package com.masterquentus.mythiccraft.client.entity.model;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.entities.GoblinEntity;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GoblinEntityModel extends AnimatedGeoModel<GoblinEntity>
{
    @Override
    public ResourceLocation getModelLocation(GoblinEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "geo/goblin.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GoblinEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/goblin_entity.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GoblinEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "animations/goblin_entity.json");
    }
}