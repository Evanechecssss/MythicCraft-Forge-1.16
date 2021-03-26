package com.masterquentus.mythiccraft.objects.blocks;

import java.util.function.Predicate;

import com.masterquentus.mythiccraft.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class ModLogStrippable extends LogBlock {

	public ModLogStrippable(MaterialColor color, Properties properties) {
		super(color, properties);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (player.getHeldItem(handIn) != null) {
			Item item = player.getHeldItem(handIn).getItem();
			if (item == Items.DIAMOND_AXE || item == Items.IRON_AXE || item == Items.GOLDEN_AXE
					|| item == Items.WOODEN_AXE || item == Items.STONE_AXE) {
				worldIn.hasBlockState(pos, (Predicate<BlockState>) BlockInit.bloodoak_stripped_log.get());
				worldIn.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 0.7F, 1F);
			}
		}
		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}
}