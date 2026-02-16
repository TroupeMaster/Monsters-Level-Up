package net.mcreator.monsterslevelup.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelcommanderFlag<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("monsters_level_up", "modelcommander_flag"), "main");
	public final ModelPart Waist;
	public final ModelPart Body;
	public final ModelPart flag;
	public final ModelPart flag0;
	public final ModelPart leftArm;
	public final ModelPart rightArm;

	public ModelcommanderFlag(ModelPart root) {
		this.Waist = root.getChild("Waist");
		this.Body = this.Waist.getChild("Body");
		this.flag = this.Body.getChild("flag");
		this.flag0 = this.flag.getChild("flag0");
		this.leftArm = this.Waist.getChild("leftArm");
		this.rightArm = this.Waist.getChild("rightArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Waist = partdefinition.addOrReplaceChild("Waist", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));
		PartDefinition Body = Waist.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition flag = Body.addOrReplaceChild("flag", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -33.0F, -1.0F, 2.0F, 34.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 2.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition flag0 = flag.addOrReplaceChild("flag0", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -16.0F, 0.0F, 0.0F, 31.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, 1.0F));
		PartDefinition leftArm = Waist.addOrReplaceChild("leftArm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition rightArm = Waist.addOrReplaceChild("rightArm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Waist.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
