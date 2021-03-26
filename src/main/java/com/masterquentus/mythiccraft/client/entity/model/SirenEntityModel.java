package com.masterquentus.mythiccraft.client.entity.model;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.entities.SirenEntity;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SirenEntityModel extends AnimatedGeoModel<SirenEntity>
{
    @Override
    public ResourceLocation getModelLocation(SirenEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "geo/siren.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SirenEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/siren_entity.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SirenEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "animations/siren_entity.json");
    }
}