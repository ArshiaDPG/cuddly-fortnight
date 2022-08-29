package com.digitalpear.divide.init;

import com.digitalpear.divide.Divide;
import com.digitalpear.divide.common.worldgen.features.DivideFeature;
import com.digitalpear.divide.init.tags.DivideBlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.util.Holder;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;


public class DivideConfiguredFeatures {
	public static final Holder<ConfiguredFeature<SingleStateFeatureConfig, ?>> DIVIDE_STONE_CLUSTER = ConfiguredFeatureUtil.register(Divide.getId("wetrack_cluster"),
			DivideFeature.WETRACK_CLUSTER, new SingleStateFeatureConfig(DivideBlocks.WETRACK.getDefaultState()));


	public static final Holder<ConfiguredFeature<VegetationPatchFeatureConfig, ?>> MUD_POOL = ConfiguredFeatureUtil.register(Divide.getId("mud_pool"),
			Feature.WATERLOGGED_VEGETATION_PATCH, new VegetationPatchFeatureConfig(DivideBlockTags.POOL_GROUND_REPLACABLES,
			BlockStateProvider.of(Blocks.MUD), PlacedFeatureUtil.placedInline(MiscConfiguredFeatures.SPRING_WATER, new PlacementModifier[0]),
					VerticalSurfaceType.FLOOR, ConstantIntProvider.create(3), 0.8F, 5, 0.1F, UniformIntProvider.create(4, 7), 0.7F));


	public static void init(){}

}
