package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class MobCallForHelpWhenAttackedMethodProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("monsters_level_up:zombies"))) && entity.getPersistentData().getBoolean("calledForHelp") == false
				&& (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == sourceentity) {
			entity.getPersistentData().putBoolean("calledForHelp", true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.ambient")), SoundSource.HOSTILE, 4, (float) 0.6);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.ambient")), SoundSource.HOSTILE, 4, (float) 0.6, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, (entity.getX() + 0.5 + Mth.nextDouble(RandomSource.create(), -0.6, 0.6)), (entity.getY() + 0.4), (entity.getZ() + 0.5 + Mth.nextDouble(RandomSource.create(), -0.6, 0.6)),
						Mth.nextInt(RandomSource.create(), 3, 5), 0, 1, 0, 0.1);
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("monsters_level_up:zombies"))) && !((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == sourceentity)) {
						if (entityiterator instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						if (entityiterator instanceof Mob _entity)
							_entity.getNavigation().moveTo((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), 1.4);
					}
				}
			}
		}
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("monsters_level_up:skeletons"))) && entity.getPersistentData().getBoolean("calledForHelp") == false
				&& (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == sourceentity) {
			entity.getPersistentData().putBoolean("calledForHelp", true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither_skeleton.ambient")), SoundSource.HOSTILE, 4, (float) 0.6);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither_skeleton.ambient")), SoundSource.HOSTILE, 4, (float) 0.6, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, (entity.getX() + 0.5 + Mth.nextDouble(RandomSource.create(), -0.6, 0.6)), (entity.getY() + 0.4), (entity.getZ() + 0.5 + Mth.nextDouble(RandomSource.create(), -0.6, 0.6)),
						Mth.nextInt(RandomSource.create(), 3, 5), 0, 1, 0, 0.1);
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("monsters_level_up:skeletons"))) && !((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == sourceentity)) {
						if (entityiterator instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						if (entityiterator instanceof Mob _entity)
							_entity.getNavigation().moveTo((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), 1.4);
					}
				}
			}
		}
	}
}
