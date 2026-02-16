package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.monsterslevelup.init.MonstersLevelUpModItems;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class ItemAttributesSetProcedure {
	@SubscribeEvent
	public static void addAttributeModifier(ItemAttributeModifierEvent event) {
		execute(event, event.getItemStack());
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
			if (itemstack.getItem() == MonstersLevelUpModItems.COMMANDER_CUTLASS.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(), (new AttributeModifier(UUID.fromString("c23302bb-52c8-43aa-a404-19f0bb9d1602"), "cutlassRange", 0.65, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == MonstersLevelUpModItems.GREATSWORD_OF_THE_DAMNEDS.get()) {
				_event.addModifier(ForgeMod.ENTITY_REACH.get(), (new AttributeModifier(UUID.fromString("75ffbc21-cb54-478c-b358-b3216b84855c"), "greatswordRange", 0.4, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == MonstersLevelUpModItems.BREACHING_HAMMER.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK, (new AttributeModifier(UUID.fromString("daaa28ac-5c88-419b-a161-72de24a4d620"), "hammerKnockback", 1, AttributeModifier.Operation.ADDITION)));
			}
		}
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.OFFHAND) {
			if (itemstack.getItem() == MonstersLevelUpModItems.GILDED_COMMANDER_SHIELD.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE,
						(new AttributeModifier(UUID.fromString("acb04f27-db32-4826-b500-37ec32bc6f90"), "gildedKnockback", 0.1, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == MonstersLevelUpModItems.HEAVY_SHIELD.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS, (new AttributeModifier(UUID.fromString("c3911250-47df-416f-a041-0033569ff747"), "heavyToughness", 4, AttributeModifier.Operation.ADDITION)));
			}
		}
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.HEAD) {
			if (itemstack.getItem() == MonstersLevelUpModItems.GUILDED_COMMANDER_HELMET.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH, (new AttributeModifier(UUID.fromString("e0f0d835-91a7-4954-af17-0217d4c835da"), "gildedHelmetHealth", 4, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == MonstersLevelUpModItems.JUGGERNAUT_HELMET.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("b3760679-c6ea-43d6-ae38-ee3173f1fb25"), "juggernautHelmet", (-0.01), AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == MonstersLevelUpModItems.WITHER_HELMET.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED, (new AttributeModifier(UUID.fromString("d46c0aa7-c35b-4bfe-866b-265c203f5984"), "witherHelmet", 0.01, AttributeModifier.Operation.ADDITION)));
			}
		}
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.CHEST) {
			if (itemstack.getItem() == MonstersLevelUpModItems.GUILDED_COMMANDER_CHESTPLATE.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH, (new AttributeModifier(UUID.fromString("a875a7be-1ae4-43aa-b630-8b0fa149586d"), "gildedHealth", 6, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == MonstersLevelUpModItems.JUGGERNAUT_CHESTPLATE.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("599f1e07-662d-45a3-a83b-49a4c97c4d74"), "juggernautChestplate", (-0.01), AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == MonstersLevelUpModItems.WITHER_CHESTPLATE.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED, (new AttributeModifier(UUID.fromString("8bb2ded6-a360-4e1d-9fba-ff8222aeaa10"), "witherChestplate", 0.01, AttributeModifier.Operation.ADDITION)));
			}
		}
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.LEGS) {
			if (itemstack.getItem() == MonstersLevelUpModItems.GUILDED_COMMANDER_LEGGINGS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED, (new AttributeModifier(UUID.fromString("00b3162b-dc4f-459b-8e27-cf01c5a39040"), "gildedSpeed", 0.025, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == MonstersLevelUpModItems.JUGGERNAUT_LEGGINGS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("4a7bbad0-38d5-434f-a4c2-5a0b961f42d8"), "juggernautLeggings", (-0.01), AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == MonstersLevelUpModItems.WITHER_LEGGINGS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED, (new AttributeModifier(UUID.fromString("c3d8194e-781f-4fa4-be8b-0d22ddd23013"), "witherLeggings", 0.01, AttributeModifier.Operation.ADDITION)));
			}
		}
		if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.FEET) {
			if (itemstack.getItem() == MonstersLevelUpModItems.GUILDED_COMMANDER_BOOTS.get()) {
				_event.addModifier(ForgeMod.STEP_HEIGHT_ADDITION.get(), (new AttributeModifier(UUID.fromString("b37feebe-e777-45dc-9caa-c590363370b3"), "gildedStep", 0.5, AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == MonstersLevelUpModItems.JUGGERNAUT_BOOTS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED,
						(new AttributeModifier(UUID.fromString("10481933-5fa3-4c8b-a8bc-2d4ba764090a"), "juggernautBoots", (-0.01), AttributeModifier.Operation.ADDITION)));
			}
			if (itemstack.getItem() == MonstersLevelUpModItems.WITHER_BOOTS.get()) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED, (new AttributeModifier(UUID.fromString("2e6edbd5-1ec1-4ef7-9734-73fbda69b9b1"), "witherBoots", 0.01, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(ForgeMod.STEP_HEIGHT_ADDITION.get(), (new AttributeModifier(UUID.fromString("9bd1b33b-a765-4d45-8d6a-9632864a7f37"), "witherBootsStep", 0.5, AttributeModifier.Operation.ADDITION)));
			}
		}
	}
}
