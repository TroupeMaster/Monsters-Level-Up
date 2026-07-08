package net.mcreator.monsterslevelup.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.monsterslevelup.network.MonstersLevelUpModVariables;
import net.mcreator.monsterslevelup.configuration.MonstersLevelUpConfigConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GrantsAdvancementsToPlayerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:stage_one"))).isDone())
				&& ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("monsters_level_up:stage_1_required")))
						|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("monsters_level_up:stage_1_required")))
						|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("monsters_level_up:stage_1_required")))
						|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("monsters_level_up:stage_1_required"))))) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:stage_one"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
			if (MonstersLevelUpModVariables.MapVariables.get(world).stage < 1) {
				MonstersLevelUpModVariables.MapVariables.get(world).stage = 1;
				MonstersLevelUpModVariables.MapVariables.get(world).syncData(world);
			}
			if (MonstersLevelUpConfigConfiguration.PLAYSTAGESOUND.get() == true) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("playsound " + MonstersLevelUpConfigConfiguration.PLAYSOUNDFORSTAGE.get() + " master @s ~ ~ ~ 1 1 1"));
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.LAVA, x, (y + 0.3), z, Mth.nextInt(RandomSource.create(), 6, 11), 0.5, 1, 0.5, 0.1);
			}
		}
		if (!(entity instanceof ServerPlayer _plr15 && _plr15.level() instanceof ServerLevel && _plr15.getAdvancements().getOrStartProgress(_plr15.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:stage_two"))).isDone())
				&& ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("monsters_level_up:stage_2_required")))
						|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("monsters_level_up:stage_2_required")))
						|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("monsters_level_up:stage_2_required")))
						|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("monsters_level_up:stage_2_required"))))) {
			if (MonstersLevelUpConfigConfiguration.REQUIREPREVIOUSSTAGES.get() == true) {
				if (entity instanceof ServerPlayer _plr25 && _plr25.level() instanceof ServerLevel
						&& _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:stage_one"))).isDone()) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:stage_two"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					if (MonstersLevelUpModVariables.MapVariables.get(world).stage < 2) {
						MonstersLevelUpModVariables.MapVariables.get(world).stage = 2;
						MonstersLevelUpModVariables.MapVariables.get(world).syncData(world);
					}
					if (MonstersLevelUpConfigConfiguration.PLAYSTAGESOUND.get() == true) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("playsound " + MonstersLevelUpConfigConfiguration.PLAYSOUNDFORSTAGE.get() + " master @s ~ ~ ~ 1 1 1"));
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LAVA, x, (y + 0.3), z, Mth.nextInt(RandomSource.create(), 6, 11), 0.5, 1, 0.5, 0.1);
					}
				}
			} else {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:stage_two"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
				if (MonstersLevelUpModVariables.MapVariables.get(world).stage < 2) {
					MonstersLevelUpModVariables.MapVariables.get(world).stage = 2;
					MonstersLevelUpModVariables.MapVariables.get(world).syncData(world);
				}
				if (MonstersLevelUpConfigConfiguration.PLAYSTAGESOUND.get() == true) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("playsound " + MonstersLevelUpConfigConfiguration.PLAYSOUNDFORSTAGE.get() + " master @s ~ ~ ~ 1 1 1"));
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.LAVA, x, (y + 0.3), z, Mth.nextInt(RandomSource.create(), 6, 11), 0.5, 1, 0.5, 0.1);
				}
			}
		}
		if (!(entity instanceof ServerPlayer _plr38 && _plr38.level() instanceof ServerLevel
				&& _plr38.getAdvancements().getOrStartProgress(_plr38.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:stage_three"))).isDone())
				&& (entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation((MonstersLevelUpConfigConfiguration.STAGETHREEREQUIREMENT.get())))) {
			if (MonstersLevelUpConfigConfiguration.REQUIREPREVIOUSSTAGES.get() == true) {
				if (entity instanceof ServerPlayer _plr44 && _plr44.level() instanceof ServerLevel
						&& _plr44.getAdvancements().getOrStartProgress(_plr44.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:stage_two"))).isDone()) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:stage_three"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					MonstersLevelUpModVariables.MapVariables.get(world).netherMultiplier = (double) MonstersLevelUpConfigConfiguration.NETHERVALUE.get();
					MonstersLevelUpModVariables.MapVariables.get(world).syncData(world);
					if (MonstersLevelUpModVariables.MapVariables.get(world).stage < 3) {
						MonstersLevelUpModVariables.MapVariables.get(world).stage = 3;
						MonstersLevelUpModVariables.MapVariables.get(world).syncData(world);
					}
					if (MonstersLevelUpConfigConfiguration.PLAYSTAGESOUND.get() == true) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("playsound " + MonstersLevelUpConfigConfiguration.PLAYSOUNDFORSTAGE.get() + " master @s ~ ~ ~ 1 1 1"));
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LAVA, x, (y + 0.3), z, Mth.nextInt(RandomSource.create(), 6, 11), 0.5, 1, 0.5, 0.1);
					}
				}
			} else {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:stage_three"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
				MonstersLevelUpModVariables.MapVariables.get(world).netherMultiplier = (double) MonstersLevelUpConfigConfiguration.NETHERVALUE.get();
				MonstersLevelUpModVariables.MapVariables.get(world).syncData(world);
				if (MonstersLevelUpModVariables.MapVariables.get(world).stage < 3) {
					MonstersLevelUpModVariables.MapVariables.get(world).stage = 3;
					MonstersLevelUpModVariables.MapVariables.get(world).syncData(world);
				}
				if (MonstersLevelUpConfigConfiguration.PLAYSTAGESOUND.get() == true) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("playsound " + MonstersLevelUpConfigConfiguration.PLAYSOUNDFORSTAGE.get() + " master @s ~ ~ ~ 1 1 1"));
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.LAVA, x, (y + 0.3), z, Mth.nextInt(RandomSource.create(), 6, 11), 0.5, 1, 0.5, 0.1);
				}
			}
		}
		if (!(entity instanceof ServerPlayer _plr59 && _plr59.level() instanceof ServerLevel
				&& _plr59.getAdvancements().getOrStartProgress(_plr59.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:stage_four"))).isDone()) && entity instanceof ServerPlayer _plr60
				&& _plr60.level() instanceof ServerLevel && _plr60.getAdvancements().getOrStartProgress(_plr60.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:end/kill_dragon"))).isDone()) {
			if (MonstersLevelUpConfigConfiguration.REQUIREPREVIOUSSTAGES.get() == true) {
				if (entity instanceof ServerPlayer _plr62 && _plr62.level() instanceof ServerLevel
						&& _plr62.getAdvancements().getOrStartProgress(_plr62.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:stage_three"))).isDone()) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:stage_four"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel = (double) MonstersLevelUpConfigConfiguration.ENCHANTMENTLEVEL.get();
					MonstersLevelUpModVariables.MapVariables.get(world).syncData(world);
					if (MonstersLevelUpModVariables.MapVariables.get(world).stage < 4) {
						MonstersLevelUpModVariables.MapVariables.get(world).stage = 4;
						MonstersLevelUpModVariables.MapVariables.get(world).syncData(world);
					}
					if (MonstersLevelUpConfigConfiguration.PLAYSTAGESOUND.get() == true) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("playsound " + MonstersLevelUpConfigConfiguration.PLAYSOUNDFORSTAGE.get() + " master @s ~ ~ ~ 1 1 1"));
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LAVA, x, (y + 0.3), z, Mth.nextInt(RandomSource.create(), 6, 11), 0.5, 1, 0.5, 0.1);
					}
				}
			} else {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:stage_four"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
				MonstersLevelUpModVariables.MapVariables.get(world).enchantLevel = (double) MonstersLevelUpConfigConfiguration.ENCHANTMENTLEVEL.get();
				MonstersLevelUpModVariables.MapVariables.get(world).syncData(world);
				if (MonstersLevelUpModVariables.MapVariables.get(world).stage < 4) {
					MonstersLevelUpModVariables.MapVariables.get(world).stage = 4;
					MonstersLevelUpModVariables.MapVariables.get(world).syncData(world);
				}
				if (MonstersLevelUpConfigConfiguration.PLAYSTAGESOUND.get() == true) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("playsound " + MonstersLevelUpConfigConfiguration.PLAYSOUNDFORSTAGE.get() + " master @s ~ ~ ~ 1 1 1"));
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.LAVA, x, (y + 0.3), z, Mth.nextInt(RandomSource.create(), 6, 11), 0.5, 1, 0.5, 0.1);
				}
			}
		}
		if (!(entity instanceof ServerPlayer _plr77 && _plr77.level() instanceof ServerLevel && _plr77.getAdvancements().getOrStartProgress(_plr77.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:enchanted"))).isDone())
				&& entity instanceof ServerPlayer _plr78 && _plr78.level() instanceof ServerLevel
				&& _plr78.getAdvancements().getOrStartProgress(_plr78.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:story/enchant_item"))).isDone()) {
			if (MonstersLevelUpConfigConfiguration.REQUIREPREVIOUSSTAGES.get() == true) {
				if (entity instanceof ServerPlayer _plr80 && _plr80.level() instanceof ServerLevel
						&& _plr80.getAdvancements().getOrStartProgress(_plr80.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:stage_three"))).isDone()) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:enchanted"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					MonstersLevelUpModVariables.MapVariables.get(world).enchant = true;
					MonstersLevelUpModVariables.MapVariables.get(world).syncData(world);
					if (MonstersLevelUpConfigConfiguration.PLAYSTAGESOUND.get() == true) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("playsound " + MonstersLevelUpConfigConfiguration.PLAYSOUNDFORSTAGE.get() + " master @s ~ ~ ~ 1 1 1"));
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LAVA, x, (y + 0.3), z, Mth.nextInt(RandomSource.create(), 6, 11), 0.5, 1, 0.5, 0.1);
					}
				}
			} else {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("monsters_level_up:enchanted"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
				MonstersLevelUpModVariables.MapVariables.get(world).enchant = true;
				MonstersLevelUpModVariables.MapVariables.get(world).syncData(world);
				if (MonstersLevelUpConfigConfiguration.PLAYSTAGESOUND.get() == true) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("playsound " + MonstersLevelUpConfigConfiguration.PLAYSOUNDFORSTAGE.get() + " master @s ~ ~ ~ 1 1 1"));
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.LAVA, x, (y + 0.3), z, Mth.nextInt(RandomSource.create(), 6, 11), 0.5, 1, 0.5, 0.1);
				}
			}
		}
	}
}
