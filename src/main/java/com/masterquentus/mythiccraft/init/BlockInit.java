package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.objects.BelladonnaCropBlock;
import com.masterquentus.mythiccraft.objects.FoxGlovesCropBlock;
import com.masterquentus.mythiccraft.objects.GarlicCropBlock;
import com.masterquentus.mythiccraft.objects.HelleboreCrop;
import com.masterquentus.mythiccraft.objects.MandrakeCropBlock;
import com.masterquentus.mythiccraft.objects.NightShadeCrop;
import com.masterquentus.mythiccraft.objects.SnowbellCrop;
import com.masterquentus.mythiccraft.objects.VervainCropBlock;
import com.masterquentus.mythiccraft.objects.WaterartichokeCrop;
import com.masterquentus.mythiccraft.objects.WhitesageCrop;
import com.masterquentus.mythiccraft.objects.WolfsCropBlock;
import com.masterquentus.mythiccraft.objects.WormwoodCrop;
import com.masterquentus.mythiccraft.objects.blocks.BlockQuarry;
import com.masterquentus.mythiccraft.objects.blocks.BloodBerryBushBlock;
import com.masterquentus.mythiccraft.objects.blocks.BloodOakCrateBlock;
import com.masterquentus.mythiccraft.objects.blocks.CharredBerryBushBlock;
import com.masterquentus.mythiccraft.objects.blocks.HellFireBlock;
import com.masterquentus.mythiccraft.objects.blocks.IcyBerryBushBlock;
import com.masterquentus.mythiccraft.objects.blocks.InfestedBerryBushBlock;
import com.masterquentus.mythiccraft.objects.blocks.ModDoor;
import com.masterquentus.mythiccraft.objects.blocks.ModGrassBlock;
import com.masterquentus.mythiccraft.objects.blocks.ModIceBlock;
import com.masterquentus.mythiccraft.objects.blocks.ModLayer;
import com.masterquentus.mythiccraft.objects.blocks.ModPaneBlock;
import com.masterquentus.mythiccraft.objects.blocks.ModSaplingBlock;
import com.masterquentus.mythiccraft.objects.blocks.ModStoneButtonBlock;
import com.masterquentus.mythiccraft.objects.blocks.ModTorchBlock;
import com.masterquentus.mythiccraft.objects.blocks.ModTrapDoor;
import com.masterquentus.mythiccraft.objects.blocks.ModWoodButtonBlock;
import com.masterquentus.mythiccraft.objects.blocks.ModWoodPressurePlateBlock;
import com.masterquentus.mythiccraft.objects.blocks.MysticBerryBushBlock;
import com.masterquentus.mythiccraft.objects.blocks.PandorsBox;
import com.masterquentus.mythiccraft.objects.blocks.PandorsBoxOpen;
import com.masterquentus.mythiccraft.objects.blocks.PedestalTier1;
import com.masterquentus.mythiccraft.objects.blocks.PedestalTier2;
import com.masterquentus.mythiccraft.objects.blocks.SilverBerryBushBlock;
import com.masterquentus.mythiccraft.objects.blocks.SoulBerryBushBlock;
import com.masterquentus.mythiccraft.objects.blocks.SpanishMossBlock;
import com.masterquentus.mythiccraft.objects.blocks.WeepingVineBlock;
import com.masterquentus.mythiccraft.objects.blocks.WhiteOakCrateBlock;
import com.masterquentus.mythiccraft.world.feature.AlderTree;
import com.masterquentus.mythiccraft.world.feature.AshTree;
import com.masterquentus.mythiccraft.world.feature.BeechTree;
import com.masterquentus.mythiccraft.world.feature.BlackthornTree;
import com.masterquentus.mythiccraft.world.feature.BloodOakTree;
import com.masterquentus.mythiccraft.world.feature.CedarTree;
import com.masterquentus.mythiccraft.world.feature.CharredTree;
import com.masterquentus.mythiccraft.world.feature.ElderTree;
import com.masterquentus.mythiccraft.world.feature.HawthornTree;
import com.masterquentus.mythiccraft.world.feature.InfestedTree;
import com.masterquentus.mythiccraft.world.feature.JuniperTree;
import com.masterquentus.mythiccraft.world.feature.RowanTree;
import com.masterquentus.mythiccraft.world.feature.SilverWoodTree;
import com.masterquentus.mythiccraft.world.feature.WhiteOakTree;
import com.masterquentus.mythiccraft.world.feature.WillowTree;
import com.masterquentus.mythiccraft.world.feature.WitchHazelTree;
import com.masterquentus.mythiccraft.world.feature.WitchWoodTree;
import com.masterquentus.mythiccraft.world.feature.YewTree;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SlimeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,
			MythicCraft.MOD_ID);

	// Ores
	public static final RegistryObject<Block> VAMPIRIC_ORE = BLOCKS.register("vampiric_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> VAMPIRIC_NETHERORE = BLOCKS.register("vampiric_netherore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> VAMPIRIC_ENDORE = BLOCKS.register("vampiric_endore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> MYTHICDIAMOND_ORE = BLOCKS.register("mythicdiamond_ore", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MYTHICDIAMOND_NETHERORE = BLOCKS.register("mythicdiamond_netherore",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MYTHICDIAMOND_ENDORE = BLOCKS.register("mythicdiamond_endore",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SILVER_NETHERORE = BLOCKS.register("silver_netherore", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SILVER_ENDORE = BLOCKS.register("silver_endore", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DRAGONHEART_ORE = BLOCKS.register("dragonheart_ore", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DRAGONHEART_NETHERORE = BLOCKS.register("dragonheart_netherore",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DRAGONHESRT_ENDORE = BLOCKS.register("dragonheart_endore",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BLOODSTONE_ORE = BLOCKS.register("bloodstone_ore", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BLOODSTONE_NETHERORE = BLOCKS.register("bloodstone_netherore",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BLOODSTONE_ENDORE = BLOCKS.register("bloodstone_endore", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MOONSTONE_ORE = BLOCKS.register("moonstone_ore", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MOONSTONE_NETHERORE = BLOCKS.register("moonstone_netherore",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MOONSTONE_ENDORE = BLOCKS.register("moonstone_endore", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ROSEQUARTZ_ORE = BLOCKS.register("rosequartz_ore", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ROSEQUARTZ_NETHERORE = BLOCKS.register("rosequartz_netherore",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ROSEQUARTZ_ENDORE = BLOCKS.register("rosequartz_endore", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> RUBY_NETHERORE = BLOCKS.register("ruby_netherore", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> RUBY_ENDORE = BLOCKS.register("ruby_endore", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SAPPHIRE_NETHERORE = BLOCKS.register("sapphire_netherore",
			() -> new Block(
					Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SAPPHIRE_ENDORE = BLOCKS.register("sapphire_endore", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> AMETHYST_ORE = BLOCKS.register("amethyst_ore", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> AMETHYST_NETHERORE = BLOCKS.register("amethyst_netherore",
			() -> new Block(
					Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> AMETHYST_ENDORE = BLOCKS.register("amethyst_endore", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SALT_ORE = BLOCKS.register("salt_ore", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SALT_NETHERORE = BLOCKS.register("salt_netherore", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SALT_ENDORE = BLOCKS.register("salt_endore", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MAGICAL_ORE = BLOCKS.register("magical_ore", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MAGICAL_NETHERORE = BLOCKS.register("magical_netherore", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MAGICAL_ENDORE = BLOCKS.register("magical_endore", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CRYSTAL_ORE = BLOCKS.register("crystal_ore", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CRYSTAL_NETHERORE = BLOCKS.register("crystal_netherore", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CRYSTAL_ENDORE = BLOCKS.register("crystal_endore", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)));

	// Blocks
	public static final RegistryObject<Block> BLACK_OBSIDIAN = BLOCKS.register("black_obsidian",
			() -> new Block(Block.Properties.from(Blocks.OBSIDIAN)));
	public static final RegistryObject<Block> CHARRED_SOIL = BLOCKS.register("charred_soil",
			() -> new ModGrassBlock(Block.Properties.create(Material.SAND, MaterialColor.BLACK).sound(SoundType.SAND)));
	public static final RegistryObject<Block> INFESTED_SOIL = BLOCKS.register("infested_soil", () -> new ModGrassBlock(
			Block.Properties.create(Material.SAND, MaterialColor.MAGENTA).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> MYSTIC_SOIL = BLOCKS.register("mystic_soil", () -> new ModGrassBlock(
			Block.Properties.create(Material.SAND, MaterialColor.MAGENTA).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> BLOODLY_SOIL = BLOCKS.register("bloodly_soil",
			() -> new ModGrassBlock(Block.Properties.create(Material.SAND, MaterialColor.RED).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> VAMPIRIC_BLOCK = BLOCKS.register("vampiric_block", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MYTHICDIAMOND_BLOCK = BLOCKS.register("mythicdiamond_block",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DRAGONHEART_BLOCK = BLOCKS.register("dragonheart_block", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BLOODSTONE_BLOCK = BLOCKS.register("bloodstone_block", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MOONSTONE_BLOCK = BLOCKS.register("moonstone_block", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CONGEALED_BLOOD = BLOCKS.register("congealed_blood", () -> new Block(
			Block.Properties.from(Blocks.HONEY_BLOCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.SLIME)));
	public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", () -> new Block(
			Block.Properties.from(Blocks.IRON_BLOCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new Block(
			Block.Properties.from(Blocks.IRON_BLOCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> AMETHYST_BLOCK = BLOCKS.register("amethyst_block", () -> new Block(
			Block.Properties.from(Blocks.IRON_BLOCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SALT_BLOCK = BLOCKS.register("salt_block", () -> new Block(
			Block.Properties.from(Blocks.RED_SAND).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> ROSEQUARTZ_BLOCK = BLOCKS.register("rosequartz_block", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ROSEQUARTZ_CHISELED = BLOCKS.register("rosequartz_chiseled",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ROSEQUARTZ_SMOOTH = BLOCKS.register("rosequartz_smooth", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ROSEQUARTZ_PILLAR = BLOCKS.register("rosequartz_pillar",
			() -> new LogBlock(MaterialColor.WHITE_TERRACOTTA, Block.Properties.from(Blocks.QUARTZ_PILLAR)
					.hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ROSEQUARTZ_BRICKS = BLOCKS.register("rosequartz_bricks",
			() -> new LogBlock(MaterialColor.WHITE_TERRACOTTA, Block.Properties.from(Blocks.QUARTZ_BLOCK)
					.hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BLACKSTONE = BLOCKS.register("blackstone", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BLACKSTONE_COBBLE = BLOCKS.register("blackstone_cobble", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BLACKSTONE_BRICKS = BLOCKS.register("blackstone_bricks", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BLACKSTONE_POLISHED = BLOCKS.register("blackstone_polished",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> blackstone_chisealed = BLOCKS.register("blackstone_chisealed",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> blackstone_cracked = BLOCKS.register("blackstone_cracked",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> mysticstone = BLOCKS.register("mysticstone", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> mysticstone_cobble = BLOCKS.register("mysticstone_cobble",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> mysticstone_bricks = BLOCKS.register("mysticstone_bricks",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> mysticstone_polished = BLOCKS.register("mysticstone_polished",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> mysticstone_chisealed = BLOCKS.register("mysticstone_chisealed",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> mysticstone_cracked = BLOCKS.register("mysticstone_cracked",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> pearlstone = BLOCKS.register("pearlstone", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> pearlstone_cobble = BLOCKS.register("pearlstone_cobble", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> pearlstone_bricks = BLOCKS.register("pearlstone_bricks", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> pearlstone_polished = BLOCKS.register("pearlstone_polished",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> pearlstone_chisealed = BLOCKS.register("pearlstone_chisealed",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> pearlstone_cracked = BLOCKS.register("pearlstone_cracked",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> charred_stone = BLOCKS.register("charred_stone", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> charred_cobble = BLOCKS.register("charred_cobble", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> charred_bricks = BLOCKS.register("charred_bricks", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> charred_polished = BLOCKS.register("charred_polished", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> charred_chisealed = BLOCKS.register("charred_chisealed", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> charred_cracked = BLOCKS.register("charred_cracked", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> marble = BLOCKS.register("marble", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> marble_cobble = BLOCKS.register("marble_cobble", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> marble_bricks = BLOCKS.register("marble_bricks", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> marble_polished = BLOCKS.register("marble_polished", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> marble_chisealed = BLOCKS.register("marble_chisealed", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> marble_cracked = BLOCKS.register("marble_cracked", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> infested_stone = BLOCKS.register("infested_stone", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> infested_cobble = BLOCKS.register("infested_cobble", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> infested_bricks = BLOCKS.register("infested_bricks", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> infested_polished = BLOCKS.register("infested_polished", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> INFESTED_CHISEALED = BLOCKS.register("infested_chisealed",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> INFESTED_CRACKED = BLOCKS.register("infested_cracked", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CRIMSON_STONE = BLOCKS.register("crimson_stone", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CRIMSON_COBBLE = BLOCKS.register("crimson_cobble", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CRIMSON_BRICKS = BLOCKS.register("crimson_bricks", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CRIMSON_POLISHED = BLOCKS.register("crimson_polished", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CRIMSON_CHISEALED = BLOCKS.register("crimson_chisealed", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CRIMSON_CRACKED = BLOCKS.register("crimson_cracked", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHARREDSLIME_BLOCK = BLOCKS.register("charredslime_block",
			() -> new SlimeBlock(Block.Properties.from(Blocks.SLIME_BLOCK)));
	public static final RegistryObject<Block> INFESTEDSLIME_BLOCK = BLOCKS.register("infestedslime_block",
			() -> new SlimeBlock(Block.Properties.from(Blocks.SLIME_BLOCK)));
	public static final RegistryObject<Block> ASH_BLOCK = BLOCKS.register("ash_block",
			() -> new Block(Block.Properties.from(Blocks.RED_SAND)));
	public static final RegistryObject<Block> HOTASH_BLOCK = BLOCKS.register("hotash_block",
			() -> new Block(Block.Properties.from(Blocks.RED_SAND)));
	public static final RegistryObject<Block> ASH_LAYER = BLOCKS.register("ash_layer", () -> new ModLayer(
			Block.Properties.from(Blocks.SAND).hardnessAndResistance(0.3f, 0.2f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> HOTASH_LAYER = BLOCKS.register("hotash_layer", () -> new ModLayer(
			Block.Properties.from(Blocks.SAND).hardnessAndResistance(0.3f, 0.2f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> MAGIC_WALL = BLOCKS.register("magic_wall", () -> new Block(
			Block.Properties.from(Blocks.STONE).hardnessAndResistance(0.3f, 0.2f).sound(SoundType.STONE)));

	// Transparent Blocks
	public static final RegistryObject<Block> CRIMSON_ICE = BLOCKS.register("crimson_ice",
			() -> new ModIceBlock(Block.Properties.from(Blocks.ICE).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.GLASS).slipperiness(0.98f)));
	public static final RegistryObject<Block> CRIMSON_PACKEDICE = BLOCKS.register("crimson_packedice",
			() -> new Block(Block.Properties.from(Blocks.PACKED_ICE).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.GLASS).slipperiness(0.98f)));
	public static final RegistryObject<Block> BLACK_ICE = BLOCKS.register("black_ice",
			() -> new ModIceBlock(Block.Properties.from(Blocks.ICE).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.GLASS).slipperiness(0.98f)));
	public static final RegistryObject<Block> BLACK_PACKEDICE = BLOCKS.register("black_packedice",
			() -> new Block(Block.Properties.from(Blocks.PACKED_ICE).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.GLASS).slipperiness(0.98f).speedFactor(0.7f).tickRandomly().notSolid()))));
	public static final RegistryObject<Block> PIXIE_GLASS = BLOCKS.register("pixie_glass", () -> new Block(
			Block.Properties.from(Blocks.GLASS).hardnessAndResistance(0.3f, 0.2f).sound(SoundType.GLASS).notSolid()))));
	public static final RegistryObject<Block> FAIRY_GLASS = BLOCKS.register("fairy_glass", () -> new Block(
			Block.Properties.from(Blocks.GLASS).hardnessAndResistance(0.3f, 0.2f).sound(SoundType.GLASS).notSolid()))));
	public static final RegistryObject<Block> PIXIE_GLASS_PANE = BLOCKS.register("pixie_glass_pane",
			() -> new ModPaneBlock(Block.Properties.from(Blocks.GLASS).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.GLASS).notSolid()))));
	public static final RegistryObject<Block> FAIRY_GLASS_PANE = BLOCKS.register("fairy_glass_pane",
			() -> new ModPaneBlock(Block.Properties.from(Blocks.GLASS).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.GLASS).notSolid()))));

	// Lanterns/Glowstone/Torches
	public static final RegistryObject<Block> BLOOD_LANTERN = BLOCKS.register("blood_lantern",
			() -> new Block(Block.Properties.from(Blocks.LANTERN).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightValue(15)));
	public static final RegistryObject<Block> SILVER_LANTERN = BLOCKS.register("silver_lantern",
			() -> new Block(Block.Properties.from(Blocks.LANTERN).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightValue(15)));
	public static final RegistryObject<Block> SOUL_LANTERN = BLOCKS.register("soul_lantern",
			() -> new Block(Block.Properties.from(Blocks.LANTERN).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightValue(15)));
	public static final RegistryObject<Block> UNDEAD_LANTERN = BLOCKS.register("undead_lantern",
			() -> new Block(Block.Properties.from(Blocks.LANTERN).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightValue(15)));
	public static final RegistryObject<Block> MYSTIC_LANTERN = BLOCKS.register("mystic_lantern",
			() -> new Block(Block.Properties.from(Blocks.LANTERN).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightValue(15)));
	public static final RegistryObject<Block> ENDER_LANTERN = BLOCKS.register("ender_lantern",
			() -> new Block(Block.Properties.from(Blocks.LANTERN).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightValue(15)));
	public static final RegistryObject<Block> FAIRY_LANTERN = BLOCKS.register("fairy_lantern",
			() -> new Block(Block.Properties.from(Blocks.LANTERN).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightValue(15)));
	public static final RegistryObject<Block> PIXIE_LANTERN = BLOCKS.register("pixie_lantern",
			() -> new Block(Block.Properties.from(Blocks.LANTERN).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightValue(15)));
	public static final RegistryObject<Block> LIFE_LANTERN = BLOCKS.register("life_lantern",
			() -> new Block(Block.Properties.from(Blocks.LANTERN).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightValue(15)));
	public static final RegistryObject<Block> FERAL_LANTERN = BLOCKS.register("feral_lantern",
			() -> new Block(Block.Properties.from(Blocks.LANTERN).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightValue(15)));
	public static final RegistryObject<Block> LOVE_LANTERN = BLOCKS.register("love_lantern",
			() -> new Block(Block.Properties.from(Blocks.LANTERN).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.LANTERN).lightValue(15)));
	public static final RegistryObject<Block> PURE_GLOWSTONE = BLOCKS.register("pure_glowstone",
			() -> new Block(Block.Properties.create(Material.GLASS).hardnessAndResistance(2.0f, 10.0f).harvestLevel(2)
					.sound(SoundType.GLASS).lightValue(15)));
	public static final RegistryObject<Block> DARK_GLOWSTONE = BLOCKS.register("dark_glowstone",
			() -> new Block(Block.Properties.create(Material.GLASS).hardnessAndResistance(2.0f, 10.0f).harvestLevel(2)
					.sound(SoundType.GLASS).lightValue(15)));
	public static final RegistryObject<Block> BLOOD_TORCH = BLOCKS.register("blood_torch",
			() -> new ModTorchBlock(Block.Properties.from(Blocks.TORCH).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightValue(15)));
	public static final RegistryObject<Block> SILVER_TORCH = BLOCKS.register("silver_torch",
			() -> new ModTorchBlock(Block.Properties.from(Blocks.TORCH).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightValue(15)));
	public static final RegistryObject<Block> SOUL_TORCH = BLOCKS.register("soul_torch",
			() -> new ModTorchBlock(Block.Properties.from(Blocks.TORCH).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightValue(15)));
	public static final RegistryObject<Block> UNDEAD_TORCH = BLOCKS.register("undead_torch",
			() -> new ModTorchBlock(Block.Properties.from(Blocks.TORCH).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightValue(15)));
	public static final RegistryObject<Block> MYSTIC_TORCH = BLOCKS.register("mystic_torch",
			() -> new ModTorchBlock(Block.Properties.from(Blocks.TORCH).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightValue(15)));
	public static final RegistryObject<Block> ENDER_TORCH = BLOCKS.register("ender_torch",
			() -> new ModTorchBlock(Block.Properties.from(Blocks.TORCH).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightValue(15)));
	public static final RegistryObject<Block> FAIRY_TORCH = BLOCKS.register("fairy_torch",
			() -> new ModTorchBlock(Block.Properties.from(Blocks.TORCH).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightValue(15)));
	public static final RegistryObject<Block> PIXIE_TORCH = BLOCKS.register("pixie_torch",
			() -> new ModTorchBlock(Block.Properties.from(Blocks.TORCH).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightValue(15)));
	public static final RegistryObject<Block> LIFE_TORCH = BLOCKS.register("life_torch",
			() -> new ModTorchBlock(Block.Properties.from(Blocks.TORCH).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightValue(15)));
	public static final RegistryObject<Block> FERAL_TORCH = BLOCKS.register("feral_torch",
			() -> new ModTorchBlock(Block.Properties.from(Blocks.TORCH).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightValue(15)));
	public static final RegistryObject<Block> LOVE_TORCH = BLOCKS.register("love_torch",
			() -> new ModTorchBlock(Block.Properties.from(Blocks.TORCH).hardnessAndResistance(0.3f, 0.2f)
					.sound(SoundType.WOOD).lightValue(15)));

	// Plants

	// Saplings
	public static final RegistryObject<Block> bloodoak_sapling = BLOCKS.register("bloodoak_sapling",
			() -> new ModSaplingBlock(() -> new BloodOakTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	public static final RegistryObject<Block> whiteoak_sapling = BLOCKS.register("whiteoak_sapling",
			() -> new ModSaplingBlock(() -> new WhiteOakTree(), Block.Properties.from(Blocks.DARK_OAK_SAPLING)));
	public static final RegistryObject<Block> silverwood_sapling = BLOCKS.register("silverwood_sapling",
			() -> new ModSaplingBlock(() -> new SilverWoodTree(), Block.Properties.from(Blocks.BIRCH_SAPLING)));
	public static final RegistryObject<Block> witchwood_sapling = BLOCKS.register("witchwood_sapling",
			() -> new ModSaplingBlock(() -> new WitchWoodTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	public static final RegistryObject<Block> alder_sapling = BLOCKS.register("alder_sapling",
			() -> new ModSaplingBlock(() -> new AlderTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	public static final RegistryObject<Block> hawthorn_sapling = BLOCKS.register("hawthorn_sapling",
			() -> new ModSaplingBlock(() -> new HawthornTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	public static final RegistryObject<Block> rowan_sapling = BLOCKS.register("rowan_sapling",
			() -> new ModSaplingBlock(() -> new RowanTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	public static final RegistryObject<Block> willow_sapling = BLOCKS.register("willow_sapling",
			() -> new ModSaplingBlock(() -> new WillowTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	public static final RegistryObject<Block> beech_sapling = BLOCKS.register("beech_sapling",
			() -> new ModSaplingBlock(() -> new BeechTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	public static final RegistryObject<Block> ash_sapling = BLOCKS.register("ash_sapling",
			() -> new ModSaplingBlock(() -> new AshTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	public static final RegistryObject<Block> blackthorn_sapling = BLOCKS.register("blackthorn_sapling",
			() -> new ModSaplingBlock(() -> new BlackthornTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	public static final RegistryObject<Block> cedar_sapling = BLOCKS.register("cedar_sapling",
			() -> new ModSaplingBlock(() -> new CedarTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	public static final RegistryObject<Block> elder_sapling = BLOCKS.register("elder_sapling",
			() -> new ModSaplingBlock(() -> new ElderTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	public static final RegistryObject<Block> juniper_sapling = BLOCKS.register("juniper_sapling",
			() -> new ModSaplingBlock(() -> new JuniperTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	public static final RegistryObject<Block> witchhazel_sapling = BLOCKS.register("witchhazel_sapling",
			() -> new ModSaplingBlock(() -> new WitchHazelTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	public static final RegistryObject<Block> yew_sapling = BLOCKS.register("yew_sapling",
			() -> new ModSaplingBlock(() -> new YewTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	public static final RegistryObject<Block> infested_sapling = BLOCKS.register("infested_sapling",
			() -> new ModSaplingBlock(() -> new InfestedTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	public static final RegistryObject<Block> charred_sapling = BLOCKS.register("charred_sapling",
			() -> new ModSaplingBlock(() -> new CharredTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));

	// Logs
	public static final RegistryObject<Block> bloodoak_log = BLOCKS.register("bloodoak_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> bloodoak_stripped_log = BLOCKS.register("bloodoak_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> whiteoak_log = BLOCKS.register("whiteoak_log",
			() -> new LogBlock(MaterialColor.WHITE_TERRACOTTA, Block.Properties.from(Blocks.DARK_OAK_LOG)));
	public static final RegistryObject<Block> whiteoak_stripped_log = BLOCKS.register("whiteoak_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> silverwood_log = BLOCKS.register("silverwood_log",
			() -> new LogBlock(MaterialColor.WHITE_TERRACOTTA, Block.Properties.from(Blocks.BIRCH_LOG)));
	public static final RegistryObject<Block> silverwood_stripped_log = BLOCKS.register("silverwood_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> witchwood_log = BLOCKS.register("witchwood_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> witchwood_stripped_log = BLOCKS.register("witchwood_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> alder_log = BLOCKS.register("alder_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> alder_stripped_log = BLOCKS.register("alder_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> hawthorn_log = BLOCKS.register("hawthorn_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> hawthorn_stripped_log = BLOCKS.register("hawthorn_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> rowan_log = BLOCKS.register("rowan_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> rowan_stripped_log = BLOCKS.register("rowan_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> willow_log = BLOCKS.register("willow_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> willow_stripped_log = BLOCKS.register("willow_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> beech_log = BLOCKS.register("beech_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> beech_stripped_log = BLOCKS.register("beech_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> ash_log = BLOCKS.register("ash_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> ash_stripped_log = BLOCKS.register("ash_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> blackthorn_log = BLOCKS.register("blackthorn_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> blackthorn_stripped_log = BLOCKS.register("blackthorn_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> cedar_log = BLOCKS.register("cedar_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> cedar_stripped_log = BLOCKS.register("cedar_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> elder_log = BLOCKS.register("elder_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> elder_stripped_log = BLOCKS.register("elder_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> juniper_log = BLOCKS.register("juniper_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> juniper_stripped_log = BLOCKS.register("juniper_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> witchhazel_log = BLOCKS.register("witchhazel_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> witchhazel_stripped_log = BLOCKS.register("witchhazel_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> yew_log = BLOCKS.register("yew_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> yew_stripped_log = BLOCKS.register("yew_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> infested_log = BLOCKS.register("infested_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> infested_stripped_log = BLOCKS.register("infested_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> charred_log = BLOCKS.register("charred_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> charred_stripped_log = BLOCKS.register("charred_stripped_log",
			() -> new LogBlock(MaterialColor.RED, Block.Properties.from(Blocks.ACACIA_LOG)));

	// Leaves
	public static final RegistryObject<Block> bloodoak_leaves = BLOCKS.register("bloodoak_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));
	public static final RegistryObject<Block> whiteoak_leaves = BLOCKS.register("whiteoak_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.DARK_OAK_LEAVES)));
	public static final RegistryObject<Block> silverwood_leaves = BLOCKS.register("silverwood_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.BIRCH_LEAVES)));
	public static final RegistryObject<Block> witchwood_leaves = BLOCKS.register("witchwood_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));
	public static final RegistryObject<Block> alder_leaves = BLOCKS.register("alder_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));
	public static final RegistryObject<Block> hawthorn_leaves = BLOCKS.register("hawthorn_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));
	public static final RegistryObject<Block> rowan_leaves = BLOCKS.register("rowan_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));
	public static final RegistryObject<Block> willow_leaves = BLOCKS.register("willow_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));
	public static final RegistryObject<Block> beech_leaves = BLOCKS.register("beech_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));
	public static final RegistryObject<Block> ash_leaves = BLOCKS.register("ash_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));
	public static final RegistryObject<Block> blackthorn_leaves = BLOCKS.register("blackthorn_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));
	public static final RegistryObject<Block> cedar_leaves = BLOCKS.register("cedar_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));
	public static final RegistryObject<Block> elder_leaves = BLOCKS.register("elder_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));
	public static final RegistryObject<Block> juniper_leaves = BLOCKS.register("juniper_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));
	public static final RegistryObject<Block> witchhazel_leaves = BLOCKS.register("witchhazel_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));
	public static final RegistryObject<Block> yew_leaves = BLOCKS.register("yew_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));
	public static final RegistryObject<Block> infested_leaves = BLOCKS.register("infested_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));
	public static final RegistryObject<Block> charred_leaves = BLOCKS.register("charred_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));

	// Planks
	public static final RegistryObject<Block> BLOODOAK_PLANKS = BLOCKS.register("bloodoak_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> WHITEOAK_PLANKS = BLOCKS.register("whiteoak_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> SILVERWOOD_PLANKS = BLOCKS.register("silverwood_planks",
			() -> new Block(Block.Properties.from(Blocks.BIRCH_PLANKS)));
	public static final RegistryObject<Block> WITCHWOOD_PLANKS = BLOCKS.register("witchwood_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> ALDER_PLANKS = BLOCKS.register("alder_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> HAWTHORN_PLANKS = BLOCKS.register("hawthorn_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> ROWAN_PLANKS = BLOCKS.register("rowan_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> WILLOW_PLANKS = BLOCKS.register("willow_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> BEECH_PLANKS = BLOCKS.register("beech_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> ASH_PLANKS = BLOCKS.register("ash_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> BLACKTHORN_PLANKS = BLOCKS.register("blackthorn_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> CEDAR_PLANKS = BLOCKS.register("cedar_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> ELDER_PLANKS = BLOCKS.register("elder_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> JUNIPER_PLANKS = BLOCKS.register("juniper_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> WITCHHAZEL_PLANKS = BLOCKS.register("witchhazel_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> YEW_PLANKS = BLOCKS.register("yew_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> INFESTED_PLANKS = BLOCKS.register("infested_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
	public static final RegistryObject<Block> CHARRED_PLANKS = BLOCKS.register("charred_planks",
			() -> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));

	// Chest

	// Barrels
	public static final RegistryObject<Block> bloodoak_crate = BLOCKS.register("bloodoak_crate",
			() -> new BloodOakCrateBlock(Block.Properties.from(Blocks.BARREL)));
	public static final RegistryObject<Block> whiteoak_crate = BLOCKS.register("whiteoak_crate",
			() -> new WhiteOakCrateBlock(Block.Properties.from(Blocks.BARREL)));

	// Doors
	public static final RegistryObject<Block> bloodoak_door = BLOCKS.register("bloodoak_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> whiteoak_door = BLOCKS.register("whiteoak_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> silverwood_door = BLOCKS.register("silverwood_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> witchwood_door = BLOCKS.register("witchwood_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> alder_door = BLOCKS.register("alder_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> hawthorn_door = BLOCKS.register("hawthorn_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> rowan_door = BLOCKS.register("rowan_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> willow_door = BLOCKS.register("willow_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> beech_door = BLOCKS.register("beech_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> ash_door = BLOCKS.register("ash_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> blackthorn_door = BLOCKS.register("blackthorn_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> cedar_door = BLOCKS.register("cedar_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> elder_door = BLOCKS.register("elder_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> juniper_door = BLOCKS.register("juniper_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> witchhazel_door = BLOCKS.register("witchhazel_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> yew_door = BLOCKS.register("yew_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> infested_door = BLOCKS.register("infested_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> charred_door = BLOCKS.register("charred_door",
			() -> new ModDoor(Block.Properties.from(Blocks.OAK_DOOR)));

	// Trap Doors
	public static final RegistryObject<Block> bloodoak_trapdoor = BLOCKS.register("bloodoak_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> whiteoak_trapdoor = BLOCKS.register("whiteoak_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> silverwood_trapdoor = BLOCKS.register("silverwood_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> witchwood_trapdoor = BLOCKS.register("witchwood_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> alder_trapdoor = BLOCKS.register("alder_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> hawthorn_trapdoor = BLOCKS.register("hawthorn_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> rowan_trapdoor = BLOCKS.register("rowan_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> willow_trapdoor = BLOCKS.register("willow_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> beech_trapdoor = BLOCKS.register("beech_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> ash_trapdoor = BLOCKS.register("ash_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> blackthorn_trapdoor = BLOCKS.register("blackthorn_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> cedar_trapdoor = BLOCKS.register("cedar_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> elder_trapdoor = BLOCKS.register("elder_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> juniper_trapdoor = BLOCKS.register("juniper_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> witchhazel_trapdoor = BLOCKS.register("witchhazel_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> yew_trapdoor = BLOCKS.register("yew_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> infested_trapdoor = BLOCKS.register("infested_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
	public static final RegistryObject<Block> charred_trapdoor = BLOCKS.register("charred_trapdoor",
			() -> new ModTrapDoor(Block.Properties.from(Blocks.OAK_TRAPDOOR)));

	// Stairs
	public static final RegistryObject<Block> bloodoak_stairs = BLOCKS.register("bloodoak_stairs",
			() -> new StairsBlock(() -> BlockInit.BLOODOAK_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.RED)));
	public static final RegistryObject<Block> whiteoak_stairs = BLOCKS.register("whiteoak_stairs",
			() -> new StairsBlock(() -> BlockInit.WHITEOAK_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> silverwood_stairs = BLOCKS.register("silverwood_stairs",
			() -> new StairsBlock(() -> BlockInit.SILVERWOOD_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.BLUE)));
	public static final RegistryObject<Block> witchwood_stairs = BLOCKS.register("witchwood_stairs",
			() -> new StairsBlock(() -> BlockInit.WITCHWOOD_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.BLUE)));
	public static final RegistryObject<Block> alder_stairs = BLOCKS.register("alder_stairs",
			() -> new StairsBlock(() -> BlockInit.ALDER_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.ORANGE_TERRACOTTA)));
	public static final RegistryObject<Block> hawthorn_stairs = BLOCKS.register("hawthorn_stairs",
			() -> new StairsBlock(() -> BlockInit.HAWTHORN_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> rowan_stairs = BLOCKS.register("rowan_stairs",
			() -> new StairsBlock(() -> BlockInit.ROWAN_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.GREEN)));
	public static final RegistryObject<Block> willow_stairs = BLOCKS.register("willow_stairs",
			() -> new StairsBlock(() -> BlockInit.WILLOW_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.GREEN)));
	public static final RegistryObject<Block> beech_stairs = BLOCKS.register("beech_stairs",
			() -> new StairsBlock(() -> BlockInit.BEECH_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.GREEN)));
	public static final RegistryObject<Block> ash_stairs = BLOCKS.register("ash_stairs",
			() -> new StairsBlock(() -> BlockInit.ASH_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> blackthorn_stairs = BLOCKS.register("blackthorn_stairs",
			() -> new StairsBlock(() -> BlockInit.BLACKTHORN_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.GREEN)));
	public static final RegistryObject<Block> cedar_stairs = BLOCKS.register("cedar_stairs",
			() -> new StairsBlock(() -> BlockInit.CEDAR_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA)));
	public static final RegistryObject<Block> elder_stairs = BLOCKS.register("elder_stairs",
			() -> new StairsBlock(() -> BlockInit.ELDER_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.BROWN)));
	public static final RegistryObject<Block> juniper_stairs = BLOCKS.register("juniper_stairs",
			() -> new StairsBlock(() -> BlockInit.JUNIPER_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.BROWN)));
	public static final RegistryObject<Block> witchhazel_stairs = BLOCKS.register("witchhazel_stairs",
			() -> new StairsBlock(() -> BlockInit.WITCHHAZEL_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> yew_stairs = BLOCKS.register("yew_stairs",
			() -> new StairsBlock(() -> BlockInit.YEW_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.ORANGE_TERRACOTTA)));
	public static final RegistryObject<Block> infested_stairs = BLOCKS.register("infested_stairs",
			() -> new StairsBlock(() -> BlockInit.INFESTED_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> charred_stairs = BLOCKS.register("charred_stairs",
			() -> new StairsBlock(() -> BlockInit.CHARRED_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.BLACK)));
	public static final RegistryObject<Block> blackstone_stairs = BLOCKS.register("blackstone_stairs",
			() -> new StairsBlock(() -> BlockInit.BLACKSTONE.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> blackstonecobble_stairs = BLOCKS.register("blackstonecobble_stairs",
			() -> new StairsBlock(() -> BlockInit.BLACKSTONE_COBBLE.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> blackstonebricks_stairs = BLOCKS.register("blackstonebricks_stairs",
			() -> new StairsBlock(() -> BlockInit.BLACKSTONE_BRICKS.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> blackstonepolished_stairs = BLOCKS.register("blackstonepolished_stairs",
			() -> new StairsBlock(() -> BlockInit.BLACKSTONE_POLISHED.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> blackstonechisealed_stairs = BLOCKS.register("blackstonechisealed_stairs",
			() -> new StairsBlock(() -> BlockInit.blackstone_chisealed.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> blackstonecracked_stairs = BLOCKS.register("blackstonecracked_stairs",
			() -> new StairsBlock(() -> BlockInit.blackstone_cracked.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> mysticstone_stairs = BLOCKS.register("mysticstone_stairs",
			() -> new StairsBlock(() -> BlockInit.mysticstone.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> mysticstonecobble_stairs = BLOCKS.register("mysticstonecobble_stairs",
			() -> new StairsBlock(() -> BlockInit.mysticstone_cobble.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> mysticstonebricks_stairs = BLOCKS.register("mysticstonebricks_stairs",
			() -> new StairsBlock(() -> BlockInit.mysticstone_bricks.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> mysticstonepolished_stairs = BLOCKS.register("mysticstonepolished_stairs",
			() -> new StairsBlock(() -> BlockInit.mysticstone_polished.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> mysticstonechisealed_stairs = BLOCKS.register(
			"mysticstonechisealed_stairs",
			() -> new StairsBlock(() -> BlockInit.mysticstone_chisealed.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> mysticstonecracked_stairs = BLOCKS.register("mysticstonecracked_stairs",
			() -> new StairsBlock(() -> BlockInit.mysticstone_cracked.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> pearlstone_stairs = BLOCKS.register("pearlstone_stairs",
			() -> new StairsBlock(() -> BlockInit.pearlstone.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> pearlstonecobble_stairs = BLOCKS.register("pearlstonecobble_stairs",
			() -> new StairsBlock(() -> BlockInit.pearlstone_cobble.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> pearlstonebricks_stairs = BLOCKS.register("pearlstonebricks_stairs",
			() -> new StairsBlock(() -> BlockInit.pearlstone_bricks.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> pearlstonepolished_stairs = BLOCKS.register("pearlstonepolished_stairs",
			() -> new StairsBlock(() -> BlockInit.pearlstone_polished.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> pearlstonechisealed_stairs = BLOCKS.register("pearlstonechisealed_stairs",
			() -> new StairsBlock(() -> BlockInit.pearlstone_chisealed.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> pearlstonecracked_stairs = BLOCKS.register("pearlstonecracked_stairs",
			() -> new StairsBlock(() -> BlockInit.pearlstone_cracked.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> charredstone_stairs = BLOCKS.register("charredstone_stairs",
			() -> new StairsBlock(() -> BlockInit.charred_stone.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> charredcobble_stairs = BLOCKS.register("charredcobble_stairs",
			() -> new StairsBlock(() -> BlockInit.charred_cobble.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> charredbricks_stairs = BLOCKS.register("charredbricks_stairs",
			() -> new StairsBlock(() -> BlockInit.charred_bricks.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> charredpolished_stairs = BLOCKS.register("charredpolished_stairs",
			() -> new StairsBlock(() -> BlockInit.charred_polished.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> charredchisealed_stairs = BLOCKS.register("charredchisealed_stairs",
			() -> new StairsBlock(() -> BlockInit.charred_chisealed.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> charredcracked_stairs = BLOCKS.register("charredcracked_stairs",
			() -> new StairsBlock(() -> BlockInit.charred_cracked.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> marble_stairs = BLOCKS.register("marble_stairs",
			() -> new StairsBlock(() -> BlockInit.marble.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> marblecobble_stairs = BLOCKS.register("marblecobble_stairs",
			() -> new StairsBlock(() -> BlockInit.marble_cobble.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> marblebricks_stairs = BLOCKS.register("marblebricks_stairs",
			() -> new StairsBlock(() -> BlockInit.marble_bricks.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> marblepolished_stairs = BLOCKS.register("marblepolished_stairs",
			() -> new StairsBlock(() -> BlockInit.marble_polished.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> marblechisealed_stairs = BLOCKS.register("marblechisealed_stairs",
			() -> new StairsBlock(() -> BlockInit.marble_chisealed.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> marblecracked_stairs = BLOCKS.register("marblecracked_stairs",
			() -> new StairsBlock(() -> BlockInit.marble_cracked.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> infestedstone_stairs = BLOCKS.register("infestedstone_stairs",
			() -> new StairsBlock(() -> BlockInit.infested_stone.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.PURPLE)));
	public static final RegistryObject<Block> infestedcobble_stairs = BLOCKS.register("infestedcobble_stairs",
			() -> new StairsBlock(() -> BlockInit.infested_cobble.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.PURPLE)));
	public static final RegistryObject<Block> infestedbricks_stairs = BLOCKS.register("infestedbricks_stairs",
			() -> new StairsBlock(() -> BlockInit.infested_bricks.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.PURPLE)));
	public static final RegistryObject<Block> infestedpolished_stairs = BLOCKS.register("infestedpolished_stairs",
			() -> new StairsBlock(() -> BlockInit.infested_polished.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.PURPLE)));
	public static final RegistryObject<Block> infestedchisealed_stairs = BLOCKS.register("infestedchisealed_stairs",
			() -> new StairsBlock(() -> BlockInit.INFESTED_CHISEALED.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.PURPLE)));
	public static final RegistryObject<Block> infestedcracked_stairs = BLOCKS.register("infestedcracked_stairs",
			() -> new StairsBlock(() -> BlockInit.INFESTED_CRACKED.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.PURPLE)));
	public static final RegistryObject<Block> crimsonstone_stairs = BLOCKS.register("crimsonstone_stairs",
			() -> new StairsBlock(() -> BlockInit.CRIMSON_STONE.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.RED)));
	public static final RegistryObject<Block> crimsoncobble_stairs = BLOCKS.register("crimsoncobble_stairs",
			() -> new StairsBlock(() -> BlockInit.CRIMSON_COBBLE.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.RED)));
	public static final RegistryObject<Block> crimsonbricks_stairs = BLOCKS.register("crimsonbricks_stairs",
			() -> new StairsBlock(() -> BlockInit.CRIMSON_BRICKS.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.RED)));
	public static final RegistryObject<Block> crimsonpolished_stairs = BLOCKS.register("crimsonpolished_stairs",
			() -> new StairsBlock(() -> BlockInit.CRIMSON_POLISHED.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.RED)));
	public static final RegistryObject<Block> crimsonchisealed_stairs = BLOCKS.register("crimsonchisealed_stairs",
			() -> new StairsBlock(() -> BlockInit.CRIMSON_CHISEALED.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.RED)));
	public static final RegistryObject<Block> crimsoncracked_stairs = BLOCKS.register("crimsoncracked_stairs",
			() -> new StairsBlock(() -> BlockInit.CRIMSON_CRACKED.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.RED)));

	// Slabs
	public static final RegistryObject<Block> BLOODOAK_SLAB = BLOCKS.register("bloodoak_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.BLOODOAK_PLANKS.get())));
	public static final RegistryObject<Block> whiteoak_slab = BLOCKS.register("whiteoak_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.WHITEOAK_PLANKS.get())));
	public static final RegistryObject<Block> silverwood_slab = BLOCKS.register("silverwood_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.SILVERWOOD_PLANKS.get())));
	public static final RegistryObject<Block> witchwood_slab = BLOCKS.register("witchwood_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.WITCHWOOD_PLANKS.get())));
	public static final RegistryObject<Block> alder_slab = BLOCKS.register("alder_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.ALDER_PLANKS.get())));
	public static final RegistryObject<Block> hawthorn_slab = BLOCKS.register("hawthorn_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.HAWTHORN_PLANKS.get())));
	public static final RegistryObject<Block> rowan_slab = BLOCKS.register("rowan_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.ROWAN_PLANKS.get())));
	public static final RegistryObject<Block> willow_slab = BLOCKS.register("willow_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.WILLOW_PLANKS.get())));
	public static final RegistryObject<Block> beech_slab = BLOCKS.register("beech_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.BEECH_PLANKS.get())));
	public static final RegistryObject<Block> ash_slab = BLOCKS.register("ash_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.ASH_PLANKS.get())));
	public static final RegistryObject<Block> blackthorn_slab = BLOCKS.register("blackthorn_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.BLACKTHORN_PLANKS.get())));
	public static final RegistryObject<Block> cedar_slab = BLOCKS.register("cedar_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.CEDAR_PLANKS.get())));
	public static final RegistryObject<Block> elder_slab = BLOCKS.register("elder_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.ELDER_PLANKS.get())));
	public static final RegistryObject<Block> juniper_slab = BLOCKS.register("juniper_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.JUNIPER_PLANKS.get())));
	public static final RegistryObject<Block> witchhazel_slab = BLOCKS.register("witchhazel_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.WITCHHAZEL_PLANKS.get())));
	public static final RegistryObject<Block> yew_slab = BLOCKS.register("yew_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.YEW_PLANKS.get())));
	public static final RegistryObject<Block> infested_slab = BLOCKS.register("infested_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.INFESTED_PLANKS.get())));
	public static final RegistryObject<Block> charred_slab = BLOCKS.register("charred_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.CHARRED_PLANKS.get())));
	public static final RegistryObject<Block> blackstone_slab = BLOCKS.register("blackstone_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.BLACKSTONE.get())));
	public static final RegistryObject<Block> blackstonecobble_slab = BLOCKS.register("blackstonecobble_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.BLACKSTONE_COBBLE.get())));
	public static final RegistryObject<Block> blackstonebricks_slab = BLOCKS.register("blackstonebricks_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.BLACKSTONE_BRICKS.get())));
	public static final RegistryObject<Block> blackstonepolished_slab = BLOCKS.register("blackstonepolished_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.BLACKSTONE_POLISHED.get())));
	public static final RegistryObject<Block> blackstonechisealed_slab = BLOCKS.register("blackstonechisealed_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.blackstone_chisealed.get())));
	public static final RegistryObject<Block> blackstonecracked_slab = BLOCKS.register("blackstonecracked_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.blackstone_cracked.get())));
	public static final RegistryObject<Block> mysticstone_slab = BLOCKS.register("mysticstone_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.mysticstone.get())));
	public static final RegistryObject<Block> mysticstonecobble_slab = BLOCKS.register("mysticstonecobble_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.mysticstone_cobble.get())));
	public static final RegistryObject<Block> mysticstonebricks_slab = BLOCKS.register("mysticstonebricks_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.mysticstone_bricks.get())));
	public static final RegistryObject<Block> mysticstonepolished_slab = BLOCKS.register("mysticstonepolished_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.mysticstone_polished.get())));
	public static final RegistryObject<Block> mysticstonechisealed_slab = BLOCKS.register("mysticstonechisealed_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.mysticstone_chisealed.get())));
	public static final RegistryObject<Block> mysticstonecracked_slab = BLOCKS.register("mysticstonecracked_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.mysticstone_cracked.get())));
	public static final RegistryObject<Block> pearlstone_slab = BLOCKS.register("pearlstone_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.pearlstone.get())));
	public static final RegistryObject<Block> pearlstonecobble_slab = BLOCKS.register("pearlstonecobble_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.pearlstone_cobble.get())));
	public static final RegistryObject<Block> pearlstonebricks_slab = BLOCKS.register("pearlstonebricks_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.BLACKSTONE_BRICKS.get())));
	public static final RegistryObject<Block> pearlstonepolished_slab = BLOCKS.register("pearlstonepolished_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.pearlstone_polished.get())));
	public static final RegistryObject<Block> pearlstonechisealed_slab = BLOCKS.register("pearlstonechisealed_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.pearlstone_chisealed.get())));
	public static final RegistryObject<Block> pearlstonecracked_slab = BLOCKS.register("pearlstonecracked_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.pearlstone_cracked.get())));
	public static final RegistryObject<Block> charredstone_slab = BLOCKS.register("charredstone_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.charred_stone.get())));
	public static final RegistryObject<Block> charredcobble_slab = BLOCKS.register("charredcobble_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.charred_cobble.get())));
	public static final RegistryObject<Block> charredbricks_slab = BLOCKS.register("charredbricks_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.charred_bricks.get())));
	public static final RegistryObject<Block> charredpolished_slab = BLOCKS.register("charredpolished_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.charred_polished.get())));
	public static final RegistryObject<Block> charredchisealed_slab = BLOCKS.register("charredchisealed_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.charred_chisealed.get())));
	public static final RegistryObject<Block> charredcracked_slab = BLOCKS.register("charredcracked_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.charred_cracked.get())));
	public static final RegistryObject<Block> marble_slab = BLOCKS.register("marble_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.marble.get())));
	public static final RegistryObject<Block> marblecobble_slab = BLOCKS.register("marblecobble_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.marble_cobble.get())));
	public static final RegistryObject<Block> marblebricks_slab = BLOCKS.register("marblebricks_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.marble_bricks.get())));
	public static final RegistryObject<Block> marblepolished_slab = BLOCKS.register("marblepolished_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.marble_polished.get())));
	public static final RegistryObject<Block> marblechisealed_slab = BLOCKS.register("marblechisealed_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.marble_chisealed.get())));
	public static final RegistryObject<Block> marblecracked_slab = BLOCKS.register("marblecracked_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.marble_cracked.get())));
	public static final RegistryObject<Block> infestedstone_slab = BLOCKS.register("infestedstone_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.infested_stone.get())));
	public static final RegistryObject<Block> infestedcobble_slab = BLOCKS.register("infestedcobble_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.infested_cobble.get())));
	public static final RegistryObject<Block> infestedbricks_slab = BLOCKS.register("infestedbricks_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.infested_bricks.get())));
	public static final RegistryObject<Block> infestedpolished_slab = BLOCKS.register("infestedpolished_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.infested_polished.get())));
	public static final RegistryObject<Block> infestedchisealed_slab = BLOCKS.register("infestedchisealed_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.INFESTED_CHISEALED.get())));
	public static final RegistryObject<Block> infestedcracked_slab = BLOCKS.register("infestedcracked_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.INFESTED_CRACKED.get())));
	public static final RegistryObject<Block> crimson_slab = BLOCKS.register("crimson_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.CRIMSON_STONE.get())));
	public static final RegistryObject<Block> crimsoncobble_slab = BLOCKS.register("crimsoncobble_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.CRIMSON_COBBLE.get())));
	public static final RegistryObject<Block> crimsonbricks_slab = BLOCKS.register("crimsonbricks_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.CRIMSON_BRICKS.get())));
	public static final RegistryObject<Block> crimsonpolished_slab = BLOCKS.register("crimsonpolished_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.CRIMSON_POLISHED.get())));
	public static final RegistryObject<Block> crimsonchisealed_slab = BLOCKS.register("crimsonchisealed_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.CRIMSON_CHISEALED.get())));
	public static final RegistryObject<Block> crimsoncracked_slab = BLOCKS.register("crimsoncracked_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.CRIMSON_CRACKED.get())));

	// Buttons
	public static final RegistryObject<Block> bloodoak_button = BLOCKS.register("bloodoak_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.RED)));
	public static final RegistryObject<Block> whiteoak_button = BLOCKS.register("whiteoak_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> silverwood_button = BLOCKS.register("silverwood_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLUE)));
	public static final RegistryObject<Block> witchwood_button = BLOCKS.register("witchwood_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLUE)));
	public static final RegistryObject<Block> alder_button = BLOCKS.register("alder_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.ORANGE_TERRACOTTA)));
	public static final RegistryObject<Block> hawthorn_button = BLOCKS.register("hawthorn_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> rowan_button = BLOCKS.register("rowan_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.GREEN)));
	public static final RegistryObject<Block> willow_button = BLOCKS.register("willow_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.GREEN)));
	public static final RegistryObject<Block> beech_button = BLOCKS.register("beech_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN)));
	public static final RegistryObject<Block> ash_button = BLOCKS.register("ash_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> blackthorn_button = BLOCKS.register("blackthorn_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.GREEN)));
	public static final RegistryObject<Block> cedar_button = BLOCKS.register("cedar_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA)));
	public static final RegistryObject<Block> elder_button = BLOCKS.register("elder_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN)));
	public static final RegistryObject<Block> juniper_button = BLOCKS.register("juniper_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN)));
	public static final RegistryObject<Block> witchhazel_button = BLOCKS.register("witchhazel_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> yew_button = BLOCKS.register("yew_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.ORANGE_TERRACOTTA)));
	public static final RegistryObject<Block> infested_button = BLOCKS.register("infested_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> charred_button = BLOCKS.register("charred_button",
			() -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.ORANGE_TERRACOTTA)));
	public static final RegistryObject<Block> blackstone_button = BLOCKS.register("blackstone_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> blackstonecobble_button = BLOCKS.register("blackstonecobble_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> blackstonebricks_button = BLOCKS.register("blackstonebricks_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> blackstonepolished_button = BLOCKS.register("blackstonepolished_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> blackstonechisealed_button = BLOCKS.register("blackstonechisealed_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> blackstonecracked_button = BLOCKS.register("blackstonecracked_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> mysticstone_button = BLOCKS.register("mysticstone_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> mysticstonecobble_button = BLOCKS.register("mysticstonecobble_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> mysticstonebricks_button = BLOCKS.register("mysticstonebricks_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> mysticstonepolished_button = BLOCKS.register("mysticstonepolished_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> mysticstonechisealed_button = BLOCKS.register(
			"mysticstonechisealed_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> mysticstonecracked_button = BLOCKS.register("mysticstonecracked_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> pearlstone_button = BLOCKS.register("pearlstone_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> pearlstonecobble_button = BLOCKS.register("pearlstonecobble_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> pearlstonebricks_button = BLOCKS.register("pearlstonebricks_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> pearlstonepolished_button = BLOCKS.register("pearlstonepolished_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> pearlstonechisealed_button = BLOCKS.register("pearlstonechisealed_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> pearlstonecracked_button = BLOCKS.register("pearlstonecracked_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> charredstone_button = BLOCKS.register("charredstone_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> charredcobble_button = BLOCKS.register("charredcobble_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> charredbricks_button = BLOCKS.register("charredbricks_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> charredpolished_button = BLOCKS.register("charredpolished_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> charredchisealed_button = BLOCKS.register("charredchisealed_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> charredcracked_button = BLOCKS.register("charredcracked_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	public static final RegistryObject<Block> marble_button = BLOCKS.register("marble_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> marblecobble_button = BLOCKS.register("marblecobble_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> marblebricks_button = BLOCKS.register("marblebricks_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> marblepolished_button = BLOCKS.register("marblepolished_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> marblechisealed_button = BLOCKS.register("marblechisealed_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> marblecracked_button = BLOCKS.register("marblecracked_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY)));
	public static final RegistryObject<Block> infestedstone_button = BLOCKS.register("infestedstone_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.PURPLE)));
	public static final RegistryObject<Block> infestedcobble_button = BLOCKS.register("infestedcobble_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.PURPLE)));
	public static final RegistryObject<Block> infestedbricks_button = BLOCKS.register("infestedbricks_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.PURPLE)));
	public static final RegistryObject<Block> infestedpolished_button = BLOCKS.register("infestedpolished_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.PURPLE)));
	public static final RegistryObject<Block> infestedchisealed_button = BLOCKS.register("infestedchisealed_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.PURPLE)));
	public static final RegistryObject<Block> infestedcracked_button = BLOCKS.register("infestedcracked_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.PURPLE)));
	public static final RegistryObject<Block> crimson_button = BLOCKS.register("crimson_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.RED)));
	public static final RegistryObject<Block> crimsoncobble_button = BLOCKS.register("crimsoncobble_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.RED)));
	public static final RegistryObject<Block> crimsonbricks_button = BLOCKS.register("crimsonbricks_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.RED)));
	public static final RegistryObject<Block> crimsonpolished_button = BLOCKS.register("crimsonpolished_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.RED)));
	public static final RegistryObject<Block> crimsonchisealed_button = BLOCKS.register("crimsonchisealed_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.RED)));
	public static final RegistryObject<Block> crimsoncracked_button = BLOCKS.register("crimsoncracked_button",
			() -> new ModStoneButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.RED)));

	// Pressure Plates
	public static final RegistryObject<Block> bloodoak_pressureplate = BLOCKS.register("bloodoak_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.RED)));
	public static final RegistryObject<Block> whiteoak_pressureplate = BLOCKS.register("whiteoak_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> silverwood_pressureplate = BLOCKS.register("silverwood_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.BLUE)));
	public static final RegistryObject<Block> witchwood_pressureplate = BLOCKS.register("witchwood_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.BLUE)));
	public static final RegistryObject<Block> alder_pressureplate = BLOCKS.register("alder_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.ORANGE_TERRACOTTA)));
	public static final RegistryObject<Block> hawthorn_pressureplate = BLOCKS.register("hawthorn_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> rowan_pressureplate = BLOCKS.register("rowan_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.GREEN)));
	public static final RegistryObject<Block> willow_pressureplate = BLOCKS.register("willow_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.GREEN)));
	public static final RegistryObject<Block> beech_pressureplate = BLOCKS.register("beech_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.BROWN)));
	public static final RegistryObject<Block> ash_pressureplate = BLOCKS.register("ash_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> blackthorn_pressureplate = BLOCKS.register("blackthorn_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.GREEN)));
	public static final RegistryObject<Block> cedar_pressureplate = BLOCKS.register("cedar_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA)));
	public static final RegistryObject<Block> elder_pressureplate = BLOCKS.register("elder_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.BROWN)));
	public static final RegistryObject<Block> juniper_pressureplate = BLOCKS.register("juniper_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.BROWN)));
	public static final RegistryObject<Block> witchhazel_pressureplate = BLOCKS.register("witchhazel_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> yew_pressureplate = BLOCKS.register("yew_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.ORANGE_TERRACOTTA)));
	public static final RegistryObject<Block> infested_pressureplate = BLOCKS.register("infested_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> charred_pressureplate = BLOCKS.register("charred_pressureplate",
			() -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.ORANGE_TERRACOTTA)));

	// Fences
	public static final RegistryObject<Block> bloodoak_fence = BLOCKS.register("bloodoak_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.RED)));
	public static final RegistryObject<Block> whiteoak_fence = BLOCKS.register("whiteoak_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> silverwood_fence = BLOCKS.register("silverwood_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLUE)));
	public static final RegistryObject<Block> witchwood_fence = BLOCKS.register("witchwood_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLUE)));
	public static final RegistryObject<Block> alder_fence = BLOCKS.register("alder_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.ORANGE_TERRACOTTA)));
	public static final RegistryObject<Block> hawthorn_fence = BLOCKS.register("hawthorn_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> rowan_fence = BLOCKS.register("rowan_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.GREEN)));
	public static final RegistryObject<Block> willow_fence = BLOCKS.register("willow_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.GREEN)));
	public static final RegistryObject<Block> beech_fence = BLOCKS.register("beech_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN)));
	public static final RegistryObject<Block> ash_fence = BLOCKS.register("ash_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> blackthorn_fence = BLOCKS.register("blackthorn_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.GREEN)));
	public static final RegistryObject<Block> cedar_fence = BLOCKS.register("cedar_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN_TERRACOTTA)));
	public static final RegistryObject<Block> elder_fence = BLOCKS.register("elder_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN)));
	public static final RegistryObject<Block> juniper_fence = BLOCKS.register("juniper_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN)));
	public static final RegistryObject<Block> witchhazel_fence = BLOCKS.register("witchhazel_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> yew_fence = BLOCKS.register("yew_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.ORANGE_TERRACOTTA)));
	public static final RegistryObject<Block> infested_fence = BLOCKS.register("infested_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> charred_fence = BLOCKS.register("charred_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.ORANGE_TERRACOTTA)));

	// Fence Gates
	public static final RegistryObject<FenceGateBlock> bloodoak_fence_gate = BLOCKS.register("bloodoak_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> whiteoak_fence_gate = BLOCKS.register("whiteoak_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> silverwood_fence_gate = BLOCKS.register("silverwood_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> witchwood_fence_gate = BLOCKS.register("witchwood_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> alder_fence_gate = BLOCKS.register("alder_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> hawthorn_fence_gate = BLOCKS.register("hawthorn_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> rowan_fence_gate = BLOCKS.register("rowan_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> willow_fence_gate = BLOCKS.register("willow_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> beech_fence_gate = BLOCKS.register("beech_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> ash_fence_gate = BLOCKS.register("ash_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> blackthorn_fence_gate = BLOCKS.register("blackthorn_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> cedar_fence_gate = BLOCKS.register("cedar_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> elder_fence_gate = BLOCKS.register("elder_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> juniper_fence_gate = BLOCKS.register("juniper_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> witchhazel_fence_gate = BLOCKS.register("witchhazel_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> yew_fence_gate = BLOCKS.register("yew_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> infested_fence_gate = BLOCKS.register("infested_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<FenceGateBlock> charred_fence_gate = BLOCKS.register("charred_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));

	// Walls
	public static final RegistryObject<WallBlock> blackstone_wall = BLOCKS.register("blackstone_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> blackstonecobble_wall = BLOCKS.register("blackstonecobble_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> blackstonebricks_wall = BLOCKS.register("blackstonebricks_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> blackstonepolished_wall = BLOCKS.register("blackstonepolished_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> blackstonechisealed_wall = BLOCKS.register("blackstonechisealed_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> blackstonecracked_wall = BLOCKS.register("blackstonecracked_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> mysticstone_wall = BLOCKS.register("mysticstone_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> mysticstonecobble_wall = BLOCKS.register("mysticstonecobble_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> mysticstonebricks_wall = BLOCKS.register("mysticstonebricks_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> mysticstonepolished_wall = BLOCKS.register("mysticstonepolished_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> mysticstonechisealed_wall = BLOCKS
			.register("mysticstonechisealed_wall", () -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> mysticstonecracked_wall = BLOCKS.register("mysticstonecracked_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> pearlstone_wall = BLOCKS.register("pearlstone_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> pearlstonecobble_wall = BLOCKS.register("pearlstonecobble_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> pearlstonebricks_wall = BLOCKS.register("pearlstonebricks_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> pearlstonepolished_wall = BLOCKS.register("pearlstonepolished_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> pearlstonechisealed_wall = BLOCKS.register("pearlstonechisealed_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> pearlstonecracked_wall = BLOCKS.register("pearlstonecracked_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> charredstone_wall = BLOCKS.register("charredstone_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> charredcobble_wall = BLOCKS.register("charredcobble_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> charredbricks_wall = BLOCKS.register("charredbricks_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> charredpolished_wall = BLOCKS.register("charredpolished_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> charredchisealed_wall = BLOCKS.register("charredchisealed_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> charredcracked_wall = BLOCKS.register("charredcracked_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> marble_wall = BLOCKS.register("marble_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> marblecobble_wall = BLOCKS.register("marblecobble_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> marblebricks_wall = BLOCKS.register("marblebricks_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> marblepolished_wall = BLOCKS.register("marblepolished_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> marblechisealed_wall = BLOCKS.register("marblechisealed_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> marblecracked_wall = BLOCKS.register("marblecracked_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> infestedstone_wall = BLOCKS.register("infested_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> infestedcobble_wall = BLOCKS.register("infestedcobble_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> infestedbricks_wall = BLOCKS.register("infestedbricks_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> infestedpolished_wall = BLOCKS.register("infestedpolished_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> infestedchisealed_wall = BLOCKS.register("infestedchisealed_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> infestedcracked_wall = BLOCKS.register("infestedcracked_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> crimsonstone_wall = BLOCKS.register("crimsonstone_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> crimsoncobble_wall = BLOCKS.register("crimsoncobble_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> crimsonbricks_wall = BLOCKS.register("crimsonbricks_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> crimsonpolished_wall = BLOCKS.register("crimsonpolished_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> crimsonchisealed_wall = BLOCKS.register("crimsonchisealed_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));
	public static final RegistryObject<WallBlock> crimsoncracked_wall = BLOCKS.register("crimsoncracked_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.ANDESITE_WALL)));

	// Crops
	public static final RegistryObject<Block> vervain_crop = BLOCKS.register("vervain_crop",
			() -> new VervainCropBlock(Block.Properties.from(Blocks.WHEAT)));
	public static final RegistryObject<Block> wolfsbane_crop = BLOCKS.register("wolfsbane_crop",
			() -> new WolfsCropBlock(Block.Properties.from(Blocks.WHEAT)));
	public static final RegistryObject<Block> garlic_crop = BLOCKS.register("garlic_crop",
			() -> new GarlicCropBlock(Block.Properties.from(Blocks.WHEAT)));
	public static final RegistryObject<Block> belladonna_crop = BLOCKS.register("belladonna_crop",
			() -> new BelladonnaCropBlock(Block.Properties.from(Blocks.WHEAT)));
	public static final RegistryObject<Block> mandrake_crop = BLOCKS.register("mandrake_crop",
			() -> new MandrakeCropBlock(Block.Properties.from(Blocks.WHEAT)));
	public static final RegistryObject<Block> foxgloves_crop = BLOCKS.register("foxgloves_crop",
			() -> new FoxGlovesCropBlock(Block.Properties.from(Blocks.WHEAT)));
	public static final RegistryObject<Block> wormwood_crop = BLOCKS.register("wormwood_crop",
			() -> new WormwoodCrop(Block.Properties.from(Blocks.CARROTS)));
	public static final RegistryObject<Block> nightshade_crop = BLOCKS.register("nightshade_crop",
			() -> new NightShadeCrop(Block.Properties.from(Blocks.WHEAT)));
	public static final RegistryObject<Block> hellebore_crop = BLOCKS.register("hellebore_crop",
			() -> new HelleboreCrop(Block.Properties.from(Blocks.WHEAT)));
	public static final RegistryObject<Block> whitesage_crop = BLOCKS.register("whitesage_crop",
			() -> new WhitesageCrop(Block.Properties.from(Blocks.WHEAT)));
	public static final RegistryObject<Block> waterartichoke_crop = BLOCKS.register("waterartichoke_crop",
			() -> new WaterartichokeCrop(Block.Properties.from(Blocks.WHEAT)));
	public static final RegistryObject<Block> snowbell_crop = BLOCKS.register("snowbell_crop",
			() -> new SnowbellCrop(Block.Properties.from(Blocks.WHEAT)));

	// Plants
	public static final RegistryObject<Block> WEEPING_VINES = BLOCKS.register("weeping_vines",
			() -> new WeepingVineBlock(Block.Properties.from(Blocks.VINE)));
	public static final RegistryObject<Block> SPANISH_MOSS = BLOCKS.register("spanish_moss",
			() -> new SpanishMossBlock(Block.Properties.from(Blocks.VINE)));

	// Special blocks
	public static final RegistryObject<Block> pandors_box = BLOCKS.register("pandors_box", () -> new PandorsBox(
			Block.Properties.from(Blocks.BONE_BLOCK).notSolid().harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> pandors_box_open = BLOCKS.register("pandors_box_open",
			() -> new PandorsBoxOpen(
					Block.Properties.from(Blocks.BONE_BLOCK).notSolid().harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> magic_quarry = BLOCKS.register("magic_quarry",
			() -> new BlockQuarry(Block.Properties.create(Material.IRON).sound(SoundType.LANTERN).notSolid()));

	public static final RegistryObject<Block> PEDESTAL_TIER1 = BLOCKS.register("pedestal_tier1",
			() -> new PedestalTier1(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> PEDESTAL_TIER2 = BLOCKS.register("pedestal_tier2",
			() -> new PedestalTier2(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> PEDESTAL_TIER3 = BLOCKS.register("pedestal_tier3", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> PEDESTAL_TIER4 = BLOCKS.register("pedestal_tier4", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> PEDESTAL_TIER5 = BLOCKS.register("pedestal_tier5", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> PEDESTAL_TIER6 = BLOCKS.register("pedestal_tier6", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> HELL_FIRE = BLOCKS.register("hell_fire",
			() -> new HellFireBlock(Block.Properties.create(Material.FIRE).hardnessAndResistance(0.5f, 15.0f)
					.sound(SoundType.field_226947_m_).doesNotBlockMovement().notSolid().lightValue(15)));

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> NO_ITEM_BLOCK = new DeferredRegister<>(ForgeRegistries.BLOCKS,
			MythicCraft.MOD_ID);

	public static final RegistryObject<Block> ICY_BERRY_BUSH = NO_ITEM_BLOCK.register("icy_berry_bush",
			() -> new IcyBerryBushBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> BLOOD_BERRY_BUSH = NO_ITEM_BLOCK.register("blood_berry_bush",
			() -> new BloodBerryBushBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> SILVER_BERRY_BUSH = NO_ITEM_BLOCK.register("silver_berry_bush",
			() -> new SilverBerryBushBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement()
					.tickRandomly().sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> CHARRED_BERRY_BUSH = NO_ITEM_BLOCK.register("charred_berry_bush",
			() -> new CharredBerryBushBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement()
					.tickRandomly().sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> SOUL_BERRY_BUSH = NO_ITEM_BLOCK.register("soul_berry_bush",
			() -> new SoulBerryBushBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> INFESTED_BERRY_BUSH = NO_ITEM_BLOCK.register("infested_berry_bush",
			() -> new InfestedBerryBushBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement()
					.tickRandomly().sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> MYSTIC_BERRY_BUSH = NO_ITEM_BLOCK.register("mystic_berry_bush",
			() -> new MysticBerryBushBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement()
					.tickRandomly().sound(SoundType.SWEET_BERRY_BUSH)));

}