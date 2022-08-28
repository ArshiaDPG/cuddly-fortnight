package com.digitalpear.divide.common.worldgen.features;

import com.digitalpear.divide.Divide;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;

public class DivideFeature {
	public static final Feature<SingleStateFeatureConfig> DIVIDE_STONE_CLUSTER = register("divide_stone_cluster",
			new DivideStoneCluster(SingleStateFeatureConfig.CODEC));


	private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
		return (F) Registry.register(Registry.FEATURE, Divide.getId(name), feature);
	}
}
