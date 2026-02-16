
package net.mcreator.monsterslevelup.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monsterslevelup.entity.model.WitherSkeletonHorseModel;
import net.mcreator.monsterslevelup.entity.layer.WitherSkeletonHorseLayer;
import net.mcreator.monsterslevelup.entity.WitherSkeletonHorseEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class WitherSkeletonHorseRenderer extends GeoEntityRenderer<WitherSkeletonHorseEntity> {
	public WitherSkeletonHorseRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new WitherSkeletonHorseModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new WitherSkeletonHorseLayer(this));
	}

	@Override
	public RenderType getRenderType(WitherSkeletonHorseEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, WitherSkeletonHorseEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 1.2f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
