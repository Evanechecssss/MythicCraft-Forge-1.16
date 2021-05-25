package com.masterquentus.mythiccraft.world.biomes;

import com.masterquentus.mythiccraft.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class VampireBiome extends ModBiome {
	protected MobSpawnInfo.Builder getMobSpawns() {
		MobSpawnInfo.Builder spawns = super.getMobSpawns();
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SKELETON, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SKELETON_HORSE, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_HORSE, 5, 4, 10));
		return spawns;
	}

	@Override
	protected BiomeGenerationSettings.Builder getGenSettings() {
		BiomeGenerationSettings.Builder worldGenSettings = super.getGenSettings();
		worldGenSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_DEAD_BUSH_2);
		worldGenSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_FOREST);

		BlockInit.WOOD_TYPES.get("bloodoak").tree.addToBiome(worldGenSettings);
		BlockInit.WOOD_TYPES.get("whiteoak").tree.addToBiome(worldGenSettings);

		worldGenSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FOREST_FLOWER_TREES);
		DefaultBiomeFeatures.addDefaultExtraVegetation(worldGenSettings);  // sugarcane + pumpkin
		worldGenSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_BERRY_DECORATED);

		return worldGenSettings;
	}

	@Override
	protected ConfiguredSurfaceBuilder<?> getSurface() {
		// whats passed into .configured does nothing here. hange the apply method below instead
		// todo: have a blank config for clarity
		return new VampireBiome.VampireBiomeSurfaceBuilder().configured(new SurfaceBuilderConfig(BlockInit.ASH_BLOCK.get().defaultBlockState(),
				Blocks.STONE.defaultBlockState(), Blocks.CLAY.defaultBlockState()));
	}

	static class VampireBiomeSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
		public VampireBiomeSurfaceBuilder() {
			super(SurfaceBuilderConfig.CODEC);
		}

		@Override
		public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
								 BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
			Random rd = new Random();
			int i = rd.nextInt(3);
			if (i == 0) {
				SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
						defaultFluid, seaLevel, seed,
						new SurfaceBuilderConfig(BlockInit.ASH_BLOCK.get().defaultBlockState(),
								Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState()));
			} else {
				SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
						defaultFluid, seaLevel, seed,
						new SurfaceBuilderConfig(
								i == 1 ? Blocks.GRASS_BLOCK.defaultBlockState()
										: BlockInit.ASH_BLOCK.get().defaultBlockState(),
								Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState()));
			}
		}
	}
}
