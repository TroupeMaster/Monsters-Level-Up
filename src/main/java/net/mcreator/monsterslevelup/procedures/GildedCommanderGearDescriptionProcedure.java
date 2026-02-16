package net.mcreator.monsterslevelup.procedures;

import net.minecraft.network.chat.Component;

public class GildedCommanderGearDescriptionProcedure {
	public static String execute() {
		return "\u00A77" + Component.translatable("item.monsters_level_up.guilded_commander_armor.desc").getString();
	}
}
