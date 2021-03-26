package com.masterquentus.mythiccraft.tileentity;

import com.masterquentus.mythiccraft.objects.blocks.ModTileEntityTypes;

import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class PandorsBoxTileEntity extends TileEntity {
	
	
	
	public PandorsBoxTileEntity(final TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
	
	public PandorsBoxTileEntity() {
		this(ModTileEntityTypes.pandors_box.get());
	}
	
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).isSolid();
	}

}
