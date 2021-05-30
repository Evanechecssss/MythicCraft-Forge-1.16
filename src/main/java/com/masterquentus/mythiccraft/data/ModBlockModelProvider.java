package com.masterquentus.mythiccraft.data;


import com.masterquentus.mythiccraft.MythicCraft;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockModelProvider extends BlockModelProvider {
    public ModBlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MythicCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}