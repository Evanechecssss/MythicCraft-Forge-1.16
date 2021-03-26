package com.masterquentus.mythiccraft.client.entity.render;

import com.masterquentus.mythiccraft.client.entity.model.BasiliskEntityModel;
import com.masterquentus.mythiccraft.entities.BasiliskEntity;
import net.minecraft.client.renderer.RenderType;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BasiliskEntityRender extends GeoEntityRenderer<BasiliskEntity>
{
	public BasiliskEntityRender(EntityRendererManager renderManager)
	{
		super(renderManager, new BasiliskEntityModel());
	}

	@Override
	public RenderType getRenderType(BasiliskEntity animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation)
	{
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}
}