package com.masterquentus.mythiccraft.client.entity.model;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.entities.UnderwaterSlimeEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 28.10.2021
 * \* Description:
 * \
 */
public class UnderwaterSlimeModel extends AnimatedGeoModel<UnderwaterSlimeEntity> {
    @Override
    public ResourceLocation getModelLocation(UnderwaterSlimeEntity underwaterSlimeEntity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "geo/underwater_slime.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(UnderwaterSlimeEntity underwaterSlimeEntity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/underwater_slime.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(UnderwaterSlimeEntity underwaterSlimeEntity) {
        return new ResourceLocation(MythicCraft.MOD_ID,"animations/underwater_slime.json");
    }
}