package com.masterquentus.mythiccraft.container;

import com.masterquentus.mythiccraft.init.ModContainerTypes;
import com.masterquentus.mythiccraft.objects.items.crafting.ModRecipeSerializers;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.util.IIntArray;

public class WitchesOvenContainer extends AbstractWitchesOvenContainer {
	public WitchesOvenContainer(int id, PlayerInventory playerInventoryIn) {
		super(ModContainerTypes.WITCHES_OVEN_CONTAINER.get(), ModRecipeSerializers.WITCHES_RECIPE, RecipeBookCategory.FURNACE, id, playerInventoryIn);

	}

	public WitchesOvenContainer(int p_i50083_1_, PlayerInventory p_i50083_2_, IInventory p_i50083_3_,
			IIntArray p_i50083_4_) {
		super(ModContainerTypes.WITCHES_OVEN_CONTAINER.get(), ModRecipeSerializers.WITCHES_RECIPE, RecipeBookCategory.FURNACE, p_i50083_1_, p_i50083_2_,
				p_i50083_3_, p_i50083_4_);
	}

}
