package com.masterquentus.mythiccraft.objects.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class TotemOfTeleportationItem extends Item {

	public TotemOfTeleportationItem(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public boolean isFoil(ItemStack stack) {
		return true;
	}
	
	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if(!playerIn.getCooldowns().isOnCooldown(this)) {
			playerIn.addEffect(new EffectInstance(Effects.NIGHT_VISION, 6000, 2555));
			playerIn.getCooldowns().addCooldown(this, 800);
			return ActionResult.success(playerIn.getItemInHand(handIn));
		}
	
		return ActionResult.fail(playerIn.getItemInHand(handIn));
	}
}