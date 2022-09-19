package com.digitalpear.divide.common.worldgen.features;

import com.digitalpear.divide.init.DivideBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class AmalgaeBushFeature extends Feature<CountConfig> {
	public AmalgaeBushFeature(Codec<CountConfig> codec) {
		super(codec);
	}

	public boolean place(FeatureContext<CountConfig> context) {
		int i = 0;
		RandomGenerator randomGenerator = context.getRandom();
		StructureWorldAccess structureWorldAccess = context.getWorld();
		BlockPos blockPos = context.getOrigin();
		int j = context.getConfig().getCount().get(randomGenerator);
		for(int k = 0; k < j; ++k) {
			int l = randomGenerator.nextInt(8) - randomGenerator.nextInt(8);
			int m = randomGenerator.nextInt(8) - randomGenerator.nextInt(8);
			int n = structureWorldAccess.getTopY(Heightmap.Type.OCEAN_FLOOR, blockPos.getX() + l, blockPos.getZ() + m);
			BlockPos blockPos2 = new BlockPos(blockPos.getX() + l, n, blockPos.getZ() + m);
			BlockState blockState = DivideBlocks.AMALGAE_BUSH.getDefaultState();

			if (blockState.canPlaceAt(structureWorldAccess, blockPos2)) {
				if (structureWorldAccess.getBlockState(blockPos2).isOf(Blocks.WATER)) {
					structureWorldAccess.setBlockState(blockPos2, blockState.with(Properties.WATERLOGGED, true), 2);
					++i;
				}
				if (structureWorldAccess.getBlockState(blockPos2).isOf(Blocks.AIR)) {
					structureWorldAccess.setBlockState(blockPos2, blockState, 2);
					++i;
				}
			}
		}
		return i > 0;
	}
}
