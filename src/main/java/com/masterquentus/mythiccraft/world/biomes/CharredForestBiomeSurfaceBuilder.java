package com.masterquentus.mythiccraft.world.biomes;

import java.util.Random;
import java.util.function.Function;

import com.masterquentus.mythiccraft.init.BlockInit;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class CharredForestBiomeSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public CharredForestBiomeSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> function) {
		super(function);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		Random rd = new Random();
		int i = rd.nextInt(3);
		if (i == 0) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(BlockInit.CHARRED_SOIL.get().getDefaultState(),
							BlockInit.charred_stone.get().getDefaultState(),
							BlockInit.ASH_BLOCK.get().getDefaultState()));
		} else {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(
							i == 1 ? BlockInit.HOTASH_BLOCK.get().getDefaultState()
									: BlockInit.ASH_BLOCK.get().getDefaultState(),
							BlockInit.charred_cobble.get().getDefaultState(), Blocks.GRAVEL.getDefaultState()));
		}

		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
				defaultFluid, seaLevel, seed,
				new SurfaceBuilderConfig(
						i == 1 ? BlockInit.ASH_BLOCK.get().getDefaultState()
								: BlockInit.charred_cobble.get().getDefaultState(),
						BlockInit.charred_stone.get().getDefaultState(), Blocks.GRAVEL.getDefaultState()));
	}

}