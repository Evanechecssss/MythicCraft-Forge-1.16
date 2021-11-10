package com.masterquentus.mythiccraft.client.entity.model.vampires;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.entities.vampire.VampireTypes;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IlagerVampireModels<T extends Entity & IAnimatable> extends AnimatedGeoModel<T> {
    private VampireTypes types;

    public IlagerVampireModels(VampireTypes types) {
        this.types = types;
    }

    @Override
    public ResourceLocation getModelLocation(T entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, String.format("geo/vampires/%s.geo.json", types.getName()));
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, String.format("textures/entity/vampires/%s.png", types.getName()));
    }

    @Override
    public ResourceLocation getAnimationFileLocation(T entity) {
        return new ResourceLocation(MythicCraft.MOD_ID, String.format("animations/vampires/%s.json", types.getName()));
    }
}