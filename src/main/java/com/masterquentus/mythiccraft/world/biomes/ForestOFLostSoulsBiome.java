package com.masterquentus.mythiccraft.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

public class ForestOFLostSoulsBiome extends Biome {
	
	public ForestOFLostSoulsBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.RABBIT, 5, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.POLAR_BEAR, 5, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SKELETON, 5, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.STRAY, 5, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.VEX, 5, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.EVOKER, 5, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.VINDICATOR, 5, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 2, 2, 3));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 5, 4, 10));
		this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285515F)));
		this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.02F)));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(WitchWoodTree.WITCHWOOD_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.02F, 0))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(WillowTree.WILLOW_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 3))));
		
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addDeadBushes(this);
		DefaultBiomeFeatures.addDenseGrass(this);
		DefaultBiomeFeatures.addInfestedStone(this);
		
	}
}