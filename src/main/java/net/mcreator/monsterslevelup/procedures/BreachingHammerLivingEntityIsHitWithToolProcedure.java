package net.mcreator.monsterslevelup.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.monsterslevelup.init.MonstersLevelUpModMobEffects;

public class BreachingHammerLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MonstersLevelUpModMobEffects.BREACHED.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstersLevelUpModMobEffects.BREACHED.get(), 100, 0));
		}
	}
}
