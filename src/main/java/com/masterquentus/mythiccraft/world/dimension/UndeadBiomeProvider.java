package com.masterquentus.mythiccraft.world.dimension;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.masterquentus.mythiccraft.init.BiomeInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

public class UndeadBiomeProvider extends BiomeProvider {
	
	@SuppressWarnings("unused")
	private Random rand;

	public UndeadBiomeProvider() {
		super(biomeList);
		rand = new Random();
	}
	
	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.CRIMSON_FROST.get(), BiomeInit.CHARREDFORESTBIOME.get());

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return BiomeInit.CRIMSON_FROST.get();
	}

}
