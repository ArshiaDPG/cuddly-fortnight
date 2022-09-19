package com.digitalpear.divide.common.worldgen.features;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class DivideFeature {
	public static final Feature<CountConfig> AMALGAE_BUSH = register("amalgae_bush", new AmalgaeBushFeature(CountConfig.CODEC));

	private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
		return Registry.register(Registry.FEATURE, name, feature);
	}
}
