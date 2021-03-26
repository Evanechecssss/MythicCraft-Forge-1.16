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

public class SilverWoodTree extends Tree {

	public static final TreeFeatureConfig SILVERWOOD_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.silverwood_log.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInit.silverwood_leaves.get().getDefaultState()),
			new BlobFoliagePlacer(2, 3))).baseHeight(5).heightRandA(5).foliageHeight(2).ignoreVines()
					.setSapling((IPlantable) BlockInit.silverwood_sapling.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(SILVERWOOD_TREE_CONFIG);
	}

}
