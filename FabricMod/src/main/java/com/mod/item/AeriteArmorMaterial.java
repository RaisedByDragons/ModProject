package com.mod.item;


import com.mod.Aer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;



public class AeriteArmorMaterial {

    // Aerite
    public static final int AERITE_BASE_DURABILITY = 35;
    public static final ResourceKey<EquipmentAsset> AERITE_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Aer.MOD_ID, "aerite"));
    public static final TagKey<Item> REPAIRS_AERITE_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(Aer.MOD_ID, "repairs_aerite_armor"));


    public static final ArmorMaterial AERITE_ARMOR_MATERIAL = new ArmorMaterial(
            AERITE_BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE,8,
                    ArmorType.LEGGINGS,6,
                    ArmorType.BOOTS,3
            ),
            15,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            2.5F,
            .05F,
            REPAIRS_AERITE_ARMOR,
            AERITE_ARMOR_MATERIAL_KEY
    );
}
