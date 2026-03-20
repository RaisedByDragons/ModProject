package com.mod.client.renderer;

import com.mod.Aer;
import com.mod.client.model.FancyPigModel;
import com.mod.entities.custom.FancyPig;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class FancyPigRenderer extends MobRenderer<FancyPig, LivingEntityRenderState, FancyPigModel<LivingEntityRenderState>> {
//    public class FancyPigRenderer extends MobRenderer<FancyPig, LivingEntityRenderState, FancyPigModel> {

    private static final Identifier TEXTURE =
            Identifier.fromNamespaceAndPath(Aer.MOD_ID, "assets/aer/textures/entity/fancy_pig/fancy_pig.png");

    public FancyPigRenderer(EntityRendererProvider.Context context) {
        super(context, new FancyPigModel<>(context.bakeLayer(FancyPigModel.LAYER)), 0.7f);
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    public @NonNull Identifier getTextureLocation(LivingEntityRenderState livingEntityRenderState) {
        return TEXTURE;
    }
}