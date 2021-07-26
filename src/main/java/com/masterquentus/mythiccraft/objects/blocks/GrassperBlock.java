package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.tileentity.GrassperTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class GrassperBlock extends Block{

	public GrassperBlock(Properties p_i48440_1_) {
		super(p_i48440_1_);
	}
	
	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult ray) {
		if (!world.isClientSide() && hand == Hand.MAIN_HAND){
			ItemStack stack = player.getItemInHand(hand);
			GrassperTileEntity tile = (GrassperTileEntity) world.getBlockEntity(pos);
			player.setItemInHand(hand, tile.getItem());
			tile.setItem(stack);
		}

		return ActionResultType.SUCCESS;
	}
	
	@Override
	public BlockRenderType getRenderShape(BlockState iBlockState) {
		return BlockRenderType.MODEL;
	}

}
