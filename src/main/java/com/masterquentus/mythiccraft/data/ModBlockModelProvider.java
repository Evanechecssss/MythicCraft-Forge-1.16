package com.masterquentus.mythiccraft.data;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockModelProvider extends BlockModelProvider {
    public ModBlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MythicCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        BlockInit.WOOD_TYPES.forEach(this::createWoodModels);
    }


    private void createWoodModels(String name, BlockInit.WoodType wood){

    }
}