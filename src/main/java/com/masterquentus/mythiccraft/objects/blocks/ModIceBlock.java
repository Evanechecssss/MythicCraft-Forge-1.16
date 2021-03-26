package com.masterquentus.mythiccraft.objects.blocks;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.IceBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.server.ServerWorld;

public class ModIceBlock extends IceBlock {

	public ModIceBlock(Properties properties) {
		super(properties);
	}
	
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
	      if (worldIn.getLightFor(LightType.BLOCK, pos) > 11 - state.getOpacity(worldIn, pos)) {
	         this.turnIntoWater(state, worldIn, pos);
	      }

	   }

}
