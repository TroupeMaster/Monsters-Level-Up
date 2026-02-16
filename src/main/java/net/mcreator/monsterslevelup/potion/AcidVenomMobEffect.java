
package net.mcreator.monsterslevelup.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.monsterslevelup.procedures.AcidVenomOnEffectActiveTickProcedure;

public class AcidVenomMobEffect extends MobEffect {
	public AcidVenomMobEffect() {
		super(MobEffectCategory.HARMFUL, -13953995);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		AcidVenomOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
