package com.masterquentus.mythiccraft.util;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.init.DimensionInit;

import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = MythicCraft.MOD_ID, bus = Bus.FORGE)
public class ForgeEventBusSubscriber {

	@SubscribeEvent
	public static void registerDimensions(final RegisterDimensionsEvent event) { 
		if(DimensionType.byName(MythicCraft.Unerworld_Dim_Type) == null) {
			DimensionManager.registerDimension(MythicCraft.Unerworld_Dim_Type, DimensionInit.underworld_dim.get(), null, false);
		}
		
		MythicCraft.LOGGER.info("Dimensions Registerd");
	}
}
