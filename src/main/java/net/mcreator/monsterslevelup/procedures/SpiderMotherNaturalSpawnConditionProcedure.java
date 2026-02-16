package net.mcreator.monsterslevelup.procedures;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import net.mcreator.monsterslevelup.network.MonstersLevelUpModVariables;

public class SpiderMotherNaturalSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD && (MonstersLevelUpModVariables.MapVariables.get(world).stage <= 2)
				? (Math.random() < 0.1)
				: (Math.random() < 1)) {
			return true;
		}
		return false;
	}
}
