package com.masterquentus.mythiccraft.objects.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class WaterCropItem extends BlockNamedItem {
    public WaterCropItem(Block crop, Item.Properties props) {
        super(crop, props);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        // if (worldIn.isRemote()) return ActionResult.resultPass(stack);

        RayTraceResult ray = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);

        if (ray.getType() != RayTraceResult.Type.BLOCK) {
            return ActionResult.resultPass(stack);
        } else {
            BlockRayTraceResult blockRay = (BlockRayTraceResult) ray;

            BlockPos hitPos = ((BlockRayTraceResult) ray).getPos();
            Direction direction = blockRay.getFace();
            BlockPos plantPos = hitPos.offset(direction);

            if (worldIn.getBlockState(hitPos).getBlock() == Blocks.WATER && direction == Direction.UP && worldIn.getBlockState(plantPos).isAir()){
                BlockState state = this.getBlock().getDefaultState();
                worldIn.setBlockState(plantPos, state);
                if (!playerIn.isCreative()) stack.shrink(1);
                return ActionResult.resultSuccess(stack);
            } else {
                return ActionResult.resultPass(stack);
            }
        }
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        ActionResult<ItemStack> result = this.onItemRightClick(context.getWorld(), context.getPlayer(), context.getHand());
        return result.getType();
    }
}
