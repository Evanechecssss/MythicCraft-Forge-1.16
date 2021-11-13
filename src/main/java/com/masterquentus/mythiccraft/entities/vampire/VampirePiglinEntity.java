package com.masterquentus.mythiccraft.entities.vampire;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
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

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 01.11.2021
 * \* Description:
 * \
 */
public class VampirePiglinEntity extends PiglinEntity implements IAnimatable {
    private AnimationTypes currentAnimation;
    int baseDamage = 3;

    public VampirePiglinEntity(EntityType<? extends AbstractPiglinEntity> p_i231570_1_, World p_i231570_2_) {
        super(p_i231570_1_, p_i231570_2_);
        currentAnimation = AnimationTypes.IDLE;
        this.setImmuneToZombification(true);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide()) {
            if (this.getTarget() != null && this.getRandom().nextInt(60) == 0) {
                this.startAttack();
            }
            if (this.isAttacking()) {
                if (this.getRandom().nextInt(100) >80){
                    vampireAttackMouse(getTarget());
                }
                this.getNavigation().stop();
            }
            if (this.isAttacking()) {
                this.entityData.set(ATTACK_TIME, this.entityData.get(ATTACK_TIME) - 1);
                if (this.entityData.get(ATTACK_TIME) <= 100) {
                    if (this.getRandom().nextInt(10) >= 5) {
                        this.vampireAttack(getTarget());

                        this.setCurrentAnimation(AnimationTypes.ATACK);
                        this.fastAttack(getTarget());
                        this.superAttack(getTarget());
                    }
                }
            }
        }
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
    private void vampireAttackMouse(LivingEntity entity) {
        entity.setHealth(entity.getHealth() - baseDamage);
        this.setHealth(this.getHealth() + (entity.getHealth()- baseDamage));
        if (entity != null) {
            List<BatEntity> entities = new ArrayList<>();
            for (int i = 0; i<=2; i++) {
                BatEntity bat = EntityType.BAT.create(level);
                bat.setPos(entity.blockPosition().getX(),
                        entity.blockPosition().getY(),
                        entity.blockPosition().getZ());
                bat.moveTo(Vector3d.atBottomCenterOf(entity.blockPosition()));
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
    private void vampireAttack(LivingEntity entity) {
        if (entity != null) {
            entity.setHealth(entity.getHealth() - baseDamage);
            entity.addEffect(new EffectInstance(Effects.BLINDNESS, 107));
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