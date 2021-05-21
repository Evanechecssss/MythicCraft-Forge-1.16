package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.tileentity.CrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.MagicQuarryTileEntity;
import com.masterquentus.mythiccraft.tileentity.PandorsBoxTileEntity;
import com.masterquentus.mythiccraft.tileentity.PedestalTileEntity;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ModTileEntityTypes {
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MythicCraft.MOD_ID);

	static Block[] CRATE_BLOCKS;
	static {
		List<BlockInit.WoodType> types = new ArrayList<>();
		BlockInit.WOOD_TYPES.forEach((string, type) -> {
			types.add(type);
		});
		CRATE_BLOCKS = new Block[BlockInit.WOOD_TYPES.size()];
		for (int i=0;i<BlockInit.WOOD_TYPES.size();i++) {
			CRATE_BLOCKS[i] = types.get(i).crate.get();
		}
	}

	public static final RegistryObject<TileEntityType<CrateTileEntity>> CRATE_TILE = TILE_ENTITY_TYPES
			.register("crate_tile_entity", () -> TileEntityType.Builder.of(CrateTileEntity::new, CRATE_BLOCKS).build(null));
	public static final RegistryObject<TileEntityType<PandorsBoxTileEntity>> pandors_box = TILE_ENTITY_TYPES.register(
			"pandors_box",
			() -> TileEntityType.Builder.of(PandorsBoxTileEntity::new, BlockInit.pandors_box.get()).build(null));
	public static final RegistryObject<TileEntityType<MagicQuarryTileEntity>> magic_quarry = TILE_ENTITY_TYPES.register(
			"magic_quarry",
			() -> TileEntityType.Builder.of(MagicQuarryTileEntity::new, BlockInit.magic_quarry.get()).build(null));
	public static final RegistryObject<TileEntityType<PedestalTileEntity>> pedestal_tier1 = TILE_ENTITY_TYPES.register(
			"pedestal_tier1",
			() -> TileEntityType.Builder.of(PedestalTileEntity::new, BlockInit.PEDESTAL_TIER1.get()).build(null));
}

