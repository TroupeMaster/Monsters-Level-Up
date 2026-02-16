package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.monsterslevelup.init.MonstersLevelUpModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WitherSkeletonConvertsEffectsProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof WitherSkeleton && entity.getPersistentData().getBoolean("witherHorseman") == true) {
			if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.BLINDNESS)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.BLINDNESS) ? _livEnt.getEffect(MobEffects.BLINDNESS).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.BLINDNESS) ? _livEnt.getEffect(MobEffects.BLINDNESS).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.BLINDNESS);
			}
			if (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MobEffects.DARKNESS)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DARKNESS) ? _livEnt.getEffect(MobEffects.DARKNESS).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DARKNESS) ? _livEnt.getEffect(MobEffects.DARKNESS).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.DARKNESS);
			}
			if (entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(MobEffects.CONFUSION)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.CONFUSION) ? _livEnt.getEffect(MobEffects.CONFUSION).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.CONFUSION) ? _livEnt.getEffect(MobEffects.CONFUSION).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.CONFUSION);
			}
			if (entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(MobEffects.HARM)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HARM) ? _livEnt.getEffect(MobEffects.HARM).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HARM) ? _livEnt.getEffect(MobEffects.HARM).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.HARM);
			}
			if (entity instanceof LivingEntity _livEnt22 && _livEnt22.hasEffect(MobEffects.HUNGER)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HUNGER) ? _livEnt.getEffect(MobEffects.HUNGER).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HUNGER) ? _livEnt.getEffect(MobEffects.HUNGER).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.HUNGER);
			}
			if (entity instanceof LivingEntity _livEnt27 && _livEnt27.hasEffect(MonstersLevelUpModMobEffects.BREACHED.get())) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstersLevelUpModMobEffects.BREACHED.get()) ? _livEnt.getEffect(MonstersLevelUpModMobEffects.BREACHED.get()).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstersLevelUpModMobEffects.BREACHED.get()) ? _livEnt.getEffect(MonstersLevelUpModMobEffects.BREACHED.get()).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstersLevelUpModMobEffects.BREACHED.get());
			}
			if (entity instanceof LivingEntity _livEnt32 && _livEnt32.hasEffect(MonstersLevelUpModMobEffects.FIRE_VULNERABILITY.get())) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstersLevelUpModMobEffects.FIRE_VULNERABILITY.get()) ? _livEnt.getEffect(MonstersLevelUpModMobEffects.FIRE_VULNERABILITY.get()).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstersLevelUpModMobEffects.FIRE_VULNERABILITY.get()) ? _livEnt.getEffect(MonstersLevelUpModMobEffects.FIRE_VULNERABILITY.get()).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstersLevelUpModMobEffects.FIRE_VULNERABILITY.get());
			}
			if (entity instanceof LivingEntity _livEnt37 && _livEnt37.hasEffect(MobEffects.DIG_SLOWDOWN)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DIG_SLOWDOWN) ? _livEnt.getEffect(MobEffects.DIG_SLOWDOWN).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DIG_SLOWDOWN) ? _livEnt.getEffect(MobEffects.DIG_SLOWDOWN).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.DIG_SLOWDOWN);
			}
			if (entity instanceof LivingEntity _livEnt42 && _livEnt42.hasEffect(MobEffects.POISON)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.POISON) ? _livEnt.getEffect(MobEffects.POISON).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.POISON) ? _livEnt.getEffect(MobEffects.POISON).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.POISON);
			}
			if (entity instanceof LivingEntity _livEnt47 && _livEnt47.hasEffect(MonstersLevelUpModMobEffects.ACID_VENOM.get())) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstersLevelUpModMobEffects.ACID_VENOM.get()) ? _livEnt.getEffect(MonstersLevelUpModMobEffects.ACID_VENOM.get()).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstersLevelUpModMobEffects.ACID_VENOM.get()) ? _livEnt.getEffect(MonstersLevelUpModMobEffects.ACID_VENOM.get()).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstersLevelUpModMobEffects.ACID_VENOM.get());
			}
			if (entity instanceof LivingEntity _livEnt52 && _livEnt52.hasEffect(MobEffects.WITHER)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WITHER) ? _livEnt.getEffect(MobEffects.WITHER).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WITHER) ? _livEnt.getEffect(MobEffects.WITHER).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WITHER);
			}
			if (entity instanceof LivingEntity _livEnt57 && _livEnt57.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
			}
			if (entity instanceof LivingEntity _livEnt62 && _livEnt62.hasEffect(MobEffects.WEAKNESS)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WEAKNESS);
			}
			if (entity instanceof LivingEntity _livEnt67 && _livEnt67.hasEffect(MobEffects.BAD_OMEN)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.BAD_OMEN) ? _livEnt.getEffect(MobEffects.BAD_OMEN).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.BAD_OMEN) ? _livEnt.getEffect(MobEffects.BAD_OMEN).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.BAD_OMEN);
			}
			if (entity instanceof LivingEntity _livEnt72 && _livEnt72.hasEffect(MobEffects.UNLUCK)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.UNLUCK) ? _livEnt.getEffect(MobEffects.UNLUCK).getDuration() : 0,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.UNLUCK) ? _livEnt.getEffect(MobEffects.UNLUCK).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.UNLUCK);
			}
		}
	}
}
