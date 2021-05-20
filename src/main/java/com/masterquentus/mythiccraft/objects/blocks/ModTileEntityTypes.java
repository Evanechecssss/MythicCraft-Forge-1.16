package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.init.BlockInit;
import com.masterquentus.mythiccraft.tileentity.AlderCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.AshCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.BeechCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.BlackthornCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.BloodOakCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.CedarCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.CharredCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.DistortedCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.ElderCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.HawthornCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.IcyCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.InfestedCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.JuniperCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.MagicQuarryTileEntity;
import com.masterquentus.mythiccraft.tileentity.PandorsBoxTileEntity;
import com.masterquentus.mythiccraft.tileentity.PedestalTileEntity;
import com.masterquentus.mythiccraft.tileentity.RowanCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.SilverWoodCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.TwistedCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.WhiteOakCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.WillowCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.WitchWoodCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.WitchhazelCrateTileEntity;
import com.masterquentus.mythiccraft.tileentity.YewCrateTileEntity;

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
	public static final RegistryObject<TileEntityType<SilverWoodCrateTileEntity>> silverwood_crate = TILE_ENTITY_TYPES
			.register("silverwood_crate", () -> TileEntityType.Builder
					.create(SilverWoodCrateTileEntity::new, BlockInit.SILVERWOOD_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<WitchWoodCrateTileEntity>> witchwood_crate = TILE_ENTITY_TYPES
			.register("witchwood_crate", () -> TileEntityType.Builder
					.create(WitchWoodCrateTileEntity::new, BlockInit.WITCHWOOD_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<AlderCrateTileEntity>> alder_crate = TILE_ENTITY_TYPES.register(
			"alder_crate",
			() -> TileEntityType.Builder.create(AlderCrateTileEntity::new, BlockInit.ALDER_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<HawthornCrateTileEntity>> hawthorn_crate = TILE_ENTITY_TYPES
			.register("hawthorn_crate", () -> TileEntityType.Builder
					.create(HawthornCrateTileEntity::new, BlockInit.HAWTHORN_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<RowanCrateTileEntity>> rowan_crate = TILE_ENTITY_TYPES.register(
			"rowan_crate",
			() -> TileEntityType.Builder.create(RowanCrateTileEntity::new, BlockInit.ROWAN_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<WillowCrateTileEntity>> willow_crate = TILE_ENTITY_TYPES.register(
			"willow_crate",
			() -> TileEntityType.Builder.create(WillowCrateTileEntity::new, BlockInit.WILLOW_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<BeechCrateTileEntity>> beech_crate = TILE_ENTITY_TYPES.register(
			"beech_crate",
			() -> TileEntityType.Builder.create(BeechCrateTileEntity::new, BlockInit.BEECH_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<AshCrateTileEntity>> ash_crate = TILE_ENTITY_TYPES.register(
			"ash_crate",
			() -> TileEntityType.Builder.create(AshCrateTileEntity::new, BlockInit.ASH_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<BlackthornCrateTileEntity>> blackthorn_crate = TILE_ENTITY_TYPES
			.register("blackthorn_crate", () -> TileEntityType.Builder
					.create(BlackthornCrateTileEntity::new, BlockInit.BLACKTHORN_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<CedarCrateTileEntity>> cedar_crate = TILE_ENTITY_TYPES
			.register("cedar_crate", () -> TileEntityType.Builder
					.create(CedarCrateTileEntity::new, BlockInit.CEDAR_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<ElderCrateTileEntity>> elder_crate = TILE_ENTITY_TYPES
			.register("elder_crate", () -> TileEntityType.Builder
					.create(ElderCrateTileEntity::new, BlockInit.ELDER_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<JuniperCrateTileEntity>> juniper_crate = TILE_ENTITY_TYPES
			.register("juniper_crate", () -> TileEntityType.Builder
					.create(JuniperCrateTileEntity::new, BlockInit.JUNIPER_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<WitchhazelCrateTileEntity>> witchhazel_crate = TILE_ENTITY_TYPES
			.register("witchhazel_crate", () -> TileEntityType.Builder
					.create(WitchhazelCrateTileEntity::new, BlockInit.WITCHHAZEL_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<YewCrateTileEntity>> yew_crate = TILE_ENTITY_TYPES
			.register("yew_crate", () -> TileEntityType.Builder
					.create(YewCrateTileEntity::new, BlockInit.YEW_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<InfestedCrateTileEntity>> infested_crate = TILE_ENTITY_TYPES
			.register("infested_crate", () -> TileEntityType.Builder
					.create(InfestedCrateTileEntity::new, BlockInit.INFESTED_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<CharredCrateTileEntity>> charred_crate = TILE_ENTITY_TYPES
			.register("charred_crate", () -> TileEntityType.Builder
					.create(CharredCrateTileEntity::new, BlockInit.CHARRED_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<IcyCrateTileEntity>> icy_crate = TILE_ENTITY_TYPES
			.register("icy_crate", () -> TileEntityType.Builder
					.create(IcyCrateTileEntity::new, BlockInit.ICY_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<DistortedCrateTileEntity>> distorted_crate = TILE_ENTITY_TYPES
			.register("distorted_crate", () -> TileEntityType.Builder
					.create(DistortedCrateTileEntity::new, BlockInit.DISTORTED_CRATE.get()).build(null));
	public static final RegistryObject<TileEntityType<TwistedCrateTileEntity>> twisted_crate = TILE_ENTITY_TYPES
			.register("twisted_crate", () -> TileEntityType.Builder
					.create(TwistedCrateTileEntity::new, BlockInit.TWISTED_CRATE.get()).build(null));
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
