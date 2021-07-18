package com.masterquentus.mythiccraft.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;

public class GrassperBlock extends Block{

	public GrassperBlock(Properties p_i48440_1_) {
		super(p_i48440_1_);
	}
	
	@Override
	public BlockRenderType getRenderShape(BlockState iBlockState) {
		return BlockRenderType.MODEL;
	}

}
