package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.world.dimension.UnderworldModDimension;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<ModDimension>(ForgeRegistries.MOD_DIMENSIONS, MythicCraft.MOD_ID);
	
	public static final RegistryObject<ModDimension> underworld_dim = MOD_DIMENSIONS.register("underworld_dim", () -> new UnderworldModDimension());
}
