package com.mod.item;

import com.mod.Aer;
import com.mod.block.ModBlocks;

import com.mod.entities.ModEntities;
import com.mod.entities.custom.FancyPig;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.pig.Pig;
import net.minecraft.world.item.*;


import java.util.function.Function;

public class ModItems {


    // Creative mode tab
    public static final ResourceKey<CreativeModeTab> AER_CREATIVE_TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Aer.MOD_ID, "aer"));
    public static final CreativeModeTab AER = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.AERITE))
            .title(Component.translatable("itemGroup.mod"))
            .displayItems((params, output) -> {
                // Items
                output.accept(ModItems.AERITE);


                // Tools
                output.accept(ModItems.AERITE_PICKAXE);

                // Blocks (may separate into two tabs in the future
                output.accept(ModBlocks.AERITE_BLOCK);
                output.accept(ModBlocks.AERITE_ORE);
                output.accept(ModBlocks.BREAKABLE_BEDROCK);
                output.accept(ModItems.FANCY_PIG_SPAWN_EGG);
            })
            .build();




    // Items
    public static final Item AERITE = register("aerite", Item::new, new Item.Properties());



    // Tools
    public static final TagKey<Item> REPAIRS_AERITE_TOOL= TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(Aer.MOD_ID, "repairs_aerite_tool"));
    public static final ToolMaterial AERITE_MATERIAL = new ToolMaterial(
        BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
                1900,
                8.5F,
                3.5F,
                22,
           REPAIRS_AERITE_TOOL
    );



    public static final Item AERITE_PICKAXE = register(
            "aerite_pickaxe",
            AeritePickaxe::new,
            new Item.Properties().pickaxe(AERITE_MATERIAL, 1f, -2.0f)
    );


    public static final Item FANCY_PIG_SPAWN_EGG =
            register("fancy_pig_spawn_egg",
                    SpawnEggItem::new,
                    new Item.Properties()
            );



    public static <GenericItem extends Item> Item register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Aer.MOD_ID, name));

        // Create the item instance.
        GenericItem item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
    public static void initialize() {
        Aer.LOGGER.info("Registering items for " + Aer.MOD_ID);

        // Creative mode tab
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, AER_CREATIVE_TAB_KEY, AER);
    }
}
