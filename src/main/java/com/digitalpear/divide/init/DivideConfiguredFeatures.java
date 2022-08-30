package com.digitalpear.divide.init;

import com.digitalpear.divide.Divide;
import com.digitalpear.divide.common.worldgen.features.DivideFeature;
import com.digitalpear.divide.init.tags.DivideBlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.util.Holder;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;


public class DivideConfiguredFeatures {
	public static final Holder<ConfiguredFeature<SingleStateFeatureConfig, ?>> DIVIDE_STONE_CLUSTER = register("wetrack_cluster",
			DivideFeature.WETRACK_CLUSTER, new SingleStateFeatureConfig(DivideBlocks.WETRACK.getDefaultState()));

	public static final Holder<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_GRASS = register("patch_grass",
			Feature.RANDOM_PATCH, ConfiguredFeatureUtil.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
					new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.GRASS_BLOCK)), List.of(Blocks.MUD, DivideBlocks.WETRACK)));

	public static final Holder<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_CRIMSON_NYLIUM = register("patch_crimson_nylium",
			Feature.RANDOM_PATCH, ConfiguredFeatureUtil.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
					new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.CRIMSON_NYLIUM)), List.of(Blocks.MUD, DivideBlocks.WETRACK)));

	public static final Holder<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_NETHERRACK = register("patch_netherrack",
			Feature.RANDOM_PATCH, ConfiguredFeatureUtil.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
					new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.NETHERRACK)), List.of(Blocks.MUD, DivideBlocks.WETRACK)));

	public static final Holder<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_END_STONE = register("patch_end_stone",
			Feature.RANDOM_PATCH, ConfiguredFeatureUtil.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
					new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.END_STONE)), List.of(Blocks.MUD, DivideBlocks.WETRACK)));


	public static final Holder<ConfiguredFeature<VegetationPatchFeatureConfig, ?>> MUD_POOL = register("mud_pool",
			Feature.WATERLOGGED_VEGETATION_PATCH, new VegetationPatchFeatureConfig(DivideBlockTags.POOL_GROUND_REPLACABLES,
			BlockStateProvider.of(Blocks.MUD), PlacedFeatureUtil.placedInline(UndergroundConfiguredFeatures.UNDERWATER_MAGMA, new PlacementModifier[0]),
					VerticalSurfaceType.FLOOR, ConstantIntProvider.create(3), 0.8F, 5, 0.1F, UniformIntProvider.create(4, 7), 0.7F));


	public static <FC extends FeatureConfig, F extends Feature<FC>> Holder register(String id, F feature, FC featureConfig) {
		return BuiltinRegistries.registerExact(BuiltinRegistries.CONFIGURED_FEATURE, Divide.getId(id), new ConfiguredFeature(feature, featureConfig));
	}

	public static void init(){}
}
