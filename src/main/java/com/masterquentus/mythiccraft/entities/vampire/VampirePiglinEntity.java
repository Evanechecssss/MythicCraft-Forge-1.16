package com.masterquentus.mythiccraft.entities.vampire;

import com.google.common.collect.ImmutableList;
import com.masterquentus.mythiccraft.entities.ai.ModMemoryModuleType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 01.11.2021
 * \* Description:
 * \
 */
public class VampirePiglinEntity extends PiglinEntity implements IAnimatable {
    private AnimationTypes currentAnimation;
    protected static final ImmutableList<MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(ModMemoryModuleType.NEAREST_TARGETABLE_PLAYER_NOT_WEARING_VAMPIRE_ARMORE,MemoryModuleType.LOOK_TARGET, MemoryModuleType.DOORS_TO_CLOSE, MemoryModuleType.LIVING_ENTITIES, MemoryModuleType.VISIBLE_LIVING_ENTITIES, MemoryModuleType.NEAREST_VISIBLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_ADULT_PIGLINS, MemoryModuleType.NEARBY_ADULT_PIGLINS, MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM, MemoryModuleType.HURT_BY, MemoryModuleType.HURT_BY_ENTITY, MemoryModuleType.WALK_TARGET, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.ATTACK_TARGET, MemoryModuleType.ATTACK_COOLING_DOWN, MemoryModuleType.INTERACTION_TARGET, MemoryModuleType.PATH, MemoryModuleType.ANGRY_AT, MemoryModuleType.UNIVERSAL_ANGER, MemoryModuleType.AVOID_TARGET, MemoryModuleType.ADMIRING_ITEM, MemoryModuleType.TIME_TRYING_TO_REACH_ADMIRE_ITEM, MemoryModuleType.ADMIRING_DISABLED, MemoryModuleType.DISABLE_WALK_TO_ADMIRE_ITEM, MemoryModuleType.CELEBRATE_LOCATION, MemoryModuleType.DANCING, MemoryModuleType.HUNTED_RECENTLY, MemoryModuleType.NEAREST_VISIBLE_BABY_HOGLIN, MemoryModuleType.NEAREST_VISIBLE_NEMESIS, MemoryModuleType.NEAREST_VISIBLE_ZOMBIFIED, MemoryModuleType.RIDE_TARGET, MemoryModuleType.VISIBLE_ADULT_PIGLIN_COUNT, MemoryModuleType.VISIBLE_ADULT_HOGLIN_COUNT, MemoryModuleType.NEAREST_VISIBLE_HUNTABLE_HOGLIN, MemoryModuleType.NEAREST_TARGETABLE_PLAYER_NOT_WEARING_GOLD, MemoryModuleType.NEAREST_PLAYER_HOLDING_WANTED_ITEM, MemoryModuleType.ATE_RECENTLY, MemoryModuleType.NEAREST_REPELLENT);

    public VampirePiglinEntity(EntityType<? extends AbstractPiglinEntity> p_i231570_1_, World p_i231570_2_) {
        super(p_i231570_1_, p_i231570_2_);
        currentAnimation = AnimationTypes.IDLE;

    }
    @Override
    protected Brain.BrainCodec<PiglinEntity> brainProvider() {
        return Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
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