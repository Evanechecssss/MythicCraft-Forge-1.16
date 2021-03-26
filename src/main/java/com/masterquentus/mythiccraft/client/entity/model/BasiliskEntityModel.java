package com.masterquentus.mythiccraft.client.entity.model;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.entities.BasiliskEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BasiliskEntityModel extends AnimatedGeoModel<BasiliskEntity>
{
    @Override
    public ResourceLocation getModelLocation(BasiliskEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "geo/basilisk.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(BasiliskEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/basilisk_entity.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(BasiliskEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "animations/basilisk_entity.json");
    }
}