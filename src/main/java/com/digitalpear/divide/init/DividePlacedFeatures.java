package com.digitalpear.divide.init;

import com.digitalpear.divide.Divide;
import net.minecraft.util.Holder;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;

public class DividePlacedFeatures {
	public static final Holder<PlacedFeature> WETRACK_CLUSTER = PlacedFeatureUtil.register(Divide.getId("wetrack_cluster"), DivideConfiguredFeatures.DIVIDE_STONE_CLUSTER,
			CountPlacementModifier.create(2), PlacedFeatureUtil.createCountExtraModifier(1, 0.25F, 1),
			InSquarePlacementModifier.getInstance(), HeightRangePlacementModifier.createUniform(YOffset.fixed(8), YOffset.fixed(90)),
			BiomePlacementModifier.getInstance());


	public static final Holder<PlacedFeature>  MUD_POOL = PlacedFeatureUtil.register(Divide.getId("mud_pool"), DivideConfiguredFeatures.MUD_POOL,
			CountPlacementModifier.create(62), InSquarePlacementModifier.getInstance(),
			PlacedFeatureUtil.BOTTOM_TO_MAX_TERRAIN_HEIGHT_RANGE, EnvironmentScanPlacementModifier.create(Direction.DOWN, BlockPredicate.solid(),
			BlockPredicate.IS_AIR, 12), RandomOffsetPlacementModifier.vertical(ConstantIntProvider.create(1)),
			BiomePlacementModifier.getInstance());


	public static void init(){
	}
}
