package com.masterquentus.mythiccraft.objects.blocks;

import java.util.stream.Stream;

import com.masterquentus.mythiccraft.init.ModTileEntityTypes;
import com.masterquentus.mythiccraft.tileentity.PedestalTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class PedestalBlock extends Block {
	int tier;
	public PedestalBlock(int tier, Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
		this.tier = tier;
	}


	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult ray) {
		if (!world.isClientSide() && hand == Hand.MAIN_HAND){
			ItemStack stack = player.getItemInHand(hand);
			PedestalTileEntity tile = (PedestalTileEntity) world.getBlockEntity(pos);
			player.setItemInHand(hand, tile.getItem());
			tile.setItem(stack);
		}

		return ActionResultType.SUCCESS;
	}

	public static final DirectionProperty FACING = HorizontalBlock.FACING;

	// todo: different shapes by tier

	private static final VoxelShape SHAPE_N = Stream
			.of(Block.box(1, 1, 1, 5, 15, 15), Block.box(0, 15, 0, 5, 16, 16),
					Block.box(0, 0, 0, 5, 1, 16), Block.box(5, 1, 1, 11, 15, 5),
					Block.box(5, 15, 0, 11, 16, 5), Block.box(5, 0, 0, 11, 1, 5),
					Block.box(5, 1, 11, 11, 15, 15), Block.box(5, 15, 11, 11, 16, 16),
					Block.box(5, 0, 11, 11, 1, 16), Block.box(11, 1, 1, 15, 15, 15),
					Block.box(11, 15, 0, 16, 16, 16), Block.box(11, 0, 0, 16, 1, 16))
			.reduce((v1, v2) -> {
				return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
			}).get();
	private static final VoxelShape SHAPE_W = Stream
			.of(Block.box(1, 1, 1, 5, 15, 15), Block.box(0, 15, 0, 5, 16, 16),
					Block.box(0, 0, 0, 5, 1, 16), Block.box(5, 1, 1, 11, 15, 5),
					Block.box(5, 15, 0, 11, 16, 5), Block.box(5, 0, 0, 11, 1, 5),
					Block.box(5, 1, 11, 11, 15, 15), Block.box(5, 15, 11, 11, 16, 16),
					Block.box(5, 0, 11, 11, 1, 16), Block.box(11, 1, 1, 15, 15, 15),
					Block.box(11, 15, 0, 16, 16, 16), Block.box(11, 0, 0, 16, 1, 16))
			.reduce((v1, v2) -> {
				return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
			}).get();
	private static final VoxelShape SHAPE_S = Stream
			.of(Block.box(1, 1, 1, 5, 15, 15), Block.box(0, 15, 0, 5, 16, 16),
					Block.box(0, 0, 0, 5, 1, 16), Block.box(5, 1, 1, 11, 15, 5),
					Block.box(5, 15, 0, 11, 16, 5), Block.box(5, 0, 0, 11, 1, 5),
					Block.box(5, 1, 11, 11, 15, 15), Block.box(5, 15, 11, 11, 16, 16),
					Block.box(5, 0, 11, 11, 1, 16), Block.box(11, 1, 1, 15, 15, 15),
					Block.box(11, 15, 0, 16, 16, 16), Block.box(11, 0, 0, 16, 1, 16))
			.reduce((v1, v2) -> {
				return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
			}).get();
	private static final VoxelShape SHAPE_E = Stream
			.of(Block.box(1, 1, 1, 5, 15, 15), Block.box(0, 15, 0, 5, 16, 16),
					Block.box(0, 0, 0, 5, 1, 16), Block.box(5, 1, 1, 11, 15, 5),
					Block.box(5, 15, 0, 11, 16, 5), Block.box(5, 0, 0, 11, 1, 5),
					Block.box(5, 1, 11, 11, 15, 15), Block.box(5, 15, 11, 11, 16, 16),
					Block.box(5, 0, 11, 11, 1, 16), Block.box(11, 1, 1, 15, 15, 15),
					Block.box(11, 15, 0, 16, 16, 16), Block.box(11, 0, 0, 16, 1, 16))
			.reduce((v1, v2) -> {
				return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
			}).get();

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.getValue(FACING)) {
		case NORTH:
			return SHAPE_N;
		case SOUTH:
			return SHAPE_S;
		case EAST:
			return SHAPE_E;
		case WEST:
			return SHAPE_W;
		default:
			return SHAPE_N;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());

	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(FACING);

	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return ModTileEntityTypes.pedestal_tier1.get().create();
	}

	@Override
	public BlockRenderType getRenderShape(BlockState iBlockState) {
		return BlockRenderType.MODEL;
	}

	public int getTier() {
		return this.tier;
	}
}