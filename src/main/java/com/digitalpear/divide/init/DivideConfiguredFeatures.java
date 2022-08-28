package com.digitalpear.divide.init;

import com.digitalpear.divide.Divide;
import com.digitalpear.divide.common.worldgen.features.DivideFeature;
import net.minecraft.util.Holder;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil;


public class DivideConfiguredFeatures {
	public static final Holder<ConfiguredFeature<SingleStateFeatureConfig, ?>> DIVIDE_STONE_CLUSTER = ConfiguredFeatureUtil.register(Divide.getId("divide_stone_cluster"), DivideFeature.DIVIDE_STONE_CLUSTER, new SingleStateFeatureConfig(DivideBlocks.WETRACK.getDefaultState()));

	public static void init(){}

}
