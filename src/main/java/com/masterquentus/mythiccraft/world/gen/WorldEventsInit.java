package com.masterquentus.mythiccraft.world.gen;

import com.masterquentus.mythiccraft.MythicCraft;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MythicCraft.MOD_ID)
public class WorldEventsInit {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {

        ModEntityGeneration.onEntitySpawn(event);
    }

    
}
