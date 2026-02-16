
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monsterslevelup.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.monsterslevelup.client.renderer.ZombieDolphinRenderer;
import net.mcreator.monsterslevelup.client.renderer.WitherSkeletonHorseRenderer;
import net.mcreator.monsterslevelup.client.renderer.TamedWitherSkeletonHorseRenderer;
import net.mcreator.monsterslevelup.client.renderer.SpiderMotherRenderer;
import net.mcreator.monsterslevelup.client.renderer.LightningRodCreeperRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MonstersLevelUpModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(MonstersLevelUpModEntities.ZOMBIE_DOLPHIN.get(), ZombieDolphinRenderer::new);
		event.registerEntityRenderer(MonstersLevelUpModEntities.LIGHTNING_ROD_CREEPER.get(), LightningRodCreeperRenderer::new);
		event.registerEntityRenderer(MonstersLevelUpModEntities.SPIDER_MOTHER.get(), SpiderMotherRenderer::new);
		event.registerEntityRenderer(MonstersLevelUpModEntities.WITHER_SKELETON_HORSE.get(), WitherSkeletonHorseRenderer::new);
		event.registerEntityRenderer(MonstersLevelUpModEntities.TAMED_WITHER_SKELETON_HORSE.get(), TamedWitherSkeletonHorseRenderer::new);
	}
}
