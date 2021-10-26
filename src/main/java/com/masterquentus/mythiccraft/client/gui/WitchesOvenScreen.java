package com.masterquentus.mythiccraft.client.gui;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.container.WitchesOvenContainer;

import net.minecraft.client.gui.recipebook.FurnaceRecipeGui;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class WitchesOvenScreen extends AbstractWitchesOvenScreen<WitchesOvenContainer>{
	private static final ResourceLocation WITCHESOVEN_GUI_TEXTURES
    = new ResourceLocation(MythicCraft.MOD_ID, "textures/gui/witches_oven.png");
	
	public WitchesOvenScreen(WitchesOvenContainer container, PlayerInventory playerInventory, ITextComponent title) {
        super(container, new FurnaceRecipeGui(), playerInventory, title, WITCHESOVEN_GUI_TEXTURES);
    }

}
