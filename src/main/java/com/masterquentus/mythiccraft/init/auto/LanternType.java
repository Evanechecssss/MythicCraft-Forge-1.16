package com.masterquentus.mythiccraft.init.auto;

import com.masterquentus.mythiccraft.entities.FairyEntity;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.EndermanEntity;
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
    BLOOD("Attracts Vampires", (pos, world) -> {
        // vampires dont exist...
    }),
    UNDEAD("Attracts All Mobs", (pos, world) -> {
        if (world.getGameTime() % 20 != 0) return;
        Predicate<Entity> check = (e) -> e instanceof MobEntity; // && ((MobEntity)e).getMobType() == CreatureAttribute.UNDEAD;
        for (Entity target : getEntities(7, pos, world, check)) {
            ((MobEntity) target).getNavigation().moveTo(pos.getX(), pos.getY(), pos.getZ(), 1);
        }
    }),
    SILVER("Attracts Werewolves", (pos, world) -> {
        // werewolves dont exist...
    }),
    SOUL("Ensnares Mobs", (pos, world) -> {
        if (world.getGameTime() % 10 != 0) return;
        Predicate<Entity> check = (e) -> e instanceof MobEntity;
        for (Entity target : getEntities(7, pos, world, check)) {
            ((MobEntity) target).getNavigation().stop();
        }
    }),
    ENDER("Attracts Endermen", (pos, world) -> {
        if (world.getGameTime() % 20 != 0) return;
        Predicate<Entity> check = (e) -> e instanceof EndermanEntity;
        for (Entity target : getEntities(7, pos, world, check)) {
            ((MobEntity) target).getNavigation().moveTo(pos.getX(), pos.getY(), pos.getZ(), 1);
            // Will Keep Enderman From Teleporting As Well
            ((MobEntity) target).setHealth(0);
        }
    }),
    MYSTIC("Attracts Magical Creatures", (pos, world) -> {
        // idk which are magical
        //Will Do Something Diffrent
    }),
    FAIRY("Attracts Fairies", (pos, world) -> {
        if (world.getGameTime() % 20 != 0) return;
        Predicate<Entity> check = (e) -> e instanceof FairyEntity;
        for (Entity target : getEntities(7, pos, world, check)) {
            ((MobEntity) target).getNavigation().moveTo(pos.getX(), pos.getY(), pos.getZ(), 1);
        }
    }),
    PIXIE("Attracts Pixies", (pos, world) -> {
        // pixies dont exist
    }),
    LIFE("Heals Players", (pos, world) -> {
        if (world.getGameTime() % 100 != 0) return;
        Predicate<Entity> check = (e) -> e instanceof PlayerEntity;
        for (Entity player : getEntities(5, pos, world, check)) {
            ((LivingEntity) player).heal(2);
        }
    }),
    LOVE("Breeds Mobs", (pos, world) -> {
        if (world.getGameTime() % 20 != 0) return;
        Predicate<Entity> check = (e) -> e instanceof AnimalEntity;
        for (Entity animal : getEntities(5, pos, world, check)) {
            if (((AnimalEntity) animal).canFallInLove() && ((AnimalEntity) animal).getAge() == 0)
                ((AnimalEntity) animal).setInLove(null);
            ((MobEntity) animal).getNavigation().moveTo(pos.getX(), pos.getY(), pos.getZ(), 1);
        }
    }),
    FERAL("Hurts and Attracts Mobs", (pos, world) -> {
        if (world.getGameTime() % 20 != 0) return;
        Predicate<Entity> check = (e) -> e instanceof LivingEntity && !(e instanceof PlayerEntity);
        for (Entity mob : getEntities(5, pos, world, check)) {
            mob.hurt(DamageSource.MAGIC, 1);
            ((MobEntity) mob).getNavigation().moveTo(pos.getX(), pos.getY(), pos.getZ(), 1);
        }
    }),
    KRAKEN("Attracts Krakens", (pos, world) -> {
        // krakens dont exist
        // A Ocean Will Have To Be Near By
    });

    public final String description;
    public final ILanternAction action;
    public Supplier<Block> block;

    LanternType(String description, ILanternAction action) {
        this.description = description;
        this.action = action;
    }

    public interface ILanternAction {
        void tick(BlockPos pos, World world);
    }

    static List<Entity> getEntities(int range, BlockPos pos, World world, Predicate<Entity> condition) {
        AxisAlignedBB box = new AxisAlignedBB(pos.offset(range, range, range), pos.offset(-range, -range, -range));
        return world.getEntities((Entity) null, box, condition);
    }
}
