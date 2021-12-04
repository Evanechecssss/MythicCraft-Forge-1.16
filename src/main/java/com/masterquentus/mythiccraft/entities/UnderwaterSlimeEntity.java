package com.masterquentus.mythiccraft.entities;

import javax.annotation.Nullable;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.LookController;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.*;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
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

import java.util.EnumSet;
import java.util.function.Predicate;

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 28.10.2021
 * \* Description:
 * \
 */
public class UnderwaterSlimeEntity extends MonsterEntity implements IAnimatable, IMob {
    private static final DataParameter<Boolean> DATA_ID_MOVING = EntityDataManager.defineId(UnderwaterSlimeEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> DATA_ID_ATTACK_TARGET = EntityDataManager.defineId(UnderwaterSlimeEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> SIZE = EntityDataManager.defineId(UnderwaterSlimeEntity.class, DataSerializers.INT);
    protected RandomWalkingGoal randomStrollGoal;

    public UnderwaterSlimeEntity(EntityType<? extends MonsterEntity> p_i48565_1_, World p_i48565_2_) {
        super(p_i48565_1_, p_i48565_2_);
        currentAnimation = AnimationTypes.IDLE;
        //AI
        this.xpReward = 10;
        this.setPathfindingMalus(PathNodeType.WATER, 0.0F);
        this.setPathfindingMalus(PathNodeType.BLOCKED, 0.0F);
        this.moveControl = new MoveHelperController(this);



    }


    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.4D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MAX_HEALTH, 48.0D);
    }
    @Override
    public CreatureAttribute getMobType() {
        return CreatureAttribute.WATER;
    }
    //AI//
    @SuppressWarnings("unused")
    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }



    @Nullable
    public LivingEntity getActiveAttackTarget() {
        if (!this.hasActiveAttackTarget()) {
            return null;
        }
        return this.getTarget();

    }


    protected boolean isMovementNoisy() {
        return false;
    }

    protected float getStandingEyeHeight(Pose p_213348_1_, EntitySize p_213348_2_) {
        return p_213348_2_.height * 0.5F;
    }

    public float getWalkTargetValue(BlockPos p_205022_1_, IWorldReader p_205022_2_) {
        return p_205022_2_.getFluidState(p_205022_1_).is(FluidTags.WATER) ? 10.0F + p_205022_2_.getBrightness(p_205022_1_) - 0.5F : super.getWalkTargetValue(p_205022_1_, p_205022_2_);
    }

    public int getAttackDuration() {
        return 80;
    }

    private void setActiveAttackTarget(int p_175463_1_) {
        this.entityData.set(DATA_ID_ATTACK_TARGET, p_175463_1_);
    }

    public boolean hasActiveAttackTarget() {
        return this.entityData.get(DATA_ID_ATTACK_TARGET) != 0;
    }
    public boolean isMoving() {
        return this.entityData.get(DATA_ID_MOVING);
    }

    private void setMoving(boolean p_175476_1_) {
        this.entityData.set(DATA_ID_MOVING, p_175476_1_);
    }


    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return this.isInWaterOrBubble() ? SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS : SoundEvents.AMBIENT_NETHER_WASTES_LOOP;
    }

    protected SoundEvent getDeathSound() {
        return this.isInWaterOrBubble() ? SoundEvents.SLIME_DEATH : SoundEvents.SLIME_DEATH_SMALL;
    }



    public void aiStep() {
        if (this.isAlive()) {
            if (this.isInWaterOrBubble()) {
                this.setAirSupply(300);
            } else if (this.onGround) {
                this.setDeltaMovement(this.getDeltaMovement().add((double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.4F), 0.5D, (double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.4F)));
                this.yRot = this.random.nextFloat() * 360.0F;
                this.onGround = false;
                this.hasImpulse = true;
            }

            if (this.hasActiveAttackTarget()) {
                this.yRot = this.yHeadRot;
            }
        }

        super.aiStep();
    }


    public boolean hurt(DamageSource p_70097_1_, float p_70097_2_) {
        if (!this.isMoving() && !p_70097_1_.isMagic() && p_70097_1_.getDirectEntity() instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity)p_70097_1_.getDirectEntity();
            if (!p_70097_1_.isExplosion()) {
                livingentity.hurt(DamageSource.thorns(this), 2.0F);
            }
        }

        if (this.randomStrollGoal != null) {
            this.randomStrollGoal.trigger();
        }

        return super.hurt(p_70097_1_, p_70097_2_);
    }

    public int getMaxHeadXRot() {
        return 180;
    }

    public void travel(Vector3d p_213352_1_) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.1F, p_213352_1_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (!this.isMoving() && this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
            this.setJumping(true);
        } else {
            super.travel(p_213352_1_);
            this.setJumping(true);
        }

    }
    @Override
    public void remove(boolean keepData) {
        int i = this.getSize();
        if (!this.level.isClientSide && i > 1 && this.isDeadOrDying() && !this.removed) {
            ITextComponent itextcomponent = this.getCustomName();
            boolean flag = this.isNoAi();
            float f = (float)i / 4.0F;
            int j = i -1;
            int k = 2 + this.random.nextInt(3);

            for(int l = 0; l < k; ++l) {
                float f1 = ((float)(l % 2) - 0.5F) * f;
                float f2 = ((float)(l / 2) - 0.5F) * f;
                UnderwaterSlimeEntity slimeentity = (UnderwaterSlimeEntity) this.getType().create(this.level);
                if (this.isPersistenceRequired()) {
                    slimeentity.setPersistenceRequired();
                }

                slimeentity.setCustomName(itextcomponent);
                slimeentity.setNoAi(flag);
                slimeentity.setInvulnerable(this.isInvulnerable());

                slimeentity.moveTo(this.getX() + (double)f1, this.getY() + 0.5D, this.getZ() + (double)f2, this.random.nextFloat() * 360.0F, 0.0F);
                this.level.addFreshEntity(slimeentity);
                slimeentity.setSize(j);
            }
        }

        super.remove(keepData);
    }
    @Override
    public boolean checkSpawnRules(IWorld p_213380_1_, SpawnReason p_213380_2_) {
        return p_213380_1_.isWaterAt(this.blockPosition());
    }

    static class MoveHelperController extends MovementController {
        private final UnderwaterSlimeEntity underwater;

        public MoveHelperController(UnderwaterSlimeEntity p_i45831_1_) {
            super(p_i45831_1_);
            this.underwater = p_i45831_1_;
        }

        public void tick() {
            if (this.operation == MovementController.Action.MOVE_TO && !this.underwater.getNavigation().isDone()) {
                Vector3d vector3d = new Vector3d(this.wantedX - this.underwater.getX(), this.wantedY - this.underwater.getY(), this.wantedZ - this.underwater.getZ());
                double d0 = vector3d.length();
                double d1 = vector3d.x / d0;
                double d2 = vector3d.y / d0;
                double d3 = vector3d.z / d0;
                float f = (float)(MathHelper.atan2(vector3d.z, vector3d.x) * (double)(180F / (float)Math.PI)) - 90.0F;
                this.underwater.yRot = this.rotlerp(this.underwater.yRot, f, 90.0F);
                this.underwater.yBodyRot = this.underwater.yRot;
                float f1 = (float)(this.speedModifier * this.underwater.getAttributeValue(Attributes.MOVEMENT_SPEED));
                float f2 = MathHelper.lerp(0.125F, this.underwater.getSpeed(), f1);
                this.underwater.setSpeed(f2);
                double d4 = Math.sin((double)(this.underwater.tickCount + this.underwater.getId()) * 0.5D) * 0.05D;
                double d5 = Math.cos((double)(this.underwater.yRot * ((float)Math.PI / 180F)));
                double d6 = Math.sin((double)(this.underwater.yRot * ((float)Math.PI / 180F)));
                double d7 = Math.sin((double)(this.underwater.tickCount + this.underwater.getId()) * 0.75D) * 0.05D;
                this.underwater.setDeltaMovement(this.underwater.getDeltaMovement().add(d4 * d5, d7 * (d6 + d5) * 0.25D + (double)f2 * d2 * 0.1D, d4 * d6));
                LookController lookcontroller = this.underwater.getLookControl();
                double d8 = this.underwater.getX() + d1 * 2.0D;
                double d9 = this.underwater.getEyeY() + d2 / d0;
                double d10 = this.underwater.getZ() + d3 * 2.0D;
                double d11 = lookcontroller.getWantedX();
                double d12 = lookcontroller.getWantedY();
                double d13 = lookcontroller.getWantedZ();
                if (!lookcontroller.isHasWanted()) {
                    d11 = d8;
                    d12 = d9;
                    d13 = d10;
                }

                this.underwater.getLookControl().setLookAt(MathHelper.lerp(0.125D, d11, d8), MathHelper.lerp(0.125D, d12, d9), MathHelper.lerp(0.125D, d13, d10), 10.0F, 40.0F);
                this.underwater.setMoving(true);
                if (!underwater.jumping){
                    this.underwater.setJumping(true);
                }

            } else {
                this.underwater.setSpeed(0.0F);
                this.underwater.setMoving(false);
            }
        }
    }
    static class TargetPredicate implements Predicate<LivingEntity> {
        private final UnderwaterSlimeEntity slime;

        public TargetPredicate(UnderwaterSlimeEntity p_i45832_1_) {
            this.slime = p_i45832_1_;
        }

        public boolean test(@Nullable LivingEntity p_test_1_) {
            return (p_test_1_ instanceof PlayerEntity || p_test_1_ instanceof SquidEntity) && p_test_1_.distanceToSqr(this.slime) > 9.0D;
        }
    }

    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        p_213281_1_.putInt("Size", this.getSize() - 1);
    }
    public EntityType<? extends UnderwaterSlimeEntity> getType() {
        return (EntityType<? extends UnderwaterSlimeEntity>)super.getType();
    }
    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        int i = p_70037_1_.getInt("Size");
        if (i < 0) {
            i = 0;
        }
        this.setSize(i + 1);
        super.readAdditionalSaveData(p_70037_1_);
    }
    //Animations and Render//

    private AnimationTypes currentAnimation;
    public int getSize(){
        return this.entityData.get(SIZE);
    }
    public void setSize(int size){
        this.entityData.set(SIZE, size);
        this.refreshDimensions();
    }

    @Override
    public EntitySize getDimensions(Pose p_213305_1_) {
        Entity entity = new SlimeEntity(EntityType.SLIME, this.level);
        int size = this.getSize();
        if (size==3){
            size=5;
        }
        return entity.getDimensions(p_213305_1_).scale((float) size/2);

    }

    @Override
    protected PathNavigator createNavigation(World p_175447_1_) {
        return new SwimmerPathNavigator(this, p_175447_1_);
    }

    protected void registerGoals() {
        MoveTowardsRestrictionGoal movetowardsrestrictiongoal = new MoveTowardsRestrictionGoal(this, 1.0D);
        this.randomStrollGoal = new RandomWalkingGoal(this, 1.0D, 80);
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this,3D, true));
        this.goalSelector.addGoal(5, movetowardsrestrictiongoal);
        this.goalSelector.addGoal(7, this.randomStrollGoal);
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(9, new LookRandomlyGoal(this));
        this.randomStrollGoal.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        movetowardsrestrictiongoal.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, false, new TargetPredicate(this)));
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(SIZE, 3);
        this.getEntityData().define(DATA_ID_MOVING, false);
        this.getEntityData().define(DATA_ID_ATTACK_TARGET, 0);
    }

    @Override
    public void onSyncedDataUpdated(DataParameter<?> p_184206_1_) {
        super.onSyncedDataUpdated(p_184206_1_);

    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    private AnimationFactory factory = new AnimationFactory(this);

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