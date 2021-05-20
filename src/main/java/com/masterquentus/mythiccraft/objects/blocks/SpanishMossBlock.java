package com.masterquentus.mythiccraft.objects.blocks;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.block.VineBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class SpanishMossBlock extends VineBlock implements IGrowable {

	public SpanishMossBlock(Properties properties) {
		super(properties);
	}

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
	      return false;
	}

	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		
	}

}
