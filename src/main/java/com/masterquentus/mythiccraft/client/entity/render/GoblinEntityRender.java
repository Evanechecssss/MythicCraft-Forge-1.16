package com.masterquentus.mythiccraft.client.entity.render;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.client.entity.model.GoblinEntityModel;
import com.masterquentus.mythiccraft.entities.GoblinEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GoblinEntityRender extends MobRenderer<GoblinEntity, GoblinEntityModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/goblin_entity.png");

	public GoblinEntityRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new GoblinEntityModel(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(GoblinEntity entity) {
		return TEXTURE;
	}
}