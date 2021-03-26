package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantmentInit {
	
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(ForgeRegistries.ENCHANTMENTS, MythicCraft.MOD_ID);
	
	

}
