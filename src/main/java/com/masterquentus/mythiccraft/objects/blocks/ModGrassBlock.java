package com.masterquentus.mythiccraft.objects.blocks;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModGrassBlock extends GrassBlock {

	public ModGrassBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

}
