package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.tileentity.ModSignTileEntity;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class ModWallSignBlock extends WallSignBlock {

	public ModWallSignBlock(Properties properties, WoodType type) {
		super(properties, type);
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new ModSignTileEntity();
	}

}
