package com.masterquentus.mythiccraft.util;

import com.masterquentus.mythiccraft.MythicCraft;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class MythicCraftTags {

	public static class Blocks {

        @SuppressWarnings("unused")
		private static Tags.IOptionalNamedTag<Block> createTag(String name) {
            return BlockTags.createOptional(new ResourceLocation(MythicCraft.MOD_ID, name));
        }

        @SuppressWarnings("unused")
		private static Tags.IOptionalNamedTag<Block> createForgeTag(String name) {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }
    }

    public static class Items {

        public static final Tags.IOptionalNamedTag<Item> AMETHYST = createForgeTag("gems/amethyst");
        public static final Tags.IOptionalNamedTag<Item> RUBY = createForgeTag("gems/ruby");
        public static final Tags.IOptionalNamedTag<Item> SAPPHIRE = createForgeTag("gems/sapphire");
        public static final Tags.IOptionalNamedTag<Item> ORE_SILVER = createForgeTag("ores/silver");
        public static final Tags.IOptionalNamedTag<Item> SILVER_INGOT = createForgeTag("ingot/silver");
        public static final Tags.IOptionalNamedTag<Item> SILVER_NUGGET = createForgeTag("nugget/silver");

        @SuppressWarnings("unused")
		private static Tags.IOptionalNamedTag<Item> createTag(String name) {
            return ItemTags.createOptional(new ResourceLocation(MythicCraft.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Item> createForgeTag(String name) {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }
    }
}