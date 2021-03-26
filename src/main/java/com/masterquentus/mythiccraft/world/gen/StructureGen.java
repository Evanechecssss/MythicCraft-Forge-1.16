package com.masterquentus.mythiccraft.world.gen;

import com.masterquentus.mythiccraft.init.BiomeInit;
import com.masterquentus.mythiccraft.init.FeatureInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class StructureGen {

	public static void generateStructures() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome == BiomeInit.MISTICMEDDOWSBIOME.get()) {
				biome.addStructure(FeatureInit.GOBLINHOUSE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			}

			biome.addFeature(Decoration.SURFACE_STRUCTURES,
					FeatureInit.GOBLINHOUSE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
							.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
				
			}
		}
		
		public static void generateStructures1() {
			for (Biome biome : ForgeRegistries.BIOMES) {
				if (biome == BiomeInit.MISTICMEDDOWSBIOME.get()) {
					biome.addStructure(FeatureInit.WOLFDEN.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
				}

				biome.addFeature(Decoration.SURFACE_STRUCTURES,
						FeatureInit.WOLFDEN.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
								.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			}
	}
}