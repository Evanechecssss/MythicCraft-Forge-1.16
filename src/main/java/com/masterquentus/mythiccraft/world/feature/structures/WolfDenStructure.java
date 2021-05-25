package com.masterquentus.mythiccraft.world.feature.structures;


import com.masterquentus.mythiccraft.MythicCraft;

import com.mojang.serialization.Codec;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class WolfDenStructure extends Structure<NoFeatureConfig> {

	public WolfDenStructure(Codec<NoFeatureConfig> codec) {
		super(codec);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public IStartFactory getStartFactory() {
		return WolfDenStructure.Start::new;
	}


	@SuppressWarnings("rawtypes")
	public static class Start extends StructureStart {

		@SuppressWarnings("unchecked")
		public Start(Structure<?> structure, int chunkX, int chunkZ, MutableBoundingBox boundingBox, int reference,
				long seed) {
			super(structure, chunkX, chunkZ, boundingBox, reference, seed);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void generatePieces(DynamicRegistries dynamicRegistryManager, ChunkGenerator generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, IFeatureConfig config) {
			Rotation rotation = Rotation.values()[this.random.nextInt(Rotation.values().length)];

			int x = (chunkX << 4) + 7;
			int z = (chunkZ << 4) + 7;
			int y = generator.getBaseHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG);
			BlockPos pos = new BlockPos(x, y, z);

			GoblinHousePieces.start(templateManagerIn, pos, rotation, this.pieces, this.random);

			this.calculateBoundingBox();

			MythicCraft.LOGGER.info("We can find a wolf den at: " + pos);
		}
	}
}