package net.mcreator.monsterslevelup.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class MonstersLevelUpConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> PLAYSTAGESOUND;
	public static final ForgeConfigSpec.ConfigValue<String> PLAYSOUNDFORSTAGE;
	public static final ForgeConfigSpec.ConfigValue<Double> NETHERVALUE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> MOBSSETONFIRE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> MOBSUSESHIELDS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ACIDVENOMREDUCEDURABILITY;
	public static final ForgeConfigSpec.ConfigValue<Double> SKELETONCOMMANDERCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> SKELETONCOMMANDERSTAGE;
	public static final ForgeConfigSpec.ConfigValue<Double> ENCHANTMENTLEVEL;
	public static final ForgeConfigSpec.ConfigValue<Double> ZOMBIEJUGGERNAUTCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> ZOMBIEJUGGERNAUTSTAGE;
	public static final ForgeConfigSpec.ConfigValue<Double> WITHERSKELETONTRAPCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> STAGE0GEARCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ALLOWPREVIOUSGEAR;
	public static final ForgeConfigSpec.ConfigValue<Double> STAGE1GEARCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> STAGE2GEARCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> ENCHANTEDCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> STAGE3GEARCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> EFFECTCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> SPIDERPUTINCOBWEB;
	public static final ForgeConfigSpec.ConfigValue<Boolean> MOBRIDESPIDERS;
	public static final ForgeConfigSpec.ConfigValue<Double> MOBRIDESPIDERSCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> MOBRIDESPIDERSSTAGE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> CREEPERSSEEKSPIDERS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SKELETONSSWITCHTOMELEE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> CREEPERSDISABLESHIELDS;
	public static final ForgeConfigSpec.ConfigValue<Double> MOBSCALLFORHELPSTAGE;
	public static final ForgeConfigSpec.ConfigValue<Double> SPIDERAPPLYACIDVENOM;
	static {
		BUILDER.push("Misc");
		PLAYSTAGESOUND = BUILDER.comment("If a sound should be played when a player enters a new stage").define("Play stage sound", true);
		PLAYSOUNDFORSTAGE = BUILDER.comment("The sound that should be player when a player enters a new stage").define("Play sound for stage", "entity.ender_dragon.growl");
		NETHERVALUE = BUILDER.comment("The multiplication value that is set once the player enters The Nether (this value increases probability for mobs to get stronger gear)").define("Nether value", (double) 1.64);
		MOBSSETONFIRE = BUILDER.comment("If mobs can set targets on fire if they have a flint and steel/fire charge in their hands").define("Mobs can set on fire", true);
		MOBSUSESHIELDS = BUILDER.define("Mobs use shields", true);
		ACIDVENOMREDUCEDURABILITY = BUILDER.define("Acid Venom reduces armor durability", true);
		SKELETONCOMMANDERCHANCE = BUILDER.define("Skeleton Commander spawn chance", (double) 0.01);
		SKELETONCOMMANDERSTAGE = BUILDER.comment("Starting at what stage do skeleton commanders spawn (set to -1 to disable)").define("Skeleton Commander spawn stage", (double) 3);
		ENCHANTMENTLEVEL = BUILDER.comment("The increase in the level of enchantments when at stage 4").define("Enchantment level", (double) 1);
		ZOMBIEJUGGERNAUTCHANCE = BUILDER.define("Zombie Juggernaut spawn chance", (double) 0.01);
		ZOMBIEJUGGERNAUTSTAGE = BUILDER.comment("Starting at what stage do zombie juggernauts spawn (set to -1 to disable)").define("Zombie Juggernaut spawn stage", (double) 3);
		WITHERSKELETONTRAPCHANCE = BUILDER.define("Wither Skeleton Trap spawn chance", (double) 0.04);
		BUILDER.pop();
		BUILDER.push("Mob Gear");
		STAGE0GEARCHANCE = BUILDER.define("Stage 0 gear chance", (double) 0.2);
		ALLOWPREVIOUSGEAR = BUILDER.comment("If gear from previous stages should be allowed to be worn in other stages too").define("Allow previous gear", true);
		STAGE1GEARCHANCE = BUILDER.define("Stage 1 gear chance", (double) 0.09);
		STAGE2GEARCHANCE = BUILDER.define("Stage 2 gear chance", (double) 0.04);
		ENCHANTEDCHANCE = BUILDER.comment("The chance for mobs to have enchanted gear").define("Enchanted chance", (double) 0.14);
		STAGE3GEARCHANCE = BUILDER.define("Stage 3 gear chance", (double) 0.05);
		EFFECTCHANCE = BUILDER.comment("The chance for a mob to spawn with a random positive effect").define("Effect chance", (double) 0.08);
		BUILDER.pop();
		BUILDER.push("Mob Behaviour");
		SPIDERPUTINCOBWEB = BUILDER.comment("Starting at what stage do spiders put players in cobwebs (set to -1 to disable)").define("Spider put in cobweb stage", (double) 1);
		MOBRIDESPIDERS = BUILDER.define("Creepers/Skeletons ride spiders on spawn", true);
		MOBRIDESPIDERSCHANCE = BUILDER.define("Creepers/Skeletons ride spiders on spawn chance", (double) 0.08);
		MOBRIDESPIDERSSTAGE = BUILDER.comment("At what stage do mobs start riding spiders").define("Creepers/Skeletons ride spiders on spawn stage", (double) 1);
		CREEPERSSEEKSPIDERS = BUILDER.define("Creepers seek spiders", true);
		SKELETONSSWITCHTOMELEE = BUILDER.define("Skeletons switch to melee", true);
		CREEPERSDISABLESHIELDS = BUILDER.define("Creepers disable shields", true);
		MOBSCALLFORHELPSTAGE = BUILDER.comment("The stage at which mobs begin calling for help (set to -1 to disable)").define("Mobs call for help stage", (double) 2);
		SPIDERAPPLYACIDVENOM = BUILDER.comment("Starting at what stage do spiders apply the Acid Venom effect (set to -1 to disable)").define("Spiders apply acid venom", (double) 3);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
