package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.monsterslevelup.init.MonstersLevelUpModItems;
import net.mcreator.monsterslevelup.init.MonstersLevelUpModEntities;

import java.util.UUID;
import java.util.List;
import java.util.Comparator;

public class WitherSkeletonHorseSpawnTrapProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("trap") == true && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()) {
			entity.getPersistentData().putBoolean("trap", false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.goat_horn.sound.2")), SoundSource.HOSTILE, 4, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.goat_horn.sound.2")), SoundSource.HOSTILE, 4, 1, false);
				}
			}
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.WITHER_SKELETON.spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof WitherSkeleton) {
						entityiterator.startRiding(entity);
						if (!(((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.hasModifier((new AttributeModifier(UUID.fromString("0d6bc98d-f59b-4940-b8b7-e730aa69c3b8"), "trapHealth", 140, AttributeModifier.Operation.ADDITION)))))
							((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
									.addTransientModifier((new AttributeModifier(UUID.fromString("0d6bc98d-f59b-4940-b8b7-e730aa69c3b8"), "trapHealth", 140, AttributeModifier.Operation.ADDITION)));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 5, 200, false, false));
						if (!(((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
								.hasModifier((new AttributeModifier(UUID.fromString("55ae6229-a341-43c3-8a70-6d1913352385"), "trapAttack", 3, AttributeModifier.Operation.ADDITION)))))
							((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
									.addTransientModifier((new AttributeModifier(UUID.fromString("55ae6229-a341-43c3-8a70-6d1913352385"), "trapAttack", 3, AttributeModifier.Operation.ADDITION)));
						if (!(((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
								.hasModifier((new AttributeModifier(UUID.fromString("2ec5b218-b5b5-49a4-8799-b101959f8781"), "trapArmor", 12, AttributeModifier.Operation.ADDITION)))))
							((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
									.addTransientModifier((new AttributeModifier(UUID.fromString("2ec5b218-b5b5-49a4-8799-b101959f8781"), "trapArmor", 12, AttributeModifier.Operation.ADDITION)));
						if (!(((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS)
								.hasModifier((new AttributeModifier(UUID.fromString("8b01d5aa-12e4-4447-8781-0e162eff1d4a"), "trapToughness", 8, AttributeModifier.Operation.ADDITION)))))
							((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS)
									.addTransientModifier((new AttributeModifier(UUID.fromString("8b01d5aa-12e4-4447-8781-0e162eff1d4a"), "trapToughness", 8, AttributeModifier.Operation.ADDITION)));
						entityiterator.getPersistentData().putBoolean("witherHorseman", true);
						{
							Entity _entity = entityiterator;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
							}
						}
						{
							Entity _entity = entityiterator;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(MonstersLevelUpModItems.COMMANDER_FLAG_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(MonstersLevelUpModItems.COMMANDER_FLAG_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entityiterator;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(MonstersLevelUpModItems.WITHER_LEGGINGS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(MonstersLevelUpModItems.WITHER_LEGGINGS.get()));
							}
						}
						{
							Entity _entity = entityiterator;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(MonstersLevelUpModItems.WITHER_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(MonstersLevelUpModItems.WITHER_BOOTS.get()));
							}
						}
						if (entityiterator instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.BOW).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.POWER_ARROWS, 4);
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.GOAT_HORN).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
				}
			}
			for (int index0 = 0; index0 < 2; index0++) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entityinstance = MonstersLevelUpModEntities.WITHER_SKELETON_HORSE.get().create(_serverLevel, null, null,
							BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -2, 2), entity.getY(), entity.getZ() + Mth.nextInt(RandomSource.create(), -2, 2)), MobSpawnType.MOB_SUMMONED, false, false);
					if (entityinstance != null) {
						entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
						entityinstance.getPersistentData().putBoolean("spawnFromTrap", false);
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.WITHER_SKELETON.spawn(_level, BlockPos.containing(entityinstance.getX(), entityinstance.getY(), entityinstance.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						{
							final Vec3 _center = new Vec3((entityinstance.getX()), (entityinstance.getY()), (entityinstance.getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof WitherSkeleton) {
									entityiterator.startRiding(entityinstance);
									if (!(((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
											.hasModifier((new AttributeModifier(UUID.fromString("0d6bc98d-f59b-4940-b8b7-e730aa69c3b8"), "trapHealth", 140, AttributeModifier.Operation.ADDITION)))))
										((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
												.addTransientModifier((new AttributeModifier(UUID.fromString("0d6bc98d-f59b-4940-b8b7-e730aa69c3b8"), "trapHealth", 140, AttributeModifier.Operation.ADDITION)));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 5, 200, false, false));
									if (!(((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
											.hasModifier((new AttributeModifier(UUID.fromString("55ae6229-a341-43c3-8a70-6d1913352385"), "trapAttack", 3, AttributeModifier.Operation.ADDITION)))))
										((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
												.addTransientModifier((new AttributeModifier(UUID.fromString("55ae6229-a341-43c3-8a70-6d1913352385"), "trapAttack", 3, AttributeModifier.Operation.ADDITION)));
									if (!(((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
											.hasModifier((new AttributeModifier(UUID.fromString("2ec5b218-b5b5-49a4-8799-b101959f8781"), "trapArmor", 12, AttributeModifier.Operation.ADDITION)))))
										((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
												.addTransientModifier((new AttributeModifier(UUID.fromString("2ec5b218-b5b5-49a4-8799-b101959f8781"), "trapArmor", 12, AttributeModifier.Operation.ADDITION)));
									if (!(((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS)
											.hasModifier((new AttributeModifier(UUID.fromString("8b01d5aa-12e4-4447-8781-0e162eff1d4a"), "trapToughness", 8, AttributeModifier.Operation.ADDITION)))))
										((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS)
												.addTransientModifier((new AttributeModifier(UUID.fromString("8b01d5aa-12e4-4447-8781-0e162eff1d4a"), "trapToughness", 8, AttributeModifier.Operation.ADDITION)));
									entityiterator.getPersistentData().putBoolean("witherHorseman", true);
									{
										Entity _entity = entityiterator;
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
										}
									}
									{
										Entity _entity = entityiterator;
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(2, new ItemStack(MonstersLevelUpModItems.WITHER_CHESTPLATE.get()));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(MonstersLevelUpModItems.WITHER_CHESTPLATE.get()));
										}
									}
									{
										Entity _entity = entityiterator;
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(1, new ItemStack(MonstersLevelUpModItems.WITHER_LEGGINGS.get()));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(MonstersLevelUpModItems.WITHER_LEGGINGS.get()));
										}
									}
									{
										Entity _entity = entityiterator;
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(0, new ItemStack(MonstersLevelUpModItems.WITHER_BOOTS.get()));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(MonstersLevelUpModItems.WITHER_BOOTS.get()));
										}
									}
									if (entityiterator instanceof LivingEntity _entity) {
										ItemStack _setstack = new ItemStack(Items.NETHERITE_SWORD).copy();
										_setstack.setCount(1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
									(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.FIRE_ASPECT, 1);
								}
							}
						}
						_serverLevel.addFreshEntity(entityinstance);
					}
				}
			}
		}
	}
}
