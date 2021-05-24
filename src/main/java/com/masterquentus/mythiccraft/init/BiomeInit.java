package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.world.biomes.*;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


@Mod.EventBusSubscriber(modid = MythicCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BiomeInit {
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, MythicCraft.MOD_ID);

	public static final RegistryObject<Biome> VAMPIREBIOME = BIOMES.register("vampire_biome",
			() -> new VampireBiome().create(new Biome.Builder().precipitation(RainType.RAIN).scale(0.5F).temperature(0.5F)
					.biomeCategory(Category.FOREST).downfall(1.5F).depth(0.12F)));

	public static final RegistryObject<Biome> MISTICMEDDOWSBIOME = BIOMES.register("misticmedows_biome",
			() -> new MysiticMedowsBiome().create(new Biome.Builder().precipitation(RainType.RAIN).scale(0.5F).temperature(0.5F)
					.biomeCategory(Category.FOREST).downfall(1.5F).depth(0.12F)));



	public static final RegistryObject<Biome> CHARREDFORESTBIOME = BIOMES.register("charredforest_biome",
			() -> new CharredForestBiome().create(new Biome.Builder()
					.precipitation(RainType.NONE).scale(1.2f).temperature(0.5f)
					.biomeCategory(Category.FOREST).downfall(0.5f).depth(0.12f)));

	// this is just the same ??
	public static final RegistryObject<Biome> INFESTEDFORESTBIOME = BIOMES.register("infestedforest_biome",
			() -> new CharredForestBiome().create(new Biome.Builder()
					.precipitation(RainType.NONE).scale(1.2f).temperature(0.5f)
					.biomeCategory(Category.FOREST).downfall(0.5f).depth(0.12f)));

	public static final RegistryObject<Biome> DRAGONBIOME = BIOMES.register("dragon_biome",
			() -> new DragonBiome().create(new Biome.Builder().precipitation(RainType.RAIN).scale(5.5F).temperature(0.5F)
					.biomeCategory(Category.FOREST).downfall(1.5F).depth(0.12F)));

	public static final RegistryObject<Biome> CRIMSON_FROST = BIOMES.register("crimson_frost",
			() -> new CrimsonFrostBiome().create(new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
					.biomeCategory(Category.ICY).downfall(0.5f).depth(0.12f)));

	public static final RegistryObject<Biome> FORESTOFLOSTSOULS = BIOMES.register("forest_of_lost_souls",
			() -> new ForestOFLostSoulsBiome().create(new Biome.Builder().precipitation(RainType.RAIN).scale(0.5F)
					.temperature(0.5F).biomeCategory(Category.FOREST).downfall(3.5F).depth(0.12F)));

	// this is just the same ??
	public static final RegistryObject<Biome> WEEPINGWITCHFOREST = BIOMES.register("weepingwitch_forest",
			() -> new ForestOFLostSoulsBiome().create(new Biome.Builder().precipitation(RainType.RAIN).scale(0.5F)
					.temperature(0.5F).biomeCategory(Category.FOREST).downfall(3.5F).depth(0.12F)));

	/*  // this isnt how you do this anymore
	public static void registerBiomes() {
		registerBiome(VAMPIREBIOME.get(), Type.DEAD, Type.DENSE);
		registerBiome(MISTICMEDDOWSBIOME.get(), Type.MAGICAL, Type.DENSE);
		registerBiome(CHARREDFORESTBIOME.get(), Type.FOREST, Type.DRY);
		registerBiome(INFESTEDFORESTBIOME.get(), Type.FOREST, Type.DENSE);
		registerBiome(DRAGONBIOME.get(), Type.MAGICAL, Type.DENSE);
		registerBiome(CRIMSON_FROST.get(), Type.MAGICAL, Type.COLD);
		registerBiome(WEEPINGWITCHFOREST.get(), Type.MAGICAL, Type.WET);
		registerBiome(FORESTOFLOSTSOULS.get(), Type.MAGICAL, Type.FOREST);
	}

	private static void registerBiome(Biome biome, Type... types) {
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 2));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}

	 */

	@SubscribeEvent
	public static void onloadbiome(BiomeLoadingEvent event){
		ResourceLocation name = event.getName();

		// if its one of our biomes
		// should individually check each biome to set the type and weight
		if (name.getNamespace().equals(MythicCraft.MOD_ID)){
			// add to world gen
			RegistryKey<Biome> key = RegistryKey.create(Registry.BIOME_REGISTRY, name);
			BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(key, 2));
		}
	}
}