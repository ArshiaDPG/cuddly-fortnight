package com.digitalpear.divide;

import com.digitalpear.divide.init.*;
import com.digitalpear.divide.common.worldgen.DivideDimensions;
import com.digitalpear.divide.init.generators.DivideBlockstates;
import com.digitalpear.divide.init.generators.DivideRecipes;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Divide implements ModInitializer {
	public static final String MOD_ID = "divide";
	public static final Logger LOGGER = LoggerFactory.getLogger("The Divide");

	public static String getId(String name){
		return MOD_ID + ":" + name;
	}


	@Override
	public void onInitialize(ModContainer mod) {
		DivideBlocks.init();
		DivideConfiguredFeatures.init();
		DividePlacedFeatures.init();
		DivideBiomeCreator.init();
		DivideDimensions.init();


		DivideRecipes.init();

		CustomPortalBuilder.beginPortal()
				.frameBlock(DivideBlocks.COLD_OBSIDIAN)
				.lightWithItem(Items.ENDER_EYE)
				.destDimID(new Identifier(getId("divide")))
				.tintColor(2136993)
				.registerPortal();

		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());
	}
}
