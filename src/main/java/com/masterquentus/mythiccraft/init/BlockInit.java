package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.init.auto.LanternType;
import com.masterquentus.mythiccraft.init.auto.OreType;
import com.masterquentus.mythiccraft.init.auto.StoneType;
import com.masterquentus.mythiccraft.init.auto.WoodTypes;
import com.masterquentus.mythiccraft.objects.blocks.*;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			MythicCraft.MOD_ID);

	static {
		for (WoodTypes woodType : WoodTypes.values()) {
			woodType.register(BLOCKS);
		}

		for (StoneType stoneType : StoneType.values()) {
			stoneType.register(BLOCKS);
		}

		for (OreType oreType : OreType.values()) {
			oreType.register(BLOCKS);
		}

		for (LanternType lantern : LanternType.values()) {
			lantern.block = BLOCKS.register(lantern.name().toLowerCase() + "_lantern",
					() -> new ModLanternBlock(lantern));
		}
	}

	public static Block[] getAllCrates() {
		Block[] crates = new Block[WoodTypes.values().length];
		for (int i = 0; i < WoodTypes.values().length; i++) {
			crates[i] = WoodTypes.values()[i].crate.get();
		}

		return crates;
	}

	public static Block[] getAllLanterns() {
		Block[] lanterns = new Block[LanternType.values().length];
		for (int i = 0; i < LanternType.values().length; i++) {
			lanterns[i] = LanternType.values()[i].block.get();
		}

		return lanterns;
	}

	// Blocks
	public static final RegistryObject<Block> BLACK_OBSIDIAN = BLOCKS.register("black_obsidian",
			() -> new Block(Block.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
					.harvestLevel(3).requiresCorrectToolForDrops().strength(50.0F, 1200.0F)));
	public static final RegistryObject<Block> CHARRED_GRASS_BLOCK = BLOCKS.register("charred_grass_block",
			() -> new GrassBlock(Block.Properties.of(Material.GRASS, MaterialColor.COLOR_BLACK).sound(SoundType.GRASS)
					.harvestTool(ToolType.SHOVEL).harvestLevel(0).randomTicks().strength(0.6F)));
	public static final RegistryObject<Block> CHARRED_SOIL = BLOCKS.register("charred_soil",
			() -> new Block(Block.Properties.of(Material.SAND, MaterialColor.COLOR_BLACK).sound(SoundType.GRAVEL)
					.harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(0.5F)));
	public static final RegistryObject<Block> INFESTED_GRASS_BLOCK = BLOCKS.register("infested_grass_block",
			() -> new GrassBlock(Block.Properties.of(Material.GRASS, MaterialColor.COLOR_PURPLE).sound(SoundType.GRASS)
					.harvestTool(ToolType.SHOVEL).harvestLevel(0).randomTicks().strength(0.6F)));
	public static final RegistryObject<Block> INFESTED_SOIL = BLOCKS.register("infested_soil",
			() -> new Block(Block.Properties.of(Material.SAND, MaterialColor.COLOR_PURPLE).sound(SoundType.GRAVEL)
					.harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(0.5F)));
	public static final RegistryObject<Block> MYSTIC_GRASS_BLOCK = BLOCKS.register("mystic_grass_block",
			() -> new GrassBlock(Block.Properties.of(Material.GRASS, MaterialColor.COLOR_PURPLE).sound(SoundType.GRASS)
					.harvestTool(ToolType.SHOVEL).harvestLevel(0).randomTicks().strength(0.6F)));
	public static final RegistryObject<Block> MYSTIC_SOIL = BLOCKS.register("mystic_soil",
			() -> new Block(Block.Properties.of(Material.SAND, MaterialColor.COLOR_PURPLE).sound(SoundType.GRAVEL)
					.harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(0.5F)));
	public static final RegistryObject<Block> BLOODLY_GRASS_BLOCK = BLOCKS.register("bloodly_grass_block",
			() -> new GrassBlock(Block.Properties.of(Material.GRASS, MaterialColor.COLOR_RED).sound(SoundType.GRASS)
					.harvestTool(ToolType.SHOVEL).harvestLevel(0).randomTicks().strength(0.6F)));
	public static final RegistryObject<Block> BLOODLY_SOIL = BLOCKS.register("bloodly_soil",
			() -> new Block(Block.Properties.of(Material.SAND, MaterialColor.COLOR_RED).sound(SoundType.GRAVEL)
					.harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(0.5F)));
	public static final RegistryObject<Block> DEEP_GRASS_BLOCK = BLOCKS.register("deep_grass_block",
			() -> new GrassBlock(Block.Properties.of(Material.GRASS, MaterialColor.COLOR_BROWN).sound(SoundType.GRASS)
					.harvestTool(ToolType.SHOVEL).harvestLevel(0).randomTicks().strength(0.6F)));
	public static final RegistryObject<Block> DEEP_SOIL = BLOCKS.register("deep_soil",
			() -> new Block(Block.Properties.of(Material.SAND, MaterialColor.COLOR_BROWN).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(0).strength(1.5F)));
	public static final RegistryObject<Block> CURSED_SOIL = BLOCKS.register("cursed_soil",
			() -> new Block(Block.Properties.of(Material.SAND, MaterialColor.COLOR_BROWN).sound(SoundType.GRASS)
					.harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(0.5F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> CONGEALED_BLOOD = BLOCKS.register("congealed_blood",
			() -> new ModBloodBlock(Block.Properties.copy(Blocks.HONEY_BLOCK).strength(5.0f, 30.0f)
					.sound(SoundType.SLIME_BLOCK).speedFactor(0.4F).jumpFactor(0.5F).noOcclusion().instabreak()));
	public static final RegistryObject<Block> ROSEQUARTZ_CHISELED = BLOCKS.register("rosequartz_chiseled",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> ROSEQUARTZ_SMOOTH = BLOCKS.register("rosequartz_smooth",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> ROSEQUARTZ_PILLAR = BLOCKS.register("rosequartz_pillar",
			() -> new RotatedPillarBlock(
					Block.Properties.copy(Blocks.QUARTZ_PILLAR).strength(5.0f, 30.0f).sound(SoundType.STONE)
							.harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> ROSEQUARTZ_BRICKS = BLOCKS.register("rosequartz_bricks",
			() -> new Block(Block.Properties.copy(Blocks.QUARTZ_BLOCK).strength(5.0f, 30.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> CHARREDSLIME_BLOCK = BLOCKS.register("charredslime_block",
			() -> new ModSlimeBlock(
					Block.Properties.copy(Blocks.SLIME_BLOCK).friction(0.8F).noOcclusion().instabreak().noOcclusion()));
	public static final RegistryObject<Block> INFESTEDSLIME_BLOCK = BLOCKS.register("infestedslime_block",
			() -> new ModSlimeBlock(
					Block.Properties.copy(Blocks.SLIME_BLOCK).friction(0.8F).noOcclusion().instabreak().noOcclusion()));
	public static final RegistryObject<Block> WATER_SLIME_BLOCK = BLOCKS.register("water_slime_block",
			() -> new ModSlimeBlock(
					Block.Properties.copy(Blocks.SLIME_BLOCK).friction(0.8F).noOcclusion().instabreak().noOcclusion()));
	public static final RegistryObject<Block> ASH_BLOCK = BLOCKS.register("ash_block", () -> new Block(Block.Properties
			.copy(Blocks.RED_SAND).harvestTool(ToolType.SHOVEL).requiresCorrectToolForDrops().strength(0.2F)));
	public static final RegistryObject<Block> HOTASH_BLOCK = BLOCKS.register("hotash_block",
			() -> new Block(Block.Properties.copy(Blocks.RED_SAND).requiresCorrectToolForDrops().strength(0.2F)));
	public static final RegistryObject<Block> ASH_LAYER = BLOCKS.register("ash_layer",
			() -> new ModLayer(Block.Properties.copy(Blocks.SAND).randomTicks().strength(0.1F)
					.requiresCorrectToolForDrops().sound(SoundType.SAND)));
	public static final RegistryObject<Block> HOTASH_LAYER = BLOCKS.register("hotash_layer",
			() -> new ModLayer(Block.Properties.copy(Blocks.SAND).randomTicks().strength(0.1F)
					.requiresCorrectToolForDrops().sound(SoundType.SAND)));
	public static final RegistryObject<Block> MAGIC_WALL = BLOCKS.register("magic_wall",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(0.3f, 0.2f).sound(SoundType.STONE)
					.noOcclusion().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> LIVING_KELP_BLOCK = BLOCKS.register("living_kelp_block",
			() -> new Block(Block.Properties.copy(Blocks.DRIED_KELP_BLOCK).strength(0.3f, 0.2f).sound(SoundType.FUNGUS)
					.lightLevel((state) -> 13)));
	public static final RegistryObject<Block> MIRROR_BLOCK = BLOCKS.register("mirror_blocks",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(5.5f, 5.5f).sound(SoundType.GLASS)
					.requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> EMBER_BLOCK = BLOCKS.register("ember_block",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(5.5f, 5.5f).sound(SoundType.STONE)
					.lightLevel((state) -> 15).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> CRIMSON_SAND = BLOCKS.register("crimson_sand",
			() -> new SandBlock(14406560, Block.Properties.copy(Blocks.SAND).sound(SoundType.SAND)
					.harvestTool(ToolType.SHOVEL).harvestLevel(1).strength(0.5F)));
	public static final RegistryObject<Block> CRIMSON_SANDSTONE = BLOCKS.register("crimson_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.SANDSTONE).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
					.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> CRIMSON_SANDSTONE_STAIRS = BLOCKS.register("crimson_sandstone_stairs",
			() -> new StairsBlock(() -> BlockInit.CRIMSON_SANDSTONE.get().defaultBlockState(),
					Block.Properties.copy(Blocks.SANDSTONE_STAIRS).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
							.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> CHISELED_CRIMSON_SANDSTONE = BLOCKS.register("chiseled_crimson_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.CHISELED_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> CUT_CRIMSON_SANDSTONE = BLOCKS.register("cut_crimson_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.CUT_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> SMOOTH_CRIMSON_SANDSTONE = BLOCKS.register("smooth_crimson_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.SMOOTH_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> SMOOTH_CRIMSON_SANDSTONE_STAIRS = BLOCKS.register(
			"smooth_crimson_sandstone_stairs",
			() -> new StairsBlock(() -> BlockInit.SMOOTH_CRIMSON_SANDSTONE.get().defaultBlockState(),
					Block.Properties.copy(Blocks.SANDSTONE_STAIRS).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
							.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> CRIMSON_SANDSTONE_SLAB = BLOCKS.register("crimson_sandstone_slab",
			() -> new SlabBlock(Block.Properties.copy(Blocks.SANDSTONE_SLAB).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> SMOOTH_CRIMSON_SANDSTONE_SLAB = BLOCKS.register(
			"smooth_crimson_sandstone_slab",
			() -> new SlabBlock(Block.Properties.copy(Blocks.SMOOTH_SANDSTONE_SLAB).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> CRIMSON_SANDSTONE_WALL = BLOCKS.register("crimson_sandstone_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.SANDSTONE_WALL).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> ICY_SAND = BLOCKS.register("icy_sand",
			() -> new SandBlock(14406560, Block.Properties.copy(Blocks.SAND).sound(SoundType.SAND)
					.harvestTool(ToolType.SHOVEL).harvestLevel(1).strength(0.5F).friction(0.98f)));
	public static final RegistryObject<Block> ICY_SANDSTONE = BLOCKS.register("icy_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.SANDSTONE).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
					.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> ICY_SANDSTONE_STAIRS = BLOCKS.register("icy_sandstone_stairs",
			() -> new StairsBlock(() -> BlockInit.ICY_SANDSTONE.get().defaultBlockState(),
					Block.Properties.copy(Blocks.SANDSTONE_STAIRS).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
							.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> CHISELED_ICY_SANDSTONE = BLOCKS.register("chiseled_icy_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.CHISELED_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> CUT_ICY_SANDSTONE = BLOCKS.register("cut_icy_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.CUT_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> SMOOTH_ICY_SANDSTONE = BLOCKS.register("smooth_icy_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.SMOOTH_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> ICY_SANDSTONE_SLAB = BLOCKS.register("icy_sandstone_slab",
			() -> new SlabBlock(Block.Properties.copy(Blocks.SANDSTONE_SLAB).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> SMOOTH_ICY_SANDSTONE_SLAB = BLOCKS.register("smooth_icy_sandstone_slab",
			() -> new SlabBlock(Block.Properties.copy(Blocks.SMOOTH_STONE_SLAB).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> SMOOTH_ICY_SANDSTONE_STAIRS = BLOCKS.register(
			"smooth_icy_sandstone_stairs",
			() -> new StairsBlock(() -> BlockInit.SMOOTH_ICY_SANDSTONE.get().defaultBlockState(),
					Block.Properties.copy(Blocks.SANDSTONE_STAIRS).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
							.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> ICY_SANDSTONE_WALL = BLOCKS.register("icy_sandstone_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.SANDSTONE_WALL).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> BLACK_SAND = BLOCKS.register("black_sand",
			() -> new SandBlock(14406560, Block.Properties.copy(Blocks.SAND).sound(SoundType.SAND)
					.harvestTool(ToolType.SHOVEL).harvestLevel(1).strength(0.5F)));
	public static final RegistryObject<Block> BLACK_SANDSTONE = BLOCKS.register("black_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.SANDSTONE).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
					.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> BLACK_SANDSTONE_STAIRS = BLOCKS.register("black_sandstone_stairs",
			() -> new StairsBlock(() -> BlockInit.BLACK_SANDSTONE.get().defaultBlockState(),
					Block.Properties.copy(Blocks.SANDSTONE_STAIRS).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
							.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> CHISELED_BLACK_SANDSTONE = BLOCKS.register("chiseled_black_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.CHISELED_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> CUT_BLACK_SANDSTONE = BLOCKS.register("cut_black_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.CUT_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> SMOOTH_BLACK_SANDSTONE = BLOCKS.register("smooth_black_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.SMOOTH_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> SMOOTH_BLACK_SANDSTONE_STAIRS = BLOCKS.register(
			"smooth_black_sandstone_stairs",
			() -> new StairsBlock(() -> BlockInit.SMOOTH_BLACK_SANDSTONE.get().defaultBlockState(),
					Block.Properties.copy(Blocks.SANDSTONE_STAIRS).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
							.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> BLACK_SANDSTONE_SLAB = BLOCKS.register("black_sandstone_slab",
			() -> new SlabBlock(Block.Properties.copy(Blocks.SANDSTONE_SLAB).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> SMOOTH_BLACK_SANDSTONE_SLAB = BLOCKS.register(
			"smooth_black_sandstone_slab",
			() -> new SlabBlock(Block.Properties.copy(Blocks.SMOOTH_STONE_SLAB).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> BLACK_SANDSTONE_WALL = BLOCKS.register("black_sandstone_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.SANDSTONE_WALL).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> PIXIE_SAND = BLOCKS.register("pixie_sand",
			() -> new SandBlock(14406560, Block.Properties.copy(Blocks.SAND).sound(SoundType.SAND)
					.harvestTool(ToolType.SHOVEL).harvestLevel(1).strength(0.5F)));
	public static final RegistryObject<Block> PIXIE_SANDSTONE = BLOCKS.register("pixie_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.SANDSTONE).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
					.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> PIXIE_SANDSTONE_STAIRS = BLOCKS.register("pixie_sandstone_stairs",
			() -> new StairsBlock(() -> BlockInit.PIXIE_SANDSTONE.get().defaultBlockState(),
					Block.Properties.copy(Blocks.SANDSTONE_STAIRS).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
							.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> CHISELED_PIXIE_SANDSTONE = BLOCKS.register("chiseled_pixie_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.CHISELED_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> CUT_PIXIE_SANDSTONE = BLOCKS.register("cut_pixie_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.CUT_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> SMOOTH_PIXIE_SANDSTONE = BLOCKS.register("smooth_pixie_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.SMOOTH_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> SMOOTH_PIXIE_SANDSTONE_STAIRS = BLOCKS.register(
			"smooth_pixie_sandstone_stairs",
			() -> new StairsBlock(() -> BlockInit.SMOOTH_PIXIE_SANDSTONE.get().defaultBlockState(),
					Block.Properties.copy(Blocks.SANDSTONE_STAIRS).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
							.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> PIXIE_SANDSTONE_SLAB = BLOCKS.register("pixie_sandstone_slab",
			() -> new SlabBlock(Block.Properties.copy(Blocks.SANDSTONE_SLAB).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> SMOOTH_PIXIE_SANDSTONE_SLAB = BLOCKS.register(
			"smooth_pixie_sandstone_slab",
			() -> new SlabBlock(Block.Properties.copy(Blocks.SMOOTH_STONE_SLAB).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> PIXIE_SANDSTONE_WALL = BLOCKS.register("pixie_sandstone_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.SANDSTONE_WALL).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> FAIRY_SAND = BLOCKS.register("fairy_sand",
			() -> new SandBlock(14406560, Block.Properties.copy(Blocks.SAND).sound(SoundType.SAND)
					.harvestTool(ToolType.SHOVEL).harvestLevel(1).strength(0.5F)));
	public static final RegistryObject<Block> FAIRY_SANDSTONE = BLOCKS.register("fairy_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.SANDSTONE).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
					.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> FAIRY_SANDSTONE_STAIRS = BLOCKS.register("fairy_sandstone_stairs",
			() -> new StairsBlock(() -> BlockInit.FAIRY_SANDSTONE.get().defaultBlockState(),
					Block.Properties.copy(Blocks.SANDSTONE_STAIRS).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
							.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> CHISELED_FAIRY_SANDSTONE = BLOCKS.register("chiseled_fairy_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.CHISELED_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> CUT_FAIRY_SANDSTONE = BLOCKS.register("cut_fairy_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.CUT_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> SMOOTH_FAIRY_SANDSTONE = BLOCKS.register("smooth_fairy_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.SMOOTH_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> SMOOTH_FAIRY_SANDSTONE_STAIRS = BLOCKS.register(
			"smooth_fairy_sandstone_stairs",
			() -> new StairsBlock(() -> BlockInit.SMOOTH_FAIRY_SANDSTONE.get().defaultBlockState(),
					Block.Properties.copy(Blocks.SANDSTONE_STAIRS).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
							.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> FAIRY_SANDSTONE_SLAB = BLOCKS.register("fairy_sandstone_slab",
			() -> new SlabBlock(Block.Properties.copy(Blocks.SANDSTONE_SLAB).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> SMOOTH_FAIRY_SANDSTONE_SLAB = BLOCKS.register(
			"smooth_fairy_sandstone_slab",
			() -> new SlabBlock(Block.Properties.copy(Blocks.SMOOTH_STONE_SLAB).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> FAIRY_SANDSTONE_WALL = BLOCKS.register("fairy_sandstone_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.SANDSTONE_WALL).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> EMBER_SAND = BLOCKS.register("ember_sand",
			() -> new SandBlock(14406560, Block.Properties.copy(Blocks.SAND).sound(SoundType.SAND)
					.harvestTool(ToolType.SHOVEL).harvestLevel(1).strength(0.5F)));
	public static final RegistryObject<Block> EMBER_SANDSTONE = BLOCKS.register("ember_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.SANDSTONE).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
					.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> EMBER_SANDSTONE_STAIRS = BLOCKS.register("ember_sandstone_stairs",
			() -> new StairsBlock(() -> BlockInit.EMBER_SANDSTONE.get().defaultBlockState(),
					Block.Properties.copy(Blocks.SANDSTONE_STAIRS).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
							.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> CHISELED_EMBER_SANDSTONE = BLOCKS.register("chiseled_ember_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.CHISELED_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> CUT_EMBER_SANDSTONE = BLOCKS.register("cut_ember_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.CUT_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> SMOOTH_EMBER_SANDSTONE = BLOCKS.register("smooth_ember_sandstone",
			() -> new Block(Block.Properties.copy(Blocks.SMOOTH_SANDSTONE).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> SMOOTH_EMBER_SANDSTONE_STAIRS = BLOCKS.register(
			"smooth_ember_sandstone_stairs",
			() -> new StairsBlock(() -> BlockInit.SMOOTH_EMBER_SANDSTONE.get().defaultBlockState(),
					Block.Properties.copy(Blocks.SANDSTONE_STAIRS).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)
							.requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> EMBER_SANDSTONE_SLAB = BLOCKS.register("ember_sandstone_slab",
			() -> new SlabBlock(Block.Properties.copy(Blocks.SANDSTONE_SLAB).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> SMOOTH_EMBER_SANDSTONE_SLAB = BLOCKS.register(
			"smooth_ember_sandstone_slab",
			() -> new SlabBlock(Block.Properties.copy(Blocks.SMOOTH_STONE_SLAB).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
	public static final RegistryObject<Block> EMBER_SANDSTONE_WALL = BLOCKS.register("ember_sandstone_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.SANDSTONE_WALL).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(0.8F)));
	public static final RegistryObject<Block> FROST_MAGMA = BLOCKS.register("frost_magma",
			() -> new MagmaBlock(Block.Properties.copy(Blocks.STONE).strength(5.5f, 5.5f).requiresCorrectToolForDrops()
					.sound(SoundType.NETHER_BRICKS).friction(0.98f).lightLevel((state) -> 3).randomTicks()
					.strength(0.5F)));
	public static final RegistryObject<Block> CRIMSON_MAGMA = BLOCKS.register("crimson_magma",
			() -> new MagmaBlock(Block.Properties.copy(Blocks.STONE).strength(5.5f, 5.5f).requiresCorrectToolForDrops()
					.sound(SoundType.NETHER_BRICKS).lightLevel((state) -> 3).randomTicks().strength(0.5F)));
	public static final RegistryObject<Block> BLOODOAK_SIGN = BLOCKS.register("bloodoak_sign",
			() -> new ModStandingSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission()
					.strength(1.0F).sound(SoundType.WOOD), WoodTypesInit.BLOOD_OAK));
	public static final RegistryObject<Block> BLOODOAK_WALL_SIGN = BLOCKS.register("bloodoak_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.BLOOD_OAK));
	public static final RegistryObject<Block> WHITE_OAK_SIGN = BLOCKS.register("whiteoak_sign",
			() -> new ModStandingSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission()
					.strength(1.0F).sound(SoundType.WOOD), WoodTypesInit.WHITE_OAK));
	public static final RegistryObject<Block> WHITE_OAK_WALL_SIGN = BLOCKS.register("whiteoak_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.WHITE_OAK));
	public static final RegistryObject<Block> SILVER_WOOD_SIGN = BLOCKS.register("silverwood_sign",
			() -> new ModStandingSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission()
					.strength(1.0F).sound(SoundType.WOOD), WoodTypesInit.SILVER_WOOD));
	public static final RegistryObject<Block> SILVER_WOOD_WALL_SIGN = BLOCKS.register("silverwood_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.SILVER_WOOD));
	public static final RegistryObject<Block> WITCH_WOOD_SIGN = BLOCKS.register("witchwood_sign",
			() -> new ModStandingSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission()
					.strength(1.0F).sound(SoundType.WOOD), WoodTypesInit.WITCH_WOOD));
	public static final RegistryObject<Block> WITCH_WOOD_WALL_SIGN = BLOCKS.register("witchwood_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.WITCH_WOOD));
	public static final RegistryObject<Block> ALDER_SIGN = BLOCKS.register("alder_sign", () -> new ModStandingSignBlock(
			AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F).sound(SoundType.WOOD),
			WoodTypesInit.ALDER));
	public static final RegistryObject<Block> ALDER_WALL_SIGN = BLOCKS.register("alder_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.ALDER));
	public static final RegistryObject<Block> HAWTHORN_SIGN = BLOCKS.register("hawthorn_sign",
			() -> new ModStandingSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission()
					.strength(1.0F).sound(SoundType.WOOD), WoodTypesInit.HAWTHORN));
	public static final RegistryObject<Block> HAWTHORN_WALL_SIGN = BLOCKS.register("hawthorn_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.HAWTHORN));
	public static final RegistryObject<Block> ROWAN_SIGN = BLOCKS.register("rowan_sign", () -> new ModStandingSignBlock(
			AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F).sound(SoundType.WOOD),
			WoodTypesInit.ROWAN));
	public static final RegistryObject<Block> ROWAN_WALL_SIGN = BLOCKS.register("rowan_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.ROWAN));
	public static final RegistryObject<Block> WILLOW_SIGN = BLOCKS.register("willow_sign",
			() -> new ModStandingSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission()
					.strength(1.0F).sound(SoundType.WOOD), WoodTypesInit.WILLOW));
	public static final RegistryObject<Block> WILLOW_WALL_SIGN = BLOCKS.register("willow_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.WILLOW));
	public static final RegistryObject<Block> BEECH_SIGN = BLOCKS.register("beech_sign", () -> new ModStandingSignBlock(
			AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F).sound(SoundType.WOOD),
			WoodTypesInit.BEECH));
	public static final RegistryObject<Block> BEECH_WALL_SIGN = BLOCKS.register("beech_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.BEECH));
	public static final RegistryObject<Block> ASH_SIGN = BLOCKS.register("ash_sign", () -> new ModStandingSignBlock(
			AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F).sound(SoundType.WOOD),
			WoodTypesInit.ASH));
	public static final RegistryObject<Block> ASH_WALL_SIGN = BLOCKS.register("ash_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.ASH));
	public static final RegistryObject<Block> BLACKTHORN_SIGN = BLOCKS.register("blackthorn_sign",
			() -> new ModStandingSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission()
					.strength(1.0F).sound(SoundType.WOOD), WoodTypesInit.BLACKTHORN));
	public static final RegistryObject<Block> BLACKTHORN_WALL_SIGN = BLOCKS.register("blackthorn_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.BLACKTHORN));
	public static final RegistryObject<Block> CEDAR_SIGN = BLOCKS.register("cedar_sign", () -> new ModStandingSignBlock(
			AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F).sound(SoundType.WOOD),
			WoodTypesInit.CEDAR));
	public static final RegistryObject<Block> CEDAR_WALL_SIGN = BLOCKS.register("cedar_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.CEDAR));
	public static final RegistryObject<Block> ELDER_SIGN = BLOCKS.register("elder_sign", () -> new ModStandingSignBlock(
			AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F).sound(SoundType.WOOD),
			WoodTypesInit.ELDER));
	public static final RegistryObject<Block> ELDER_WALL_SIGN = BLOCKS.register("elder_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.ELDER));
	public static final RegistryObject<Block> JUNIPER_SIGN = BLOCKS.register("juniper_sign",
			() -> new ModStandingSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission()
					.strength(1.0F).sound(SoundType.WOOD), WoodTypesInit.JUNIPER));
	public static final RegistryObject<Block> JUNIPER_WALL_SIGN = BLOCKS.register("juniper_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.JUNIPER));
	public static final RegistryObject<Block> WITCHHAZEL_SIGN = BLOCKS.register("witchhazel_sign",
			() -> new ModStandingSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission()
					.strength(1.0F).sound(SoundType.WOOD), WoodTypesInit.WITCHHAZEL));
	public static final RegistryObject<Block> WITCHHAZEL_WALL_SIGN = BLOCKS.register("witchhazel_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.WITCHHAZEL));
	public static final RegistryObject<Block> YEW_SIGN = BLOCKS.register("yew_sign", () -> new ModStandingSignBlock(
			AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F).sound(SoundType.WOOD),
			WoodTypesInit.YEW));
	public static final RegistryObject<Block> YEW_WALL_SIGN = BLOCKS.register("yew_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.YEW));
	public static final RegistryObject<Block> INFESTED_SIGN = BLOCKS.register("infested_sign",
			() -> new ModStandingSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission()
					.strength(1.0F).sound(SoundType.WOOD), WoodTypesInit.INFESTED));
	public static final RegistryObject<Block> INFESTED_WALL_SIGN = BLOCKS.register("infested_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.INFESTED));
	public static final RegistryObject<Block> CHARRED_SIGN = BLOCKS.register("charred_sign",
			() -> new ModStandingSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission()
					.strength(1.0F).sound(SoundType.WOOD), WoodTypesInit.CHARRED));
	public static final RegistryObject<Block> CHARRED_WALL_SIGN = BLOCKS.register("charred_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.CHARRED));
	public static final RegistryObject<Block> ICY_SIGN = BLOCKS.register("icy_sign", () -> new ModStandingSignBlock(
			AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F).sound(SoundType.WOOD),
			WoodTypesInit.ICY));
	public static final RegistryObject<Block> ICY_WALL_SIGN = BLOCKS.register("icy_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.ICY));
	public static final RegistryObject<Block> TWISTED_SIGN = BLOCKS.register("twisted_sign",
			() -> new ModStandingSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission()
					.strength(1.0F).sound(SoundType.WOOD), WoodTypesInit.TWISTED));
	public static final RegistryObject<Block> TWISTED_WALL_SIGN = BLOCKS.register("twisted_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.TWISTED));
	public static final RegistryObject<Block> DISTORTED_SIGN = BLOCKS.register("distorted_sign",
			() -> new ModStandingSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission()
					.strength(1.0F).sound(SoundType.WOOD), WoodTypesInit.DISTORTED));
	public static final RegistryObject<Block> DISTORTED_WALL_SIGN = BLOCKS.register("distorted_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.DISTORTED));
	public static final RegistryObject<Block> HELLBARK_SIGN = BLOCKS.register("hellbark_sign",
			() -> new ModStandingSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission()
					.strength(1.0F).sound(SoundType.WOOD), WoodTypesInit.HELLBARK));
	public static final RegistryObject<Block> HELLBARK_WALL_SIGN = BLOCKS.register("hellbark_wall_sign",
			() -> new ModWallSignBlock(AbstractBlock.Properties.copy(Blocks.ACACIA_SIGN).noCollission().strength(1.0F)
					.sound(SoundType.WOOD), WoodTypesInit.HELLBARK));

	// Transparent Blocks
	public static final RegistryObject<Block> CRIMSON_ICE = BLOCKS.register("crimson_ice", () -> new ModIceBlock(
			Block.Properties.copy(Blocks.ICE).strength(0.3f, 0.2f).sound(SoundType.GLASS).friction(0.98f).randomTicks()));
	public static final RegistryObject<Block> CRIMSON_PACKEDICE = BLOCKS.register("crimson_packedice", () -> new Block(
			Block.Properties.copy(Blocks.PACKED_ICE).strength(0.3f, 0.2f).sound(SoundType.GLASS).friction(0.98f)));
	public static final RegistryObject<Block> BLACK_ICE = BLOCKS.register("black_ice", () -> new ModIceBlock(
			Block.Properties.copy(Blocks.ICE).strength(0.3f, 0.2f).sound(SoundType.GLASS).friction(0.98f).randomTicks()));
	public static final RegistryObject<Block> BLACK_PACKEDICE = BLOCKS.register("black_packedice",
			() -> new Block(Block.Properties.copy(Blocks.PACKED_ICE).strength(0.3f, 0.2f).sound(SoundType.GLASS)
					.friction(0.98f).speedFactor(0.7f).randomTicks().noOcclusion()));
	public static final RegistryObject<Block> PIXIE_GLASS = BLOCKS.register("pixie_glass", () -> new GlassBlock(
			Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> FAIRY_GLASS = BLOCKS.register("fairy_glass", () -> new GlassBlock(
			Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> CRIMSON_GLASS = BLOCKS.register("crimson_glass", () -> new GlassBlock(
			Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> ICY_GLASS = BLOCKS.register("icy_glass",
			() -> new GlassBlock(Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f).sound(SoundType.GLASS)
					.noOcclusion().friction(0.98f)));
	public static final RegistryObject<Block> EMBER_GLASS = BLOCKS.register("ember_glass", () -> new GlassBlock(
			Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> PIXIE_GLASS_PANE = BLOCKS.register("pixie_glass_pane",
			() -> new ModPaneBlock(
					Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> FAIRY_GLASS_PANE = BLOCKS.register("fairy_glass_pane",
			() -> new ModPaneBlock(
					Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> CRIMSON_GLASS_PANE = BLOCKS.register("crimson_glass_pane",
			() -> new ModPaneBlock(
					Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> ICY_GLASS_PANE = BLOCKS.register("icy_glass_pane", () -> new ModPaneBlock(
			Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> EMBER_GLASS_PANE = BLOCKS.register("ember_glass_pane",
			() -> new ModPaneBlock(Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f).sound(SoundType.GLASS)
					.noOcclusion().friction(0.98f)));

	// Glowstone/Torches
	public static final RegistryObject<Block> PURE_GLOWSTONE = BLOCKS.register("pure_glowstone",
			() -> new Block(Block.Properties.of(Material.GLASS).strength(2.0f, 10.0f).harvestLevel(2)
					.sound(SoundType.GLASS).lightLevel((state) -> 15)));
	public static final RegistryObject<Block> DARK_GLOWSTONE = BLOCKS.register("dark_glowstone",
			() -> new Block(Block.Properties.of(Material.GLASS).strength(2.0f, 10.0f).harvestLevel(2)
					.sound(SoundType.GLASS).lightLevel((state) -> 15)));

	// Mushrooms

	// Trophies
	public static final RegistryObject<Block> LILITH_TROPHY = BLOCKS.register("lilith_trophy",
			() -> new TrophyBlock(Block.Properties.copy(Blocks.STONE).strength(0.3f, 0.2f).harvestTool(ToolType.PICKAXE)
					.harvestLevel(0).noOcclusion()));
	public static final RegistryObject<Block> DEATH_TROPHY = BLOCKS.register("death_trophy",
			() -> new TrophyBlock(Block.Properties.copy(Blocks.STONE).strength(0.3f, 0.2f).harvestTool(ToolType.PICKAXE)
					.harvestLevel(0).noOcclusion()));
	public static final RegistryObject<Block> MIRROR_DEMON_TROPHY = BLOCKS.register("mirror_demon_trophy",
			() -> new TrophyBlock(Block.Properties.copy(Blocks.STONE).strength(0.3f, 0.2f).harvestTool(ToolType.PICKAXE)
					.harvestLevel(0)));
	public static final RegistryObject<Block> KRAKEN_TROPHY = BLOCKS.register("kraken_trophy",
			() -> new TrophyBlock(Block.Properties.copy(Blocks.STONE).strength(0.3f, 0.2f).harvestTool(ToolType.PICKAXE)
					.harvestLevel(0).noOcclusion()));
	public static final RegistryObject<Block> PRIDE_TROPHY = BLOCKS.register("pride_trophy",
			() -> new TrophyBlock(Block.Properties.copy(Blocks.STONE).strength(0.3f, 0.2f).harvestTool(ToolType.PICKAXE)
					.harvestLevel(0).noOcclusion()));
	public static final RegistryObject<Block> ENVY_TROPHY = BLOCKS.register("envy_trophy",
			() -> new TrophyBlock(Block.Properties.copy(Blocks.STONE).strength(0.3f, 0.2f).harvestTool(ToolType.PICKAXE)
					.harvestLevel(0).noOcclusion()));
	public static final RegistryObject<Block> GLUTTONY_TROPHY = BLOCKS.register("gluttony_trophy",
			() -> new TrophyBlock(Block.Properties.copy(Blocks.STONE).strength(0.3f, 0.2f).harvestTool(ToolType.PICKAXE)
					.harvestLevel(0)));
	public static final RegistryObject<Block> LUST_TROPHY = BLOCKS.register("lust_trophy",
			() -> new TrophyBlock(Block.Properties.copy(Blocks.STONE).strength(0.3f, 0.2f).harvestTool(ToolType.PICKAXE)
					.harvestLevel(0).noOcclusion()));
	public static final RegistryObject<Block> WRATH_TROPHY = BLOCKS.register("wrath_trophy",
			() -> new TrophyBlock(Block.Properties.copy(Blocks.STONE).strength(0.3f, 0.2f).harvestTool(ToolType.PICKAXE)
					.harvestLevel(0).noOcclusion()));
	public static final RegistryObject<Block> GREED_TROPHY = BLOCKS.register("greed_trophy",
			() -> new TrophyBlock(Block.Properties.copy(Blocks.STONE).strength(0.3f, 0.2f).harvestTool(ToolType.PICKAXE)
					.harvestLevel(0).noOcclusion()));
	public static final RegistryObject<Block> SLOTH_TROPHY = BLOCKS.register("sloth_trophy",
			() -> new TrophyBlock(Block.Properties.copy(Blocks.STONE).strength(0.3f, 0.2f).harvestTool(ToolType.PICKAXE)
					.harvestLevel(0).noOcclusion()));


	// Crops
	public static final RegistryObject<Block> VERVAIN_CROP = createCrop("vervain_crop", ItemInit.vervain_seeds);
	public static final RegistryObject<Block> wormwood_crop = createCrop("wormwood_crop", ItemInit.wormwood_seeds);
	public static final RegistryObject<Block> wolfsbane_crop = createCrop("wolfsbane_crop", ItemInit.wolfsbane_seeds);
	public static final RegistryObject<Block> garlic_crop = createCrop("garlic_crop", ItemInit.garlic_seeds);
	public static final RegistryObject<Block> belladonna_crop = createCrop("belladonna_crop", ItemInit.belladnna_seeds);
	public static final RegistryObject<Block> mandrake_crop = createCrop("mandrake_crop", ItemInit.mandrake_seeds);
	public static final RegistryObject<Block> foxgloves_crop = createCrop("foxgloves_crop", ItemInit.foxgloves_seeds);
	public static final RegistryObject<Block> nightshade_crop = createCrop("nightshade_crop",
			ItemInit.nightshade_seeds);
	public static final RegistryObject<Block> hellebore_crop = createCrop("hellebore_crop", ItemInit.hellebore_seeds);
	public static final RegistryObject<Block> whitesage_crop = createCrop("whitesage_crop", ItemInit.whitesage_seeds);
	public static final RegistryObject<Block> snowbell_crop = createCrop("snowbell_crop", ItemInit.snowbell_seeds);
	public static final RegistryObject<Block> waterartichoke_crop = BLOCKS.register("waterartichoke_crop",
			() -> new WaterartichokeCrop(Block.Properties.copy(Blocks.WHEAT)));

	private static RegistryObject<Block> createCrop(String registryName, RegistryObject<Item> seeds) {
		return BLOCKS.register(registryName, () -> new ModCropBlock(Block.Properties.copy(Blocks.WHEAT), seeds));
	}

	// Plants
	public static final RegistryObject<Block> BLOODY_ROSE = BLOCKS.register("bloody_rose",
			() -> new BloodyRose(Effects.HUNGER, 5,
					Block.Properties.copy(Blocks.POPPY).strength(0.3f, 0.2f).sound(SoundType.VINE)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_BLOODY_ROSE = BLOCKS.register("potted_bloody_rose",
			() -> new FlowerPotBlock(BlockInit.BLOODY_ROSE.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	public static final RegistryObject<Block> GlOW_FLOWER = BLOCKS.register("glow_flower",
			() -> new FlowerBlock(Effects.NIGHT_VISION, 5, Block.Properties.copy(Blocks.DANDELION).strength(0.3f, 0.2f)
					.sound(SoundType.VINE).lightLevel((state) -> 10)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_GlOW_FLOWER = BLOCKS.register("potted_glow_flower",
			() -> new FlowerPotBlock(BlockInit.GlOW_FLOWER.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	public static final RegistryObject<Block> BONE_FLOWER = BLOCKS.register("bone_flower", () -> new FlowerBlock(
			Effects.BLINDNESS, 5,
			Block.Properties.copy(Blocks.POPPY).strength(0.3f, 0.2f).sound(SoundType.VINE).lightLevel((state) -> 10)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_BONE_FLOWER = BLOCKS.register("potted_bone_flower",
			() -> new FlowerPotBlock(BlockInit.BONE_FLOWER.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	public static final RegistryObject<Block> FIRE_FLOWER = BLOCKS.register("fire_flower", () -> new FlowerBlock(
			Effects.FIRE_RESISTANCE, 5,
			Block.Properties.copy(Blocks.POPPY).strength(0.3f, 0.2f).sound(SoundType.VINE).lightLevel((state) -> 10)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_FIRE_FLOWER = BLOCKS.register("potted_fire_flower",
			() -> new FlowerPotBlock(BlockInit.FIRE_FLOWER.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	public static final RegistryObject<Block> PRICKLY_FLOWER = BLOCKS.register("prickly_flower", () -> new FlowerBlock(
			Effects.DAMAGE_BOOST, 5,
			Block.Properties.copy(Blocks.POPPY).strength(0.3f, 0.2f).sound(SoundType.VINE).lightLevel((state) -> 10)));
	public static final RegistryObject<Block> SCORCHED_FLOWER = BLOCKS.register("scorched_flower",
			() -> new FlowerBlock(Effects.DIG_SPEED, 5, Block.Properties.copy(Blocks.POPPY).strength(0.3f, 0.2f)
					.sound(SoundType.VINE).lightLevel((state) -> 10)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_SCORCHED_FLOWER = BLOCKS.register("potted_scorched_flower",
			() -> new FlowerPotBlock(BlockInit.SCORCHED_FLOWER.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	public static final RegistryObject<Block> GRASSPER = BLOCKS.register("grassper",
			() -> new GrassperBlock(Block.Properties.copy(Blocks.POPPY).strength(0.3f, 0.2f).sound(SoundType.VINE)));
	public static final RegistryObject<Block> WEEPING_VINES = BLOCKS.register("weeping_vines",
			() -> new VineBlock(Block.Properties.copy(Blocks.VINE)));
	public static final RegistryObject<Block> SPANISH_MOSS = BLOCKS.register("spanish_moss",
			() -> new VineBlock(Block.Properties.copy(Blocks.VINE)));
	public static final RegistryObject<Block> WITCHES_LADDER_TOP = BLOCKS.register("witches_ladder_top",
			() -> new WitchesLadderTopBlock(Block.Properties.copy(Blocks.WEEPING_VINES).randomTicks()
					.noCollission()));
	public static final RegistryObject<Block> WITCHES_LADDER_PLANT = BLOCKS.register("witches_ladder_plant",
			() -> new WitchesLadderBlock(Block.Properties.copy(Blocks.WEEPING_VINES_PLANT).sound(SoundType.WET_GRASS).randomTicks()
					.noCollission()));
	public static final RegistryObject<Block> EMBER_MOSS = BLOCKS.register("ember_moss",
			() -> new EmberMossBlock(Block.Properties.copy(Blocks.VINE)));
	public static final RegistryObject<Block> LIVING_KELP_TOP = BLOCKS.register("living_kelp_top",
			() -> new ModKelpTopBlock(Block.Properties.copy(Blocks.KELP_PLANT).sound(SoundType.WET_GRASS).randomTicks()
					.noCollission().lightLevel((state) -> 15)));
	public static final RegistryObject<Block> LIVING_KELP_PLANT = BLOCKS.register("living_kelp_plant",
			() -> new ModKelpBlock(Block.Properties.copy(Blocks.KELP_PLANT).sound(SoundType.WET_GRASS).randomTicks()
					.noCollission().lightLevel((state) -> 15)));
	public static final RegistryObject<Block> DEAD_LIVING_CORAL = BLOCKS.register("dead_livingcoral",
			() -> new DeadCoralPlantBlock(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL).noCollission().instabreak()));
	public static final RegistryObject<Block> LIVING_CORAL = BLOCKS.register("livingcoral",
			() -> new CoralPlantBlock(BlockInit.DEAD_LIVING_CORAL.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL).noCollission().instabreak())));
	public static final RegistryObject<Block> DEAD_LIVING_CORAL_BLOCK = BLOCKS.register("dead_livingcoral_block",
			() -> new Block(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_BLOCK)));
	public static final RegistryObject<Block> LIVING_CORAL_BLOCK = BLOCKS.register("livingcoral_block",
			() -> new CoralBlock(BlockInit.DEAD_LIVING_CORAL_BLOCK.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL_BLOCK).lightLevel((state) -> 15))));
	public static final RegistryObject<Block> DEAD_LIVING_CORAL_FAN = BLOCKS.register("dead_livingcoral_fan",
			() -> new CoralFanBlock(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_BLOCK).noCollission().instabreak()));
	public static final RegistryObject<Block> LIVING_CORAL_FAN = BLOCKS.register("livingcoral_fan",
			() -> new CoralFinBlock(BlockInit.DEAD_LIVING_CORAL_FAN.get(), (Block.Properties
					.copy(Blocks.BRAIN_CORAL_FAN).noCollission().instabreak().lightLevel((state) -> 15))));
	public static final RegistryObject<Block> DEAD_LIVING_CORAL_WALL_FAN = BLOCKS.register("dead_livingcoral_wall_fan",
			() -> new DeadCoralWallFanBlock(
					Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_WALL_FAN).noCollission().instabreak()));
	public static final RegistryObject<Block> LIVING_CORAL_WALL_FAN = BLOCKS.register("livingcoral_wall_fan",
			() -> new CoralWallFanBlock(BlockInit.DEAD_LIVING_CORAL_WALL_FAN.get(), (Block.Properties
					.copy(Blocks.BRAIN_CORAL_WALL_FAN).noCollission().instabreak().lightLevel((state) -> 15))));
	public static final RegistryObject<Block> DEAD_BLOODLY_CORAL = BLOCKS.register("dead_bloodlycoral",
			() -> new DeadCoralPlantBlock(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL).noCollission().instabreak()));
	public static final RegistryObject<Block> BLOODLY_CORAL = BLOCKS.register("bloodlycoral",
			() -> new CoralPlantBlock(BlockInit.DEAD_BLOODLY_CORAL.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL).noCollission().instabreak())));
	public static final RegistryObject<Block> DEAD_BLOODLY_CORAL_BLOCK = BLOCKS.register("dead_bloodlycoral_block",
			() -> new Block(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_BLOCK)));
	public static final RegistryObject<Block> BLOODLY_CORAL_BLOCK = BLOCKS.register("bloodlycoral_block",
			() -> new CoralBlock(BlockInit.DEAD_BLOODLY_CORAL_BLOCK.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL_BLOCK))));
	public static final RegistryObject<Block> DEAD_BLOODLY_CORAL_FAN = BLOCKS.register("dead_bloodlycoral_fan",
			() -> new CoralFanBlock(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_BLOCK).noCollission().instabreak()));
	public static final RegistryObject<Block> BLOODLY_CORAL_FAN = BLOCKS.register("bloodlycoral_fan",
			() -> new CoralFinBlock(BlockInit.DEAD_BLOODLY_CORAL_FAN.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL_FAN).noCollission().instabreak())));
	public static final RegistryObject<Block> DEAD_BLOODLY_CORAL_WALL_FAN = BLOCKS
			.register("dead_bloodlycoral_wall_fan", () -> new DeadCoralWallFanBlock(
					Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_WALL_FAN).noCollission().instabreak()));
	public static final RegistryObject<Block> BLOODLY_CORAL_WALL_FAN = BLOCKS.register("bloodlycoral_wall_fan",
			() -> new CoralWallFanBlock(BlockInit.DEAD_BLOODLY_CORAL_WALL_FAN.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL_WALL_FAN).noCollission().instabreak())));
	public static final RegistryObject<Block> DEAD_TWILIGHT_CORAL = BLOCKS.register("dead_twilightcoral",
			() -> new DeadCoralPlantBlock(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL).noCollission().instabreak()));
	public static final RegistryObject<Block> TWILIGHT_CORAL = BLOCKS.register("twilightcoral",
			() -> new CoralPlantBlock(BlockInit.DEAD_TWILIGHT_CORAL.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL).noCollission().instabreak())));
	public static final RegistryObject<Block> DEAD_TWILIGHT_CORAL_BLOCK = BLOCKS.register("dead_twilightcoral_block",
			() -> new Block(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_BLOCK)));
	public static final RegistryObject<Block> TWILIGHT_CORAL_BLOCK = BLOCKS.register("twilightcoral_block",
			() -> new CoralBlock(BlockInit.DEAD_TWILIGHT_CORAL_BLOCK.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL_BLOCK))));
	public static final RegistryObject<Block> DEAD_TWILIGHT_CORAL_FAN = BLOCKS.register("dead_twilightcoral_fan",
			() -> new CoralFanBlock(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_BLOCK).noCollission().instabreak()));
	public static final RegistryObject<Block> TWILIGHT_CORAL_FAN = BLOCKS.register("twilightcoral_fan",
			() -> new CoralFinBlock(BlockInit.DEAD_TWILIGHT_CORAL_FAN.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL_FAN).noCollission().instabreak())));
	public static final RegistryObject<Block> DEAD_TWILIGHT_CORAL_WALL_FAN = BLOCKS
			.register("dead_twilightcoral_wall_fan", () -> new DeadCoralWallFanBlock(
					Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_WALL_FAN).noCollission().instabreak()));
	public static final RegistryObject<Block> TWILIGHT_CORAL_WALL_FAN = BLOCKS.register("twilightcoral_wall_fan",
			() -> new CoralWallFanBlock(BlockInit.DEAD_TWILIGHT_CORAL_WALL_FAN.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL_WALL_FAN).noCollission().instabreak())));
	public static final RegistryObject<Block> DEAD_CRIMSON_CORAL = BLOCKS.register("dead_crimsoncoral",
			() -> new DeadCoralPlantBlock(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL).noCollission().instabreak()));
	public static final RegistryObject<Block> CRIMSON_CORAL = BLOCKS.register("crimsoncoral",
			() -> new CoralPlantBlock(BlockInit.DEAD_CRIMSON_CORAL.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL).noCollission().instabreak())));
	public static final RegistryObject<Block> DEAD_CRIMSON_CORAL_BLOCK = BLOCKS.register("dead_crimsoncoral_block",
			() -> new Block(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_BLOCK)));
	public static final RegistryObject<Block> CRIMSON_CORAL_BLOCK = BLOCKS.register("crimsoncoral_block",
			() -> new CoralBlock(BlockInit.DEAD_CRIMSON_CORAL_BLOCK.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL_BLOCK))));
	public static final RegistryObject<Block> DEAD_CRIMSON_CORAL_FAN = BLOCKS.register("dead_crimsoncoral_fan",
			() -> new CoralFanBlock(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_BLOCK).noCollission().instabreak()));
	public static final RegistryObject<Block> CRIMSON_CORAL_FAN = BLOCKS.register("crimsoncoral_fan",
			() -> new CoralFinBlock(BlockInit.DEAD_CRIMSON_CORAL_FAN.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL_FAN).noCollission().instabreak())));
	public static final RegistryObject<Block> DEAD_CRIMSON_CORAL_WALL_FAN = BLOCKS
			.register("dead_crimsoncoral_wall_fan", () -> new DeadCoralWallFanBlock(
					Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_WALL_FAN).noCollission().instabreak()));
	public static final RegistryObject<Block> CRIMSON_CORAL_WALL_FAN = BLOCKS.register("crimsoncoral_wall_fan",
			() -> new CoralWallFanBlock(BlockInit.DEAD_CRIMSON_CORAL_WALL_FAN.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL_WALL_FAN).noCollission().instabreak())));
	public static final RegistryObject<Block> DEAD_ICY_CORAL = BLOCKS.register("dead_icycoral",
			() -> new DeadCoralPlantBlock(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL).noCollission().instabreak()));
	public static final RegistryObject<Block> ICY_CORAL = BLOCKS.register("icycoral",
			() -> new CoralPlantBlock(BlockInit.DEAD_ICY_CORAL.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL).noCollission().instabreak())));
	public static final RegistryObject<Block> DEAD_ICY_CORAL_BLOCK = BLOCKS.register("dead_icycoral_block",
			() -> new Block(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_BLOCK)));
	public static final RegistryObject<Block> ICY_CORAL_BLOCK = BLOCKS.register("icycoral_block",
			() -> new CoralBlock(BlockInit.DEAD_ICY_CORAL_BLOCK.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL_BLOCK))));
	public static final RegistryObject<Block> DEAD_ICY_CORAL_FAN = BLOCKS.register("dead_icycoral_fan",
			() -> new CoralFanBlock(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_BLOCK).noCollission().instabreak()));
	public static final RegistryObject<Block> ICY_CORAL_FAN = BLOCKS.register("icycoral_fan",
			() -> new CoralFinBlock(BlockInit.DEAD_ICY_CORAL_FAN.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL_FAN).noCollission().instabreak())));
	public static final RegistryObject<Block> DEAD_ICY_CORAL_WALL_FAN = BLOCKS.register("dead_icycoral_wall_fan",
			() -> new DeadCoralWallFanBlock(
					Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_WALL_FAN).noCollission().instabreak()));
	public static final RegistryObject<Block> ICY_CORAL_WALL_FAN = BLOCKS.register("icycoral_wall_fan",
			() -> new CoralWallFanBlock(BlockInit.DEAD_ICY_CORAL_WALL_FAN.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL_WALL_FAN).noCollission().instabreak())));
	public static final RegistryObject<Block> DEAD_DRAGON_CORAL = BLOCKS.register("dead_dragoncoral",
			() -> new DeadCoralPlantBlock(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL).noCollission().instabreak()));
	public static final RegistryObject<Block> DRAGON_CORAL = BLOCKS.register("dragoncoral",
			() -> new CoralPlantBlock(BlockInit.DEAD_DRAGON_CORAL.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL).noCollission().instabreak())));
	public static final RegistryObject<Block> DEAD_DRAGON_CORAL_BLOCK = BLOCKS.register("dead_dragoncoral_block",
			() -> new Block(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_BLOCK)));
	public static final RegistryObject<Block> DRAGON_CORAL_BLOCK = BLOCKS.register("dragoncoral_block",
			() -> new CoralBlock(BlockInit.DEAD_DRAGON_CORAL_BLOCK.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL_BLOCK))));
	public static final RegistryObject<Block> DEAD_DRAGON_CORAL_FAN = BLOCKS.register("dead_dragoncoral_fan",
			() -> new CoralFanBlock(Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_BLOCK).noCollission().instabreak()));
	public static final RegistryObject<Block> DRAGON_CORAL_FAN = BLOCKS.register("dragoncoral_fan",
			() -> new CoralFinBlock(BlockInit.DEAD_DRAGON_CORAL_FAN.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL_FAN).noCollission().instabreak())));
	public static final RegistryObject<Block> DEAD_DRAGON_CORAL_WALL_FAN = BLOCKS.register("dead_dragoncoral_wall_fan",
			() -> new DeadCoralWallFanBlock(
					Block.Properties.copy(Blocks.DEAD_BRAIN_CORAL_WALL_FAN).noCollission().instabreak()));
	public static final RegistryObject<Block> DRAGON_CORAL_WALL_FAN = BLOCKS.register("dragoncoral_wall_fan",
			() -> new CoralWallFanBlock(BlockInit.DEAD_DRAGON_CORAL_WALL_FAN.get(),
					(Block.Properties.copy(Blocks.BRAIN_CORAL_WALL_FAN).noCollission().instabreak())));
	public static final RegistryObject<Block> WILD_BRAMBLE = BLOCKS.register("wild_bramble",
			() -> new WildBrambleBlock(Block.Properties.copy(Blocks.SUGAR_CANE).randomTicks().noCollission()));
	public static final RegistryObject<Block> ENDER_BRAMBLE = BLOCKS.register("ender_bramble",
			() -> new EnderBrambleBlock(
					Block.Properties.copy(Blocks.SUGAR_CANE).randomTicks().noCollission().harvestTool(ToolType.AXE)));
	public static final RegistryObject<Block> SCORCHED_GRASS_SMALL = BLOCKS.register("scorched_grass_small",
			() -> new TallGrassBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BLACK)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> TAll_SCORCHED_GRASS_SMALL = BLOCKS.register("tall_scorched_grass_small",
			() -> new DoublePlantBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BLACK)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> TALL_SCORCHED_GRASS = BLOCKS.register("tall_scorched_grass",
			() -> new DoublePlantBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BLACK)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> SCORCHED_GRASS = BLOCKS.register("scorched_grass",
			() -> new TallGrassBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BLACK)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> SCORCHED_GRASS_MEDIUM = BLOCKS.register("scorched_grass_medium",
			() -> new TallGrassBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BLACK)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> TALL_SCORCHED_GRASS_MEDIUM = BLOCKS.register("tall_scorched_grass_medium",
			() -> new DoublePlantBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BLACK)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> SCORCHED_GRASS_GLOWING = BLOCKS.register("scorched_grass_glowing",
			() -> new GlowingScorchedGrassBlock(
					Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BLACK).sound(SoundType.GRASS)
							.lightLevel((state) -> 10).noCollission().instabreak()));
	public static final RegistryObject<Block> TALL_SCORCHED_GRASS_GLOWING = BLOCKS.register(
			"tall_scorched_grass_glowing",
			() -> new DoubbleGlowingScorchedGrassBlock(
					Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BLACK).sound(SoundType.GRASS)
							.lightLevel((state) -> 10).noCollission().instabreak()));
	public static final RegistryObject<Block> INFESTED_GRASS = BLOCKS.register("infested_grass",
			() -> new TallGrassBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_PURPLE)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> TAll_INFESTED_GRASS = BLOCKS.register("tall_infested_grass",
			() -> new DoublePlantBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_PURPLE)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> CHARRED_GRASS = BLOCKS.register("charred_grass",
			() -> new TallGrassBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BLACK)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> TAll_CHARRED_GRASS = BLOCKS.register("tall_charred_grass",
			() -> new DoublePlantBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_PURPLE)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> BLOODLY_GRASS = BLOCKS.register("bloodly_grass",
			() -> new TallGrassBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_RED)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> TAll_BLOODLY_GRASS = BLOCKS.register("tall_bloodly_grass",
			() -> new DoublePlantBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_PURPLE)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> MYSTIC_GRASS = BLOCKS.register("mystic_grass",
			() -> new TallGrassBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_PURPLE)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> TAll_MYSTIC_GRASS = BLOCKS.register("tall_mystic_grass",
			() -> new DoublePlantBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_PURPLE)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> DEEP_GRASS = BLOCKS.register("deep_grass",
			() -> new TallGrassBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BROWN)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> TAll_DEEP_GRASS = BLOCKS.register("tall_deep_grass",
			() -> new DoublePlantBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_PURPLE)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> GLINT_WEED = BLOCKS.register("glint_weed",
			() -> new TallGrassBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BLACK)
					.sound(SoundType.GRASS).lightLevel((state) -> 10).noCollission().instabreak()));
	public static final RegistryObject<Block> WISPY_COTTON = BLOCKS.register("wispy_cotton",
			() -> new TallGrassBlock(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_BLACK)
					.sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> ENDER_CACTUS = BLOCKS.register("ender_cactus",
			() -> new EnderCactusBlock(Block.Properties.copy(Blocks.CACTUS).randomTicks().harvestTool(ToolType.AXE)));
	public static final RegistryObject<Block> SEA_CANDLES = BLOCKS.register("sea_candles", () -> new SeaCandlesBlock(
			Block.Properties.copy(Blocks.SEA_PICKLE).strength(0.3f, 0.2f).sound(SoundType.WET_GRASS).noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_ENDER_CACTUS = BLOCKS.register("potted_ender_cactus",
			() -> new FlowerPotBlock(BlockInit.ENDER_CACTUS.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_BLOODOAK_SAPLING = BLOCKS.register("potted_bloodoak_sapling",
			() -> new FlowerPotBlock(WoodTypes.BLOODOAK.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_WHITEOAK_SAPLING = BLOCKS.register("potted_whiteoak_sapling",
			() -> new FlowerPotBlock(WoodTypes.WHITEOAK.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_SILVERWOOD_SAPLING = BLOCKS.register("potted_silverwood_sapling",
			() -> new FlowerPotBlock(WoodTypes.SILVERWOOD.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_WITCHWOOD_SAPLING = BLOCKS.register("potted_witchwood_sapling",
			() -> new FlowerPotBlock(WoodTypes.WITCHWOOD.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_ALDER_SAPLING = BLOCKS.register("potted_alder_sapling",
			() -> new FlowerPotBlock(WoodTypes.ALDER.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_HAWTHORN_SAPLING = BLOCKS.register("potted_hawthorn_sapling",
			() -> new FlowerPotBlock(WoodTypes.HAWTHORN.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_ROWAN_SAPLING = BLOCKS.register("potted_rowan_sapling",
			() -> new FlowerPotBlock(WoodTypes.ROWAN.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_WILLOW_SAPLING = BLOCKS.register("potted_willow_sapling",
			() -> new FlowerPotBlock(WoodTypes.WILLOW.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_BEECH_SAPLING = BLOCKS.register("potted_beech_sapling",
			() -> new FlowerPotBlock(WoodTypes.BEECH.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_ASH_SAPLING = BLOCKS.register("potted_ash_sapling",
			() -> new FlowerPotBlock(WoodTypes.ASH.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_BLACKTHORN_SAPLING = BLOCKS.register("potted_blackthorn_sapling",
			() -> new FlowerPotBlock(WoodTypes.BLACKTHORN.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_CEDAR_SAPLING = BLOCKS.register("potted_cedar_sapling",
			() -> new FlowerPotBlock(WoodTypes.CEDAR.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_ELDER_SAPLING = BLOCKS.register("potted_elder_sapling",
			() -> new FlowerPotBlock(WoodTypes.ELDER.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_JUNIPER_SAPLING = BLOCKS.register("potted_juniper_sapling",
			() -> new FlowerPotBlock(WoodTypes.JUNIPER.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_WITCHHAZEL_SAPLING = BLOCKS.register("potted_witchhazel_sapling",
			() -> new FlowerPotBlock(WoodTypes.WITCHHAZEL.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_YEW_SAPLING = BLOCKS.register("potted_yew_sapling",
			() -> new FlowerPotBlock(WoodTypes.YEW.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_INFESTED_SAPLING = BLOCKS.register("potted_infested_sapling",
			() -> new FlowerPotBlock(WoodTypes.INFESTED.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_CHARRED_SAPLING = BLOCKS.register("potted_charred_sapling",
			() -> new FlowerPotBlock(WoodTypes.CHARRED.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_ICY_SAPLING = BLOCKS.register("potted_icy_sapling",
			() -> new FlowerPotBlock(WoodTypes.ICY.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_TWISTED_SAPLING = BLOCKS.register("potted_twisted_sapling",
			() -> new FlowerPotBlock(WoodTypes.TWISTED.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_DISTORTED_SAPLING = BLOCKS.register("potted_distorted_sapling",
			() -> new FlowerPotBlock(WoodTypes.DISTORTED.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_HELLBARK_SAPLING = BLOCKS.register("potted_hellbark_sapling",
			() -> new FlowerPotBlock(WoodTypes.HELLBARK.sapling.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));

	// Special blocks
	public static final RegistryObject<Block> PANDORS_BOX = BLOCKS.register("pandors_box",
			() -> new PandorsBox(Block.Properties.copy(Blocks.BONE_BLOCK).noOcclusion().harvestTool(ToolType.PICKAXE)
					.harvestLevel(1).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> PANDORS_BOX_OPEN = BLOCKS.register("pandors_box_open",
			() -> new PandorsBoxOpen(Block.Properties.copy(Blocks.BONE_BLOCK).noOcclusion()
					.harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> MAGIC_QUARRY = BLOCKS.register("magic_quarry",
			() -> new QuarryBlock(Block.Properties.of(Material.METAL).sound(SoundType.LANTERN).noOcclusion()
					.harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> MAGIC_MIRROR = BLOCKS.register("magic_mirror",
			() -> new MagicMirrorBlock(Block.Properties.of(Material.GLASS).sound(SoundType.GLASS).noOcclusion()
					.harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> STATUE_OF_BOKEN_CURSES = BLOCKS.register("statue_of_broken_curses",
			() -> new StatueOfBrokenCursesBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).noOcclusion()
					.harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> CRYSTAL_BALL = BLOCKS.register("crystal_ball",
			() -> new CrystalBallBlock(Block.Properties.of(Material.GLASS).sound(SoundType.GLASS).noOcclusion()
					.harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> BROKEN_CRYSTAL_BALL = BLOCKS.register("broken_crystal_ball",
			() -> new BrokenCrystalBallBlock(Block.Properties.of(Material.GLASS).sound(SoundType.GLASS).noOcclusion()
					.harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> MOB_SLAYER = BLOCKS.register("mob_slayer",
			() -> new MobSlayerBlock(Block.Properties.copy(Blocks.SLIME_BLOCK).harvestTool(ToolType.PICKAXE)
					.harvestLevel(0).sound(SoundType.FUNGUS)));
	public static final RegistryObject<Block> AMETHYST_CHIMES = BLOCKS.register("amethyst_chimes",
			() -> new AmethystChimesBlock(Block.Properties.copy(Blocks.IRON_BLOCK).harvestTool(ToolType.PICKAXE)
					.harvestLevel(1).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> DEMON_HEART = BLOCKS.register("demon_heart", () -> new DemonHeartBlock(
			Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.WET_GRASS).harvestLevel(0).noOcclusion()));
	public static final RegistryObject<Block> WITCHES_OVEN = BLOCKS.register("witches_oven",
			() -> new WitchesOvenBlock(Block.Properties.copy(Blocks.FURNACE).harvestTool(ToolType.PICKAXE)
					.harvestLevel(1).sound(SoundType.METAL).requiresCorrectToolForDrops()));

	// class
	public static final RegistryObject<Block> PEDESTAL_TIER1 = BLOCKS.register("pedestal_tier1",
			() -> new PedestalBlock(1, Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> PEDESTAL_TIER2 = BLOCKS.register("pedestal_tier2",
			() -> new PedestalBlock(2, Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> PEDESTAL_TIER3 = BLOCKS.register("pedestal_tier3",
			() -> new PedestalBlock(3, Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> PEDESTAL_TIER4 = BLOCKS.register("pedestal_tier4",
			() -> new PedestalBlock(4, Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> PEDESTAL_TIER5 = BLOCKS.register("pedestal_tier5",
			() -> new PedestalBlock(5, Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> PEDESTAL_TIER6 = BLOCKS.register("pedestal_tier6",
			() -> new PedestalBlock(6, Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> HELL_FIRE = BLOCKS.register("hell_fire",
			() -> new HellFireBlock(Block.Properties.of(Material.FIRE).strength(0.5f, 15.0f)
					.sound(SoundType.HONEY_BLOCK).noOcclusion().lightLevel((state) -> 15)));

	public static final DeferredRegister<Block> NO_ITEM_BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS,
			MythicCraft.MOD_ID);

	public static final RegistryObject<Block> ICY_BERRY_BUSH = NO_ITEM_BLOCK.register("icy_berry_bush",
			() -> new IcyBerryBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> BLOOD_BERRY_BUSH = NO_ITEM_BLOCK.register("blood_berry_bush",
			() -> new BloodBerryBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> SILVER_BERRY_BUSH = NO_ITEM_BLOCK.register("silver_berry_bush",
			() -> new SilverBerryBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> CHARRED_BERRY_BUSH = NO_ITEM_BLOCK.register("charred_berry_bush",
			() -> new CharredBerryBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> SOUL_BERRY_BUSH = NO_ITEM_BLOCK.register("soul_berry_bush",
			() -> new SoulBerryBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> INFESTED_BERRY_BUSH = NO_ITEM_BLOCK.register("infested_berry_bush",
			() -> new InfestedBerryBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> MYSTIC_BERRY_BUSH = NO_ITEM_BLOCK.register("mystic_berry_bush",
			() -> new MysticBerryBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> CINDER_FRUIT_PLANT = NO_ITEM_BLOCK.register("cinder_fruit_plant",
			() -> new CinderPlantBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH).lightLevel((state) -> 13), ParticleTypes.SMOKE));
}