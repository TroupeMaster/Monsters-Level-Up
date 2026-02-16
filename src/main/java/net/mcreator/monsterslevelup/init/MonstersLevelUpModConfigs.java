package net.mcreator.monsterslevelup.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.monsterslevelup.configuration.MonstersLevelUpConfigConfiguration;
import net.mcreator.monsterslevelup.MonstersLevelUpMod;

@Mod.EventBusSubscriber(modid = MonstersLevelUpMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MonstersLevelUpModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MonstersLevelUpConfigConfiguration.SPEC, "Monsters Level Up Config File.toml");
		});
	}
}
