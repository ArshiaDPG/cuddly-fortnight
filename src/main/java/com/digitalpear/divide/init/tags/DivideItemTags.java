package com.digitalpear.divide.init.tags;

import com.digitalpear.divide.Divide;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DivideItemTags {

	private static TagKey<Item> register(String id) {
		return TagKey.of(Registry.ITEM_KEY, new Identifier(Divide.MOD_ID, id));
	}
	public static final TagKey<Item> FUNGUS_DROPS = register("fungus_drops");
}
