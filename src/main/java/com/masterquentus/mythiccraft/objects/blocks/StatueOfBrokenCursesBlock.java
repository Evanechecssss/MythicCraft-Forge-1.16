package com.masterquentus.mythiccraft.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class StatueOfBrokenCursesBlock extends Block {

	public static VoxelShape SHAPE_N = Stream
			.of(Block.box(0, -16, 0, 16, -10, 16), Block.box(0, -12, 0, 16, -4, 16), Block.box(1, -4, 2, 14, 4, 15),
					Block.box(3, 4, 3, 13, 10, 14), Block.box(3, 10, -1, 13, 30, 12), Block.box(-2, 10, -2, 3, 18, 9),
					Block.box(13, 10, -3, 18, 17, 8))
			.reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

	public static VoxelShape SHAPE_S = Stream
			.of(Block.box(-0.14285714285714235, -16, -3.285714285714283, 15.857142857142858, -10, 12.714285714285715),
					Block.box(-0.14285714285714235, -12, -3.285714285714283, 15.857142857142858, -4,
							12.714285714285715),
					Block.box(1.8571428571428577, -4, -2.285714285714283, 14.857142857142858, 4, 10.714285714285715),
					Block.box(2.8571428571428577, 4, -1.2857142857142847, 12.857142857142858, 10, 9.714285714285715),
					Block.box(2.8571428571428577, 10, 0.7142857142857153, 12.857142857142858, 30, 13.714285714285715),
					Block.box(12.857142857142858, 10, 3.7142857142857153, 17.857142857142854, 18, 14.714285714285714),
					Block.box(-2.142857142857144, 10, 4.714285714285715, 2.8571428571428577, 17, 15.714285714285714))
			.reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

	public static VoxelShape SHAPE_W = Stream
			.of(Block.box(1.5714285714285712, -16, -1.7142857142857135, 17.57142857142857, -10, 14.285714285714286),
					Block.box(1.5714285714285712, -12, -1.7142857142857135, 17.57142857142857, -4, 14.285714285714286),
					Block.box(3.571428571428571, -4, 0.2857142857142865, 16.57142857142857, 4, 13.285714285714286),
					Block.box(4.571428571428571, 4, 1.2857142857142865, 15.571428571428571, 10, 11.285714285714286),
					Block.box(0.5714285714285712, 10, 1.2857142857142865, 13.571428571428571, 30, 11.285714285714286),
					Block.box(-0.42857142857142705, 10, 11.285714285714286, 10.571428571428571, 18, 16.285714285714285),
					Block.box(-1.428571428571427, 10, -3.7142857142857153, 9.571428571428571, 17, 1.2857142857142865))
			.reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

	public static VoxelShape SHAPE_E = Stream
			.of(Block.box(-1.7142857142857117, -16, -1.5714285714285712, 14.285714285714286, -10, 14.428571428571429),
					Block.box(-1.7142857142857117, -12, -1.5714285714285712, 14.285714285714286, -4,
							14.428571428571429),
					Block.box(-0.7142857142857117, -4, -0.5714285714285712, 12.285714285714286, 4, 12.428571428571429),
					Block.box(0.2857142857142865, 4, 1.4285714285714288, 11.285714285714286, 10, 11.428571428571429),
					Block.box(2.2857142857142865, 10, 1.4285714285714288, 15.285714285714286, 30, 11.428571428571429),
					Block.box(5.2857142857142865, 10, -3.5714285714285694, 16.285714285714285, 18, 1.4285714285714288),
					Block.box(6.2857142857142865, 10, 11.428571428571429, 17.285714285714285, 17, 16.42857142857143))
			.reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
	
	
	
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

	public StatueOfBrokenCursesBlock(Properties properties) {
		super(properties);

	}

		public static final DirectionProperty FACING = HorizontalBlock.FACING;

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
	public BlockRenderType getRenderShape(BlockState iBlockState) {
		return BlockRenderType.MODEL;
	}
}