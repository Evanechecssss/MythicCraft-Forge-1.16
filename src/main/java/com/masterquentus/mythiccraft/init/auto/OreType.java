package com.masterquentus.mythiccraft.init.auto;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

// you'll have to set the right maxHeight, minHeight, veinSize, veinsPerChunk for everything. idk what you want
// if you want nether and overworld ores to have different heights / rarities, you'll have to add more parameters to the enum
public enum OreType {
    VAMPIRIC(3, 15, 1, 50, 10, 4, 10),
    MYTHICDIAMOND(3, 15, 1, 50, 10, 4, 10),
    SILVER(3, 15, 2, 50, 10, 4, 10),
    DRAGONHEART(0.5F, 15, 2, 50, 10, 4, 10),
    BLOODSTONE(3, 15, 2, 50, 10, 4, 10),
    MOONSTONE(0.5F, 15, 2, 50, 10, 4, 10),
    ROSEQUARTZ(0.5F, 15, 2, 50, 10, 4, 10),
    RUBY(3, 15, 2, 50, 10, 4, 10),
    SAPPHIRE(3, 15, 2, 50, 10, 4, 10),
    AMETHYST(3, 15, 2, 50, 10, 4, 10),
    SALT(3, 15, 2, 50, 10, 4, 10),
    MAGICAL(3, 15, 2, 50, 10, 4, 10),
    CRYSTAL(3, 15, 2, 50, 10, 4, 10),
    FROSTSTEEL(3, 15, 2, 50, 10, 4, 10);

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
    OreType(float mineTime, int blastResist, int harvestLevel, int maxHeight, int minHeight, int veinSize, int veinsPerChunk){
        this.mineTime = mineTime;
        this.blastResist = blastResist;
        this.harvestLevel = harvestLevel;
        this.maxHeight = maxHeight;
        this.minHeight = minHeight;
        this.veinSize = veinSize;
        this.veinsPerChunk = veinsPerChunk;
    }

    public void register(DeferredRegister<Block> blockRegistry) {
        Block.Properties props = Block.Properties.of(Material.STONE).strength(this.mineTime, this.blastResist).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(this.harvestLevel);
        this.overworld = blockRegistry.register(this.name().toLowerCase() + "_ore", () -> new Block(props));
        this.nether = blockRegistry.register(this.name().toLowerCase() + "_netherore", () -> new Block(props));
        this.end = blockRegistry.register(this.name().toLowerCase() + "_endore", () -> new Block(props));
        this.block = blockRegistry.register(this.name().toLowerCase() + "_block", () -> new Block(props));
    }
}
