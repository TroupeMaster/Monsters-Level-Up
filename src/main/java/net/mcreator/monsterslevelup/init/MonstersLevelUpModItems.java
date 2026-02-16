
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monsterslevelup.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.monsterslevelup.item.ZombieJuggernautSpawnEggItem;
import net.mcreator.monsterslevelup.item.WitherSkeletonTrapHorseSpawnEggItem;
import net.mcreator.monsterslevelup.item.WitherItem;
import net.mcreator.monsterslevelup.item.WitherBoneItem;
import net.mcreator.monsterslevelup.item.SkeletonTrapHorseSpawnEggItem;
import net.mcreator.monsterslevelup.item.SkeletonCommanderSpawnEggItem;
import net.mcreator.monsterslevelup.item.JuggernautItem;
import net.mcreator.monsterslevelup.item.HeavyShieldItem;
import net.mcreator.monsterslevelup.item.HeavyPlatingItem;
import net.mcreator.monsterslevelup.item.GuildedCommanderItem;
import net.mcreator.monsterslevelup.item.GreatswordOfTheDamnedsItem;
import net.mcreator.monsterslevelup.item.GildedIngotItem;
import net.mcreator.monsterslevelup.item.GildedCommanderShieldItem;
import net.mcreator.monsterslevelup.item.CommanderFlagItem;
import net.mcreator.monsterslevelup.item.CommanderCutlassItem;
import net.mcreator.monsterslevelup.item.BreachingHammerItem;
import net.mcreator.monsterslevelup.MonstersLevelUpMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MonstersLevelUpModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MonstersLevelUpMod.MODID);
	public static final RegistryObject<Item> ZOMBIE_DOLPHIN_SPAWN_EGG = REGISTRY.register("zombie_dolphin_spawn_egg", () -> new ForgeSpawnEggItem(MonstersLevelUpModEntities.ZOMBIE_DOLPHIN, -12693974, -10100515, new Item.Properties()));
	public static final RegistryObject<Item> LIGHTNING_ROD_CREEPER_SPAWN_EGG = REGISTRY.register("lightning_rod_creeper_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersLevelUpModEntities.LIGHTNING_ROD_CREEPER, -13867478, -3706538, new Item.Properties()));
	public static final RegistryObject<Item> SPIDER_MOTHER_SPAWN_EGG = REGISTRY.register("spider_mother_spawn_egg", () -> new ForgeSpawnEggItem(MonstersLevelUpModEntities.SPIDER_MOTHER, -13489370, -5763570, new Item.Properties()));
	public static final RegistryObject<Item> COMMANDER_CUTLASS = REGISTRY.register("commander_cutlass", () -> new CommanderCutlassItem());
	public static final RegistryObject<Item> GUILDED_COMMANDER_HELMET = REGISTRY.register("guilded_commander_helmet", () -> new GuildedCommanderItem.Helmet());
	public static final RegistryObject<Item> GUILDED_COMMANDER_CHESTPLATE = REGISTRY.register("guilded_commander_chestplate", () -> new GuildedCommanderItem.Chestplate());
	public static final RegistryObject<Item> GUILDED_COMMANDER_LEGGINGS = REGISTRY.register("guilded_commander_leggings", () -> new GuildedCommanderItem.Leggings());
	public static final RegistryObject<Item> GUILDED_COMMANDER_BOOTS = REGISTRY.register("guilded_commander_boots", () -> new GuildedCommanderItem.Boots());
	public static final RegistryObject<Item> COMMANDER_FLAG_CHESTPLATE = REGISTRY.register("commander_flag_chestplate", () -> new CommanderFlagItem.Chestplate());
	public static final RegistryObject<Item> GILDED_INGOT = REGISTRY.register("gilded_ingot", () -> new GildedIngotItem());
	public static final RegistryObject<Item> GILDED_COMMANDER_SHIELD = REGISTRY.register("gilded_commander_shield", () -> new GildedCommanderShieldItem());
	public static final RegistryObject<Item> WITHER_SKELETON_HORSE_SPAWN_EGG = REGISTRY.register("wither_skeleton_horse_spawn_egg",
			() -> new ForgeSpawnEggItem(MonstersLevelUpModEntities.WITHER_SKELETON_HORSE, -15395563, -16717057, new Item.Properties()));
	public static final RegistryObject<Item> JUGGERNAUT_HELMET = REGISTRY.register("juggernaut_helmet", () -> new JuggernautItem.Helmet());
	public static final RegistryObject<Item> JUGGERNAUT_CHESTPLATE = REGISTRY.register("juggernaut_chestplate", () -> new JuggernautItem.Chestplate());
	public static final RegistryObject<Item> JUGGERNAUT_LEGGINGS = REGISTRY.register("juggernaut_leggings", () -> new JuggernautItem.Leggings());
	public static final RegistryObject<Item> JUGGERNAUT_BOOTS = REGISTRY.register("juggernaut_boots", () -> new JuggernautItem.Boots());
	public static final RegistryObject<Item> HEAVY_PLATING = REGISTRY.register("heavy_plating", () -> new HeavyPlatingItem());
	public static final RegistryObject<Item> BREACHING_HAMMER = REGISTRY.register("breaching_hammer", () -> new BreachingHammerItem());
	public static final RegistryObject<Item> HEAVY_SHIELD = REGISTRY.register("heavy_shield", () -> new HeavyShieldItem());
	public static final RegistryObject<Item> SKELETON_COMMANDER_SPAWN_EGG = REGISTRY.register("skeleton_commander_spawn_egg", () -> new SkeletonCommanderSpawnEggItem());
	public static final RegistryObject<Item> ZOMBIE_JUGGERNAUT_SPAWN_EGG = REGISTRY.register("zombie_juggernaut_spawn_egg", () -> new ZombieJuggernautSpawnEggItem());
	public static final RegistryObject<Item> SKELETON_TRAP_HORSE_SPAWN_EGG = REGISTRY.register("skeleton_trap_horse_spawn_egg", () -> new SkeletonTrapHorseSpawnEggItem());
	public static final RegistryObject<Item> WITHER_SKELETON_TRAP_HORSE_SPAWN_EGG = REGISTRY.register("wither_skeleton_trap_horse_spawn_egg", () -> new WitherSkeletonTrapHorseSpawnEggItem());
	public static final RegistryObject<Item> WITHER_BONE = REGISTRY.register("wither_bone", () -> new WitherBoneItem());
	public static final RegistryObject<Item> WITHER_HELMET = REGISTRY.register("wither_helmet", () -> new WitherItem.Helmet());
	public static final RegistryObject<Item> WITHER_CHESTPLATE = REGISTRY.register("wither_chestplate", () -> new WitherItem.Chestplate());
	public static final RegistryObject<Item> WITHER_LEGGINGS = REGISTRY.register("wither_leggings", () -> new WitherItem.Leggings());
	public static final RegistryObject<Item> WITHER_BOOTS = REGISTRY.register("wither_boots", () -> new WitherItem.Boots());
	public static final RegistryObject<Item> GREATSWORD_OF_THE_DAMNEDS = REGISTRY.register("greatsword_of_the_damneds", () -> new GreatswordOfTheDamnedsItem());

	// Start of user code block custom items
	// End of user code block custom items
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(GILDED_COMMANDER_SHIELD.get(), new ResourceLocation("blocking"), ItemProperties.getProperty(Items.SHIELD, new ResourceLocation("blocking")));
			ItemProperties.register(HEAVY_SHIELD.get(), new ResourceLocation("blocking"), ItemProperties.getProperty(Items.SHIELD, new ResourceLocation("blocking")));
		});
	}
}
