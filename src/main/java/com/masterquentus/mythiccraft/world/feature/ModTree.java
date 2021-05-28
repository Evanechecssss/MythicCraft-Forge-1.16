package com.masterquentus.mythiccraft.world.feature;

import com.masterquentus.mythiccraft.init.BlockInit;
import com.masterquentus.mythiccraft.init.auto.WoodType;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import javax.annotation.Nullable;
import java.util.Random;

public class ModTree extends Tree {
    protected final WoodType woodType;
    protected static final TwoLayerFeature SIZE_TYPE = new TwoLayerFeature(1, 0, 1);

    public ModTree(WoodType woodType){
        this.woodType = woodType;
    }

    protected FoliagePlacer getFoliagePlacer(){
        return new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3);
    }

    protected AbstractTrunkPlacer getTrunkPlacer(){
        return new StraightTrunkPlacer(4, 2, 0);
    }

    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random rand, boolean p_225546_2_) {
        SimpleBlockStateProvider logs = new SimpleBlockStateProvider(this.woodType.log.get().defaultBlockState());
        SimpleBlockStateProvider leaves = new SimpleBlockStateProvider(this.woodType.leaves.get().defaultBlockState());
        return Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(logs, leaves, this.getFoliagePlacer(), this.getTrunkPlacer(), SIZE_TYPE).ignoreVines().build()));
    }

    public void addToBiome(BiomeGenerationSettings.Builder genSettings){
        genSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, this.getConfiguredFeature(null, false));
    }
}