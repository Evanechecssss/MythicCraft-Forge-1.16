package com.masterquentus.mythiccraft.client.entity.render;

import com.masterquentus.mythiccraft.client.entity.model.UnderwaterSlimeModel;
import com.masterquentus.mythiccraft.entities.UnderwaterSlimeEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 28.10.2021
 * \* Description:
 * \
 */
public class UnderwaterSlimeRender extends GeoEntityRenderer<UnderwaterSlimeEntity> {
    public UnderwaterSlimeRender(EntityRendererManager renderManager) {
        super(renderManager, new UnderwaterSlimeModel());
    }

    @Override
    public RenderType getRenderType(UnderwaterSlimeEntity animatable, float partialTicks, MatrixStack stack, @Nullable IRenderTypeBuffer renderTypeBuffer, @Nullable IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {

        stack.scale(4 *  0.25F * (float)animatable.getSize(),4 *  0.25F * (float)animatable.getSize(),4 *  0.25F * (float)animatable.getSize());
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }

}