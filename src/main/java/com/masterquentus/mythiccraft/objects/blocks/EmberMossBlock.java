package com.masterquentus.mythiccraft.objects.blocks;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.VineBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class EmberMossBlock extends FireBlock implements IGrowable {

	public EmberMossBlock(Properties p_i48303_1_) {
		super(p_i48303_1_);
	}

	@Override
	public boolean isValidBonemealTarget(IBlockReader p_176473_1_, BlockPos p_176473_2_, BlockState p_176473_3_,
			boolean p_176473_4_) {
		return false;
	}

	public void stepOn(World p_176199_1_, BlockPos p_176199_2_, Entity p_176199_3_) {
		if (!p_176199_3_.fireImmune() && p_176199_3_ instanceof LivingEntity) {
			p_176199_3_.hurt(DamageSource.IN_FIRE, 1.0F);
		}

		super.stepOn(p_176199_1_, p_176199_2_, p_176199_3_);
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

	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		entityIn.setSecondsOnFire(10);
	}

	@Override
	public void catchFire(BlockState state, World world, BlockPos pos, Direction face, LivingEntity igniter) {
		super.catchFire(state, world, pos, face, igniter);

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
