package com.masterquentus.mythiccraft.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.IRecipeHelperPopulator;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.FurnaceResultSlot;
import net.minecraft.inventory.container.RecipeBookContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.item.crafting.ServerRecipePlacerFurnace;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class AbstractWitchesOvenContainer extends RecipeBookContainer<IInventory> {
	private final IInventory furnaceInventory;
    private final IIntArray furnaceData;
    protected final World world;
    private final IRecipeType<? extends AbstractCookingRecipe> recipeType;
    private final RecipeBookCategory field_242384_g;
    protected final World level;

	public AbstractWitchesOvenContainer(ContainerType<?> p_i241921_1_,
			IRecipeType<? extends AbstractCookingRecipe> p_i241921_2_, RecipeBookCategory p_i241921_3_,
			int p_i241921_4_, PlayerInventory p_i241921_5_) {
		this(p_i241921_1_, p_i241921_2_, p_i241921_3_, p_i241921_4_, p_i241921_5_, new Inventory(3), new IntArray(4));
	}

	public AbstractWitchesOvenContainer(ContainerType<?> containerType,
			IRecipeType<? extends AbstractCookingRecipe> recipeType, RecipeBookCategory recipeBookCategory,
			int id, PlayerInventory playerInventory, IInventory furnaceInventory, IIntArray furnaceData) {
		super(containerType, id);
		this.world = playerInventory.player.level;
        this.recipeType = recipeType;
        this.field_242384_g = recipeBookCategory;
        checkContainerSize(furnaceInventory, 3);
        checkContainerDataCount(furnaceData, 4);
        this.furnaceInventory = furnaceInventory;
        this.furnaceData = furnaceData;
        this.level = playerInventory.player.level;

        this.addSlot(new Slot(furnaceInventory, 0, 56, 17));
        this.addSlot(new Slot(furnaceInventory, 1, 56, 53));
        //this.addSlot(new Slot(furnaceInventory, 0, 83, 53));
        //this.addSlot(new FurnaceResultSlot(playerInventory.player, furnaceInventory, 2, 118, 21));
        this.addSlot(new FurnaceResultSlot(playerInventory.player, furnaceInventory, 2, 118, 53));

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k) {
			this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
		}

		this.addDataSlots(furnaceData);
	}

	public void fillCraftSlotsStackedContents(RecipeItemHelper p_201771_1_) {
		if (this.furnaceInventory instanceof IRecipeHelperPopulator) {
			((IRecipeHelperPopulator) this.furnaceInventory).fillStackedContents(p_201771_1_);
		}

	}

	public void clearCraftingContent() {
		this.furnaceInventory.clearContent();
	}

	@SuppressWarnings("unchecked")
	public void handlePlacement(boolean p_217056_1_, IRecipe<?> p_217056_2_, ServerPlayerEntity p_217056_3_) {
		(new ServerRecipePlacerFurnace<>(this)).recipeClicked(p_217056_3_, (IRecipe<IInventory>) p_217056_2_,
				p_217056_1_);
	}

	public boolean recipeMatches(IRecipe<? super IInventory> p_201769_1_) {
		return p_201769_1_.matches(this.furnaceInventory, this.level);
	}

	public int getResultSlotIndex() {
		return 2;
	}

	public int getGridWidth() {
		return 1;
	}

	public int getGridHeight() {
		return 1;
	}

	@OnlyIn(Dist.CLIENT)
	public int getSize() {
		return 3;
	}

	public boolean stillValid(PlayerEntity p_75145_1_) {
		return this.furnaceInventory.stillValid(p_75145_1_);
	}

	public ItemStack quickMoveStack(PlayerEntity p_82846_1_, int p_82846_2_) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(p_82846_2_);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (p_82846_2_ == 2) {
				if (!this.moveItemStackTo(itemstack1, 3, 39, true)) {
					return ItemStack.EMPTY;
				}

				slot.onQuickCraft(itemstack1, itemstack);
			} else if (p_82846_2_ != 1 && p_82846_2_ != 0) {
				if (this.canSmelt(itemstack1)) {
					if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
						return ItemStack.EMPTY;
					}
				} else if (this.isFuel(itemstack1)) {
					if (!this.moveItemStackTo(itemstack1, 1, 2, false)) {
						return ItemStack.EMPTY;
					}
				} else if (p_82846_2_ >= 3 && p_82846_2_ < 30) {
					if (!this.moveItemStackTo(itemstack1, 30, 39, false)) {
						return ItemStack.EMPTY;
					}
				} else if (p_82846_2_ >= 30 && p_82846_2_ < 39 && !this.moveItemStackTo(itemstack1, 3, 30, false)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.moveItemStackTo(itemstack1, 3, 39, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(p_82846_1_, itemstack1);
		}

		return itemstack;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected boolean canSmelt(ItemStack p_217057_1_) {
		return this.level.getRecipeManager()
				.getRecipeFor((IRecipeType) this.recipeType, new Inventory(p_217057_1_), this.level).isPresent();
	}

	protected boolean isFuel(ItemStack p_217058_1_) {
		return AbstractFurnaceTileEntity.isFuel(p_217058_1_);
	}

	@OnlyIn(Dist.CLIENT)
	   public int getBurnProgress() {
	      int i = this.furnaceData.get(2);
	      int j = this.furnaceData.get(3);
	      return j != 0 && i != 0 ? i * 24 / j : 0;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public int getLitProgress() {
	      int i = this.furnaceData.get(1);
	      if (i == 0) {
	         i = 200;
	      }

	      return this.furnaceData.get(0) * 13 / i;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public boolean isLit() {
	      return this.furnaceData.get(0) > 0;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public RecipeBookCategory getRecipeBookType() {
	      return this.field_242384_g;
	   }
	}