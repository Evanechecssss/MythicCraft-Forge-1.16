package com.masterquentus.mythiccraft.objects.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class HellFireBlock extends FireBlock {

	public HellFireBlock(Properties builder) {
		super(builder);
	}
	
	@Override
	public boolean addDestroyEffects(BlockState state, World world, BlockPos pos, ParticleManager manager) {
		return super.addDestroyEffects(state, world, pos, manager);
		
	}
	
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		entityIn.setSecondsOnFire(10);

	}
	
	@Override
	public void catchFire(BlockState state, World world, BlockPos pos, Direction face, LivingEntity igniter) {
		super.catchFire(state, world, pos, face, igniter);
	}
	
	@Override
	public boolean canEntityDestroy(BlockState state, IBlockReader world, BlockPos pos, Entity entity) {
		return super.canEntityDestroy(state, world, pos, entity);
	}
	
	@Override
	public boolean isFireSource(BlockState state, IWorldReader world, BlockPos pos, Direction side) {
		return super.isFireSource(state, world, pos, side);
	}

	public BlockState getStateToPlace(World world, BlockPos pos) {
		return getStateForPlacement(world, pos);
	}
}
