package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntitySetsAttackTargetProcedure {
	@SubscribeEvent
	public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
		execute(event, event.getEntity().level(), event.getOriginalTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity.getPersistentData().getBoolean("mobCommander") == true && entity instanceof Monster) {
			if (sourceentity instanceof Mob) {
				try {
					((Mob) sourceentity).setTarget(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if (sourceentity.getPersistentData().getBoolean("mobCommander") == true && sourceentity.getPersistentData().getDouble("usedHorn") <= 0) {
			SkeletonCommanderSetsAttackTargetMethodProcedure.execute(world, entity, sourceentity);
		} else if (sourceentity.getPersistentData().getBoolean("mobCommander") == true && sourceentity.getPersistentData().getDouble("usedHorn") > 0) {
			sourceentity.getPersistentData().putDouble("usedHorn", (sourceentity.getPersistentData().getDouble("usedHorn") - 1));
		}
		if (sourceentity.getPersistentData().getBoolean("juggernaut") == true && sourceentity.getPersistentData().getDouble("dash") <= 0) {
			ZombieJuggernautSetsAttackTargetMethodProcedure.execute(world, sourceentity);
		} else if (sourceentity.getPersistentData().getBoolean("juggernaut") == true && sourceentity.getPersistentData().getDouble("dash") > 0) {
			sourceentity.getPersistentData().putDouble("dash", (sourceentity.getPersistentData().getDouble("dash") - 1));
		}
	}
}
