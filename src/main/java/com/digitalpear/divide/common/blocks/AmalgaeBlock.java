package com.digitalpear.divide.common.blocks;

import com.digitalpear.divide.init.DivideConfiguredFeatures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class AmalgaeBlock extends Block implements Fertilizable {
	public AmalgaeBlock(Settings settings) {
		super(settings);
	}

	public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
		return world.getBlockState(pos.up()).isAir();
	}

	public boolean canGrow(World world, RandomGenerator random, BlockPos pos, BlockState state) {
		return true;
	}

	public void grow(ServerWorld world, RandomGenerator random, BlockPos pos, BlockState state) {
		DivideConfiguredFeatures.AMALGAE_PATCH_BONEMEAL.value().generate(world, world.getChunkManager().getChunkGenerator(), random, pos.up());
	}
}
