package com.digitalpear.divide.init;

import com.digitalpear.divide.Divide;
import com.digitalpear.divide.init.DividePlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.OverworldBiomeCreator;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import org.jetbrains.annotations.Nullable;

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

	public static Biome createShatteredLands() {
		net.minecraft.world.biome.GenerationSettings.Builder builder = new net.minecraft.world.biome.GenerationSettings.Builder();
		builder.feature(GenerationStep.Feature.RAW_GENERATION, DividePlacedFeatures.WETRACK_CLUSTER);
		builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, DividePlacedFeatures.MUD_POOL);

		SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
		spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMITE, 8, 2, 4));

		return createBiome(Biome.Precipitation.NONE, 0.5F, 0.5F, spawnBuilder, builder, DEFAULT_MUSIC);
	}



	private static Biome register(RegistryKey<Biome> key, Biome biome)
	{
		return Registry.register(BuiltinRegistries.BIOME, key, biome);
	}
	public static RegistryKey<Biome> createBiomeKey(String id){
		return RegistryKey.of(Registry.BIOME_KEY, new Identifier(Divide.MOD_ID, id));
	}



	public static final RegistryKey<Biome> SHATTERED_LANDS = createBiomeKey("shattered_lands");


	public static void init(){
		register(SHATTERED_LANDS, createShatteredLands());
	}
}
