
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monsterslevelup.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.monsterslevelup.client.model.Modeljuggernaut_leggings;
import net.mcreator.monsterslevelup.client.model.Modeljuggernaut_helmet;
import net.mcreator.monsterslevelup.client.model.Modeljuggernaut_chestplate;
import net.mcreator.monsterslevelup.client.model.Modeljuggernaut_boots;
import net.mcreator.monsterslevelup.client.model.ModelendermanClone;
import net.mcreator.monsterslevelup.client.model.ModelcommanderFlag;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class MonstersLevelUpModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelcommanderFlag.LAYER_LOCATION, ModelcommanderFlag::createBodyLayer);
		event.registerLayerDefinition(ModelendermanClone.LAYER_LOCATION, ModelendermanClone::createBodyLayer);
		event.registerLayerDefinition(Modeljuggernaut_helmet.LAYER_LOCATION, Modeljuggernaut_helmet::createBodyLayer);
		event.registerLayerDefinition(Modeljuggernaut_boots.LAYER_LOCATION, Modeljuggernaut_boots::createBodyLayer);
		event.registerLayerDefinition(Modeljuggernaut_chestplate.LAYER_LOCATION, Modeljuggernaut_chestplate::createBodyLayer);
		event.registerLayerDefinition(Modeljuggernaut_leggings.LAYER_LOCATION, Modeljuggernaut_leggings::createBodyLayer);
	}
}
