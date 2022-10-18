package com.digitalpear.divide.init;

import com.digitalpear.divide.Divide;
import com.digitalpear.divide.init.tags.DivideBiomeTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.EndPlacedFeatures;
import net.minecraft.world.gen.feature.NetherPlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import org.jetbrains.annotations.Nullable;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;
import org.quiltmc.qsl.worldgen.biome.api.BiomeSelectionContext;
import org.quiltmc.qsl.worldgen.biome.api.BiomeSelectors;

import java.util.function.Predicate;

public class DivideBiomeCreator {

	protected static final int DEFAULT_WATER_COLOR = 4159204;
	protected static final int DEFAULT_WATER_FOG_COLOR = 329011;
	private static final int DEFAULT_FOG_COLOR = 12638463;
	private static final int DEFAULT_SKY_COLOR = 12638463;
	@Nullable
	private static final MusicSound DEFAULT_MUSIC = null;

	private static Biome createBiome(Biome.Precipitation precipitation, float temperature, float downfall, SpawnSettings.Builder builder, net.minecraft.world.biome.GenerationSettings.Builder builder2, @Nullable MusicSound musicSound) {
		return createBiome(precipitation, temperature, downfall, DEFAULT_WATER_COLOR, DEFAULT_WATER_FOG_COLOR, builder, builder2, musicSound);
	}

	private static Biome createBiome(Biome.Precipitation precipitation, float temperature, float downfall, int waterColor, int waterFogColor, SpawnSettings.Builder builder, net.minecraft.world.biome.GenerationSettings.Builder builder2, @Nullable MusicSound musicSound) {
		return (new net.minecraft.world.biome.Biome.Builder()).precipitation(precipitation).temperature(temperature).downfall(downfall).effects((new net.minecraft.world.biome.BiomeEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(DEFAULT_FOG_COLOR).skyColor(DEFAULT_SKY_COLOR).moodSound(BiomeMoodSound.CAVE).music(musicSound).build()).spawnSettings(builder.build()).generationSettings(builder2.build()).build();
	}

	private static void addDivideBasicFeatures(net.minecraft.world.biome.GenerationSettings.Builder generationSettings) {
		generationSettings.feature(GenerationStep.Feature.RAW_GENERATION, DividePlacedFeatures.WETRACK_SPIKE);
		generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, DividePlacedFeatures.AMALGAE_SWAMPLANDS_VEGETATION);
		generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, DividePlacedFeatures.AMALGAE_POOL);
		generationSettings.feature(GenerationStep.Feature.UNDERGROUND_ORES, DividePlacedFeatures.ORE_WETRACK_IRON);
		generationSettings.feature(GenerationStep.Feature.UNDERGROUND_ORES, DividePlacedFeatures.ORE_WETRACK_LAPIS);
		generationSettings.feature(GenerationStep.Feature.UNDERGROUND_ORES, DividePlacedFeatures.ORE_WETRACK_IRON_SUFFOCATED);
	}
	public static void addDivideBasicMobs(SpawnSettings.Builder spawnBuilder){
		spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMITE, 8, 2, 4));
		spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 16, 1, 2));
	}

	public static Biome createAlgaeSwamplands() {
		net.minecraft.world.biome.GenerationSettings.Builder builder = new net.minecraft.world.biome.GenerationSettings.Builder();
		addDivideBasicFeatures(builder);
		builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, DividePlacedFeatures.OBSIDIAN_CLUSTER);
		builder.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, DividePlacedFeatures.PATCH_GRASS);
		builder.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, DividePlacedFeatures.PATCH_WARPED_NYLIUM);
		builder.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, DividePlacedFeatures.PATCH_CRIMSON_NYLIUM);
		builder.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, DividePlacedFeatures.PATCH_END_STONE);

		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.FLOWER_DEFAULT);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.WARPED_FOREST_VEGETATION);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.CRIMSON_FOREST_VEGETATION);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, EndPlacedFeatures.CHORUS_PLANT);

		SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
		addDivideBasicMobs(spawnBuilder);


		return createBiome(Biome.Precipitation.NONE, 0.5F, 0.5F, spawnBuilder, builder, DEFAULT_MUSIC);
	}


	private static Biome register(RegistryKey<Biome> key, Biome biome)
	{
		return Registry.register(BuiltinRegistries.BIOME, key, biome);
	}
	public static RegistryKey<Biome> createBiomeKey(String id){
		return RegistryKey.of(Registry.BIOME_KEY, new Identifier(Divide.MOD_ID, id));
	}

	public static final RegistryKey<Biome> AMALGAE_SWAMPLANDS = createBiomeKey("amalgae_swamplands");


	public static Predicate<BiomeSelectionContext> foundInTheDivide() {
		return context -> context.isIn(DivideBiomeTags.IS_DIVIDE);
	}
	public static void init(){
		register(AMALGAE_SWAMPLANDS, createAlgaeSwamplands());
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, DividePlacedFeatures.ORE_COLD_OBSIDIAN.getKey().get());
	}
}
