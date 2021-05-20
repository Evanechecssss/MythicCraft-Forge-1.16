package com.masterquentus.mythiccraft.client.entity.render;

import com.masterquentus.mythiccraft.client.entity.model.FairyEntityModel;
import com.masterquentus.mythiccraft.entities.FairyEntity;
import net.minecraft.client.renderer.RenderType;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FairyEntityRender extends GeoEntityRenderer<FairyEntity>
{
	public FairyEntityRender(EntityRendererManager renderManager)
	{
		super(renderManager, new FairyEntityModel());
	}

	@Override
	public RenderType getRenderType(FairyEntity animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation)
	{
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}