package com.digitalpear.divide.init.tags;

import com.digitalpear.divide.Divide;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DivideItemTags {
	public static final TagKey<Item> BUCKET_DISPENSABLES = register("bucket_dispensables");


	private static TagKey<Item> register(String id) {
		return TagKey.of(Registry.ITEM_KEY, new Identifier(Divide.MOD_ID, id));
	}
}
