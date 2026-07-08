package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monsterslevelup.network.MonstersLevelUpModVariables;
import net.mcreator.monsterslevelup.init.MonstersLevelUpModEntities;
import net.mcreator.monsterslevelup.entity.EndermanCloneEntity;
import net.mcreator.monsterslevelup.configuration.MonstersLevelUpConfigConfiguration;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class EndermanIsAngryProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double xPos = 0;
		double yPos = 0;
		double zPos = 0;
		if (entity instanceof EnderMan && !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)
				&& MonstersLevelUpModVariables.MapVariables.get(world).stage >= (double) MonstersLevelUpConfigConfiguration.ENDERMANSUMMONCLONE.get() && MonstersLevelUpModVariables.MapVariables.get(world).stage > -1) {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)
							&& !(!world.getEntitiesOfClass(EndermanCloneEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 6, 6, 6), e -> true).isEmpty())) {
						for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 0, 1); index0++) {
							xPos = entityiterator.getX() + Mth.nextInt(RandomSource.create(), -9, 9);
							yPos = entityiterator.getY() + Mth.nextInt(RandomSource.create(), -1, 1);
							zPos = entityiterator.getZ() + Mth.nextInt(RandomSource.create(), -9, 9);
							if (world.isEmptyBlock(BlockPos.containing(xPos, yPos, zPos)) && world.isEmptyBlock(BlockPos.containing(xPos, yPos + 1, zPos)) && world.isEmptyBlock(BlockPos.containing(xPos, yPos + 2, zPos))
									&& world.isEmptyBlock(BlockPos.containing(xPos, yPos + 3, zPos)) && world.getBlockState(BlockPos.containing(xPos, yPos - 1, zPos)).canOcclude()) {
								if (world instanceof ServerLevel _serverLevel) {
									Entity entityinstance = MonstersLevelUpModEntities.ENDERMAN_CLONE.get().create(_serverLevel, null, null, BlockPos.containing(xPos, yPos, zPos), MobSpawnType.MOB_SUMMONED, false, false);
									if (entityinstance != null) {
										entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
										if (entityinstance instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
											_entity.setTarget(_ent);
										_serverLevel.addFreshEntity(entityinstance);
									}
								}
								break;
							}
						}
					}
				}
			}
		}
	}
}
