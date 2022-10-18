package com.digitalpear.divide.common.blocks;

import com.digitalpear.divide.common.worldgen.DivideDimensions;
import com.digitalpear.divide.init.DivideBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class DividePortalBlock extends Block {
	protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 1.0D, 0.0D, 16.0D, 15.0D, 16.0D);

	public DividePortalBlock(Settings settings) {
		super(settings);
	}

	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return SHAPE;
	}

	@Override
	public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
		if(!world.getBlockState(pos.down()).isOf(DivideBlocks.ENDER_CLEFT) && !world.getBlockState(pos.down()).isOf(DivideBlocks.DIVIDE_PORTAL)){
			world.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		super.neighborUpdate(state, world, pos, block, fromPos, notify);
	}

	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		if (world instanceof ServerWorld && !entity.hasVehicle() && !entity.hasPassengers() && entity.canUsePortals() &&
				VoxelShapes.matchesAnywhere(VoxelShapes.cuboid(entity.getBoundingBox().offset(-pos.getX(), -pos.getY(), -pos.getZ())),
						state.getOutlineShape(world, pos), BooleanBiFunction.AND)) {
			RegistryKey<World> registryKey = world.getRegistryKey() == DivideDimensions.DIVIDE_KEY ? World.OVERWORLD : DivideDimensions.DIVIDE_KEY;
			ServerWorld serverWorld = ((ServerWorld)world).getServer().getWorld(registryKey);
			if (serverWorld == null) {
				return;
			}

			entity.moveToWorld(serverWorld);
		}

	}

	public void randomDisplayTick(BlockState state, World world, BlockPos pos, RandomGenerator random) {
		double d = (double)pos.getX() + random.nextDouble();
		double e = (double)pos.getY() + 0.8D;
		double f = (double)pos.getZ() + random.nextDouble();
		world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0D, 0.0D, 0.0D);
	}

	public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
		return ItemStack.EMPTY;
	}

	public boolean canBucketPlace(BlockState state, Fluid fluid) {
		return false;
	}
}
