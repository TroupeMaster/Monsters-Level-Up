package net.mcreator.monsterslevelup.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.monsterslevelup.init.MonstersLevelUpModMobEffects;

public class GreatswordOfTheDamnedsLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.4 && !(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MonstersLevelUpModMobEffects.FIRE_VULNERABILITY.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstersLevelUpModMobEffects.FIRE_VULNERABILITY.get(), 80, 0));
		}
		if (Math.random() < 0.6 && !(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.WITHER))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
		}
	}
}
