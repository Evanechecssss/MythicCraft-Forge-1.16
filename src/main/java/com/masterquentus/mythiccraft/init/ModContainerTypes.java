package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;

import com.masterquentus.mythiccraft.container.CrateContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {

	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, MythicCraft.MOD_ID);

	public static final RegistryObject<ContainerType<CrateContainer>> bloodoak_crate = createContainer("bloodoak_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> whiteoak_crate = createContainer("whiteoak_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> SILVERWOOD_CRATE = createContainer("silverwood_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> WITCHWOOD_CRATE = createContainer("witchwood_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> ALDER_CRATE = createContainer("alder_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> ROWAN_CRATE = createContainer("rowan_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> WILLOW_CRATE = createContainer("willow_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> BEECH_CRATE = createContainer("beech_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> ASH_CRATE = createContainer("ash_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> BLACKTHORN_CRATE = createContainer("blackthorn_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> CEDAR_CRATE = createContainer("cedar_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> ELDER_CRATE = createContainer("elder_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> JUNIPER_CRATE = createContainer("juniper_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> YEW_CRATE = createContainer("yew_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> INFESTED_CRATE = createContainer("infested_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> CHARRED_CRATE = createContainer("charred_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> ICY_CRATE = createContainer("icy_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> DISTORTED_CRATE = createContainer("distorted_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> TWISTED_CRATE = createContainer("twisted_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> WITCHHAZEL_CRATE = createContainer("witchhazel_crate");
	public static final RegistryObject<ContainerType<CrateContainer>> HAWTHORN_CRATE = createContainer("hawthorn_crate");

	public static final RegistryObject<ContainerType<CrateContainer>> createContainer(String registryName){
		return CONTAINER_TYPES.register(registryName, () -> IForgeContainerType.create(CrateContainer::new));
	}
}
