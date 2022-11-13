package com.digitalpear.divide;


import com.digitalpear.divide.init.DivideBlocks;
import net.minecraft.client.render.RenderLayer;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

public class DivideClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {
		BlockRenderLayerMap.put(RenderLayer.getCutout(), DivideBlocks.AMALGAE_BUSH);
		BlockRenderLayerMap.put(RenderLayer.getCutout(), DivideBlocks.ENDER_CLEFT);
		BlockRenderLayerMap.put(RenderLayer.getCutout(), DivideBlocks.AMALGAE_MUSHROOM);
		BlockRenderLayerMap.put(RenderLayer.getCutout(), DivideBlocks.POTTED_AMALGAE_MUSHROOM);
	}
}
