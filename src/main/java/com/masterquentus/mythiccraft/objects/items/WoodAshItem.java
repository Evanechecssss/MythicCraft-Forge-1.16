package com.masterquentus.mythiccraft.objects.items;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WoodAshItem extends Item 
{

	public WoodAshItem(Properties properties) 
	{
		super(properties);
	
	
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 100;
	}
}
