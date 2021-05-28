package com.masterquentus.mythiccraft.world.biomes;

import com.masterquentus.mythiccraft.init.BlockInit;
import com.masterquentus.mythiccraft.init.auto.StoneType;
import com.masterquentus.mythiccraft.init.auto.WoodType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class CrimsonFrostBiome extends ModBiome {
	@Override
	protected BiomeGenerationSettings.Builder getGenSettings() {
		BiomeGenerationSettings.Builder worldGenSettings = super.getGenSettings();
		worldGenSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_DEAD_BUSH_2);
		worldGenSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_FOREST);

		WoodType.SILVERWOOD.tree.addToBiome(worldGenSettings);
		WoodType.BLOODOAK.tree.addToBiome(worldGenSettings);

		return worldGenSettings;
	}

	@Override
	protected ConfiguredSurfaceBuilder<?> getSurface() {
		// whats passed into .configured does nothing here. hange the apply method below instead
		// todo: have a blank config for clarity
		return new CrimsonFrostBiome.CrimsonFrostBiomeSurfaceBuilder().configured(new SurfaceBuilderConfig(BlockInit.CRIMSON_ICE.get().defaultBlockState(),
				BlockInit.CRIMSON_PACKEDICE.get().defaultBlockState(), StoneType.CRIMSON.blocks.get(StoneType.StoneVariation.STONE).get().defaultBlockState()));
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

	static class CrimsonFrostBiomeSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
		public CrimsonFrostBiomeSurfaceBuilder() {
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
						new SurfaceBuilderConfig(BlockInit.CRIMSON_ICE.get().defaultBlockState(),
								BlockInit.CRIMSON_PACKEDICE.get().defaultBlockState(),
								StoneType.CRIMSON.blocks.get(StoneType.StoneVariation.STONE).get().defaultBlockState()));
			} else {
				SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
						defaultFluid, seaLevel, seed,
						new SurfaceBuilderConfig(
								i == 1 ? BlockInit.CRIMSON_PACKEDICE.get().defaultBlockState()
										: StoneType.CRIMSON.blocks.get(StoneType.StoneVariation.STONE).get().defaultBlockState(),
								StoneType.CRIMSON.blocks.get(StoneType.StoneVariation.STONE).get().defaultBlockState(), Blocks.GRAVEL.defaultBlockState()));
			}
		}

	}
}
