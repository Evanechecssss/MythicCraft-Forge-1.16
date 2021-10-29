package com.masterquentus.mythiccraft.entities;

import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Random;

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 28.10.2021
 * \* Description:
 * \
 */
public class UnderwaterSlime extends SlimeEntity implements IAnimatable, IMob {

    private AnimationTypes currentAnimation;
    protected final SwimmerPathNavigator waterNavigation;

    public UnderwaterSlime(EntityType<? extends SlimeEntity> p_i48565_1_, World p_i48565_2_) {
        super(p_i48565_1_, p_i48565_2_);
        currentAnimation = AnimationTypes.IDLE;
        this.waterNavigation = new SwimmerPathNavigator(this, p_i48565_2_);
    }
    @Override
    public EntitySize getDimensions(Pose p_213305_1_) {
        Entity entity = new SlimeEntity(EntityType.SLIME,this.level);
        return entity.getDimensions(p_213305_1_).scale(4F *  0.25F * (float)this.getSize());
    }

    @Override
    public boolean isPushedByFluid() {
        return !this.isSwimming();
    }
    @Override
    public void updateSwimming() {
        if (!this.level.isClientSide) {
            if (this.isEffectiveAi() && this.isInWater() && this.wantsToSwim()) {
                this.navigation = this.waterNavigation;
                this.setSwimming(true);
            }
        }

    }

    private boolean wantsToSwim() {
        LivingEntity livingentity = this.getTarget();
        return livingentity != null && livingentity.isInWater();
    }

    /*Spawn*/
    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 1.1D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MAX_HEALTH, 48.0D);
    }

    /*Animations*/

    private AnimationFactory factory = new AnimationFactory(this);

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean rideableUnderWater() {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.getController().getCurrentAnimation() == null) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation(AnimationTypes.IDLE.getRegistryName(), true));
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation(currentAnimation.getRegistryName(), currentAnimation.shouldLoop()));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    public enum AnimationTypes {
        IDLE("animation.slime.idle", true),
        JUMP("animation.slime.jump", false);
        private String path;
        private boolean loop;

        AnimationTypes(String path, boolean loop) {
            this.path = path;
            this.loop = loop;
        }

        public String getRegistryName() {
            return path;
        }

        public Boolean shouldLoop() {
            return loop;
        }
    }

}