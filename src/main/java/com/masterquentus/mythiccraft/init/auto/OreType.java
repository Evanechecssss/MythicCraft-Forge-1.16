package com.masterquentus.mythiccraft.init.auto;

import com.masterquentus.mythiccraft.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

// you'll have to set the right maxHeight, minHeight, veinSize, veinsPerChunk for everything. idk what you want
// if you want nether and overworld ores to have different heights / rarities, you'll have to add more parameters to the enum
public enum OreType {
	VAMPIRIC(ItemInit.VAMPIRIC_GEM, 2, 15, 1, 50, 10, 4, 10),
	MYTHICDIAMOND(ItemInit.MYTHIC_DIAMOND, 3, 15, 1, 50, 10, 4, 10), 
	SILVER(null, 2, 15, 2, 50, 10, 4, 10),
	DRAGONHEART(null, 0.5F, 15, 2, 50, 10, 4, 10), 
	BLOODSTONE(null, 3, 15, 2, 50, 10, 4, 10),
	MOONSTONE(ItemInit.moonstone, 0.5F, 15, 2, 50, 10, 4, 10),
	ROSEQUARTZ(ItemInit.ROSE_QUARTZ, 0.5F, 15, 2, 50, 10, 4, 10), 
	RUBY(ItemInit.AMETHYST, 3, 15, 2, 50, 10, 4, 10),
	SAPPHIRE(ItemInit.SAPPHIRE, 3, 15, 2, 50, 10, 4, 10), 
	AMETHYST(ItemInit.AMETHYST, 3, 15, 2, 50, 10, 4, 10),
	SALT(ItemInit.AMETHYST, 3, 15, 2, 50, 10, 4, 10),
	MAGICAL(ItemInit.magical_dust, 3, 15, 2, 50, 10, 4, 10),
	CRYSTAL(ItemInit.magic_crystal, 3, 15, 2, 50, 10, 4, 10), 
	FROSTSTEEL(null, 3, 15, 2, 50, 10, 4, 10);

	public final float mineTime;
	public final int blastResist;
	public final int harvestLevel;
	public final int maxHeight;
	public final int minHeight;
	public final int veinSize;
	public final int veinsPerChunk;
	public Supplier<Block> block;
	public Supplier<Block> overworld;
	public Supplier<Block> nether;
	public Supplier<Block> end;
	public Supplier<Item> fortunableDrop;

	OreType(Supplier<Item> drop, float mineTime, int blastResist, int harvestLevel, int maxHeight, int minHeight,
			int veinSize, int veinsPerChunk) {
		this.mineTime = mineTime;
		this.blastResist = blastResist;
		this.harvestLevel = harvestLevel;
		this.maxHeight = maxHeight;
		this.minHeight = minHeight;
		this.veinSize = veinSize;
		this.veinsPerChunk = veinsPerChunk;
		this.fortunableDrop = drop;
	}

	public void register(DeferredRegister<Block> blockRegistry) {
		Block.Properties props = Block.Properties.of(Material.STONE).strength(this.mineTime, this.blastResist)
				.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(this.harvestLevel);
		this.overworld = blockRegistry.register(this.name().toLowerCase() + "_ore", () -> new Block(props));
		this.nether = blockRegistry.register(this.name().toLowerCase() + "_netherore", () -> new Block(props));
		this.end = blockRegistry.register(this.name().toLowerCase() + "_endore", () -> new Block(props));
		this.block = blockRegistry.register(this.name().toLowerCase() + "_block", () -> new Block(props));
	}
}
