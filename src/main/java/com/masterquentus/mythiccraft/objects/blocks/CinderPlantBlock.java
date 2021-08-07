package com.masterquentus.mythiccraft.objects.blocks;

import java.util.Random;

import com.masterquentus.mythiccraft.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CinderPlantBlock extends SweetBerryBushBlock implements IGrowable
{
	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
	   public static final VoxelShape field_220126_b = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
	   public static final VoxelShape field_220127_c = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
	   public final IParticleData flameParticle;

	   public CinderPlantBlock(Properties properties, IParticleData particle) {
	      super(properties);
	      this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
	      this.flameParticle = particle;
	   }

	   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	      if (state.getValue(AGE) == 0) {
	         return field_220126_b;
	      } else {
	         return state.getValue(AGE) < 3 ? field_220127_c : super.getShape(state, worldIn, pos, context);
	      }
	   }
	   
	   @SuppressWarnings("deprecation")
	public void tick(BlockState p_225534_1_, ServerWorld p_225534_2_, BlockPos p_225534_3_, Random p_225534_4_) {
	      super.tick(p_225534_1_, p_225534_2_, p_225534_3_, p_225534_4_);
	      int i = p_225534_1_.getValue(AGE);
	      if (i < 3 && p_225534_2_.getRawBrightness(p_225534_3_.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(p_225534_2_, p_225534_3_, p_225534_1_, p_225534_4_.nextInt(5) == 0)) {
	         p_225534_2_.setBlock(p_225534_3_, p_225534_1_.setValue(AGE, Integer.valueOf(i + 1)), 2);
	         net.minecraftforge.common.ForgeHooks.onCropsGrowPost(p_225534_2_, p_225534_3_, p_225534_1_);
	      }

	   }

	   @Override
	   public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
	      int i = p_225533_1_.getValue(AGE);
	      boolean flag = i == 3;
	      if (!flag && p_225533_4_.getItemInHand(p_225533_5_).getItem() == Items.BONE_MEAL) {
	         return ActionResultType.PASS;
	      } else if (i > 1) {
	         int j = 1 + p_225533_2_.random.nextInt(2);
			  popResource(p_225533_2_, p_225533_3_, new ItemStack(this.asItem(), j + (flag ? 1 : 0)));
	         p_225533_2_.playSound((PlayerEntity)null, p_225533_3_, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + p_225533_2_.random.nextFloat() * 0.4F);
	         p_225533_2_.setBlock(p_225533_3_, p_225533_1_.setValue(AGE, Integer.valueOf(1)), 2);
	         return ActionResultType.SUCCESS;
	      } else {
	         return super.use(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);
	      }
	   }

	   public void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	      builder.add(AGE);
	   }


	@Override
	   public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
	      return state.getValue(AGE) < 3;
	   }

	@Override
	   public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) {
	      return true;
	   }

	   @Override
	   public void performBonemeal(ServerWorld p_225535_1_, Random p_225535_2_, BlockPos p_225535_3_, BlockState p_225535_4_) {
	      int i = Math.min(3, p_225535_4_.getValue(AGE) + 1);
	      p_225535_1_.setBlock(p_225535_3_, p_225535_4_.setValue(AGE, Integer.valueOf(i)), 2);
	   }
	   
	   public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
			entityIn.setSecondsOnFire(10);

		}
		
		@Override
		public void catchFire(BlockState state, World world, BlockPos pos, Direction face, LivingEntity igniter) {
			super.catchFire(state, world, pos, face, igniter);
		}
		
		@OnlyIn(Dist.CLIENT)
		   public void animateTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
		      double d0 = (double)p_180655_3_.getX() + 0.5D;
		      double d1 = (double)p_180655_3_.getY() + 0.7D;
		      double d2 = (double)p_180655_3_.getZ() + 0.5D;
		      p_180655_2_.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		      p_180655_2_.addParticle(this.flameParticle, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		      
		}
		
		@Override
		public boolean isFireSource(BlockState state, IWorldReader world, BlockPos pos, Direction side) {
			return super.isFireSource(state, world, pos, side);
		}
	   
	   @Override
	    public ItemStack getCloneItemStack(IBlockReader p_1854731, BlockPos p_1854732, BlockState p_1854733) {
	        return new ItemStack(ItemInit.CINDER_FRUIT.get());
	   }
}