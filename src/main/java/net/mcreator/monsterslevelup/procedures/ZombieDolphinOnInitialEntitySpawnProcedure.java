package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class ZombieDolphinOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).getModifier(UUID.fromString("12b49339-313d-49c9-8963-472073fc12f3")) != null)) {
			if (!(((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).hasModifier((new AttributeModifier(UUID.fromString("12b49339-313d-49c9-8963-472073fc12f3"), "zombiedolphin_swimSpeed", 6, AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get())
						.addTransientModifier((new AttributeModifier(UUID.fromString("12b49339-313d-49c9-8963-472073fc12f3"), "zombiedolphin_swimSpeed", 6, AttributeModifier.Operation.ADDITION)));
		}
	}
}
