package com.masterquentus.mythiccraft.world.gen;

import com.masterquentus.mythiccraft.init.ModEntityTypes;

import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Arrays;
import java.util.List;

public class ModEntityGeneration {

    public static void onEntitySpawn(final BiomeLoadingEvent event) {
        addEntityToSpecificBiomes(event, ModEntityTypes.BASILISK_ENTITY.get(), 5, 2, 4, Biomes.SWAMP,
                Biomes.SWAMP_HILLS, Biomes.BAMBOO_JUNGLE);
        addEntityToAllBiomesOcean(event, ModEntityTypes.UNDERWATER_SLIME.get(), 5, 2, 4);
        addEntityToAllBiomesNoNether(event, ModEntityTypes.PIGLIN.get(), 5, 2, 4);
        removeEntityFromNether(event, ModEntityTypes.UNDERWATER_SLIME.get());
    }

    @SafeVarargs
    @SuppressWarnings("unused")
    private static void addEntityToAllBiomesExceptThese(BiomeLoadingEvent event, EntityType<?> type, int weight,
                                                        int minCount, int maxCount, RegistryKey<Biome>... biomes) {
        boolean isBiomeSelected = Arrays.stream(biomes).map(RegistryKey::location).map(Object::toString)
                .anyMatch(s -> s.equals(event.getName().toString()));

        if (!isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    @SafeVarargs
    private static void addEntityToSpecificBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount,
                                                  int maxCount, RegistryKey<Biome>... biomes) {
        boolean isBiomeSelected = Arrays.stream(biomes).map(RegistryKey::location).map(Object::toString)
                .anyMatch(s -> s.equals(event.getName().toString()));

        if (isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    @SuppressWarnings("unused")
    private static void addEntityToAllOverworldBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight,
                                                      int minCount, int maxCount) {
        if (!event.getCategory().equals(Biome.Category.THEEND) && !event.getCategory().equals(Biome.Category.NETHER)) {
            List<MobSpawnInfo.Spawners> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnInfo.Spawners(type, weight, minCount, maxCount));
        }
    }

    private static void removeEntityFromNether(BiomeLoadingEvent event, EntityType<?> type) {
        if (!event.getCategory().equals(Biome.Category.NETHER)) {
            List<MobSpawnInfo.Spawners> base = event.getSpawns().getSpawner(type.getCategory());
            base.remove(new MobSpawnInfo.Spawners(type, 0, 0, 0));
        }
    }

    @SuppressWarnings("unused")
    private static void addEntityToAllBiomesNoNether(BiomeLoadingEvent event, EntityType<?> type, int weight,
                                                     int minCount, int maxCount) {
        if (!event.getCategory().equals(Biome.Category.NETHER)) {
            List<MobSpawnInfo.Spawners> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnInfo.Spawners(type, weight, minCount, maxCount));
        }
    }

    private static void addEntityToAllBiomesOcean(BiomeLoadingEvent event, EntityType<?> type, int weight,
                                                  int minCount, int maxCount) {
        if (!event.getCategory().equals(Biome.Category.OCEAN)) {
            List<MobSpawnInfo.Spawners> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnInfo.Spawners(type, weight, minCount, maxCount));
        }
    }

    @SuppressWarnings("unused")
    private static void addEntityToAllBiomesNoEnd(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount,
                                                  int maxCount) {
        if (!event.getCategory().equals(Biome.Category.THEEND)) {
            List<MobSpawnInfo.Spawners> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnInfo.Spawners(type, weight, minCount, maxCount));
        }
    }

    private static void addEntityToAllBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount,
                                             int maxCount) {
        List<MobSpawnInfo.Spawners> base = event.getSpawns().getSpawner(type.getCategory());
        base.add(new MobSpawnInfo.Spawners(type, weight, minCount, maxCount));
    }
}