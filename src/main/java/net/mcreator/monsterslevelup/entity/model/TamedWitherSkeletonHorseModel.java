package net.mcreator.monsterslevelup.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.monsterslevelup.entity.TamedWitherSkeletonHorseEntity;

public class TamedWitherSkeletonHorseModel extends GeoModel<TamedWitherSkeletonHorseEntity> {
	@Override
	public ResourceLocation getAnimationResource(TamedWitherSkeletonHorseEntity entity) {
		return new ResourceLocation("monsters_level_up", "animations/witherhorse.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TamedWitherSkeletonHorseEntity entity) {
		return new ResourceLocation("monsters_level_up", "geo/witherhorse.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TamedWitherSkeletonHorseEntity entity) {
		return new ResourceLocation("monsters_level_up", "textures/entities/" + entity.getTexture() + ".png");
	}

}
