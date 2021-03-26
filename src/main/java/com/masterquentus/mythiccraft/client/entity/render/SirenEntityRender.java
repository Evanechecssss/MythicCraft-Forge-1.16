package com.masterquentus.mythiccraft.client.entity.render;

import com.masterquentus.mythiccraft.client.entity.model.SirenEntityModel;
import com.masterquentus.mythiccraft.entities.SirenEntity;

import net.minecraft.client.renderer.RenderType;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SirenEntityRender extends GeoEntityRenderer<SirenEntity>
{
	public SirenEntityRender(EntityRendererManager renderManager)
	{
		super(renderManager, new SirenEntityModel());
	}

	@Override
	public RenderType getRenderType(SirenEntity animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation)
	{
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}
}