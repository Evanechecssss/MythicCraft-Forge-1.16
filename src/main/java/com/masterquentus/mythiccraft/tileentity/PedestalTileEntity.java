package com.masterquentus.mythiccraft.tileentity;

import com.masterquentus.mythiccraft.init.ModTileEntityTypes;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class PedestalTileEntity extends TileEntity {
	public PedestalTileEntity(final TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
	
	public PedestalTileEntity() {
		this(ModTileEntityTypes.pedestal_tier1.get());
	}

	/*
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.below()).canOcclude();
	}
	 */
}