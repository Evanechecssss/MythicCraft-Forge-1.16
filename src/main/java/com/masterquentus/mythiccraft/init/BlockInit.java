package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
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
import java.util.function.Supplier;

public class BlockInit {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			MythicCraft.MOD_ID);


	// ****** Wood Types ****** //
	// to add a new type of wood just add its name to this array and make the assets
	// TODO: data generators for models, land, blockstates, loot tables
	// TODO: autogenerate blocks for stone varients below
	private static String[] woodTypes = {"bloodoak", "whiteoak", "silverwood", "witchwood", "alder", "hawthorn", "rowan", "willow", "beech", "ash",
			"blackthorn", "cedar", "elder", "juniper", "witchhazel", "yew", "infested", "charred", "distorted", "icy", "twisted"};

	public static class WoodType{
		public final String name;
		public final Supplier<Block> log;
		public final Supplier<Block> wood;
		public final Supplier<Block> strippedLog;
		public final Supplier<Block> strippedWood;
		public final Supplier<Block> plank;
		public final Supplier<Block> leaves;
		public final Supplier<Block> door;
		public final Supplier<Block> crate;
		public final Supplier<Block> trapdoor;
		public final Supplier<Block> stairs;
		public final Supplier<Block> slab;
		public final Supplier<Block> button;
		public final Supplier<Block> pressureplate;
		public final Supplier<Block> fence;
		public final Supplier<Block> gate;
		public final Supplier<Block> sapling;
		public final ModTree tree;

		public WoodType(String name, Supplier<Block> log, Supplier<Block> strippedLog, Supplier<Block> wood, Supplier<Block> strippedWood,
						Supplier<Block> plank, Supplier<Block> leaves, Supplier<Block> door, Supplier<Block> crate, Supplier<Block> trapdoor,
						Supplier<Block> stairs, Supplier<Block> slab, Supplier<Block> button, Supplier<Block> pressureplate,
						Supplier<Block> fence, Supplier<Block> gate, Supplier<Block> sapling, ModTree tree){
			this.name = name;
			this.log = log;
			this.strippedLog = strippedLog;
			this.wood = wood;
			this.strippedWood = strippedWood;
			this.plank = plank;
			this.leaves = leaves;
			this.door = door;
			this.crate = crate;
			this.trapdoor = trapdoor;
			this.stairs = stairs;
			this.slab = slab;
			this.button = button;
			this.pressureplate = pressureplate;
			this.fence = fence;
			this.gate = gate;
			this.sapling = sapling;
			this.tree = tree;
		}
	}

	public static Map<String, WoodType> WOOD_TYPES = new HashMap<>();
	static {
		for (String name : woodTypes){
			ModTree tree = new ModTree(name);
			WOOD_TYPES.put(name, new WoodType(name,
					BLOCKS.register(name + "_log", () -> new ModLogBlock(MaterialColor.COLOR_RED, false)),
					BLOCKS.register(name + "_stripped_log", () -> new ModLogBlock(MaterialColor.COLOR_RED, true)),
					BLOCKS.register(name + "_wood", () -> new ModLogBlock(MaterialColor.COLOR_RED, false)),
					BLOCKS.register(name + "_stripped_wood", () -> new ModLogBlock(MaterialColor.COLOR_RED, true)),
					BLOCKS.register(name + "_planks", () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS))),
					BLOCKS.register(name + "_leaves", () -> new LeavesBlock(Block.Properties.copy(Blocks.OAK_LEAVES))),
					BLOCKS.register(name + "_door", () -> new ModDoor(Block.Properties.copy(Blocks.OAK_LEAVES))),
					BLOCKS.register(name + "_crate", () -> new CrateBlock(Block.Properties.copy(Blocks.BARREL))),
					BLOCKS.register(name + "_trapdoor", () -> new ModTrapDoor(Block.Properties.copy(Blocks.OAK_TRAPDOOR))),
					BLOCKS.register(name + "_stairs", () -> new StairsBlock(() -> BlockInit.WOOD_TYPES.get(name).plank.get().defaultBlockState(), Block.Properties.of(Material.WOOD, MaterialColor.COLOR_RED))),
					BLOCKS.register(name + "_slab", () -> new SlabBlock(Block.Properties.copy(BlockInit.WOOD_TYPES.get(name).plank.get()))),
					BLOCKS.register(name + "_button", () -> new ModWoodButtonBlock(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_RED))),
					BLOCKS.register(name + "_pressureplate", () -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOD, MaterialColor.COLOR_RED))),
					BLOCKS.register(name + "_fence", () -> new FenceBlock(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_RED))),
					BLOCKS.register(name + "_fence_gate", () -> new FenceGateBlock(Block.Properties.copy(Blocks.OAK_FENCE_GATE))),
					BLOCKS.register(name + "_sapling", () -> new SaplingBlock(tree, Block.Properties.copy(Blocks.OAK_SAPLING))),
					tree
			));
		}


	}

	public static Block[] getAllCrates(){
		List<WoodType> types = new ArrayList<>();
		WOOD_TYPES.forEach((string, type) -> {
			types.add(type);
		});
		Block[] crates = new Block[BlockInit.WOOD_TYPES.size()];
		for (int i=0;i<BlockInit.WOOD_TYPES.size();i++) {
			crates[i] = types.get(i).crate.get();
		}

		return crates;
	}

	// Ores
	public static final RegistryObject<Block> VAMPIRIC_ORE = BLOCKS.register("vampiric_ore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> VAMPIRIC_NETHERORE = BLOCKS.register("vampiric_netherore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> VAMPIRIC_ENDORE = BLOCKS.register("vampiric_endore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> MYTHICDIAMOND_ORE = BLOCKS.register("mythicdiamond_ore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)));
	public static final RegistryObject<Block> MYTHICDIAMOND_NETHERORE = BLOCKS.register("mythicdiamond_netherore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)));
	public static final RegistryObject<Block> MYTHICDIAMOND_ENDORE = BLOCKS.register("mythicdiamond_endore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> SILVER_NETHERORE = BLOCKS.register("silver_netherore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> SILVER_ENDORE = BLOCKS.register("silver_endore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> DRAGONHEART_ORE = BLOCKS.register("dragonheart_ore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> DRAGONHEART_NETHERORE = BLOCKS.register("dragonheart_netherore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> DRAGONHESRT_ENDORE = BLOCKS.register("dragonheart_endore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> BLOODSTONE_ORE = BLOCKS.register("bloodstone_ore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> BLOODSTONE_NETHERORE = BLOCKS.register("bloodstone_netherore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> BLOODSTONE_ENDORE = BLOCKS.register("bloodstone_endore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> MOONSTONE_ORE = BLOCKS.register("moonstone_ore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> MOONSTONE_NETHERORE = BLOCKS.register("moonstone_netherore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> MOONSTONE_ENDORE = BLOCKS.register("moonstone_endore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> ROSEQUARTZ_ORE = BLOCKS.register("rosequartz_ore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> ROSEQUARTZ_NETHERORE = BLOCKS.register("rosequartz_netherore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> ROSEQUARTZ_ENDORE = BLOCKS.register("rosequartz_endore",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> RUBY_NETHERORE = BLOCKS.register("ruby_netherore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> RUBY_ENDORE = BLOCKS.register("ruby_endore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> SAPPHIRE_NETHERORE = BLOCKS.register("sapphire_netherore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> SAPPHIRE_ENDORE = BLOCKS.register("sapphire_endore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> AMETHYST_ORE = BLOCKS.register("amethyst_ore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> AMETHYST_NETHERORE = BLOCKS.register("amethyst_netherore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> AMETHYST_ENDORE = BLOCKS.register("amethyst_endore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> SALT_ORE = BLOCKS.register("salt_ore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> SALT_NETHERORE = BLOCKS.register("salt_netherore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> SALT_ENDORE = BLOCKS.register("salt_endore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> MAGICAL_ORE = BLOCKS.register("magical_ore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> MAGICAL_NETHERORE = BLOCKS.register("magical_netherore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> MAGICAL_ENDORE = BLOCKS.register("magical_endore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> CRYSTAL_ORE = BLOCKS.register("crystal_ore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> CRYSTAL_NETHERORE = BLOCKS.register("crystal_netherore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> CRYSTAL_ENDORE = BLOCKS.register("crystal_endore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> FROSTSTEEL_ORE = BLOCKS.register("froststeel_ore",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));

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
	public static final RegistryObject<Block> VAMPIRIC_BLOCK = BLOCKS.register("vampiric_block",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> MYTHICDIAMOND_BLOCK = BLOCKS.register("mythicdiamond_block",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> DRAGONHEART_BLOCK = BLOCKS.register("dragonheart_block",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> BLOODSTONE_BLOCK = BLOCKS.register("bloodstone_block",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> MOONSTONE_BLOCK = BLOCKS.register("moonstone_block",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> CONGEALED_BLOOD = BLOCKS.register("congealed_blood",
			() -> new Block(Block.Properties.copy(Blocks.HONEY_BLOCK).strength(5.0f, 30.0f)
					.sound(SoundType.SLIME_BLOCK).harvestLevel(1)));
	public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block",
			() -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block",
			() -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> AMETHYST_BLOCK = BLOCKS.register("amethyst_block",
			() -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> SALT_BLOCK = BLOCKS.register("salt_block",
			() -> new Block(Block.Properties.copy(Blocks.RED_SAND).strength(5.0f, 30.0f)
					.sound(SoundType.SAND).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> FROSTSTEEL_BLOCK = BLOCKS.register("froststeel_block",
			() -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).strength(5.0f, 30.0f)
					.sound(SoundType.GLASS).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> ROSEQUARTZ_BLOCK = BLOCKS.register("rosequartz_block",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
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
	public static final RegistryObject<Block> ICYSTONE = BLOCKS.register("icystone",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> ICYSTONE_COBBLE = BLOCKS.register("icystone_cobble",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> ICYSTONE_BRICKS = BLOCKS.register("icystone_bricks",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> ICYSTONE_POLISHED = BLOCKS.register("icystone_polished",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> ICYSTONE_CHISEALED = BLOCKS.register("icystone_chisealed",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> ICYSTONE_CRACKED = BLOCKS.register("icystone_cracked",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> mysticstone = BLOCKS.register("mysticstone",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> mysticstone_cobble = BLOCKS.register("mysticstone_cobble",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> mysticstone_bricks = BLOCKS.register("mysticstone_bricks",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> mysticstone_polished = BLOCKS.register("mysticstone_polished",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> mysticstone_chisealed = BLOCKS.register("mysticstone_chisealed",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> mysticstone_cracked = BLOCKS.register("mysticstone_cracked",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> pearlstone = BLOCKS.register("pearlstone",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> pearlstone_cobble = BLOCKS.register("pearlstone_cobble",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> pearlstone_bricks = BLOCKS.register("pearlstone_bricks",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> pearlstone_polished = BLOCKS.register("pearlstone_polished",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> pearlstone_chisealed = BLOCKS.register("pearlstone_chisealed",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> pearlstone_cracked = BLOCKS.register("pearlstone_cracked",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> charred_stone = BLOCKS.register("charred_stone",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> charred_cobble = BLOCKS.register("charred_cobble",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> charred_bricks = BLOCKS.register("charred_bricks",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));;
	public static final RegistryObject<Block> charred_polished = BLOCKS.register("charred_polished",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> charred_chisealed = BLOCKS.register("charred_chisealed",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> charred_cracked = BLOCKS.register("charred_cracked",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> marble = BLOCKS.register("marble",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> marble_cobble = BLOCKS.register("marble_cobble",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> marble_bricks = BLOCKS.register("marble_bricks",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> marble_polished = BLOCKS.register("marble_polished",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> marble_chisealed = BLOCKS.register("marble_chisealed",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> marble_cracked = BLOCKS.register("marble_cracked",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> infested_stone = BLOCKS.register("infested_stone",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> infested_cobble = BLOCKS.register("infested_cobble",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> infested_bricks = BLOCKS.register("infested_bricks",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> infested_polished = BLOCKS.register("infested_polished",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> INFESTED_CHISEALED = BLOCKS.register("infested_chisealed",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> INFESTED_CRACKED = BLOCKS.register("infested_cracked",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> CRIMSON_STONE = BLOCKS.register("crimson_stone",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> CRIMSON_COBBLE = BLOCKS.register("crimson_cobble",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> CRIMSON_BRICKS = BLOCKS.register("crimson_bricks",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> CRIMSON_POLISHED = BLOCKS.register("crimson_polished",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> CRIMSON_CHISEALED = BLOCKS.register("crimson_chisealed",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> CRIMSON_CRACKED = BLOCKS.register("crimson_cracked",
			() -> new Block(Block.Properties.of(Material.STONE).strength(0.5f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
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
	public static final RegistryObject<Block> BLOOD_LANTERN = BLOCKS.register("blood_lantern",
			() -> new LanternBlock(Block.Properties.copy(Blocks.LANTERN).strength(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightLevel((state) ->15)));
	public static final RegistryObject<Block> SILVER_LANTERN = BLOCKS.register("silver_lantern",
			() -> new LanternBlock(Block.Properties.copy(Blocks.LANTERN).strength(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightLevel((state) ->15)));
	public static final RegistryObject<Block> SOUL_LANTERN = BLOCKS.register("soul_lantern",
			() -> new LanternBlock(Block.Properties.copy(Blocks.LANTERN).strength(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightLevel((state) ->15)));
	public static final RegistryObject<Block> UNDEAD_LANTERN = BLOCKS.register("undead_lantern",
			() -> new LanternBlock(Block.Properties.copy(Blocks.LANTERN).strength(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightLevel((state) ->15)));
	public static final RegistryObject<Block> MYSTIC_LANTERN = BLOCKS.register("mystic_lantern",
			() -> new LanternBlock(Block.Properties.copy(Blocks.LANTERN).strength(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightLevel((state) ->15)));
	public static final RegistryObject<Block> ENDER_LANTERN = BLOCKS.register("ender_lantern",
			() -> new LanternBlock(Block.Properties.copy(Blocks.LANTERN).strength(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightLevel((state) ->15)));
	public static final RegistryObject<Block> FAIRY_LANTERN = BLOCKS.register("fairy_lantern",
			() -> new LanternBlock(Block.Properties.copy(Blocks.LANTERN).strength(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightLevel((state) ->15)));
	public static final RegistryObject<Block> PIXIE_LANTERN = BLOCKS.register("pixie_lantern",
			() -> new LanternBlock(Block.Properties.copy(Blocks.LANTERN).strength(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightLevel((state) ->15)));
	public static final RegistryObject<Block> LIFE_LANTERN = BLOCKS.register("life_lantern",
			() -> new LanternBlock(Block.Properties.copy(Blocks.LANTERN).strength(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightLevel((state) ->15)));
	public static final RegistryObject<Block> FERAL_LANTERN = BLOCKS.register("feral_lantern",
			() -> new LanternBlock(Block.Properties.copy(Blocks.LANTERN).strength(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightLevel((state) ->15)));
	public static final RegistryObject<Block> LOVE_LANTERN = BLOCKS.register("love_lantern",
			() -> new LanternBlock(Block.Properties.copy(Blocks.LANTERN).strength(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightLevel((state) ->15)));
	public static final RegistryObject<Block> PURE_GLOWSTONE = BLOCKS.register("pure_glowstone",
			() -> new Block(Block.Properties.of(Material.GLASS).strength(2.0f, 10.0f).harvestLevel(2)
					.sound(SoundType.GLASS).lightLevel((state) ->15)));
	public static final RegistryObject<Block> DARK_GLOWSTONE = BLOCKS.register("dark_glowstone",
			() -> new Block(Block.Properties.of(Material.GLASS).strength(2.0f, 10.0f).harvestLevel(2)
					.sound(SoundType.GLASS).lightLevel((state) ->15)));

	public static final RegistryObject<Block> BLOOD_TORCH = BLOCKS.register("blood_torch",
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

	// Stairs
	public static final RegistryObject<Block> ICYSTONECOBBLE_STAIRS = BLOCKS.register("icystonecobble_stairs",
			() -> new StairsBlock(() -> BlockInit.ICYSTONE_COBBLE.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)));
	public static final RegistryObject<Block> ICYSTONEBRICKS_STAIRS = BLOCKS.register("icystonebricks_stairs",
			() -> new StairsBlock(() -> BlockInit.ICYSTONE_BRICKS.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)));
	public static final RegistryObject<Block> ICYSTONEPOLISHED_STAIRS = BLOCKS.register("icystonepolished_stairs",
			() -> new StairsBlock(() -> BlockInit.ICYSTONE_POLISHED.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)));
	public static final RegistryObject<Block> ICYSTONECHISEALED_STAIRS = BLOCKS.register("icystonechisealed_stairs",
			() -> new StairsBlock(() -> BlockInit.ICYSTONE_CHISEALED.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)));
	public static final RegistryObject<Block> ICYSTONECRACKED_STAIRS = BLOCKS.register("icystonecracked_stairs",
			() -> new StairsBlock(() -> BlockInit.ICYSTONE_CRACKED.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)));
	public static final RegistryObject<Block> mysticstone_stairs = BLOCKS.register("mysticstone_stairs",
			() -> new StairsBlock(() -> BlockInit.mysticstone.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> mysticstonecobble_stairs = BLOCKS.register("mysticstonecobble_stairs",
			() -> new StairsBlock(() -> BlockInit.mysticstone_cobble.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> mysticstonebricks_stairs = BLOCKS.register("mysticstonebricks_stairs",
			() -> new StairsBlock(() -> BlockInit.mysticstone_bricks.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> mysticstonepolished_stairs = BLOCKS.register("mysticstonepolished_stairs",
			() -> new StairsBlock(() -> BlockInit.mysticstone_polished.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> mysticstonechisealed_stairs = BLOCKS.register(
			"mysticstonechisealed_stairs",
			() -> new StairsBlock(() -> BlockInit.mysticstone_chisealed.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> mysticstonecracked_stairs = BLOCKS.register("mysticstonecracked_stairs",
			() -> new StairsBlock(() -> BlockInit.mysticstone_cracked.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> pearlstone_stairs = BLOCKS.register("pearlstone_stairs",
			() -> new StairsBlock(() -> BlockInit.pearlstone.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<Block> pearlstonecobble_stairs = BLOCKS.register("pearlstonecobble_stairs",
			() -> new StairsBlock(() -> BlockInit.pearlstone_cobble.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<Block> pearlstonebricks_stairs = BLOCKS.register("pearlstonebricks_stairs",
			() -> new StairsBlock(() -> BlockInit.pearlstone_bricks.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<Block> pearlstonepolished_stairs = BLOCKS.register("pearlstonepolished_stairs",
			() -> new StairsBlock(() -> BlockInit.pearlstone_polished.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<Block> pearlstonechisealed_stairs = BLOCKS.register("pearlstonechisealed_stairs",
			() -> new StairsBlock(() -> BlockInit.pearlstone_chisealed.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<Block> pearlstonecracked_stairs = BLOCKS.register("pearlstonecracked_stairs",
			() -> new StairsBlock(() -> BlockInit.pearlstone_cracked.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<Block> charredstone_stairs = BLOCKS.register("charredstone_stairs",
			() -> new StairsBlock(() -> BlockInit.charred_stone.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> charredcobble_stairs = BLOCKS.register("charredcobble_stairs",
			() -> new StairsBlock(() -> BlockInit.charred_cobble.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> charredbricks_stairs = BLOCKS.register("charredbricks_stairs",
			() -> new StairsBlock(() -> BlockInit.charred_bricks.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> charredpolished_stairs = BLOCKS.register("charredpolished_stairs",
			() -> new StairsBlock(() -> BlockInit.charred_polished.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> charredchisealed_stairs = BLOCKS.register("charredchisealed_stairs",
			() -> new StairsBlock(() -> BlockInit.charred_chisealed.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> charredcracked_stairs = BLOCKS.register("charredcracked_stairs",
			() -> new StairsBlock(() -> BlockInit.charred_cracked.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> marble_stairs = BLOCKS.register("marble_stairs",
			() -> new StairsBlock(() -> BlockInit.marble.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> marblecobble_stairs = BLOCKS.register("marblecobble_stairs",
			() -> new StairsBlock(() -> BlockInit.marble_cobble.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> marblebricks_stairs = BLOCKS.register("marblebricks_stairs",
			() -> new StairsBlock(() -> BlockInit.marble_bricks.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> marblepolished_stairs = BLOCKS.register("marblepolished_stairs",
			() -> new StairsBlock(() -> BlockInit.marble_polished.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> marblechisealed_stairs = BLOCKS.register("marblechisealed_stairs",
			() -> new StairsBlock(() -> BlockInit.marble_chisealed.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> marblecracked_stairs = BLOCKS.register("marblecracked_stairs",
			() -> new StairsBlock(() -> BlockInit.marble_cracked.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> infestedstone_stairs = BLOCKS.register("infestedstone_stairs",
			() -> new StairsBlock(() -> BlockInit.infested_stone.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)));
	public static final RegistryObject<Block> infestedcobble_stairs = BLOCKS.register("infestedcobble_stairs",
			() -> new StairsBlock(() -> BlockInit.infested_cobble.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)));
	public static final RegistryObject<Block> infestedbricks_stairs = BLOCKS.register("infestedbricks_stairs",
			() -> new StairsBlock(() -> BlockInit.infested_bricks.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)));
	public static final RegistryObject<Block> infestedpolished_stairs = BLOCKS.register("infestedpolished_stairs",
			() -> new StairsBlock(() -> BlockInit.infested_polished.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)));
	public static final RegistryObject<Block> infestedchisealed_stairs = BLOCKS.register("infestedchisealed_stairs",
			() -> new StairsBlock(() -> BlockInit.INFESTED_CHISEALED.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)));
	public static final RegistryObject<Block> infestedcracked_stairs = BLOCKS.register("infestedcracked_stairs",
			() -> new StairsBlock(() -> BlockInit.INFESTED_CRACKED.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)));
	public static final RegistryObject<Block> crimsonstone_stairs = BLOCKS.register("crimsonstone_stairs",
			() -> new StairsBlock(() -> BlockInit.CRIMSON_STONE.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> crimsoncobble_stairs = BLOCKS.register("crimsoncobble_stairs",
			() -> new StairsBlock(() -> BlockInit.CRIMSON_COBBLE.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> crimsonbricks_stairs = BLOCKS.register("crimsonbricks_stairs",
			() -> new StairsBlock(() -> BlockInit.CRIMSON_BRICKS.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> crimsonpolished_stairs = BLOCKS.register("crimsonpolished_stairs",
			() -> new StairsBlock(() -> BlockInit.CRIMSON_POLISHED.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> crimsonchisealed_stairs = BLOCKS.register("crimsonchisealed_stairs",
			() -> new StairsBlock(() -> BlockInit.CRIMSON_CHISEALED.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> crimsoncracked_stairs = BLOCKS.register("crimsoncracked_stairs",
			() -> new StairsBlock(() -> BlockInit.CRIMSON_CRACKED.get().defaultBlockState(),
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED)));

	public static final RegistryObject<Block> ICYSTONE_SLAB = BLOCKS.register("icystone_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.ICYSTONE.get())));
	public static final RegistryObject<Block> ICYSTONECOBBLE_SLAB = BLOCKS.register("icystonecobble_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.ICYSTONE_COBBLE.get())));
	public static final RegistryObject<Block> ICYSTONEBRICKS_SLAB = BLOCKS.register("icystonebricks_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.ICYSTONE_BRICKS.get())));
	public static final RegistryObject<Block> ICYSTONEPOLISHED_SLAB = BLOCKS.register("icystonepolished_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.ICYSTONE_POLISHED.get())));
	public static final RegistryObject<Block> ICYSTONECHISEALED_SLAB = BLOCKS.register("icystonechisealed_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.ICYSTONE_CHISEALED.get())));
	public static final RegistryObject<Block> ICYSTONECRACKED_SLAB = BLOCKS.register("icystonecracked_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.ICYSTONE_CRACKED.get())));
	public static final RegistryObject<Block> mysticstone_slab = BLOCKS.register("mysticstone_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.mysticstone.get())));
	public static final RegistryObject<Block> mysticstonecobble_slab = BLOCKS.register("mysticstonecobble_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.mysticstone_cobble.get())));
	public static final RegistryObject<Block> mysticstonebricks_slab = BLOCKS.register("mysticstonebricks_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.mysticstone_bricks.get())));
	public static final RegistryObject<Block> mysticstonepolished_slab = BLOCKS.register("mysticstonepolished_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.mysticstone_polished.get())));
	public static final RegistryObject<Block> mysticstonechisealed_slab = BLOCKS.register("mysticstonechisealed_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.mysticstone_chisealed.get())));
	public static final RegistryObject<Block> mysticstonecracked_slab = BLOCKS.register("mysticstonecracked_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.mysticstone_cracked.get())));
	public static final RegistryObject<Block> pearlstone_slab = BLOCKS.register("pearlstone_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.pearlstone.get())));
	public static final RegistryObject<Block> pearlstonecobble_slab = BLOCKS.register("pearlstonecobble_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.pearlstone_cobble.get())));
	public static final RegistryObject<Block> pearlstonebricks_slab = BLOCKS.register("pearlstonebricks_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.pearlstone_bricks.get())));
	public static final RegistryObject<Block> pearlstonepolished_slab = BLOCKS.register("pearlstonepolished_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.pearlstone_polished.get())));
	public static final RegistryObject<Block> pearlstonechisealed_slab = BLOCKS.register("pearlstonechisealed_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.pearlstone_chisealed.get())));
	public static final RegistryObject<Block> pearlstonecracked_slab = BLOCKS.register("pearlstonecracked_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.pearlstone_cracked.get())));
	public static final RegistryObject<Block> charredstone_slab = BLOCKS.register("charredstone_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.charred_stone.get())));
	public static final RegistryObject<Block> charredcobble_slab = BLOCKS.register("charredcobble_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.charred_cobble.get())));
	public static final RegistryObject<Block> charredbricks_slab = BLOCKS.register("charredbricks_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.charred_bricks.get())));
	public static final RegistryObject<Block> charredpolished_slab = BLOCKS.register("charredpolished_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.charred_polished.get())));
	public static final RegistryObject<Block> charredchisealed_slab = BLOCKS.register("charredchisealed_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.charred_chisealed.get())));
	public static final RegistryObject<Block> charredcracked_slab = BLOCKS.register("charredcracked_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.charred_cracked.get())));
	public static final RegistryObject<Block> marble_slab = BLOCKS.register("marble_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.marble.get())));
	public static final RegistryObject<Block> marblecobble_slab = BLOCKS.register("marblecobble_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.marble_cobble.get())));
	public static final RegistryObject<Block> marblebricks_slab = BLOCKS.register("marblebricks_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.marble_bricks.get())));
	public static final RegistryObject<Block> marblepolished_slab = BLOCKS.register("marblepolished_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.marble_polished.get())));
	public static final RegistryObject<Block> marblechisealed_slab = BLOCKS.register("marblechisealed_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.marble_chisealed.get())));
	public static final RegistryObject<Block> marblecracked_slab = BLOCKS.register("marblecracked_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.marble_cracked.get())));
	public static final RegistryObject<Block> infestedstone_slab = BLOCKS.register("infestedstone_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.infested_stone.get())));
	public static final RegistryObject<Block> infestedcobble_slab = BLOCKS.register("infestedcobble_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.infested_cobble.get())));
	public static final RegistryObject<Block> infestedbricks_slab = BLOCKS.register("infestedbricks_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.infested_bricks.get())));
	public static final RegistryObject<Block> infestedpolished_slab = BLOCKS.register("infestedpolished_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.infested_polished.get())));
	public static final RegistryObject<Block> infestedchisealed_slab = BLOCKS.register("infestedchisealed_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.INFESTED_CHISEALED.get())));
	public static final RegistryObject<Block> infestedcracked_slab = BLOCKS.register("infestedcracked_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.INFESTED_CRACKED.get())));
	public static final RegistryObject<Block> crimson_slab = BLOCKS.register("crimson_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.CRIMSON_STONE.get())));
	public static final RegistryObject<Block> crimsoncobble_slab = BLOCKS.register("crimsoncobble_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.CRIMSON_COBBLE.get())));
	public static final RegistryObject<Block> crimsonbricks_slab = BLOCKS.register("crimsonbricks_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.CRIMSON_BRICKS.get())));
	public static final RegistryObject<Block> crimsonpolished_slab = BLOCKS.register("crimsonpolished_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.CRIMSON_POLISHED.get())));
	public static final RegistryObject<Block> crimsonchisealed_slab = BLOCKS.register("crimsonchisealed_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.CRIMSON_CHISEALED.get())));
	public static final RegistryObject<Block> crimsoncracked_slab = BLOCKS.register("crimsoncracked_slab",
			() -> new SlabBlock(Block.Properties.copy(BlockInit.CRIMSON_CRACKED.get())));

	// Buttons
	public static final RegistryObject<Block> ICYSTONE_BUTTON = BLOCKS.register("icystone_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)));
	public static final RegistryObject<Block> ICYSTONECOBBLE_BUTTON = BLOCKS.register("icystonecobble_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)));
	public static final RegistryObject<Block> ICYSTONEBRICKS_BUTTON = BLOCKS.register("icystonebricks_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)));
	public static final RegistryObject<Block> ICYSTONEPOLISHED_BUTTON = BLOCKS.register("icystonepolished_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)));
	public static final RegistryObject<Block> ICYSTONECHISEALED_BUTTON = BLOCKS.register("icystonechisealed_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)));
	public static final RegistryObject<Block> ICYSTONECRACKED_BUTTON = BLOCKS.register("icystonecracked_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)));
	public static final RegistryObject<Block> mysticstone_button = BLOCKS.register("mysticstone_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> mysticstonecobble_button = BLOCKS.register("mysticstonecobble_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> mysticstonebricks_button = BLOCKS.register("mysticstonebricks_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> mysticstonepolished_button = BLOCKS.register("mysticstonepolished_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> mysticstonechisealed_button = BLOCKS.register(
			"mysticstonechisealed_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> mysticstonecracked_button = BLOCKS.register("mysticstonecracked_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> pearlstone_button = BLOCKS.register("pearlstone_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<Block> pearlstonecobble_button = BLOCKS.register("pearlstonecobble_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<Block> pearlstonebricks_button = BLOCKS.register("pearlstonebricks_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<Block> pearlstonepolished_button = BLOCKS.register("pearlstonepolished_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<Block> pearlstonechisealed_button = BLOCKS.register("pearlstonechisealed_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<Block> pearlstonecracked_button = BLOCKS.register("pearlstonecracked_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<Block> charredstone_button = BLOCKS.register("charredstone_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<Block> charredcobble_button = BLOCKS.register("charredcobble_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<Block> charredbricks_button = BLOCKS.register("charredbricks_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<Block> charredpolished_button = BLOCKS.register("charredpolished_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<Block> charredchisealed_button = BLOCKS.register("charredchisealed_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<Block> charredcracked_button = BLOCKS.register("charredcracked_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)));
	public static final RegistryObject<Block> marble_button = BLOCKS.register("marble_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> marblecobble_button = BLOCKS.register("marblecobble_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> marblebricks_button = BLOCKS.register("marblebricks_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> marblepolished_button = BLOCKS.register("marblepolished_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> marblechisealed_button = BLOCKS.register("marblechisealed_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> marblecracked_button = BLOCKS.register("marblecracked_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)));
	public static final RegistryObject<Block> infestedstone_button = BLOCKS.register("infestedstone_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)));
	public static final RegistryObject<Block> infestedcobble_button = BLOCKS.register("infestedcobble_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)));
	public static final RegistryObject<Block> infestedbricks_button = BLOCKS.register("infestedbricks_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)));
	public static final RegistryObject<Block> infestedpolished_button = BLOCKS.register("infestedpolished_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)));
	public static final RegistryObject<Block> infestedchisealed_button = BLOCKS.register("infestedchisealed_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)));
	public static final RegistryObject<Block> infestedcracked_button = BLOCKS.register("infestedcracked_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)));
	public static final RegistryObject<Block> crimson_button = BLOCKS.register("crimson_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> crimsoncobble_button = BLOCKS.register("crimsoncobble_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> crimsonbricks_button = BLOCKS.register("crimsonbricks_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> crimsonpolished_button = BLOCKS.register("crimsonpolished_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> crimsonchisealed_button = BLOCKS.register("crimsonchisealed_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED)));
	public static final RegistryObject<Block> crimsoncracked_button = BLOCKS.register("crimsoncracked_button",
			() -> new ModStoneButtonBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED)));

	// Walls
	public static final RegistryObject<WallBlock> icystone_wall = BLOCKS.register("icystone_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> icystonecobble_wall = BLOCKS.register("icystonecobble_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> icystonebricks_wall = BLOCKS.register("icystonebricks_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> icystonepolished_wall = BLOCKS.register("icystonepolished_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> icystonechisealed_wall = BLOCKS.register("icystonechisealed_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> icystonecracked_wall = BLOCKS.register("icystonecracked_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> mysticstone_wall = BLOCKS.register("mysticstone_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> mysticstonecobble_wall = BLOCKS.register("mysticstonecobble_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> mysticstonebricks_wall = BLOCKS.register("mysticstonebricks_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> mysticstonepolished_wall = BLOCKS.register("mysticstonepolished_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> mysticstonechisealed_wall = BLOCKS
			.register("mysticstonechisealed_wall", () -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> mysticstonecracked_wall = BLOCKS.register("mysticstonecracked_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> pearlstone_wall = BLOCKS.register("pearlstone_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> pearlstonecobble_wall = BLOCKS.register("pearlstonecobble_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> pearlstonebricks_wall = BLOCKS.register("pearlstonebricks_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> pearlstonepolished_wall = BLOCKS.register("pearlstonepolished_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> pearlstonechisealed_wall = BLOCKS.register("pearlstonechisealed_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> pearlstonecracked_wall = BLOCKS.register("pearlstonecracked_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> charredstone_wall = BLOCKS.register("charredstone_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> charredcobble_wall = BLOCKS.register("charredcobble_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> charredbricks_wall = BLOCKS.register("charredbricks_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> charredpolished_wall = BLOCKS.register("charredpolished_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> charredchisealed_wall = BLOCKS.register("charredchisealed_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> charredcracked_wall = BLOCKS.register("charredcracked_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> marble_wall = BLOCKS.register("marble_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> marblecobble_wall = BLOCKS.register("marblecobble_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> marblebricks_wall = BLOCKS.register("marblebricks_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> marblepolished_wall = BLOCKS.register("marblepolished_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> marblechisealed_wall = BLOCKS.register("marblechisealed_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> marblecracked_wall = BLOCKS.register("marblecracked_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> infestedstone_wall = BLOCKS.register("infested_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> infestedcobble_wall = BLOCKS.register("infestedcobble_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> infestedbricks_wall = BLOCKS.register("infestedbricks_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> infestedpolished_wall = BLOCKS.register("infestedpolished_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> infestedchisealed_wall = BLOCKS.register("infestedchisealed_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> infestedcracked_wall = BLOCKS.register("infestedcracked_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> crimsonstone_wall = BLOCKS.register("crimsonstone_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> crimsoncobble_wall = BLOCKS.register("crimsoncobble_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> crimsonbricks_wall = BLOCKS.register("crimsonbricks_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> crimsonpolished_wall = BLOCKS.register("crimsonpolished_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> crimsonchisealed_wall = BLOCKS.register("crimsonchisealed_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> crimsoncracked_wall = BLOCKS.register("crimsoncracked_wall",
			() -> new WallBlock(Block.Properties.copy(Blocks.ANDESITE_WALL)));

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

	@SuppressWarnings("deprecation")
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