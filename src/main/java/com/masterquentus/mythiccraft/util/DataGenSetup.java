package com.masterquentus.mythiccraft.util;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.init.DimensionSetup;
import net.minecraft.data.BlockTagsProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = MythicCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenSetup {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent evt) {
        evt.getGenerator().addProvider(new DimensionSetup(evt.getGenerator()));
    }
}
