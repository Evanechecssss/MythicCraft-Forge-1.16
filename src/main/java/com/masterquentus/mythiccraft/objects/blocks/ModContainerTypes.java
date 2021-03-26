package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.container.BloodOakCrateContainer;
import com.masterquentus.mythiccraft.container.WhiteOakCrateContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {

	
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, MythicCraft.MOD_ID);
	
	public static final RegistryObject<ContainerType<BloodOakCrateContainer>> bloodoak_crate = CONTAINER_TYPES.register("bloodoak_crate", () -> IForgeContainerType.create(BloodOakCrateContainer::new));
	public static final RegistryObject<ContainerType<WhiteOakCrateContainer>> whiteoak_crate = CONTAINER_TYPES.register("whiteoak_crate", () -> IForgeContainerType.create(WhiteOakCrateContainer::new));
}
