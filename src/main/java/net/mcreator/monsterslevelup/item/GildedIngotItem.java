
package net.mcreator.monsterslevelup.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class GildedIngotItem extends Item {
	public GildedIngotItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
