package net.mcreator.monsterslevelup.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monsterslevelup.init.MonstersLevelUpModItems;
import net.mcreator.monsterslevelup.init.MonstersLevelUpModEntities;
import net.mcreator.monsterslevelup.entity.SpiderMotherEntity;

import java.util.UUID;
import java.util.List;
import java.util.Comparator;

public class SkeletonCommanderSpawnsWithEggProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entityinstance) {
		if (entityinstance == null)
			return;
		entityinstance.getPersistentData().putBoolean("mobCommander", true);
		if (!(((LivingEntity) entityinstance).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
				.hasModifier((new AttributeModifier(UUID.fromString("aaf707dc-0448-41d2-af7a-bf1816fd3e88"), "commanderHealth", 250, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entityinstance).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
					.addTransientModifier((new AttributeModifier(UUID.fromString("aaf707dc-0448-41d2-af7a-bf1816fd3e88"), "commanderHealth", 250, AttributeModifier.Operation.ADDITION)));
		if (entityinstance instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 5, 999, false, false));
		if (!(((LivingEntity) entityinstance).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE)
				.hasModifier((new AttributeModifier(UUID.fromString("a222c6ce-dda7-4f76-a415-e08f1ba27eeb"), "commanderFollowRange", 24, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entityinstance).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE)
					.addTransientModifier((new AttributeModifier(UUID.fromString("a222c6ce-dda7-4f76-a415-e08f1ba27eeb"), "commanderFollowRange", 24, AttributeModifier.Operation.ADDITION)));
		if (!(((LivingEntity) entityinstance).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
				.hasModifier((new AttributeModifier(UUID.fromString("23b9b726-380d-4c55-a7c2-17c1e833f301"), "commanderKnockback", 1, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entityinstance).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
					.addTransientModifier((new AttributeModifier(UUID.fromString("23b9b726-380d-4c55-a7c2-17c1e833f301"), "commanderKnockback", 1, AttributeModifier.Operation.ADDITION)));
		if (entityinstance instanceof LivingEntity _entity) {
			ItemStack _setstack = new ItemStack(MonstersLevelUpModItems.COMMANDER_CUTLASS.get()).copy();
			_setstack.setCount(1);
			_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
		if (entityinstance instanceof LivingEntity _entity) {
			ItemStack _setstack = new ItemStack(Items.GOAT_HORN).copy();
			_setstack.setCount(1);
			_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
		{
			Entity _entity = entityinstance;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(3, new ItemStack(MonstersLevelUpModItems.GUILDED_COMMANDER_HELMET.get()));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(MonstersLevelUpModItems.GUILDED_COMMANDER_HELMET.get()));
			}
		}
		{
			Entity _entity = entityinstance;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(2, new ItemStack(MonstersLevelUpModItems.COMMANDER_FLAG_CHESTPLATE.get()));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(MonstersLevelUpModItems.COMMANDER_FLAG_CHESTPLATE.get()));
			}
		}
		{
			Entity _entity = entityinstance;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(1, new ItemStack(MonstersLevelUpModItems.GUILDED_COMMANDER_LEGGINGS.get()));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(MonstersLevelUpModItems.GUILDED_COMMANDER_LEGGINGS.get()));
			}
		}
		{
			Entity _entity = entityinstance;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(0, new ItemStack(MonstersLevelUpModItems.GUILDED_COMMANDER_BOOTS.get()));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(MonstersLevelUpModItems.GUILDED_COMMANDER_BOOTS.get()));
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = MonstersLevelUpModEntities.SPIDER_MOTHER.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
		{
			final Vec3 _center = new Vec3(x, (y + 1), z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof SpiderMotherEntity) {
					entityinstance.startRiding(entityiterator);
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, (int) Double.POSITIVE_INFINITY, 1, false, false));
					if (!(((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
							.hasModifier((new AttributeModifier(UUID.fromString("007255f3-ef1a-4414-9221-41df81c1901a"), "commanderHealth", 120, AttributeModifier.Operation.ADDITION)))))
						((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.addTransientModifier((new AttributeModifier(UUID.fromString("007255f3-ef1a-4414-9221-41df81c1901a"), "commanderHealth", 120, AttributeModifier.Operation.ADDITION)));
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 5, 999, false, false));
					if (!(((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE)
							.hasModifier((new AttributeModifier(UUID.fromString("fb6e5641-10c2-46d6-9f43-f1f44853cde5"), "commanderFollowRange", 24, AttributeModifier.Operation.ADDITION)))))
						((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE)
								.addTransientModifier((new AttributeModifier(UUID.fromString("fb6e5641-10c2-46d6-9f43-f1f44853cde5"), "commanderFollowRange", 24, AttributeModifier.Operation.ADDITION)));
					if (!(((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE)
							.hasModifier((new AttributeModifier(UUID.fromString("d5ce13dd-164a-4333-bbfa-2cb6caaeba51"), "commanderSpeed", 0.15, AttributeModifier.Operation.ADDITION)))))
						((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE)
								.addTransientModifier((new AttributeModifier(UUID.fromString("d5ce13dd-164a-4333-bbfa-2cb6caaeba51"), "commanderSpeed", 0.15, AttributeModifier.Operation.ADDITION)));
				}
			}
		}
	}
}
