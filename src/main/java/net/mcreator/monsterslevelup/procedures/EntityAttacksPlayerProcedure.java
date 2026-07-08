package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.monsterslevelup.network.MonstersLevelUpModVariables;
import net.mcreator.monsterslevelup.init.MonstersLevelUpModMobEffects;
import net.mcreator.monsterslevelup.init.MonstersLevelUpModItems;
import net.mcreator.monsterslevelup.entity.ZombieDolphinEntity;
import net.mcreator.monsterslevelup.entity.WitherSkeletonHorseEntity;
import net.mcreator.monsterslevelup.entity.EndermanCloneEntity;
import net.mcreator.monsterslevelup.configuration.MonstersLevelUpConfigConfiguration;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class EntityAttacksPlayerProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, entity, immediatesourceentity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (entity instanceof Player) {
			if (sourceentity instanceof LivingEntity && !(sourceentity instanceof Player) && ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstersLevelUpModItems.BREACHING_HAMMER.get()
					|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MonstersLevelUpModItems.BREACHING_HAMMER.get())) {
				if ((entity instanceof LivingEntity _entUseItem7 ? _entUseItem7.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown((entity instanceof LivingEntity _entUseItem9 ? _entUseItem9.getUseItem() : ItemStack.EMPTY).getItem(), 160);
					{
						ItemStack _ist = (entity instanceof LivingEntity _entUseItem11 ? _entUseItem11.getUseItem() : ItemStack.EMPTY);
						if (_ist.hurt((int) amount, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.stopUsingItem();
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				} else {
					if (!(entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(MonstersLevelUpModMobEffects.BREACHED.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstersLevelUpModMobEffects.BREACHED.get(), 200, 0));
					}
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
						&& MonstersLevelUpModVariables.MapVariables.get(world).enchant == true && !(entity instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(MonstersLevelUpModMobEffects.ACID_VENOM.get()))
						&& !((entity instanceof LivingEntity _entUseItem32 ? _entUseItem32.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)) {
					if (Math.random() < 0.35) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstersLevelUpModMobEffects.ACID_VENOM.get(), 80, 0));
					}
				}
			}
			if (sourceentity instanceof Creeper && (entity instanceof LivingEntity _entUseItem36 ? _entUseItem36.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem
					&& MonstersLevelUpConfigConfiguration.CREEPERSDISABLESHIELDS.get() == true && MonstersLevelUpModVariables.MapVariables.get(world).stage >= 1) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _entUseItem39 ? _entUseItem39.getUseItem() : ItemStack.EMPTY).getItem(), 100);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
			if (sourceentity instanceof WitherSkeletonHorseEntity && !((entity instanceof LivingEntity _entUseItem46 ? _entUseItem46.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)) {
				entity.setSecondsOnFire(4);
				if (Math.random() < 0.25) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 150, 0));
				}
			}
			if (sourceentity instanceof EndermanCloneEntity) {
				if (!sourceentity.level().isClientSide())
					sourceentity.discard();
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
			if (sourceentity instanceof Blaze && immediatesourceentity == sourceentity && !((entity instanceof LivingEntity _entUseItem72 ? _entUseItem72.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)
					&& MonstersLevelUpConfigConfiguration.BLAZEAPPLYFIREVULNERABILITY.get() == true) {
				if (!(entity instanceof LivingEntity _livEnt75 && _livEnt75.hasEffect(MonstersLevelUpModMobEffects.FIRE_VULNERABILITY.get()))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstersLevelUpModMobEffects.FIRE_VULNERABILITY.get(), 300, 0));
				}
			}
			if (sourceentity instanceof MagmaCube && immediatesourceentity == sourceentity && !((entity instanceof LivingEntity _entUseItem79 ? _entUseItem79.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)
					&& MonstersLevelUpConfigConfiguration.MAGMACUBESETONFIRE.get() == true) {
				entity.setSecondsOnFire(5);
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
				}
			}
		}
		if (sourceentity instanceof Player) {
			if (MonstersLevelUpModVariables.MapVariables.get(world).stage >= (double) MonstersLevelUpConfigConfiguration.MOBSCALLFORHELPSTAGE.get() && MonstersLevelUpModVariables.MapVariables.get(world).stage > -1) {
				MobCallForHelpWhenAttackedMethodProcedure.execute(world, entity, sourceentity);
			}
		}
		if (entity instanceof EnderMan && !world.getEntitiesOfClass(EndermanCloneEntity.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty() && !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0 && MonstersLevelUpModVariables.MapVariables.get(world).stage >= (double) MonstersLevelUpConfigConfiguration.ENDERMANSUMMONCLONE.get()
				&& MonstersLevelUpModVariables.MapVariables.get(world).stage > -1) {
			if (sourceentity == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof EndermanCloneEntity && !((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
							if ((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)
									&& (entityiterator instanceof Mob _mob ? _mob.isAggressive() : false) && Math.random() < 0.03) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.HOSTILE, 1, 1, false);
									}
								}
								{
									Entity _ent = entity;
									_ent.teleportTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
								}
								if (!entityiterator.level().isClientSide())
									entityiterator.discard();
							}
						}
					}
				}
			}
		}
	}
}
