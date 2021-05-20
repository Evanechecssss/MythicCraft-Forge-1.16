package com.masterquentus.mythiccraft.tileentity;

import com.masterquentus.mythiccraft.init.ModTileEntityTypes;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class PandorsBoxTileEntity extends TileEntity {
	public PandorsBoxTileEntity(final TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public PandorsBoxTileEntity() {
		this(ModTileEntityTypes.pandors_box.get());
	}

	/*
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.below()).canOcclude();
	}
	 */
}
