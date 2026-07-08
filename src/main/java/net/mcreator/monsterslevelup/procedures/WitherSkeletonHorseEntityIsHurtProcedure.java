package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.monsterslevelup.entity.WitherSkeletonHorseEntity;
import net.mcreator.monsterslevelup.entity.TamedWitherSkeletonHorseEntity;

public class WitherSkeletonHorseEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if (entity instanceof WitherSkeletonHorseEntity) {
				if ((entity instanceof WitherSkeletonHorseEntity _datEntI ? _datEntI.getEntityData().get(WitherSkeletonHorseEntity.DATA_rear) : 0) <= 0 && !entity.isVehicle()) {
					if (entity instanceof WitherSkeletonHorseEntity _datEntSetI)
						_datEntSetI.getEntityData().set(WitherSkeletonHorseEntity.DATA_rear, 200);
					if (entity instanceof WitherSkeletonHorseEntity) {
						((WitherSkeletonHorseEntity) entity).setAnimation("animation.WitherHorse_rear");
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 99, false, false));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_level_up:entity.wither_skeleton_horse.death")),
									SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_level_up:entity.wither_skeleton_horse.death")), SoundSource.HOSTILE, 2,
									(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
						}
					}
				}
			} else if (entity instanceof TamedWitherSkeletonHorseEntity) {
				if ((entity instanceof TamedWitherSkeletonHorseEntity _datEntI ? _datEntI.getEntityData().get(TamedWitherSkeletonHorseEntity.DATA_rear) : 0) <= 0 && !entity.isVehicle()) {
					if (entity instanceof TamedWitherSkeletonHorseEntity _datEntSetI)
						_datEntSetI.getEntityData().set(TamedWitherSkeletonHorseEntity.DATA_rear, 200);
					if (entity instanceof TamedWitherSkeletonHorseEntity) {
						((TamedWitherSkeletonHorseEntity) entity).setAnimation("animation.WitherHorse_rear");
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 99, false, false));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_level_up:entity.wither_skeleton_horse.death")),
									SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_level_up:entity.wither_skeleton_horse.death")), SoundSource.HOSTILE, 2,
									(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
						}
					}
				}
			}
		}
	}
}
