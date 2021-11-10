package com.masterquentus.mythiccraft.world.gen;

import com.masterquentus.mythiccraft.MythicCraft;

import com.masterquentus.mythiccraft.init.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = MythicCraft.MOD_ID)
public class WorldEventsInit {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        List<MobSpawnInfo.Spawners> spawns =
                event.getSpawns().getSpawner(EntityClassification.MONSTER);
        spawns.removeIf(e -> e.type == ModEntityTypes.UNDERWATER_SLIME.get());
        ModEntityGeneration.onEntitySpawn(event);
    }
}
