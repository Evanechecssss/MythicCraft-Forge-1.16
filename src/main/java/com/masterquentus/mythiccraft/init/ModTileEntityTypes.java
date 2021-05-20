package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.tileentity.CrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.MagicQuarryTileEntity;
import com.masterquentus.mythiccraft.tileentity.PandorsBoxTileEntity;
import com.masterquentus.mythiccraft.tileentity.PedestalTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MythicCraft.MOD_ID);

	public static final RegistryObject<TileEntityType<CrateTileEntity>> CRATE_TILE = TILE_ENTITY_TYPES
			.register("crate_tile_entity", () -> TileEntityType.Builder.of(CrateTileEntity::new,
					BlockInit.TWISTED_CRATE.get(), BlockInit.DISTORTED_CRATE.get(), BlockInit.ICY_CRATE.get(), BlockInit.CHARRED_CRATE.get(),
					BlockInit.INFESTED_CRATE.get(), BlockInit.YEW_CRATE.get(), BlockInit.WITCHHAZEL_CRATE.get(), BlockInit.JUNIPER_CRATE.get(),
					BlockInit.ELDER_CRATE.get(), BlockInit.CEDAR_CRATE.get(), BlockInit.BLACKTHORN_CRATE.get(), BlockInit.ASH_CRATE.get(),
					BlockInit.WILLOW_CRATE.get(), BlockInit.BEECH_CRATE.get(), BlockInit.ROWAN_CRATE.get(), BlockInit.HAWTHORN_CRATE.get(),
					BlockInit.ALDER_CRATE.get(), BlockInit.WITCHWOOD_CRATE.get(), BlockInit.SILVERWOOD_CRATE.get(), BlockInit.whiteoak_crate.get(),
					BlockInit.bloodoak_crate.get()).build(null));


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
}
