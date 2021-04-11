package com.masterquentus.mythiccraft.objects.blocks;

import java.util.Random;

import com.masterquentus.mythiccraft.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.KelpTopBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ModKelpTopBlock extends KelpTopBlock implements IGrowable {

	public ModKelpTopBlock(Properties builder) {
		super(builder);

	}
	
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.isValidPosition(worldIn, currentPos)) {
            if (facing == Direction.DOWN) {
                return Blocks.AIR.getDefaultState();
            }

            worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
        }

        if (facing == Direction.UP && facingState.getBlock() == this) {
            return BlockInit.LIVING_KELP.get().getDefaultState();
        } else {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
            return stateIn;
        }
        
        
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
	
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        BlockState blockstate = worldIn.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block == Blocks.MAGMA_BLOCK) {
            return false;
        } else {
            return block == this || block == BlockInit.LIVING_KELP.get() || blockstate.isSolidSide(worldIn, blockpos, Direction.UP);
        }
    }

}
