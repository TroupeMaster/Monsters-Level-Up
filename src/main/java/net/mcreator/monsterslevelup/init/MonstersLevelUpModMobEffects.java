
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monsterslevelup.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.monsterslevelup.potion.FireVulnerabilityMobEffect;
import net.mcreator.monsterslevelup.potion.BreachedMobEffect;
import net.mcreator.monsterslevelup.potion.AcidVenomMobEffect;
import net.mcreator.monsterslevelup.MonstersLevelUpMod;

public class MonstersLevelUpModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MonstersLevelUpMod.MODID);
	public static final RegistryObject<MobEffect> ACID_VENOM = REGISTRY.register("acid_venom", () -> new AcidVenomMobEffect());
	public static final RegistryObject<MobEffect> BREACHED = REGISTRY.register("breached", () -> new BreachedMobEffect());
	public static final RegistryObject<MobEffect> FIRE_VULNERABILITY = REGISTRY.register("fire_vulnerability", () -> new FireVulnerabilityMobEffect());
}
