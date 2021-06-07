package com.masterquentus.mythiccraft.data;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.init.auto.OreType;
import com.masterquentus.mythiccraft.init.auto.StoneType;

import com.masterquentus.mythiccraft.init.auto.WoodTypes;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    @SuppressWarnings("unused")
	private final ModBlockModelProvider blockModels;

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, MythicCraft.MOD_ID, exFileHelper);
        MythicCraft.LOGGER.debug("!!! ModBlockStateProvider !!!");


        this.blockModels = new ModBlockModelProvider(gen, exFileHelper) {
            @Override protected void registerModels() {}
        };
    }

    @Override
    protected void registerStatesAndModels() {
        for (WoodTypes woodType : WoodTypes.values()){
            this.createWoodStates(woodType.name().toLowerCase(), woodType);
        }

        for (StoneType stoneType : StoneType.values()){
            for (StoneType.StoneVariation stoneVariation : StoneType.StoneVariation.values()){
                createStoneStates(stoneType, stoneVariation);
            }
        }

        for (OreType ore : OreType.values()){
            simpleBlock(ore.block.get());
            simpleBlock(ore.overworld.get());
            simpleBlock(ore.nether.get());
            simpleBlock(ore.end.get());
        }
    }

    private void createStoneStates(StoneType stoneType, StoneType.StoneVariation stoneVariation) {
        Block base = stoneType.blocks.get(stoneVariation).get();
        simpleBlock(base);
        wallBlock((WallBlock) stoneType.walls.get(stoneVariation).get(), blockTexture(base));
        slabBlock((SlabBlock) stoneType.slabs.get(stoneVariation).get(), blockTexture(base), blockTexture(base));
        stairsBlock((StairsBlock) stoneType.stairs.get(stoneVariation).get(), blockTexture(base));
    }


    private void createWoodStates(String name, WoodTypes wood){
        simpleBlock(wood.plank.get());
        simpleBlock(wood.leaves.get());
        simpleBlock(wood.wood.get());
        simpleBlock(wood.strippedWood.get());

        fenceBlock((FenceBlock) wood.fence.get(), blockTexture(wood.plank.get()));
        fenceGateBlock((FenceGateBlock) wood.gate.get(), blockTexture(wood.plank.get()));
        slabBlock((SlabBlock) wood.slab.get(), blockTexture(wood.plank.get()), blockTexture(wood.plank.get()));
        stairsBlock((StairsBlock) wood.stairs.get(), blockTexture(wood.plank.get()));
        trapdoorBlock((TrapDoorBlock) wood.trapdoor.get(), blockTexture(wood.plank.get()), true);

        // log
        axisBlock((RotatedPillarBlock) wood.log.get(), extend("block/" + name, "_log"), extend("block/" + name, "_log_top"));
        axisBlock((RotatedPillarBlock) wood.strippedLog.get(), extend("block/" + name, "_stripped_log"), extend("block/" + name, "_stripped_log_top"));

    }

    private ResourceLocation extend(String prefix, String suffix) {
        return new ResourceLocation(MythicCraft.MOD_ID, prefix + suffix);
    }
}
