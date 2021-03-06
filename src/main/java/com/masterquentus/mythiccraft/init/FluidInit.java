package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;

import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidInit {

	public static final ResourceLocation BLOOD_STILL_RL = new ResourceLocation(MythicCraft.MOD_ID, "block/blood_still");
	public static final ResourceLocation BLOOD_FLOWING_RL = new ResourceLocation(MythicCraft.MOD_ID,
			"block/blood_flowing");
	public static final ResourceLocation ECTOPLASM_STILL_RL = new ResourceLocation(MythicCraft.MOD_ID,
			"block/ectoplasm_still");
	public static final ResourceLocation ECTOPLASM_FLOWING_RL = new ResourceLocation(MythicCraft.MOD_ID,
			"block/ectoplasm_flowing");
	public static final ResourceLocation INFESTEDGOO_STILL_RL = new ResourceLocation(MythicCraft.MOD_ID,
			"block/infestedgoo_still");
	public static final ResourceLocation INFESTEDGOO_FLOWING_RL = new ResourceLocation(MythicCraft.MOD_ID,
			"block/infestedgoo_flowing");
	public static final ResourceLocation DARK_WATER_STILL_RL = new ResourceLocation(MythicCraft.MOD_ID,
			"block/dark_water_still");
	public static final ResourceLocation DARK_WATER_FLOWING_RL = new ResourceLocation(MythicCraft.MOD_ID,
			"block/dark_water_flowing");
	public static final ResourceLocation MANA_STILL_RL = new ResourceLocation(MythicCraft.MOD_ID, "block/mana_still");
	public static final ResourceLocation MANA_FLOWING_RL = new ResourceLocation(MythicCraft.MOD_ID,
			"block/mana_flowing");
	public static final ResourceLocation BLOOD_OVERLAY_RL = new ResourceLocation(MythicCraft.MOD_ID,
			"block/blood_overlay");
	public static final ResourceLocation ECTOPLASM_OVERLAY_RL = new ResourceLocation(MythicCraft.MOD_ID,
			"block/ectoplasm_overlay");
	public static final ResourceLocation INFESTEDGOO_OVERLAY_RL = new ResourceLocation(MythicCraft.MOD_ID,
			"block/infestedgoo_overlay");
	public static final ResourceLocation DARK_WATER_OVERLAY_RL = new ResourceLocation(MythicCraft.MOD_ID,
			"block/dark_water_overlay");
	public static final ResourceLocation MANA_OVERLAY_RL = new ResourceLocation(MythicCraft.MOD_ID,
			"block/mana_overlay");

	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS,
			MythicCraft.MOD_ID);

	public static final RegistryObject<FlowingFluid> BLOOD_FLUID = FLUIDS.register("blood_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.BLOOD_PROPERTIES));
	public static final RegistryObject<FlowingFluid> BLOOD_FLOWING = FLUIDS.register("blood_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.BLOOD_PROPERTIES));
	public static final RegistryObject<FlowingFluid> ECTOPLASM_FLUID = FLUIDS.register("ectoplasm_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.ECTOPLASM_PROPERTIES));
	public static final RegistryObject<FlowingFluid> ECTOPLASM_FLOWING = FLUIDS.register("ectoplasm_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.ECTOPLASM_PROPERTIES));
	public static final RegistryObject<FlowingFluid> INFESTEDGOO_FLUID = FLUIDS.register("infestedgoo_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.INFESTEDGOO_PROPERTIES));
	public static final RegistryObject<FlowingFluid> INFESTEDGOO_FLOWING = FLUIDS.register("infestedgoo_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.INFESTEDGOO_PROPERTIES));
	public static final RegistryObject<FlowingFluid> DARK_WATER_FLUID = FLUIDS.register("dark_water_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.DARK_WATER_PROPERTIES));
	public static final RegistryObject<FlowingFluid> DARK_WATER_FLOWING = FLUIDS.register("dark_water_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.DARK_WATER_PROPERTIES));
	public static final RegistryObject<FlowingFluid> MANA_FLUID = FLUIDS.register("mana_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.MANA_PROPERTIES));
	public static final RegistryObject<FlowingFluid> MANA_FLOWING = FLUIDS.register("mana_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.MANA_PROPERTIES));

	public static final ForgeFlowingFluid.Properties BLOOD_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> BLOOD_FLUID.get(), () -> BLOOD_FLOWING.get(),
			FluidAttributes.builder(BLOOD_STILL_RL, BLOOD_FLOWING_RL).density(10).viscosity(5).luminosity(2)
					.sound(SoundEvents.HONEY_BLOCK_PLACE).overlay(BLOOD_OVERLAY_RL)).slopeFindDistance(2)
							.levelDecreasePerBlock(2).block(() -> FluidInit.BLOOD_BLOCK.get())
							.bucket(() -> ItemInit.blood_bucket.get());
	public static final ForgeFlowingFluid.Properties ECTOPLASM_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> ECTOPLASM_FLUID.get(), () -> ECTOPLASM_FLOWING.get(),
			FluidAttributes.builder(ECTOPLASM_STILL_RL, ECTOPLASM_FLOWING_RL).density(15).viscosity(6).luminosity(5)
					.rarity(Rarity.UNCOMMON).sound(SoundEvents.BEEHIVE_DRIP).overlay(ECTOPLASM_OVERLAY_RL))
							.slopeFindDistance(5).levelDecreasePerBlock(4).block(() -> FluidInit.ECTOPLASM_BLOCK.get())
							.bucket(() -> ItemInit.ectoplasm_bucket.get());
	public static final ForgeFlowingFluid.Properties INFESTEDGOO_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> INFESTEDGOO_FLUID.get(), () -> INFESTEDGOO_FLOWING.get(),
			FluidAttributes.builder(INFESTEDGOO_STILL_RL, INFESTEDGOO_FLOWING_RL).density(15).viscosity(6).luminosity(5)
					.rarity(Rarity.UNCOMMON).sound(SoundEvents.BEEHIVE_DRIP).overlay(INFESTEDGOO_OVERLAY_RL))
							.slopeFindDistance(5).levelDecreasePerBlock(4)
							.block(() -> FluidInit.INFESTEDGOO_BLOCK.get())
							.bucket(() -> ItemInit.ectoplasm_bucket.get());
	public static final ForgeFlowingFluid.Properties DARK_WATER_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> DARK_WATER_FLUID.get(), () -> DARK_WATER_FLOWING.get(),
			FluidAttributes.builder(DARK_WATER_STILL_RL, DARK_WATER_FLOWING_RL).density(10).viscosity(5).luminosity(2)
					.sound(SoundEvents.WATER_AMBIENT).overlay(DARK_WATER_OVERLAY_RL)).slopeFindDistance(2)
							.levelDecreasePerBlock(2).block(() -> FluidInit.DARK_WATER_BLOCK.get())
							.bucket(() -> ItemInit.DARK_WATER_BUCKET.get());
	public static final ForgeFlowingFluid.Properties MANA_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> MANA_FLUID.get(), () -> MANA_FLOWING.get(),
			FluidAttributes.builder(MANA_STILL_RL, MANA_FLOWING_RL).density(10).viscosity(5).luminosity(2)
					.sound(SoundEvents.WATER_AMBIENT).overlay(MANA_OVERLAY_RL)).slopeFindDistance(2)
							.levelDecreasePerBlock(2).block(() -> FluidInit.MANA_BLOCK.get())
							.bucket(() -> ItemInit.LIQUID_MANA_BUCKET.get());

	public static final RegistryObject<FlowingFluidBlock> BLOOD_BLOCK = BlockInit.BLOCKS.register("blood",
			() -> new FlowingFluidBlock(() -> FluidInit.BLOOD_FLUID.get(),
					Block.Properties.of(Material.WATER).noCollission().strength(100.0f).noDrops()));
	public static final RegistryObject<FlowingFluidBlock> ECTOPLASM_BLOCK = BlockInit.BLOCKS.register("ectoplasm",
			() -> new FlowingFluidBlock(() -> FluidInit.ECTOPLASM_FLUID.get(),
					Block.Properties.of(Material.WATER).noCollission().strength(100.0f).noDrops()));
	public static final RegistryObject<FlowingFluidBlock> INFESTEDGOO_BLOCK = BlockInit.BLOCKS.register("infestedgoo",
			() -> new FlowingFluidBlock(() -> FluidInit.INFESTEDGOO_FLUID.get(),
					Block.Properties.of(Material.WATER).noCollission().strength(100.0f).noDrops()));
	public static final RegistryObject<FlowingFluidBlock> DARK_WATER_BLOCK = BlockInit.BLOCKS.register("dark_water",
			() -> new FlowingFluidBlock(() -> FluidInit.DARK_WATER_FLUID.get(),
					Block.Properties.of(Material.WATER).noCollission().strength(100.0f).noDrops()));
	public static final RegistryObject<FlowingFluidBlock> MANA_BLOCK = BlockInit.BLOCKS.register("mana",
			() -> new FlowingFluidBlock(() -> FluidInit.MANA_FLUID.get(),
					Block.Properties.of(Material.WATER).noCollission().strength(100.0f).noDrops()));

}
