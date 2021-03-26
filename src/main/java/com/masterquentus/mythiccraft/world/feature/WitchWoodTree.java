package com.masterquentus.mythiccraft.world.feature;

import java.util.Random;

import com.masterquentus.mythiccraft.init.BlockInit;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class WitchWoodTree extends Tree {
	
	public static final TreeFeatureConfig WITCHWOOD_TREE_CONFIG = (new TreeFeatureConfig.Builder( new SimpleBlockStateProvider(BlockInit.witchwood_log.get().getDefaultState()), new SimpleBlockStateProvider(BlockInit.witchwood_leaves.get().getDefaultState()), new BlobFoliagePlacer(3, 1))).baseHeight(10).heightRandA(3).foliageHeight(4).ignoreVines().setSapling((IPlantable) BlockInit.witchwood_sapling.get()).build();

	
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(WITCHWOOD_TREE_CONFIG);
	}
	
}