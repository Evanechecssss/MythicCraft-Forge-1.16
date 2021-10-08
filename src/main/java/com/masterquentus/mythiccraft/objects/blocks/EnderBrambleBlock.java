package com.masterquentus.mythiccraft.objects.blocks;


import java.util.Random;

import com.masterquentus.mythiccraft.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
public class EnderBrambleBlock extends SugarCaneBlock implements net.minecraftforge.common.IPlantable{
	public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
	   public static final VoxelShape COLLISION_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
	   public static final VoxelShape OUTLINE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

	public EnderBrambleBlock(Properties p_i48440_1_) {
		super(p_i48440_1_);
	}
	

	   @SuppressWarnings("unused")
	public void entityInside(BlockState state, World world, BlockPos pos, Entity entity) {
		   int bound = 5000;
		int dist = (((LivingEntity) entity).getRandom().nextInt(bound));
		   double d0 = entity.getX();
	         double d1 = entity.getY();
	         double d2 = entity.getZ();

	         for(int i = 0; i < 16; ++i) {
	            double d3 = entity.getX() + (((LivingEntity) entity).getRandom().nextDouble() - 0.5D) * dist;
	            double d4 = MathHelper.clamp(entity.getY() + (double)(((LivingEntity) entity).getRandom().nextInt(dist) - dist/2), 0.0D, (double)(world.getHeight() - 1));
	            double d5 = entity.getZ() + (((LivingEntity) entity).getRandom().nextDouble() - 0.5D) * dist;
	            if (entity.isPassenger()) {
	            	entity.stopRiding();
	            }

	            if (((LivingEntity) entity).randomTeleport(d3, d4, d5, true)) {
	               SoundEvent soundevent = entity instanceof FoxEntity ? SoundEvents.FOX_TELEPORT : SoundEvents.CHORUS_FRUIT_TELEPORT;
	               entity.playSound(soundevent, 1.0F, 1.0F);
	               entity.playSound(soundevent, 1.0F, 1.0F);
	               break;
	            }
	         }
	   }
	   
	   @SuppressWarnings("deprecation")
		@Override
		   public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
		       BlockState above = world.getBlockState(pos.above());
		       if (above.isAir()){
		           int i;
		           for(i = 1; world.getBlockState(pos.below(i)).is(this); ++i) {
		       }
		       
		       if (i < 3) {
		            int j = state.getValue(AGE);
		            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, true)) {
		            if (j == 15) {
		            	world.setBlockAndUpdate(pos.above(), this.defaultBlockState());
		            	world.setBlock(pos, state.setValue(AGE, Integer.valueOf(0)), 4);
		            } else {
		            	world.setBlock(pos, state.setValue(AGE, Integer.valueOf(j + 1)), 4);
		            }
		           }
		       }
		 }
	}

public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, IWorld p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
    if (!p_196271_1_.canSurvive(p_196271_4_, p_196271_5_)) {
       p_196271_4_.getBlockTicks().scheduleTick(p_196271_5_, this, 1);
    }

    return super.updateShape(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
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
}