package com.masterquentus.mythiccraft.world.feature.structures;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.masterquentus.mythiccraft.MythicCraft;

import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.google.common.collect.ImmutableMap;

public class StructuresInit {
	public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister
			.create(ForgeRegistries.STRUCTURE_FEATURES, MythicCraft.MOD_ID);

	public static final RegistryObject<Structure<NoFeatureConfig>> GOBLIN_HUT = STRUCTURES.register("goblin_hut",
			GoblinHutStructure::new);

	public static void setupStructures() {
		setupMapSpacingAndLand(GOBLIN_HUT.get(), new StructureSeparationSettings(10, 5, 1234567890), true);

	}

	public static <F extends Structure<?>> void setupMapSpacingAndLand(F structure,
			StructureSeparationSettings structureSeparationSettings, boolean transformSurroundingLand) {

		Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);

		if (transformSurroundingLand) {
			Structure.NOISE_AFFECTING_FEATURES = ImmutableList.<Structure<?>>builder()
					.addAll(Structure.NOISE_AFFECTING_FEATURES).add(structure).build();
		}

		DimensionStructuresSettings.DEFAULTS = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
				.putAll(DimensionStructuresSettings.DEFAULTS).put(structure, structureSeparationSettings).build();

		WorldGenRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
			Map<Structure<?>, StructureSeparationSettings> structureMap = settings.getValue().structureSettings()
					.structureConfig();

			if (structureMap instanceof ImmutableMap) {
				Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
				tempMap.put(structure, structureSeparationSettings);
				settings.getValue().structureSettings().structureConfig = tempMap;

			} else {
				structureMap.put(structure, structureSeparationSettings);
			}

		});

	}

	public static void register(IEventBus eventbus) {
		STRUCTURES.register(eventbus);

	}
}
