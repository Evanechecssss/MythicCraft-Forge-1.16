package com.masterquentus.mythiccraft.world.dimension;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationSettings;

public class UnderworldGenSettings extends GenerationSettings {

	public int getBiomeSize() {
		return 4;
	}
	
	public int getRiverSize() {
		return 4;
	}
	
	public int getBiomeId() {
		return -1;
	}
	
	@Override
	public int getBedrockFloorHeight() {
		return 0;
	}
	
	public UnderworldGenSettings() {
		this.defaultBlock = Blocks.STONE.getDefaultState();
	}
}

