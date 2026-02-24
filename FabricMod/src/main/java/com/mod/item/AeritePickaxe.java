package com.mod.item;

import com.mod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;


public class AeritePickaxe extends Item {

    public AeritePickaxe(Item.Properties settings) {
        super(settings);
    }

    /**
     * Please just let me mine bedrock for the love of god
     */
    @Override
    public @NotNull InteractionResult use(Level world, @NotNull Player player, @NotNull InteractionHand hand) {

        // Basically just right-click on a bedrock block and you'll be able to mine it
        if (!world.isClientSide()) {
            Vec3 eyePos = player.getEyePosition(1.0F);
            Vec3 look = player.getViewVector(1.0F);
            Vec3 reachVec = eyePos.add(look.scale(5));
            BlockHitResult hitResult = world.clip(new ClipContext(
                    eyePos,
                    reachVec,
                    ClipContext.Block.COLLIDER,
                    ClipContext.Fluid.NONE,
                    player
            ));

            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos pos = hitResult.getBlockPos();
                if (world.getBlockState(pos).is(Blocks.BEDROCK)) {
                    world.setBlockAndUpdate(pos, ModBlocks.BREAKABLE_BEDROCK.defaultBlockState());
                }
            }
        }
        return InteractionResult.SUCCESS;
    }
}
