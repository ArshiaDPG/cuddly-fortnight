package com.digitalpear.divide.common.blocks;

import com.digitalpear.divide.init.DivideBlocks;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class AmalgaeRootsBlock extends AbstractLichenBlock implements Fertilizable, Waterloggable {
	private static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
	private final LichenSpreadBehavior spreadBehavior = new LichenSpreadBehavior(this);

	public AmalgaeRootsBlock(Settings settings) {
		super(settings);
		this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false));
	}

	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(WATERLOGGED);
	}

	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		if (state.get(WATERLOGGED)) {
			world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
		}

		return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
	}

	public boolean canReplace(BlockState state, ItemPlacementContext context) {
		return !context.getStack().isOf(DivideBlocks.AMALGAE_ROOTS.asItem()) || super.canReplace(state, context);
	}

	public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
		return Direction.stream().anyMatch((direction) -> this.spreadBehavior.canSpreadInAnyDirection(state, world, pos, direction.getOpposite()));
	}

	public boolean canGrow(World world, RandomGenerator random, BlockPos pos, BlockState state) {
		return true;
	}

	public void grow(ServerWorld world, RandomGenerator random, BlockPos pos, BlockState state) {
		this.spreadBehavior.spreadFromRandomFacingToRandomDirection(state, world, pos, random);
	}

	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
	}

	public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	public LichenSpreadBehavior getLichenSpreadBehavior() {
		return this.spreadBehavior;
	}
}
