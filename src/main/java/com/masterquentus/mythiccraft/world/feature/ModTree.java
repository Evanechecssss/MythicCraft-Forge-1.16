package com.masterquentus.mythiccraft.world.feature;

import com.masterquentus.mythiccraft.init.BlockInit;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import javax.annotation.Nullable;
import java.util.Random;

public class ModTree extends Tree {
    private final String woodTypeName;
    static final BlobFoliagePlacer FOLIAGE_PLAYER = new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3);
    static final StraightTrunkPlacer TRUNK_PLACER = new StraightTrunkPlacer(4, 2, 0);
    static final TwoLayerFeature SIZE_TYPE = new TwoLayerFeature(1, 0, 1);

    public ModTree(String woodTypeName){
        this.woodTypeName = woodTypeName;
    }

    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random rand, boolean p_225546_2_) {
        BlockInit.WoodType type = BlockInit.WOOD_TYPES.get(woodTypeName);
        SimpleBlockStateProvider logs = new SimpleBlockStateProvider(type.log.get().defaultBlockState());
        SimpleBlockStateProvider leaves = new SimpleBlockStateProvider(type.leaves.get().defaultBlockState());
        return Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(logs, leaves, FOLIAGE_PLAYER, TRUNK_PLACER, SIZE_TYPE).ignoreVines().build()));
    }

    public void addToBiome(BiomeGenerationSettings.Builder genSettings){
        genSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, this.getConfiguredFeature(null, false));
    }
}