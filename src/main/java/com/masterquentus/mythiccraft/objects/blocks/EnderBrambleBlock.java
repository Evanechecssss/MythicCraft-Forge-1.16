package com.masterquentus.mythiccraft.objects.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.World;
public class EnderBrambleBlock extends Block {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
	   public static final VoxelShape COLLISION_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
	   public static final VoxelShape OUTLINE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

	public EnderBrambleBlock(Properties p_i48440_1_) {
		super(p_i48440_1_);
	}
	

	   public void entityInside(BlockState p_196262_1_, World p_196262_2_, BlockPos p_196262_3_, Entity p_196262_4_) {
	      p_196262_4_.teleportTo(jumpFactor, friction, explosionResistance);
	   }
}