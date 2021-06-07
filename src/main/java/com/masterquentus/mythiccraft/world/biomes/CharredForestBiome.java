package com.masterquentus.mythiccraft.world.biomes;

import com.masterquentus.mythiccraft.init.BlockInit;
import com.masterquentus.mythiccraft.init.auto.StoneType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import com.masterquentus.mythiccraft.init.auto.WoodTypes;

import java.util.Random;

public class CharredForestBiome extends DragonBiome {
	@Override
	protected BiomeGenerationSettings.Builder getGenSettings() {
		BiomeGenerationSettings.Builder worldGenSettings = super.getGenSettings();
		WoodTypes.CHARRED.tree.addToBiome(worldGenSettings);
		return worldGenSettings;
	}

	@Override
	protected ConfiguredSurfaceBuilder<?> getSurface() {
		// whats passed into .configured does nothing here. hange the apply method below instead
		// todo: have a blank config for clarity
		return new CharredForestBiomeSurfaceBuilder().configured(new SurfaceBuilderConfig(BlockInit.ASH_BLOCK.get().defaultBlockState(),
				Blocks.STONE.defaultBlockState(), Blocks.CLAY.defaultBlockState()));
	}

	static class CharredForestBiomeSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
		public CharredForestBiomeSurfaceBuilder() {
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
						new SurfaceBuilderConfig(BlockInit.CHARRED_SOIL.get().defaultBlockState(),
								StoneType.CHARRED.blocks.get(StoneType.StoneVariation.STONE).get().defaultBlockState(),
								BlockInit.ASH_BLOCK.get().defaultBlockState()));
				
			} else {
				SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
						defaultFluid, seaLevel, seed,
						new SurfaceBuilderConfig(
								i == 1 ? BlockInit.HOTASH_BLOCK.get().defaultBlockState()
										: BlockInit.ASH_BLOCK.get().defaultBlockState(),
								StoneType.CHARRED.blocks.get(StoneType.StoneVariation.COBBLE).get().defaultBlockState(), Blocks.GRAVEL.defaultBlockState()));
			}

			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(
							i == 1 ? BlockInit.ASH_BLOCK.get().defaultBlockState()
									: StoneType.CHARRED.blocks.get(StoneType.StoneVariation.COBBLE).get().defaultBlockState(),
							StoneType.CHARRED.blocks.get(StoneType.StoneVariation.STONE).get().defaultBlockState(), Blocks.GRAVEL.defaultBlockState()));
		}

	}
}
