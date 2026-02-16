package net.mcreator.monsterslevelup.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.monsterslevelup.entity.WitherSkeletonHorseEntity;

public class WitherSkeletonHorseModel extends GeoModel<WitherSkeletonHorseEntity> {
	@Override
	public ResourceLocation getAnimationResource(WitherSkeletonHorseEntity entity) {
		return new ResourceLocation("monsters_level_up", "animations/witherhorse.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WitherSkeletonHorseEntity entity) {
		return new ResourceLocation("monsters_level_up", "geo/witherhorse.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WitherSkeletonHorseEntity entity) {
		return new ResourceLocation("monsters_level_up", "textures/entities/" + entity.getTexture() + ".png");
	}

}
