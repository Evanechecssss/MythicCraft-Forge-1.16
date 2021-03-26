package com.masterquentus.mythiccraft.client.entity.model;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.entities.LilithEntity;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LilithEntityModel extends AnimatedGeoModel<LilithEntity>
{
    @Override
    public ResourceLocation getModelLocation(LilithEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "geo/lilith.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(LilithEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/lilith_entity.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(LilithEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "animations/lilith_entity.json");
    }
}