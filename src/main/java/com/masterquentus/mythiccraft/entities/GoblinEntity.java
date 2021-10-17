package com.masterquentus.mythiccraft.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class GoblinEntity extends MonsterEntity implements IAnimatable {
	
	private AnimationFactory factory = new AnimationFactory(this);
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
	{
		boolean isWalking = !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F);
		if (isWalking){
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblin.walk", true));
		} else {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblin.idle", true));
		}

		return PlayState.CONTINUE;
	}
	
	public GoblinEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
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
	
    }

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 26)
				.add(Attributes.MOVEMENT_SPEED, 0.13D).add(Attributes.FOLLOW_RANGE, 25).add(Attributes.ARMOR_TOUGHNESS, 2D)
				.add(Attributes.ATTACK_DAMAGE, 3);
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
}