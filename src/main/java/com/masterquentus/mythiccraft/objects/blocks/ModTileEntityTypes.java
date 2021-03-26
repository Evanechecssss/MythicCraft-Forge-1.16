package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.init.BlockInit;
import com.masterquentus.mythiccraft.tileentity.BloodOakCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.MagicQuarryTileEntity;
import com.masterquentus.mythiccraft.tileentity.PandorsBoxTileEntity;
import com.masterquentus.mythiccraft.tileentity.PedestalTileEntity;
import com.masterquentus.mythiccraft.tileentity.WhiteOakCrateTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, MythicCraft.MOD_ID);

	public static final RegistryObject<TileEntityType<BloodOakCrateTileEntity>> bloodoak_crate = TILE_ENTITY_TYPES
			.register("bloodoak_crate", () -> TileEntityType.Builder
					.create(BloodOakCrateTileEntity::new, BlockInit.bloodoak_crate.get()).build(null));
	public static final RegistryObject<TileEntityType<WhiteOakCrateTileEntity>> whiteoak_crate = TILE_ENTITY_TYPES
			.register("whiteoak_crate", () -> TileEntityType.Builder
					.create(WhiteOakCrateTileEntity::new, BlockInit.whiteoak_crate.get()).build(null));
	public static final RegistryObject<TileEntityType<PandorsBoxTileEntity>> pandors_box = TILE_ENTITY_TYPES.register(
			"pandors_box",
			() -> TileEntityType.Builder.create(PandorsBoxTileEntity::new, BlockInit.pandors_box.get()).build(null));
	public static final RegistryObject<TileEntityType<MagicQuarryTileEntity>> magic_quarry = TILE_ENTITY_TYPES.register(
			"magic_quarry",
			() -> TileEntityType.Builder.create(MagicQuarryTileEntity::new, BlockInit.magic_quarry.get()).build(null));
	public static final RegistryObject<TileEntityType<PedestalTileEntity>> pedestal_tier1 = TILE_ENTITY_TYPES.register(
			"pedestal_tier1",
			() -> TileEntityType.Builder.create(PedestalTileEntity::new, BlockInit.PEDESTAL_TIER1.get()).build(null));
}
