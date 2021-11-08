package com.masterquentus.mythiccraft.client.entity.model;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.entities.WendigoEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 07.11.2021
 * \* Description:
 * \
 */
public class WendigoEntityModel extends AnimatedGeoModel<WendigoEntity> {

    @Override
    public ResourceLocation getModelLocation(WendigoEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "geo/wendigo.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(WendigoEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/wendigo.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(WendigoEntity entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, "animations/wendigo.json");
    }
}