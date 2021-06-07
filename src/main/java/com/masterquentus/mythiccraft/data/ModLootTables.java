package com.masterquentus.mythiccraft.data;

import com.masterquentus.mythiccraft.init.auto.WoodTypes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.util.ResourceLocation;

import java.util.function.BiConsumer;

public class ModLootTables extends BlockLootTables {
    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> p_accept_1_) {
        this.addTables();
    }

    @Override
    protected void addTables() {
        for (WoodTypes wood : WoodTypes.values()){
            this.add(wood.crate.get(), createShulkerBoxDrop(wood.crate.get()));
        }
    }

}
