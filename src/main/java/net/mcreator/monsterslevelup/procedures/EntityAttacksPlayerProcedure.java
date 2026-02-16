package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.monsterslevelup.network.MonstersLevelUpModVariables;
import net.mcreator.monsterslevelup.init.MonstersLevelUpModMobEffects;
import net.mcreator.monsterslevelup.init.MonstersLevelUpModItems;
import net.mcreator.monsterslevelup.entity.ZombieDolphinEntity;
import net.mcreator.monsterslevelup.entity.WitherSkeletonHorseEntity;
import net.mcreator.monsterslevelup.configuration.MonstersLevelUpConfigConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityAttacksPlayerProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Player) {
			if (sourceentity instanceof LivingEntity && !(sourceentity instanceof Player) && ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstersLevelUpModItems.BREACHING_HAMMER.get()
					|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MonstersLevelUpModItems.BREACHING_HAMMER.get())) {
				if (!(entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MonstersLevelUpModMobEffects.BREACHED.get()))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstersLevelUpModMobEffects.BREACHED.get(), 200, 0));
				}
			}
			if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("monsters_level_up:spiders")))) {
				if (MonstersLevelUpModVariables.MapVariables.get(world).stage >= (double) MonstersLevelUpConfigConfiguration.SPIDERPUTINCOBWEB.get() && MonstersLevelUpModVariables.MapVariables.get(world).stage > -1
						&& world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))) {
					if (Math.random() < 0.1) {
						world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Blocks.COBWEB.defaultBlockState(), 3);
					}
				}
				if (MonstersLevelUpModVariables.MapVariables.get(world).stage >= (double) MonstersLevelUpConfigConfiguration.SPIDERAPPLYACIDVENOM.get() && MonstersLevelUpModVariables.MapVariables.get(world).stage > -1
						&& MonstersLevelUpModVariables.MapVariables.get(world).enchant == true && !(entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(MonstersLevelUpModMobEffects.ACID_VENOM.get()))
						&& !((entity instanceof LivingEntity _entUseItem21 ? _entUseItem21.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)) {
					if (Math.random() < 0.35) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstersLevelUpModMobEffects.ACID_VENOM.get(), 80, 0));
					}
				}
			}
			if (sourceentity instanceof Creeper && (entity instanceof LivingEntity _entUseItem25 ? _entUseItem25.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem
					&& MonstersLevelUpConfigConfiguration.CREEPERSDISABLESHIELDS.get() == true && MonstersLevelUpModVariables.MapVariables.get(world).stage >= 1) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _entUseItem28 ? _entUseItem28.getUseItem() : ItemStack.EMPTY).getItem(), 100);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
			if (sourceentity instanceof WitherSkeletonHorseEntity && !((entity instanceof LivingEntity _entUseItem35 ? _entUseItem35.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)) {
				entity.setSecondsOnFire(4);
				if (Math.random() < 0.25) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 150, 0));
				}
			}
		}
		if (entity instanceof LivingEntity) {
			if (sourceentity instanceof ZombieDolphinEntity) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_level_up:entity.zombie_dolphin.attack")),
								SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_level_up:entity.zombie_dolphin.attack")), SoundSource.HOSTILE, 1,
								1, false);
					}
				}
			}
			if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("monsters_level_up:can_wear_armor")))
					&& ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("monsters_level_up:can_set_on_fire")))
							|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("monsters_level_up:can_set_on_fire"))))
					&& MonstersLevelUpConfigConfiguration.MOBSSETONFIRE.get() == true) {
				if (Math.random() < 0.25) {
					entity.setSecondsOnFire(5);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.flintandsteel.use")), SoundSource.HOSTILE, (float) 0.3,
									(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.flintandsteel.use")), SoundSource.HOSTILE, (float) 0.3,
									(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
						}
					}
				}
			}
		}
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("monsters_level_up:can_wear_armor"))) && sourceentity instanceof LivingEntity
				&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)
				&& MonstersLevelUpConfigConfiguration.MOBSUSESHIELDS.get() == true && !((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem)) {
			if (Math.random() < 0.25) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.HOSTILE, 1,
								(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.HOSTILE, 1,
								(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
					}
				}
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				} else if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
			}
		}
		if (sourceentity instanceof Player) {
			if (MonstersLevelUpModVariables.MapVariables.get(world).stage >= (double) MonstersLevelUpConfigConfiguration.MOBSCALLFORHELPSTAGE.get() && MonstersLevelUpModVariables.MapVariables.get(world).stage > -1) {
				MobCallForHelpWhenAttackedMethodProcedure.execute(world, entity, sourceentity);
			}
		}
	}
}
