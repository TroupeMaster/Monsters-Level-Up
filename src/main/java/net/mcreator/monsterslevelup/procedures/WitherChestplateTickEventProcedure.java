package net.mcreator.monsterslevelup.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.monsterslevelup.init.MonstersLevelUpModMobEffects;
import net.mcreator.monsterslevelup.init.MonstersLevelUpModItems;

public class WitherChestplateTickEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == MonstersLevelUpModItems.WITHER_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstersLevelUpModItems.WITHER_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == MonstersLevelUpModItems.WITHER_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == MonstersLevelUpModItems.WITHER_BOOTS.get()) {
			if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.BLINDNESS)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.BLINDNESS) ? _livEnt.getEffect(MobEffects.BLINDNESS).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.BLINDNESS) ? _livEnt.getEffect(MobEffects.BLINDNESS).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.BLINDNESS);
			}
			if (entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(MobEffects.DARKNESS)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DARKNESS) ? _livEnt.getEffect(MobEffects.DARKNESS).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DARKNESS) ? _livEnt.getEffect(MobEffects.DARKNESS).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.DARKNESS);
			}
			if (entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(MobEffects.CONFUSION)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.CONFUSION) ? _livEnt.getEffect(MobEffects.CONFUSION).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.CONFUSION) ? _livEnt.getEffect(MobEffects.CONFUSION).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.CONFUSION);
			}
			if (entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(MobEffects.HARM)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HARM) ? _livEnt.getEffect(MobEffects.HARM).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HARM) ? _livEnt.getEffect(MobEffects.HARM).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.HARM);
			}
			if (entity instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(MobEffects.HUNGER)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HUNGER) ? _livEnt.getEffect(MobEffects.HUNGER).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HUNGER) ? _livEnt.getEffect(MobEffects.HUNGER).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.HUNGER);
			}
			if (entity instanceof LivingEntity _livEnt33 && _livEnt33.hasEffect(MonstersLevelUpModMobEffects.BREACHED.get())) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstersLevelUpModMobEffects.BREACHED.get()) ? _livEnt.getEffect(MonstersLevelUpModMobEffects.BREACHED.get()).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstersLevelUpModMobEffects.BREACHED.get()) ? _livEnt.getEffect(MonstersLevelUpModMobEffects.BREACHED.get()).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstersLevelUpModMobEffects.BREACHED.get());
			}
			if (entity instanceof LivingEntity _livEnt38 && _livEnt38.hasEffect(MonstersLevelUpModMobEffects.FIRE_VULNERABILITY.get())) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstersLevelUpModMobEffects.FIRE_VULNERABILITY.get()) ? _livEnt.getEffect(MonstersLevelUpModMobEffects.FIRE_VULNERABILITY.get()).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstersLevelUpModMobEffects.FIRE_VULNERABILITY.get()) ? _livEnt.getEffect(MonstersLevelUpModMobEffects.FIRE_VULNERABILITY.get()).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstersLevelUpModMobEffects.FIRE_VULNERABILITY.get());
			}
			if (entity instanceof LivingEntity _livEnt43 && _livEnt43.hasEffect(MobEffects.DIG_SLOWDOWN)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DIG_SLOWDOWN) ? _livEnt.getEffect(MobEffects.DIG_SLOWDOWN).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DIG_SLOWDOWN) ? _livEnt.getEffect(MobEffects.DIG_SLOWDOWN).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.DIG_SLOWDOWN);
			}
			if (entity instanceof LivingEntity _livEnt48 && _livEnt48.hasEffect(MobEffects.POISON)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.POISON) ? _livEnt.getEffect(MobEffects.POISON).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.POISON) ? _livEnt.getEffect(MobEffects.POISON).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.POISON);
			}
			if (entity instanceof LivingEntity _livEnt53 && _livEnt53.hasEffect(MonstersLevelUpModMobEffects.ACID_VENOM.get())) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstersLevelUpModMobEffects.ACID_VENOM.get()) ? _livEnt.getEffect(MonstersLevelUpModMobEffects.ACID_VENOM.get()).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstersLevelUpModMobEffects.ACID_VENOM.get()) ? _livEnt.getEffect(MonstersLevelUpModMobEffects.ACID_VENOM.get()).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstersLevelUpModMobEffects.ACID_VENOM.get());
			}
			if (entity instanceof LivingEntity _livEnt58 && _livEnt58.hasEffect(MobEffects.WITHER)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WITHER) ? _livEnt.getEffect(MobEffects.WITHER).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WITHER) ? _livEnt.getEffect(MobEffects.WITHER).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WITHER);
			}
			if (entity instanceof LivingEntity _livEnt63 && _livEnt63.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
			}
			if (entity instanceof LivingEntity _livEnt68 && _livEnt68.hasEffect(MobEffects.WEAKNESS)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WEAKNESS);
			}
			if (entity instanceof LivingEntity _livEnt73 && _livEnt73.hasEffect(MobEffects.BAD_OMEN)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.BAD_OMEN) ? _livEnt.getEffect(MobEffects.BAD_OMEN).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.BAD_OMEN) ? _livEnt.getEffect(MobEffects.BAD_OMEN).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.BAD_OMEN);
			}
			if (entity instanceof LivingEntity _livEnt78 && _livEnt78.hasEffect(MobEffects.UNLUCK)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.UNLUCK) ? _livEnt.getEffect(MobEffects.UNLUCK).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.UNLUCK) ? _livEnt.getEffect(MobEffects.UNLUCK).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.UNLUCK);
			}
		}
	}
}
