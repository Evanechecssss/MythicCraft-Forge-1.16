package com.masterquentus.mythiccraft.util.enums;

import java.util.function.Supplier;

import com.masterquentus.mythiccraft.init.ItemInit;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum ModItemTiers implements IItemTier {
	
	
	
	VAMPIRIC(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.of(ItemInit.VAMPIRIC_GEM.get());
		
	}),
	
	SILVER(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.of(ItemInit.SILVER_INGOT.get());
		
	}),

	MYTHICDIAMOND(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.of(ItemInit.MYTHIC_DIAMOND.get());
		
	}),

	DRAGONHEART(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.of(ItemInit.DRAGONHEART_INGOT.get());
		
	}),
	
	FROSTSTEEL(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.of(ItemInit.FROSTSTEEL_INGOT.get());
		
	}),
	
	RUBY(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.of(ItemInit.RUBY.get());
		
	}),
	
	SAPPHIRE(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.of(ItemInit.SAPPHIRE.get());
		
	}),
	
	AMETHYST(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.of(ItemInit.AMETHYST.get());
		
	}),
	
	ANCIENT(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.of(ItemInit.dragonscale_black.get());
		
		
	}),
	
	ARTHANA(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.of(ItemInit.AMETHYST.get());
		
	});

	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyValue<Ingredient> repairMaterial;

	ModItemTiers(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairMaterial = new LazyValue<>(repairMaterial);
	}

	@Override
	public int getUses() {
		return this.maxUses;
	}

	@Override
	public float getSpeed() {
		return this.efficiency;
	}

	@Override
	public float getAttackDamageBonus() {
		return this.attackDamage;
	}

	@Override
	public int getLevel() {
		return this.harvestLevel;
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairMaterial.get();
	}
}