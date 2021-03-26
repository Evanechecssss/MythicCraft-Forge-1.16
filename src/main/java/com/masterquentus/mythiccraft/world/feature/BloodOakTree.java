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

public class BloodOakTree extends Tree {
	
	public static final TreeFeatureConfig BLOODOAK_TREE_CONFIG = (new TreeFeatureConfig.Builder( new SimpleBlockStateProvider(BlockInit.bloodoak_log.get().getDefaultState()), new SimpleBlockStateProvider(BlockInit.bloodoak_leaves.get().getDefaultState()), new BlobFoliagePlacer(3, 1))).baseHeight(6).heightRandA(5).foliageHeight(2).ignoreVines().setSapling((IPlantable) BlockInit.bloodoak_sapling.get()).build();

	
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(BLOODOAK_TREE_CONFIG);
	}
	
}

