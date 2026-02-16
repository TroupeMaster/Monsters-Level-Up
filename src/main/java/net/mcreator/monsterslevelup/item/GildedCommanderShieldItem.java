
package net.mcreator.monsterslevelup.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.monsterslevelup.procedures.GildedCommanderGearDescriptionProcedure;

import java.util.List;

public class GildedCommanderShieldItem extends ShieldItem {
	public GildedCommanderShieldItem() {
		super(new Item.Properties().durability(0).fireResistant());
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		Entity entity = itemstack.getEntityRepresentation();
		list.add(Component.literal(GildedCommanderGearDescriptionProcedure.execute()));
	}
}
