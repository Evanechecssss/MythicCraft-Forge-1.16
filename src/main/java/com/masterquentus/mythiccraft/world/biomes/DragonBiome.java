package com.masterquentus.mythiccraft.world.biomes;


import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.eventbus.api.BusBuilder;
import net.minecraftforge.fml.RegistryObject;

public class DragonBiome extends ModBiome{
	protected BiomeGenerationSettings.Builder getGenSettings() {
		BiomeGenerationSettings.Builder worldGenSettings = super.getGenSettings();
		worldGenSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_DEAD_BUSH_2);
		worldGenSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_FOREST);

		return worldGenSettings;
	}

	protected ConfiguredSurfaceBuilder<?> getSurface() {
		return SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.defaultBlockState(),
				Blocks.STONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState()));
	}

	protected MobSpawnInfo.Builder getMobSpawns() {
		MobSpawnInfo.Builder spawns = super.getMobSpawns();
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SKELETON, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SKELETON_HORSE, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_HORSE, 5, 4, 10));
		return spawns;
	}
}
