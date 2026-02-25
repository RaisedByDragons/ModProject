package com.mod;


import com.mod.block.ModBlocks;
import com.mod.world.dimension.AerDimension;
import com.mod.world.dimension.AerTeleport;
import com.mod.item.ModItems;
import net.fabricmc.api.ModInitializer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Aer implements ModInitializer {
	public static final String MOD_ID = "aer";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.initialize();
		ModBlocks.initialize();
		AerDimension.initialize();
		AerTeleport.register();

		Aer.LOGGER.info("Aer initialized");
	}

}