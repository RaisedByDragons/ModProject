package com.mod;


import com.mod.block.ModBlocks;
import com.mod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
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



		// Register bedrock breaking with aerite pickaxe
		PlayerBlockBreakEvents.BEFORE.register((player, world, hand, pos, direction) -> {
			ItemStack stack = player.o

			if (stack.is(ModItems.AERITE_PICKAXE) && world.getBlockState(pos).is(Blocks.BEDROCK)) {
				world.destroyBlock(pos, true); // break bedrock and drop items
				return InteractionResult.SUCCESS;
			}
			return InteractionResult.PASS;
		});


		Mod.LOGGER.info("Mod initialized");
	}


}