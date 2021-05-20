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

public class TwistedTree extends Tree {
	
	public static final TreeFeatureConfig TWISTED_TREE_CONFIG = (new TreeFeatureConfig.Builder( new SimpleBlockStateProvider(BlockInit.TWISTED_LOG.get().getDefaultState()), new SimpleBlockStateProvider(BlockInit.TWISTED_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(3, 1))).baseHeight(10).heightRandA(3).foliageHeight(4).ignoreVines().setSapling((IPlantable) BlockInit.TWISTED_SAPLING.get()).build();

	
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(TWISTED_TREE_CONFIG);
	}
	
}