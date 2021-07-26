package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.init.auto.LanternType;
import com.masterquentus.mythiccraft.init.auto.OreType;
import com.masterquentus.mythiccraft.init.auto.StoneType;
import com.masterquentus.mythiccraft.init.auto.WoodTypes;
import com.masterquentus.mythiccraft.objects.blocks.BrokenCrystalBallBlock;
import com.masterquentus.mythiccraft.objects.blocks.CinderPlantBlock;
import com.masterquentus.mythiccraft.objects.blocks.CrystalBallBlock;
import com.masterquentus.mythiccraft.objects.blocks.EmberMossBlock;
import com.masterquentus.mythiccraft.objects.blocks.EnderBrambleBlock;
import com.masterquentus.mythiccraft.objects.blocks.GrassperBlock;
import com.masterquentus.mythiccraft.objects.blocks.HellFireBlock;
import com.masterquentus.mythiccraft.objects.blocks.MagicMirrorBlock;
import com.masterquentus.mythiccraft.objects.blocks.MobSlayerBlock;
import com.masterquentus.mythiccraft.objects.blocks.ModBerryBushBlock;
import com.masterquentus.mythiccraft.objects.blocks.ModCropBlock;
import com.masterquentus.mythiccraft.objects.blocks.ModGrassBlock;
import com.masterquentus.mythiccraft.objects.blocks.ModIceBlock;
import com.masterquentus.mythiccraft.objects.blocks.ModKelpBlock;
import com.masterquentus.mythiccraft.objects.blocks.ModKelpTopBlock;
import com.masterquentus.mythiccraft.objects.blocks.ModLanternBlock;
import com.masterquentus.mythiccraft.objects.blocks.ModLayer;
import com.masterquentus.mythiccraft.objects.blocks.ModPaneBlock;
import com.masterquentus.mythiccraft.objects.blocks.PandorsBox;
import com.masterquentus.mythiccraft.objects.blocks.PandorsBoxOpen;
import com.masterquentus.mythiccraft.objects.blocks.PedestalBlock;
import com.masterquentus.mythiccraft.objects.blocks.QuarryBlock;
import com.masterquentus.mythiccraft.objects.blocks.StatueOfBrokenCursesBlock;
import com.masterquentus.mythiccraft.objects.blocks.TrophyBlock;
import com.masterquentus.mythiccraft.objects.blocks.WaterartichokeCrop;
import com.masterquentus.mythiccraft.objects.blocks.WildBrambleBlock;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.block.MushroomBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlimeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.VineBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
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

	public static Block[] getAllChest() {
		Block[] chest = new Block[WoodTypes.values().length];
		for (int i = 0; i < WoodTypes.values().length; i++) {
			chest[i] = WoodTypes.values()[i].chest.get();
		}

		return chest;

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
			() -> new ModGrassBlock(Block.Properties.of(Material.DIRT, MaterialColor.COLOR_BLACK)
					.sound(SoundType.GRAVEL).harvestTool(ToolType.SHOVEL).harvestLevel(0)));
	public static final RegistryObject<Block> CONGEALED_BLOOD = BLOCKS.register("congealed_blood",
			() -> new Block(Block.Properties.copy(Blocks.HONEY_BLOCK).strength(5.0f, 30.0f).sound(SoundType.SLIME_BLOCK)
					.harvestLevel(1)));
	public static final RegistryObject<Block> ROSEQUARTZ_CHISELED = BLOCKS.register("rosequartz_chiseled",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> ROSEQUARTZ_SMOOTH = BLOCKS.register("rosequartz_smooth",
			() -> new Block(Block.Properties.of(Material.STONE).strength(5.0f, 30.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> ROSEQUARTZ_PILLAR = BLOCKS.register("rosequartz_pillar",
			() -> new RotatedPillarBlock(Block.Properties.copy(Blocks.QUARTZ_PILLAR).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> ROSEQUARTZ_BRICKS = BLOCKS.register("rosequartz_bricks",
			() -> new RotatedPillarBlock(Block.Properties.copy(Blocks.QUARTZ_BLOCK).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> CHARREDSLIME_BLOCK = BLOCKS.register("charredslime_block",
			() -> new SlimeBlock(Block.Properties.copy(Blocks.SLIME_BLOCK).harvestLevel(1)));
	public static final RegistryObject<Block> INFESTEDSLIME_BLOCK = BLOCKS.register("infestedslime_block",
			() -> new SlimeBlock(Block.Properties.copy(Blocks.SLIME_BLOCK).harvestLevel(1)));
	public static final RegistryObject<Block> ASH_BLOCK = BLOCKS.register("ash_block",
			() -> new Block(Block.Properties.copy(Blocks.RED_SAND).harvestTool(ToolType.SHOVEL).harvestLevel(1)));
	public static final RegistryObject<Block> HOTASH_BLOCK = BLOCKS.register("hotash_block",
			() -> new Block(Block.Properties.copy(Blocks.RED_SAND)));
	public static final RegistryObject<Block> ASH_LAYER = BLOCKS.register("ash_layer",
			() -> new ModLayer(Block.Properties.copy(Blocks.SAND).strength(0.3f, 0.2f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> HOTASH_LAYER = BLOCKS.register("hotash_layer",
			() -> new ModLayer(Block.Properties.copy(Blocks.SAND).strength(0.3f, 0.2f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> MAGIC_WALL = BLOCKS.register("magic_wall",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(0.3f, 0.2f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> LIVING_KELP_BLOCK = BLOCKS.register("living_kelp_block",
			() -> new Block(Block.Properties.copy(Blocks.DRIED_KELP_BLOCK).strength(0.3f, 0.2f).sound(SoundType.FUNGUS)
					.lightLevel((state) -> 13)));
	public static final RegistryObject<Block> MIRROR_BLOCK = BLOCKS.register("mirror_blocks",
			() -> new Block(Block.Properties.copy(Blocks.STONE).strength(5.5f, 5.5f).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> EMBER_BLOCK = BLOCKS.register("ember_block", () -> new Block(
			Block.Properties.copy(Blocks.STONE).strength(5.5f, 5.5f).sound(SoundType.STONE).lightLevel((state) -> 15)));

	// Transparent Blocks
	public static final RegistryObject<Block> CRIMSON_ICE = BLOCKS.register("crimson_ice", () -> new ModIceBlock(
			Block.Properties.copy(Blocks.ICE).strength(0.3f, 0.2f).sound(SoundType.GLASS).friction(0.98f)));
	public static final RegistryObject<Block> CRIMSON_PACKEDICE = BLOCKS.register("crimson_packedice", () -> new Block(
			Block.Properties.copy(Blocks.PACKED_ICE).strength(0.3f, 0.2f).sound(SoundType.GLASS).friction(0.98f)));
	public static final RegistryObject<Block> BLACK_ICE = BLOCKS.register("black_ice", () -> new ModIceBlock(
			Block.Properties.copy(Blocks.ICE).strength(0.3f, 0.2f).sound(SoundType.GLASS).friction(0.98f)));
	public static final RegistryObject<Block> BLACK_PACKEDICE = BLOCKS.register("black_packedice",
			() -> new Block(Block.Properties.copy(Blocks.PACKED_ICE).strength(0.3f, 0.2f).sound(SoundType.GLASS)
					.friction(0.98f).speedFactor(0.7f).randomTicks().noOcclusion()));
	public static final RegistryObject<Block> PIXIE_GLASS = BLOCKS.register("pixie_glass", () -> new Block(
			Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> FAIRY_GLASS = BLOCKS.register("fairy_glass", () -> new Block(
			Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> PIXIE_GLASS_PANE = BLOCKS.register("pixie_glass_pane",
			() -> new ModPaneBlock(
					Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> FAIRY_GLASS_PANE = BLOCKS.register("fairy_glass_pane",
			() -> new ModPaneBlock(
					Block.Properties.copy(Blocks.GLASS).strength(0.3f, 0.2f).sound(SoundType.GLASS).noOcclusion()));

	// Lanterns/Glowstone/Torches
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
	public static final RegistryObject<Block> vervain_crop = createCrop("vervain_crop", ItemInit.vervain_seeds);
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
			() -> new FlowerBlock(Effects.HUNGER, 5,
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
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_PRICKLY_FLOWER = BLOCKS.register("potted_prickly_flower",
			() -> new FlowerPotBlock(BlockInit.PRICKLY_FLOWER.get(),
					Block.Properties.copy(Blocks.BRICKS).instabreak().noOcclusion()));
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
	public static final RegistryObject<Block> EMBER_MOSS = BLOCKS.register("ember_moss",
			() -> new EmberMossBlock(Block.Properties.copy(Blocks.VINE)));
	public static final RegistryObject<Block> LIVING_KELP_TOP = BLOCKS.register("living_kelp_top",
			() -> new ModKelpTopBlock(Block.Properties.copy(Blocks.KELP_PLANT).sound(SoundType.WET_GRASS).randomTicks()
					.noCollission().lightLevel((state) -> 15)));
	public static final RegistryObject<Block> LIVING_KELP_PLANT = BLOCKS.register("living_kelp_plant",
			() -> new ModKelpBlock(Block.Properties.copy(Blocks.KELP_PLANT).sound(SoundType.WET_GRASS).randomTicks()
					.noCollission().lightLevel((state) -> 15)));
	public static final RegistryObject<Block> WILD_BRAMBLE = BLOCKS.register("wild_bramble",
			() -> new WildBrambleBlock(Block.Properties.copy(Blocks.SUGAR_CANE).randomTicks().noCollission()));
	public static final RegistryObject<Block> ENDER_BRAMBLE = BLOCKS.register("ender_bramble",
			() -> new EnderBrambleBlock(
					Block.Properties.copy(Blocks.SUGAR_CANE).randomTicks().noCollission().harvestTool(ToolType.AXE)));
	public static final RegistryObject<Block> SCORCHED_GRASS_SMALL = BLOCKS.register("scorched_grass_small",
			() -> new GrassBlock(Block.Properties.copy(Blocks.GRASS)));
	public static final RegistryObject<Block> SCORCHED_GRASS = BLOCKS.register("scorched_grass",
			() -> new GrassBlock(Block.Properties.copy(Blocks.GRASS)));
	public static final RegistryObject<Block> SCORCHED_GRASS_MEDIUM = BLOCKS.register("scorched_grass_medium",
			() -> new GrassBlock(Block.Properties.copy(Blocks.GRASS)));
	public static final RegistryObject<Block> SCORCHED_GRASS_GLOWING = BLOCKS.register("scorched_grass_glowing",
			() -> new GrassBlock(Block.Properties.copy(Blocks.GRASS).lightLevel((state) -> 10)));
	public static final RegistryObject<Block> GLINT_WEED = BLOCKS.register("glint_weed",
			() -> new GrassBlock(Block.Properties.copy(Blocks.GRASS).lightLevel((state) -> 10)));
	public static final RegistryObject<Block> WISPY_COTTON = BLOCKS.register("wispy_cotton",
			() -> new GrassBlock(Block.Properties.copy(Blocks.GRASS)));
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

	// Special blocks
	public static final RegistryObject<Block> pandors_box = BLOCKS.register("pandors_box", () -> new PandorsBox(
			Block.Properties.copy(Blocks.BONE_BLOCK).noOcclusion().harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> pandors_box_open = BLOCKS.register("pandors_box_open",
			() -> new PandorsBoxOpen(Block.Properties.copy(Blocks.BONE_BLOCK).noOcclusion()
					.harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> magic_quarry = BLOCKS.register("magic_quarry",
			() -> new QuarryBlock(Block.Properties.of(Material.METAL).sound(SoundType.LANTERN).noOcclusion()
					.harvestTool(ToolType.PICKAXE).harvestLevel(2)));
	public static final RegistryObject<Block> MAGIC_MIRROR = BLOCKS.register("magic_mirror",
			() -> new MagicMirrorBlock(Block.Properties.of(Material.GLASS).sound(SoundType.GLASS).noOcclusion()
					.harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> STATUE_OF_BOKEN_CURSES = BLOCKS.register("statue_of_broken_curses",
			() -> new StatueOfBrokenCursesBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).noOcclusion()
					.harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> CRYSTAL_BALL = BLOCKS.register("crystal_ball",
			() -> new CrystalBallBlock(Block.Properties.of(Material.GLASS).sound(SoundType.GLASS).noOcclusion()
					.harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> BROKEN_CRYSTAL_BALL = BLOCKS.register("broken_crystal_ball",
			() -> new BrokenCrystalBallBlock(Block.Properties.of(Material.GLASS).sound(SoundType.GLASS).noOcclusion()
					.harvestTool(ToolType.PICKAXE).harvestLevel(1)));
	public static final RegistryObject<Block> MOB_SLAYER = BLOCKS.register("mob_slayer", () -> new MobSlayerBlock(
			Block.Properties.copy(Blocks.SLIME_BLOCK).harvestTool(ToolType.PICKAXE).harvestLevel(0)));

	// class
	public static final RegistryObject<Block> PEDESTAL_TIER1 = BLOCKS.register("pedestal_tier1",
			() -> new PedestalBlock(1, Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2)));

	public static final RegistryObject<Block> PEDESTAL_TIER2 = BLOCKS.register("pedestal_tier2",
			() -> new PedestalBlock(2, Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2)));

	public static final RegistryObject<Block> PEDESTAL_TIER3 = BLOCKS.register("pedestal_tier3",
			() -> new PedestalBlock(3, Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2)));

	public static final RegistryObject<Block> PEDESTAL_TIER4 = BLOCKS.register("pedestal_tier4",
			() -> new PedestalBlock(4, Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2)));

	public static final RegistryObject<Block> PEDESTAL_TIER5 = BLOCKS.register("pedestal_tier5",
			() -> new PedestalBlock(5, Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2)));

	public static final RegistryObject<Block> PEDESTAL_TIER6 = BLOCKS.register("pedestal_tier6",
			() -> new PedestalBlock(6, Block.Properties.of(Material.STONE).strength(0.5f, 15.0f).sound(SoundType.STONE)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2)));

	public static final RegistryObject<Block> HELL_FIRE = BLOCKS.register("hell_fire",
			() -> new HellFireBlock(Block.Properties.of(Material.FIRE).strength(0.5f, 15.0f)
					.sound(SoundType.HONEY_BLOCK).noCollission().noOcclusion().lightLevel((state) -> 15)));

	public static final DeferredRegister<Block> NO_ITEM_BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS,
			MythicCraft.MOD_ID);

	public static final RegistryObject<Block> ICY_BERRY_BUSH = NO_ITEM_BLOCK.register("icy_berry_bush",
			() -> new ModBerryBushBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> BLOOD_BERRY_BUSH = NO_ITEM_BLOCK.register("blood_berry_bush",
			() -> new ModBerryBushBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> SILVER_BERRY_BUSH = NO_ITEM_BLOCK.register("silver_berry_bush",
			() -> new ModBerryBushBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> CHARRED_BERRY_BUSH = NO_ITEM_BLOCK.register("charred_berry_bush",
			() -> new ModBerryBushBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> SOUL_BERRY_BUSH = NO_ITEM_BLOCK.register("soul_berry_bush",
			() -> new ModBerryBushBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> INFESTED_BERRY_BUSH = NO_ITEM_BLOCK.register("infested_berry_bush",
			() -> new ModBerryBushBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> MYSTIC_BERRY_BUSH = NO_ITEM_BLOCK.register("mystic_berry_bush",
			() -> new ModBerryBushBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> CINDER_FRUIT_PLANT = NO_ITEM_BLOCK.register("cinder_fruit_plant",
			() -> new CinderPlantBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks()
					.sound(SoundType.SWEET_BERRY_BUSH).lightLevel((state) -> 13), ParticleTypes.SMOKE));

}