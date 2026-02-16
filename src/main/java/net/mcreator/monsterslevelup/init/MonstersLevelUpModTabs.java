
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monsterslevelup.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.monsterslevelup.MonstersLevelUpMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MonstersLevelUpModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MonstersLevelUpMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(MonstersLevelUpModItems.COMMANDER_CUTLASS.get());
			tabData.accept(MonstersLevelUpModItems.GILDED_COMMANDER_SHIELD.get());
			tabData.accept(MonstersLevelUpModItems.GUILDED_COMMANDER_HELMET.get());
			tabData.accept(MonstersLevelUpModItems.GUILDED_COMMANDER_CHESTPLATE.get());
			tabData.accept(MonstersLevelUpModItems.GUILDED_COMMANDER_LEGGINGS.get());
			tabData.accept(MonstersLevelUpModItems.GUILDED_COMMANDER_BOOTS.get());
			tabData.accept(MonstersLevelUpModItems.COMMANDER_FLAG_CHESTPLATE.get());
			tabData.accept(MonstersLevelUpModItems.BREACHING_HAMMER.get());
			tabData.accept(MonstersLevelUpModItems.HEAVY_SHIELD.get());
			tabData.accept(MonstersLevelUpModItems.JUGGERNAUT_HELMET.get());
			tabData.accept(MonstersLevelUpModItems.JUGGERNAUT_CHESTPLATE.get());
			tabData.accept(MonstersLevelUpModItems.JUGGERNAUT_LEGGINGS.get());
			tabData.accept(MonstersLevelUpModItems.JUGGERNAUT_BOOTS.get());
			tabData.accept(MonstersLevelUpModItems.WITHER_HELMET.get());
			tabData.accept(MonstersLevelUpModItems.WITHER_CHESTPLATE.get());
			tabData.accept(MonstersLevelUpModItems.WITHER_LEGGINGS.get());
			tabData.accept(MonstersLevelUpModItems.WITHER_BOOTS.get());
			tabData.accept(MonstersLevelUpModItems.GREATSWORD_OF_THE_DAMNEDS.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(MonstersLevelUpModItems.ZOMBIE_DOLPHIN_SPAWN_EGG.get());
			tabData.accept(MonstersLevelUpModItems.LIGHTNING_ROD_CREEPER_SPAWN_EGG.get());
			tabData.accept(MonstersLevelUpModItems.SPIDER_MOTHER_SPAWN_EGG.get());
			tabData.accept(MonstersLevelUpModItems.WITHER_SKELETON_HORSE_SPAWN_EGG.get());
			tabData.accept(MonstersLevelUpModItems.SKELETON_COMMANDER_SPAWN_EGG.get());
			tabData.accept(MonstersLevelUpModItems.ZOMBIE_JUGGERNAUT_SPAWN_EGG.get());
			tabData.accept(MonstersLevelUpModItems.SKELETON_TRAP_HORSE_SPAWN_EGG.get());
			tabData.accept(MonstersLevelUpModItems.WITHER_SKELETON_TRAP_HORSE_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(MonstersLevelUpModItems.GILDED_INGOT.get());
			tabData.accept(MonstersLevelUpModItems.HEAVY_PLATING.get());
			tabData.accept(MonstersLevelUpModItems.WITHER_BONE.get());
		}
	}
}
