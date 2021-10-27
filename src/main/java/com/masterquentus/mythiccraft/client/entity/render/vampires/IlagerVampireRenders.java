package com.masterquentus.mythiccraft.client.entity.render.vampires;

import com.masterquentus.mythiccraft.client.entity.model.vampires.IlagerVampireModels;
import com.masterquentus.mythiccraft.entities.vampire.IlagerTypes;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

/**
 * \* User: Evanechecssss \* https://bio.link/evanechecssss \* Data: 01.10.2021
 * \* Description: \
 */
public class IlagerVampireRenders<T extends LivingEntity & IAnimatable> extends GeoEntityRenderer<T> {
	public IlagerVampireRenders(EntityRendererManager renderManager, IlagerTypes types) {
		super(renderManager, new IlagerVampireModels<T>(types));

	}

	@Override
	public RenderType getRenderType(T animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}