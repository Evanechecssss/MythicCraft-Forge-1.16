package com.masterquentus.mythiccraft.world.feature.structures;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.common.collect.ImmutableMap;
import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.init.FeatureInit;

import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class WolfDenPieces {

private static final ResourceLocation Part_1 = new ResourceLocation(MythicCraft.MOD_ID, "wolf_den");
	
	private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.of(Part_1, new BlockPos(0, 1, 0));
	
	public static void start(TemplateManager manager, BlockPos pos, Rotation rot, List<StructurePiece> pieces, Random rand) {
		int x = pos.getX();
		int z = pos.getZ();

		BlockPos rotationOffset = new BlockPos(0, 0, 0).rotate(rot);
		BlockPos blockpos = rotationOffset.offset(x, pos.getY(), z);
		pieces.add(new GoblinHousePieces.Piece(manager, Part_1, blockpos, rot));
	}
	
	public static class Piece extends TemplateStructurePiece {
		private ResourceLocation resourceLocation;
		private Rotation rotation;

		public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos,
				Rotation rotationIn) {
			super(FeatureInit.WOLF_DEN_PIECE, 0);
			this.resourceLocation = resourceLocationIn;
			BlockPos blockpos = WolfDenPieces.OFFSET.get(resourceLocation);
			this.templatePosition = pos.offset(blockpos.getX(), blockpos.getY(), blockpos.getZ());
			this.rotation = rotationIn;
			this.setupPiece(templateManagerIn);
		}

		public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
			super(FeatureInit.WOLF_DEN_PIECE, tagCompound);
			this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
			this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
			this.setupPiece(templateManagerIn);
		}

		private void setupPiece(TemplateManager templateManager) {
			Template template = templateManager.getOrCreate(this.resourceLocation);
			PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation)
					.setMirror(Mirror.NONE);
			this.setup(template, this.templatePosition, placementsettings);
		}

		@Override
		protected void addAdditionalSaveData(CompoundNBT tagCompound) {
			super.addAdditionalSaveData(tagCompound);
			tagCompound.putString("Template", this.resourceLocation.toString());
			tagCompound.putString("Rot", this.rotation.name());
		}

		@Override
		protected void handleDataMarker(String function, BlockPos pos, IServerWorld worldIn, Random rand, MutableBoundingBox sbb) {
			if ("chest".equals(function)) {
				worldIn.setBlock(pos, Blocks.CHEST.defaultBlockState(), 2);
				TileEntity tileentity = worldIn.getBlockEntity(pos);
				if (tileentity instanceof ChestTileEntity) {
					// could set loot table here
				}
			}
		}

		@Override
		public boolean postProcess(ISeedReader seedRead, StructureManager p_230383_2, ChunkGenerator chunkGeneratorIn, Random randomIn, MutableBoundingBox mutableBoundingBoxIn, ChunkPos chunkPosIn, BlockPos p_230383_7_) {
			PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE);
			BlockPos blockpos = WolfDenPieces.OFFSET.get(this.resourceLocation);
			this.templatePosition.offset(Template.calculateRelativePosition(placementsettings, new BlockPos(0 - blockpos.getX(), 0, 0 - blockpos.getZ())));
			return super.postProcess(seedRead, p_230383_2, chunkGeneratorIn, randomIn, mutableBoundingBoxIn, chunkPosIn, p_230383_7_);
		}
	}
}