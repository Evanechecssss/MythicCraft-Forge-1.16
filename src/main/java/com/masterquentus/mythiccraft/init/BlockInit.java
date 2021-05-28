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

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			MythicCraft.MOD_ID);

	//twisted, distorted
	private static String[] woodTypes = {"bloodoak", "whiteoak", "silverwood", "witchwood", "alder", "hawthorn", "rowan", "willow", "beech", "ash",
			"blackthorn", "cedar", "elder", "juniper", "witchhazel", "yew", "infested", "charred", "icy"};

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

	private static String[] stoneTypes = {"icystone", "mysticstone", "pearlstone", "charred", "infested", "crimson", "marble"};

	public enum StoneVariation {
		STONE,COBBLE,BRICKS,POLISHED,CHISELED, CRACKED;

		public String toString(){
			switch(this) {
				case STONE:
					return "";
				case COBBLE:
					return "cobble";
				case BRICKS:
					return "bricks";
				case POLISHED:
					return "polished";
				case CHISELED:
					return "chisealed";
				case CRACKED:
					return "cracked";
			}

			return "ERROR_INVALID_STONE_TYPE";
		}
	}

	public static class StoneType{
		public final String name;
		public HashMap<StoneVariation, Supplier<Block>> blocks = new HashMap<>();
		public HashMap<StoneVariation, Supplier<Block>> stairs = new HashMap<>();
		public HashMap<StoneVariation, Supplier<Block>> slabs = new HashMap<>();
		public HashMap<StoneVariation, Supplier<Block>> buttons = new HashMap<>();
		public HashMap<StoneVariation, Supplier<Block>> walls = new HashMap<>();

		public StoneType(String name){
			this.name = name;
		}
	}

	public static Map<String, WoodType> WOOD_TYPES = new HashMap<>();
	public static Map<String, StoneType> STONE_TYPES = new HashMap<>();
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

		for (String name : stoneTypes){
			StoneType stoneType = new StoneType(name);
			for (StoneVariation variation : StoneVariation.values()){
				String typeString = variation.toString();
					if (variation == StoneVariation.STONE && (name == "crimson" || name == "charred" || name == "infested")){
					typeString = "stone";
				}
				AbstractBlock.Properties props = Block.Properties.of(Material.STONE).strength(5.0f, 30.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1);
				stoneType.blocks.put(variation, BLOCKS.register(name + (typeString.equals("") ? "" : "_" + typeString), () -> new Block(props)));
				stoneType.stairs.put(variation, BLOCKS.register(name + typeString + "_stairs", () -> new StairsBlock(() -> BlockInit.STONE_TYPES.get(name).stairs.get(variation).get().defaultBlockState(), props)));
				stoneType.slabs.put(variation, BLOCKS.register(name + typeString + "_slab", () -> new SlabBlock(props)));
				stoneType.buttons.put(variation, BLOCKS.register(name + typeString + "_button", () -> new ModStoneButtonBlock(props)));
				stoneType.walls.put(variation, BLOCKS.register(name + typeString + "_wall", () -> new WallBlock(props)));
			}

			STONE_TYPES.put(name, stoneType);
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
	public static final RegistryObject<Block> KRAKEN_LANTERN = BLOCKS.register("kraken_lantern",
			() -> new LanternBlock(Block.Properties.copy(Blocks.LANTERN).strength(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightLevel((state) ->15)));
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