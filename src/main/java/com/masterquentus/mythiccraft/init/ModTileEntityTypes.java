package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.init.auto.WoodTypes;
import com.masterquentus.mythiccraft.tileentity.CrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.GrassperTileEntity;
import com.masterquentus.mythiccraft.tileentity.LanternTileEntity;
import com.masterquentus.mythiccraft.tileentity.MagicMirrorTileEntity;
import com.masterquentus.mythiccraft.tileentity.MagicQuarryTileEntity;
import com.masterquentus.mythiccraft.tileentity.MobSlayerTileEntity;
import com.masterquentus.mythiccraft.tileentity.ModSignTileEntity;
import com.masterquentus.mythiccraft.tileentity.PandorsBoxTileEntity;
import com.masterquentus.mythiccraft.tileentity.PedestalTileEntity;

import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, MythicCraft.MOD_ID);

	public static final RegistryObject<TileEntityType<CrateTileEntity>> CRATE_TILE = TILE_ENTITY_TYPES.register(
			"crate_tile_entity",
			() -> TileEntityType.Builder.of(CrateTileEntity::new, BlockInit.getAllCrates()).build(null));
	public static final RegistryObject<TileEntityType<PandorsBoxTileEntity>> pandors_box = TILE_ENTITY_TYPES.register(
			"pandors_box",
			() -> TileEntityType.Builder.of(PandorsBoxTileEntity::new, BlockInit.pandors_box.get()).build(null));
	public static final RegistryObject<TileEntityType<MagicQuarryTileEntity>> magic_quarry = TILE_ENTITY_TYPES.register(
			"magic_quarry",
			() -> TileEntityType.Builder.of(MagicQuarryTileEntity::new, BlockInit.magic_quarry.get()).build(null));
	public static final RegistryObject<TileEntityType<PedestalTileEntity>> pedestal_tier1 = TILE_ENTITY_TYPES.register(
			"pedestal_tier1",
			() -> TileEntityType.Builder.of(PedestalTileEntity::new, BlockInit.PEDESTAL_TIER1.get(),
					BlockInit.PEDESTAL_TIER2.get(), BlockInit.PEDESTAL_TIER3.get(), BlockInit.PEDESTAL_TIER4.get(),
					BlockInit.PEDESTAL_TIER5.get(), BlockInit.PEDESTAL_TIER6.get()).build(null));

	public static final RegistryObject<TileEntityType<LanternTileEntity>> LANTERN_TILE = TILE_ENTITY_TYPES.register(
			"lantern", () -> TileEntityType.Builder.of(LanternTileEntity::new, BlockInit.getAllLanterns()).build(null));

	public static final RegistryObject<TileEntityType<MobSlayerTileEntity>> MOB_SLAYER = TILE_ENTITY_TYPES.register(
			"mob_slayer",
			() -> TileEntityType.Builder.of(MobSlayerTileEntity::new, BlockInit.MOB_SLAYER.get()).build(null));

	public static final RegistryObject<TileEntityType<MagicMirrorTileEntity>> MAGIC_MIRROR = TILE_ENTITY_TYPES.register(
			"magic_mirror",
			() -> TileEntityType.Builder.of(MagicMirrorTileEntity::new, BlockInit.MAGIC_MIRROR.get()).build(null));

	public static final RegistryObject<TileEntityType<GrassperTileEntity>> GRASSPER = TILE_ENTITY_TYPES.register(
			"grassper", () -> TileEntityType.Builder.of(GrassperTileEntity::new, BlockInit.GRASSPER.get()).build(null));

	public static final RegistryObject<TileEntityType<ModSignTileEntity>> SIGN_TILE_ENTITY = TILE_ENTITY_TYPES.register(
			"sign",
			() -> TileEntityType.Builder.of(ModSignTileEntity::new, BlockInit.BLOODOAK_SIGN.get(),
					BlockInit.BLOODOAK_WALL_SIGN.get(), BlockInit.WHITE_OAK_SIGN.get(),
					BlockInit.WHITE_OAK_WALL_SIGN.get(), BlockInit.SILVER_WOOD_SIGN.get(),
					BlockInit.SILVER_WOOD_WALL_SIGN.get(), BlockInit.WITCH_WOOD_SIGN.get(),
					BlockInit.WITCH_WOOD_WALL_SIGN.get(), BlockInit.ALDER_SIGN.get(), BlockInit.ALDER_WALL_SIGN.get(),
					BlockInit.HAWTHORN_SIGN.get(), BlockInit.HAWTHORN_WALL_SIGN.get(), BlockInit.ROWAN_SIGN.get(),
					BlockInit.ROWAN_WALL_SIGN.get(), BlockInit.WILLOW_SIGN.get(), BlockInit.WILLOW_WALL_SIGN.get(),
					BlockInit.BEECH_SIGN.get(), BlockInit.BEECH_WALL_SIGN.get(), BlockInit.ASH_SIGN.get(),
					BlockInit.ASH_WALL_SIGN.get(), BlockInit.BLACKTHORN_SIGN.get(),
					BlockInit.BLACKTHORN_WALL_SIGN.get(), BlockInit.CEDAR_SIGN.get(), BlockInit.CEDAR_WALL_SIGN.get(),
					BlockInit.ELDER_SIGN.get(), BlockInit.ELDER_WALL_SIGN.get(), BlockInit.JUNIPER_SIGN.get(),
					BlockInit.JUNIPER_WALL_SIGN.get(), BlockInit.WITCHHAZEL_SIGN.get(),
					BlockInit.WITCHHAZEL_WALL_SIGN.get(), BlockInit.YEW_SIGN.get(), BlockInit.YEW_WALL_SIGN.get(),
					BlockInit.INFESTED_SIGN.get(), BlockInit.INFESTED_WALL_SIGN.get(), BlockInit.CHARRED_SIGN.get(),
					BlockInit.CHARRED_WALL_SIGN.get(), BlockInit.ICY_SIGN.get(), BlockInit.ICY_WALL_SIGN.get(),
					BlockInit.TWISTED_SIGN.get(), BlockInit.TWISTED_WALL_SIGN.get(), BlockInit.DISTORTED_SIGN.get(),
					BlockInit.DISTORTED_WALL_SIGN.get()).build(null));

	// public static final RegistryObject<TileEntityType<WitchesOvenTileEntity>>
	// WITCHES_OVEN = TILE_ENTITY_TYPES.register(
	// "witches_oven", () -> TileEntityType.Builder.of(WitchesOvenTileEntity::new,
	// BlockInit.WITCHES_OVEN.get()).build(null));
}
