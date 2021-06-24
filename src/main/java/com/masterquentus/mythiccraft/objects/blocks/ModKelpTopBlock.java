package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.KelpTopBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class ModKelpTopBlock extends KelpTopBlock implements IGrowable {

	public ModKelpTopBlock(Properties builder) {
		super(builder);

	}
	
	public boolean canGrowInto(BlockState p_230334_1_) {
	      return p_230334_1_.is(Blocks.WATER);
	   }

    @Override
    protected Block getBodyBlock() {
        return BlockInit.LIVING_KELP_PLANT.get();
    }


    @Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState blockstate = worldIn.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block == Blocks.MAGMA_BLOCK) {
            return false;
        } else {
            return block == this || block ==this.getBodyBlock() || blockstate.isFaceSturdy(worldIn, blockpos, Direction.UP);
        }
    }

}
