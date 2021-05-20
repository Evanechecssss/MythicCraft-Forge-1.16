package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.tileentity.WitchhazelCrateTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class WitchhazelCrateBlock extends Block {

	public WitchhazelCrateBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return ModTileEntityTypes.witchhazel_crate.get().create();
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult result) {
		if(!worldIn.isRemote) { 
			TileEntity tile = worldIn.getTileEntity(pos);
			if(tile instanceof WitchhazelCrateTileEntity) {
				worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_BARREL_OPEN, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
				NetworkHooks.openGui((ServerPlayerEntity)player, (WitchhazelCrateTileEntity)tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		
		return ActionResultType.FAIL;
	}
	
	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if(state.getBlock() != newState.getBlock()) {
			TileEntity te = worldIn.getTileEntity(pos);
			if(te  instanceof WitchhazelCrateTileEntity) {
				InventoryHelper.dropItems(worldIn, pos, ((WitchhazelCrateTileEntity)te).getItems());
				
			}
		}
	}
}