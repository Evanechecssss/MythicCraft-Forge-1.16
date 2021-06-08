package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.init.ModTileEntityTypes;
import com.masterquentus.mythiccraft.tileentity.CrateTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.List;

public class CrateBlock extends Block {
	public CrateBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return ModTileEntityTypes.CRATE_TILE.get().create();
	}
	
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult result) {
		if(!worldIn.isClientSide()) {
			TileEntity tile = worldIn.getBlockEntity(pos);
			if(tile instanceof CrateTileEntity) {
				worldIn.playSound(player, pos, SoundEvents.BARREL_OPEN, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.random.nextFloat() * 0.4F);
				NetworkHooks.openGui((ServerPlayerEntity)player, (CrateTileEntity)tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		
		return ActionResultType.FAIL;
	}
	
	@Override
	public void onRemove(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if(state.getBlock() != newState.getBlock()) {
			TileEntity te = worldIn.getBlockEntity(pos);
			if(te instanceof CrateTileEntity) {
				// InventoryHelper.dropContents(worldIn, pos, ((CrateTileEntity)te).getItems());
			}
		}
	}


	@Override
	public void playerWillDestroy(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		TileEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof CrateTileEntity) {
			CrateTileEntity tile = (CrateTileEntity)tileentity;
			if (!world.isClientSide && player.isCreative() && !tile.isEmpty()) {
				ItemStack itemstack = new ItemStack(this.asItem());
				CompoundNBT compoundnbt = tile.saveToTag(new CompoundNBT());
				if (!compoundnbt.isEmpty()) {
					itemstack.addTagElement("BlockEntityTag", compoundnbt);
				}

				if (tile.hasCustomName()) {
					itemstack.setHoverName(tile.getCustomName());
				}

				ItemEntity itementity = new ItemEntity(world, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, itemstack);
				itementity.setDefaultPickUpDelay();
				world.addFreshEntity(itementity);
			} else {
				tile.unpackLootTable(player);
			}
		}

		super.playerWillDestroy(world, pos, state, player);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		TileEntity tileentity = builder.getOptionalParameter(LootParameters.BLOCK_ENTITY);
		if (tileentity instanceof CrateTileEntity) {
			CrateTileEntity tile = (CrateTileEntity)tileentity;
			builder = builder.withDynamicDrop(new ResourceLocation("contents"), (p_220168_1_, p_220168_2_) -> {
				for(int i = 0; i < tile.getContainerSize(); ++i) {
					p_220168_2_.accept(tile.getItem(i));
				}

			});
		}

		return super.getDrops(state, builder);
	}
}