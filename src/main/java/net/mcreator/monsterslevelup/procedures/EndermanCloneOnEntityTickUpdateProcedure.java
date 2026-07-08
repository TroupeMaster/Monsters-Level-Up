package net.mcreator.monsterslevelup.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monsterslevelup.entity.EndermanCloneEntity;

public class EndermanCloneOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof EndermanCloneEntity _datEntI ? _datEntI.getEntityData().get(EndermanCloneEntity.DATA_despawn) : 0) >= 200) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			if (entity instanceof EndermanCloneEntity _datEntSetI)
				_datEntSetI.getEntityData().set(EndermanCloneEntity.DATA_despawn, (int) ((entity instanceof EndermanCloneEntity _datEntI ? _datEntI.getEntityData().get(EndermanCloneEntity.DATA_despawn) : 0) + 1));
		}
	}
}
