package net.mcreator.monsterslevelup.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ChargeOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("chargeRegeneration") >= 40) {
			entity.getPersistentData().putDouble("chargeRegeneration", 0);
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1));
		} else {
			entity.getPersistentData().putDouble("chargeRegeneration", (entity.getPersistentData().getDouble("chargeRegeneration") + 1));
		}
	}
}
