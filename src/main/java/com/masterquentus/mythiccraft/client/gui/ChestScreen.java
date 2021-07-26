package com.masterquentus.mythiccraft.client.gui;

import com.masterquentus.mythiccraft.MythicCraft;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChestScreen extends ContainerScreen<Container> {
	// if you want them to have uniue backgrounds, dont just copy this class over and over. instead, add a parameter to the constructor
	private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(MythicCraft.MOD_ID, "textures/gui/chest.png");

	public ChestScreen(Container screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		this.leftPos = 0;
		this.topPos = 0;
		this.imageWidth = 175;
		this.imageHeight = 183;
	}
	
	@Override
	public void render(MatrixStack stack, final int mouseX, final int mouseY, final float partialTicks) {
		super.render(stack, mouseX, mouseY, partialTicks);
		// this.renderHoveredToolTip(mouseX, mouseY);
}
	
	@Override
	protected void renderLabels(MatrixStack stack, int p_230451_2_, int p_230451_3_) {
		this.font.draw(stack, this.title, 8.0f, 6.0f, 4210752);
		this.font.draw(stack, this.inventory.getDisplayName(), 8.0f, 90.0f, 4210752);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected void renderBg(MatrixStack stack, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.minecraft.getTextureManager().bind(BACKGROUND_TEXTURE);
		int x = (this.width - this.imageWidth) / 2;
		int y = (this.height - this.imageHeight) / 2;
		this.blit(stack, x, y, 0, 0, this.imageWidth, this.imageHeight);
	}
}
