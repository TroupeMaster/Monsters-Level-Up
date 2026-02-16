package net.mcreator.monsterslevelup.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monsterslevelup.entity.SpiderMotherEntity;

public class SpiderMotherModel extends GeoModel<SpiderMotherEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpiderMotherEntity entity) {
		return new ResourceLocation("monsters_level_up", "animations/spidermother.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpiderMotherEntity entity) {
		return new ResourceLocation("monsters_level_up", "geo/spidermother.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpiderMotherEntity entity) {
		return new ResourceLocation("monsters_level_up", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(SpiderMotherEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("Head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
