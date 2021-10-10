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
import net.minecraft.util.Rotation;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class StatueOfBrokenCursesBlock extends HorizontalBlock {
	
	public static VoxelShape STATUE_OF_BOKEN_CURSES = Stream
			.of(Block.box(0, -16, 0, 16, -10, 16), Block.box(0, -12, 0, 16, -4, 16), Block.box(1, -4, 2, 14, 4, 15),
					Block.box(3, 4, 3, 13, 10, 14), Block.box(3, 10, -1, 13, 30, 12), Block.box(-2, 10, -2, 3, 18, 9),
					Block.box(13, 10, -3, 18, 17, 8))
			.reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

	public StatueOfBrokenCursesBlock(Properties p_i48440_1_) {
		super(p_i48440_1_);
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
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return ModTileEntityTypes.pandors_box.get().create();
	}
	
	@Override
    public BlockRenderType getRenderShape(BlockState iBlockState) {
        return BlockRenderType.MODEL;
	}	
}