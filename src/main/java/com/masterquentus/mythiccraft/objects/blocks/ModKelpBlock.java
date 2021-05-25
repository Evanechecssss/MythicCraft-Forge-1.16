package com.masterquentus.mythiccraft.objects.blocks;

import java.util.Random;

import com.masterquentus.mythiccraft.init.BlockInit;

import net.minecraft.block.*;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;

public class ModKelpBlock extends KelpBlock implements ILiquidContainer {
	public ModKelpBlock(Properties properties) {
		super(properties);
	}

	public FluidState getFluidState(BlockState state) {
	      return Fluids.WATER.getSource(false);
	   }

	   public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
	      if (!state.canSurvive(worldIn, pos)) {
	         worldIn.destroyBlock(pos, true);
	      }

	      super.tick(state, worldIn, pos, rand);
	   }

	   public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
	      return new ItemStack(BlockInit.LIVING_KELP.get());
	   }

	  protected AbstractTopPlantBlock getHeadBlock() {
		return (AbstractTopPlantBlock)BlockInit.LIVING_KELP_TOP.get();
	}

	   public boolean canPlaceLiquid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
	      return false;
	   }

	   public boolean placeLiquid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
	      return false;
	   }
	}