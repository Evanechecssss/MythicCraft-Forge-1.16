package com.masterquentus.mythiccraft.world.biomes;


import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class DragonBiome extends Biome {

	public DragonBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.ZOMBIE, 5, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SKELETON, 5, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SKELETON_HORSE, 5, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.ZOMBIE_HORSE, 5, 4, 10));
		this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285515F)));
		this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.02F)));
		
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addDeadBushes(this);
		DefaultBiomeFeatures.addDenseGrass(this);
		DefaultBiomeFeatures.addInfestedStone(this);
		DefaultBiomeFeatures.addCarvers(this);
		
	}
}
