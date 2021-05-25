package com.masterquentus.mythiccraft.objects.blocks;

import java.util.stream.Stream;

import com.masterquentus.mythiccraft.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
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
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class PandorsBox extends Block 
{

	public static final DirectionProperty FACING = HorizontalBlock.FACING;
	
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.box(6.9, 10.4, -1.1, 9.1, 13.6, 0.1),
			Block.box(7, 10.5, -1, 9, 13.5, 0),
			Block.box(-2.25, 0, 14.56351, 1.75, 1, 17.56351),
			Block.box(14.25, 0, 14.56351, 18.25, 1, 17.56351),
			Block.box(14.25, 0, -1.56351, 18.25, 1, 1.43649),
			Block.box(-2.25, 0, -1.56351, 1.75, 1, 1.43649),
			Block.box(-1.75, -2.53752, 13.06351, 1.25, 1.46248, 15.06351),
			Block.box(14.75, -2.53752, 13.06351, 17.75, 1.46248, 15.06351),
			Block.box(14.75, -2.53752, 0.93649, 17.75, 1.46248, 2.93649),
			Block.box(-1.75, -2.53752, 0.93649, 1.25, 1.46248, 2.93649),
			Block.box(-1.9, 16.0672, 14.8823, 17.9, 18.0672, 21.5323),
			Block.box(-1.9, 17.34919, -5.75787, 17.9, 19.34919, 0.89213),
			Block.box(-1.9, 15.37327, 6.15852, 17.9, 17.37327, 9.87092),
			Block.box(-1.9, 14.07843, 4.5, 17.9, 16.07843, 11.5),
			Block.box(-2, 12.82843, 0.01472, 18, 14.82843, 16.01472),
			Block.box(-2, 2.82843, 0, 18, 12.82843, 16)
			).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_W = Stream.of(
			Block.box(7, 10.5, -1, 9, 13.5, 0),
			Block.box(6.9, 10.4, -1.1, 9.1, 13.6, 0.1),
			Block.box(-2.25, 0, 14.56351, 1.75, 1, 17.56351),
			Block.box(14.25, 0, 14.56351, 18.25, 1, 17.56351),
			Block.box(14.25, 0, -1.56351, 18.25, 1, 1.43649),
			Block.box(-2.25, 0, -1.56351, 1.75, 1, 1.43649),
			Block.box(-1.75, -2.53752, 13.06351, 1.25, 1.46248, 15.06351),
			Block.box(14.75, -2.53752, 13.06351, 17.75, 1.46248, 15.06351),
			Block.box(14.75, -2.53752, 0.93649, 17.75, 1.46248, 2.93649),
			Block.box(-1.75, -2.53752, 0.93649, 1.25, 1.46248, 2.93649),
			Block.box(-1.9, 16.0672, 14.8823, 17.9, 18.0672, 21.5323),
			Block.box(-1.9, 17.34919, -5.75787, 17.9, 19.34919, 0.89213),
			Block.box(-1.9, 15.37327, 6.15852, 17.9, 17.37327, 9.87092),
			Block.box(-1.9, 14.07843, 4.5, 17.9, 16.07843, 11.5),
			Block.box(-2, 12.82843, 0.01472, 18, 14.82843, 16.01472),
			Block.box(-2, 2.82843, 0, 18, 12.82843, 16)
			).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_S = Stream.of(
			Block.box(7, 10.5, -1, 9, 13.5, 0),
			Block.box(6.9, 10.4, -1.1, 9.1, 13.6, 0.1),
			Block.box(-2.25, 0, 14.56351, 1.75, 1, 17.56351),
			Block.box(14.25, 0, 14.56351, 18.25, 1, 17.56351),
			Block.box(14.25, 0, -1.56351, 18.25, 1, 1.43649),
			Block.box(-2.25, 0, -1.56351, 1.75, 1, 1.43649),
			Block.box(-1.75, -2.53752, 13.06351, 1.25, 1.46248, 15.06351),
			Block.box(14.75, -2.53752, 13.06351, 17.75, 1.46248, 15.06351),
			Block.box(14.75, -2.53752, 0.93649, 17.75, 1.46248, 2.93649),
			Block.box(-1.75, -2.53752, 0.93649, 1.25, 1.46248, 2.93649),
			Block.box(-1.9, 16.0672, 14.8823, 17.9, 18.0672, 21.5323),
			Block.box(-1.9, 17.34919, -5.75787, 17.9, 19.34919, 0.89213),
			Block.box(-1.9, 15.37327, 6.15852, 17.9, 17.37327, 9.87092),
			Block.box(-1.9, 14.07843, 4.5, 17.9, 16.07843, 11.5),
			Block.box(-2, 12.82843, 0.01472, 18, 14.82843, 16.01472),
			Block.box(-2, 2.82843, 0, 18, 12.82843, 16)
			).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_E = Stream.of(
			Block.box(7, 10.5, -1, 9, 13.5, 0),
			Block.box(6.9, 10.4, -1.1, 9.1, 13.6, 0.1),
			Block.box(-2.25, 0, 14.56351, 1.75, 1, 17.56351),
			Block.box(14.25, 0, 14.56351, 18.25, 1, 17.56351),
			Block.box(14.25, 0, -1.56351, 18.25, 1, 1.43649),
			Block.box(-2.25, 0, -1.56351, 1.75, 1, 1.43649),
			Block.box(-1.75, -2.53752, 13.06351, 1.25, 1.46248, 15.06351),
			Block.box(14.75, -2.53752, 13.06351, 17.75, 1.46248, 15.06351),
			Block.box(14.75, -2.53752, 0.93649, 17.75, 1.46248, 2.93649),
			Block.box(-1.75, -2.53752, 0.93649, 1.25, 1.46248, 2.93649),
			Block.box(-1.9, 16.0672, 14.8823, 17.9, 18.0672, 21.5323),
			Block.box(-1.9, 17.34919, -5.75787, 17.9, 19.34919, 0.89213),
			Block.box(-1.9, 15.37327, 6.15852, 17.9, 17.37327, 9.87092),
			Block.box(-1.9, 14.07843, 4.5, 17.9, 16.07843, 11.5),
			Block.box(-2, 12.82843, 0.01472, 18, 14.82843, 16.01472),
			Block.box(-2, 2.82843, 0, 18, 12.82843, 16)
			).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();
	
	public PandorsBox(Properties properties) 
	{
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
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult result) {
		  if (!worldIn.isClientSide()) {
			  LightningBoltEntity lightningboltentity = EntityType.LIGHTNING_BOLT.create(worldIn);
			  lightningboltentity.moveTo(Vector3d.atBottomCenterOf(pos));
			  lightningboltentity.setVisualOnly(false);
			  worldIn.addFreshEntity(lightningboltentity);
		  }
		return ActionResultType.SUCCESS;
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
	