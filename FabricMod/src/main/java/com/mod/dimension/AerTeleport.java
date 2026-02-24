package com.mod.dimension;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Relative;

import java.util.ArrayList;
import java.util.EnumSet;


public class AerTeleport {
    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerLevel world : server.getAllLevels()) {
                // Make a copy of the player list
                for (ServerPlayer player : new ArrayList<>(world.players())) {

                    // Only trigger in overworld
                    if (!player.level().dimension().equals(ServerLevel.OVERWORLD)) continue;

                    // Prevent spam / double teleport
                    if (player.isChangingDimension()) continue;

                    if (player.getY() < world.getMinY()) {
                        teleport(server, player);
                    }
                }
            }
        });

    }

    private static void teleport(MinecraftServer server, ServerPlayer player) {
        ServerLevel target = server.getLevel(AerDimensionGenerator.AER_DIMENSION);
        if (target == null) return;

        double x = player.getX();
        double y = target.getMaxY() + 40;
        double z = player.getZ();
        float yaw = player.getYRot();
        float pitch = player.getXRot();

        // Teleport with full control
        player.teleportTo(target, x, y, z, EnumSet.noneOf(Relative.class), yaw, pitch, true);
    }
}
