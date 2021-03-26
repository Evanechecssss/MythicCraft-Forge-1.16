package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.world.biomes.CharredForestBiome;
import com.masterquentus.mythiccraft.world.biomes.CharredForestBiomeSurfaceBuilder;
import com.masterquentus.mythiccraft.world.biomes.CrimsonFrostBiome;
import com.masterquentus.mythiccraft.world.biomes.CrimsonFrostBiomeSurfaceBuilder;
import com.masterquentus.mythiccraft.world.biomes.MysiticMedowsBiome;
import com.masterquentus.mythiccraft.world.biomes.VampireBiome;
import com.masterquentus.mythiccraft.world.biomes.WeepingWitchForestBiome;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Biome> Biomes = new DeferredRegister<>(ForgeRegistries.BIOMES,
			MythicCraft.MOD_ID);

	public static final RegistryObject<Biome> VAMPIREBIOME = Biomes.register("vampire_biome",
			() -> new VampireBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(0.5F).temperature(0.5F)
					.waterColor(4849664).waterFogColor(3145728)
					.surfaceBuilder(SurfaceBuilder.MOUNTAIN,
							new SurfaceBuilderConfig(BlockInit.ASH_BLOCK.get().getDefaultState(),
									BlockInit.BLACKSTONE.get().getDefaultState(), Blocks.CLAY.getDefaultState()))
					.category(Category.FOREST).downfall(1.5F).depth(0.12F).parent(null)));
	public static final RegistryObject<Biome> MISTICMEDDOWSBIOME = Biomes.register("misticmedows_biome",
			() -> new MysiticMedowsBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(0.5F).temperature(0.5F)
					.waterColor(1822207).waterFogColor(1828351)
					.surfaceBuilder(SurfaceBuilder.MOUNTAIN,
							new SurfaceBuilderConfig(Blocks.GRASS.getDefaultState(),
									BlockInit.mysticstone.get().getDefaultState(), Blocks.CLAY.getDefaultState()))
					.category(Category.FOREST).downfall(1.5F).depth(0.12F).parent(null)));
	public static final RegistryObject<Biome> CHARREDFORESTBIOME = Biomes.register("charredforest_biome",
			() -> new CharredForestBiome(new Biome.Builder()
					.precipitation(RainType.NONE).scale(1.2f).temperature(0.5f).waterColor(3351).waterFogColor(
							3361)
					.surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
							register("charred_surface",
									new CharredForestBiomeSurfaceBuilder(SurfaceBuilderConfig::deserialize)),
							new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(),
									Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())))
					.category(Category.FOREST).downfall(0.5f).depth(0.12f).parent(null)));
	public static final RegistryObject<Biome> INFESTEDFORESTBIOME = Biomes.register("infestedforest_biome",
			() -> new CharredForestBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(0.5F).temperature(0.5F)
					.waterColor(3545143).waterFogColor(4069431)
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
									Blocks.STONE.getDefaultState(), Blocks.GRAVEL.getDefaultState()))
					.category(Category.FOREST).downfall(1.5F).depth(0.12F).parent(null)));
	public static final RegistryObject<Biome> DRAGONBIOME = Biomes.register("dragon_biome",
			() -> new CharredForestBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(5.5F).temperature(0.5F)
					.waterColor(3545143).waterFogColor(4069431)
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
									Blocks.STONE.getDefaultState(), Blocks.GRAVEL.getDefaultState()))
					.category(Category.FOREST).downfall(1.5F).depth(0.12F).parent(null)));
	public static final RegistryObject<Biome> CRIMSON_FROST = Biomes.register("crimson_frost",
			() -> new CrimsonFrostBiome(new Biome.Builder()
					.precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f).waterColor(3351).waterFogColor(
							3361)
					.surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
							register("crimson_frost",
									new CrimsonFrostBiomeSurfaceBuilder(SurfaceBuilderConfig::deserialize)),
							new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(),
									Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())))
					.category(Category.ICY).downfall(0.5f).depth(0.12f).parent(null)));
	public static final RegistryObject<Biome> WEEPINGWITCHFOREST = Biomes.register("weepingwitch_forest",
			() -> new WeepingWitchForestBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(0.5F)
					.temperature(0.5F).waterColor(3093084).waterFogColor(3093066)
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
									Blocks.STONE.getDefaultState(), Blocks.CLAY.getDefaultState()))
					.category(Category.FOREST).downfall(3.5F).depth(0.12F).parent(null)));

	public static void registerBiomes() {
		registerBiome(VAMPIREBIOME.get(), Type.DEAD, Type.DENSE);
		registerBiome(MISTICMEDDOWSBIOME.get(), Type.MAGICAL, Type.DENSE);
		registerBiome(CHARREDFORESTBIOME.get(), Type.FOREST, Type.DRY);
		registerBiome(INFESTEDFORESTBIOME.get(), Type.FOREST, Type.DENSE);
		registerBiome(DRAGONBIOME.get(), Type.MAGICAL, Type.DENSE);
		registerBiome(CRIMSON_FROST.get(), Type.MAGICAL, Type.COLD);
		registerBiome(WEEPINGWITCHFOREST.get(), Type.MAGICAL, Type.WET);
	}

	private static void registerBiome(Biome biome, Type... types) {
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 2));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
		return (F) (Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
	}
}