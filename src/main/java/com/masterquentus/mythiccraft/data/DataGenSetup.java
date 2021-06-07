package com.masterquentus.mythiccraft.data;

import com.masterquentus.mythiccraft.MythicCraft;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = MythicCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenSetup {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if (event.includeClient()){
            MythicCraft.LOGGER.debug("!!! gather data client !!!");
            gen.addProvider(new ModBlockModelProvider(gen, existingFileHelper));
            gen.addProvider(new ModBlockStateProvider(gen, existingFileHelper));
        }

        if (event.includeServer()){
            MythicCraft.LOGGER.debug("!!! gather data server !!!");
            gen.addProvider(new ModLootProvider(gen));
        }

        // gen.addProvider(new DimensionSetup(gen));
    }
}