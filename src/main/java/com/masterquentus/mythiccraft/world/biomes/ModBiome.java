package com.masterquentus.mythiccraft.world.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModBiome {
    public Biome create(Biome.Builder biome){
        return biome.generationSettings(this.getGenSettings().build()).mobSpawnSettings(this.getMobSpawns().build()).temperatureAdjustment(Biome.TemperatureModifier.NONE).specialEffects(this.getEffects()).build();
    }

    // TODO: use this to set the right water colors
    protected BiomeAmbience getEffects(){
        return new BiomeAmbience.Builder().waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.95F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build();
    }

    private static int calculateSkyColor(float p_244206_0_) {
        float lvt_1_1_ = p_244206_0_ / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
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
