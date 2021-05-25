package com.masterquentus.mythiccraft.world.feature.structures;


import com.masterquentus.mythiccraft.MythicCraft;

import com.mojang.serialization.Codec;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class GoblinHouseStructure extends Structure<NoFeatureConfig> {

	public GoblinHouseStructure(Codec<NoFeatureConfig> codec) {
		super(codec);
	}

	/*
	@Override
	public boolean canBeGenerated(BiomeManager manager, ChunkGenerator<?> generator, Random rand, int chunkX, int chunkZ, Biome biome) {
		ChunkPos pos = this.getStartPositionForPosition(generator, rand, chunkX, chunkZ, 0, 0);

		if (chunkX == pos.x && chunkZ == pos.z) {
			if (generator.hasStructure(biome, this)) {
				return true;
			}
		}

		return false;
	}

	 */

	@Override
	public GenerationStage.Decoration step() {
		return GenerationStage.Decoration.SURFACE_STRUCTURES;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public IStartFactory getStartFactory() {
		return GoblinHouseStructure.Start::new;
	}

	/*
	@Override
	protected ChunkPos getStartPositionForPosition(ChunkGenerator generator, Random rand, int x, int z, int offsetX,
			int offsetZ) {
		int maxDistance = 10;
		int minDistance = 3;

		int xTemp = x + maxDistance * offsetX;
		int ztemp = z + maxDistance * offsetZ;
		int xTemp2 = xTemp < 0 ? xTemp - maxDistance + 1 : xTemp;
		int zTemp2 = ztemp < 0 ? ztemp - maxDistance + 1 : ztemp;
		int validChunkX = xTemp2 / maxDistance;
		int validChunkZ = zTemp2 / maxDistance;

		((SharedSeedRandom) rand).setLargeFeatureWithSalt(generator., validChunkX, validChunkZ, this.getSeedModifier());
		validChunkX = validChunkX * maxDistance;
		validChunkZ = validChunkZ * maxDistance;
		validChunkX = validChunkX + rand.nextInt(maxDistance - minDistance);
		validChunkZ = validChunkZ + rand.nextInt(maxDistance - minDistance);

		return new ChunkPos(validChunkX, validChunkZ);
	}

	 */

	@SuppressWarnings("rawtypes")
	public static class Start extends StructureStart {

		@SuppressWarnings("unchecked")
		public Start(Structure<?> structure, int chunkX, int chunkZ, MutableBoundingBox boundingBox, int reference, long seed) {
			super(structure, chunkX, chunkZ, boundingBox, reference, seed);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void generatePieces(DynamicRegistries p_230364_1_, ChunkGenerator generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome p_230364_6_, IFeatureConfig p_230364_7_) {
			Rotation rotation = Rotation.values()[this.random.nextInt(Rotation.values().length)];

			int x = (chunkX << 4) + 7;
			int z = (chunkZ << 4) + 7;
			int y = generator.getBaseHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG);
			BlockPos pos = new BlockPos(x, y, z);

			GoblinHousePieces.start(templateManagerIn, pos, rotation, this.pieces, this.random);

			this.calculateBoundingBox();

			MythicCraft.LOGGER.info("We can find a house at: " + pos);
		}
	}
}