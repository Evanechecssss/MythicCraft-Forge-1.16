package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.tileentity.CrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.LanternTileEntity;
import com.masterquentus.mythiccraft.tileentity.MagicMirrorTileEntity;
import com.masterquentus.mythiccraft.tileentity.MagicQuarryTileEntity;
import com.masterquentus.mythiccraft.tileentity.MobSlayerTileEntity;
import com.masterquentus.mythiccraft.tileentity.PandorsBoxTileEntity;
import com.masterquentus.mythiccraft.tileentity.PedestalTileEntity;

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
			"mob_slayer", () -> TileEntityType.Builder.of(MobSlayerTileEntity::new, BlockInit.MOB_SLAYER.get()).build(null));
	
	public static final RegistryObject<TileEntityType<MagicMirrorTileEntity>> MAGIC_MIRROR = TILE_ENTITY_TYPES.register(
			"magic_mirror", () -> TileEntityType.Builder.of(MagicMirrorTileEntity::new, BlockInit.MAGIC_MIRROR.get()).build(null));
}
