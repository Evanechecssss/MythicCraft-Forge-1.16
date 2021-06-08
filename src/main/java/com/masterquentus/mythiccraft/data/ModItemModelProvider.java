package com.masterquentus.mythiccraft.data;


import com.google.common.collect.ImmutableList;
import com.masterquentus.mythiccraft.MythicCraft;

import com.masterquentus.mythiccraft.init.ItemInit;
import com.masterquentus.mythiccraft.init.auto.LanternType;
import com.masterquentus.mythiccraft.init.auto.OreType;
import com.masterquentus.mythiccraft.init.auto.StoneType;
import com.masterquentus.mythiccraft.init.auto.WoodTypes;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.resources.ResourcePackType;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MythicCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (WoodTypes wood : WoodTypes.values()){
            this.basicBlock(wood.plank.get());
            this.basicBlock(wood.log.get());
            this.basicBlock(wood.strippedLog.get());
            this.basicBlock(wood.wood.get());
            this.basicBlock(wood.strippedWood.get());
            this.basicBlock(wood.sapling.get());
            this.basicBlock(wood.button.get());
            this.basicBlock(wood.gate.get());
            this.basicBlock(wood.pressureplate.get());
            this.basicBlock(wood.slab.get());
            this.basicBlock(wood.stairs.get());
            this.basicBlock(wood.trapdoor.get());
            this.basicBlock(wood.crate.get());
            this.basicBlock(wood.leaves.get());

            // door should be a basic item
            // fence should parent block/name_door_inventory
            /*
            {
              "parent": "minecraft:block/fence_inventory",
              "textures": {
                "texture": "minecraft:block/oak_planks"
              }
            }
             */
            this.basicBlock(wood.door.get());
            this.basicBlock(wood.fence.get());

        }

        for (StoneType stone : StoneType.values()){
            stone.blocks.forEach((type, block) -> this.basicBlock(block.get()));
            stone.buttons.forEach((type, block) -> this.basicBlock(block.get()));
            stone.slabs.forEach((type, block) -> this.basicBlock(block.get()));
            stone.stairs.forEach((type, block) -> this.basicBlock(block.get()));
            stone.walls.forEach((type, block) -> this.basicBlock(block.get()));
        }

        for (OreType ore : OreType.values()){
            this.basicBlock(ore.block.get());
            this.basicBlock(ore.overworld.get());
            this.basicBlock(ore.nether.get());
            this.basicBlock(ore.end.get());
        }

        for (LanternType lantern : LanternType.values()){
            basicBlock(lantern.block.get());
        }
    }

    protected void basicBlock(Block block) {
        Item item = block.asItem();
        getBuilder(item.getRegistryName().toString())
                .parent(new ModelFile.UncheckedModelFile(modLoc("block/" + item.getRegistryName().getPath())));
    }

    protected void basicItem(Item item) {
        String path = item.getRegistryName().getPath();
        if (existingFileHelper.exists(modLoc("item/" + path), ResourcePackType.CLIENT_RESOURCES, ".png", "textures")) {
            getBuilder(path).parent(new ModelFile.UncheckedModelFile(mcLoc("item/generated")))
                    .texture("layer0", modLoc("item/" + path));
        } else {
            System.out.println("no texture for " + item + " found, skipping");
        }
    }
}