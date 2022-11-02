package com.digitalpear.divide.common.worldgen.features;

import com.digitalpear.divide.Divide;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.feature.BasaltColumnsFeatureConfig;
import net.minecraft.world.gen.feature.DripstoneClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class DivideFeature {
	public static final Feature<CountConfig> AMALGAE_BUSH = register("amalgae_bush", new AmalgaeBushFeature(CountConfig.CODEC));
	public static final Feature<BasaltColumnsFeatureConfig> OBSIDIAN_SPIKE = register("obsidian_spike", new ObsidianSpikesFeature(BasaltColumnsFeatureConfig.CODEC));
	public static final Feature<DripstoneClusterFeatureConfig> OBSIDIAN_CLUSTER = register("obsidian_cluster", new ObsidianClusterFeature(DripstoneClusterFeatureConfig.CODEC));

	private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
		return Registry.register(Registry.FEATURE, Divide.getId(name), feature);
	}
}
