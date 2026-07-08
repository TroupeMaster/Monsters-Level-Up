
package net.mcreator.monsterslevelup.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.monsterslevelup.procedures.ChargeOnEffectActiveTickProcedure;
import net.mcreator.monsterslevelup.procedures.ChargeEffectStartedappliedProcedure;
import net.mcreator.monsterslevelup.procedures.ChargeEffectExpiresProcedure;

public class ChargeMobEffect extends MobEffect {
	public ChargeMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -9043968);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		ChargeEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ChargeOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		ChargeEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
