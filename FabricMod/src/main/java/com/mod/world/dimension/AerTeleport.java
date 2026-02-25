package com.mod.world.dimension;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import net.minecraft.world.entity.Relative;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


public class AerTeleport {
    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {

            // Apply delayed invulnerability
            for (ServerPlayer player : pendingInvulnerability) {
                player.fallDistance = 0;
                player.addEffect(new MobEffectInstance(
                        MobEffects.RESISTANCE,
                        100,
                        4,
                        false,
                        false,
                        false
                ));
            }
            pendingInvulnerability.clear();

            for (ServerLevel world : server.getAllLevels()) {
                // Make a copy of the player list
                for (ServerPlayer player : new ArrayList<>(world.players())) {

                    // Only trigger in overworld
                    if (!player.level().dimension().equals(ServerLevel.OVERWORLD)) continue;

                    // Prevent spam / double teleport
                    if (player.isChangingDimension()) continue;

                    if (player.getY() < world.getMinY() - 10) {
                        teleport(server, player);
                    }
                }
            }
        });

    }

    private static final List<ServerPlayer> pendingInvulnerability = new ArrayList<>();

    private static void teleport(MinecraftServer server, ServerPlayer player) {
        ServerLevel target = server.getLevel(AerDimension.AER_DIMENSION);
        if (target == null) return;

        double x = player.getX();
        double y = target.getMaxY() - 170;
        double z = player.getZ();
        float yaw = player.getYRot();
        float pitch = player.getXRot();

        // Teleport with full control
        player.teleportTo(target, x, y, z, EnumSet.noneOf(Relative.class), yaw, pitch, true);

        // Temporary invulnerability just in case player is bad at the game
        pendingInvulnerability.add(player);
    }
}
