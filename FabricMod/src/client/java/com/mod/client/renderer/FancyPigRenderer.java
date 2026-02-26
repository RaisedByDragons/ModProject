package com.mod.client.renderer;

import com.mod.entities.custom.FancyPig;

import net.minecraft.client.model.animal.pig.PigModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class FancyPigRenderer
        extends MobRenderer<FancyPig, LivingEntityRenderState, PigModel> {

    private static final Identifier TEXTURE =
            Identifier.fromNamespaceAndPath("minecraft", "textures/entity/fancy_pig/fancy_pig.png");

    public FancyPigRenderer(EntityRendererProvider.Context context) {
        super(
                context,
                new PigModel(context.bakeLayer(ModelLayers.PIG)),
                0.7f
        );
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    public Identifier getTextureLocation(LivingEntityRenderState state) {
        return TEXTURE;
    }
}