package com.masterquentus.mythiccraft.init;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonElement;
import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.world.dimension.UndeadBiomeProvider;
import com.masterquentus.mythiccraft.world.dimension.WorldDataCompilerAndOps;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.Lifecycle;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.FuzzedBiomeMagnifier;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.NoiseSettings;
import net.minecraft.world.gen.settings.ScalingSettings;
import net.minecraft.world.gen.settings.SlideSettings;

import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;

import static net.minecraft.world.DimensionType.OVERWORLD_EFFECTS;

public class DimensionSetup extends WorldDataCompilerAndOps<JsonElement> {
    public static final RegistryKey<World> UNDERWORLD = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(MythicCraft.MOD_ID, "underworld"));

    public DimensionSetup(DataGenerator generator) {
        super(generator, JsonOps.INSTANCE, GSON::toJson, new DynamicRegistries.Impl());
    }

    @Override
    public void generate(DirectoryCache directoryCache) {
        // ConfiguredSurfaceBuilders.registerConfigurations(dynamicRegistries.getRegistry(Registry.CONFIGURED_SURFACE_BUILDER_KEY));

        // getBiomes().forEach((rl, biome) -> serialize(Registry.BIOME_SOURCE, rl, biome, Biome.CODEC));
        getDimensions().forEach((rl, dimension) -> serialize(Registry.LEVEL_STEM_REGISTRY, rl, dimension, Dimension.CODEC));
    }

    private Map<ResourceLocation, Dimension> getDimensions() {
        Optional<DimensionSettings> underworldDimensionSettings = makeDimensionSettings(
                new DimensionStructuresSettings(Optional.empty(), ImmutableMap.of()),
                new NoiseSettings(
                        128, // Noise Height - This allows us to shorten the world so we can cram more stuff upwards
                        new ScalingSettings(0.9999999814507745D, 0.9999999814507745D, 80.0D, 160.0D),
                        new SlideSettings(-10, 3, 0),
                        new SlideSettings(-30, 0, 0),
                        1,
                        2,
                        1.0D,
                        -0.46875D,
                        false,
                        true,
                        false,
                        false
                ),
                Blocks.STONE.defaultBlockState(),
                Blocks.WATER.defaultBlockState(),
                -20,
                0,
                31,
                false
        );

        // Register the dimension noise settings in the local datagen registry.
        // getOrCreateInRegistry(dynamicRegistries.getRegistry(Registry.NOISE_SETTINGS_KEY), RegistryKey.getOrCreateKey(Registry.NOISE_SETTINGS_KEY, TwilightForestMod.prefix("forest_noise_config")), forestDimensionSettings::get);
        // getOrCreateInRegistry(dynamicRegistries.getRegistry(Registry.NOISE_SETTINGS_KEY), RegistryKey.getOrCreateKey(Registry.NOISE_SETTINGS_KEY, TwilightForestMod.prefix("sky_noise_config")), skyDimensionSettings::get);
        NoiseChunkGenerator underworldChunkGen = new NoiseChunkGenerator(new UndeadBiomeProvider(0L, new SimpleRegistry<>(Registry.BIOME_REGISTRY, Lifecycle.experimental())), 0L, underworldDimensionSettings::get);
        //NoiseChunkGenerator skyChunkGen = new NoiseChunkGenerator(new TFBiomeProvider(0L, new SimpleRegistry<>(Registry.BIOME_KEY, Lifecycle.experimental())), 4L, () -> WorldGenRegistries.NOISE_SETTINGS.getValueForKey(RegistryKey.getOrCreateKey(Registry.NOISE_SETTINGS_KEY, new ResourceLocation("floating_islands"))));
        //NoiseChunkGenerator skyChunkGen = new NoiseChunkGenerator(new CheckerboardBiomeProvider(BiomeMaker.BIOMES.values().stream().sorted((o1, o2) -> Float.compare(o1.getDepth(), o2.getDepth())).map(b -> (Supplier<Biome>) () -> b).collect(Collectors.toList()), 2), 4L, skyDimensionSettings::get);

        Optional<DimensionType> underworldType = makeDimensionType(
                OptionalLong.of(13000L),
                true,
                false,
                false,
                true,
                0.125D,
                false,
                false,
                true,
                true,
                false,
                256,
                FuzzedBiomeMagnifier.INSTANCE,
                new ResourceLocation("infiniburn_overworld"),  // idk what that is
                OVERWORLD_EFFECTS, // DimensionRenderInfo
                0f
        );

        // Register the type in the local datagen registry. Hacky.
        getOrCreateInRegistry(dynamicRegistries.registryOrThrow(Registry.DIMENSION_TYPE_REGISTRY), RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(MythicCraft.MOD_ID, "underworld_type")), underworldType::get);

        return ImmutableMap.of(
                new ResourceLocation(MythicCraft.MOD_ID, "underworld"), new Dimension(underworldType::get, underworldChunkGen)
        );
    }

    /*
    private Map<ResourceLocation, Biome> getBiomes() {
        return BiomeMaker
                .BIOMES
                .entrySet()
                .stream()
                .peek(registryKeyBiomeEntry -> registryKeyBiomeEntry.getValue().setRegistryName(registryKeyBiomeEntry.getKey().getLocation()))
                .collect(Collectors.toMap(entry -> entry.getKey().getLocation(), Map.Entry::getValue));
    }

     */
}
