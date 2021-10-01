package com.masterquentus.mythiccraft.entities.vampire;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 30.09.2021
 * \* Description:
 * \
 */
public class VampirePillagerEntity extends PillagerEntity implements IAnimatable {

    public VampirePillagerEntity(EntityType<? extends PillagerEntity> p_i50198_1_, World p_i50198_2_) {
        super(p_i50198_1_, p_i50198_2_);
    }

    @Override
    public void registerControllers(AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
        return null;
    }
}