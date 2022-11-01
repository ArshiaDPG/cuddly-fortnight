package com.digitalpear.divide.init.tags;

import com.digitalpear.divide.Divide;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class DivideBiomeTags {
	public static final TagKey<Biome> IS_DIVIDE = register("is_divide");


	private static TagKey<Biome> register(String id) {
		return TagKey.of(Registry.BIOME_KEY, new Identifier(Divide.MOD_ID, id));
	}
}
