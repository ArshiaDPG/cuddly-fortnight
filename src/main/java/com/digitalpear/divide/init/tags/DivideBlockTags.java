package com.digitalpear.divide.init.tags;

import com.digitalpear.divide.Divide;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DivideBlockTags {
	public static final TagKey<Block> POOL_GROUND_REPLACABLES = register("pool_ground_replacables");


	private static TagKey<Block> register(String id) {
		return TagKey.of(Registry.BLOCK_KEY, new Identifier(Divide.MOD_ID, id));
	}
}
