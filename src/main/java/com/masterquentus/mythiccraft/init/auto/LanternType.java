package com.masterquentus.mythiccraft.init.auto;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Supplier;

public enum LanternType {
    BLOOD("attracts vampires", 5, (pos, world) -> {

    }),
    UNDEAD("attracts undead", 5, (pos, world) -> {

    }),
    SILVER("attracts werewolves", 5, (pos, world) -> {

    }),
    SOUL("ensnares mobs", 5, (pos, world) -> {

    }),
    ENDER("attracts endermen", 5, (pos, world) -> {

    }),
    MYSTIC("attracts magical creatures", 5, (pos, world) -> {

    }),
    FAIRY("attracts fairies", 5, (pos, world) -> {

    }),
    PIXIE("attracts pixies", 5, (pos, world) -> {

    }),
    LIFE("heals players", 5, (pos, world) -> {

    }),
    LOVE("breeds mobs", 5, (pos, world) -> {

    }),
    FERAL("hurts mobs", 5, (pos, world) -> {

    }),
    KRAKEN("attracts krakens", 5, (pos, world) -> {

    });

    public final int range;
    public final String description;
    public final ILanternAction action;
    public Supplier<Block> block;
    LanternType(String description, int range, ILanternAction action){
        this.description = description;
        this.action = action;
        this.range = range;
    }

    public interface ILanternAction{
        void tick(BlockPos pos, World world);
    }
}
