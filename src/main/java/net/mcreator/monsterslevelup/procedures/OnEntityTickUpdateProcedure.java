package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.monsterslevelup.network.MonstersLevelUpModVariables;
import net.mcreator.monsterslevelup.init.MonstersLevelUpModItems;
import net.mcreator.monsterslevelup.configuration.MonstersLevelUpConfigConfiguration;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class OnEntityTickUpdateProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Spider || entity instanceof CaveSpider) && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null
				&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 6, 6, 6), e -> true).isEmpty() && MonstersLevelUpModVariables.MapVariables.get(world).stage >= 1) {
			SpiderOnTickUpdateMethodProcedure.execute(world, entity);
		}
		if (entity instanceof Creeper && !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (!entity.isPassenger() && MonstersLevelUpConfigConfiguration.CREEPERSSEEKSPIDERS.get() == true && MonstersLevelUpModVariables.MapVariables.get(world).stage >= 1) {
				CreeperOnTickUpdateMethodProcedure.execute(world, x, y, z, entity);
			}
		}
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("monsters_level_up:archer_skeleton"))) && entity.getPersistentData().getBoolean("mobCommander") == false
				&& !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && MonstersLevelUpModVariables.MapVariables.get(world).stage >= 1) {
			SkeletonOnTickUpdateMethodProcedure.execute(world, x, y, z, entity);
		}
		if (entity instanceof EnderMan) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null && entity.getPersistentData().getBoolean("spawnedClone") == true) {
				entity.getPersistentData().putBoolean("spawnedClone", false);
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstersLevelUpModItems.COMMANDER_FLAG_CHESTPLATE.get() && entity instanceof Monster) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Monster && !(entityiterator == entity)) {
						if (!(entityiterator instanceof LivingEntity _livEnt27 && _livEnt27.hasEffect(MobEffects.MOVEMENT_SPEED))) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 0));
						}
						if (!(entityiterator instanceof LivingEntity _livEnt29 && _livEnt29.hasEffect(MobEffects.DAMAGE_BOOST))) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0));
						}
					}
				}
			}
		}
	}
}
