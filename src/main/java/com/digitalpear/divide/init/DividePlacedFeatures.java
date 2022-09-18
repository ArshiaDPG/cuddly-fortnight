package com.digitalpear.divide.init;

import com.digitalpear.divide.Divide;
import net.minecraft.util.Holder;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;

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


	public static final Holder<PlacedFeature>  MUD_POOL = PlacedFeatureUtil.register(Divide.getId("mud_pool"), DivideConfiguredFeatures.MUD_POOL,
			CountPlacementModifier.create(62), InSquarePlacementModifier.getInstance(),
			PlacedFeatureUtil.BOTTOM_TO_MAX_TERRAIN_HEIGHT_RANGE, EnvironmentScanPlacementModifier.create(Direction.DOWN, BlockPredicate.solid(),
			BlockPredicate.IS_AIR, 12), RandomOffsetPlacementModifier.vertical(ConstantIntProvider.create(1)),
			BiomePlacementModifier.getInstance());


	public static void init(){

	}
}
