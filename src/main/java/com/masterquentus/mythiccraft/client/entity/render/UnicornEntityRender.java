package com.masterquentus.mythiccraft.client.entity.render;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.client.entity.model.UnicornEntityModel;
import com.masterquentus.mythiccraft.entities.UnicornEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class UnicornEntityRender extends MobRenderer<UnicornEntity, UnicornEntityModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/unicorn_entity.png");

	public UnicornEntityRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new UnicornEntityModel(), 1.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(UnicornEntity entity) {
		return TEXTURE;
	}
}