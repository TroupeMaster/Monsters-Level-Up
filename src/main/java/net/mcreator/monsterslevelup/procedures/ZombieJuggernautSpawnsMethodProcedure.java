package net.mcreator.monsterslevelup.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;

import net.mcreator.monsterslevelup.init.MonstersLevelUpModItems;

import java.util.UUID;

public class ZombieJuggernautSpawnsMethodProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("juggernaut", true);
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
				.hasModifier((new AttributeModifier(UUID.fromString("9e88af15-6448-4073-b20e-386799cef6f4"), "juggernautHealth", 200, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
					.addTransientModifier((new AttributeModifier(UUID.fromString("9e88af15-6448-4073-b20e-386799cef6f4"), "juggernautHealth", 200, AttributeModifier.Operation.ADDITION)));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 5, 999, false, false));
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE)
				.hasModifier((new AttributeModifier(UUID.fromString("cb0da29d-8282-43f4-96ce-fd63183fa548"), "juggernautFollowRange", 24, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE)
					.addTransientModifier((new AttributeModifier(UUID.fromString("cb0da29d-8282-43f4-96ce-fd63183fa548"), "juggernautFollowRange", 24, AttributeModifier.Operation.ADDITION)));
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
				.hasModifier((new AttributeModifier(UUID.fromString("3af306e5-1268-45b7-a036-f47b090471ec"), "juggernautKnockback", 1, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
					.addTransientModifier((new AttributeModifier(UUID.fromString("3af306e5-1268-45b7-a036-f47b090471ec"), "juggernautKnockback", 1, AttributeModifier.Operation.ADDITION)));
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
				.hasModifier((new AttributeModifier(UUID.fromString("c31dfdd0-32ea-411e-84a7-725a2ea8678e"), "juggernautAttack", 6, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
					.addTransientModifier((new AttributeModifier(UUID.fromString("c31dfdd0-32ea-411e-84a7-725a2ea8678e"), "juggernautAttack", 6, AttributeModifier.Operation.ADDITION)));
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.SPAWN_REINFORCEMENTS_CHANCE)
				.hasModifier((new AttributeModifier(UUID.fromString("a241cdb6-daab-4755-afa0-57a5e7d10f88"), "juggernautReinforcements", 0.18, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.SPAWN_REINFORCEMENTS_CHANCE)
					.addTransientModifier((new AttributeModifier(UUID.fromString("a241cdb6-daab-4755-afa0-57a5e7d10f88"), "juggernautReinforcements", 0.18, AttributeModifier.Operation.ADDITION)));
		if (entity instanceof LivingEntity _entity) {
			ItemStack _setstack = new ItemStack(MonstersLevelUpModItems.BREACHING_HAMMER.get()).copy();
			_setstack.setCount(1);
			_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
		if (entity instanceof LivingEntity _entity) {
			ItemStack _setstack = new ItemStack(MonstersLevelUpModItems.HEAVY_SHIELD.get()).copy();
			_setstack.setCount(1);
			_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(3, new ItemStack(MonstersLevelUpModItems.JUGGERNAUT_HELMET.get()));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(MonstersLevelUpModItems.JUGGERNAUT_HELMET.get()));
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(2, new ItemStack(MonstersLevelUpModItems.JUGGERNAUT_CHESTPLATE.get()));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(MonstersLevelUpModItems.JUGGERNAUT_CHESTPLATE.get()));
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(1, new ItemStack(MonstersLevelUpModItems.JUGGERNAUT_LEGGINGS.get()));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(MonstersLevelUpModItems.JUGGERNAUT_LEGGINGS.get()));
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(0, new ItemStack(MonstersLevelUpModItems.JUGGERNAUT_BOOTS.get()));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(MonstersLevelUpModItems.JUGGERNAUT_BOOTS.get()));
			}
		}
	}
}
