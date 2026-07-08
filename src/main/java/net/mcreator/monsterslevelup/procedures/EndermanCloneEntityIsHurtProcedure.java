package net.mcreator.monsterslevelup.procedures;

import net.minecraft.world.entity.Entity;

public class EndermanCloneEntityIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.level().isClientSide())
			entity.discard();
	}
}
