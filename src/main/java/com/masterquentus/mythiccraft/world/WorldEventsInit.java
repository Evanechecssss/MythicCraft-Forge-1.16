package com.masterquentus.mythiccraft.world;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.world.feature.structures.StructuresInit;
import com.masterquentus.mythiccraft.world.gen.StructureGenerationInit;
import com.mojang.serialization.Codec;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = MythicCraft.MOD_ID)
public class WorldEventsInit {
	
	@SubscribeEvent
	public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
		StructureGenerationInit.generateStructures(event);
		
		
	}
	
	@SuppressWarnings("resource")
	@SubscribeEvent
    public static void addDimensionalSpacing(final WorldEvent.Load event) {
        if(event.getWorld() instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) event.getWorld();
            
            try {
                Method GETCODEC_METHOD =
                        ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "func_230347_a_");
                @SuppressWarnings("unchecked")
				ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey(
                        (Codec<? extends ChunkGenerator>)GETCODEC_METHOD.invoke(serverWorld.getChunkSource().generator));

                if (cgRL != null && cgRL.getNamespace().equals("terraforged")) {
                    return;
                }
            } catch (Exception e) {
                LogManager.getLogger().error("Was unable to check if " + serverWorld.dimension().location()
                        + " is using Terraforged's ChunkGenerator.");
            }
            
            if (serverWorld.getChunkSource().generator instanceof FlatChunkGenerator &&
                    serverWorld.dimension().equals(World.OVERWORLD)) {
                return;
            }
            
            @SuppressWarnings("resource")
			Map<Structure<?>, StructureSeparationSettings> tempMap =
                    new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
            tempMap.putIfAbsent(StructuresInit.GOBLIN_HUT.get(),
                    DimensionStructuresSettings.DEFAULTS.get(StructuresInit.GOBLIN_HUT.get()));
            serverWorld.getChunkSource().generator.getSettings().structureConfig  = tempMap;
        }
	}
}
        
