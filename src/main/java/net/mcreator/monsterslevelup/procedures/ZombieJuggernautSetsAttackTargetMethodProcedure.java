package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ZombieJuggernautSetsAttackTargetMethodProcedure {
	public static void execute(LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		sourceentity.getPersistentData().putDouble("dash", (Mth.nextInt(RandomSource.create(), 40, 200)));
		if (!((sourceentity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.HOSTILE, 4,
							(float) 0.6);
				} else {
					_level.playLocalSound((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.HOSTILE, 4, (float) 0.6, false);
				}
			}
			sourceentity.setDeltaMovement(new Vec3((((sourceentity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - sourceentity.getX()) * 0.4), 0.24,
					(((sourceentity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - sourceentity.getZ()) * 0.4)));
		}
	}
}
