package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class DimensionInit {
	public static final RegistryKey<World> UNDERWORLD_DIMENSION_WORLD = RegistryKey.create(Registry.DIMENSION_REGISTRY,
			new ResourceLocation(MythicCraft.MOD_ID, "underworld_dimension"));

}
