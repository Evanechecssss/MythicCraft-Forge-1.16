package com.masterquentus.mythiccraft.world.gen;

// Working ore generation in forge 1.16.3!
// To get this to work, add this to the constructor of your mod's main class:
// MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGen::addFeaturesToBiomes).

import com.masterquentus.mythiccraft.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGen {
    public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
        addOreToBiome(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.VAMPIRIC_ORE.get(), 25, 23, 4, 9);
        addOreToBiome(event.getGeneration(), OreFeatureConfig.FillerBlockType.NETHERRACK, BlockInit.VAMPIRIC_NETHERORE.get(), 25, 23, 4, 9);
        addOreToBiome(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.MOONSTONE_ORE.get(), 25, 23, 4, 9);
        addOreToBiome(event.getGeneration(), OreFeatureConfig.FillerBlockType.NETHERRACK, BlockInit.MOONSTONE_NETHERORE.get(), 25, 23, 4, 9);
        addOreToBiome(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.SILVER_ORE.get(), 25, 23, 4, 9);
        addOreToBiome(event.getGeneration(), OreFeatureConfig.FillerBlockType.NETHERRACK, BlockInit.SILVER_NETHERORE.get(), 25, 23, 4, 9);
        addOreToBiome(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.MYTHICDIAMOND_ORE.get(), 12, 1, 4, 20);
        addOreToBiome(event.getGeneration(), OreFeatureConfig.FillerBlockType.NETHERRACK, BlockInit.MYTHICDIAMOND_NETHERORE.get(), 12, 1, 4, 20);

        // TODO: also do DRAGONHEART_ORE, RUBY_ORE, SAPPHIRE_ORE, AMETHYST_ORE and nether varients
    }



    private static void addOreToBiome(BiomeGenerationSettingsBuilder biomeGenSettings, RuleTest fillertype, Block oreBlock, int maxHeight, int minHeight, int veinSize, int veinsPerChunk){
        ConfiguredFeature<?, ?> feature = Feature.ORE.configured(
                new OreFeatureConfig(
                        fillertype,
                        oreBlock.defaultBlockState(),
                        veinSize))
                .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight))).count(veinsPerChunk);

        biomeGenSettings.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> feature);
    }
}
