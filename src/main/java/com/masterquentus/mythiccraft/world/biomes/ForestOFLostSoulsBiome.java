package com.masterquentus.mythiccraft.world.biomes;

import com.masterquentus.mythiccraft.init.auto.WoodTypes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ForestOFLostSoulsBiome extends ModBiome {
	@Override
	protected ConfiguredSurfaceBuilder<?> getSurface() {
		return SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.defaultBlockState(),
				Blocks.STONE.defaultBlockState(), Blocks.CLAY.defaultBlockState()));
	}

	@Override
	protected BiomeGenerationSettings.Builder getGenSettings() {
		BiomeGenerationSettings.Builder worldGenSettings = super.getGenSettings();
		worldGenSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_DEAD_BUSH_2);
		worldGenSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_FOREST);

		WoodTypes.WITCHWOOD.tree.addToBiome(worldGenSettings);
		WoodTypes.WILLOW.tree.addToBiome(worldGenSettings);

		return worldGenSettings;
	}

	@Override
	protected MobSpawnInfo.Builder getMobSpawns() {
		MobSpawnInfo.Builder spawns = super.getMobSpawns();
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.RABBIT, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.POLAR_BEAR, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SKELETON, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.STRAY, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.VEX, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.EVOKER, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.VINDICATOR, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.WOLF, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 5, 4, 10));
		return spawns;
	}
}