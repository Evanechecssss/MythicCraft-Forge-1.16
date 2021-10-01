package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.entities.*;
import com.masterquentus.mythiccraft.entities.vampire.VampireEvokerEntity;
import com.masterquentus.mythiccraft.entities.vampire.VampirePillagerEntity;
import com.masterquentus.mythiccraft.entities.vampire.VampireVindicatorEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			MythicCraft.MOD_ID);

	public static final RegistryObject<EntityType<GoblinEntity>> GOBLIN_ENTITY = ENTITY_TYPES.register("goblin_entity",
			() -> EntityType.Builder.<GoblinEntity>of(GoblinEntity::new, EntityClassification.CREATURE)
					.sized(1.3F, 0.9F).build(new ResourceLocation(MythicCraft.MOD_ID, "goblin_entity").toString()));
	public static final RegistryObject<EntityType<BasiliskEntity>> BASILISK_ENTITY = ENTITY_TYPES
			.register("basilisk_entity",
					() -> EntityType.Builder.<BasiliskEntity>of(BasiliskEntity::new, EntityClassification.MONSTER)
							.sized(2.6F, 0.9F)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "basilisk_entity").toString()));
	public static final RegistryObject<EntityType<UnicornEntity>> UNICORN_ENTITY = ENTITY_TYPES
			.register("unicorn_entity",
					() -> EntityType.Builder.<UnicornEntity>of(UnicornEntity::new, EntityClassification.CREATURE)
							.sized(2.6F, 0.9F)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "unicorn_entity").toString()));
	public static final RegistryObject<EntityType<SirenEntity>> SIREN_ENTITY = ENTITY_TYPES.register("siren_entity",
			() -> EntityType.Builder.<SirenEntity>of(SirenEntity::new, EntityClassification.WATER_CREATURE)
					.sized(0.8F, 2.0F).build(new ResourceLocation(MythicCraft.MOD_ID, "siren_entity").toString()));
	public static final RegistryObject<EntityType<FairyEntity>> FAIRY_ENTITY = ENTITY_TYPES.register("fairy_entity",
            () -> EntityType.Builder.<FairyEntity>of(FairyEntity::new, EntityClassification.CREATURE)
                    .sized(0.8F, 2.0F).build(new ResourceLocation(MythicCraft.MOD_ID, "fairy_entity").toString()));
    public static final RegistryObject<EntityType<LilithEntity>> LILITH_ENTITY = ENTITY_TYPES.register("lilith_entity",
            () -> EntityType.Builder.<LilithEntity>of(LilithEntity::new, EntityClassification.CREATURE)
                    .sized(0.8F, 2.0F).build(new ResourceLocation(MythicCraft.MOD_ID, "lilith_entity").toString()));

    public static final RegistryObject<EntityType<MobSummonProjectile>> MOB_SUMMON = ENTITY_TYPES.register("mob_summon",
            () -> EntityType.Builder.<MobSummonProjectile>of(MobSummonProjectile::new, EntityClassification.MISC)
                    .sized(0.5F, 0.5F).build(new ResourceLocation(MythicCraft.MOD_ID, "mob_summon").toString()));


    public static final RegistryObject<EntityType<VampireEvokerEntity>> EVOKER = ENTITY_TYPES.register("evoker_entity",
            () -> EntityType.Builder.<VampireEvokerEntity>of(VampireEvokerEntity::new, EntityClassification.MONSTER)
                    .sized(1F, 2F).build(new ResourceLocation(MythicCraft.MOD_ID, "evoker_entity").toString()));
    public static final RegistryObject<EntityType<VampirePillagerEntity>> PILLAGER = ENTITY_TYPES.register("pillager_entity",
            () -> EntityType.Builder.<VampirePillagerEntity>of(VampirePillagerEntity::new, EntityClassification.MONSTER)
                    .sized(1F, 2F).build(new ResourceLocation(MythicCraft.MOD_ID, "pillager_entity").toString()));
    public static final RegistryObject<EntityType<VampireVindicatorEntity>> VINDICATOR = ENTITY_TYPES.register("vindicator_entity",
            () -> EntityType.Builder.<VampireVindicatorEntity>of(VampireVindicatorEntity::new, EntityClassification.MONSTER)
                    .sized(1F, 2F).build(new ResourceLocation(MythicCraft.MOD_ID, "vindicator_entity").toString()));


}
