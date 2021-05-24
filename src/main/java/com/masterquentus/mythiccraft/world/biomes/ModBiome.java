package com.masterquentus.mythiccraft.world.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModBiome {
    public Biome create(Biome.Builder biome){
        return biome.generationSettings(getGenSettings().build()).mobSpawnSettings(getMobSpawns().build()).build();
    }

    protected BiomeGenerationSettings.Builder getGenSettings() {
        BiomeGenerationSettings.Builder worldGenSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(getSurface());
        DefaultBiomeFeatures.addDefaultOres(worldGenSettings);
        DefaultBiomeFeatures.addInfestedStone(worldGenSettings);
        DefaultBiomeFeatures.addDefaultCarvers(worldGenSettings);
        return worldGenSettings;
    }

    protected ConfiguredSurfaceBuilder<?> getSurface() {
        return SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.defaultBlockState(),
                Blocks.STONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState()));
    }

    protected MobSpawnInfo.Builder getMobSpawns() {
        return new MobSpawnInfo.Builder();
    }
}
