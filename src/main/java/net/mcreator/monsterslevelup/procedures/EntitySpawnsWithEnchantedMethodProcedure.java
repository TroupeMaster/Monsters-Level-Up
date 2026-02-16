package net.mcreator.monsterslevelup.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.monsterslevelup.network.MonstersLevelUpModVariables;
import net.mcreator.monsterslevelup.configuration.MonstersLevelUpConfigConfiguration;

public class EntitySpawnsWithEnchantedMethodProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())
				&& Math.random() < (double) MonstersLevelUpConfigConfiguration.ENCHANTEDCHANCE.get() * MonstersLevelUpModVariables.MapVariables.get(world).netherMultiplier) {
			if (Math.random() < 0.2) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.ALL_DAMAGE_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			} else if (Math.random() < 0.2) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.PROJECTILE_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			} else if (Math.random() < 0.2) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.FIRE_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			} else if (Math.random() < 0.2) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.BLAST_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			} else if (Math.random() < 0.2) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.THORNS,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			}
		}
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())
				&& Math.random() < (double) MonstersLevelUpConfigConfiguration.ENCHANTEDCHANCE.get() * MonstersLevelUpModVariables.MapVariables.get(world).netherMultiplier) {
			if (Math.random() < 0.2) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.ALL_DAMAGE_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			} else if (Math.random() < 0.2) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.PROJECTILE_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			} else if (Math.random() < 0.2) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.FIRE_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			} else if (Math.random() < 0.2) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.BLAST_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			} else if (Math.random() < 0.2) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.THORNS,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			}
		}
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())
				&& Math.random() < (double) MonstersLevelUpConfigConfiguration.ENCHANTEDCHANCE.get() * MonstersLevelUpModVariables.MapVariables.get(world).netherMultiplier) {
			if (Math.random() < 0.2) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.ALL_DAMAGE_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			} else if (Math.random() < 0.2) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.PROJECTILE_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			} else if (Math.random() < 0.2) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.FIRE_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			} else if (Math.random() < 0.2) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.BLAST_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			} else if (Math.random() < 0.2) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.THORNS,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			}
		}
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())
				&& Math.random() < (double) MonstersLevelUpConfigConfiguration.ENCHANTEDCHANCE.get() * MonstersLevelUpModVariables.MapVariables.get(world).netherMultiplier) {
			if (Math.random() < 0.125) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(Enchantments.ALL_DAMAGE_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			} else if (Math.random() < 0.125) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(Enchantments.PROJECTILE_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			} else if (Math.random() < 0.125) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(Enchantments.FIRE_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			} else if (Math.random() < 0.125) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(Enchantments.BLAST_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			}
			if (Math.random() < 0.125) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(Enchantments.THORNS,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			}
			if (Math.random() < 0.125) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(Enchantments.DEPTH_STRIDER,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			}
			if (Math.random() < 0.125) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(Enchantments.FALL_PROTECTION,
						(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
			}
			if (Math.random() < 0.125) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(Enchantments.FROST_WALKER, 1);
			}
		}
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())
				&& Math.random() < (double) MonstersLevelUpConfigConfiguration.ENCHANTEDCHANCE.get() * MonstersLevelUpModVariables.MapVariables.get(world).netherMultiplier) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof BowItem) {
				if (Math.random() < 0.33) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.POWER_ARROWS,
							(int) (Mth.nextInt(RandomSource.create(), 1, 3) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
				}
				if (Math.random() < 0.33) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.FLAMING_ARROWS, 1);
				}
				if (Math.random() < 0.33) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.PUNCH_ARROWS, 1);
				}
			} else {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof TridentItem) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.CHANNELING, 1);
				}
				if (Math.random() < 0.33) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.SHARPNESS,
							(int) (Mth.nextInt(RandomSource.create(), 1, 3) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
				}
				if (Math.random() < 0.33) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.FIRE_ASPECT,
							(int) (Mth.nextInt(RandomSource.create(), 1, 2) + MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel));
				}
				if (Math.random() < 0.33) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.KNOCKBACK, 1);
				}
			}
		}
	}
}
