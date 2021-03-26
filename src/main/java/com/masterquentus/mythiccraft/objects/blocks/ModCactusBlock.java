package com.masterquentus.mythiccraft.objects.blocks;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.CactusBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ModCactusBlock extends CactusBlock implements IGrowable {

	public ModCactusBlock(Properties properties) {
		super(properties);
	
	}

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		
	}
	
	@Override
	public boolean collisionExtendsVertically(BlockState state, IBlockReader world, BlockPos pos,
			Entity collidingEntity) {
		return super.collisionExtendsVertically(state, world, pos, collidingEntity);
	}

}
