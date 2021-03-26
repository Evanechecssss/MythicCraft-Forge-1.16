package com.masterquentus.mythiccraft.world.gen;

import com.masterquentus.mythiccraft.init.BlockInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class MythicCraftOreGen {
	@SuppressWarnings("rawtypes")
	public static void generateOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(9, 23, 5, 25));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
							BlockInit.VAMPIRIC_ORE.get().getDefaultState(), 4)).withPlacement(customConfig));
			ConfiguredPlacement customConfig1 = Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 23, 5, 25));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
									BlockInit.VAMPIRIC_NETHERORE.get().getDefaultState(), 4))
							.withPlacement(customConfig1));
			ConfiguredPlacement customConfig2 = Placement.COUNT_RANGE.configure(new CountRangeConfig(9, 23, 3, 25));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
							BlockInit.MOONSTONE_ORE.get().getDefaultState(), 3)).withPlacement(customConfig2));
			ConfiguredPlacement customConfig3 = Placement.COUNT_RANGE.configure(new CountRangeConfig(9, 23, 3, 25));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
									BlockInit.MOONSTONE_NETHERORE.get().getDefaultState(), 3))
							.withPlacement(customConfig3));
			ConfiguredPlacement customConfig4 = Placement.COUNT_RANGE.configure(new CountRangeConfig(9, 23, 3, 25));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
							BlockInit.SILVER_ORE.get().getDefaultState(), 3)).withPlacement(customConfig4));
			ConfiguredPlacement customConfig5 = Placement.COUNT_RANGE.configure(new CountRangeConfig(5, 1, 3, 12));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
									BlockInit.SILVER_NETHERORE.get().getDefaultState(), 3))
							.withPlacement(customConfig5));
			ConfiguredPlacement customConfig6 = Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 1, 5, 12));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
									BlockInit.MYTHICDIAMOND_ORE.get().getDefaultState(), 4))
							.withPlacement(customConfig6));
			ConfiguredPlacement customConfig7 = Placement.COUNT_RANGE.configure(new CountRangeConfig(12, 1, 2, 3));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
									BlockInit.MYTHICDIAMOND_NETHERORE.get().getDefaultState(), 4))
							.withPlacement(customConfig7));
			ConfiguredPlacement customConfig8 = Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 8, 3, 12));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
									BlockInit.DRAGONHEART_ORE.get().getDefaultState(), 4))
							.withPlacement(customConfig8));
			ConfiguredPlacement customConfig9 = Placement.COUNT_RANGE.configure(new CountRangeConfig(12, 13, 3, 12));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
									BlockInit.DRAGONHEART_NETHERORE.get().getDefaultState(), 4))
							.withPlacement(customConfig9));
			@SuppressWarnings("unused")
			ConfiguredPlacement customConfig10 = Placement.COUNT_RANGE.configure(new CountRangeConfig(9, 23, 5, 25));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
							BlockInit.RUBY_ORE.get().getDefaultState(), 4)).withPlacement(customConfig));
			@SuppressWarnings("unused")
			ConfiguredPlacement customConfig11 = Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 23, 5, 25));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
									BlockInit.RUBY_NETHERORE.get().getDefaultState(), 4))
							.withPlacement(customConfig1));
			@SuppressWarnings("unused")
			ConfiguredPlacement customConfig12 = Placement.COUNT_RANGE.configure(new CountRangeConfig(9, 23, 5, 25));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
							BlockInit.SAPPHIRE_ORE.get().getDefaultState(), 4)).withPlacement(customConfig));
			@SuppressWarnings("unused")
			ConfiguredPlacement customConfig13 = Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 23, 5, 25));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
									BlockInit.SAPPHIRE_NETHERORE.get().getDefaultState(), 4))
							.withPlacement(customConfig1));
			@SuppressWarnings("unused")
			ConfiguredPlacement customConfig14 = Placement.COUNT_RANGE.configure(new CountRangeConfig(9, 23, 5, 25));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
							BlockInit.AMETHYST_ORE.get().getDefaultState(), 4)).withPlacement(customConfig));
			@SuppressWarnings("unused")
			ConfiguredPlacement customConfig15 = Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 23, 5, 25));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
									BlockInit.AMETHYST_NETHERORE.get().getDefaultState(), 4))
							.withPlacement(customConfig1));

		}
	}
}
