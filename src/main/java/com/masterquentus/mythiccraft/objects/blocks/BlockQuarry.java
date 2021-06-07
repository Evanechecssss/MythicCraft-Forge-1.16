package com.masterquentus.mythiccraft.objects.blocks;

import java.util.stream.Stream;

import com.masterquentus.mythiccraft.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.effect.LightningBoltEntity;
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
import net.minecraft.world.World;

public class BlockQuarry extends Block {

	public static final DirectionProperty FACING = HorizontalBlock.FACING;

	private static final VoxelShape SHAPE_N = Stream.of(Block.box(0, 16.5, 0, 16, 27.5, 16),
			Block.box(7, 2.45672, 7, 9, 15.54328, 9), Block.box(4.7039, 8, 7, 11.2961, 10, 9),
			Block.box(7, 8, 4.7039, 9, 10, 11.2961),
			Block.box(8.68297, 10.00416, 7, 10.68297, 16.00416, 9),
			Block.box(7, 10.00416, 8.68297, 9, 16.00416, 10.68297),
			Block.box(5.31703, 10.00416, 7, 7.31703, 16.00416, 9),
			Block.box(7, 10.00416, 5.31703, 9, 16.00416, 7.31703),
			Block.box(8.68297, 1.99584, 7, 10.68297, 7.99584, 9),
			Block.box(7, 1.99584, 8.68297, 9, 7.99584, 10.68297),
			Block.box(5.31703, 1.99584, 7, 7.31703, 7.99584, 9),
			Block.box(7, 1.99584, 5.31703, 9, 7.99584, 7.31703)).reduce((v1, v2) -> {
				return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
			}).get();
	private static final VoxelShape SHAPE_W = Stream.of(Block.box(0, 16.5, 0, 16, 27.5, 16),
			Block.box(7, 2.45672, 7, 9, 15.54328, 9), Block.box(4.7039, 8, 7, 11.2961, 10, 9),
			Block.box(7, 8, 4.7039, 9, 10, 11.2961),
			Block.box(8.68297, 10.00416, 7, 10.68297, 16.00416, 9),
			Block.box(7, 10.00416, 8.68297, 9, 16.00416, 10.68297),
			Block.box(5.31703, 10.00416, 7, 7.31703, 16.00416, 9),
			Block.box(7, 10.00416, 5.31703, 9, 16.00416, 7.31703),
			Block.box(8.68297, 1.99584, 7, 10.68297, 7.99584, 9),
			Block.box(7, 1.99584, 8.68297, 9, 7.99584, 10.68297),
			Block.box(5.31703, 1.99584, 7, 7.31703, 7.99584, 9),
			Block.box(7, 1.99584, 5.31703, 9, 7.99584, 7.31703)).reduce((v1, v2) -> {
				return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
			}).get();
	private static final VoxelShape SHAPE_S = Stream.of(Block.box(0, 16.5, 0, 16, 27.5, 16),
			Block.box(7, 2.45672, 7, 9, 15.54328, 9), Block.box(4.7039, 8, 7, 11.2961, 10, 9),
			Block.box(7, 8, 4.7039, 9, 10, 11.2961),
			Block.box(8.68297, 10.00416, 7, 10.68297, 16.00416, 9),
			Block.box(7, 10.00416, 8.68297, 9, 16.00416, 10.68297),
			Block.box(5.31703, 10.00416, 7, 7.31703, 16.00416, 9),
			Block.box(7, 10.00416, 5.31703, 9, 16.00416, 7.31703),
			Block.box(8.68297, 1.99584, 7, 10.68297, 7.99584, 9),
			Block.box(7, 1.99584, 8.68297, 9, 7.99584, 10.68297),
			Block.box(5.31703, 1.99584, 7, 7.31703, 7.99584, 9),
			Block.box(7, 1.99584, 5.31703, 9, 7.99584, 7.31703)).reduce((v1, v2) -> {
				return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
			}).get();
	private static final VoxelShape SHAPE_E = Stream.of(Block.box(0, 16.5, 0, 16, 27.5, 16),
			Block.box(7, 2.45672, 7, 9, 15.54328, 9), Block.box(4.7039, 8, 7, 11.2961, 10, 9),
			Block.box(7, 8, 4.7039, 9, 10, 11.2961),
			Block.box(8.68297, 10.00416, 7, 10.68297, 16.00416, 9),
			Block.box(7, 10.00416, 8.68297, 9, 16.00416, 10.68297),
			Block.box(5.31703, 10.00416, 7, 7.31703, 16.00416, 9),
			Block.box(7, 10.00416, 5.31703, 9, 16.00416, 7.31703),
			Block.box(8.68297, 1.99584, 7, 10.68297, 7.99584, 9),
			Block.box(7, 1.99584, 8.68297, 9, 7.99584, 10.68297),
			Block.box(5.31703, 1.99584, 7, 7.31703, 7.99584, 9),
			Block.box(7, 1.99584, 5.31703, 9, 7.99584, 7.31703)).reduce((v1, v2) -> {
				return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
			}).get();

	public BlockQuarry(Properties properties) {
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
		return ModTileEntityTypes.magic_quarry.get().create();
	}

	@Override
	public BlockRenderType getRenderShape(BlockState iBlockState) {
		return BlockRenderType.MODEL;
	}
}