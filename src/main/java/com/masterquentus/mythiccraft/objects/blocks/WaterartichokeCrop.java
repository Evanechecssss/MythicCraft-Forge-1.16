package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.init.ItemInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class WaterartichokeCrop extends ModCropBlock {
	public WaterartichokeCrop(Properties builder) {
		super(builder, ItemInit.waterartichoke_seeds);
	}

	@Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() == Blocks.WATER;
    }
}
