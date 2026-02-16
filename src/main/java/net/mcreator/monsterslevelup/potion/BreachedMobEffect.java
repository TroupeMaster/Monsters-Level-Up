
package net.mcreator.monsterslevelup.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.monsterslevelup.procedures.BreachedEffectStartedappliedProcedure;
import net.mcreator.monsterslevelup.procedures.BreachedEffectExpiresProcedure;

public class BreachedMobEffect extends MobEffect {
	public BreachedMobEffect() {
		super(MobEffectCategory.HARMFUL, -15132386);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		BreachedEffectStartedappliedProcedure.execute(entity.level(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		BreachedEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
