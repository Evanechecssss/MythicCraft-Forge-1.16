package com.masterquentus.mythiccraft.entities;

import com.masterquentus.mythiccraft.MythicCraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class LilithEntity extends MonsterEntity implements IAnimatable {
	public LilithEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
		// this.ignoreFrustumCheck = true;
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new WaterAvoidingRandomWalkingGoal(this,  1.0D));
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));

		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0F, 0.6D, 1.0D));
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 290)
				.add(Attributes.MOVEMENT_SPEED, 0.33D).add(Attributes.FOLLOW_RANGE, 35)
				.add(Attributes.ARMOR_TOUGHNESS, 10D).add(Attributes.ATTACK_DAMAGE, 11);
	}

	public void onAttackEnd(){
		// do something idk
		MythicCraft.LOGGER.debug("lilith end atack");
		if (this.getTarget() != null) {
			LightningBoltEntity bolt = EntityType.LIGHTNING_BOLT.create(this.level);
			bolt.moveTo(Vector3d.atBottomCenterOf(this.getTarget().blockPosition()));
			this.level.addFreshEntity(bolt);
		}
	}

	// ANIMATIONS //

	@Override
	public void tick() {
		super.tick();
		if (!this.level.isClientSide()){

			// this should be in a goal instead
			if (this.getTarget() != null && this.getRandom().nextInt(60) == 0){
				this.startAttack();
			}
			if (this.isAttacking()){
				// dont run while attacking
				this.getNavigation().stop();
			}

			if (this.isAttacking()){
				this.entityData.set(ATTACK_TIME, this.entityData.get(ATTACK_TIME) - 1);
				if (this.entityData.get(ATTACK_TIME) == 0) this.onAttackEnd();
			}
		}
	}

	private static final DataParameter<Integer> ATTACK_TIME = EntityDataManager.defineId(LilithEntity.class, DataSerializers.INT);

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ATTACK_TIME, 0);
	}

	public void startAttack(){
		this.entityData.set(ATTACK_TIME, 50);
		MythicCraft.LOGGER.debug("lilith start attack");
	}

	public boolean isAttacking(){
		return this.entityData.get(ATTACK_TIME) > 0;
	}

	private AnimationFactory factory = new AnimationFactory(this);
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (this.isAttacking()){
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.lilith.attack", true));
			return PlayState.CONTINUE;
		}

		boolean isWalking = !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F);
		if (isWalking){
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.lilith.walk", true));
		} else {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.lilith.idle", true));
		}

		return PlayState.CONTINUE;
	}
	


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}


	// BOSS BAR //

	private final ServerBossInfo bossEvent = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenScreen(true);

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
		this.bossEvent.setPercent(this.getHealth() / this.getMaxHealth());
	}

	public void startSeenByPlayer(ServerPlayerEntity p_184178_1_) {
		super.startSeenByPlayer(p_184178_1_);
		this.bossEvent.addPlayer(p_184178_1_);
	}

	public void stopSeenByPlayer(ServerPlayerEntity p_184203_1_) {
		super.stopSeenByPlayer(p_184203_1_);
		this.bossEvent.removePlayer(p_184203_1_);
	}
}