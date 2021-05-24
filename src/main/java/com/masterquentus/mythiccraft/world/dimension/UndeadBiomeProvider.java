package com.masterquentus.mythiccraft.world.dimension;

import java.util.*;

import com.google.common.collect.ImmutableSet;
import com.masterquentus.mythiccraft.init.BiomeInit;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.EndBiomeProvider;

public class UndeadBiomeProvider extends BiomeProvider {

	private final long seed;
	private final Registry<Biome> registry;

	public UndeadBiomeProvider(long seed, Registry<Biome> registry) {
		super(biomeList);
		this.seed = seed;
		this.registry = registry;
	}
	
	private static final List<Biome> biomeList = new ArrayList<>();
	static {
		biomeList.add(BiomeInit.CRIMSON_FROST.get());
		biomeList.add(BiomeInit.CHARREDFORESTBIOME.get());
	}

	public static final Codec<UndeadBiomeProvider> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
			Codec.LONG.fieldOf("seed").stable().orElseGet(() -> 0L).forGetter((obj) -> obj.seed),
			RegistryLookupCodec.create(Registry.BIOME_REGISTRY).forGetter(provider -> provider.registry)
	).apply(instance, instance.stable(UndeadBiomeProvider::new)));

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return BiomeInit.CRIMSON_FROST.get();
	}



	@Override
	protected Codec<? extends BiomeProvider> codec() {
		return CODEC;
	}

	@Override
	public BiomeProvider withSeed(long p_230320_1_) {
		return new UndeadBiomeProvider(p_230320_1_, this.registry);
	}

}
