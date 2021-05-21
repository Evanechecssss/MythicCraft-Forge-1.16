package com.masterquentus.mythiccraft.objects.blocks;

import java.util.stream.Stream;

import com.masterquentus.mythiccraft.init.ModTileEntityTypes;
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

public class PedestalTier1 extends Block {

	public static final DirectionProperty FACING = HorizontalBlock.FACING;

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

	public PedestalTier1(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));

	}

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
}