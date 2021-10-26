package com.masterquentus.mythiccraft.init.auto;

import com.masterquentus.mythiccraft.objects.blocks.ModStoneButtonBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.function.Supplier;

public enum StoneType {
	ICYSTONE, MYSTICSTONE, PEARLSTONE, CHARRED, INFESTED, CRIMSON, MARBLE, UNDERWORLD;

	public HashMap<StoneVariation, Supplier<Block>> blocks = new HashMap<>();
	public HashMap<StoneVariation, Supplier<Block>> stairs = new HashMap<>();
	public HashMap<StoneVariation, Supplier<Block>> slabs = new HashMap<>();
	public HashMap<StoneVariation, Supplier<Block>> buttons = new HashMap<>();
	public HashMap<StoneVariation, Supplier<Block>> walls = new HashMap<>();

	public void register(DeferredRegister<Block> blockRegistry) {
		String name = this.name().toLowerCase();
		for (StoneType.StoneVariation variation : StoneType.StoneVariation.values()) {
			String typeString = variation.toString();
			if (variation == StoneType.StoneVariation.STONE && (name.equals("crimson") || name.equals("charred")
					|| name.equals("infested") || name.equals("icy")
					|| name.equals("pearl") || name.equals("mystic") || name.equals("underworld"))) {
				typeString = "stone";
			}
			AbstractBlock.Properties props = Block.Properties.of(Material.STONE).strength(5.0f, 30.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1);
			this.blocks.put(variation, blockRegistry.register(name + (typeString.equals("") ? "" : "_" + typeString),
					() -> new Block(props)));
			this.stairs.put(variation, blockRegistry.register(name + typeString + "_stairs",
					() -> new StairsBlock(() -> this.blocks.get(variation).get().defaultBlockState(), props)));
			this.slabs.put(variation, blockRegistry.register(name + typeString + "_slab", () -> new SlabBlock(props)));
			this.buttons.put(variation,
					blockRegistry.register(name + typeString + "_button", () -> new ModStoneButtonBlock(props)));
			this.walls.put(variation, blockRegistry.register(name + typeString + "_wall", () -> new WallBlock(props)));
		}
	}

	public enum StoneVariation {
		STONE, COBBLE, BRICKS, POLISHED, CHISELED, CRACKED;

		public String toString() {
			switch (this) {
			case STONE:
				return "";
			case COBBLE:
				return "cobble";
			case BRICKS:
				return "bricks";
			case POLISHED:
				return "polished";
			case CHISELED:
				return "chisealed";
			case CRACKED:
				return "cracked";
			}

			return "ERROR_INVALID_STONE_TYPE";
		}
	}
}
