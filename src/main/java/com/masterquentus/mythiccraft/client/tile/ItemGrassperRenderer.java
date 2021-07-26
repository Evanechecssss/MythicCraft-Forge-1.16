package com.masterquentus.mythiccraft.client.tile;

import com.masterquentus.mythiccraft.tileentity.GrassperTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;

public class ItemGrassperRenderer extends TileEntityRenderer<GrassperTileEntity> {
    public ItemGrassperRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(GrassperTileEntity tile, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        ItemStack stack = tile.getItem();
        if (!stack.isEmpty()) {
            matrixStackIn.pushPose();
            matrixStackIn.scale(0.5F,0.5F,0.5F);
            float spin = (tile.getLevel().getDayTime() + partialTicks) / 30.0F;
            matrixStackIn.mulPose(Vector3f.YP.rotation(spin));
            Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemCameraTransforms.TransformType.FIXED, combinedLightIn, OverlayTexture.NO_OVERLAY, matrixStackIn, bufferIn);
            matrixStackIn.popPose();
        }
    }
}