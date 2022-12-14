package com.digitalpear.divide.common.blocks;

import com.digitalpear.divide.init.DivideBlocks;
import com.digitalpear.divide.init.DivideData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FreezerBlock extends Block {
	public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
	public static final BooleanProperty POWERED = Properties.POWERED;



	public FreezerBlock(Settings settings) {
		super(settings);
		this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(POWERED, false));
	}

	public static void freeze(World world, BlockPos pos){
		if (world.getBlockState(pos.up()).isOf(Blocks.CRYING_OBSIDIAN)){
			world.setBlockState(pos.up(), DivideBlocks.COLD_OBSIDIAN.getDefaultState(), 2);
		}
		else if (world.getBlockState(pos.up()).getFluidState().isIn(FluidTags.LAVA)){
			if (world.getBlockState(pos.up()).getFluidState().isSource()){

				world.setBlockState(pos.up(), Blocks.OBSIDIAN.getDefaultState(), 2);
			}
			else{
				world.setBlockState(pos.up(), Blocks.COBBLED_DEEPSLATE.getDefaultState(), 2);
			}
		}
		else if (world.getBlockState(pos.up()).getFluidState().isIn(FluidTags.WATER)){
			if (world.getBlockState(pos.up()).getFluidState().isSource()){

				world.setBlockState(pos.up(), Blocks.ICE.getDefaultState(), 2);
			}
			else{
				world.setBlockState(pos.up(), Blocks.POWDER_SNOW.getDefaultState(), 2);
			}
		}
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
		if (world.isReceivingRedstonePower(pos) || world.getDimension().ultraWarm()){
			world.setBlockState(pos, state.with(POWERED, true), 2);
		}
		super.onPlaced(world, pos, state, placer, itemStack);
	}


	public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
		if (!world.isClient) {
			boolean bl = world.isReceivingRedstonePower(pos) || world.getDimension().ultraWarm();
			if (bl != state.get(POWERED)) {
				world.setBlockState(pos, state.with(POWERED, bl), 2);
			}
			if (!state.get(POWERED)){
				freeze(world, pos);
			}
		}
	}

	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING, POWERED);
	}


	public void randomDisplayTick(BlockState state, World world, BlockPos pos, RandomGenerator random) {
		for (int i = random.nextInt(10); i < random.range(3, 7); i++) {
			Direction direction = Direction.random(random);
			if (direction != Direction.UP && !state.get(POWERED)) {
				BlockPos blockPos = pos.offset(direction);
				BlockState blockState = world.getBlockState(blockPos);
				if (!state.isOpaque() || !blockState.isSideSolidFullSquare(world, blockPos, direction.getOpposite())) {
					double d = pos.getX();
					double e = pos.getY();
					double f = pos.getZ();
					if (direction == Direction.DOWN) {
						e -= 0.05D;
						d += random.nextDouble();
						f += random.nextDouble();
					} else {
						e += random.nextDouble() * 0.8D;
						if (direction.getAxis() == Direction.Axis.X) {
							f += random.nextDouble();
							if (direction == Direction.EAST) {
								++d;
							} else {
								d += 0.05D;
							}
						} else {
							d += random.nextDouble();
							if (direction == Direction.SOUTH) {
								++f;
							} else {
								f += 0.05D;
							}
						}
					}

					world.addParticle(ParticleTypes.SNOWFLAKE, d, e, f, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	@Nullable
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
	}
}
