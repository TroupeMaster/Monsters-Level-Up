package net.mcreator.monsterslevelup.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class WitherSkeletonHorseOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		WitherSkeletonHorseSpawnTrapProcedure.execute(world, x, y, z, entity);
		WitherHorseTickProcedure.execute(world, x, y, z, entity);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (entity.getX() + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (entity.getY() + 0.1), (entity.getZ() + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
					Mth.nextInt(RandomSource.create(), 1, 4), 0, 0, 0, 0);
	}
}
