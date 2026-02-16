package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.monsterslevelup.init.MonstersLevelUpModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class WitherArmorDescriptionProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getEntity(), event.getItemStack(), event.getToolTip());
	}

	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		execute(null, entity, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		if (itemstack.getItem() == MonstersLevelUpModItems.WITHER_HELMET.get() || itemstack.getItem() == MonstersLevelUpModItems.WITHER_CHESTPLATE.get() || itemstack.getItem() == MonstersLevelUpModItems.WITHER_LEGGINGS.get()
				|| itemstack.getItem() == MonstersLevelUpModItems.WITHER_BOOTS.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == MonstersLevelUpModItems.WITHER_HELMET.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstersLevelUpModItems.WITHER_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == MonstersLevelUpModItems.WITHER_LEGGINGS.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == MonstersLevelUpModItems.WITHER_BOOTS.get()) {
				tooltip.add(Component.literal(("\u00A79" + Component.translatable("item.monsters_level_up.wither_armor.desc_complete").getString())));
			} else {
				tooltip.add(Component.literal(("\u00A77" + Component.translatable("item.monsters_level_up.wither_armor.desc").getString())));
			}
		}
	}
}
