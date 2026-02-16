package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.monsterslevelup.entity.ZombieDolphinEntity;

import java.util.Comparator;

public class ZombieDolphinOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() > entity.getY() && !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).isUnderWater())
					&& entity.getPersistentData().getBoolean("jump") == false) {
				if (entity.isUnderWater()) {
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.2, (entity.getDeltaMovement().z())));
				} else {
					if (entity.getPersistentData().getBoolean("jump") == false) {
						entity.getPersistentData().putBoolean("jump", true);
						entity.getPersistentData().putDouble("jumpCooldown", 60);
						if (entity instanceof ZombieDolphinEntity) {
							((ZombieDolphinEntity) entity).setAnimation("animation.zombieDolphin_jump");
						}
						entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1), 1, (Math.cos(Math.toRadians(entity.getYRot())) * 1)));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dolphin.jump")), SoundSource.HOSTILE, (float) 0.75, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dolphin.jump")), SoundSource.HOSTILE, (float) 0.75, 1, false);
							}
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("jumpCooldown") > 0) {
			if (entity.isUnderWater()) {
				if (entity.getPersistentData().getDouble("jumpCooldown") == 100) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dolphin.splash")), SoundSource.HOSTILE, (float) 0.1,
									(float) Mth.nextDouble(RandomSource.create(), 0.6, 1.4));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dolphin.splash")), SoundSource.HOSTILE, (float) 0.1, (float) Mth.nextDouble(RandomSource.create(), 0.6, 1.4), false);
						}
					}
				}
				entity.getPersistentData().putDouble("jumpCooldown", (entity.getPersistentData().getDouble("jumpCooldown") - 1));
			}
		} else if (entity.getPersistentData().getBoolean("jump") == true) {
			entity.getPersistentData().putBoolean("jump", false);
		}
		if (entity.isSwimming()) {
			if (Math.random() < 0.5) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dolphin.swim")), SoundSource.HOSTILE, (float) 0.03,
								(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dolphin.swim")), SoundSource.HOSTILE, (float) 0.03, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
					}
				}
			}
		}
		if (!entity.isVehicle() && !world.getEntitiesOfClass(Drowned.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
			if (!((Entity) world.getEntitiesOfClass(Drowned.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).isPassenger()) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((((Entity) world.getEntitiesOfClass(Drowned.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Drowned.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(Drowned.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), 3);
				if (!world.getEntitiesOfClass(Drowned.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Drowned.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).startRiding(entity);
				}
			}
		}
	}
}
