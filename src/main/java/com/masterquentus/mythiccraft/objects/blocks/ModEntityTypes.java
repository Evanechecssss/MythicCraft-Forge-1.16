package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.entities.BasiliskEntity;
import com.masterquentus.mythiccraft.entities.FairyEntity;
import com.masterquentus.mythiccraft.entities.GoblinEntity;
import com.masterquentus.mythiccraft.entities.LilithEntity;
import com.masterquentus.mythiccraft.entities.SirenEntity;
import com.masterquentus.mythiccraft.entities.UnicornEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
			MythicCraft.MOD_ID);

	public static final RegistryObject<EntityType<GoblinEntity>> GOBLIN_ENTITY = ENTITY_TYPES.register("goblin_entity",
			() -> EntityType.Builder.<GoblinEntity>create(GoblinEntity::new, EntityClassification.CREATURE)
					.size(1.3F, 0.9F).build(new ResourceLocation(MythicCraft.MOD_ID, "goblin_entity").toString()));
	public static final RegistryObject<EntityType<BasiliskEntity>> BASILISK_ENTITY = ENTITY_TYPES
			.register("basilisk_entity",
					() -> EntityType.Builder.<BasiliskEntity>create(BasiliskEntity::new, EntityClassification.MONSTER)
							.size(2.6F, 0.9F)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "basilisk_entity").toString()));
	public static final RegistryObject<EntityType<UnicornEntity>> UNICORN_ENTITY = ENTITY_TYPES
			.register("unicorn_entity",
					() -> EntityType.Builder.<UnicornEntity>create(UnicornEntity::new, EntityClassification.CREATURE)
							.size(2.6F, 0.9F)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "unicorn_entity").toString()));
	public static final RegistryObject<EntityType<SirenEntity>> SIREN_ENTITY = ENTITY_TYPES.register("siren_entity",
			() -> EntityType.Builder.<SirenEntity>create(SirenEntity::new, EntityClassification.WATER_CREATURE)
					.size(0.8F, 2.0F).build(new ResourceLocation(MythicCraft.MOD_ID, "siren_entity").toString()));
	public static final RegistryObject<EntityType<FairyEntity>> FAIRY_ENTITY = ENTITY_TYPES.register("fairy_entity",
			() -> EntityType.Builder.<FairyEntity>create(FairyEntity::new, EntityClassification.CREATURE)
					.size(0.8F, 2.0F).build(new ResourceLocation(MythicCraft.MOD_ID, "fairy_entity").toString()));
	public static final RegistryObject<EntityType<LilithEntity>> LILITH_ENTITY = ENTITY_TYPES.register("lilith_entity",
			() -> EntityType.Builder.<LilithEntity>create(LilithEntity::new, EntityClassification.CREATURE)
					.size(0.8F, 2.0F).build(new ResourceLocation(MythicCraft.MOD_ID, "lilith_entity").toString()));
}
