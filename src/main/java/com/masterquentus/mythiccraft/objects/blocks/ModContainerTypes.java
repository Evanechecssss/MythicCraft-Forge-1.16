package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.container.AlderCrateContainer;
import com.masterquentus.mythiccraft.container.AshCrateContainer;
import com.masterquentus.mythiccraft.container.BeechCrateContainer;
import com.masterquentus.mythiccraft.container.BlackthornCrateContainer;
import com.masterquentus.mythiccraft.container.BloodOakCrateContainer;
import com.masterquentus.mythiccraft.container.CedarCrateContainer;
import com.masterquentus.mythiccraft.container.CharredCrateContainer;
import com.masterquentus.mythiccraft.container.DistortedCrateContainer;
import com.masterquentus.mythiccraft.container.ElderCrateContainer;
import com.masterquentus.mythiccraft.container.HawthornCrateContainer;
import com.masterquentus.mythiccraft.container.IcyCrateContainer;
import com.masterquentus.mythiccraft.container.InfestedCrateContainer;
import com.masterquentus.mythiccraft.container.JuniperCrateContainer;
import com.masterquentus.mythiccraft.container.RowanCrateContainer;
import com.masterquentus.mythiccraft.container.SilverWoodCrateContainer;
import com.masterquentus.mythiccraft.container.TwistedCrateContainer;
import com.masterquentus.mythiccraft.container.WhiteOakCrateContainer;
import com.masterquentus.mythiccraft.container.WillowCrateContainer;
import com.masterquentus.mythiccraft.container.WitchWoodCrateContainer;
import com.masterquentus.mythiccraft.container.WitchhazelCrateContainer;
import com.masterquentus.mythiccraft.container.YewCrateContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(
			ForgeRegistries.CONTAINERS, MythicCraft.MOD_ID);

	public static final RegistryObject<ContainerType<BloodOakCrateContainer>> bloodoak_crate = CONTAINER_TYPES
			.register("bloodoak_crate", () -> IForgeContainerType.create(BloodOakCrateContainer::new));
	public static final RegistryObject<ContainerType<WhiteOakCrateContainer>> whiteoak_crate = CONTAINER_TYPES
			.register("whiteoak_crate", () -> IForgeContainerType.create(WhiteOakCrateContainer::new));
	public static final RegistryObject<ContainerType<SilverWoodCrateContainer>> SILVERWOOD_CRATE = CONTAINER_TYPES
			.register("silverwood_crate", () -> IForgeContainerType.create(SilverWoodCrateContainer::new));
	public static final RegistryObject<ContainerType<WitchWoodCrateContainer>> WITCHWOOD_CRATE = CONTAINER_TYPES
			.register("witchwood_crate", () -> IForgeContainerType.create(WitchWoodCrateContainer::new));
	public static final RegistryObject<ContainerType<AlderCrateContainer>> ALDER_CRATE = CONTAINER_TYPES
			.register("alder_crate", () -> IForgeContainerType.create(AlderCrateContainer::new));
	public static final RegistryObject<ContainerType<HawthornCrateContainer>> HAWTHORN_CRATE = CONTAINER_TYPES
			.register("hawthorn_crate", () -> IForgeContainerType.create(HawthornCrateContainer::new));
	public static final RegistryObject<ContainerType<RowanCrateContainer>> ROWAN_CRATE = CONTAINER_TYPES
			.register("rowan_crate", () -> IForgeContainerType.create(RowanCrateContainer::new));
	public static final RegistryObject<ContainerType<WillowCrateContainer>> WILLOW_CRATE = CONTAINER_TYPES
			.register("willow_crate", () -> IForgeContainerType.create(WillowCrateContainer::new));
	public static final RegistryObject<ContainerType<BeechCrateContainer>> BEECH_CRATE = CONTAINER_TYPES
			.register("beech_crate", () -> IForgeContainerType.create(BeechCrateContainer::new));
	public static final RegistryObject<ContainerType<AshCrateContainer>> ASH_CRATE = CONTAINER_TYPES
			.register("ash_crate", () -> IForgeContainerType.create(AshCrateContainer::new));
	public static final RegistryObject<ContainerType<BlackthornCrateContainer>> BLACKTHORN_CRATE = CONTAINER_TYPES
			.register("blackthorn_crate", () -> IForgeContainerType.create(BlackthornCrateContainer::new));
	public static final RegistryObject<ContainerType<CedarCrateContainer>> CEDAR_CRATE = CONTAINER_TYPES
			.register("cedar_crate", () -> IForgeContainerType.create(CedarCrateContainer::new));
	public static final RegistryObject<ContainerType<ElderCrateContainer>> ELDER_CRATE = CONTAINER_TYPES
			.register("elder_crate", () -> IForgeContainerType.create(ElderCrateContainer::new));
	public static final RegistryObject<ContainerType<JuniperCrateContainer>> JUNIPER_CRATE = CONTAINER_TYPES
			.register("juniper_crate", () -> IForgeContainerType.create(JuniperCrateContainer::new));
	public static final RegistryObject<ContainerType<WitchhazelCrateContainer>> WITCHHAZEL_CRATE = CONTAINER_TYPES
			.register("witchhazel_crate", () -> IForgeContainerType.create(WitchhazelCrateContainer::new));
	public static final RegistryObject<ContainerType<YewCrateContainer>> YEW_CRATE = CONTAINER_TYPES
			.register("yew_crate", () -> IForgeContainerType.create(YewCrateContainer::new));
	public static final RegistryObject<ContainerType<InfestedCrateContainer>> INFESTED_CRATE = CONTAINER_TYPES
			.register("infested_crate", () -> IForgeContainerType.create(InfestedCrateContainer::new));
	public static final RegistryObject<ContainerType<CharredCrateContainer>> CHARRED_CRATE = CONTAINER_TYPES
			.register("charred_crate", () -> IForgeContainerType.create(CharredCrateContainer::new));
	public static final RegistryObject<ContainerType<IcyCrateContainer>> ICY_CRATE = CONTAINER_TYPES
			.register("icy_crate", () -> IForgeContainerType.create(IcyCrateContainer::new));
	public static final RegistryObject<ContainerType<DistortedCrateContainer>> DISTORTED_CRATE = CONTAINER_TYPES
			.register("distorted_crate", () -> IForgeContainerType.create(DistortedCrateContainer::new));
	public static final RegistryObject<ContainerType<TwistedCrateContainer>> TWISTED_CRATE = CONTAINER_TYPES
			.register("twisted_crate", () -> IForgeContainerType.create(TwistedCrateContainer::new));
}
