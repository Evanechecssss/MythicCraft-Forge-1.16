package com.masterquentus.mythiccraft.init;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.world.feature.structures.GoblinHousePieces;
import com.masterquentus.mythiccraft.world.feature.structures.GoblinHouseStructure;
import com.masterquentus.mythiccraft.world.feature.structures.WolfDenPieces;
import com.masterquentus.mythiccraft.world.feature.structures.WolfDenStructure;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.World;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

// your ide will probably show errors in this class (accessing private / final fields)
// when you try to run it, it wont crash because of the Access Transformer

@Mod.EventBusSubscriber(bus = Bus.FORGE, modid = MythicCraft.MOD_ID)
public class FeatureInit {

	// Structure Types
	public static Structure<NoFeatureConfig> GOBLIN_HOUSE = new GoblinHouseStructure(NoFeatureConfig.CODEC);
	public static IStructurePieceType GOBLIN_HOUSE_PIECE = GoblinHousePieces.Piece::new;

	public static Structure<NoFeatureConfig> WOLF_DEN = new GoblinHouseStructure(NoFeatureConfig.CODEC);
	public static IStructurePieceType WOLF_DEN_PIECE = GoblinHousePieces.Piece::new;

	// Configured Structures

	public static StructureFeature<?, ?> CONFIGURED_GOBLIN_HOUSE = GOBLIN_HOUSE.configured(IFeatureConfig.NONE);
	public static StructureFeature<?, ?> CONFIGURED_WOLF_DEN = WOLF_DEN.configured(IFeatureConfig.NONE);

	// Event Listeners

	@SubscribeEvent
	public void onRegisterStructures(final RegistryEvent.Register<Structure<?>> event) {
		MythicCraft.LOGGER.debug("onRegisterStructures !!!");


		// Structures
		registerStructure(
				GOBLIN_HOUSE,
				new StructureSeparationSettings(10 /* maximum distance apart in chunks between spawn attempts */,
						5 /* minimum distance apart in chunks between spawn attempts */,
						1234567890 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
				true);
		registerStructurePiece(GOBLIN_HOUSE_PIECE, new ResourceLocation(MythicCraft.MOD_ID, "goblin_house_piece"));

		registerStructure(
				WOLF_DEN,
				new StructureSeparationSettings(10 /* maximum distance apart in chunks between spawn attempts */,
						5 /* minimum distance apart in chunks between spawn attempts */,
						314159265 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
				true);
		registerStructurePiece(WOLF_DEN_PIECE, new ResourceLocation(MythicCraft.MOD_ID, "wolf_den_piece"));


		// Configured Structures
		Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
		Registry.register(registry, new ResourceLocation(MythicCraft.MOD_ID, "configured_goblin_house"), CONFIGURED_GOBLIN_HOUSE);
		FlatGenerationSettings.STRUCTURE_FEATURES.put(GOBLIN_HOUSE, CONFIGURED_GOBLIN_HOUSE);

		Registry.register(registry, new ResourceLocation(MythicCraft.MOD_ID, "configured_wolf_den"), CONFIGURED_WOLF_DEN);
		FlatGenerationSettings.STRUCTURE_FEATURES.put(WOLF_DEN, CONFIGURED_WOLF_DEN);

	}




	@SubscribeEvent
	public void biomeModification(final BiomeLoadingEvent event) {
		// how to check for specific  biomes: if (event.getName().equals(BiomeInit.MISTICMEDDOWSBIOME.getId())){
		event.getGeneration().getStructures().add(() -> CONFIGURED_GOBLIN_HOUSE);
		event.getGeneration().getStructures().add(() -> CONFIGURED_WOLF_DEN);
	}

	@SubscribeEvent
	public void addDimensionalSpacing(final WorldEvent.Load event) {
		if(event.getWorld() instanceof ServerWorld){
			ServerWorld serverWorld = (ServerWorld)event.getWorld();

			// Prevent spawning our structure in Vanilla's superflat world as
			// people seem to want their superflat worlds free of modded structures.
			// Also that vanilla superflat is really tricky and buggy to work with in my experience.
			if(serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator &&
					serverWorld.dimension().equals(World.OVERWORLD)){
				return;
			}

			Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
			tempMap.put(GOBLIN_HOUSE, DimensionStructuresSettings.DEFAULTS.get(GOBLIN_HOUSE));
			serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
		}
	}

	// Util

	public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey) {
		entry.setRegistryName(new ResourceLocation(MythicCraft.MOD_ID, registryKey));
		registry.register(entry);
		return entry;
	}

	public static <F extends Structure<?>> void registerStructure(F structure, StructureSeparationSettings structureSeparationSettings, boolean transformSurroundingLand) {
		Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);

		if(transformSurroundingLand){
			Structure.NOISE_AFFECTING_FEATURES = ImmutableList.<Structure<?>>builder()
							.addAll(Structure.NOISE_AFFECTING_FEATURES)
							.add(structure)
							.build();
		}

		DimensionStructuresSettings.DEFAULTS = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
						.putAll(DimensionStructuresSettings.DEFAULTS)
						.put(structure, structureSeparationSettings)
						.build();
	}

	static void registerStructurePiece(IStructurePieceType structurePiece, ResourceLocation rl) {
		Registry.register(Registry.STRUCTURE_PIECE, rl, structurePiece);
	}
}
