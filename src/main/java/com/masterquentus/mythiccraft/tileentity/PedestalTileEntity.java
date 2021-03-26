package com.masterquentus.mythiccraft.tileentity;

import com.masterquentus.mythiccraft.objects.blocks.ModTileEntityTypes;

import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class PedestalTileEntity extends TileEntity {
	
	
	
	public PedestalTileEntity(final TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
	
	public PedestalTileEntity() {
		this(ModTileEntityTypes.pedestal_tier1.get());
	}
	
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).isSolid();
	}

}