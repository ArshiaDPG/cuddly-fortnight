package com.digitalpear.divide.common.worldgen.features;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.HugeMushroomFeature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;

public class HugeAmalgaeMushroomFeature extends HugeMushroomFeature {
	public HugeAmalgaeMushroomFeature(Codec<HugeMushroomFeatureConfig> codec) {
		super(codec);
	}

	@Override
	protected int getCapSize(int i, int j, int capSize, int y) {
		return y <= 3 ? 0 : capSize;
	}

	@Override
	protected void generateCap(WorldAccess world, RandomGenerator random, BlockPos start, int y, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config) {
		int i = config.foliageRadius;
		lmao(i, world, random, start, y, mutable, config);
		lmao(i-1, world, random, start, y+1, mutable, config);
	}


	public void lmao(int radius, WorldAccess world, RandomGenerator random, BlockPos start, int y, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config){
		for(int j = -radius; j <= radius; ++j) {
			for(int k = -radius; k <= radius; ++k) {
				boolean bl = j == -radius;
				boolean bl2 = j == radius;
				boolean bl3 = k == -radius;
				boolean bl4 = k == radius;
				boolean bl5 = bl || bl2;
				boolean bl6 = bl3 || bl4;
				if (!bl5 || !bl6) {
					mutable.set(start, j, y, k);
					if (!world.getBlockState(mutable).isOpaqueFullCube(world, mutable)) {
						boolean bl7 = bl || bl6 && j == 1 - radius;
						boolean bl8 = bl2 || bl6 && j == radius - 1;
						boolean bl9 = bl3 || bl5 && k == 1 - radius;
						boolean bl10 = bl4 || bl5 && k == radius - 1;
						BlockState blockState = config.capProvider.getBlockState(random, start);
						if (blockState.contains(MushroomBlock.WEST) && blockState.contains(MushroomBlock.EAST) && blockState.contains(MushroomBlock.NORTH) && blockState.contains(MushroomBlock.SOUTH)) {
							blockState = blockState.with(MushroomBlock.WEST, bl7).with(MushroomBlock.EAST, bl8).with(MushroomBlock.NORTH, bl9).with(MushroomBlock.SOUTH, bl10);
						}

						this.setBlockState(world, mutable, blockState);
					}
				}
			}
		}
	}
}
