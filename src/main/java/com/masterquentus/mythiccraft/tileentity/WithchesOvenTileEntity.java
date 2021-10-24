package com.masterquentus.mythiccraft.tileentity;

import com.masterquentus.mythiccraft.container.WitchesOvenContainer;
import com.masterquentus.mythiccraft.init.ModTileEntityTypes;
import com.masterquentus.mythiccraft.objects.items.crafting.ModRecipeSerializers;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class WithchesOvenTileEntity extends AbstractFurnaceTileEntity {
	public WithchesOvenTileEntity() {
		this(ModTileEntityTypes.WITCHESOVEN_TILE.get(), ModRecipeSerializers.WITCHES_RECIPE);
	}

	protected WithchesOvenTileEntity(TileEntityType<?> tileTypeIn,
			IRecipeType<? extends AbstractCookingRecipe> recipeTypeIn) {
		super(tileTypeIn, recipeTypeIn);
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("tile.mythiccraft.witchesoven");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new WitchesOvenContainer(id, player, this, this.dataAccess);
	}

}
