package com.masterquentus.mythiccraft.world.biomes;

import com.masterquentus.mythiccraft.init.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.TwoFeatureChoiceConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class MysiticMedowsBiome extends ModBiome {
	@Override
	protected MobSpawnInfo.Builder getMobSpawns() {
		MobSpawnInfo.Builder spawns = super.getMobSpawns();
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.RABBIT, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.COD, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SALMON, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PUFFERFISH, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.DONKEY, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.MOOSHROOM, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PANDA, 5, 4, 10));
		spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 5, 4, 10));
		return spawns;
	}

	@Override
	protected BiomeGenerationSettings.Builder getGenSettings() {
		BiomeGenerationSettings.Builder worldGenSettings = super.getGenSettings();
		worldGenSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_DEAD_BUSH_2);
		worldGenSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_FOREST);

		BlockInit.WOOD_TYPES.get("silverwood").tree.addToBiome(worldGenSettings);
		BlockInit.WOOD_TYPES.get("bloodoak").tree.addToBiome(worldGenSettings);

		DefaultBiomeFeatures.addGiantTaigaVegetation(worldGenSettings);
		DefaultBiomeFeatures.addTaigaTrees(worldGenSettings);
		DefaultBiomeFeatures.addSparseBerryBushes(worldGenSettings);DefaultBiomeFeatures.addForestFlowers(worldGenSettings);

		return worldGenSettings;
	}

	/* // todo: find modern equivilent. im too lazy to deal with it right now
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.SWEET_BERRY_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.BLUE_ORCHID_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.DEFAULT_FLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(3))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.PUMPKIN_PATCH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.MELON_PATCH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.LILY_PAD_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(7))));


	 */
	protected ConfiguredSurfaceBuilder<?> getSurface() {
		return SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderConfig(Blocks.GRASS.defaultBlockState(),
				BlockInit.mysticstone.get().defaultBlockState(), Blocks.CLAY.defaultBlockState()));
	}
}
