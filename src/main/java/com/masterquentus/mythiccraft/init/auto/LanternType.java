package com.masterquentus.mythiccraft.init.auto;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public enum LanternType {
    BLOOD("attracts vampires", (pos, world) -> {

    }),
    UNDEAD("attracts undead", (pos, world) -> {

    }),
    SILVER("attracts werewolves", (pos, world) -> {

    }),
    SOUL("ensnares mobs", (pos, world) -> {

    }),
    ENDER("attracts endermen", (pos, world) -> {

    }),
    MYSTIC("attracts magical creatures", (pos, world) -> {

    }),
    FAIRY("attracts fairies", (pos, world) -> {

    }),
    PIXIE("attracts pixies", (pos, world) -> {

    }),
    LIFE("heals players", (pos, world) -> {
        if (world.getGameTime() % 100 != 0) return;
        Predicate<Entity> check = (e) -> e instanceof PlayerEntity;
        for (Entity player : getEntities(5, pos, world, check)){
            ((LivingEntity)player).heal(2);
        }
    }),
    LOVE("breeds mobs", (pos, world) -> {
        if (world.getGameTime() % 100 != 0) return;
        Predicate<Entity> check = (e) -> e instanceof AnimalEntity && ((AnimalEntity)e).canFallInLove() && ((AnimalEntity)e).getAge() == 0;
        for (Entity animal : getEntities(5, pos, world, check)){
            ((AnimalEntity)animal).setInLove(null);
        }
    }),
    FERAL("hurts mobs", (pos, world) -> {
        if (world.getGameTime() % 100 != 0) return;
        Predicate<Entity> check = (e) -> e instanceof LivingEntity && !(e instanceof PlayerEntity);
        for (Entity mob : getEntities(5, pos, world, check)){
            mob.hurt(DamageSource.MAGIC, 2);
        }
    }),
    KRAKEN("attracts krakens", (pos, world) -> {

    });

    public final String description;
    public final ILanternAction action;
    public Supplier<Block> block;
    LanternType(String description, ILanternAction action){
        this.description = description;
        this.action = action;
    }

    public interface ILanternAction{
        void tick(BlockPos pos, World world);
    }

    static List<Entity> getEntities(int range, BlockPos pos, World world, Predicate<Entity> condition){
        AxisAlignedBB box = new AxisAlignedBB(pos.offset(range, range, range), pos.offset(-range, -range, -range));
        return world.getEntities((Entity)null, box, condition);
    }
}
