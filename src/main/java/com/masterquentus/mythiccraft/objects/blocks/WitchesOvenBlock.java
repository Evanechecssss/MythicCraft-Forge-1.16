package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.init.ModTileEntityTypes;
import com.masterquentus.mythiccraft.tileentity.WithchesOvenTileEntity;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class WitchesOvenBlock extends AbstractFurnaceBlock {

	public WitchesOvenBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected void openContainer(World worldIn, BlockPos pos, PlayerEntity player) {
	      TileEntity tileentity = worldIn.getBlockEntity(pos);
	      if (tileentity instanceof WithchesOvenTileEntity) {
	    	  player.openMenu((INamedContainerProvider)tileentity);
	    	  player.awardStat(Stats.INTERACT_WITH_FURNACE);
	      }
	}

	@Override
	public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
		return ModTileEntityTypes.WITCHESOVEN_TILE.get().create();
	}
	

}
