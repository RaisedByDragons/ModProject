package com.mod;


import com.mod.block.ModBlocks;
import com.mod.item.ModItems;
import net.fabricmc.api.ModInitializer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Mod implements ModInitializer {
	public static final String MOD_ID = "mod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.initialize();
		ModBlocks.initialize();

		Mod.LOGGER.info("Mod initialized");
	}

}