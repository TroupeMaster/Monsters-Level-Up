package net.mcreator.monsterslevelup.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.monsterslevelup.network.MonstersLevelUpModVariables;
import net.mcreator.monsterslevelup.configuration.MonstersLevelUpConfigConfiguration;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetStageWithCommandProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if ((StringArgumentType.getString(arguments, "type")).equals("setstage")) {
			if (DoubleArgumentType.getDouble(arguments, "stage") >= 0) {
				if (DoubleArgumentType.getDouble(arguments, "stage") == 3) {
					MonstersLevelUpModVariables.MapVariables.get(world).stage = DoubleArgumentType.getDouble(arguments, "stage");
					MonstersLevelUpModVariables.MapVariables.get(world).syncData(world);
					MonstersLevelUpModVariables.MapVariables.get(world).netherMultiplier = (double) MonstersLevelUpConfigConfiguration.NETHERVALUE.get();
					MonstersLevelUpModVariables.MapVariables.get(world).syncData(world);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("Successfully set stage to " + DoubleArgumentType.getDouble(arguments, "stage"))), false);
				} else {
					MonstersLevelUpModVariables.MapVariables.get(world).stage = DoubleArgumentType.getDouble(arguments, "stage");
					MonstersLevelUpModVariables.MapVariables.get(world).syncData(world);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("Successfully set stage to " + DoubleArgumentType.getDouble(arguments, "stage"))), false);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Stage must be a value between 0 and 2"), false);
			}
		} else if ((StringArgumentType.getString(arguments, "type")).equals("getstage")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Current stage: " + MonstersLevelUpModVariables.MapVariables.get(world).stage)), false);
		} else if ((StringArgumentType.getString(arguments, "type")).isEmpty()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Invalid input."), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Valid inputs are:"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("-setstage"), false);
		}
	}
}
