package com.masterquentus.mythiccraft.objects.blocks;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class EmberMossBlock extends GrassBlock implements IGrowable {

	public EmberMossBlock(Properties p_i48303_1_) {
		super(p_i48303_1_);
	}

	@Override
	public boolean isValidBonemealTarget(IBlockReader p_176473_1_, BlockPos p_176473_2_, BlockState p_176473_3_,
			boolean p_176473_4_) {
		return false;
	}

	@Override
	public boolean isBonemealSuccess(World p_180670_1_, Random p_180670_2_, BlockPos p_180670_3_,
			BlockState p_180670_4_) {
		return false;
	}

	@Override
	public void performBonemeal(ServerWorld p_225535_1_, Random p_225535_2_, BlockPos p_225535_3_,
			BlockState p_225535_4_) {

	}
	
	public void entityInside(BlockState state, World p_196262_2_, BlockPos pos, Entity p_196262_4_) {
		p_196262_4_.hurt(DamageSource.IN_FIRE, 1.0F);
	}

	@Override
    public void stepOn(World worldIn, BlockPos pos, Entity entityIn) {
        HellFireBlock.lightEntityOnFire(entityIn, 5);
        super.stepOn(worldIn, pos, entityIn);
    }
	
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		entityIn.setSecondsOnFire(10);
	}

	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		float chance = 0.35f;
		if (chance < rand.nextFloat()) {
			worldIn.addParticle(ParticleTypes.FLAME, pos.getX() + rand.nextDouble(), pos.getY() + 0.3D,
					pos.getZ() + rand.nextDouble(), 0d, 0.05d, 0d);
		}
		super.animateTick(stateIn, worldIn, pos, rand);
	}

}
