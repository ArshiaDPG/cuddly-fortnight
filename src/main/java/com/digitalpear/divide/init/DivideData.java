package com.digitalpear.divide.init;

import com.digitalpear.divide.common.blocks.WetrackBlock;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public class DivideData {
	public static Map<Block, Block> UNWETTING_MAP = new HashMap<>();
	public static void registerUnwetting(Block input, Block result){
		UNWETTING_MAP.put(input, result);
	}
}
