//package com.mod.entities;
//
//import com.mod.Aer;
//import com.mod.entities.custom.FancyPig;
//import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
//import net.minecraft.core.Registry;
//import net.minecraft.core.registries.Registries;
//import net.minecraft.world.entity.EntityDimensions;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.SpawnGroup;
//import net.minecraft.resources.Identifier;
//
//public class ModEntities {
//
//    public static final EntityType<FancyPig> FANCY_PIG = Registry.register(
//            Registries.ENTITY_TYPE,
//            new Identifier(Aer.MOD_ID, "fancy_pig"),
//            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FancyPig::new)
//                    .dimensions(EntityDimensions.fixed(0.9f, 0.9f))
//                    .build()
//    );
//
//    public static void initialize() {
//        // Optional logging
//        Aer.LOGGER.info("Registered entities for " + Aer.MOD_ID);
//    }
//}


package com.mod.entities;

import com.mod.Aer;
import com.mod.entities.custom.FancyPig;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {

    // EntityType registration
    public static final ResourceKey<EntityType<?>> FANCY_PIG_KEY =
            ResourceKey.create(Registries.ENTITY_TYPE,
                    Identifier.fromNamespaceAndPath(Aer.MOD_ID, "fancy_pig"));

    public static final EntityType<FancyPig> FANCY_PIG =
            EntityType.Builder.of(FancyPig::new, MobCategory.CREATURE)
                    .sized(0.9f, 0.9f)
                    .build(FANCY_PIG_KEY);

    public static void initialize() {
//        Aer.LOGGER.info("Registering Entities for " + Aer.MOD_ID);

        Registry.register(BuiltInRegistries.ENTITY_TYPE, FANCY_PIG_KEY, FANCY_PIG);

        // Register attributes
        FabricDefaultAttributeRegistry.register(FANCY_PIG, FancyPig.createAttributes());
    }
}