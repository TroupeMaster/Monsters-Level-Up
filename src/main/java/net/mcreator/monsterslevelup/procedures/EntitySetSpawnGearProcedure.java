package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.monsterslevelup.network.MonstersLevelUpModVariables;
import net.mcreator.monsterslevelup.configuration.MonstersLevelUpConfigConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntitySetSpawnGearProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("monsters_level_up:can_wear_armor"))) && entity.getPersistentData().getBoolean("mobCommander") == false
				&& entity.getPersistentData().getBoolean("witherHorseman") == false && entity.getPersistentData().getBoolean("juggernaut") == false) {
			if (MonstersLevelUpConfigConfiguration.ALLOWPREVIOUSGEAR.get() == true) {
				if (MonstersLevelUpModVariables.MapVariables.get(world).stage >= 3) {
					Stage3SetGearMethodProcedure.execute(world, entity);
				}
				if (MonstersLevelUpModVariables.MapVariables.get(world).stage >= 2) {
					Stage2SetGearMethodProcedure.execute(world, entity);
				}
				if (MonstersLevelUpModVariables.MapVariables.get(world).stage >= 1) {
					Stage1SetGearMethodProcedure.execute(world, entity);
				}
				if (MonstersLevelUpModVariables.MapVariables.get(world).stage >= 0) {
					Stage0SetGearMethodProcedure.execute(entity);
				}
			} else {
				if (MonstersLevelUpModVariables.MapVariables.get(world).stage >= 3) {
					Stage3SetGearMethodProcedure.execute(world, entity);
				}
				if (MonstersLevelUpModVariables.MapVariables.get(world).stage == 2) {
					Stage2SetGearMethodProcedure.execute(world, entity);
				} else if (MonstersLevelUpModVariables.MapVariables.get(world).stage == 1) {
					Stage1SetGearMethodProcedure.execute(world, entity);
				} else if (MonstersLevelUpModVariables.MapVariables.get(world).stage == 0) {
					Stage0SetGearMethodProcedure.execute(entity);
				}
			}
			if (MonstersLevelUpModVariables.MapVariables.get(world).enchant == true) {
				EntitySpawnsWithEnchantedMethodProcedure.execute(world, entity);
			}
		}
		if (entity instanceof Monster && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("monsters_level_up:cannot_receive_effects")))) {
			if (MonstersLevelUpModVariables.MapVariables.get(world).enchant == true && Math.random() < (double) MonstersLevelUpConfigConfiguration.EFFECTCHANCE.get() * MonstersLevelUpModVariables.MapVariables.get(world).netherMultiplier) {
				EntitySpawnsWithEffectMethodProcedure.execute(entity);
			}
		}
	}
}
