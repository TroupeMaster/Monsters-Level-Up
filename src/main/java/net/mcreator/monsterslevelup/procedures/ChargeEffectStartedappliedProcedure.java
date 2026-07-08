package net.mcreator.monsterslevelup.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class ChargeEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
				.hasModifier((new AttributeModifier(UUID.fromString("748d8505-eb8e-41ca-9880-3119499a018e"), "chargeSpeed", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.addTransientModifier((new AttributeModifier(UUID.fromString("748d8505-eb8e-41ca-9880-3119499a018e"), "chargeSpeed", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL)));
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
				.hasModifier((new AttributeModifier(UUID.fromString("ee1a953a-45ec-477f-b501-8e86aa92b80d"), "chargeStrength", 2, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
					.addTransientModifier((new AttributeModifier(UUID.fromString("ee1a953a-45ec-477f-b501-8e86aa92b80d"), "chargeStrength", 2, AttributeModifier.Operation.ADDITION)));
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS)
				.hasModifier((new AttributeModifier(UUID.fromString("ba1694a5-edc0-4a5c-8c7b-92d17bbeaf5b"), "chargeArmor", 2, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS)
					.addTransientModifier((new AttributeModifier(UUID.fromString("ba1694a5-edc0-4a5c-8c7b-92d17bbeaf5b"), "chargeArmor", 2, AttributeModifier.Operation.ADDITION)));
	}
}
