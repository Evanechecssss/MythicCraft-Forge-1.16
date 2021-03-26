package com.masterquentus.mythiccraft.client.entity.model;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.entities.FairyEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FairyEntityModel extends AnimatedGeoModel<FairyEntity>
{
    @Override
    public ResourceLocation getModelLocation(FairyEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "geo/fairy.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(FairyEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/fairy_entity.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(FairyEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "animations/fairy_entity.json");
    }
}