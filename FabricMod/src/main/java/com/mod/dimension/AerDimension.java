package com.mod.dimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;


public class AerDimension {
    public static final ResourceKey<Level> AER_DIMENSION =
            ResourceKey.create(Registries.DIMENSION,
                    Identifier.fromNamespaceAndPath("mod", "aer_dimension")
            );

    public static DimensionType AER_DIMENSION_TYPE;

    public static void initialize() {}
}
