package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.monsterslevelup.init.MonstersLevelUpModMobEffects;
import net.mcreator.monsterslevelup.configuration.MonstersLevelUpConfigConfiguration;

public class AcidVenomOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("acidVenomTick") >= 10) {
			entity.getPersistentData().putDouble("acidVenomTick", 0);
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)),
					(float) (1 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstersLevelUpModMobEffects.ACID_VENOM.get()) ? _livEnt.getEffect(MonstersLevelUpModMobEffects.ACID_VENOM.get()).getAmplifier() : 0) / 2));
			if (Math.random() < 0.2) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_level_up:generic.acid_venom.ambient")), SoundSource.NEUTRAL,
								(float) 0.33, (float) Mth.nextDouble(RandomSource.create(), 0.88, 1.12));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_level_up:generic.acid_venom.ambient")), SoundSource.NEUTRAL, (float) 0.33,
								(float) Mth.nextDouble(RandomSource.create(), 0.88, 1.12), false);
					}
				}
				if (MonstersLevelUpConfigConfiguration.ACIDVENOMREDUCEDURABILITY.get() == true) {
					if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) && Math.random() < 0.25) {
						{
							ItemStack _ist = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY);
							if (_ist.hurt(Mth.nextInt(RandomSource.create(), 1, 2), RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					} else if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) && Math.random() < 0.25) {
						{
							ItemStack _ist = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY);
							if (_ist.hurt(Mth.nextInt(RandomSource.create(), 1, 2), RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					} else if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) && Math.random() < 0.25) {
						{
							ItemStack _ist = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY);
							if (_ist.hurt(Mth.nextInt(RandomSource.create(), 1, 2), RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					} else if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) && Math.random() < 0.25) {
						{
							ItemStack _ist = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY);
							if (_ist.hurt(Mth.nextInt(RandomSource.create(), 1, 2), RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
				}
			}
		} else {
			entity.getPersistentData().putDouble("acidVenomTick", (entity.getPersistentData().getDouble("acidVenomTick") + 1));
		}
	}
}
