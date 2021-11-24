package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.entities.BasiliskEntity;
import com.masterquentus.mythiccraft.entities.FairyEntity;
import com.masterquentus.mythiccraft.entities.GoblinEntity;
import com.masterquentus.mythiccraft.entities.LilithEntity;
import com.masterquentus.mythiccraft.entities.MobSummonProjectile;
import com.masterquentus.mythiccraft.entities.SirenEntity;
import com.masterquentus.mythiccraft.entities.UnderwaterSlimeEntity;
import com.masterquentus.mythiccraft.entities.UnicornEntity;
import com.masterquentus.mythiccraft.entities.WendigoEntity;
import com.masterquentus.mythiccraft.entities.boats.ModBoatEntity;
import com.masterquentus.mythiccraft.entities.vampire.VampireEvokerEntity;
import com.masterquentus.mythiccraft.entities.vampire.VampirePiglinEntity;
import com.masterquentus.mythiccraft.entities.vampire.VampirePillagerEntity;
import com.masterquentus.mythiccraft.entities.vampire.VampireVindicatorEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

	public static DeferredRegister<EntityType<?>> ENTITY_TYPES
			= DeferredRegister.create(ForgeRegistries.ENTITIES, MythicCraft.MOD_ID);


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
			() -> EntityType.Builder.<FairyEntity>of(FairyEntity::new, EntityClassification.CREATURE).sized(0.8F, 2.0F)
					.build(new ResourceLocation(MythicCraft.MOD_ID, "fairy_entity").toString()));
	public static final RegistryObject<EntityType<LilithEntity>> LILITH_ENTITY = ENTITY_TYPES.register("lilith_entity",
			() -> EntityType.Builder.<LilithEntity>of(LilithEntity::new, EntityClassification.CREATURE)
					.sized(0.8F, 2.0F).build(new ResourceLocation(MythicCraft.MOD_ID, "lilith_entity").toString()));
	public static final RegistryObject<EntityType<MobSummonProjectile>> MOB_SUMMON = ENTITY_TYPES.register("mob_summon",
			() -> EntityType.Builder.<MobSummonProjectile>of(MobSummonProjectile::new, EntityClassification.MISC)
					.sized(0.5F, 0.5F).build(new ResourceLocation(MythicCraft.MOD_ID, "mob_summon").toString()));
	public static final RegistryObject<EntityType<VampireEvokerEntity>> EVOKER = ENTITY_TYPES.register("evoker_entity",
			() -> EntityType.Builder.<VampireEvokerEntity>of(VampireEvokerEntity::new, EntityClassification.MONSTER)
					.sized(1F, 2F).build(new ResourceLocation(MythicCraft.MOD_ID, "evoker_entity").toString()));
	public static final RegistryObject<EntityType<VampirePillagerEntity>> PILLAGER = ENTITY_TYPES.register(
			"pillager_entity",
			() -> EntityType.Builder.<VampirePillagerEntity>of(VampirePillagerEntity::new, EntityClassification.MONSTER)
					.sized(1F, 2F).build(new ResourceLocation(MythicCraft.MOD_ID, "pillager_entity").toString()));
	public static final RegistryObject<EntityType<VampireVindicatorEntity>> VINDICATOR = ENTITY_TYPES.register(
			"vindicator_entity",
			() -> EntityType.Builder
					.<VampireVindicatorEntity>of(VampireVindicatorEntity::new, EntityClassification.MONSTER)
					.sized(1F, 2F).build(new ResourceLocation(MythicCraft.MOD_ID, "vindicator_entity").toString()));
	public static final RegistryObject<EntityType<UnderwaterSlimeEntity>> UNDERWATER_SLIME = ENTITY_TYPES
			.register("underwater_slime",
					() -> EntityType.Builder.<UnderwaterSlimeEntity>of(UnderwaterSlimeEntity::new, EntityClassification.MONSTER)
							.sized(1F, 1F)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "underwater_slime").toString()));
	public static final RegistryObject<EntityType<VampirePiglinEntity>> PIGLIN = ENTITY_TYPES.register("piglin_entity",
			() -> EntityType.Builder.<VampirePiglinEntity>of(VampirePiglinEntity::new, EntityClassification.MONSTER)
					.sized(1F, 2F).build(new ResourceLocation(MythicCraft.MOD_ID, "piglin_entity").toString()));
	public static final RegistryObject<EntityType<WendigoEntity>> WENDIGO_ENTITY = ENTITY_TYPES.register("wendigo",
			() -> EntityType.Builder.<WendigoEntity>of(WendigoEntity::new, EntityClassification.CREATURE)
					.sized(0.8F, 2.0F).build(new ResourceLocation(MythicCraft.MOD_ID, "wendigo").toString()));

	public static final RegistryObject<EntityType<ModBoatEntity>> BLOODOAK_BOAT =
			ENTITY_TYPES.register("bloodoak_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "bloodoak_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> WHITEOAK_BOAT =
			ENTITY_TYPES.register("whiteoak_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "whiteoak_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> SILVERWOOD_BOAT =
			ENTITY_TYPES.register("silverwood_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "silverwood_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> WITCHWOOD_BOAT =
			ENTITY_TYPES.register("witchwood_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "witchwood_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> ALDER_BOAT =
			ENTITY_TYPES.register("alder_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "alder_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> HAWTHORN_BOAT =
			ENTITY_TYPES.register("hawthorn_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "hawthorn_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> ROWAN_BOAT =
			ENTITY_TYPES.register("rowan_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "rowan_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> WILLOW_BOAT =
			ENTITY_TYPES.register("willow_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "willow_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> BEECH_BOAT =
			ENTITY_TYPES.register("beech_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "beech_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> ASH_BOAT =
			ENTITY_TYPES.register("ash_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "ash_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> BLACKTHORN_BOAT =
			ENTITY_TYPES.register("blackthorn_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "blackthorn_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> CEDAR_BOAT =
			ENTITY_TYPES.register("cedar_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "cedar_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> ELDER_BOAT =
			ENTITY_TYPES.register("elder_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "elder_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> JUNIPER_BOAT =
			ENTITY_TYPES.register("juniper_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "juniper_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> WITCHHAZEL_BOAT =
			ENTITY_TYPES.register("witchhazel_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "witchhazel_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> YEW_BOAT =
			ENTITY_TYPES.register("yew_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "yew_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> INFESTED_BOAT =
			ENTITY_TYPES.register("infested_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "infested_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> CHARRED_BOAT =
			ENTITY_TYPES.register("charred_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "charred_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> ICY_BOAT =
			ENTITY_TYPES.register("icy_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "icy_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> TWISTED_BOAT =
			ENTITY_TYPES.register("twisted_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "twisted_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> DISTORTED_BOAT =
			ENTITY_TYPES.register("distorted_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "distorted_boat").toString()));
	public static final RegistryObject<EntityType<ModBoatEntity>> HELLBARK_BOAT =
			ENTITY_TYPES.register("hellbark_boat",
					() -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
							EntityClassification.MISC).sized(0.5f, 0.5f)
							.build(new ResourceLocation(MythicCraft.MOD_ID, "hellbark_boat").toString()));
}