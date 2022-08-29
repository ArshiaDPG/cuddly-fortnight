package com.digitalpear.divide.common.worldgen.features;

import com.mojang.serialization.Codec;
import net.minecraft.block.MudBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Iterator;

public class WetrackClusterFeature extends Feature<SingleStateFeatureConfig> {

	public WetrackClusterFeature(Codec<SingleStateFeatureConfig> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeatureContext<SingleStateFeatureConfig> context) {
		BlockPos blockPos = context.getOrigin();
		StructureWorldAccess structureWorldAccess = context.getWorld();
		RandomGenerator randomGenerator = context.getRandom();


		int loops = randomGenerator.range(3, 12);
		int size = randomGenerator.range(3, 12);
		int radiusOffset = randomGenerator.nextInt(4);
		int heightOffset = randomGenerator.nextInt(1);


		for(int i = 0; i < loops; ++i) {
			int j = randomGenerator.range(size, size+5);
			int k = randomGenerator.range(size, size+5);
			int l = randomGenerator.range(size, size+5);
			float f = (float)(j + k + l) * 0.333F + 0.5F;
			Iterator var11 = BlockPos.iterate(blockPos.add(-j + randomGenerator.range(-heightOffset, heightOffset),
							-k + randomGenerator.range(-radiusOffset, radiusOffset),
					-l + randomGenerator.range(-heightOffset, heightOffset)),
					blockPos.add(j + randomGenerator.range(-heightOffset, heightOffset), k + randomGenerator.range(-radiusOffset, radiusOffset),
							l + randomGenerator.range(-heightOffset, heightOffset))).iterator();


			while(var11.hasNext()) {
				BlockPos blockPos2 = (BlockPos)var11.next();
				if (blockPos2.getSquaredDistance(blockPos) <= (double)(f * f)) {
					structureWorldAccess.setBlockState(blockPos2, context.getConfig().state, 4);
				}
			}

			blockPos = blockPos.add(-1 + randomGenerator.nextInt(2), -randomGenerator.nextInt(2), -1 + randomGenerator.nextInt(2));
		}
		return true;
	}
}
