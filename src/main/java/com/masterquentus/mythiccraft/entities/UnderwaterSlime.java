package com.masterquentus.mythiccraft.entities;

import com.masterquentus.mythiccraft.entities.ai.HurtByTargetGoal;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.*;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
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
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 28.10.2021
 * \* Description:
 * \
 */
public class UnderwaterSlime extends SlimeEntity implements IAnimatable, IMob {

    public UnderwaterSlime(EntityType<? extends SlimeEntity> p_i48565_1_, World p_i48565_2_) {
        super(p_i48565_1_, p_i48565_2_);
        currentAnimation = AnimationTypes.IDLE;

        //AI
        this.maxUpStep = 1.0F;
        this.setPathfindingMalus(PathNodeType.WATER, 0.0F);
        this.waterNavigation = new SwimmerPathNavigator(this, p_i48565_2_);
        this.groundNavigation = new GroundPathNavigator(this, p_i48565_2_);
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 1.1D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MAX_HEALTH, 48.0D);
    }

    //AI//
    @SuppressWarnings("unused")
	private boolean searchingForLand;
    protected final SwimmerPathNavigator waterNavigation;
    protected final GroundPathNavigator groundNavigation;

    public boolean isPushedByFluid() {
        return !this.isSwimming();
    }
    public float getWalkTargetValue(BlockPos p_180484_1_) {
        return this.getWalkTargetValue(p_180484_1_, this.level);
    }

    public float getWalkTargetValue(BlockPos p_205022_1_, IWorldReader p_205022_2_) {
        return 0.0F;
    }
    private boolean wantsToSwim() {
        LivingEntity livingentity = this.getTarget();
        return livingentity != null && livingentity.isInWater();
    }

    public void travel(Vector3d p_213352_1_) {
        if (this.isEffectiveAi() && this.isInWater() && this.wantsToSwim()) {
            this.moveRelative(0.01F, p_213352_1_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
        } else {
            super.travel(p_213352_1_);
        }

    }

    public void updateSwimming() {
        if (!this.level.isClientSide) {
            if (this.isEffectiveAi() && this.isInWater() && this.wantsToSwim()) {
                this.navigation = this.waterNavigation;
                this.setSwimming(true);
            } else {
                this.navigation = this.groundNavigation;
                this.setSwimming(false);
            }
        }

    }

    protected boolean closeToNextPos() {
        Path path = this.getNavigation().getPath();
        if (path != null) {
            BlockPos blockpos = path.getTarget();
            if (blockpos != null) {
                double d0 = this.distanceToSqr((double) blockpos.getX(), (double) blockpos.getY(), (double) blockpos.getZ());
                if (d0 < 4.0D) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean okTarget(@Nullable LivingEntity p_204714_1_) {
        if (p_204714_1_ != null) {
            return p_204714_1_.isInWater();
        } else {
            return false;
        }
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    protected void registerGoals() {
        addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, UnderwaterSlime.class)).setAlertOthers(ZombifiedPiglinEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::okTarget));
        this.goalSelector.addGoal(1, new GoToWaterGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new SwimUpGoal(this, 1.0D, this.level.getSeaLevel()));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, (p_213811_1_) -> Math.abs(p_213811_1_.getY() - this.getY()) <= 4.0D));
    }
    @SuppressWarnings("unused")
	private float getSoundPitch() {
        float f = this.isTiny() ? 1.4F : 0.8F;
        return ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * f;
    }

    protected int getJumpDelay() {
        return this.random.nextInt(20) + 10;
    }


    public static class GoToWaterGoal extends Goal {
        private final UnderwaterSlime mob;
        private double wantedX;
        private double wantedY;
        private double wantedZ;
        private final double speedModifier;
        private final World level;

        public GoToWaterGoal(UnderwaterSlime p_i48910_1_, double p_i48910_2_) {
            this.mob = p_i48910_1_;
            this.speedModifier = p_i48910_2_;
            this.level = p_i48910_1_.level;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            if (!this.level.isDay()) {
                return false;
            } else if (this.mob.isInWater()) {
                return false;
            } else {
                Vector3d vector3d = this.getWaterPos();
                if (vector3d == null) {
                    return false;
                } else {
                    this.wantedX = vector3d.x;
                    this.wantedY = vector3d.y;
                    this.wantedZ = vector3d.z;
                    return true;
                }
            }
        }

        public boolean canContinueToUse() {
            return !this.mob.getNavigation().isDone();
        }

        public void start() {
            this.mob.getNavigation().moveTo(this.wantedX, this.wantedY, this.wantedZ, this.speedModifier);
        }

        @Nullable
        private Vector3d getWaterPos() {
            Random random = this.mob.getRandom();
            BlockPos blockpos = this.mob.blockPosition();

            for (int i = 0; i < 10; ++i) {
                BlockPos blockpos1 = blockpos.offset(random.nextInt(20) - 10, 2 - random.nextInt(8), random.nextInt(20) - 10);
                if (this.level.getBlockState(blockpos1).is(Blocks.WATER)) {
                    return Vector3d.atBottomCenterOf(blockpos1);
                }
            }

            return null;
        }
    }

    public static class SwimUpGoal extends Goal {
        private final UnderwaterSlime slime;
        private final double speedModifier;
        private final int seaLevel;
        private boolean stuck;

        public SwimUpGoal(UnderwaterSlime p_i48908_1_, double p_i48908_2_, int p_i48908_4_) {
            this.slime = p_i48908_1_;
            this.speedModifier = p_i48908_2_;
            this.seaLevel = p_i48908_4_;
        }

        public boolean canUse() {
            return !this.slime.level.isDay() && this.slime.isInWater() && this.slime.getY() < (double) (this.seaLevel - 2);
        }

        public boolean canContinueToUse() {
            return this.canUse() && !this.stuck;
        }
        static BlockPos moveUpToAboveSolid(BlockPos p_226342_0_, int p_226342_1_, int p_226342_2_, Predicate<BlockPos> p_226342_3_) {
            if (p_226342_1_ < 0) {
                throw new IllegalArgumentException("aboveSolidAmount was " + p_226342_1_ + ", expected >= 0");
            } else if (!p_226342_3_.test(p_226342_0_)) {
                return p_226342_0_;
            } else {
                BlockPos blockpos;
                for(blockpos = p_226342_0_.above(); blockpos.getY() < p_226342_2_ && p_226342_3_.test(blockpos); blockpos = blockpos.above()) {
                }

                BlockPos blockpos1;
                BlockPos blockpos2;
                for(blockpos1 = blockpos; blockpos1.getY() < p_226342_2_ && blockpos1.getY() - blockpos.getY() < p_226342_1_; blockpos1 = blockpos2) {
                    blockpos2 = blockpos1.above();
                    if (p_226342_3_.test(blockpos2)) {
                        break;
                    }
                }

                return blockpos1;
            }
        }
        private static BlockPos getRandomDelta(Random p_226343_0_, int p_226343_1_, int p_226343_2_, int p_226343_3_, @Nullable Vector3d p_226343_4_, double p_226343_5_) {
            if (p_226343_4_ != null && !(p_226343_5_ >= Math.PI)) {
                double d3 = MathHelper.atan2(p_226343_4_.z, p_226343_4_.x) - (double)((float)Math.PI / 2F);
                double d4 = d3 + (double)(2.0F * p_226343_0_.nextFloat() - 1.0F) * p_226343_5_;
                double d0 = Math.sqrt(p_226343_0_.nextDouble()) * (double)MathHelper.SQRT_OF_TWO * (double)p_226343_1_;
                double d1 = -d0 * Math.sin(d4);
                double d2 = d0 * Math.cos(d4);
                if (!(Math.abs(d1) > (double)p_226343_1_) && !(Math.abs(d2) > (double)p_226343_1_)) {
                    int l = p_226343_0_.nextInt(2 * p_226343_2_ + 1) - p_226343_2_ + p_226343_3_;
                    return new BlockPos(d1, (double)l, d2);
                } else {
                    return null;
                }
            } else {
                int i = p_226343_0_.nextInt(2 * p_226343_1_ + 1) - p_226343_1_;
                int j = p_226343_0_.nextInt(2 * p_226343_2_ + 1) - p_226343_2_ + p_226343_3_;
                int k = p_226343_0_.nextInt(2 * p_226343_1_ + 1) - p_226343_1_;
                return new BlockPos(i, j, k);
            }
        }
        @Nullable
        private static Vector3d generateRandomPos(MobEntity p_226339_0_, int p_226339_1_, int p_226339_2_, int p_226339_3_, @Nullable Vector3d p_226339_4_, boolean p_226339_5_, double p_226339_6_, ToDoubleFunction<BlockPos> p_226339_8_, boolean p_226339_9_, int p_226339_10_, int p_226339_11_, boolean p_226339_12_) {
            PathNavigator pathnavigator = p_226339_0_.getNavigation();
            Random random = p_226339_0_.getRandom();
            boolean flag;
            if (p_226339_0_.hasRestriction()) {
                flag = p_226339_0_.getRestrictCenter().closerThan(p_226339_0_.position(), (double)(p_226339_0_.getRestrictRadius() + (float)p_226339_1_) + 1.0D);
            } else {
                flag = false;
            }

            boolean flag1 = false;
            double d0 = Double.NEGATIVE_INFINITY;
            BlockPos blockpos = p_226339_0_.blockPosition();

            for(int i = 0; i < 10; ++i) {
                BlockPos blockpos1 = getRandomDelta(random, p_226339_1_, p_226339_2_, p_226339_3_, p_226339_4_, p_226339_6_);
                if (blockpos1 != null) {
                    int j = blockpos1.getX();
                    int k = blockpos1.getY();
                    int l = blockpos1.getZ();
                    if (p_226339_0_.hasRestriction() && p_226339_1_ > 1) {
                        BlockPos blockpos2 = p_226339_0_.getRestrictCenter();
                        if (p_226339_0_.getX() > (double)blockpos2.getX()) {
                            j -= random.nextInt(p_226339_1_ / 2);
                        } else {
                            j += random.nextInt(p_226339_1_ / 2);
                        }

                        if (p_226339_0_.getZ() > (double)blockpos2.getZ()) {
                            l -= random.nextInt(p_226339_1_ / 2);
                        } else {
                            l += random.nextInt(p_226339_1_ / 2);
                        }
                    }

                    BlockPos blockpos3 = new BlockPos((double)j + p_226339_0_.getX(), (double)k + p_226339_0_.getY(), (double)l + p_226339_0_.getZ());
                    if (blockpos3.getY() >= 0 && blockpos3.getY() <= p_226339_0_.level.getMaxBuildHeight() && (!flag || p_226339_0_.isWithinRestriction(blockpos3)) && (!p_226339_12_ || pathnavigator.isStableDestination(blockpos3))) {
                        if (p_226339_9_) {
                            blockpos3 = moveUpToAboveSolid(blockpos3, random.nextInt(p_226339_10_ + 1) + p_226339_11_, p_226339_0_.level.getMaxBuildHeight(), (p_226341_1_) -> {
                                return p_226339_0_.level.getBlockState(p_226341_1_).getMaterial().isSolid();
                            });
                        }

                        if (p_226339_5_ || !p_226339_0_.level.getFluidState(blockpos3).is(FluidTags.WATER)) {
                            PathNodeType pathnodetype = WalkNodeProcessor.getBlockPathTypeStatic(p_226339_0_.level, blockpos3.mutable());
                            if (p_226339_0_.getPathfindingMalus(pathnodetype) == 0.0F) {
                                double d1 = p_226339_8_.applyAsDouble(blockpos3);
                                if (d1 > d0) {
                                    d0 = d1;
                                    blockpos = blockpos3;
                                    flag1 = true;
                                }
                            }
                        }
                    }
                }
            }

            return flag1 ? Vector3d.atBottomCenterOf(blockpos) : null;
        }
        @Nullable
        public static Vector3d getPosTowards(MobEntity p_75464_0_, int p_75464_1_, int p_75464_2_, Vector3d p_75464_3_) {
            Vector3d vector3d = p_75464_3_.subtract(p_75464_0_.getX(), p_75464_0_.getY(), p_75464_0_.getZ());
            return generateRandomPos(p_75464_0_, p_75464_1_, p_75464_2_, 0, vector3d, true, (double)((float)Math.PI / 2F), ( (UnderwaterSlime) p_75464_0_ )::getWalkTargetValue, false, 0, 0, true);
        }
        public void tick() {
            if (this.slime.getY() < (double) (this.seaLevel - 1) && (this.slime.getNavigation().isDone() || this.slime.closeToNextPos())) {


                Vector3d vector3d = getPosTowards(this.slime, 4, 8, new Vector3d(this.slime.getX(), (double) (this.seaLevel - 1), this.slime.getZ()));
                if (vector3d == null) {
                    this.stuck = true;
                    return;
                }

                this.slime.getNavigation().moveTo(vector3d.x, vector3d.y, vector3d.z, this.speedModifier);
            }

        }

        public void start() {

            this.stuck = false;
        }

        public void stop() {

        }
    }
    //Animations and Render//

    private AnimationTypes currentAnimation;

    @Override
    public EntitySize getDimensions(Pose p_213305_1_) {
        Entity entity = new SlimeEntity(EntityType.SLIME, this.level);
        return entity.getDimensions(p_213305_1_).scale(4F * 0.25F * (float) this.getSize());
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