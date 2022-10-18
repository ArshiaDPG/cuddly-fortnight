package com.digitalpear.divide.init;

import com.digitalpear.divide.Divide;
import net.minecraft.util.Holder;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacementModifier;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;

import java.util.List;

public class DividePlacedFeatures {

	public static int middenChance = 12;

	public static final Holder<PlacedFeature> PATCH_GRASS = PlacedFeatureUtil.register(Divide.getId("patch_grass"),
			DivideConfiguredFeatures.PATCH_GRASS, RarityFilterPlacementModifier.create(middenChance),
			InSquarePlacementModifier.getInstance(), PlacedFeatureUtil.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.getInstance());

	public static final Holder<PlacedFeature> PATCH_WARPED_NYLIUM = PlacedFeatureUtil.register(Divide.getId("patch_warped_nylium"),
			DivideConfiguredFeatures.PATCH_WARPED_NYLIUM, RarityFilterPlacementModifier.create(middenChance),
			InSquarePlacementModifier.getInstance(), PlacedFeatureUtil.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.getInstance());

	public static final Holder<PlacedFeature> PATCH_CRIMSON_NYLIUM = PlacedFeatureUtil.register(Divide.getId("patch_crimson_nylium"),
			DivideConfiguredFeatures.PATCH_CRIMSON_NYLIUM, RarityFilterPlacementModifier.create(middenChance),
			InSquarePlacementModifier.getInstance(), PlacedFeatureUtil.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.getInstance());

	public static final Holder<PlacedFeature> PATCH_END_STONE = PlacedFeatureUtil.register(Divide.getId("patch_end_stone"),
			DivideConfiguredFeatures.PATCH_END_STONE, RarityFilterPlacementModifier.create(middenChance),
			InSquarePlacementModifier.getInstance(), PlacedFeatureUtil.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.getInstance());


	public static final Holder<PlacedFeature> AMALGAE_POOL = PlacedFeatureUtil.register(Divide.getId("mud_pool"), DivideConfiguredFeatures.AMALGAE_POOL,
			CountPlacementModifier.create(20), InSquarePlacementModifier.getInstance(),
			PlacedFeatureUtil.BOTTOM_TO_MAX_TERRAIN_HEIGHT_RANGE, EnvironmentScanPlacementModifier.create(Direction.DOWN, BlockPredicate.solid(),
			BlockPredicate.IS_AIR, 12), RandomOffsetPlacementModifier.vertical(ConstantIntProvider.create(1)),
			BiomePlacementModifier.getInstance());


	public static final Holder<PlacedFeature> ORE_WETRACK_LAPIS = PlacedFeatureUtil.register(Divide.getId("ore_wetrack_lapis"), DivideConfiguredFeatures.ORE_WETRACK_LAPIS,
			commonOrePlacementModifiers(40, HeightRangePlacementModifier.createUniform(YOffset.getBottom(), YOffset.getTop())));

	public static final Holder<PlacedFeature> ORE_WETRACK_IRON = PlacedFeatureUtil.register(Divide.getId("ore_wetrack_iron"), DivideConfiguredFeatures.ORE_WETRACK_IRON,
			commonOrePlacementModifiers(16, HeightRangePlacementModifier.createUniform(YOffset.getBottom(), YOffset.getTop())));

	public static final Holder<PlacedFeature> ORE_WETRACK_IRON_SUFFOCATED = PlacedFeatureUtil.register(Divide.getId("ore_wetrack_iron_suffocated"), DivideConfiguredFeatures.ORE_WETRACK_IRON_SUFFOCATED,
			commonOrePlacementModifiers(20, HeightRangePlacementModifier.createUniform(YOffset.getBottom(), YOffset.getTop())));


	public static final Holder<PlacedFeature> ORE_COLD_OBSIDIAN = PlacedFeatureUtil.register(Divide.getId("ore_cold_obsidian"), DivideConfiguredFeatures.ORE_COLD_OBSIDIAN,
			List.of(CountPlacementModifier.create(4), HeightRangePlacementModifier.createUniform(YOffset.getBottom(), YOffset.fixed(32))));


	public static final Holder<PlacedFeature> AMALGAE_SWAMPLANDS_VEGETATION = PlacedFeatureUtil.register(Divide.getId("amalgae_swamplands_vegetation"),
			DivideConfiguredFeatures.AMALGAE_PATCH, CountPlacementModifier.create(40), InSquarePlacementModifier.getInstance(),
			PlacedFeatureUtil.BOTTOM_TO_MAX_TERRAIN_HEIGHT_RANGE, EnvironmentScanPlacementModifier.create(Direction.DOWN, BlockPredicate.solid(),
					BlockPredicate.IS_AIR, 12), RandomOffsetPlacementModifier.vertical(ConstantIntProvider.create(1)), BiomePlacementModifier.getInstance());

	public static final Holder<PlacedFeature> WETRACK_SPIKE = PlacedFeatureUtil.register(Divide.getId("wetrack_spike"),
			DivideConfiguredFeatures.WETRACK_SPIKE, CountOnEveryLayerPlacementModifier.create(2), BiomePlacementModifier.getInstance());

	public static final Holder<PlacedFeature> OBSIDIAN_CLUSTER = PlacedFeatureUtil.register(Divide.getId("obsidian_cluster"),
			DivideConfiguredFeatures.OBSIDIAN_CLUSTER, CountPlacementModifier.create(UniformIntProvider.create(3, 9)), InSquarePlacementModifier.getInstance(),
			PlacedFeatureUtil.BOTTOM_TO_MAX_TERRAIN_HEIGHT_RANGE, BiomePlacementModifier.getInstance());



	private static List<PlacementModifier> commonOrePlacementModifiers(int count, PlacementModifier modifier) {
		return orePlacementModifiers(CountPlacementModifier.create(count), modifier);
	}
	private static List<PlacementModifier> orePlacementModifiers(PlacementModifier firstModifier, PlacementModifier secondModifier) {
		return List.of(firstModifier, InSquarePlacementModifier.getInstance(), secondModifier, BiomePlacementModifier.getInstance());
	}

	public static void init(){


	}
}
