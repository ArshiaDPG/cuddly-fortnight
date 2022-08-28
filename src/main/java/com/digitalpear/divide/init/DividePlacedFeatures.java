package com.digitalpear.divide.init;

import com.digitalpear.divide.Divide;
import net.minecraft.util.Holder;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;

public class DividePlacedFeatures {
	public static final Holder<PlacedFeature> DIVIDE_STONE_CLUSTER = PlacedFeatureUtil.register(Divide.getId("divide_stone_cluster"), DivideConfiguredFeatures.DIVIDE_STONE_CLUSTER,
			CountPlacementModifier.create(2), PlacedFeatureUtil.createCountExtraModifier(1, 0.25F, 1),
			InSquarePlacementModifier.getInstance(), HeightRangePlacementModifier.createUniform(YOffset.fixed(8), YOffset.fixed(90)),
			BiomePlacementModifier.getInstance());


	public static void init(){
	}
}
