package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.init.BlockInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

public class ModLogBlock extends RotatedPillarBlock {
    private final boolean isStripped;

    public ModLogBlock(MaterialColor verticalColorIn) {
        this(verticalColorIn, false);
    }

    public ModLogBlock(MaterialColor verticalColorIn, boolean isStripped) {
	    super(AbstractBlock.Properties.of(Material.WOOD, (p_235431_2_) -> {
            return p_235431_2_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? verticalColorIn : MaterialColor.WOOD;
        }));
	    this.isStripped = isStripped;
	}

    @SuppressWarnings("deprecation")
	@Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        Item held = player.getItemInHand(handIn).getItem();
        if (held instanceof AxeItem && !this.isStripped){
            BlockState newState = this.defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
            worldIn.setBlockAndUpdate(pos, newState);
            worldIn.playSound(player, pos, SoundEvents.AXE_STRIP, SoundCategory.BLOCKS, 0.7F, 1F);
            return ActionResultType.SUCCESS;
        }
        return super.use(state, worldIn, pos, player, handIn, hit);
    }	

}
