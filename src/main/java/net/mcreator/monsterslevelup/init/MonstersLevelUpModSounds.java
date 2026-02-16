
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monsterslevelup.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monsterslevelup.MonstersLevelUpMod;

public class MonstersLevelUpModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MonstersLevelUpMod.MODID);
	public static final RegistryObject<SoundEvent> ENTITY_ZOMBIE_DOLPHIN_AMBIENT = REGISTRY.register("entity.zombie_dolphin.ambient",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation("monsters_level_up", "entity.zombie_dolphin.ambient")));
	public static final RegistryObject<SoundEvent> ENTITY_ZOMBIE_DOLPHIN_ATTACK = REGISTRY.register("entity.zombie_dolphin.attack", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("monsters_level_up", "entity.zombie_dolphin.attack")));
	public static final RegistryObject<SoundEvent> ENTITY_ZOMBIE_DOLPHIN_DEATH = REGISTRY.register("entity.zombie_dolphin.death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("monsters_level_up", "entity.zombie_dolphin.death")));
	public static final RegistryObject<SoundEvent> ENTITY_ZOMBIE_DOLPHIN_HURT = REGISTRY.register("entity.zombie_dolphin.hurt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("monsters_level_up", "entity.zombie_dolphin.hurt")));
	public static final RegistryObject<SoundEvent> GENERIC_ACID_VENOM_AMBIENT = REGISTRY.register("generic.acid_venom.ambient", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("monsters_level_up", "generic.acid_venom.ambient")));
	public static final RegistryObject<SoundEvent> ENTITY_WITHER_SKELETON_HORSE_AMBIENT = REGISTRY.register("entity.wither_skeleton_horse.ambient",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation("monsters_level_up", "entity.wither_skeleton_horse.ambient")));
	public static final RegistryObject<SoundEvent> ENTITY_WITHER_SKELETON_HORSE_HURT = REGISTRY.register("entity.wither_skeleton_horse.hurt",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation("monsters_level_up", "entity.wither_skeleton_horse.hurt")));
	public static final RegistryObject<SoundEvent> ENTITY_WITHER_SKELETON_HORSE_DEATH = REGISTRY.register("entity.wither_skeleton_horse.death",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation("monsters_level_up", "entity.wither_skeleton_horse.death")));
}
