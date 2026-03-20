package com.mod.client.model;// Made with Blockbench 5.0.7
//// Exported for Minecraft version 1.17 or later with Mojang mappings
//// Paste this class into your mod and generate all required imports

import com.mod.Aer;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import org.jspecify.annotations.NonNull;

import java.util.Objects;

public class FancyPigModel<T extends LivingEntityRenderState> extends QuadrupedModel<LivingEntityRenderState> {

	public static final ModelLayerLocation LAYER =
			new ModelLayerLocation(Objects.requireNonNull(Identifier.tryParse(Aer.MOD_ID + "/textures/entity/fancy_pig/fancy_pig.png")), "main");

	private final ModelPart head;
	private final ModelPart rightHindLeg;
	private final ModelPart leftHindLeg;
	private final ModelPart rightFrontLeg;
	private final ModelPart leftFrontLeg;

	public FancyPigModel(ModelPart modelPart) {
		super(modelPart);
		this.head = modelPart.getChild("head");
		this.rightHindLeg = modelPart.getChild("right_hind_leg");
		this.leftHindLeg = modelPart.getChild("left_hind_leg");
		this.rightFrontLeg = modelPart.getChild("right_front_leg");
		this.leftFrontLeg = modelPart.getChild("left_front_leg");
	}

	public static LayerDefinition getLayerDefinition() {
		MeshDefinition mesh = createBodyMesh(6, false, false, CubeDeformation.NONE);
		return LayerDefinition.create(mesh, 68, 48);
	}

	public static MeshDefinition createBodyMesh(int i, boolean bl, boolean bl2, @NonNull CubeDeformation cubeDeformation) {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();
		partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(36, 14).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(16, 38).addBox(-2.0F, 0.0F, -9.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, -6.0F));
		partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 14).addBox(-5.0F, -10.0F, -7.0F, 10.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.0F, 2.0F, 1.5708F, 0.0F, 0.0F));
		createLegs(partDefinition, bl, bl2, i, cubeDeformation);
		createTusks(partDefinition.getChild("head"), bl, cubeDeformation);
		createTail(partDefinition.getChild("body"), cubeDeformation);
		createHat(partDefinition.getChild("head"), cubeDeformation);
		return meshDefinition;
	}

	private static void createTusks(PartDefinition partDefinition, boolean bl, @NonNull CubeDeformation cubeDeformation) {
		partDefinition.addOrReplaceChild("tusk1", CubeListBuilder.create().texOffs(32, 42).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(26, 38).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 3.0F, -7.0F, 0.1745F, 0.3054F, 0.0F));

		partDefinition.addOrReplaceChild("tusk_2", CubeListBuilder.create().texOffs(34, 46).addBox(0.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 42).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 3.0F, -7.0F, 0.1745F, -0.3054F, 0.0F));

	}

	private static void createTail(PartDefinition partDefinition, @NonNull CubeDeformation cubeDeformation) {
		partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(16, 42).addBox(-2.0F, -2.0F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(16, 46).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 46).addBox(-1.0F, -2.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 44).addBox(1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(30, 46).addBox(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -5.0F, -0.4606F, -0.3152F, -0.1964F));

	}

	private static void createHat(PartDefinition partDefinition, @NonNull CubeDeformation cubeDeformation) {
		partDefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(36, 30).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -2.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -4.0F, -0.1309F, 0.0F, 0.0F));
	}


	static void createLegs(PartDefinition partDefinition, boolean bl, boolean bl2, int i, CubeDeformation cubeDeformation) {
		CubeListBuilder cubeListBuilder = CubeListBuilder.create().mirror(bl2).texOffs(0, 38).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, cubeDeformation);
		CubeListBuilder cubeListBuilder2 = CubeListBuilder.create().mirror(bl).texOffs(0, 38).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, cubeDeformation);
		partDefinition.addOrReplaceChild("right_hind_leg", cubeListBuilder, PartPose.offset(-3.0F, 18.0F, 7.0F));
		partDefinition.addOrReplaceChild("left_hind_leg", cubeListBuilder2, PartPose.offset(3.0F, 18.0F, 7.0F));
		partDefinition.addOrReplaceChild("right_front_leg", cubeListBuilder, PartPose.offset(-3.0F, 18.0F, -5.0F));
		partDefinition.addOrReplaceChild("left_front_leg", cubeListBuilder2, PartPose.offset(3.0F, 18.0F, -5.0F));
	}

	public void setupAnim(LivingEntityRenderState livingEntityRenderState) {
		super.setupAnim(livingEntityRenderState);
		this.head.xRot = livingEntityRenderState.xRot * ((float)Math.PI / 180F);
		this.head.yRot = livingEntityRenderState.yRot * ((float)Math.PI / 180F);
		float f = livingEntityRenderState.walkAnimationPos;
		float g = livingEntityRenderState.walkAnimationSpeed;
		this.rightHindLeg.xRot = Mth.cos((double)(f * 0.6662F)) * 1.4F * g;
		this.leftHindLeg.xRot = Mth.cos((double)(f * 0.6662F + (float)Math.PI)) * 1.4F * g;
		this.rightFrontLeg.xRot = Mth.cos((double)(f * 0.6662F + (float)Math.PI)) * 1.4F * g;
		this.leftFrontLeg.xRot = Mth.cos((double)(f * 0.6662F)) * 1.4F * g;
	}
}