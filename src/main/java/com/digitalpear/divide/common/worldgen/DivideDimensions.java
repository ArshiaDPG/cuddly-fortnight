package com.digitalpear.divide.common.worldgen;

import com.digitalpear.divide.Divide;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class DivideDimensions {

	public static final RegistryKey<World> DIVIDE = RegistryKey.of(Registry.WORLD_KEY, new Identifier(Divide.MOD_ID, "divide"));
	public static final RegistryKey<DimensionType> DIVIDE_TYPE = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, DIVIDE.getValue());




	public static void init(){

	}
}
