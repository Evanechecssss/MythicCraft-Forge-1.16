package com.masterquentus.mythiccraft.util.enums;

import java.util.function.Supplier;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.init.ItemInit;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ModArmorMaterials implements IArmorMaterial {

	VAMPIRIC(MythicCraft.MOD_ID + ":vampiric", 5, new int[] { 7, 9, 11, 7 }, 420, SoundEvents.ARMOR_EQUIP_GENERIC,
			6.9F, () -> {
				return Ingredient.of(ItemInit.VAMPIRIC_GEM.get());
			}),

	SILVER(MythicCraft.MOD_ID + ":silver", 5, new int[] { 7, 9, 11, 7 }, 420, SoundEvents.ARMOR_EQUIP_GENERIC,
			6.9F, () -> {
				return Ingredient.of(ItemInit.SILVER_INGOT.get());
			}),

	MYTHICDIAMOND(MythicCraft.MOD_ID + ":mythicdiamond", 5, new int[] { 7, 9, 11, 7 }, 420,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.MYTHIC_DIAMOND.get());
			}),

	DRAGONHEART(MythicCraft.MOD_ID + ":dragonheart", 5, new int[] { 7, 9, 11, 7 }, 420,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.DRAGONHEART_INGOT.get());
			}),
	
	FROSTSTEEL(MythicCraft.MOD_ID + ":froststeel", 5, new int[] { 7, 9, 11, 7 }, 420,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.FROSTSTEEL_INGOT.get());
			}),

	DRAGONSCALERED(MythicCraft.MOD_ID + ":dragonscalered", 5, new int[] { 7, 9, 11, 7 }, 420,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.dragonscale_red.get());
			}),

	DRAGONSCALEAMETHYST(MythicCraft.MOD_ID + ":dragonscaleamethyst", 5, new int[] { 7, 9, 11, 7 }, 420,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.dragonscale_amethyst.get());
			}),

	DRAGONSCALEBLACK(MythicCraft.MOD_ID + ":dragonscaleblack", 5, new int[] { 7, 9, 11, 7 }, 420,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.dragonscale_black.get());
			}),

	DRAGONSCALEGREEN(MythicCraft.MOD_ID + ":dragonscalegreen", 5, new int[] { 7, 9, 11, 7 }, 420,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.dragonscale_green.get());
			}),

	DRAGONSCALEGRAY(MythicCraft.MOD_ID + ":dragonscalegray", 5, new int[] { 7, 9, 11, 7 }, 420,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.dragonscale_gray.get());
			}),

	DRAGONSCALEWHITE(MythicCraft.MOD_ID + ":dragonscalewhite", 5, new int[] { 7, 9, 11, 7 }, 420,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.dragonscale_white.get());
			}),

	DRAGONSCALESAPPHIRE(MythicCraft.MOD_ID + ":dragonscalesapphire", 5, new int[] { 7, 9, 11, 7 }, 420,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.dragonscale_sapphire.get());
			}),

	DRAGONSCALESILVER(MythicCraft.MOD_ID + ":dragonscalesilver", 5, new int[] { 7, 9, 11, 7 }, 420,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.dragonscale_silver.get());
			}),

	DRAGONSCALEBLUE(MythicCraft.MOD_ID + ":dragonscaleblue", 5, new int[] { 7, 9, 11, 7 }, 420,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.dragonscale_blue.get());
			}),

	SIREN(MythicCraft.MOD_ID + ":siren", 5, new int[] { 7, 9, 11, 7 }, 420, SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F,
			() -> {
				return Ingredient.of(ItemInit.siren_scale.get());
			}),

	MERMAID(MythicCraft.MOD_ID + ":mermaid", 5, new int[] { 7, 9, 11, 7 }, 420, SoundEvents.ARMOR_EQUIP_GENERIC,
			6.9F, () -> {
				return Ingredient.of(ItemInit.mermaid_scale.get());
			}),

	BASILISK(MythicCraft.MOD_ID + ":basilisk", 5, new int[] { 7, 9, 11, 7 }, 420, SoundEvents.ARMOR_EQUIP_GENERIC,
			6.9F, () -> {
				return Ingredient.of(ItemInit.basilisk_scale.get());
			}),

	KRAKEN(MythicCraft.MOD_ID + ":kraken", 5, new int[] { 7, 9, 11, 7 }, 420, SoundEvents.ARMOR_EQUIP_GENERIC,
			6.9F, () -> {
				return Ingredient.of(ItemInit.kraken_scale.get());
			}),

	DRAGONBONE(MythicCraft.MOD_ID + ":drahonbone", 5, new int[] { 7, 9, 11, 7 }, 420,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.dragon_bone.get());
			}),
	
	RUBY(MythicCraft.MOD_ID + ":ruby", 5, new int[] { 7, 9, 11, 7 }, 20,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.RUBY.get());
			}),
	
	SAPPHIRE(MythicCraft.MOD_ID + ":sapphire", 5, new int[] { 7, 9, 11, 7 }, 20,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.SAPPHIRE.get());
			}),
	
	AMETHYST(MythicCraft.MOD_ID + ":amethyst", 5, new int[] { 7, 9, 11, 7 }, 420,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.AMETHYST.get());
			}),
	
	ANCIENT(MythicCraft.MOD_ID + ":ancent", 5, new int[] { 7, 9, 11, 7 }, 420,
			SoundEvents.ARMOR_EQUIP_GENERIC, 6.9F, () -> {
				return Ingredient.of(ItemInit.dragonscale_black.get());
			}),
	WITCH(MythicCraft.MOD_ID + ":witch", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ARMOR_EQUIP_LEATHER,
			6.9F, () -> {
		return Ingredient.of(ItemInit.INFUSED_FABRIC.get());
			}),

	DEATH(MythicCraft.MOD_ID + ":death", 5, new int[]{3, 4, 3, 2}, 15, SoundEvents.ARMOR_EQUIP_LEATHER,
			6.9F, () -> {
		return Ingredient.of(ItemInit.DEATH_SOUL.get());
	});

	private static final int[] MAX_DAMAGE_ARRAY = new int[] { 16, 16, 16, 16 };
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final LazyValue<Ingredient> repairMaterial;

	private ModArmorMaterials(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn,
			SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
		this.name = nameIn;
		this.maxDamageFactor = maxDamageFactorIn;
		this.damageReductionAmountArray = damageReductionAmountIn;
		this.enchantability = enchantabilityIn;
		this.soundEvent = soundEventIn;
		this.toughness = toughnessIn;
		this.repairMaterial = new LazyValue<>(repairMaterialIn);
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.soundEvent;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairMaterial.get();
	}


	@OnlyIn(Dist.CLIENT)
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return 0;
	}
}