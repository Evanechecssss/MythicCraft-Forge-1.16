package com.masterquentus.mythiccraft.objects.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class GlowingScorchedGrassBlock extends GrassBlock {

	public GlowingScorchedGrassBlock(Properties p_i48388_1_) {
		super(p_i48388_1_);
	}
	
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		entityIn.setSecondsOnFire(10);

	}
	
	@Override
	public void catchFire(BlockState state, World world, BlockPos pos, Direction face, LivingEntity igniter) {
		super.catchFire(state, world, pos, face, igniter);
	}
	
	@Override
	public boolean isFireSource(BlockState state, IWorldReader world, BlockPos pos, Direction side) {
		return super.isFireSource(state, world, pos, side);
	}

}
