package com.masterquentus.mythiccraft.objects.blocks;

import java.util.stream.Stream;

import com.masterquentus.mythiccraft.init.DimensionInit;
import com.masterquentus.mythiccraft.init.ModTileEntityTypes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
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
import net.minecraft.world.server.ServerWorld;

public class MagicMirrorBlock extends Block {

	public static VoxelShape SHAPE_N = Stream
			.of(Block.box(4, -16, -2, 15, -4, 18), Block.box(5, -4, -2, 14, 8, 18), Block.box(6, 20, -2, 13, 32, 18),
					Block.box(5.5, 8, -2, 13.5, 20, 18))
			.reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

	public static VoxelShape SHAPE_S = Stream
			.of(Block.box(4, -16, -2, 15, -4, 18), Block.box(5, -4, -2, 14, 8, 18), Block.box(6, 20, -2, 13, 32, 18),
					Block.box(5.5, 8, -2, 13.5, 20, 18))
			.reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

	public static VoxelShape SHAPE_W = Stream.of(
			Block.box(-0.5, -16, 2, 19.5, -4, 13),
			Block.box(-0.5, -4, 3, 19.5, 8, 12),
			Block.box(-0.5, 13, 4, 19.5, 25, 11),
			Block.box(-0.5, 8, 3.5, 19.5, 20, 11.5)
			).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

	public static VoxelShape SHAPE_E = Stream.of(
			Block.box(-0.5, -16, 2, 19.5, -4, 13),
			Block.box(-0.5, -4, 3, 19.5, 8, 12),
			Block.box(-0.5, 13, 4, 19.5, 25, 11),
			Block.box(-0.5, 8, 3.5, 19.5, 20, 11.5)
			).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

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

	public MagicMirrorBlock(Properties p_i48440_1_) {
		super(p_i48440_1_);

	}

	public static final DirectionProperty FACING = HorizontalBlock.FACING;

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
		builder.add(FACING);

	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return ModTileEntityTypes.MAGIC_MIRROR.get().create();
	}

	@Override
	public BlockRenderType getRenderShape(BlockState iBlockState) {
		return BlockRenderType.MODEL;
	}
}