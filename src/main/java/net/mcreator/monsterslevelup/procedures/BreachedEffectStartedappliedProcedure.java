package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.UUID;

public class BreachedEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.break_block")), SoundSource.NEUTRAL, (float) 0.5, (float) 0.8);
			} else {
				_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.break_block")), SoundSource.NEUTRAL, (float) 0.5, (float) 0.8, false);
			}
		}
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getModifier(UUID.fromString("958f1dff-e041-4d16-9579-f8523ee9cf5f")) != null)) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).hasModifier((new AttributeModifier(UUID.fromString("958f1dff-e041-4d16-9579-f8523ee9cf5f"), "breachedArmor",
					(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getValue() * (-0.4)), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).addTransientModifier((new AttributeModifier(UUID.fromString("958f1dff-e041-4d16-9579-f8523ee9cf5f"), "breachedArmor",
						(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getValue() * (-0.4)), AttributeModifier.Operation.ADDITION)));
		}
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).getModifier(UUID.fromString("88f710c9-72f6-4775-ac55-fa91db91e7f9")) != null)) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).hasModifier((new AttributeModifier(UUID.fromString("88f710c9-72f6-4775-ac55-fa91db91e7f9"), "breachedTough",
					(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).getValue() * (-0.4)), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).addTransientModifier((new AttributeModifier(UUID.fromString("88f710c9-72f6-4775-ac55-fa91db91e7f9"), "breachedTough",
						(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).getValue() * (-0.4)), AttributeModifier.Operation.ADDITION)));
		}
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getModifier(UUID.fromString("3123bcbb-6f03-4b19-a6dc-cb231db5d437")) != null)) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).hasModifier((new AttributeModifier(UUID.fromString("3123bcbb-6f03-4b19-a6dc-cb231db5d437"), "breachedKnockback",
					(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).getValue() * (-0.84)), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).addTransientModifier((new AttributeModifier(UUID.fromString("3123bcbb-6f03-4b19-a6dc-cb231db5d437"), "breachedKnockback",
						(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).getValue() * (-0.84)), AttributeModifier.Operation.ADDITION)));
		}
	}
}
