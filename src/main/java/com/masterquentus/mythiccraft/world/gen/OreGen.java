package com.masterquentus.mythiccraft.world.gen;

import com.masterquentus.mythiccraft.init.auto.OreType;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGen {
    public static final RuleTest ENDSTONE = new BlockMatchRuleTest(Blocks.END_STONE);

    public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
        // im not checking the biome because stone/netherack/endstone only exist in thier respective dimension. This means the ores will also spawn in modded dimensions based on those blocks.
        // the overworld and nether use the same height range but end ore spawns everywhere in endstone because height doesnt mean much to the void islands
        for (OreType ore : OreType.values()){
            addOreToBiome(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, ore.overworld.get(), ore.maxHeight, ore.minHeight, ore.veinSize, ore.veinsPerChunk);
            addOreToBiome(event.getGeneration(), OreFeatureConfig.FillerBlockType.NETHERRACK, ore.nether.get(), ore.maxHeight, ore.minHeight, ore.veinSize, ore.veinsPerChunk);
            addOreToBiome(event.getGeneration(), ENDSTONE, ore.end.get(), 256, 0, ore.veinSize, ore.veinsPerChunk);
        }
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
