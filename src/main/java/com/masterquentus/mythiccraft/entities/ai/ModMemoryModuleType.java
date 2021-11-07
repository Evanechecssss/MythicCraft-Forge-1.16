package com.masterquentus.mythiccraft.entities.ai;

import com.mojang.serialization.Codec;
import net.minecraft.entity.ai.brain.Memory;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import java.util.Optional;

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 03.11.2021
 * \* Description:
 * \
 */
public class ModMemoryModuleType<U> extends MemoryModuleType<U>   {
    public static final net.minecraft.entity.ai.brain.memory.MemoryModuleType<PlayerEntity> NEAREST_TARGETABLE_PLAYER_NOT_WEARING_VAMPIRE_ARMORE = register("nearest_targetable_player_not_wearing_vampire_armore");
    private final Optional<Codec<Memory<U>>> codec;

    public ModMemoryModuleType(Optional<Codec<U>> p_i50306_1_) {
        super(p_i50306_1_);
        this.codec = p_i50306_1_.map(Memory::codec);
    }

    public String toString() {
        return Registry.MEMORY_MODULE_TYPE.getKey(this).toString();
    }

    public Optional<Codec<Memory<U>>> getCodec() {
        return this.codec;
    }

    private static <U> net.minecraft.entity.ai.brain.memory.MemoryModuleType<U> register(String p_234108_0_, Codec<U> p_234108_1_) {
        return Registry.register(Registry.MEMORY_MODULE_TYPE, new ResourceLocation(p_234108_0_), new net.minecraft.entity.ai.brain.memory.MemoryModuleType<>(Optional.of(p_234108_1_)));
    }

    private static <U> net.minecraft.entity.ai.brain.memory.MemoryModuleType<U> register(String p_223541_0_) {
        return Registry.register(Registry.MEMORY_MODULE_TYPE, new ResourceLocation(p_223541_0_), new net.minecraft.entity.ai.brain.memory.MemoryModuleType<>(Optional.empty()));
    }
}