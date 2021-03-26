package com.masterquentus.mythiccraft.world.biomes;

import com.masterquentus.mythiccraft.world.feature.BloodOakTree;
import com.masterquentus.mythiccraft.world.feature.WhiteOakTree;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class VampireBiome extends Biome {

	public VampireBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.ZOMBIE, 5, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SKELETON, 5, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SKELETON_HORSE, 5, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.ZOMBIE_HORSE, 5, 4, 10));
		this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285515F)));
		this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.02F)));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.SWEET_BERRY_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(WhiteOakTree.WHITEOAK_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.02F, 0))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(BloodOakTree.BLOODOAK_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 3))));
		
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addDeadBushes(this);
		DefaultBiomeFeatures.addDenseGrass(this);
		DefaultBiomeFeatures.addForestTrees(this);
		DefaultBiomeFeatures.addBerryBushes(this);
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addInfestedStone(this);
		DefaultBiomeFeatures.addReedsAndPumpkins(this);
		
		
	}
}
