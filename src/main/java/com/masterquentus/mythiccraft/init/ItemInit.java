package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.MythicCraft.MythicCraftItems;
import com.masterquentus.mythiccraft.objects.blocks.ModEntityTypes;
import com.masterquentus.mythiccraft.objects.items.DragonBoneBow;
import com.masterquentus.mythiccraft.objects.items.FlintAndHellFireItem;
import com.masterquentus.mythiccraft.objects.items.ModSpawnEggItem;
import com.masterquentus.mythiccraft.objects.items.VampriricItem;
import com.masterquentus.mythiccraft.objects.items.WoodAshItem;
import com.masterquentus.mythiccraft.util.enums.ModArmorMaterials;
import com.masterquentus.mythiccraft.util.enums.ModItemTiers;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,
			MythicCraft.MOD_ID);

	// Items
	public static final RegistryObject<Item> VAMPIRIC_GEM = ITEMS.register("vampiric_gem",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> MYTHIC_DIAMOND = ITEMS.register("mythic_diamond",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> BLOODSTONE_INGOT = ITEMS.register("bloodstone_ingot",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> BLOODSTONE_NUGGET = ITEMS.register("bloodstone_nugget",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> DRAGONHEART_INGOT = ITEMS.register("dragonheart_ingot",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> DRAGONHEART_NUGGET = ITEMS.register("dragonheart_nugget",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> PUREGLOWSTONE_DUST = ITEMS.register("pureglowstone_dust",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> DARKGLOWSTONE_DUST = ITEMS.register("darkglowstone_dust",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> ROSE_QUARTZ = ITEMS.register("rose_quartz",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> FAIRY_DUST = ITEMS.register("fairy_dust",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)
					.food(new Food.Builder().setAlwaysEdible().hunger(2).saturation(0.4f)
							.effect(new EffectInstance(Effects.GLOWING, 3000, 5), 0.7f)
							.effect(new EffectInstance(Effects.LEVITATION, 6000, 5), 0.7f)
							.effect(new EffectInstance(Effects.ABSORPTION, 6000, 5), 0.7f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> PIXIE_DUST = ITEMS.register("pixie_dust",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)
					.food(new Food.Builder().setAlwaysEdible().hunger(2).saturation(0.4f)
							.effect(new EffectInstance(Effects.GLOWING, 3000, 5), 0.7f)
							.effect(new EffectInstance(Effects.LEVITATION, 6000, 5), 0.7f)
							.effect(new EffectInstance(Effects.FIRE_RESISTANCE, 6000, 5), 0.7f).build())));
	public static final RegistryObject<Item> UNICORN_HORN = ITEMS.register("unicorn_horn",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> basilisk_scale = ITEMS.register("basilisk_scale",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> mermaid_scale = ITEMS.register("mermaid_scale",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> siren_scale = ITEMS.register("siren_scale",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> kraken_scale = ITEMS.register("kraken_scale",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> kraken_tooth = ITEMS.register("kraken_tooth",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_red = ITEMS.register("dragonscale_red",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_amethyst = ITEMS.register("dragonscale_amethyst",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_black = ITEMS.register("dragonscale_black",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_green = ITEMS.register("dragonscale_green",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_gray = ITEMS.register("dragonscale_gray",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_white = ITEMS.register("dragonscale_white",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_sapphire = ITEMS.register("dragonscale_sapphire",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_silver = ITEMS.register("dragonscale_silver",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_blue = ITEMS.register("dragonscale_blue",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<VampriricItem> vampiric_ring = ITEMS.register("vampiric_ring",
			() -> new VampriricItem(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> daylight_ring = ITEMS.register("daylight_ring",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> wolfsbane = ITEMS.register("wolfsbane",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> vervain = ITEMS.register("vervain",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> belladonna = ITEMS.register("belladonna",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> mandrake = ITEMS.register("mandrake",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> foxgloves = ITEMS.register("foxgloves",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> wormwood = ITEMS.register("wormwood",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> nightshade = ITEMS.register("nightshade",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> hellebore = ITEMS.register("hellebore",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> whitesage = ITEMS.register("whitesage",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> waterartichoke = ITEMS.register("waterartichoke",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> icy_needle = ITEMS.register("icy_needle",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> moonstone = ITEMS.register("moonstone",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> ash = ITEMS.register("ash",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> magic_crystal = ITEMS.register("magic_crystal",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> witches_hand = ITEMS.register("witches_hand",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> infested_goo = ITEMS.register("infested_goo",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> infested_slimeball = ITEMS.register("infested_slimeball",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> charred_slimeball = ITEMS.register("charred_slimeball",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragon_bone = ITEMS.register("dragon_bone",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_lilith = ITEMS.register("contract_lilith",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_pandora = ITEMS.register("contract_pandora",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_death = ITEMS.register("contract_death",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_medusa = ITEMS.register("contract_medusa",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_mirrordemon = ITEMS.register("contract_mirrordemon",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_lust = ITEMS.register("contract_lust",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_wrath = ITEMS.register("contract_wrath",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_envy = ITEMS.register("contract_envy",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_pride = ITEMS.register("contract_pride",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_sloth = ITEMS.register("contract_sloth",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_greed = ITEMS.register("contract_greed",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_gluttony = ITEMS.register("contract_gluttony",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> soul_bottle = ITEMS.register("soul_bottle",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> magical_gear = ITEMS.register("magical_gear",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> salt = ITEMS.register("salt",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> magical_dust = ITEMS.register("magical_dust",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> lilith_bloodbottle = ITEMS.register("lilith_bloodbottle",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> pandora_bloodbottle = ITEMS.register("pandora_bloodbottle",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> death_bloodbottle = ITEMS.register("death_bloodbottle",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> medusa_bloodbottle = ITEMS.register("medusa_bloodbottle",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> mirrordemon_bloodbottle = ITEMS.register("mirrordemon_bloodbottle",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> lust_bloodbottle = ITEMS.register("lust_bloodbottle",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> wrath_bloodbottle = ITEMS.register("wrath_bloodbottle",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> envy_bloodbottle = ITEMS.register("envy_bloodbottle",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> pride_bloodbottle = ITEMS.register("pride_bloodbottle",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> sloth_bloodbottle = ITEMS.register("sloth_bloodbottle",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> greed_bloodbottle = ITEMS.register("greed_bloodbottle",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> gluttony_bloodbottle = ITEMS.register("gluttony_bloodbottle",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));

	// Rune's
	public static final RegistryObject<Item> blank_rune = ITEMS.register("blank_rune",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> fire_rune = ITEMS.register("fire_rune",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> water_rune = ITEMS.register("water_rune",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> earth_rune = ITEMS.register("earth_rune",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> air_rune = ITEMS.register("air_rune",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> yellow_rune = ITEMS.register("yellow_rune",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> purple_rune = ITEMS.register("purple_rune",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> black_rune = ITEMS.register("black_rune",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> blue_rune = ITEMS.register("blue_rune",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> red_rune = ITEMS.register("red_rune",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> white_rune = ITEMS.register("white_rune",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> orange_rune = ITEMS.register("orange_rune",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> green_rune = ITEMS.register("green_rune",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)));

	// Armor
	public static final RegistryObject<ArmorItem> vampiric_helmet = ITEMS.register("vampiric_helmet",
			() -> new ArmorItem(ModArmorMaterials.VAMPIRIC, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> vampiric_chestplate = ITEMS.register("vampiric_chestplate",
			() -> new ArmorItem(ModArmorMaterials.VAMPIRIC, EquipmentSlotType.CHEST,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> vampiric_leggings = ITEMS.register("vampiric_leggings",
			() -> new ArmorItem(ModArmorMaterials.VAMPIRIC, EquipmentSlotType.LEGS,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> vampiric_boots = ITEMS.register("vampiric_boots",
			() -> new ArmorItem(ModArmorMaterials.VAMPIRIC, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> silver_helmet = ITEMS.register("silver_helmet",
			() -> new ArmorItem(ModArmorMaterials.SILVER, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> silver_chestplate = ITEMS.register("silver_chestplate",
			() -> new ArmorItem(ModArmorMaterials.SILVER, EquipmentSlotType.CHEST,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> silver_leggings = ITEMS.register("silver_leggings",
			() -> new ArmorItem(ModArmorMaterials.SILVER, EquipmentSlotType.LEGS,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> silver_boots = ITEMS.register("silver_boots",
			() -> new ArmorItem(ModArmorMaterials.SILVER, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> mythicdiamond_helmet = ITEMS.register("mythicdiamond_helmet",
			() -> new ArmorItem(ModArmorMaterials.MYTHICDIAMOND, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> mythicdiamond_chestplate = ITEMS.register("mythicdiamond_chestplate",
			() -> new ArmorItem(ModArmorMaterials.MYTHICDIAMOND, EquipmentSlotType.CHEST,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> mythicdiamond_leggings = ITEMS.register("mythicdiamond_leggings",
			() -> new ArmorItem(ModArmorMaterials.MYTHICDIAMOND, EquipmentSlotType.LEGS,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> mythicdiamond_boots = ITEMS.register("mythicdiamond_boots",
			() -> new ArmorItem(ModArmorMaterials.MYTHICDIAMOND, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonheart_helmet = ITEMS.register("dragonheart_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONHEART, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonheart_chestplate = ITEMS.register("dragonheart_chestplate",
			() -> new ArmorItem(ModArmorMaterials.DRAGONHEART, EquipmentSlotType.CHEST,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonheart_leggings = ITEMS.register("dragonheart_leggings",
			() -> new ArmorItem(ModArmorMaterials.DRAGONHEART, EquipmentSlotType.LEGS,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonheart_boots = ITEMS.register("dragonheart_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONHEART, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalered_helmet = ITEMS.register("dragonscalered_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALERED, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalered_chestplate = ITEMS
			.register("dragonscalered_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALERED,
					EquipmentSlotType.CHEST, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalered_leggings = ITEMS.register("dragonscalered_leggings",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALERED, EquipmentSlotType.LEGS,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalered_boots = ITEMS.register("dragonscalered_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALERED, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleamethyst_helmet = ITEMS
			.register("dragonscaleamethyst_helmet", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEAMETHYST,
					EquipmentSlotType.HEAD, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleamethyst_chestplate = ITEMS
			.register("dragonscaleamethyst_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEAMETHYST,
					EquipmentSlotType.CHEST, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleamethyst_leggings = ITEMS
			.register("dragonscaleamethyst_leggings", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEAMETHYST,
					EquipmentSlotType.LEGS, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleamethyst_boots = ITEMS
			.register("dragonscaleamethyst_boots", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEAMETHYST,
					EquipmentSlotType.FEET, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleblack_helmet = ITEMS.register("dragonscaleblack_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEBLACK, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleblack_chestplate = ITEMS
			.register("dragonscaleblack_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEBLACK,
					EquipmentSlotType.CHEST, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleblack_leggings = ITEMS
			.register("dragonscaleblack_leggings", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEBLACK,
					EquipmentSlotType.LEGS, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleblack_boots = ITEMS.register("dragonscaleblack_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEBLACK, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalegreen_helmet = ITEMS.register("dragonscalegreen_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEGREEN, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalegreen_chestplate = ITEMS
			.register("dragonscalegreen_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEGREEN,
					EquipmentSlotType.CHEST, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalegreen_leggings = ITEMS
			.register("dragonscalegreen_leggings", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEGREEN,
					EquipmentSlotType.LEGS, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalegreen_boots = ITEMS.register("dragonscalegreen_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEGREEN, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalegray_helmet = ITEMS.register("dragonscalegray_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEGRAY, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalegray_chestplate = ITEMS
			.register("dragonscalegray_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEGRAY,
					EquipmentSlotType.CHEST, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalegray_leggings = ITEMS.register("dragonscalegray_leggings",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEGRAY, EquipmentSlotType.LEGS,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalegray_boots = ITEMS.register("dragonscalegray_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEGRAY, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalewhite_helmet = ITEMS.register("dragonscalewhite_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEWHITE, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalewhite_chestplate = ITEMS
			.register("dragonscalewhite_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEWHITE,
					EquipmentSlotType.CHEST, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalewhite_leggings = ITEMS
			.register("dragonscalewhite_leggings", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEWHITE,
					EquipmentSlotType.LEGS, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalewhite_boots = ITEMS.register("dragonscalewhite_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEWHITE, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalesapphire_helmet = ITEMS
			.register("dragonscalesapphire_helmet", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALESAPPHIRE,
					EquipmentSlotType.HEAD, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalesapphire_chestplate = ITEMS
			.register("dragonscalesapphire_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALESAPPHIRE,
					EquipmentSlotType.CHEST, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalesapphire_leggings = ITEMS
			.register("dragonscalesapphire_leggings", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALESAPPHIRE,
					EquipmentSlotType.LEGS, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalesapphire_boots = ITEMS
			.register("dragonscalesapphire_boots", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALESAPPHIRE,
					EquipmentSlotType.FEET, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalesilver_helmet = ITEMS.register("dragonscalesilver_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALESILVER, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalesilver_chestplate = ITEMS
			.register("dragonscalesilver_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALESILVER,
					EquipmentSlotType.CHEST, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalesilver_leggings = ITEMS
			.register("dragonscalesilver_leggings", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALESILVER,
					EquipmentSlotType.LEGS, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalesilver_boots = ITEMS.register("dragonscalesilver_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALESILVER, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleblue_helmet = ITEMS.register("dragonscaleblue_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEBLUE, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleblue_chestplate = ITEMS
			.register("dragonscaleblue_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEBLUE,
					EquipmentSlotType.CHEST, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleblue_leggings = ITEMS.register("dragonscaleblue_leggings",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEBLUE, EquipmentSlotType.LEGS,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleblue_boots = ITEMS.register("dragonscaleblue_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEBLUE, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> siren_helmet = ITEMS.register("siren_helmet",
			() -> new ArmorItem(ModArmorMaterials.SIREN, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> siren_chestplate = ITEMS.register("siren_chestplate",
			() -> new ArmorItem(ModArmorMaterials.SIREN, EquipmentSlotType.CHEST,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> siren_leggings = ITEMS.register("siren_leggings",
			() -> new ArmorItem(ModArmorMaterials.SIREN, EquipmentSlotType.LEGS,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> siren_boots = ITEMS.register("siren_boots",
			() -> new ArmorItem(ModArmorMaterials.SIREN, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> mermaid_helmet = ITEMS.register("mermaid_helmet",
			() -> new ArmorItem(ModArmorMaterials.MERMAID, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> mermaid_chestplate = ITEMS.register("mermaid_chestplate",
			() -> new ArmorItem(ModArmorMaterials.MERMAID, EquipmentSlotType.CHEST,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> mermaid_leggings = ITEMS.register("mermaid_leggings",
			() -> new ArmorItem(ModArmorMaterials.MERMAID, EquipmentSlotType.LEGS,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> mermaid_boots = ITEMS.register("mermaid_boots",
			() -> new ArmorItem(ModArmorMaterials.MERMAID, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> basilisk_helmet = ITEMS.register("basilisk_helmet",
			() -> new ArmorItem(ModArmorMaterials.BASILISK, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> basilisk_chestplate = ITEMS.register("basilisk_chestplate",
			() -> new ArmorItem(ModArmorMaterials.BASILISK, EquipmentSlotType.CHEST,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> basilisk_leggings = ITEMS.register("basilisk_leggings",
			() -> new ArmorItem(ModArmorMaterials.BASILISK, EquipmentSlotType.LEGS,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> basilisk_boots = ITEMS.register("basilisk_boots",
			() -> new ArmorItem(ModArmorMaterials.BASILISK, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> kraken_helmet = ITEMS.register("kraken_helmet",
			() -> new ArmorItem(ModArmorMaterials.KRAKEN, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> kraken_chestplate = ITEMS.register("kraken_chestplate",
			() -> new ArmorItem(ModArmorMaterials.KRAKEN, EquipmentSlotType.CHEST,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> kraken_leggings = ITEMS.register("kraken_leggings",
			() -> new ArmorItem(ModArmorMaterials.KRAKEN, EquipmentSlotType.LEGS,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> kraken_boots = ITEMS.register("kraken_boots",
			() -> new ArmorItem(ModArmorMaterials.KRAKEN, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonbone_helmet = ITEMS.register("dragonbone_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONBONE, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonbone_chestplate = ITEMS.register("dragonbone_chestplate",
			() -> new ArmorItem(ModArmorMaterials.DRAGONBONE, EquipmentSlotType.CHEST,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonbone_leggings = ITEMS.register("dragonbone_leggings",
			() -> new ArmorItem(ModArmorMaterials.DRAGONBONE, EquipmentSlotType.LEGS,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonbone_boots = ITEMS.register("dragonbone_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONBONE, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> ruby_helmet = ITEMS.register("ruby_helmet",
			() -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> ruby_chestplate = ITEMS.register("ruby_chestplate",
			() -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlotType.CHEST,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> ruby_leggings = ITEMS.register("ruby_leggings",
			() -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlotType.LEGS,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> ruby_boots = ITEMS.register("ruby_boots",
			() -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> sapphire_helmet = ITEMS.register("sapphire_helmet",
			() -> new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> sapphire_chestplate = ITEMS.register("sapphire_chestplate",
			() -> new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlotType.CHEST,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> sapphire_leggings = ITEMS.register("sapphire_leggings",
			() -> new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlotType.LEGS,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> sapphire_boots = ITEMS.register("sapphire_boots",
			() -> new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> amethyst_helmet = ITEMS.register("amethyst_helmet",
			() -> new ArmorItem(ModArmorMaterials.AMETHYST, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> amethyst_chestplate = ITEMS.register("amethyst_chestplate",
			() -> new ArmorItem(ModArmorMaterials.AMETHYST, EquipmentSlotType.CHEST,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> amethyst_leggings = ITEMS.register("amethyst_leggings",
			() -> new ArmorItem(ModArmorMaterials.AMETHYST, EquipmentSlotType.LEGS,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> amethyst_boots = ITEMS.register("amethyst_boots",
			() -> new ArmorItem(ModArmorMaterials.AMETHYST, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> ancient_helmet = ITEMS.register("ancient_helmet",
			() -> new ArmorItem(ModArmorMaterials.ANCIENT, EquipmentSlotType.HEAD,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> ancient_chestplate = ITEMS.register("ancient_chestplate",
			() -> new ArmorItem(ModArmorMaterials.ANCIENT, EquipmentSlotType.CHEST,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> ancient_leggings = ITEMS.register("ancient_leggings",
			() -> new ArmorItem(ModArmorMaterials.ANCIENT, EquipmentSlotType.LEGS,
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> ancient_boots = ITEMS.register("ancient_boots",
			() -> new ArmorItem(ModArmorMaterials.ANCIENT, EquipmentSlotType.FEET,
					new Item.Properties().group(MythicCraftItems.instance)));

	// Bows
	public static final RegistryObject<Item> DRAGONBONE_BOW = ITEMS.register("dragonbone_bow",
			() -> new DragonBoneBow(new Item.Properties().group(MythicCraftItems.instance).maxDamage(500)));

	// Trident

	// Tools
	public static final RegistryObject<SwordItem> vampiric_sword = ITEMS.register("vampiric_sword",
			() -> new SwordItem(ModItemTiers.VAMPIRIC, 2, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> vampiric_pickaxe = ITEMS.register("vampiric_pickaxe",
			() -> new PickaxeItem(ModItemTiers.VAMPIRIC, 2, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> vampiric_shovel = ITEMS.register("vampiric_shovel",
			() -> new ShovelItem(ModItemTiers.VAMPIRIC, 2, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> vampiric_axe = ITEMS.register("vampiric_axe",
			() -> new AxeItem(ModItemTiers.VAMPIRIC, 11, 3.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> vampiric_hoe = ITEMS.register("vampiric_hoe",
			() -> new HoeItem(ModItemTiers.VAMPIRIC, 5.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<SwordItem> silver_sword = ITEMS.register("silver_sword",
			() -> new SwordItem(ModItemTiers.SILVER, 7, 5.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> silver_pickaxe = ITEMS.register("silver_pickaxe",
			() -> new PickaxeItem(ModItemTiers.SILVER, 4, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> silver_shovel = ITEMS.register("silver_shovel",
			() -> new ShovelItem(ModItemTiers.SILVER, 2, 5.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> silver_axe = ITEMS.register("silver_axe",
			() -> new AxeItem(ModItemTiers.SILVER, 11, 3.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> silver_hoe = ITEMS.register("silver_hoe",
			() -> new HoeItem(ModItemTiers.SILVER, 5.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<SwordItem> mythicdiamond_sword = ITEMS.register("mythicdiamond_sword",
			() -> new SwordItem(ModItemTiers.MYTHICDIAMOND, 7, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> mythicdiamond_pickaxe = ITEMS.register("mythicdiamond_pickaxe",
			() -> new PickaxeItem(ModItemTiers.MYTHICDIAMOND, 4, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> mythicdiamond_shovel = ITEMS.register("mythicdiamond_shovel",
			() -> new ShovelItem(ModItemTiers.MYTHICDIAMOND, 2, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> mythicdiamond_axe = ITEMS.register("mythicdiamond_axe",
			() -> new AxeItem(ModItemTiers.MYTHICDIAMOND, 11, 3.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> mythicdiamond_hoe = ITEMS.register("mythicdiamond_hoe",
			() -> new HoeItem(ModItemTiers.MYTHICDIAMOND, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<SwordItem> dragonheart_sword = ITEMS.register("dragonheart_sword",
			() -> new SwordItem(ModItemTiers.DRAGONHEART, 7, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> dragonheart_pickaxe = ITEMS.register("dragonheart_pickaxe",
			() -> new PickaxeItem(ModItemTiers.DRAGONHEART, 4, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> dragonheart_shovel = ITEMS.register("dragonheart_shovel",
			() -> new ShovelItem(ModItemTiers.DRAGONHEART, 2, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> dragonheart_axe = ITEMS.register("dragonheart_axe",
			() -> new AxeItem(ModItemTiers.DRAGONHEART, 11, 3.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> dragonheart_hoe = ITEMS.register("dragonheart_hoe",
			() -> new HoeItem(ModItemTiers.DRAGONHEART, 5.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<SwordItem> ruby_sword = ITEMS.register("ruby_sword",
			() -> new SwordItem(ModItemTiers.RUBY, 7, 5.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> ruby_pickaxe = ITEMS.register("ruby_pickaxe",
			() -> new PickaxeItem(ModItemTiers.RUBY, 4, 5.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> ruby_shovel = ITEMS.register("ruby_shovel",
			() -> new ShovelItem(ModItemTiers.RUBY, 2, 5.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> ruby_axe = ITEMS.register("ruby_axe",
			() -> new AxeItem(ModItemTiers.RUBY, 11, 3.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> ruby_hoe = ITEMS.register("ruby_hoe",
			() -> new HoeItem(ModItemTiers.RUBY, 5.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<SwordItem> sapphire_sword = ITEMS.register("sapphire_sword",
			() -> new SwordItem(ModItemTiers.SAPPHIRE, 7, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> sapphire_pickaxe = ITEMS.register("sapphire_pickaxe",
			() -> new PickaxeItem(ModItemTiers.SAPPHIRE, 4, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> sapphire_shovel = ITEMS.register("sapphire_shovel",
			() -> new ShovelItem(ModItemTiers.SAPPHIRE, 2, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> sapphire_axe = ITEMS.register("sapphire_axe",
			() -> new AxeItem(ModItemTiers.SAPPHIRE, 11, 3.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> sapphire_hoe = ITEMS.register("sapphire_hoe",
			() -> new HoeItem(ModItemTiers.SAPPHIRE, 5.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<SwordItem> amethyst_sword = ITEMS.register("amethyst_sword",
			() -> new SwordItem(ModItemTiers.AMETHYST, 7, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> amethyst_pickaxe = ITEMS.register("amethyst_pickaxe",
			() -> new PickaxeItem(ModItemTiers.AMETHYST, 4, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> amethyst_shovel = ITEMS.register("amethyst_shovel",
			() -> new ShovelItem(ModItemTiers.AMETHYST, 2, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> amethyst_axe = ITEMS.register("amethyst_axe",
			() -> new AxeItem(ModItemTiers.AMETHYST, 11, 3.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> amethyst_hoe = ITEMS.register("amethyst_hoe",
			() -> new HoeItem(ModItemTiers.AMETHYST, 5.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<SwordItem> ancient_sword = ITEMS.register("ancient_sword",
			() -> new SwordItem(ModItemTiers.ANCIENT, 7, 5.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> ancient_pickaxe = ITEMS.register("ancient_pickaxe",
			() -> new PickaxeItem(ModItemTiers.ANCIENT, 4, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> ancient_shovel = ITEMS.register("ancient_shovel",
			() -> new ShovelItem(ModItemTiers.ANCIENT, 2, 5.0f,
					new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> ancient_axe = ITEMS.register("ancient_axe",
			() -> new AxeItem(ModItemTiers.ANCIENT, 11, 3.0f, new Item.Properties().group(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> ancient_hoe = ITEMS.register("ancient_hoe",
			() -> new HoeItem(ModItemTiers.ANCIENT, 5.0f, new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> FLINT_AND_HELLFIRE = ITEMS.register("flint_and_hellfire",
			() -> new FlintAndHellFireItem(
					new Item.Properties().group(MythicCraftItems.instance).defaultMaxDamage(60)));

	// Fuel
	public static final RegistryObject<WoodAshItem> WOOD_ASH = ITEMS.register("wood_ash",
			() -> new WoodAshItem(new Item.Properties().group(MythicCraftItems.instance)));

	// Food
	public static final RegistryObject<Item> RAW_KRAKEN = ITEMS.register("raw_kraken",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)
					.food(new Food.Builder().meat().hunger(3).saturation(1.2f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> COOKED_KRAKEN = ITEMS.register("cooked_kraken",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance).food(new Food.Builder().hunger(8)
					.saturation(1.2f).effect(new EffectInstance(Effects.REGENERATION, 6000, 5), 0.7f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> BLOOD_BERRY = ITEMS.register("blood_berry",
			() -> new BlockItem(BlockInit.BLOOD_BERRY_BUSH.get(),
					new Item.Properties().group(MythicCraftItems.instance)
							.food(new Food.Builder().setAlwaysEdible().hunger(2).saturation(0.4f)
									.effect(new EffectInstance(Effects.STRENGTH, 3000, 5), 0.7f)
									.effect(new EffectInstance(Effects.POISON, 6000, 5), 0.7f).build())))));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> icy_berry = ITEMS.register("icy_berry",
			() -> new BlockItem(BlockInit.ICY_BERRY_BUSH.get(),
					new Item.Properties().group(MythicCraftItems.instance)
							.food(new Food.Builder().setAlwaysEdible().hunger(2).saturation(0.4f)
									.effect(new EffectInstance(Effects.SLOWNESS, 3000, 5), 0.7f)
									.effect(new EffectInstance(Effects.INSTANT_DAMAGE, 6000, 5), 0.7f).build())))));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> silver_berry = ITEMS.register("silver_berry",
			() -> new BlockItem(BlockInit.SILVER_BERRY_BUSH.get(),
					new Item.Properties().group(MythicCraftItems.instance)
							.food(new Food.Builder().setAlwaysEdible().hunger(2).saturation(0.4f)
									.effect(new EffectInstance(Effects.WEAKNESS, 3000, 5), 0.7f)
									.effect(new EffectInstance(Effects.LEVITATION, 6000, 5), 0.7f).build())))));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> charred_berry = ITEMS.register("charred_berry",
			() -> new BlockItem(BlockInit.CHARRED_BERRY_BUSH.get(),
					new Item.Properties().group(MythicCraftItems.instance)
							.food(new Food.Builder().setAlwaysEdible().hunger(2).saturation(0.4f)
									.effect(new EffectInstance(Effects.HUNGER, 3000, 5), 0.7f)
									.effect(new EffectInstance(Effects.FIRE_RESISTANCE, 6000, 5), 0.7f).build())))));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> soul_berry = ITEMS.register("soul_berry",
			() -> new BlockItem(BlockInit.SOUL_BERRY_BUSH.get(),
					new Item.Properties().group(MythicCraftItems.instance)
							.food(new Food.Builder().setAlwaysEdible().hunger(2).saturation(0.4f)
									.effect(new EffectInstance(Effects.HEALTH_BOOST, 3000, 5), 0.7f)
									.effect(new EffectInstance(Effects.WITHER, 6000, 5), 0.7f).build())))));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> infested_berry = ITEMS.register("infested_berry",
			() -> new BlockItem(BlockInit.INFESTED_BERRY_BUSH.get(),
					new Item.Properties().group(MythicCraftItems.instance)
							.food(new Food.Builder().setAlwaysEdible().hunger(2).saturation(0.4f)
									.effect(new EffectInstance(Effects.NAUSEA, 3000, 5), 0.7f)
									.effect(new EffectInstance(Effects.HASTE, 6000, 5), 0.7f).build())))));

	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> mystic_berry = ITEMS.register("mystic_berry",
			() -> new BlockItem(BlockInit.MYSTIC_BERRY_BUSH.get(),
					new Item.Properties().group(MythicCraftItems.instance)
							.food(new Food.Builder().setAlwaysEdible().hunger(2).saturation(0.4f)
									.effect(new EffectInstance(Effects.LUCK, 3000, 5), 0.7f)
									.effect(new EffectInstance(Effects.BLINDNESS, 6000, 5), 0.7f).build())))));
	public static final RegistryObject<Item> blood_apple = ITEMS.register("blood_apple",
			() -> new Item(new Item.Properties().group(MythicCraftItems.instance)
					.food(new Food.Builder().hunger(4).saturation(0.5f).build())));

	// Plants
	public static final RegistryObject<Item> vervain_seeds = ITEMS.register("vervain_seeds",
			() -> new BlockItem(BlockInit.vervain_crop.get(), new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> wolfsbane_seeds = ITEMS.register("wolfsbane_seeds",
			() -> new BlockItem(BlockInit.wolfsbane_crop.get(),
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> garlic_seeds = ITEMS.register("garlic_seeds",
			() -> new BlockItem(BlockInit.garlic_crop.get(), new Item.Properties().group(MythicCraftItems.instance)
					.food(new Food.Builder().hunger(2).saturation(0.4f).build())));
	public static final RegistryObject<Item> belladnna_seeds = ITEMS.register("belladnna_seeds",
			() -> new BlockItem(BlockInit.belladonna_crop.get(),
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> mandrake_seeds = ITEMS.register("mandrake_seeds",
			() -> new BlockItem(BlockInit.mandrake_crop.get(), new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> foxgloves_seeds = ITEMS.register("foxgloves_seeds",
			() -> new BlockItem(BlockInit.foxgloves_crop.get(),
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> wormwood_seeds = ITEMS.register("wormwood_seeds",
			() -> new BlockItem(BlockInit.wormwood_crop.get(), new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> nightshade_seeds = ITEMS.register("nightshade_seeds",
			() -> new BlockItem(BlockInit.nightshade_crop.get(),
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> hellebore_seeds = ITEMS.register("hellebore_seeds",
			() -> new BlockItem(BlockInit.hellebore_crop.get(),
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> whitesage_seeds = ITEMS.register("whitesage_seeds",
			() -> new BlockItem(BlockInit.whitesage_crop.get(),
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> waterartichoke_seeds = ITEMS.register("waterartichoke_seeds",
			() -> new BlockItem(BlockInit.waterartichoke_crop.get(),
					new Item.Properties().group(MythicCraftItems.instance)));
	public static final RegistryObject<Item> snowbell_seeds = ITEMS.register("snowbell_seeds",
			() -> new BlockItem(BlockInit.snowbell_crop.get(), new Item.Properties().group(MythicCraftItems.instance)));

	// Fluids Bucket
	public static final RegistryObject<BucketItem> blood_bucket = ITEMS.register("blood_bucket",
			() -> new BucketItem(() -> FluidInit.BLOOD_FLUID.get(),
					new Item.Properties().group(MythicCraftItems.instance).maxStackSize(1)));
	public static final RegistryObject<BucketItem> ectoplasm_bucket = ITEMS.register("ectoplasm_bucket",
			() -> new BucketItem(() -> FluidInit.ECTOPLASM_FLUID.get(),
					new Item.Properties().group(MythicCraftItems.instance).maxStackSize(1)));
	public static final RegistryObject<BucketItem> infestedgoo_bucket = ITEMS.register("infestedgoo_bucket",
			() -> new BucketItem(() -> FluidInit.INFESTEDGOO_FLUID.get(),
					new Item.Properties().group(MythicCraftItems.instance).maxStackSize(1)));

	// SpawnEggs
	public static final RegistryObject<ModSpawnEggItem> basilisk_spawn_egg = ITEMS.register("basilisk_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.BASILISK_ENTITY, 0x338457, 0x002C43,
					new Item.Properties().group(MythicCraftItems.instance).maxStackSize(16)));
	public static final RegistryObject<ModSpawnEggItem> goblin_spawn_egg = ITEMS.register("goblin_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.GOBLIN_ENTITY, 0x00A800, 0xA9E4D1,
					new Item.Properties().group(MythicCraftItems.instance).maxStackSize(16)));
	public static final RegistryObject<ModSpawnEggItem> unicorn_spawn_egg = ITEMS.register("unicorn_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.UNICORN_ENTITY, 0xFFFFFF, 0x97FFFF,
					new Item.Properties().group(MythicCraftItems.instance).maxStackSize(16)));
	public static final RegistryObject<ModSpawnEggItem> siren_spawn_egg = ITEMS.register("siren_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.SIREN_ENTITY, 0x007774, 0x000000,
					new Item.Properties().group(MythicCraftItems.instance).maxStackSize(16)));
	public static final RegistryObject<ModSpawnEggItem> FAIRY_SPAWN_EGG = ITEMS.register("fairy_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.FAIRY_ENTITY, 0xFF0000, 0x500000,
					new Item.Properties().group(MythicCraftItems.instance).maxStackSize(16)));
	public static final RegistryObject<ModSpawnEggItem> LILITH_SPAWN_EGG = ITEMS.register("lilith_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.LILITH_ENTITY, 0x770000, 0x735C30,
					new Item.Properties().group(MythicCraftItems.instance).maxStackSize(16)));

}
