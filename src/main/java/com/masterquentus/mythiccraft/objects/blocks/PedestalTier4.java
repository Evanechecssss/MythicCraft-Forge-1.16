package com.masterquentus.mythiccraft.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class PedestalTier4 extends Block {
	
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(13, 2, 3.75, 14, 3, 13.75),
			Block.makeCuboidShape(3, 2, 2, 13, 3, 3),
			Block.makeCuboidShape(15, 16, 3, 16, 22, 13),
			Block.makeCuboidShape(3, 6, 15, 13, 12, 16),
			Block.makeCuboidShape(0, 6, 3, 1, 12, 13),
			Block.makeCuboidShape(3, 6, 0, 13, 12, 1),
			Block.makeCuboidShape(15, 6, 3, 16, 12, 13),
			Block.makeCuboidShape(3, 24, 13, 13, 25, 14),
			Block.makeCuboidShape(2, 24, 3, 3, 25, 13),
			Block.makeCuboidShape(3, 24, 2, 13, 25, 3),
			Block.makeCuboidShape(13, 24, 3, 14, 25, 13),
			Block.makeCuboidShape(3, 13, 13, 13, 14, 14),
			Block.makeCuboidShape(2, 13, 3, 3, 14, 13),
			Block.makeCuboidShape(3, 13, 2, 13, 14, 3),
			Block.makeCuboidShape(13, 13, 3, 14, 14, 13),
			Block.makeCuboidShape(3, 2, 13, 13, 3, 14),
			Block.makeCuboidShape(2, 2, 3, 3, 3, 13),
			Block.makeCuboidShape(3, 25, 3, 13, 25, 13),
			Block.makeCuboidShape(3, 13.5, 3, 13, 13.5, 13),
			Block.makeCuboidShape(3, 2, 3, 13, 2, 13),
			Block.makeCuboidShape(0, 2, 13, 3, 26, 16),
			Block.makeCuboidShape(0, 2, 0, 3, 26, 3),
			Block.makeCuboidShape(13, 2, 0, 16, 26, 3),
			Block.makeCuboidShape(13, 2, 13, 16, 26, 16),
			Block.makeCuboidShape(-4, 8, -4, 20, 8, 20),
			Block.makeCuboidShape(-4, 19, -4, 20, 19, 20),
			Block.makeCuboidShape(-0.5, 0, 12.5, 3.5, 2, 16.5),
			Block.makeCuboidShape(12.5, 0, 12.5, 16.5, 2, 16.5),
			Block.makeCuboidShape(-0.5, 0, -0.5, 3.5, 2, 3.5),
			Block.makeCuboidShape(12.5, 0, -0.5, 16.5, 2, 3.5),
			Block.makeCuboidShape(-0.5, 25, 12.5, 3.5, 27, 16.5),
			Block.makeCuboidShape(12.5, 25, 12.5, 16.5, 27, 16.5),
			Block.makeCuboidShape(-0.5, 25, -0.5, 3.5, 27, 3.5),
			Block.makeCuboidShape(12.5, 25, -0.5, 16.5, 27, 3.5),
			Block.makeCuboidShape(3, 16, 15, 13, 22, 16),
			Block.makeCuboidShape(0, 16, 3, 1, 22, 13),
			Block.makeCuboidShape(3, 16, 0, 13, 22, 1)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(13, 2, 3.75, 14, 3, 13.75),
			Block.makeCuboidShape(3, 2, 2, 13, 3, 3),
			Block.makeCuboidShape(15, 16, 3, 16, 22, 13),
			Block.makeCuboidShape(3, 6, 15, 13, 12, 16),
			Block.makeCuboidShape(0, 6, 3, 1, 12, 13),
			Block.makeCuboidShape(3, 6, 0, 13, 12, 1),
			Block.makeCuboidShape(15, 6, 3, 16, 12, 13),
			Block.makeCuboidShape(3, 24, 13, 13, 25, 14),
			Block.makeCuboidShape(2, 24, 3, 3, 25, 13),
			Block.makeCuboidShape(3, 24, 2, 13, 25, 3),
			Block.makeCuboidShape(13, 24, 3, 14, 25, 13),
			Block.makeCuboidShape(3, 13, 13, 13, 14, 14),
			Block.makeCuboidShape(2, 13, 3, 3, 14, 13),
			Block.makeCuboidShape(3, 13, 2, 13, 14, 3),
			Block.makeCuboidShape(13, 13, 3, 14, 14, 13),
			Block.makeCuboidShape(3, 2, 13, 13, 3, 14),
			Block.makeCuboidShape(2, 2, 3, 3, 3, 13),
			Block.makeCuboidShape(3, 25, 3, 13, 25, 13),
			Block.makeCuboidShape(3, 13.5, 3, 13, 13.5, 13),
			Block.makeCuboidShape(3, 2, 3, 13, 2, 13),
			Block.makeCuboidShape(0, 2, 13, 3, 26, 16),
			Block.makeCuboidShape(0, 2, 0, 3, 26, 3),
			Block.makeCuboidShape(13, 2, 0, 16, 26, 3),
			Block.makeCuboidShape(13, 2, 13, 16, 26, 16),
			Block.makeCuboidShape(-4, 8, -4, 20, 8, 20),
			Block.makeCuboidShape(-4, 19, -4, 20, 19, 20),
			Block.makeCuboidShape(-0.5, 0, 12.5, 3.5, 2, 16.5),
			Block.makeCuboidShape(12.5, 0, 12.5, 16.5, 2, 16.5),
			Block.makeCuboidShape(-0.5, 0, -0.5, 3.5, 2, 3.5),
			Block.makeCuboidShape(12.5, 0, -0.5, 16.5, 2, 3.5),
			Block.makeCuboidShape(-0.5, 25, 12.5, 3.5, 27, 16.5),
			Block.makeCuboidShape(12.5, 25, 12.5, 16.5, 27, 16.5),
			Block.makeCuboidShape(-0.5, 25, -0.5, 3.5, 27, 3.5),
			Block.makeCuboidShape(12.5, 25, -0.5, 16.5, 27, 3.5),
			Block.makeCuboidShape(3, 16, 15, 13, 22, 16),
			Block.makeCuboidShape(0, 16, 3, 1, 22, 13),
			Block.makeCuboidShape(3, 16, 0, 13, 22, 1)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(13, 2, 3.75, 14, 3, 13.75),
			Block.makeCuboidShape(3, 2, 2, 13, 3, 3),
			Block.makeCuboidShape(15, 16, 3, 16, 22, 13),
			Block.makeCuboidShape(3, 6, 15, 13, 12, 16),
			Block.makeCuboidShape(0, 6, 3, 1, 12, 13),
			Block.makeCuboidShape(3, 6, 0, 13, 12, 1),
			Block.makeCuboidShape(15, 6, 3, 16, 12, 13),
			Block.makeCuboidShape(3, 24, 13, 13, 25, 14),
			Block.makeCuboidShape(2, 24, 3, 3, 25, 13),
			Block.makeCuboidShape(3, 24, 2, 13, 25, 3),
			Block.makeCuboidShape(13, 24, 3, 14, 25, 13),
			Block.makeCuboidShape(3, 13, 13, 13, 14, 14),
			Block.makeCuboidShape(2, 13, 3, 3, 14, 13),
			Block.makeCuboidShape(3, 13, 2, 13, 14, 3),
			Block.makeCuboidShape(13, 13, 3, 14, 14, 13),
			Block.makeCuboidShape(3, 2, 13, 13, 3, 14),
			Block.makeCuboidShape(2, 2, 3, 3, 3, 13),
			Block.makeCuboidShape(3, 25, 3, 13, 25, 13),
			Block.makeCuboidShape(3, 13.5, 3, 13, 13.5, 13),
			Block.makeCuboidShape(3, 2, 3, 13, 2, 13),
			Block.makeCuboidShape(0, 2, 13, 3, 26, 16),
			Block.makeCuboidShape(0, 2, 0, 3, 26, 3),
			Block.makeCuboidShape(13, 2, 0, 16, 26, 3),
			Block.makeCuboidShape(13, 2, 13, 16, 26, 16),
			Block.makeCuboidShape(-4, 8, -4, 20, 8, 20),
			Block.makeCuboidShape(-4, 19, -4, 20, 19, 20),
			Block.makeCuboidShape(-0.5, 0, 12.5, 3.5, 2, 16.5),
			Block.makeCuboidShape(12.5, 0, 12.5, 16.5, 2, 16.5),
			Block.makeCuboidShape(-0.5, 0, -0.5, 3.5, 2, 3.5),
			Block.makeCuboidShape(12.5, 0, -0.5, 16.5, 2, 3.5),
			Block.makeCuboidShape(-0.5, 25, 12.5, 3.5, 27, 16.5),
			Block.makeCuboidShape(12.5, 25, 12.5, 16.5, 27, 16.5),
			Block.makeCuboidShape(-0.5, 25, -0.5, 3.5, 27, 3.5),
			Block.makeCuboidShape(12.5, 25, -0.5, 16.5, 27, 3.5),
			Block.makeCuboidShape(3, 16, 15, 13, 22, 16),
			Block.makeCuboidShape(0, 16, 3, 1, 22, 13),
			Block.makeCuboidShape(3, 16, 0, 13, 22, 1)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(13, 2, 3.75, 14, 3, 13.75),
			Block.makeCuboidShape(3, 2, 2, 13, 3, 3),
			Block.makeCuboidShape(15, 16, 3, 16, 22, 13),
			Block.makeCuboidShape(3, 6, 15, 13, 12, 16),
			Block.makeCuboidShape(0, 6, 3, 1, 12, 13),
			Block.makeCuboidShape(3, 6, 0, 13, 12, 1),
			Block.makeCuboidShape(15, 6, 3, 16, 12, 13),
			Block.makeCuboidShape(3, 24, 13, 13, 25, 14),
			Block.makeCuboidShape(2, 24, 3, 3, 25, 13),
			Block.makeCuboidShape(3, 24, 2, 13, 25, 3),
			Block.makeCuboidShape(13, 24, 3, 14, 25, 13),
			Block.makeCuboidShape(3, 13, 13, 13, 14, 14),
			Block.makeCuboidShape(2, 13, 3, 3, 14, 13),
			Block.makeCuboidShape(3, 13, 2, 13, 14, 3),
			Block.makeCuboidShape(13, 13, 3, 14, 14, 13),
			Block.makeCuboidShape(3, 2, 13, 13, 3, 14),
			Block.makeCuboidShape(2, 2, 3, 3, 3, 13),
			Block.makeCuboidShape(3, 25, 3, 13, 25, 13),
			Block.makeCuboidShape(3, 13.5, 3, 13, 13.5, 13),
			Block.makeCuboidShape(3, 2, 3, 13, 2, 13),
			Block.makeCuboidShape(0, 2, 13, 3, 26, 16),
			Block.makeCuboidShape(0, 2, 0, 3, 26, 3),
			Block.makeCuboidShape(13, 2, 0, 16, 26, 3),
			Block.makeCuboidShape(13, 2, 13, 16, 26, 16),
			Block.makeCuboidShape(-4, 8, -4, 20, 8, 20),
			Block.makeCuboidShape(-4, 19, -4, 20, 19, 20),
			Block.makeCuboidShape(-0.5, 0, 12.5, 3.5, 2, 16.5),
			Block.makeCuboidShape(12.5, 0, 12.5, 16.5, 2, 16.5),
			Block.makeCuboidShape(-0.5, 0, -0.5, 3.5, 2, 3.5),
			Block.makeCuboidShape(12.5, 0, -0.5, 16.5, 2, 3.5),
			Block.makeCuboidShape(-0.5, 25, 12.5, 3.5, 27, 16.5),
			Block.makeCuboidShape(12.5, 25, 12.5, 16.5, 27, 16.5),
			Block.makeCuboidShape(-0.5, 25, -0.5, 3.5, 27, 3.5),
			Block.makeCuboidShape(12.5, 25, -0.5, 16.5, 27, 3.5),
			Block.makeCuboidShape(3, 16, 15, 13, 22, 16),
			Block.makeCuboidShape(0, 16, 3, 1, 22, 13),
			Block.makeCuboidShape(3, 16, 0, 13, 22, 1)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	
	
	public PedestalTier4(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));

	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
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
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());

	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
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
	public BlockRenderType getRenderType(BlockState iBlockState) {
		return BlockRenderType.MODEL;
	}
}
