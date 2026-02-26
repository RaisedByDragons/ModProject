package com.mod;

import com.mod.entities.ModEntities;
import com.mod.client.renderer.FancyPigRenderer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ModClientInit implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ModEntities.FANCY_PIG, FancyPigRenderer::new);
	}
}