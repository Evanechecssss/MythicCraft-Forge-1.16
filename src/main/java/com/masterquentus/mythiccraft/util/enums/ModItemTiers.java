package com.masterquentus.mythiccraft.util.enums;

import java.util.function.Supplier;

import com.masterquentus.mythiccraft.init.ItemInit;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum ModItemTiers implements IItemTier {
	
	
	
	VAMPIRIC(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.fromItems(ItemInit.VAMPIRIC_GEM.get());
		
	}),
	
	SILVER(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.fromItems(ItemInit.SILVER_INGOT.get());
		
	}),

	MYTHICDIAMOND(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.fromItems(ItemInit.MYTHIC_DIAMOND.get());
		
	}),

	DRAGONHEART(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.fromItems(ItemInit.DRAGONHEART_INGOT.get());
		
	}),
	
	RUBY(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.fromItems(ItemInit.RUBY.get());
		
	}),
	
	SAPPHIRE(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.fromItems(ItemInit.SAPPHIRE.get());
		
	}),
	
	AMETHYST(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.fromItems(ItemInit.AMETHYST.get());
		
	}),
	
	ANCIENT(2, 550, 5.0F, 6.5F, 15, () -> {
		return Ingredient.fromItems(ItemInit.dragonscale_black.get());
		
	});

	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyValue<Ingredient> repairMaterial;

	private ModItemTiers(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
			Supplier<Ingredient> repairMaterial) {
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairMaterial = new LazyValue<>(repairMaterial);
	}

	@Override
	public int getMaxUses() {
		return this.maxUses;
	}

	@Override
	public float getEfficiency() {
		return this.efficiency;
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		return this.harvestLevel;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial.getValue();
	}
}