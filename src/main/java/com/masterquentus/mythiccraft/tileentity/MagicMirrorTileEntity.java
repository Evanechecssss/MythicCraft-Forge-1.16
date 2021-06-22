package com.masterquentus.mythiccraft.tileentity;

import com.masterquentus.mythiccraft.init.ModTileEntityTypes;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class MagicMirrorTileEntity extends TileEntity {
	public MagicMirrorTileEntity(final TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public MagicMirrorTileEntity() {
		this(ModTileEntityTypes.MAGIC_MIRROR.get());
	}

}