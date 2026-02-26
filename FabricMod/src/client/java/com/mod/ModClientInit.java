package com.mod;

//import com.mod.client.model.FancyPigModel;
import com.mod.client.renderer.FancyPigRenderer;
import com.mod.entities.ModEntities;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ModClientInit implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		// Register entity renderer
		EntityRendererRegistry.register(ModEntities.FANCY_PIG, context ->
				new FancyPigRenderer(context)
		);
	}
}