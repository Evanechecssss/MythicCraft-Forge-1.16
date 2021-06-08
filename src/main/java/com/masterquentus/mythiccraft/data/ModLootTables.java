package com.masterquentus.mythiccraft.data;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.init.auto.LanternType;
import com.masterquentus.mythiccraft.init.auto.OreType;
import com.masterquentus.mythiccraft.init.auto.StoneType;
import com.masterquentus.mythiccraft.init.auto.WoodTypes;
import com.masterquentus.mythiccraft.objects.blocks.CrateBlock;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.item.Items;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class ModLootTables extends BlockLootTables {
    @Override
    protected void addTables() {
        for (WoodTypes wood : WoodTypes.values()){
            this.dropSelf(wood.plank.get());
            this.dropSelf(wood.log.get());
            this.dropSelf(wood.strippedLog.get());
            this.dropSelf(wood.wood.get());
            this.dropSelf(wood.strippedWood.get());
            this.dropSelf(wood.sapling.get());
            this.dropSelf(wood.button.get());
            this.dropSelf(wood.door.get());
            this.dropSelf(wood.fence.get());
            this.dropSelf(wood.gate.get());
            this.dropSelf(wood.pressureplate.get());
            this.dropSelf(wood.slab.get());
            this.dropSelf(wood.stairs.get());
            this.dropSelf(wood.trapdoor.get());
            this.add(wood.crate.get(), createShulkerBoxDrop(wood.crate.get()));
            this.add(wood.leaves.get(), (p_218473_0_) -> {
                return createLeavesDrops(p_218473_0_, wood.sapling.get(), new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F});
            });
        }

        for (StoneType stone : StoneType.values()){
            stone.blocks.forEach((type, block) -> this.dropSelf(block.get()));
            stone.buttons.forEach((type, block) -> this.dropSelf(block.get()));
            stone.slabs.forEach((type, block) -> this.dropSelf(block.get()));
            stone.stairs.forEach((type, block) -> this.dropSelf(block.get()));
            stone.walls.forEach((type, block) -> this.dropSelf(block.get()));
        }

        for (OreType ore : OreType.values()){
            this.dropSelf(ore.block.get());

            if (ore.fortunableDrop == null) {
                this.dropSelf(ore.overworld.get());
                this.dropSelf(ore.nether.get());
                this.dropSelf(ore.end.get());
            } else {
                this.add(ore.overworld.get(), (p_241170_0_) -> {
                    return createOreDrop(p_241170_0_, ore.fortunableDrop.get());
                });
                this.add(ore.nether.get(), (p_241170_0_) -> {
                    return createOreDrop(p_241170_0_, ore.fortunableDrop.get());
                });
                this.add(ore.end.get(), (p_241170_0_) -> {
                    return createOreDrop(p_241170_0_, ore.fortunableDrop.get());
                });
            }


        }

        for (LanternType lantern : LanternType.values()){
            this.dropSelf(lantern.block.get());
        }
    }

    // temp. so validation doesnt break todo: loot tables for all blocks
    Set<Block> known = new HashSet<>();

    @Override
    protected void add(Block block, LootTable.Builder loot) {
        super.add(block, loot);
        known.add(block);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> block.getRegistryName().getNamespace().equals(MythicCraft.MOD_ID) && known.contains(block)).collect(Collectors.toList());
    }

}
