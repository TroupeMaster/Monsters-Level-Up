package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.monsterslevelup.entity.WitherSkeletonHorseEntity;
import net.mcreator.monsterslevelup.MonstersLevelUpMod;

import java.util.UUID;

public class TamedWitherSkeletonHorseTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 1 / 900 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 2));
		}
		if (entity.isVehicle()) {
			entity.getPersistentData().putDouble("xPos", (entity.getX()));
			entity.getPersistentData().putDouble("zPos", (entity.getZ()));
			MonstersLevelUpMod.queueServerWork(2, () -> {
				if (entity.getPersistentData().getDouble("xPos") != entity.getX() || entity.getPersistentData().getDouble("zPos") != entity.getZ()) {
					if (entity.getPersistentData().getDouble("playGallop") >= 10) {
						entity.getPersistentData().putDouble("playGallop", 0);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.horse.gallop")), SoundSource.HOSTILE, 1,
										(float) Mth.nextDouble(RandomSource.create(), 0.85, 1.07));
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.horse.gallop")), SoundSource.HOSTILE, 1,
										(float) Mth.nextDouble(RandomSource.create(), 0.85, 1.07), false);
							}
						}
					} else {
						entity.getPersistentData().putDouble("playGallop", (entity.getPersistentData().getDouble("playGallop") + 1));
					}
				}
			});
		}
		if (entity.getPersistentData().getDouble("eat") >= 200 && world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude() && !entity.isInWall() && !entity.isInWaterOrBubble() && !entity.isInLava() && !entity.isVehicle()
				&& (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			entity.getPersistentData().putDouble("eat", 0);
			if (Math.random() < 0.25) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 99, false, false));
				if (entity instanceof WitherSkeletonHorseEntity) {
					((WitherSkeletonHorseEntity) entity).setAnimation("animation.WitherHorse_eat");
				}
			}
		} else {
			entity.getPersistentData().putDouble("eat", (entity.getPersistentData().getDouble("eat") + 1));
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (entity.getPersistentData().getBoolean("rear") == false) {
				entity.getPersistentData().putBoolean("rear", true);
				if (entity instanceof WitherSkeletonHorseEntity) {
					((WitherSkeletonHorseEntity) entity).setAnimation("animation.WitherHorse_rear");
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_level_up:entity.wither_skeleton_horse.death")), SoundSource.HOSTILE,
								2, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_level_up:entity.wither_skeleton_horse.death")), SoundSource.HOSTILE, 2,
								(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
					}
				}
			}
		} else if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			if (entity.getPersistentData().getBoolean("rear") == true) {
				entity.getPersistentData().putBoolean("rear", false);
			}
		}
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SOUL_SAND || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.SOUL_SAND)
				&& !(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getModifier(UUID.fromString("8bd547b3-c1bd-460a-9380-37485569905c")) != null)) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.hasModifier((new AttributeModifier(UUID.fromString("8bd547b3-c1bd-460a-9380-37485569905c"), "soulSandSpeed", 0.08, AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
						.addTransientModifier((new AttributeModifier(UUID.fromString("8bd547b3-c1bd-460a-9380-37485569905c"), "soulSandSpeed", 0.08, AttributeModifier.Operation.ADDITION)));
		} else if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getModifier(UUID.fromString("8bd547b3-c1bd-460a-9380-37485569905c")) != null) {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).removeModifier(UUID.fromString("8bd547b3-c1bd-460a-9380-37485569905c"));
		}
		if (entity.isUnderWater()) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) 0.5);
			if (Math.random() < 0.01) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.HOSTILE, (float) 0.3,
								(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.HOSTILE, (float) 0.3,
								(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
					}
				}
			}
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (-0.25), (entity.getDeltaMovement().z())));
		}
		if (world.getLevelData().isRaining() || world.getLevelData().isThundering()) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) 0.5);
			if (Math.random() < 0.01) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.HOSTILE, (float) 0.3,
								(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.HOSTILE, (float) 0.3,
								(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
					}
				}
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (entity.getX() + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (entity.getY() + 0.1), (entity.getZ() + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
					Mth.nextInt(RandomSource.create(), 1, 4), 0, 0, 0, 0);
	}
}
