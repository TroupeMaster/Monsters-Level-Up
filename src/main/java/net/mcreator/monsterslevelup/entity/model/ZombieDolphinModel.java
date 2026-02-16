package net.mcreator.monsterslevelup.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.monsterslevelup.entity.ZombieDolphinEntity;

public class ZombieDolphinModel extends GeoModel<ZombieDolphinEntity> {
	@Override
	public ResourceLocation getAnimationResource(ZombieDolphinEntity entity) {
		return new ResourceLocation("monsters_level_up", "animations/zombiedolphin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ZombieDolphinEntity entity) {
		return new ResourceLocation("monsters_level_up", "geo/zombiedolphin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ZombieDolphinEntity entity) {
		return new ResourceLocation("monsters_level_up", "textures/entities/" + entity.getTexture() + ".png");
	}

}
