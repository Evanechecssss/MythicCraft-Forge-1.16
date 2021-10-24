package com.masterquentus.mythiccraft.objects.items.crafting;

import com.masterquentus.mythiccraft.init.BlockInit;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

	public class WitchesOvenRecipe extends AbstractCookingRecipe {
    public WitchesOvenRecipe(ResourceLocation id, String group, Ingredient ingredient,
            ItemStack result, float experience, int cookTime) {
super(ModRecipeSerializers.WITCHES_RECIPE, id, group, ingredient, result, experience, cookTime);
	}
	
	public ItemStack getIcon() {
        return new ItemStack(BlockInit.WITCHES_OVEN.get());
    }

	@Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.WITCHES_SMELTING.get();
    }


}
