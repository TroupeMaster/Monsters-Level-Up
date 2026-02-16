package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.monsterslevelup.network.MonstersLevelUpModVariables;
import net.mcreator.monsterslevelup.configuration.MonstersLevelUpConfigConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntitySpawnsMiscProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("monsters_level_up:archer_skeleton"))) && !entity.isPassenger() && (entity.level().dimension()) == Level.OVERWORLD
				&& Math.random() < (double) MonstersLevelUpConfigConfiguration.SKELETONCOMMANDERCHANCE.get() * MonstersLevelUpModVariables.MapVariables.get(world).netherMultiplier
				&& MonstersLevelUpModVariables.MapVariables.get(world).stage >= (double) MonstersLevelUpConfigConfiguration.SKELETONCOMMANDERSTAGE.get() && MonstersLevelUpModVariables.MapVariables.get(world).stage > -1) {
			SkeletonCommanderSpawnsMethodProcedure.execute(world, x, y, z, entity);
		}
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("monsters_level_up:land_zombies"))) && !entity.isPassenger() && (entity.level().dimension()) == Level.OVERWORLD
				&& Math.random() < (double) MonstersLevelUpConfigConfiguration.ZOMBIEJUGGERNAUTCHANCE.get() * MonstersLevelUpModVariables.MapVariables.get(world).netherMultiplier
				&& MonstersLevelUpModVariables.MapVariables.get(world).stage >= (double) MonstersLevelUpConfigConfiguration.ZOMBIEJUGGERNAUTSTAGE.get() && MonstersLevelUpModVariables.MapVariables.get(world).stage > -1) {
			ZombieJuggernautSpawnsMethodProcedure.execute(entity);
		}
		if ((entity instanceof Creeper || entity instanceof Skeleton || entity instanceof Stray) && !entity.isPassenger() && (entity.level().dimension()) == Level.OVERWORLD && entity.getPersistentData().getBoolean("mobCommander") == false
				&& MonstersLevelUpConfigConfiguration.MOBRIDESPIDERS.get() == true && Math.random() < (double) MonstersLevelUpConfigConfiguration.MOBRIDESPIDERSCHANCE.get() * MonstersLevelUpModVariables.MapVariables.get(world).netherMultiplier
				&& MonstersLevelUpModVariables.MapVariables.get(world).stage >= (double) MonstersLevelUpConfigConfiguration.MOBRIDESPIDERSSTAGE.get()) {
			CreeperOrSkeletonSpawnsMountedMethodProcedure.execute(world, entity);
		}
		if (entity instanceof Drowned && !entity.isPassenger() && Math.random() < 0.08 * MonstersLevelUpModVariables.MapVariables.get(world).netherMultiplier && MonstersLevelUpModVariables.MapVariables.get(world).stage >= 2) {
			DrownedSpawnsMountedMethodProcedure.execute(world, entity);
		}
	}
}
