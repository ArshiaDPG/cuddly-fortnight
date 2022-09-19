package com.digitalpear.divide.init;

import com.digitalpear.divide.Divide;
import com.digitalpear.divide.common.worldgen.features.DivideFeature;
import com.digitalpear.divide.init.tags.DivideBlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Holder;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;


public class DivideConfiguredFeatures {
	public static final RuleTest BASE_STONE_DIVIDE = new TagMatchRuleTest(DivideBlockTags.BASE_STONE_DIVIDE);

	public static final Holder<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_GRASS = register("patch_grass",
			Feature.RANDOM_PATCH, ConfiguredFeatureUtil.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
					new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.GRASS_BLOCK)), List.of(Blocks.MUD, DivideBlocks.WETRACK)));

	public static final Holder<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_WARPED_NYLIUM = register("patch_warped_nylium",
			Feature.RANDOM_PATCH, ConfiguredFeatureUtil.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
					new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.WARPED_NYLIUM)), List.of(Blocks.MUD, DivideBlocks.WETRACK)));

	public static final Holder<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_CRIMSON_NYLIUM = register("patch_crimson_nylium",
			Feature.RANDOM_PATCH, ConfiguredFeatureUtil.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
					new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.CRIMSON_NYLIUM)), List.of(Blocks.MUD, DivideBlocks.WETRACK)));

	public static final Holder<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_END_STONE = register("patch_end_stone",
			Feature.RANDOM_PATCH, ConfiguredFeatureUtil.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
					new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.END_STONE)), List.of(Blocks.MUD, DivideBlocks.WETRACK)));

	public static final Holder<ConfiguredFeature<CountConfig, ?>> AMALGAE_BUSH = register("amalgae_bush", DivideFeature.AMALGAE_BUSH, new CountConfig(6));

	public static final Holder<ConfiguredFeature<RandomPatchFeatureConfig, ?>> AMALGAE_BUSH_BONEMEAL = ConfiguredFeatureUtil.register("amalgae_bush_bonemeal", Feature.RANDOM_PATCH,
			ConfiguredFeatureUtil.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
			new SimpleBlockFeatureConfig(BlockStateProvider.of(DivideBlocks.AMALGAE_BUSH))));


	public static final Holder<ConfiguredFeature<VegetationPatchFeatureConfig, ?>> AMALGAE_POOL = register("amalgae_pool",
			Feature.WATERLOGGED_VEGETATION_PATCH, new VegetationPatchFeatureConfig(DivideBlockTags.POOL_GROUND_REPLACABLES,
			BlockStateProvider.of(DivideBlocks.AMALGAE_BLOCK), PlacedFeatureUtil.placedInline(AMALGAE_BUSH),
					VerticalSurfaceType.FLOOR, ConstantIntProvider.create(3), 0.8F, 5, 0.1F, UniformIntProvider.create(4, 7), 0.7F));


	public static final Holder<ConfiguredFeature<OreFeatureConfig, ?>> ORE_WETRACK_LAPIS = register("ore_wetrack_lapis",
			Feature.SCATTERED_ORE, new OreFeatureConfig(BASE_STONE_DIVIDE, DivideBlocks.WETRACK_LAPIS_ORE.getDefaultState(), 4, 0.1F));

	public static final Holder<ConfiguredFeature<OreFeatureConfig, ?>> ORE_WETRACK_IRON = register("ore_wetrack_iron",
			Feature.ORE, new OreFeatureConfig(BASE_STONE_DIVIDE, DivideBlocks.WETRACK_IRON_ORE.getDefaultState(), 4, 0.1F));

	public static final Holder<ConfiguredFeature<OreFeatureConfig, ?>> ORE_WETRACK_IRON_SUFFOCATED = register("ore_wetrack_iron_suffocated",
			Feature.ORE, new OreFeatureConfig(BASE_STONE_DIVIDE, DivideBlocks.WETRACK_IRON_ORE.getDefaultState(), 24, 1.0F));


	public static <FC extends FeatureConfig, F extends Feature<FC>> Holder register(String id, F feature, FC featureConfig) {
		return BuiltinRegistries.registerExact(BuiltinRegistries.CONFIGURED_FEATURE, Divide.getId(id), new ConfiguredFeature(feature, featureConfig));
	}


	public static void init(){
	}
}
