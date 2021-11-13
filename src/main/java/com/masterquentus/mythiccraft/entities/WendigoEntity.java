package com.masterquentus.mythiccraft.entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
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
 * \* Data: 07.11.2021
 * \* Description:
 * \
 */
public class WendigoEntity extends MonsterEntity implements IAnimatable {
    public WendigoEntity(EntityType<? extends MonsterEntity> p_i48575_1_, World p_i48575_2_) {
        super(p_i48575_1_, p_i48575_2_);
        currentAnimationFoot = AnimationTypes.IDLE;
        currentAnimation = AnimationTypes.IDLE;
        this.setAggressive(true);
    }
    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 300)
                .add(Attributes.MOVEMENT_SPEED, 0.33D).add(Attributes.FOLLOW_RANGE, 35)
                .add(Attributes.ARMOR_TOUGHNESS, 10D).add(Attributes.ATTACK_DAMAGE, 15)
                .add(Attributes.KNOCKBACK_RESISTANCE,10).add(Attributes.ATTACK_DAMAGE, 15);
    }

    /*AI*/
    protected boolean isAttacking = false;
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new WendigoMellAttack(this, 1.2, false));
        this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(5, new SwimGoal(this));

    }
    @Override
    public void tick() {
        if (this.isInWater()){
            this.setCurrentAnimation(AnimationTypes.SWIM);
        }
        if (isAttacking){
            this.setCurrentAnimation(AnimationTypes.ATACK);
        }

        super.tick();
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.POLAR_BEAR_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.POLAR_BEAR_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.POLAR_BEAR_DEATH;
    }
    private void setAttacking(boolean b) {
        this.isAttacking = b;
    }
    protected SoundEvent getStepSound() {
        return SoundEvents.POLAR_BEAR_STEP;
    }
    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    public boolean attacked(DamageSource source, float amount) {
        if (source.getEntity() instanceof ArrowEntity)
            return false;
        if (source == DamageSource.FALL)
            return false;
        if (source == DamageSource.CACTUS)
            return false;
        if (source.isExplosion())
            return false;
        if (source == DamageSource.ANVIL)
            return false;
        return true;
    }

    protected class WendigoMellAttack extends MeleeAttackGoal{
        private WendigoEntity p_i1636_1_;
        public WendigoMellAttack(WendigoEntity p_i1636_1_, double p_i1636_2_, boolean p_i1636_4_) {
            super(p_i1636_1_, p_i1636_2_, p_i1636_4_);
            this.p_i1636_1_ = p_i1636_1_;

        }

        @Override
        public void start() {
            super.start();
            p_i1636_1_.setAttacking(true);
        }

        @Override
        public void stop() {
            super.stop();
            p_i1636_1_.setAttacking(true);
        }
    }




    /*Animations*/
    private AnimationTypes currentAnimation;
    private AnimationTypes currentAnimationFoot;
    private AnimationFactory factory = new AnimationFactory(this);
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controllerT", 0, this::predicate));
        data.addAnimationController(new AnimationController(this, "controllerF", 0, this::predicateFoot));
    }
    @OnlyIn(Dist.CLIENT)
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation(currentAnimation.registerName, currentAnimation.loop));
        return PlayState.CONTINUE;
    }
    @OnlyIn(Dist.CLIENT)
    private <E extends IAnimatable> PlayState predicateFoot(AnimationEvent<E> event) {
        boolean isWalking = !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F);
        if (isWalking){
            setCurrentAnimationFoot(AnimationTypes.WALK);
        }else {
            setCurrentAnimationFoot(AnimationTypes.IDLE);
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation(currentAnimationFoot.registerName, currentAnimationFoot.loop));
        return PlayState.CONTINUE;
    }



    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
    public AnimationTypes getCurrentAnimation() {
        return currentAnimation;
    }
    public AnimationTypes getCurrentAnimationFoot() {
        return currentAnimationFoot;
    }
    public void setCurrentAnimation(AnimationTypes animationType) {
        this.currentAnimation = animationType;
    }
    public void setCurrentAnimationFoot(AnimationTypes animationType) {
        this.currentAnimationFoot = animationType;
    }
    public enum AnimationTypes {
        IDLE("animation.wendigo.idle", true),
        WALK("animation.wendigo.walk",true),
        ATACK("animation.wendigo.attack", true),
        SWIM("animation.wendigo.swim",true);
        private String registerName;
        private boolean loop;
        AnimationTypes(String string, boolean loop) {
            this.registerName = string;
            this.loop = loop;
        }
    }

}