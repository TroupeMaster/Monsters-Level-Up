
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monsterslevelup.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.monsterslevelup.entity.ZombieDolphinEntity;
import net.mcreator.monsterslevelup.entity.WitherSkeletonHorseEntity;
import net.mcreator.monsterslevelup.entity.TamedWitherSkeletonHorseEntity;
import net.mcreator.monsterslevelup.entity.SpiderMotherEntity;
import net.mcreator.monsterslevelup.entity.LightningRodCreeperEntity;
import net.mcreator.monsterslevelup.MonstersLevelUpMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MonstersLevelUpModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MonstersLevelUpMod.MODID);
	public static final RegistryObject<EntityType<ZombieDolphinEntity>> ZOMBIE_DOLPHIN = register("zombie_dolphin",
			EntityType.Builder.<ZombieDolphinEntity>of(ZombieDolphinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ZombieDolphinEntity::new)

					.sized(0.9f, 0.6f));
	public static final RegistryObject<EntityType<LightningRodCreeperEntity>> LIGHTNING_ROD_CREEPER = register("lightning_rod_creeper",
			EntityType.Builder.<LightningRodCreeperEntity>of(LightningRodCreeperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LightningRodCreeperEntity::new)

					.sized(0.6f, 1.7f));
	public static final RegistryObject<EntityType<SpiderMotherEntity>> SPIDER_MOTHER = register("spider_mother",
			EntityType.Builder.<SpiderMotherEntity>of(SpiderMotherEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SpiderMotherEntity::new)

					.sized(1.5f, 1.5f));
	public static final RegistryObject<EntityType<WitherSkeletonHorseEntity>> WITHER_SKELETON_HORSE = register("wither_skeleton_horse", EntityType.Builder.<WitherSkeletonHorseEntity>of(WitherSkeletonHorseEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WitherSkeletonHorseEntity::new).fireImmune().sized(1.3975f, 1.6f));
	public static final RegistryObject<EntityType<TamedWitherSkeletonHorseEntity>> TAMED_WITHER_SKELETON_HORSE = register("tamed_wither_skeleton_horse",
			EntityType.Builder.<TamedWitherSkeletonHorseEntity>of(TamedWitherSkeletonHorseEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(TamedWitherSkeletonHorseEntity::new).fireImmune().sized(1.3975f, 1.6f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ZombieDolphinEntity.init();
			LightningRodCreeperEntity.init();
			SpiderMotherEntity.init();
			WitherSkeletonHorseEntity.init();
			TamedWitherSkeletonHorseEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(ZOMBIE_DOLPHIN.get(), ZombieDolphinEntity.createAttributes().build());
		event.put(LIGHTNING_ROD_CREEPER.get(), LightningRodCreeperEntity.createAttributes().build());
		event.put(SPIDER_MOTHER.get(), SpiderMotherEntity.createAttributes().build());
		event.put(WITHER_SKELETON_HORSE.get(), WitherSkeletonHorseEntity.createAttributes().build());
		event.put(TAMED_WITHER_SKELETON_HORSE.get(), TamedWitherSkeletonHorseEntity.createAttributes().build());
	}
}
