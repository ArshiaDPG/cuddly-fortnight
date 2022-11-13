package com.digitalpear.divide.init;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class DivideData {

	public static void registerFlammables(){
		FlammableBlockRegistry.getDefaultInstance().add(DivideBlocks.AMALGAE_BLOCK, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(DivideBlocks.AMALGAE_BUSH, 5, 5);
	}
	public static void init(){
		registerFlammables();
	}
}
