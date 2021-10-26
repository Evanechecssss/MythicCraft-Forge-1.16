package com.masterquentus.mythiccraft.objects.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GlowingScorchedGrassBlock extends GrassBlock {

	public GlowingScorchedGrassBlock(Properties p_i48388_1_) {
		super(p_i48388_1_);
	}
	
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		entityIn.setSecondsOnFire(10);

	}
	
	public void entityInside(BlockState state, World p_196262_2_, BlockPos pos, Entity p_196262_4_) {
	      p_196262_4_.hurt(DamageSource.IN_FIRE, 1.0F);
	}

}
