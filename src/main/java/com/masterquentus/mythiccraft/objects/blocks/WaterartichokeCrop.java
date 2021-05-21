package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.init.ItemInit;

import com.masterquentus.mythiccraft.objects.blocks.ModCropBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
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
