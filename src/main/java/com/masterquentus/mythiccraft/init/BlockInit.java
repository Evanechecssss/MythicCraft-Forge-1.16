package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.init.auto.LanternType;
import com.masterquentus.mythiccraft.init.auto.OreType;
import com.masterquentus.mythiccraft.init.auto.StoneType;
import com.masterquentus.mythiccraft.init.auto.WoodType;
import com.masterquentus.mythiccraft.objects.blocks.WaterartichokeCrop;
import com.masterquentus.mythiccraft.objects.blocks.*;
import com.masterquentus.mythiccraft.world.feature.*;

import net.minecraft.block.*;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			MythicCraft.MOD_ID);

	static {
		for (WoodType woodType : WoodType.values()){
			woodType.register(BLOCKS);
		}

		for (StoneType stoneType : StoneType.values()){
			stoneType.register(BLOCKS);
		}

		for (OreType oreType : OreType.values()){
			oreType.register(BLOCKS);
		}

		for (LanternType lantern : LanternType.values()){
			lantern.block = BLOCKS.register(lantern.name().toLowerCase() + "_lantern", () -> new ModLanternBlock(lantern));
		}
	}

	public static Block[] getAllCrates(){
		Block[] crates = new Block[WoodType.values().length];
		for (int i=0;i<WoodType.values().length;i++) {
			crates[i] = WoodType.values()[i].crate.get();
		}

		return crates;
	}

	public static Block[] getAllLanterns(){
		Block[] lanterns = new Block[LanternType.values().length];
		for (int i=0;i<LanternType.values().length;i++) {
			lanterns[i] = LanternType.values()[i].block.get();
		}

		return lanterns;
	}

	// Blocks
	public static final RegistryObject<Block> BLACK_OBSIDIAN = BLOCKS.register("black_obsidian",
			() -> new Block(Block.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
					.harvestLevel(3)));
	public static final RegistryObject<Block> CHARRED_SOIL = BLOCKS.register("charred_soil",
			() -> new ModGrassBlock(Block.Properties.of(Material.SAND, MaterialColor.COLOR_BLACK).sound(SoundType.SAND)
					.harvestTool(ToolType.SHOVEL).harvestLevel(0)));
	public static final RegistryObject<Block> INFESTED_SOIL = BLOCKS.register("infested_soil",
			() -> new ModGrassBlock(Block.Properties.of(Material.SAND, MaterialColor.COLOR_MAGENTA)
					.sound(SoundType.GRAVEL).harvestTool(ToolType.SHOVEL).harvestLevel(0)));
	public static final RegistryObject<Block> MYSTIC_SOIL = BLOCKS.register("mystic_soil",
			() -> new ModGrassBlock(Block.Properties.of(Material.SAND, MaterialColor.COLOR_MAGENTA)
					.sound(SoundType.GRAVEL).harvestTool(ToolType.SHOVEL).harvestLevel(0)));
	public static final RegistryObject<Block> BLOODLY_SOIL = BLOCKS.register("bloodly_soil",
			() -> new ModGrassBlock(Block.Properties.of(Material.SAND, MaterialColor.COLOR_RED).sound(SoundType.GRAVEL)
					.harvestTool(ToolType.SHOVEL).harvestLevel(0)));
	public static final RegistryObject<Block> DEEP_SOIL = BLOCKS.register("deep_soil",
			() -> new ModGrassBlock(Block.Properties.of(Material.DIRT, MaterialColor.COLOR_BLACK).sound(SoundType.GRAVEL)
					.harvestTool(ToolType.SHOVEL).harvestLevel(0)));

	public static final RegistryObject<Block> CONGEALED_BLOOD = BLOCKS.register("congealed_blood",
			() -> new Block(Block.Properties.copy(Blocks.HONEY_BLOCK).strength(5.0f, 30.0f)
					.sound(SoundType.SLIME_BLOCK).harvestLevel(1)));
	public static final RegistryObject<Block> ROSEQUARTZ_CHISELED = BLOCKS.register("rosequartz_chiseled",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> ROSEQUARTZ_SMOOTH = BLOCKS.register("rosequartz_smooth",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> ROSEQUARTZ_PILLAR = BLOCKS.register("rosequartz_pillar",
			() -> new RotatedPillarBlock(Block.Properties.copy(Blocks.QUARTZ_PILLAR).strength(5.0f, 30.0f)
							.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> ROSEQUARTZ_BRICKS = BLOCKS.register("rosequartz_bricks",
			() -> new RotatedPillarBlock(Block.Properties.copy(Blocks.QUARTZ_BLOCK).strength(5.0f, 30.0f).sound(SoundType.STONE)
							.harvestTool(ToolType.PICKAXE).harvestLevel(1)));


	public static final RegistryObject<Block> CHARREDSLIME_BLOCK = BLOCKS.register("charredslime_block",
			() -> new SlimeBlock(Block.Properties.copy(Blocks.SLIME_BLOCK).harvestLevel(1)));
	public static final RegistryObject<Block> INFESTEDSLIME_BLOCK = BLOCKS.register("infestedslime_block",
			() -> new SlimeBlock(Block.Properties.copy(Blocks.SLIME_BLOCK).harvestLevel(1)));
	public static final RegistryObject<Block> ASH_BLOCK = BLOCKS.register("ash_block",
			() -> new Block(Block.Properties.copy(Blocks.RED_SAND).harvestTool(ToolType.SHOVEL).harvestLevel(1)));
	public static final RegistryObject<Block> HOTASH_BLOCK = BLOCKS.register("hotash_block",
			() -> new Block(Block.Properties.copy(Blocks.RED_SAND)));
	public static final RegistryObject<Block> ASH_LAYER = BLOCKS.register("ash_layer", () -> new ModLayer(
			Block.Properties.copy(Blocks.SAND).strength(0.3f, 0.2f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> HOTASH_LAYER = BLOCKS.register("hotash_layer", () -> new ModLayer(
			Block.Properties.copy(Blocks.SAND).strength(0.3f, 0.2f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> MAGIC_WALL = BLOCKS.register("magic_wall", () -> new Block(
			Block.Properties.copy(Blocks.STONE).strength(0.3f, 0.2f).sound(SoundType.STONE)));

	// Transparent Blocks
	public static final RegistryObject<Block> CRIMSON_ICE = BLOCKS.register("crimson_ice",
			() -> new ModIceBlock(Block.Properties.copy(Blocks.ICE).strength(0.3f, 0.2f)
					.sound(SoundType.GLASS).friction(0.98f)));
	public static final RegistryObject<Block> CRIMSON_PACKEDICE = BLOCKS.register("crimson_packedice",
			() -> new Block(Block.Properties.copy(Blocks.PACKED_ICE).strength(0.3f, 0.2f)
					.sound(SoundType.GLASS).friction(0.98f)));
	public static final RegistryObject<Block> BLACK_ICE = BLOCKS.register("black_ice",
			() -> new ModIceBlock(Block.Properties.copy(Blocks.ICE).strength(0.3f, 0.2f)
					.sound(SoundType.GLASS).friction(0.98f)));
	public static final RegistryObject<Block> BLACK_PACKEDICE = BLOCKS.register("black_packedice",
			() -> new Block(Block.Properties.copy(Blocks.PACKED_ICE).strength(0.3f, 0.2f)
					.sound(SoundType.GLASS).friction(0.98f).speedFactor(0.7f).randomTicks().noOcclusion()));
	public static final RegistryObject<Block> PIXIE_GLASS = BLOCKS.register("pixie_glass", () -> new Block(
			Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> FAIRY_GLASS = BLOCKS.register("fairy_glass", () -> new Block(
			Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> PIXIE_GLASS_PANE = BLOCKS.register("pixie_glass_pane",
			() -> new ModPaneBlock(Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f)
					.sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> FAIRY_GLASS_PANE = BLOCKS.register("fairy_glass_pane",
			() -> new ModPaneBlock(Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f)
					.sound(SoundType.GLASS).noOcclusion()));

	// Lanterns/Glowstone/Torches
	public static final RegistryObject<Block> PURE_GLOWSTONE = BLOCKS.register("pure_glowstone",
			() -> new Block(Block.Properties.of(Material.GLASS).strength(2.0f, 10.0f).harvestLevel(2)
					.sound(SoundType.GLASS).lightLevel((state) ->15)));
	public static final RegistryObject<Block> DARK_GLOWSTONE = BLOCKS.register("dark_glowstone",
			() -> new Block(Block.Properties.of(Material.GLASS).strength(2.0f, 10.0f).harvestLevel(2)
					.sound(SoundType.GLASS).lightLevel((state) ->15)));
	public static final RegistryObject<Block> BLOOD_TORCH = BLOCKS.register(
			"blood_torch",
			() -> new TorchBlock(Block.Properties.copy(Blocks.TORCH).strength(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightLevel((state) ->15), ParticleTypes.FLAME));
	public static final RegistryObject<Block> SILVER_TORCH = BLOCKS.register("silver_torch",
			() -> new TorchBlock(Block.Properties.copy(Blocks.TORCH).strength(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightLevel((state) ->15), ParticleTypes.FLAME));
	public static final RegistryObject<Block> SOUL_TORCH = BLOCKS.register("soul_torch",
			() -> new TorchBlock(Block.Properties.copy(Blocks.TORCH).strength(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightLevel((state) ->15), ParticleTypes.FLAME));
	public static final RegistryObject<Block> UNDEAD_TORCH = BLOCKS.register("undead_torch",
			() -> new TorchBlock(Block.Properties.copy(Blocks.TORCH).strength(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightLevel((state) ->15), ParticleTypes.FLAME));
	public static final RegistryObject<Block> MYSTIC_TORCH = BLOCKS.register("mystic_torch",
			() -> new TorchBlock(Block.Properties.copy(Blocks.TORCH).strength(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightLevel((state) ->15), ParticleTypes.FLAME));
	public static final RegistryObject<Block> ENDER_TORCH = BLOCKS.register("ender_torch",
			() -> new TorchBlock(Block.Properties.copy(Blocks.TORCH).strength(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightLevel((state) ->15), ParticleTypes.FLAME));
	public static final RegistryObject<Block> FAIRY_TORCH = BLOCKS.register("fairy_torch",
			() -> new TorchBlock(Block.Properties.copy(Blocks.TORCH).strength(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightLevel((state) ->15), ParticleTypes.FLAME));
	public static final RegistryObject<Block> PIXIE_TORCH = BLOCKS.register("pixie_torch",
			() -> new TorchBlock(Block.Properties.copy(Blocks.TORCH).strength(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightLevel((state) ->15), ParticleTypes.FLAME));
	public static final RegistryObject<Block> LIFE_TORCH = BLOCKS.register("life_torch",
			() -> new TorchBlock(Block.Properties.copy(Blocks.TORCH).strength(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightLevel((state) ->15), ParticleTypes.FLAME));
	public static final RegistryObject<Block> FERAL_TORCH = BLOCKS.register("feral_torch",
			() -> new TorchBlock(Block.Properties.copy(Blocks.TORCH).strength(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightLevel((state) ->15), ParticleTypes.FLAME));
	public static final RegistryObject<Block> LOVE_TORCH = BLOCKS.register("love_torch",
			() -> new TorchBlock(Block.Properties.copy(Blocks.TORCH).strength(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightLevel((state) ->15), ParticleTypes.FLAME));

	// PLANT
	public static final RegistryObject<Block> BLOODY_ROSE = BLOCKS.register("bloody_rose",
			() -> new FlowerBlock(Effects.NIGHT_VISION, 5,
					Block.Properties.copy(Blocks.POPPY).strength(0.3f, 0.2f).sound(SoundType.VINE)));

	// Mushrooms

	// Crops
	public static final RegistryObject<Block> vervain_crop = createCrop("vervain_crop", ItemInit.vervain_seeds);
	public static final RegistryObject<Block> wormwood_crop = createCrop("wormwood_crop", ItemInit.wormwood_seeds);
	public static final RegistryObject<Block> wolfsbane_crop = createCrop("wolfsbane_crop", ItemInit.wolfsbane_seeds);
	public static final RegistryObject<Block> garlic_crop = createCrop("garlic_crop", ItemInit.garlic_seeds);
	public static final RegistryObject<Block> belladonna_crop = createCrop("belladonna_crop", ItemInit.belladnna_seeds);
	public static final RegistryObject<Block> mandrake_crop = createCrop("mandrake_crop", ItemInit.mandrake_seeds);
	public static final RegistryObject<Block> foxgloves_crop = createCrop("foxgloves_crop", ItemInit.foxgloves_seeds);
	public static final RegistryObject<Block> nightshade_crop = createCrop("nightshade_crop", ItemInit.nightshade_seeds);
	public static final RegistryObject<Block> hellebore_crop = createCrop("hellebore_crop", ItemInit.hellebore_seeds);
	public static final RegistryObject<Block> whitesage_crop = createCrop("whitesage_crop", ItemInit.whitesage_seeds);
	public static final RegistryObject<Block> snowbell_crop = createCrop("snowbell_crop", ItemInit.snowbell_seeds);

	public static final RegistryObject<Block> waterartichoke_crop = BLOCKS.register("waterartichoke_crop",
			() -> new WaterartichokeCrop(Block.Properties.copy(Blocks.WHEAT)));

	private static RegistryObject<Block> createCrop(String registryName, RegistryObject<Item> seeds){
		return BLOCKS.register(registryName,
				() -> new ModCropBlock(Block.Properties.copy(Blocks.WHEAT), seeds));
	}

	// PLANT
	public static final RegistryObject<Block> WEEPING_VINES = BLOCKS.register("weeping_vines",
			() -> new VineBlock(Block.Properties.copy(Blocks.VINE)));
	public static final RegistryObject<Block> SPANISH_MOSS = BLOCKS.register("spanish_moss",
			() -> new VineBlock(Block.Properties.copy(Blocks.VINE)));
	public static final RegistryObject<Block> LIVING_KELP_TOP = BLOCKS.register("living_kelp_top",
			() -> new ModKelpTopBlock(
					Block.Properties.copy(Blocks.KELP_PLANT).sound(SoundType.WET_GRASS).randomTicks()));
	public static final RegistryObject<Block> LIVING_KELP = BLOCKS.register("living_kelp",
			() -> new ModKelpBlock(Block.Properties.copy(Blocks.KELP_PLANT).sound(SoundType.WET_GRASS).randomTicks()));

	// Special blocks
	public static final RegistryObject<Block> pandors_box = BLOCKS.register("pandors_box", () -> new PandorsBox(
			Block.Properties.copy(Blocks.BONE_BLOCK).noOcclusion().harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> pandors_box_open = BLOCKS.register("pandors_box_open",
			() -> new PandorsBoxOpen(
					Block.Properties.copy(Blocks.BONE_BLOCK).noOcclusion().harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> magic_quarry = BLOCKS.register("magic_quarry",
			() -> new BlockQuarry(Block.Properties.of(Material.METAL).sound(SoundType.LANTERN).noOcclusion()));


	// i think the voxel shapes for all tiers are the same so they're all using one class
	public static final RegistryObject<Block> PEDESTAL_TIER1 = BLOCKS.register("pedestal_tier1",
			() -> new PedestalTier1(
					Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> PEDESTAL_TIER2 = BLOCKS.register("pedestal_tier2",
			() -> new PedestalTier1(
					Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> PEDESTAL_TIER3 = BLOCKS.register("pedestal_tier3",
			() -> new PedestalTier1(
					Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> PEDESTAL_TIER4 = BLOCKS.register("pedestal_tier4",
			() -> new PedestalTier1(
					Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> PEDESTAL_TIER5 = BLOCKS.register("pedestal_tier5", () -> new Block(
			Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> PEDESTAL_TIER6 = BLOCKS.register("pedestal_tier6", () -> new Block(
			Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> HELL_FIRE = BLOCKS.register("hell_fire",
			() -> new HellFireBlock(Block.Properties.of(Material.FIRE).strength(0.5f, 15.0f)
					.sound(SoundType.HONEY_BLOCK).noCollission().noOcclusion().lightLevel((s) -> 15)));

	public static final DeferredRegister<Block> NO_ITEM_BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS,
			MythicCraft.MOD_ID);

	public static final RegistryObject<Block> ICY_BERRY_BUSH = NO_ITEM_BLOCK.register("icy_berry_bush",
			() -> new ModBerryBushBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> BLOOD_BERRY_BUSH = NO_ITEM_BLOCK.register("blood_berry_bush",
			() -> new ModBerryBushBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> SILVER_BERRY_BUSH = NO_ITEM_BLOCK.register("silver_berry_bush",
			() -> new ModBerryBushBlock(Block.Properties.of(Material.PLANT).noCollission()
					.randomTicks().sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> CHARRED_BERRY_BUSH = NO_ITEM_BLOCK.register("charred_berry_bush",
			() -> new ModBerryBushBlock(Block.Properties.of(Material.PLANT).noCollission()
					.randomTicks().sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> SOUL_BERRY_BUSH = NO_ITEM_BLOCK.register("soul_berry_bush",
			() -> new ModBerryBushBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> INFESTED_BERRY_BUSH = NO_ITEM_BLOCK.register("infested_berry_bush",
			() -> new ModBerryBushBlock(Block.Properties.of(Material.PLANT).noCollission()
					.randomTicks().sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> MYSTIC_BERRY_BUSH = NO_ITEM_BLOCK.register("mystic_berry_bush",
			() -> new ModBerryBushBlock(Block.Properties.of(Material.PLANT).noCollission()
					.randomTicks().sound(SoundType.SWEET_BERRY_BUSH)));

}