package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.monsterslevelup.MonstersLevelUpMod;

public class SpiderMotherEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		MonstersLevelUpMod.queueServerWork(20, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.break")), SoundSource.HOSTILE, 1, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.break")), SoundSource.HOSTILE, 1, (float) 0.8, false);
				}
			}
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 5); index0++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.CAVE_SPIDER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot((float) Math.random());
						entityToSpawn.setYBodyRot((float) Math.random());
						entityToSpawn.setYHeadRot((float) Math.random());
						entityToSpawn.setXRot((float) Math.random());
						entityToSpawn.setDeltaMovement((Mth.nextDouble(RandomSource.create(), -1, 1)), 0.3, (Mth.nextDouble(RandomSource.create(), -1, 1)));
					}
				}
			}
		});
	}
}
