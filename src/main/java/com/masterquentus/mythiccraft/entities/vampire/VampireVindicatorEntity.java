package com.masterquentus.mythiccraft.entities.vampire;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.vector.Vector3d;
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

import java.util.ArrayList;
import java.util.List;


public class VampireVindicatorEntity extends VindicatorEntity implements IAnimatable, IInfectingable {
    int baseDamage = 3;
    private AnimationTypes currentAnimation;
    public VampireVindicatorEntity(EntityType<? extends VindicatorEntity> p_i50189_1_, World p_i50189_2_) {
        super(p_i50189_1_, p_i50189_2_);
        currentAnimation = AnimationTypes.IDLE;
    }
    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 1.1D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MAX_HEALTH, 48.0D);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide()) {
            if (this.getTarget() != null && this.getRandom().nextInt(60) == 0) {
                this.startAttack();
            }
            if (this.isAttacking()) {
                this.getNavigation().stop();
            }
            if (this.isAttacking()) {
                this.entityData.set(ATTACK_TIME, this.entityData.get(ATTACK_TIME) - 1);
                if (this.entityData.get(ATTACK_TIME) <= 100) {
                    if (this.getRandom().nextInt(10) >= 5) {
                        this.vampireAttack(getTarget());
                        this.vampireAttackMouse(getTarget());
                        this.setCurrentAnimation(AnimationTypes.ATACK);
                        this.fastAttack(getTarget());
                        this.superAttack(getTarget());
                    }
                }
            }
        }
    }


    private AnimationFactory factory = new AnimationFactory(this);

    public AnimationTypes getCurrentAnimation() {
        return currentAnimation;
    }

    public void setCurrentAnimation(AnimationTypes animationType) {
        this.currentAnimation = animationType;
    }

    @OnlyIn(Dist.CLIENT)
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.getController().getCurrentAnimation() == null) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation(AnimationTypes.IDLE.registerName, true));
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation(currentAnimation.registerName, currentAnimation.loop));
        return PlayState.CONTINUE;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public boolean infect(LivingEntity entity) {
        entity.setHealth(entity.getHealth() - 1);
        return true;
    }

    @Override
    public boolean isInfected() {
        return false;
    }

    @Override
    public boolean canBeInfected() {
        return false;
    }

    @Override
    public boolean isInfectSource() {
        return true;
    }

    @Override
    public void getInfection(Object param) {

    }

    private static final DataParameter<Integer> ATTACK_TIME = EntityDataManager.defineId(VampireEvokerEntity.class, DataSerializers.INT);

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACK_TIME, 0);
    }

    public void startAttack() {
        this.entityData.set(ATTACK_TIME, 150);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACK_TIME) > 0;
    }

    private void fastAttack(LivingEntity entity) {
        if (entity != null) {
            entity.setHealth(entity.getHealth() - baseDamage);
            entity.setJumping(true);
            this.startAttack();
        }
    }

    private void vampireAttack(LivingEntity entity) {
        if (entity != null) {
            entity.setHealth(entity.getHealth() - baseDamage);
            entity.addEffect(new EffectInstance(Effects.BLINDNESS, 107));
            this.startAttack();
        }
    }
    private void vampireAttackMouse(LivingEntity entity) {
        if (entity != null) {
            entity.setHealth(entity.getHealth() - baseDamage);
            List<BatEntity> entities = new ArrayList<>();
            for (int i = 0; i<=5; i++) {
                BatEntity bat = EntityType.BAT.create(level);
                bat.moveTo(Vector3d.atBottomCenterOf(this.getTarget().blockPosition()));
                this.level.addFreshEntity(bat);
                entities.add(bat);
            }
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            entities.forEach(batEntity -> {
                                batEntity.setHealth(0);
                            });
                        }
                    },
                    3000
            );
            this.startAttack();
        }
    }



    private void superAttack(LivingEntity entity) {
        if (entity != null) {
            this.setHealth(entity.getHealth() + (baseDamage));
            entity.setHealth(entity.getHealth() - baseDamage);
            this.startAttack();
        }
    }

    private enum AnimationTypes {
        IDLE("animation.model.idle", true),
        WALK("animation.model.walk", true),
        ATACK("animation.model.atack", false);
        private String registerName;
        private boolean loop;

        AnimationTypes(String string, boolean loop) {
            this.registerName = string;
            this.loop = loop;
        }
    }
}