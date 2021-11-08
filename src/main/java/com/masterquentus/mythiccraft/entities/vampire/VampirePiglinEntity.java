package com.masterquentus.mythiccraft.entities.vampire;

import com.masterquentus.mythiccraft.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 01.11.2021
 * \* Description:
 * \
 */
public class VampirePiglinEntity extends PiglinEntity implements IAnimatable {
    private AnimationTypes currentAnimation;

    public VampirePiglinEntity(EntityType<? extends AbstractPiglinEntity> p_i231570_1_, World p_i231570_2_) {
        super(p_i231570_1_, p_i231570_2_);
        currentAnimation = AnimationTypes.IDLE;

    }



    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @OnlyIn(Dist.CLIENT)
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.getController().getCurrentAnimation() == null) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation(AnimationTypes.IDLE.registerName, true));
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation(currentAnimation.registerName, currentAnimation.loop));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    private AnimationFactory factory = new AnimationFactory(this);

    public AnimationTypes getCurrentAnimation() {
        return currentAnimation;
    }

    public void setCurrentAnimation(AnimationTypes animationType) {
        this.currentAnimation = animationType;
    }

    public enum AnimationTypes {
        IDLE("animation.piglin.idle", true),
        ATACK("animation.piglin.fight", false);
        private String registerName;
        private boolean loop;

        AnimationTypes(String string, boolean loop) {
            this.registerName = string;
            this.loop = loop;
        }
    }
}