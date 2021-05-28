package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.tileentity.*;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ModTileEntityTypes {
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MythicCraft.MOD_ID);

	public static final RegistryObject<TileEntityType<CrateTileEntity>> CRATE_TILE = TILE_ENTITY_TYPES
			.register("crate_tile_entity", () -> TileEntityType.Builder.of(CrateTileEntity::new, BlockInit.getAllCrates()).build(null));
	public static final RegistryObject<TileEntityType<PandorsBoxTileEntity>> pandors_box = TILE_ENTITY_TYPES.register(
			"pandors_box",
			() -> TileEntityType.Builder.of(PandorsBoxTileEntity::new, BlockInit.pandors_box.get()).build(null));
	public static final RegistryObject<TileEntityType<MagicQuarryTileEntity>> magic_quarry = TILE_ENTITY_TYPES.register(
			"magic_quarry",
			() -> TileEntityType.Builder.of(MagicQuarryTileEntity::new, BlockInit.magic_quarry.get()).build(null));
	public static final RegistryObject<TileEntityType<PedestalTileEntity>> pedestal_tier1 = TILE_ENTITY_TYPES.register(
			"pedestal_tier1",
			() -> TileEntityType.Builder.of(PedestalTileEntity::new, BlockInit.PEDESTAL_TIER1.get()).build(null));
	public static final RegistryObject<TileEntityType<LanternTileEntity>> LANTERN_TILE = TILE_ENTITY_TYPES
			.register("lantern", () -> TileEntityType.Builder.of(LanternTileEntity::new, BlockInit.getAllLanterns()).build(null));
}

