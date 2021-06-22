package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.init.ModTileEntityTypes;
import com.masterquentus.mythiccraft.tileentity.MobSlayerTileEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class MobSlayerBlock extends Block {
    public MobSlayerBlock(AbstractBlock.Properties props) {
        super(props);
    }
    
    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.MOB_SLAYER.get().create();
    }
    
    @SuppressWarnings("deprecation")
	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
	    if (!world.isClientSide() && hand == Hand.MAIN_HAND ){
	        TileEntity tile = world.getBlockEntity(pos);
	        if (tile instanceof MobSlayerTileEntity){
	            ((MobSlayerTileEntity) tile).toggle();
	            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ANVIL_LAND, SoundCategory.PLAYERS, 1.0F, 1.0F);
	            return ActionResultType.SUCCESS;
	        }
	    }

	    return super.use(state, world, pos, player, hand, hit);
	}
}
