package com.mod.client.renderer;

import com.mod.Aer;
import com.mod.client.model.FancyPigModel;
import com.mod.entities.custom.FancyPig;

import net.minecraft.client.model.animal.pig.PigModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class FancyPigRenderer extends MobRenderer<FancyPig, LivingEntityRenderState, FancyPigModel<LivingEntityRenderState>> {
//    TODO: Currently uses PigModel, but should eventually use FancyPigModel
//    public class FancyPigRenderer extends MobRenderer<FancyPig, LivingEntityRenderState, FancyPigModel> {

    private static final Identifier TEXTURE =
            Identifier.fromNamespaceAndPath(Aer.MOD_ID, "entities/fancy_pig/fancy_pig.png");

//    public FancyPigRenderer(EntityRendererProvider.Context context) {
//        super(
//                context,
//                new PigModel(context.bakeLayer(ModelLayers.PIG)),
//                0.7f
//        );
//    }

    public FancyPigRenderer(EntityRendererProvider.Context context) {
        super(context, new FancyPigModel(context.bakeLayer(net.minecraft.client.model.geom.ModelLayers.PIG)), 0.7f);

//        TODO - eventually the below model should be used
//        super(context, new FancyPigModel(context.bakeLayer(FancyPigModel.LAYER)), 0.7f);
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    public Identifier getTextureLocation(LivingEntityRenderState livingEntityRenderState) {
        return TEXTURE;
    }
}