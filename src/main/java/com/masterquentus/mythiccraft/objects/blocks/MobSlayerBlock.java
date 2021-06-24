package com.masterquentus.mythiccraft.objects.blocks;

import java.util.List;

import javax.annotation.Nullable;

import com.masterquentus.mythiccraft.init.ModTileEntityTypes;
import com.masterquentus.mythiccraft.tileentity.MobSlayerTileEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MobSlayerBlock extends Block {
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack p_190948_1_, @Nullable IBlockReader p_190948_2_, List<ITextComponent> tooltop,
			ITooltipFlag p_190948_4_) {
		super.appendHoverText(p_190948_1_, p_190948_2_, tooltop, p_190948_4_);
		tooltop.add(new StringTextComponent(
				"To Activate, Place Pedestals Holding 2 Red Runes & 2 Purple Runes On The 4th Diagonal Block"));
	}

	public static final DirectionProperty FACING = HorizontalBlock.FACING;
	public static final BooleanProperty ENABLED = BlockStateProperties.ENABLED;

	public MobSlayerBlock(AbstractBlock.Properties props) {
		super(props);
		this.registerDefaultState(
				this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(ENABLED, Boolean.valueOf(false)));
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());

	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(FACING, ENABLED);
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return ModTileEntityTypes.MOB_SLAYER.get().create();
	}

	@SuppressWarnings("deprecation")
	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
			BlockRayTraceResult hit) {
		if (!world.isClientSide() && hand == Hand.MAIN_HAND) {
			TileEntity tile = world.getBlockEntity(pos);
			if (tile instanceof MobSlayerTileEntity) {
				((MobSlayerTileEntity) tile).toggle();
				world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.SLIME_BLOCK_BREAK,
						SoundCategory.PLAYERS, 1.0F, 1.0F);
				return ActionResultType.SUCCESS;
			}
		}

		return super.use(state, world, pos, player, hand, hit);
	}

}
