package com.digitalpear.divide.init;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;

import java.util.HashMap;
import java.util.Map;

public class DivideData {
	public static Map<Block, Block> UNWETTING_MAP = new HashMap<>();

	public static void registerUnwetting(Block input, Block result){
		UNWETTING_MAP.put(input, result);
	}


	public static void registerFlammables(){
		FlammableBlockRegistry.getDefaultInstance().add(DivideBlocks.AMALGAE_BLOCK, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(DivideBlocks.AMALGAE_BUSH, 5, 5);
	}
	public static void init(){
		registerFlammables();
	}

}
