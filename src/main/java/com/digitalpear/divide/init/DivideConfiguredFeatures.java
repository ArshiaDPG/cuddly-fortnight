package com.digitalpear.divide.init;

import com.digitalpear.divide.Divide;
import com.digitalpear.divide.common.worldgen.features.DivideFeature;
import com.digitalpear.divide.init.tags.DivideBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MushroomBlock;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Holder;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.floatprovider.ClampedNormalFloatProvider;
import net.minecraft.util.math.floatprovider.UniformFloatProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.List;


public class DivideConfiguredFeatures {
	public static final RuleTest BASE_STONE_DIVIDE = new TagMatchRuleTest(DivideBlockTags.BASE_STONE_DIVIDE);
	public static final RuleTest OBSIDIAN = new BlockMatchRuleTest(Blocks.END_STONE);
	public static final List<Block> PATCH_BLOCKS = List.of(DivideBlocks.AMALGAE_BLOCK, DivideBlocks.WETRACK);

	public static final Holder<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_GRASS = register("patch_grass",
			Feature.RANDOM_PATCH, ConfiguredFeatureUtil.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
					new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.GRASS_BLOCK)), PATCH_BLOCKS));

	public static final Holder<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_WARPED_NYLIUM = register("patch_warped_nylium",
			Feature.RANDOM_PATCH, ConfiguredFeatureUtil.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
					new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.WARPED_NYLIUM)), PATCH_BLOCKS));

	public static final Holder<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_CRIMSON_NYLIUM = register("patch_crimson_nylium",
			Feature.RANDOM_PATCH, ConfiguredFeatureUtil.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
					new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.CRIMSON_NYLIUM)), PATCH_BLOCKS));

	public static final Holder<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_END_STONE = register("patch_end_stone",
			Feature.RANDOM_PATCH, ConfiguredFeatureUtil.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
					new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.END_STONE)), PATCH_BLOCKS));

	/*
		Amalgae features
	 */
	public static final Holder<ConfiguredFeature<CountConfig, ?>> PATCH_AMALGAE_BUSH = register("patch_amalgae_bush",
			DivideFeature.AMALGAE_BUSH, new CountConfig(6));

	public static final Holder<ConfiguredFeature<SimpleBlockFeatureConfig, ?>> AMALGAE_VEGETATION = register("amalgae_vegetation",
			Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(DataPool.<BlockState>builder()
					.add(DivideBlocks.AMALGAE_BUSH.getDefaultState(), 3)
					.add(DivideBlocks.AMALGAE_MUSHROOM.getDefaultState(), 1)
					.add(Blocks.AIR.getDefaultState(), 6)
					.build())));

	public static final Holder<ConfiguredFeature<VegetationPatchFeatureConfig, ?>> AMALGAE_PATCH = register("amalgae_patch",
			Feature.VEGETATION_PATCH, new VegetationPatchFeatureConfig(DivideBlockTags.BASE_STONE_DIVIDE, BlockStateProvider.of(DivideBlocks.AMALGAE_BLOCK),
					PlacedFeatureUtil.placedInline(AMALGAE_VEGETATION), VerticalSurfaceType.FLOOR,
					ConstantIntProvider.create(1), 0.0F, 5, 0.8F, UniformIntProvider.create(4, 7), 0.3F));

	public static final Holder<ConfiguredFeature<VegetationPatchFeatureConfig, ?>> AMALGAE_PATCH_BONEMEAL = register("amalgae_patch_bonemeal",
			Feature.VEGETATION_PATCH, new VegetationPatchFeatureConfig(DivideBlockTags.BASE_STONE_DIVIDE, BlockStateProvider.of(DivideBlocks.AMALGAE_BLOCK),
					PlacedFeatureUtil.placedInline(AMALGAE_VEGETATION), VerticalSurfaceType.FLOOR,
					ConstantIntProvider.create(1), 0.0F, 5, 0.6F, UniformIntProvider.create(1, 2), 0.75F));

	public static final Holder<ConfiguredFeature<VegetationPatchFeatureConfig, ?>> AMALGAE_POOL = register("amalgae_pool",
			Feature.WATERLOGGED_VEGETATION_PATCH, new VegetationPatchFeatureConfig(DivideBlockTags.POOL_GROUND_REPLACABLES,
			BlockStateProvider.of(DivideBlocks.AMALGAE_BLOCK), PlacedFeatureUtil.placedInline(PATCH_AMALGAE_BUSH),
					VerticalSurfaceType.FLOOR, ConstantIntProvider.create(3), 0.8F, 5, 0.1F, UniformIntProvider.create(4, 7), 0.7F));

	public static final Holder<ConfiguredFeature<HugeMushroomFeatureConfig, ?>> HUGE_AMALGAE_MUSHROOM = register("huge_amalgae_mushroom",
			DivideFeature.HUGE_AMALGAE_MUSHROOM, new HugeMushroomFeatureConfig(BlockStateProvider.of(DivideBlocks.AMALGAE_MUSHROOM_BLOCK.getDefaultState()
					.with(MushroomBlock.UP, true).with(MushroomBlock.DOWN, false)),
					BlockStateProvider.of(Blocks.MUSHROOM_STEM.getDefaultState().with(MushroomBlock.UP, false).with(MushroomBlock.DOWN, false)), 3));


	/*
		Ores
	 */
	public static final Holder<ConfiguredFeature<OreFeatureConfig, ?>> ORE_WETRACK_LAPIS = register("ore_wetrack_lapis",
			Feature.SCATTERED_ORE, new OreFeatureConfig(BASE_STONE_DIVIDE, DivideBlocks.WETRACK_LAPIS_ORE.getDefaultState(), 4, 0.1F));

	public static final Holder<ConfiguredFeature<OreFeatureConfig, ?>> ORE_WETRACK_IRON = register("ore_wetrack_iron",
			Feature.ORE, new OreFeatureConfig(BASE_STONE_DIVIDE, DivideBlocks.WETRACK_IRON_ORE.getDefaultState(), 4, 0.1F));

	public static final Holder<ConfiguredFeature<OreFeatureConfig, ?>> ORE_WETRACK_IRON_SUFFOCATED = register("ore_wetrack_iron_suffocated",
			Feature.ORE, new OreFeatureConfig(BASE_STONE_DIVIDE, DivideBlocks.WETRACK_IRON_ORE.getDefaultState(), 24, 1.0F));



	/*
		Obsidian Altars features
	 */
	public static final Holder<ConfiguredFeature<OreFeatureConfig, ?>> ORE_COLD_OBSIDIAN = register("ore_cold_obsidian",
			Feature.SCATTERED_ORE, new OreFeatureConfig(OBSIDIAN, DivideBlocks.COLD_OBSIDIAN.getDefaultState(), 8));


	public static final Holder<ConfiguredFeature<BasaltColumnsFeatureConfig, ?>> OBSIDIAN_SPIKE = register("obsidian_spike",
			DivideFeature.OBSIDIAN_SPIKE, new BasaltColumnsFeatureConfig(UniformIntProvider.create(2, 3), UniformIntProvider.create(5, 10)));

	public static final Holder<ConfiguredFeature<DripstoneClusterFeatureConfig, ?>> OBSIDIAN_CLUSTER = register("obsidian_cluster",
			DivideFeature.OBSIDIAN_CLUSTER, new DripstoneClusterFeatureConfig(12, UniformIntProvider.create(3, 6), UniformIntProvider.create(2, 8), 1, 3,
					UniformIntProvider.create(2, 4), UniformFloatProvider.create(0.3F, 0.7F), ClampedNormalFloatProvider.create(0.1F, 0.3F, 0.1F, 0.9F), 0.1F, 3, 8));


	public static <FC extends FeatureConfig, F extends Feature<FC>> Holder register(String id, F feature, FC featureConfig) {
		return BuiltinRegistries.registerExact(BuiltinRegistries.CONFIGURED_FEATURE, Divide.getId(id), new ConfiguredFeature(feature, featureConfig));
	}


	public static void init(){
	}
}
