package net.mcreator.monsterslevelup.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.monsterslevelup.network.MonstersLevelUpModVariables;
import net.mcreator.monsterslevelup.configuration.MonstersLevelUpConfigConfiguration;

public class WitherSkeletonHorseOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < (double) MonstersLevelUpConfigConfiguration.WITHERSKELETONTRAPCHANCE.get() * MonstersLevelUpModVariables.MapVariables.get(world).netherMultiplier && entity.getPersistentData().getBoolean("spawnFromTrap") == false) {
			entity.getPersistentData().putBoolean("trap", true);
		}
	}
}
