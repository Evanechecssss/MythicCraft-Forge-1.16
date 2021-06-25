package com.masterquentus.mythiccraft.objects.blocks;


import java.util.Random;

import com.masterquentus.mythiccraft.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class WildBrambleBlock extends Block implements net.minecraftforge.common.IPlantable{
	public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
	   public static final VoxelShape COLLISION_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
	   public static final VoxelShape OUTLINE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

	public WildBrambleBlock(Properties p_i48440_1_) {
		super(p_i48440_1_);
	}
	
	public boolean canSurvive(BlockState p_196260_1_, IWorldReader p_196260_2_, BlockPos p_196260_3_) {
	      BlockState soil = p_196260_2_.getBlockState(p_196260_3_.below());
	      if (soil.canSustainPlant(p_196260_2_, p_196260_3_.below(), Direction.UP, this)) return true;
	      BlockState blockstate = p_196260_2_.getBlockState(p_196260_3_.below());
	      if (blockstate.getBlock() == this) {
	         return true;
	      } else {
	         if (blockstate.is(Blocks.GRASS_BLOCK) || blockstate.is(Blocks.DIRT) || blockstate.is(Blocks.COARSE_DIRT) || blockstate.is(Blocks.PODZOL) || blockstate.is(Blocks.SAND) || blockstate.is(Blocks.RED_SAND)) {
	            BlockPos blockpos = p_196260_3_.below();

	            for(Direction direction : Direction.Plane.HORIZONTAL) {
	               BlockState blockstate1 = p_196260_2_.getBlockState(blockpos.relative(direction));
	               FluidState fluidstate = p_196260_2_.getFluidState(blockpos.relative(direction));
	               if (fluidstate.is(FluidTags.WATER) || blockstate1.is(Blocks.FROSTED_ICE)) {
	                  return true;
	               }
	            }
	         }

	         return false;
	      }
	   }
	

	   public void entityInside(BlockState p_196262_1_, World p_196262_2_, BlockPos p_196262_3_, Entity p_196262_4_) {
	      p_196262_4_.hurt(DamageSource.CACTUS, 1.0F);
	   }
	   
	   @SuppressWarnings("deprecation")
		@Override
		   public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
		       BlockState above = world.getBlockState(pos.above());
		       if (above.isAir()){
		           world.setBlockAndUpdate(pos.above(), BlockInit.WILD_BRAMBLE.get().defaultBlockState());
		       }
	   }


	   @Override
	   public BlockState getPlant(IBlockReader world, BlockPos pos) {
	      return defaultBlockState();
	   }
	}