
package net.mcreator.monsterslevelup.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.monsterslevelup.procedures.WitherSkeletonTrapHorseSpawnEggRightclickedOnBlockProcedure;

public class WitherSkeletonTrapHorseSpawnEggItem extends Item {
	public WitherSkeletonTrapHorseSpawnEggItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		WitherSkeletonTrapHorseSpawnEggRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
