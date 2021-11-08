package com.masterquentus.mythiccraft.init;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.MythicCraft.MythicCraftBlocks;
import com.masterquentus.mythiccraft.MythicCraft.MythicCraftItems;
import com.masterquentus.mythiccraft.objects.items.AnointingPasteItem;
import com.masterquentus.mythiccraft.objects.items.DragonBoneBow;
import com.masterquentus.mythiccraft.objects.items.FlintAndHellFireItem;
import com.masterquentus.mythiccraft.objects.items.ModSpawnEggItem;
import com.masterquentus.mythiccraft.objects.items.MoonCharmItem;
import com.masterquentus.mythiccraft.objects.items.MutandisItem;
import com.masterquentus.mythiccraft.objects.items.ProjectileTest;
import com.masterquentus.mythiccraft.objects.items.TagLockKitItem;
import com.masterquentus.mythiccraft.objects.items.TotemOfTeleportationItem;
import com.masterquentus.mythiccraft.objects.items.VampriricItem;
import com.masterquentus.mythiccraft.objects.items.WaterCropItem;
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
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SignItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			MythicCraft.MOD_ID);

	public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("testitem",
			() -> new ProjectileTest(new Item.Properties().tab(MythicCraftItems.instance)));

	// Items
	public static final RegistryObject<Item> VAMPIRIC_GEM = ITEMS.register("vampiric_gem",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> MYTHIC_DIAMOND = ITEMS.register("mythic_diamond",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> BLOODSTONE_INGOT = ITEMS.register("bloodstone_ingot",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> BLOODSTONE_NUGGET = ITEMS.register("bloodstone_nugget",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> DRAGONHEART_INGOT = ITEMS.register("dragonheart_ingot",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> DRAGONHEART_NUGGET = ITEMS.register("dragonheart_nugget",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> FROSTSTEEL_INGOT = ITEMS.register("froststeel_ingot",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> FROSTSTEEL_NUGGET = ITEMS.register("froststeell_nugget",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> GOBLINITE_DUST = ITEMS.register("goblinite_dust",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> GOBLINITE_NUGGET = ITEMS.register("goblinite_nugget",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> GOBLINITE_INGOT = ITEMS.register("goblinite_ingot",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> PUREGLOWSTONE_DUST = ITEMS.register("pureglowstone_dust",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> DARKGLOWSTONE_DUST = ITEMS.register("darkglowstone_dust",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> ROSE_QUARTZ = ITEMS.register("rose_quartz",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> FAIRY_DUST = ITEMS.register("fairy_dust",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)
					.food(new Food.Builder().alwaysEat().nutrition(2).saturationMod(0.4f)
							.effect(new EffectInstance(Effects.GLOWING, 3000, 5), 0.7f)
							.effect(new EffectInstance(Effects.LEVITATION, 6000, 5), 0.7f)
							.effect(new EffectInstance(Effects.ABSORPTION, 6000, 5), 0.7f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> PIXIE_DUST = ITEMS.register("pixie_dust",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)
					.food(new Food.Builder().alwaysEat().nutrition(2).saturationMod(0.4f)
							.effect(new EffectInstance(Effects.GLOWING, 3000, 5), 0.7f)
							.effect(new EffectInstance(Effects.LEVITATION, 6000, 5), 0.7f)
							.effect(new EffectInstance(Effects.FIRE_RESISTANCE, 6000, 5), 0.7f).build())));
	public static final RegistryObject<Item> UNICORN_HORN = ITEMS.register("unicorn_horn",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> basilisk_scale = ITEMS.register("basilisk_scale",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> mermaid_scale = ITEMS.register("mermaid_scale",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> siren_scale = ITEMS.register("siren_scale",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> kraken_scale = ITEMS.register("kraken_scale",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> kraken_tooth = ITEMS.register("kraken_tooth",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_red = ITEMS.register("dragonscale_red",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_amethyst = ITEMS.register("dragonscale_amethyst",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_black = ITEMS.register("dragonscale_black",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_green = ITEMS.register("dragonscale_green",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_gray = ITEMS.register("dragonscale_gray",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_white = ITEMS.register("dragonscale_white",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_sapphire = ITEMS.register("dragonscale_sapphire",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_silver = ITEMS.register("dragonscale_silver",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragonscale_blue = ITEMS.register("dragonscale_blue",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<VampriricItem> vampiric_ring = ITEMS.register("vampiric_ring",
			() -> new VampriricItem(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> daylight_ring = ITEMS.register("daylight_ring",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> MOON_CHARM = ITEMS.register("moon_charm",
			() -> new MoonCharmItem(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> wolfsbane = ITEMS.register("wolfsbane",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> vervain = ITEMS.register("vervain",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> belladonna = ITEMS.register("belladonna",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> mandrake = ITEMS.register("mandrake",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> foxgloves = ITEMS.register("foxgloves",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> wormwood = ITEMS.register("wormwood",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> nightshade = ITEMS.register("nightshade",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> hellebore = ITEMS.register("hellebore",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> whitesage = ITEMS.register("whitesage",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> waterartichoke = ITEMS.register("waterartichoke",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> icy_needle = ITEMS.register("icy_needle",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> moonstone = ITEMS.register("moonstone",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> ash = ITEMS.register("ash",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> magic_crystal = ITEMS.register("magic_crystal",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> witches_hand = ITEMS.register("witches_hand",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> infested_goo = ITEMS.register("infested_goo",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> infested_slimeball = ITEMS.register("infested_slimeball",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> charred_slimeball = ITEMS.register("charred_slimeball",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> dragon_bone = ITEMS.register("dragon_bone",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_lilith = ITEMS.register("contract_lilith",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_pandora = ITEMS.register("contract_pandora",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_death = ITEMS.register("contract_death",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_medusa = ITEMS.register("contract_medusa",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_mirrordemon = ITEMS.register("contract_mirrordemon",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_lust = ITEMS.register("contract_lust",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_wrath = ITEMS.register("contract_wrath",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_envy = ITEMS.register("contract_envy",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_pride = ITEMS.register("contract_pride",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_sloth = ITEMS.register("contract_sloth",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_greed = ITEMS.register("contract_greed",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> contract_gluttony = ITEMS.register("contract_gluttony",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> soul_bottle = ITEMS.register("soul_bottle",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> magical_gear = ITEMS.register("magical_gear",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> salt = ITEMS.register("salt",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> magical_dust = ITEMS.register("magical_dust",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> lilith_bloodbottle = ITEMS.register("lilith_bloodbottle",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> pandora_bloodbottle = ITEMS.register("pandora_bloodbottle",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> death_bloodbottle = ITEMS.register("death_bloodbottle",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> medusa_bloodbottle = ITEMS.register("medusa_bloodbottle",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> mirrordemon_bloodbottle = ITEMS.register("mirrordemon_bloodbottle",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> lust_bloodbottle = ITEMS.register("lust_bloodbottle",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> wrath_bloodbottle = ITEMS.register("wrath_bloodbottle",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> envy_bloodbottle = ITEMS.register("envy_bloodbottle",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> pride_bloodbottle = ITEMS.register("pride_bloodbottle",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> sloth_bloodbottle = ITEMS.register("sloth_bloodbottle",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> greed_bloodbottle = ITEMS.register("greed_bloodbottle",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> gluttony_bloodbottle = ITEMS.register("gluttony_bloodbottle",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> LILITH_SOUL = ITEMS.register("lilith_soul",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> PANDORA_SOUL = ITEMS.register("pandora_soul",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> DEATH_SOUL = ITEMS.register("death_soul",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> MEDUSA_SOUL = ITEMS.register("medusa_soul",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> MIRRORDEMON_SOUL = ITEMS.register("mirrordemon_soul",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> LUST_SOUL = ITEMS.register("lust_soul",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> WRATH_SOUL = ITEMS.register("wrath_soul",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> ENVY_SOUL = ITEMS.register("envy_soul",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> PRIDE_SOUL = ITEMS.register("pride_soul",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> SLOTH_SOUL = ITEMS.register("sloth_soul",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> GREED_SOUL = ITEMS.register("greed_soul",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> GLUTTONY_SOUL = ITEMS.register("gluttony_soul",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<TagLockKitItem> TAGLOCK_KIT = ITEMS.register("taglock_kit",
			() -> new TagLockKitItem(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> NECROMANTIC_STONE = ITEMS.register("necromantic_stone",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> UNFIRED_CLAY_POT = ITEMS.register("unfired_clay_pot",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> CLAY_POT = ITEMS.register("clay_pot",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> BREATH_OF_THE_GODDES = ITEMS.register("breath_of_the_goddes",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> EXHALE_OF_THE_HORNED_ONE = ITEMS.register("exhale_of_the_horned_one",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> FOUL_FUME = ITEMS.register("foul_fume",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> HINT_OF_REBIRTH = ITEMS.register("hint_of_rebirth",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> ODOR_OF_PURITY = ITEMS.register("order_of_purity",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> REEK_OF_MISFORTUNE = ITEMS.register("reek_of_misfortune",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> WHIFF_OF_MAGIC = ITEMS.register("whiff_of_magic",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> OIL_OF_VITRIOL = ITEMS.register("oil_of_vitriol",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> DROP_OF_LUCK = ITEMS.register("drop_of_luck",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> DIAMOND_VAPOR = ITEMS.register("diamond_vapor",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> TEAR_OF_THE_GODDESS = ITEMS.register("tear_of_the_goddess",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> ENDER_DEW = ITEMS.register("ender_dew",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> BONE_NEEDLE = ITEMS.register("bone_needle",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> ATTUNED_STONE = ITEMS.register("attuned_stone",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> CHARGED_ATTUNED_STONE = ITEMS.register("charged_attuned_stone",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> WOOL_OF_BAT = ITEMS.register("wool_of_bat",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> ANOINTING_PASTE = ITEMS.register("anointing_paste",
			() -> new AnointingPasteItem(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> TOTEM_OF_TELEPORTATION = ITEMS.register("totem_of_teleportation",
			() -> new TotemOfTeleportationItem(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> MUTANDIS = ITEMS.register("mutandis",
			() -> new MutandisItem(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> MUTANDIS_EXTREMIS = ITEMS.register("mutandis_extremis",
			() -> new MutandisItem(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> ENT_TWIG = ITEMS.register("ent_twig",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> MUTATING_SPRIG = ITEMS.register("mutating_sprig",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> MYSTIC_BRANCH = ITEMS.register("mystic_branch",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> QUICK_LIME = ITEMS.register("quicklime",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> GYPSUM = ITEMS.register("gypsum",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> DEAD_LIVING_CORAL_FAN_ITEM = ITEMS.register("dead_livingcoral_fan",
			() -> new WallOrFloorItem(BlockInit.DEAD_LIVING_CORAL_FAN.get(), BlockInit.DEAD_LIVING_CORAL_WALL_FAN.get(),
					new Item.Properties().tab(MythicCraftBlocks.instance)));
	public static final RegistryObject<Item> LIVING_CORAL_FAN_ITEM = ITEMS.register("livingcoral_fan",
			() -> new WallOrFloorItem(BlockInit.LIVING_CORAL_FAN.get(), BlockInit.LIVING_CORAL_WALL_FAN.get(),
					new Item.Properties().tab(MythicCraftBlocks.instance)));
	public static final RegistryObject<Item> DEAD_BLOODLY_CORAL_FAN_ITEM = ITEMS.register("dead_bloodly_fan",
			() -> new WallOrFloorItem(BlockInit.DEAD_BLOODLY_CORAL_FAN.get(),
					BlockInit.DEAD_BLOODLY_CORAL_WALL_FAN.get(),
					new Item.Properties().tab(MythicCraftBlocks.instance)));
	public static final RegistryObject<Item> BLOODLY_CORAL_FAN_ITEM = ITEMS.register("bloodly_fan",
			() -> new WallOrFloorItem(BlockInit.BLOODLY_CORAL_FAN.get(), BlockInit.BLOODLY_CORAL_WALL_FAN.get(),
					new Item.Properties().tab(MythicCraftBlocks.instance)));
	public static final RegistryObject<Item> DEAD_TWILIGHT_CORAL_FAN_ITEM = ITEMS.register("dead_twilight_fan",
			() -> new WallOrFloorItem(BlockInit.DEAD_TWILIGHT_CORAL_FAN.get(),
					BlockInit.DEAD_TWILIGHT_CORAL_WALL_FAN.get(),
					new Item.Properties().tab(MythicCraftBlocks.instance)));
	public static final RegistryObject<Item> TWILIGHT_CORAL_FAN_ITEM = ITEMS.register("twilight_fan",
			() -> new WallOrFloorItem(BlockInit.TWILIGHT_CORAL_FAN.get(), BlockInit.TWILIGHT_CORAL_WALL_FAN.get(),
					new Item.Properties().tab(MythicCraftBlocks.instance)));
	public static final RegistryObject<Item> DEAD_CRIMSON_CORAL_FAN_ITEM = ITEMS.register("dead_crimson_fan",
			() -> new WallOrFloorItem(BlockInit.DEAD_CRIMSON_CORAL_FAN.get(),
					BlockInit.DEAD_CRIMSON_CORAL_WALL_FAN.get(),
					new Item.Properties().tab(MythicCraftBlocks.instance)));
	public static final RegistryObject<Item> CRIMSON_CORAL_FAN_ITEM = ITEMS.register("crimson_fan",
			() -> new WallOrFloorItem(BlockInit.CRIMSON_CORAL_FAN.get(), BlockInit.CRIMSON_CORAL_WALL_FAN.get(),
					new Item.Properties().tab(MythicCraftBlocks.instance)));
	public static final RegistryObject<Item> DEAD_ICY_CORAL_FAN_ITEM = ITEMS.register("dead_icy_fan",
			() -> new WallOrFloorItem(BlockInit.DEAD_ICY_CORAL_FAN.get(), BlockInit.DEAD_ICY_CORAL_WALL_FAN.get(),
					new Item.Properties().tab(MythicCraftBlocks.instance)));
	public static final RegistryObject<Item> ICY_CORAL_FAN_ITEM = ITEMS.register("icy_fan",
			() -> new WallOrFloorItem(BlockInit.ICY_CORAL_FAN.get(), BlockInit.ICY_CORAL_WALL_FAN.get(),
					new Item.Properties().tab(MythicCraftBlocks.instance)));
	public static final RegistryObject<Item> DEAD_DRAGON_CORAL_FAN_ITEM = ITEMS.register("dead_dragon_fan",
			() -> new WallOrFloorItem(BlockInit.DEAD_DRAGON_CORAL_FAN.get(), BlockInit.DEAD_DRAGON_CORAL_WALL_FAN.get(),
					new Item.Properties().tab(MythicCraftBlocks.instance)));
	public static final RegistryObject<Item> DRAGON_CORAL_FAN_ITEM = ITEMS.register("dragon_fan",
			() -> new WallOrFloorItem(BlockInit.DRAGON_CORAL_FAN.get(), BlockInit.DRAGON_CORAL_WALL_FAN.get(),
					new Item.Properties().tab(MythicCraftBlocks.instance)));

	// Signs
	public static final RegistryObject<Item> BLOODOAK_SIGN = ITEMS.register("bloodoak_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.BLOODOAK_SIGN.get(), BlockInit.BLOODOAK_WALL_SIGN.get()));
	public static final RegistryObject<Item> WHITEOAK_SIGN = ITEMS.register("whiteoak_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.WHITE_OAK_SIGN.get(), BlockInit.WHITE_OAK_WALL_SIGN.get()));
	public static final RegistryObject<Item> SILVERWOOD_SIGN = ITEMS.register("silverwood_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.SILVER_WOOD_SIGN.get(), BlockInit.SILVER_WOOD_WALL_SIGN.get()));
	public static final RegistryObject<Item> WITCH_WOOD_SIGN = ITEMS.register("witchwood_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.WITCH_WOOD_SIGN.get(), BlockInit.WITCH_WOOD_WALL_SIGN.get()));
	public static final RegistryObject<Item> ALDER_SIGN = ITEMS.register("alder_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.ALDER_SIGN.get(), BlockInit.ALDER_WALL_SIGN.get()));
	public static final RegistryObject<Item> HAWTHORN_SIGN = ITEMS.register("hawthorn_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.HAWTHORN_SIGN.get(), BlockInit.HAWTHORN_WALL_SIGN.get()));
	public static final RegistryObject<Item> ROWAN_SIGN = ITEMS.register("rowan_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.ROWAN_SIGN.get(), BlockInit.ROWAN_WALL_SIGN.get()));
	public static final RegistryObject<Item> WILLOW_SIGN = ITEMS.register("willow_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.WILLOW_SIGN.get(), BlockInit.WILLOW_WALL_SIGN.get()));
	public static final RegistryObject<Item> BEECH_SIGN = ITEMS.register("beech_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.BEECH_SIGN.get(), BlockInit.BEECH_WALL_SIGN.get()));
	public static final RegistryObject<Item> ASH_SIGN = ITEMS.register("ash_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.ASH_SIGN.get(), BlockInit.ASH_WALL_SIGN.get()));
	public static final RegistryObject<Item> BLACKTHORN_SIGN = ITEMS.register("blackthorn_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.BLACKTHORN_SIGN.get(), BlockInit.BLACKTHORN_WALL_SIGN.get()));
	public static final RegistryObject<Item> CEDAR_SIGN = ITEMS.register("cedar_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.CEDAR_SIGN.get(), BlockInit.CEDAR_WALL_SIGN.get()));
	public static final RegistryObject<Item> ELDER_SIGN = ITEMS.register("elder_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.ELDER_SIGN.get(), BlockInit.ELDER_WALL_SIGN.get()));
	public static final RegistryObject<Item> JUNIPER_SIGN = ITEMS.register("juniper_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.JUNIPER_SIGN.get(), BlockInit.JUNIPER_WALL_SIGN.get()));
	public static final RegistryObject<Item> WITCHHAZEL_SIGN = ITEMS.register("witchhazel_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.WITCHHAZEL_SIGN.get(), BlockInit.WITCHHAZEL_WALL_SIGN.get()));
	public static final RegistryObject<Item> YEW_SIGN = ITEMS.register("yew_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.YEW_SIGN.get(), BlockInit.YEW_WALL_SIGN.get()));
	public static final RegistryObject<Item> INFESTED_SIGN = ITEMS.register("infested_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.INFESTED_SIGN.get(), BlockInit.INFESTED_WALL_SIGN.get()));
	public static final RegistryObject<Item> CHARRED_SIGN = ITEMS.register("charred_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.CHARRED_SIGN.get(), BlockInit.CHARRED_WALL_SIGN.get()));
	public static final RegistryObject<Item> ICY_SIGN = ITEMS.register("icy_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.ICY_SIGN.get(), BlockInit.ICY_WALL_SIGN.get()));
	public static final RegistryObject<Item> TWISTED_SIGN = ITEMS.register("twisted_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.TWISTED_SIGN.get(), BlockInit.TWISTED_WALL_SIGN.get()));
	public static final RegistryObject<Item> DISTORTED_SIGN = ITEMS.register("distorted_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.DISTORTED_SIGN.get(), BlockInit.DISTORTED_WALL_SIGN.get()));
	public static final RegistryObject<Item> HELLBARK_SIGN = ITEMS.register("hellbark_sign",
			() -> new SignItem(new Item.Properties().tab(MythicCraftBlocks.instance).stacksTo(16),
					BlockInit.HELLBARK_SIGN.get(), BlockInit.HELLBARK_WALL_SIGN.get()));

	// Rune's
	public static final RegistryObject<Item> blank_rune = ITEMS.register("blank_rune",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> fire_rune = ITEMS.register("fire_rune",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> water_rune = ITEMS.register("water_rune",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> earth_rune = ITEMS.register("earth_rune",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> air_rune = ITEMS.register("air_rune",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> yellow_rune = ITEMS.register("yellow_rune",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> purple_rune = ITEMS.register("purple_rune",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> black_rune = ITEMS.register("black_rune",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> blue_rune = ITEMS.register("blue_rune",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> red_rune = ITEMS.register("red_rune",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> white_rune = ITEMS.register("white_rune",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> orange_rune = ITEMS.register("orange_rune",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> green_rune = ITEMS.register("green_rune",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)));

	// Horse Armor
	public static final RegistryObject<Item> AMETHYST_HORSE_ARMOR = ITEMS.register("amethyst_horse_armor",
			() -> new HorseArmorItem(5, "amethyst", new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> RUBY_HORSE_ARMOR = ITEMS.register("ruby_horse_armor",
			() -> new HorseArmorItem(5, "ruby", new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> SAPPHIRE_HORSE_ARMOR = ITEMS.register("sapphire_horse_armor",
			() -> new HorseArmorItem(5, "sapphire", new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> NETHERITE_HORSE_ARMOR = ITEMS.register("netherite_horse_armor",
			() -> new HorseArmorItem(9, "netherite", new Item.Properties().tab(MythicCraftItems.instance)));

	// Armor
	public static final RegistryObject<ArmorItem> vampiric_helmet = ITEMS.register("vampiric_helmet",
			() -> new ArmorItem(ModArmorMaterials.VAMPIRIC, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> vampiric_chestplate = ITEMS.register("vampiric_chestplate",
			() -> new ArmorItem(ModArmorMaterials.VAMPIRIC, EquipmentSlotType.CHEST,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> vampiric_leggings = ITEMS.register("vampiric_leggings",
			() -> new ArmorItem(ModArmorMaterials.VAMPIRIC, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> vampiric_boots = ITEMS.register("vampiric_boots",
			() -> new ArmorItem(ModArmorMaterials.VAMPIRIC, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> silver_helmet = ITEMS.register("silver_helmet",
			() -> new ArmorItem(ModArmorMaterials.SILVER, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> silver_chestplate = ITEMS.register("silver_chestplate",
			() -> new ArmorItem(ModArmorMaterials.SILVER, EquipmentSlotType.CHEST,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> silver_leggings = ITEMS.register("silver_leggings",
			() -> new ArmorItem(ModArmorMaterials.SILVER, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> silver_boots = ITEMS.register("silver_boots",
			() -> new ArmorItem(ModArmorMaterials.SILVER, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> mythicdiamond_helmet = ITEMS.register("mythicdiamond_helmet",
			() -> new ArmorItem(ModArmorMaterials.MYTHICDIAMOND, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> mythicdiamond_chestplate = ITEMS.register("mythicdiamond_chestplate",
			() -> new ArmorItem(ModArmorMaterials.MYTHICDIAMOND, EquipmentSlotType.CHEST,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> mythicdiamond_leggings = ITEMS.register("mythicdiamond_leggings",
			() -> new ArmorItem(ModArmorMaterials.MYTHICDIAMOND, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> mythicdiamond_boots = ITEMS.register("mythicdiamond_boots",
			() -> new ArmorItem(ModArmorMaterials.MYTHICDIAMOND, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonheart_helmet = ITEMS.register("dragonheart_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONHEART, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonheart_chestplate = ITEMS.register("dragonheart_chestplate",
			() -> new ArmorItem(ModArmorMaterials.DRAGONHEART, EquipmentSlotType.CHEST,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonheart_leggings = ITEMS.register("dragonheart_leggings",
			() -> new ArmorItem(ModArmorMaterials.DRAGONHEART, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonheart_boots = ITEMS.register("dragonheart_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONHEART, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> FROSTSTEEL_HELMET = ITEMS.register("froststeel_helmet",
			() -> new ArmorItem(ModArmorMaterials.FROSTSTEEL, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> FROSTSTEEL_CHESTPLATE = ITEMS.register("froststeel_chestplate",
			() -> new ArmorItem(ModArmorMaterials.FROSTSTEEL, EquipmentSlotType.CHEST,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> FROSTSTEEL_LEGGINGS = ITEMS.register("froststeel_leggings",
			() -> new ArmorItem(ModArmorMaterials.FROSTSTEEL, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> FROSTSTEEL_BOOTS = ITEMS.register("froststeel_boots",
			() -> new ArmorItem(ModArmorMaterials.FROSTSTEEL, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalered_helmet = ITEMS.register("dragonscalered_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALERED, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalered_chestplate = ITEMS
			.register("dragonscalered_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALERED,
					EquipmentSlotType.CHEST, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalered_leggings = ITEMS.register("dragonscalered_leggings",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALERED, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalered_boots = ITEMS.register("dragonscalered_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALERED, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleamethyst_helmet = ITEMS
			.register("dragonscaleamethyst_helmet", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEAMETHYST,
					EquipmentSlotType.HEAD, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleamethyst_chestplate = ITEMS
			.register("dragonscaleamethyst_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEAMETHYST,
					EquipmentSlotType.CHEST, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleamethyst_leggings = ITEMS
			.register("dragonscaleamethyst_leggings", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEAMETHYST,
					EquipmentSlotType.LEGS, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleamethyst_boots = ITEMS
			.register("dragonscaleamethyst_boots", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEAMETHYST,
					EquipmentSlotType.FEET, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleblack_helmet = ITEMS.register("dragonscaleblack_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEBLACK, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleblack_chestplate = ITEMS
			.register("dragonscaleblack_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEBLACK,
					EquipmentSlotType.CHEST, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleblack_leggings = ITEMS
			.register("dragonscaleblack_leggings", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEBLACK,
					EquipmentSlotType.LEGS, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleblack_boots = ITEMS.register("dragonscaleblack_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEBLACK, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalegreen_helmet = ITEMS.register("dragonscalegreen_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEGREEN, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalegreen_chestplate = ITEMS
			.register("dragonscalegreen_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEGREEN,
					EquipmentSlotType.CHEST, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalegreen_leggings = ITEMS
			.register("dragonscalegreen_leggings", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEGREEN,
					EquipmentSlotType.LEGS, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalegreen_boots = ITEMS.register("dragonscalegreen_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEGREEN, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalegray_helmet = ITEMS.register("dragonscalegray_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEGRAY, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalegray_chestplate = ITEMS
			.register("dragonscalegray_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEGRAY,
					EquipmentSlotType.CHEST, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalegray_leggings = ITEMS.register("dragonscalegray_leggings",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEGRAY, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalegray_boots = ITEMS.register("dragonscalegray_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEGRAY, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalewhite_helmet = ITEMS.register("dragonscalewhite_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEWHITE, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalewhite_chestplate = ITEMS
			.register("dragonscalewhite_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEWHITE,
					EquipmentSlotType.CHEST, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalewhite_leggings = ITEMS
			.register("dragonscalewhite_leggings", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEWHITE,
					EquipmentSlotType.LEGS, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalewhite_boots = ITEMS.register("dragonscalewhite_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEWHITE, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalesapphire_helmet = ITEMS
			.register("dragonscalesapphire_helmet", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALESAPPHIRE,
					EquipmentSlotType.HEAD, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalesapphire_chestplate = ITEMS
			.register("dragonscalesapphire_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALESAPPHIRE,
					EquipmentSlotType.CHEST, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalesapphire_leggings = ITEMS
			.register("dragonscalesapphire_leggings", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALESAPPHIRE,
					EquipmentSlotType.LEGS, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalesapphire_boots = ITEMS
			.register("dragonscalesapphire_boots", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALESAPPHIRE,
					EquipmentSlotType.FEET, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalesilver_helmet = ITEMS.register("dragonscalesilver_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALESILVER, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalesilver_chestplate = ITEMS
			.register("dragonscalesilver_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALESILVER,
					EquipmentSlotType.CHEST, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalesilver_leggings = ITEMS
			.register("dragonscalesilver_leggings", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALESILVER,
					EquipmentSlotType.LEGS, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscalesilver_boots = ITEMS.register("dragonscalesilver_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALESILVER, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleblue_helmet = ITEMS.register("dragonscaleblue_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEBLUE, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleblue_chestplate = ITEMS
			.register("dragonscaleblue_chestplate", () -> new ArmorItem(ModArmorMaterials.DRAGONSCALEBLUE,
					EquipmentSlotType.CHEST, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleblue_leggings = ITEMS.register("dragonscaleblue_leggings",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEBLUE, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonscaleblue_boots = ITEMS.register("dragonscaleblue_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONSCALEBLUE, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> siren_helmet = ITEMS.register("siren_helmet",
			() -> new ArmorItem(ModArmorMaterials.SIREN, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> siren_chestplate = ITEMS.register("siren_chestplate",
			() -> new ArmorItem(ModArmorMaterials.SIREN, EquipmentSlotType.CHEST,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> siren_leggings = ITEMS.register("siren_leggings",
			() -> new ArmorItem(ModArmorMaterials.SIREN, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> siren_boots = ITEMS.register("siren_boots",
			() -> new ArmorItem(ModArmorMaterials.SIREN, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> mermaid_helmet = ITEMS.register("mermaid_helmet",
			() -> new ArmorItem(ModArmorMaterials.MERMAID, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> mermaid_chestplate = ITEMS.register("mermaid_chestplate",
			() -> new ArmorItem(ModArmorMaterials.MERMAID, EquipmentSlotType.CHEST,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> mermaid_leggings = ITEMS.register("mermaid_leggings",
			() -> new ArmorItem(ModArmorMaterials.MERMAID, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> mermaid_boots = ITEMS.register("mermaid_boots",
			() -> new ArmorItem(ModArmorMaterials.MERMAID, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> basilisk_helmet = ITEMS.register("basilisk_helmet",
			() -> new ArmorItem(ModArmorMaterials.BASILISK, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> basilisk_chestplate = ITEMS.register("basilisk_chestplate",
			() -> new ArmorItem(ModArmorMaterials.BASILISK, EquipmentSlotType.CHEST,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> basilisk_leggings = ITEMS.register("basilisk_leggings",
			() -> new ArmorItem(ModArmorMaterials.BASILISK, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> basilisk_boots = ITEMS.register("basilisk_boots",
			() -> new ArmorItem(ModArmorMaterials.BASILISK, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> kraken_helmet = ITEMS.register("kraken_helmet",
			() -> new ArmorItem(ModArmorMaterials.KRAKEN, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> kraken_chestplate = ITEMS.register("kraken_chestplate",
			() -> new ArmorItem(ModArmorMaterials.KRAKEN, EquipmentSlotType.CHEST,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> kraken_leggings = ITEMS.register("kraken_leggings",
			() -> new ArmorItem(ModArmorMaterials.KRAKEN, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> kraken_boots = ITEMS.register("kraken_boots",
			() -> new ArmorItem(ModArmorMaterials.KRAKEN, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonbone_helmet = ITEMS.register("dragonbone_helmet",
			() -> new ArmorItem(ModArmorMaterials.DRAGONBONE, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonbone_chestplate = ITEMS.register("dragonbone_chestplate",
			() -> new ArmorItem(ModArmorMaterials.DRAGONBONE, EquipmentSlotType.CHEST,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonbone_leggings = ITEMS.register("dragonbone_leggings",
			() -> new ArmorItem(ModArmorMaterials.DRAGONBONE, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> dragonbone_boots = ITEMS.register("dragonbone_boots",
			() -> new ArmorItem(ModArmorMaterials.DRAGONBONE, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> ruby_helmet = ITEMS.register("ruby_helmet",
			() -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> ruby_chestplate = ITEMS.register("ruby_chestplate",
			() -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlotType.CHEST,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> ruby_leggings = ITEMS.register("ruby_leggings",
			() -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> ruby_boots = ITEMS.register("ruby_boots",
			() -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> sapphire_helmet = ITEMS.register("sapphire_helmet",
			() -> new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> sapphire_chestplate = ITEMS.register("sapphire_chestplate",
			() -> new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlotType.CHEST,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> sapphire_leggings = ITEMS.register("sapphire_leggings",
			() -> new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> sapphire_boots = ITEMS.register("sapphire_boots",
			() -> new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> amethyst_helmet = ITEMS.register("amethyst_helmet",
			() -> new ArmorItem(ModArmorMaterials.AMETHYST, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> amethyst_chestplate = ITEMS.register("amethyst_chestplate",
			() -> new ArmorItem(ModArmorMaterials.AMETHYST, EquipmentSlotType.CHEST,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> amethyst_leggings = ITEMS.register("amethyst_leggings",
			() -> new ArmorItem(ModArmorMaterials.AMETHYST, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> amethyst_boots = ITEMS.register("amethyst_boots",
			() -> new ArmorItem(ModArmorMaterials.AMETHYST, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> ancient_helmet = ITEMS.register("ancient_helmet",
			() -> new ArmorItem(ModArmorMaterials.ANCIENT, EquipmentSlotType.HEAD,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> ancient_chestplate = ITEMS.register("ancient_chestplate",
			() -> new ArmorItem(ModArmorMaterials.ANCIENT, EquipmentSlotType.CHEST,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> ancient_leggings = ITEMS.register("ancient_leggings",
			() -> new ArmorItem(ModArmorMaterials.ANCIENT, EquipmentSlotType.LEGS,
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<ArmorItem> ancient_boots = ITEMS.register("ancient_boots",
			() -> new ArmorItem(ModArmorMaterials.ANCIENT, EquipmentSlotType.FEET,
					new Item.Properties().tab(MythicCraftItems.instance)));

	// Bows
	public static final RegistryObject<Item> DRAGONBONE_BOW = ITEMS.register("dragonbone_bow",
			() -> new DragonBoneBow(new Item.Properties().tab(MythicCraftItems.instance).durability(500)));

	// Tools
	public static final RegistryObject<SwordItem> vampiric_sword = ITEMS.register("vampiric_sword",
			() -> new SwordItem(ModItemTiers.VAMPIRIC, 2, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> vampiric_pickaxe = ITEMS.register("vampiric_pickaxe",
			() -> new PickaxeItem(ModItemTiers.VAMPIRIC, 2, 5.0f,
					new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> vampiric_shovel = ITEMS.register("vampiric_shovel",
			() -> new ShovelItem(ModItemTiers.VAMPIRIC, 2, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> vampiric_axe = ITEMS.register("vampiric_axe",
			() -> new AxeItem(ModItemTiers.VAMPIRIC, 11, 3.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> vampiric_hoe = ITEMS.register("vampiric_hoe",
			() -> new HoeItem(ModItemTiers.VAMPIRIC, 1, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<SwordItem> silver_sword = ITEMS.register("silver_sword",
			() -> new SwordItem(ModItemTiers.SILVER, 7, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> silver_pickaxe = ITEMS.register("silver_pickaxe",
			() -> new PickaxeItem(ModItemTiers.SILVER, 4, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> silver_shovel = ITEMS.register("silver_shovel",
			() -> new ShovelItem(ModItemTiers.SILVER, 2, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> silver_axe = ITEMS.register("silver_axe",
			() -> new AxeItem(ModItemTiers.SILVER, 11, 3.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> silver_hoe = ITEMS.register("silver_hoe",
			() -> new HoeItem(ModItemTiers.SILVER, 1, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<SwordItem> mythicdiamond_sword = ITEMS.register("mythicdiamond_sword",
			() -> new SwordItem(ModItemTiers.MYTHICDIAMOND, 7, 5.0f,
					new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> mythicdiamond_pickaxe = ITEMS.register("mythicdiamond_pickaxe",
			() -> new PickaxeItem(ModItemTiers.MYTHICDIAMOND, 4, 5.0f,
					new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> mythicdiamond_shovel = ITEMS.register("mythicdiamond_shovel",
			() -> new ShovelItem(ModItemTiers.MYTHICDIAMOND, 2, 5.0f,
					new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> mythicdiamond_axe = ITEMS.register("mythicdiamond_axe",
			() -> new AxeItem(ModItemTiers.MYTHICDIAMOND, 11, 3.0f,
					new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> mythicdiamond_hoe = ITEMS.register("mythicdiamond_hoe",
			() -> new HoeItem(ModItemTiers.MYTHICDIAMOND, 1, 5.0f,
					new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<SwordItem> dragonheart_sword = ITEMS.register("dragonheart_sword",
			() -> new SwordItem(ModItemTiers.DRAGONHEART, 7, 5.0f,
					new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> dragonheart_pickaxe = ITEMS.register("dragonheart_pickaxe",
			() -> new PickaxeItem(ModItemTiers.DRAGONHEART, 4, 5.0f,
					new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> dragonheart_shovel = ITEMS.register("dragonheart_shovel",
			() -> new ShovelItem(ModItemTiers.DRAGONHEART, 2, 5.0f,
					new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> dragonheart_axe = ITEMS.register("dragonheart_axe",
			() -> new AxeItem(ModItemTiers.DRAGONHEART, 11, 3.0f,
					new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> dragonheart_hoe = ITEMS.register("dragonheart_hoe",
			() -> new HoeItem(ModItemTiers.DRAGONHEART, 1, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<SwordItem> FROSTSTEEL_SWORD = ITEMS.register("froststeel_sword",
			() -> new SwordItem(ModItemTiers.FROSTSTEEL, 7, 5.0f,
					new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> FROSTSTEEL_PICKAXE = ITEMS.register("froststeel_pickaxe",
			() -> new PickaxeItem(ModItemTiers.FROSTSTEEL, 4, 5.0f,
					new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> FROSTSTEEL_SHOVEL = ITEMS.register("froststeel_shovel",
			() -> new ShovelItem(ModItemTiers.FROSTSTEEL, 2, 5.0f,
					new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> FROSTSTEEL_AXE = ITEMS.register("froststeel_axe",
			() -> new AxeItem(ModItemTiers.FROSTSTEEL, 11, 3.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> FROSTSTEEL_HOE = ITEMS.register("froststeel_hoe",
			() -> new HoeItem(ModItemTiers.FROSTSTEEL, 1, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<SwordItem> ruby_sword = ITEMS.register("ruby_sword",
			() -> new SwordItem(ModItemTiers.RUBY, 7, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> ruby_pickaxe = ITEMS.register("ruby_pickaxe",
			() -> new PickaxeItem(ModItemTiers.RUBY, 4, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> ruby_shovel = ITEMS.register("ruby_shovel",
			() -> new ShovelItem(ModItemTiers.RUBY, 2, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> ruby_axe = ITEMS.register("ruby_axe",
			() -> new AxeItem(ModItemTiers.RUBY, 11, 3.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> ruby_hoe = ITEMS.register("ruby_hoe",
			() -> new HoeItem(ModItemTiers.RUBY, 1, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<SwordItem> sapphire_sword = ITEMS.register("sapphire_sword",
			() -> new SwordItem(ModItemTiers.SAPPHIRE, 7, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> sapphire_pickaxe = ITEMS.register("sapphire_pickaxe",
			() -> new PickaxeItem(ModItemTiers.SAPPHIRE, 4, 5.0f,
					new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> sapphire_shovel = ITEMS.register("sapphire_shovel",
			() -> new ShovelItem(ModItemTiers.SAPPHIRE, 2, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> sapphire_axe = ITEMS.register("sapphire_axe",
			() -> new AxeItem(ModItemTiers.SAPPHIRE, 11, 3.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> sapphire_hoe = ITEMS.register("sapphire_hoe",
			() -> new HoeItem(ModItemTiers.SAPPHIRE, 1, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<SwordItem> amethyst_sword = ITEMS.register("amethyst_sword",
			() -> new SwordItem(ModItemTiers.AMETHYST, 7, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> amethyst_pickaxe = ITEMS.register("amethyst_pickaxe",
			() -> new PickaxeItem(ModItemTiers.AMETHYST, 4, 5.0f,
					new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> amethyst_shovel = ITEMS.register("amethyst_shovel",
			() -> new ShovelItem(ModItemTiers.AMETHYST, 2, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> amethyst_axe = ITEMS.register("amethyst_axe",
			() -> new AxeItem(ModItemTiers.AMETHYST, 11, 3.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> amethyst_hoe = ITEMS.register("amethyst_hoe",
			() -> new HoeItem(ModItemTiers.AMETHYST, 1, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<SwordItem> ancient_sword = ITEMS.register("ancient_sword",
			() -> new SwordItem(ModItemTiers.ANCIENT, 7, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<PickaxeItem> ancient_pickaxe = ITEMS.register("ancient_pickaxe",
			() -> new PickaxeItem(ModItemTiers.ANCIENT, 4, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<ShovelItem> ancient_shovel = ITEMS.register("ancient_shovel",
			() -> new ShovelItem(ModItemTiers.ANCIENT, 2, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<AxeItem> ancient_axe = ITEMS.register("ancient_axe",
			() -> new AxeItem(ModItemTiers.ANCIENT, 11, 3.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	public static final RegistryObject<HoeItem> ancient_hoe = ITEMS.register("ancient_hoe",
			() -> new HoeItem(ModItemTiers.ANCIENT, -1, -1, new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> FLINT_AND_HELLFIRE = ITEMS.register("flint_and_hellfire",
			() -> new FlintAndHellFireItem(new Item.Properties().tab(MythicCraftItems.instance).defaultDurability(60)));

	public static final RegistryObject<SwordItem> ARTHANA = ITEMS.register("arthana",
			() -> new SwordItem(ModItemTiers.ARTHANA, 2, 5.0f, new Item.Properties().tab(MythicCraftItems.instance)));

	// Fuel
	public static final RegistryObject<WoodAshItem> WOOD_ASH = ITEMS.register("wood_ash",
			() -> new WoodAshItem(new Item.Properties().tab(MythicCraftItems.instance)));

	// Food
	public static final RegistryObject<Item> RAW_KRAKEN = ITEMS.register("raw_kraken",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)
					.food(new Food.Builder().meat().nutrition(3).saturationMod(1.2f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> COOKED_KRAKEN = ITEMS.register("cooked_kraken",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance).food(new Food.Builder().nutrition(8)
					.saturationMod(1.2f).effect(new EffectInstance(Effects.REGENERATION, 6000, 5), 0.7f).build())));
	public static final RegistryObject<Item> RAW_WOLF_MEAT = ITEMS.register("raw_wolf_meat",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)
					.food(new Food.Builder().meat().nutrition(3).saturationMod(1.2f).build())));
	public static final RegistryObject<Item> COOKED_WOLF_MEAT = ITEMS.register("cooked_wolf_meat",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)
					.food(new Food.Builder().nutrition(8).saturationMod(1.2f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> BLOOD_BERRY = ITEMS.register("blood_berry",
			() -> new BlockItem(BlockInit.BLOOD_BERRY_BUSH.get(),
					new Item.Properties().tab(MythicCraftItems.instance)
							.food(new Food.Builder().alwaysEat().nutrition(2).saturationMod(0.4f)
									.effect(new EffectInstance(Effects.DAMAGE_BOOST, 3000, 5), 0.7f)
									.effect(new EffectInstance(Effects.POISON, 6000, 5), 0.7f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> icy_berry = ITEMS.register("icy_berry",
			() -> new BlockItem(BlockInit.ICY_BERRY_BUSH.get(),
					new Item.Properties().tab(MythicCraftItems.instance)
							.food(new Food.Builder().alwaysEat().nutrition(2).saturationMod(0.4f)
									.effect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 3000, 5), 0.7f)
									.effect(new EffectInstance(Effects.HARM, 6000, 5), 0.7f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> silver_berry = ITEMS.register("silver_berry",
			() -> new BlockItem(BlockInit.SILVER_BERRY_BUSH.get(),
					new Item.Properties().tab(MythicCraftItems.instance)
							.food(new Food.Builder().alwaysEat().nutrition(2).saturationMod(0.4f)
									.effect(new EffectInstance(Effects.WEAKNESS, 3000, 5), 0.7f)
									.effect(new EffectInstance(Effects.LEVITATION, 6000, 5), 0.7f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> charred_berry = ITEMS.register("charred_berry",
			() -> new BlockItem(BlockInit.CHARRED_BERRY_BUSH.get(),
					new Item.Properties().tab(MythicCraftItems.instance)
							.food(new Food.Builder().alwaysEat().nutrition(2).saturationMod(0.4f)
									.effect(new EffectInstance(Effects.HUNGER, 3000, 5), 0.7f)
									.effect(new EffectInstance(Effects.FIRE_RESISTANCE, 6000, 5), 0.7f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> soul_berry = ITEMS.register("soul_berry",
			() -> new BlockItem(BlockInit.SOUL_BERRY_BUSH.get(),
					new Item.Properties().tab(MythicCraftItems.instance)
							.food(new Food.Builder().alwaysEat().nutrition(2).saturationMod(0.4f)
									.effect(new EffectInstance(Effects.HEALTH_BOOST, 3000, 5), 0.7f)
									.effect(new EffectInstance(Effects.WITHER, 6000, 5), 0.7f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> infested_berry = ITEMS.register("infested_berry",
			() -> new BlockItem(BlockInit.INFESTED_BERRY_BUSH.get(),
					new Item.Properties().tab(MythicCraftItems.instance)
							.food(new Food.Builder().alwaysEat().nutrition(2).saturationMod(0.4f)
									.effect(new EffectInstance(Effects.CONFUSION, 3000, 5), 0.7f)
									.effect(new EffectInstance(Effects.DIG_SPEED, 6000, 5), 0.7f).build())));

	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> mystic_berry = ITEMS.register("mystic_berry",
			() -> new BlockItem(BlockInit.MYSTIC_BERRY_BUSH.get(),
					new Item.Properties().tab(MythicCraftItems.instance)
							.food(new Food.Builder().alwaysEat().nutrition(2).saturationMod(0.4f)
									.effect(new EffectInstance(Effects.LUCK, 3000, 5), 0.7f)
									.effect(new EffectInstance(Effects.BLINDNESS, 6000, 5), 0.7f).build())));
	public static final RegistryObject<Item> BLOOD_APPLE = ITEMS.register("blood_apple",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)
					.food(new Food.Builder().nutrition(4).saturationMod(0.5f).build())));
	public static final RegistryObject<Item> JUNIPER_BERRY = ITEMS.register("juniper_berry",
			() -> new Item(new Item.Properties().tab(MythicCraftItems.instance)
					.food(new Food.Builder().nutrition(4).saturationMod(0.5f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> CINDER_FRUIT = ITEMS.register("cinder_fruit",
			() -> new BlockItem(BlockInit.CINDER_FRUIT_PLANT.get(),
					new Item.Properties().tab(MythicCraftItems.instance)
							.food(new Food.Builder().alwaysEat().nutrition(2).saturationMod(0.4f)
									.effect(new EffectInstance(Effects.WEAKNESS, 3000, 5), 0.7f)
									.effect(new EffectInstance(Effects.DIG_SLOWDOWN, 3000, 5), 0.7f)
									.effect(new EffectInstance(Effects.FIRE_RESISTANCE, 2000, 5), 0.7f).build())));

	// Plants
	public static final RegistryObject<Item> vervain_seeds = ITEMS.register("vervain_seeds",
			() -> new BlockItem(BlockInit.vervain_crop.get(), new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> wolfsbane_seeds = ITEMS.register("wolfsbane_seeds",
			() -> new BlockItem(BlockInit.wolfsbane_crop.get(), new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> garlic_seeds = ITEMS.register("garlic_seeds",
			() -> new BlockItem(BlockInit.garlic_crop.get(), new Item.Properties().tab(MythicCraftItems.instance)
					.food(new Food.Builder().nutrition(2).saturationMod(0.4f).build())));
	public static final RegistryObject<Item> belladnna_seeds = ITEMS.register("belladnna_seeds",
			() -> new BlockItem(BlockInit.belladonna_crop.get(), new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> mandrake_seeds = ITEMS.register("mandrake_seeds",
			() -> new BlockItem(BlockInit.mandrake_crop.get(), new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> foxgloves_seeds = ITEMS.register("foxgloves_seeds",
			() -> new BlockItem(BlockInit.foxgloves_crop.get(), new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> wormwood_seeds = ITEMS.register("wormwood_seeds",
			() -> new BlockItem(BlockInit.wormwood_crop.get(), new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> nightshade_seeds = ITEMS.register("nightshade_seeds",
			() -> new BlockItem(BlockInit.nightshade_crop.get(), new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> hellebore_seeds = ITEMS.register("hellebore_seeds",
			() -> new BlockItem(BlockInit.hellebore_crop.get(), new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> whitesage_seeds = ITEMS.register("whitesage_seeds",
			() -> new BlockItem(BlockInit.whitesage_crop.get(), new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> waterartichoke_seeds = ITEMS.register("waterartichoke_seeds",
			() -> new WaterCropItem(BlockInit.waterartichoke_crop.get(),
					new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> snowbell_seeds = ITEMS.register("snowbell_seeds",
			() -> new BlockItem(BlockInit.snowbell_crop.get(), new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> LIVING_KELP_ITEM = ITEMS.register("living_kelp_item",
			() -> new BlockItem(BlockInit.LIVING_KELP_TOP.get(), new Item.Properties().tab(MythicCraftItems.instance)));
	public static final RegistryObject<Item> DEMON_HEART_ITEM = ITEMS.register("demon_heart_item",
			() -> new BlockItem(BlockInit.DEMON_HEART.get(), new Item.Properties().tab(MythicCraftItems.instance)));

	// Fluids Bucket
	public static final RegistryObject<BucketItem> blood_bucket = ITEMS.register("blood_bucket",
			() -> new BucketItem(() -> FluidInit.BLOOD_FLUID.get(),
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(1)));
	public static final RegistryObject<BucketItem> ectoplasm_bucket = ITEMS.register("ectoplasm_bucket",
			() -> new BucketItem(() -> FluidInit.ECTOPLASM_FLUID.get(),
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(1)));
	public static final RegistryObject<BucketItem> infestedgoo_bucket = ITEMS.register("infestedgoo_bucket",
			() -> new BucketItem(() -> FluidInit.INFESTEDGOO_FLUID.get(),
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(1)));
	public static final RegistryObject<BucketItem> DARK_WATER_BUCKET = ITEMS.register("dark_water_bucket",
			() -> new BucketItem(() -> FluidInit.DARK_WATER_FLUID.get(),
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(1)));
	public static final RegistryObject<BucketItem> MANA_BUCKET = ITEMS.register("mana_bucket",
			() -> new BucketItem(() -> FluidInit.MANA_FLUID.get(),
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(1)));

	// SpawnEggs
	public static final RegistryObject<ModSpawnEggItem> basilisk_spawn_egg = ITEMS.register("basilisk_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.BASILISK_ENTITY, 0x338457, 0x002C43,
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(16)));
	public static final RegistryObject<ModSpawnEggItem> goblin_spawn_egg = ITEMS.register("goblin_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.GOBLIN_ENTITY, 0x00A800, 0xA9E4D1,
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(16)));
	public static final RegistryObject<ModSpawnEggItem> unicorn_spawn_egg = ITEMS.register("unicorn_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.UNICORN_ENTITY, 0xFFFFFF, 0x97FFFF,
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(16)));
	public static final RegistryObject<ModSpawnEggItem> siren_spawn_egg = ITEMS.register("siren_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.SIREN_ENTITY, 0x007774, 0x000000,
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(16)));
	public static final RegistryObject<ModSpawnEggItem> FAIRY_SPAWN_EGG = ITEMS.register("fairy_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.FAIRY_ENTITY, 0xFF0000, 0x500000,
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(16)));
	public static final RegistryObject<ModSpawnEggItem> LILITH_SPAWN_EGG = ITEMS.register("lilith_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.LILITH_ENTITY, 0x770000, 0x735C30,
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(16)));
	public static final RegistryObject<ModSpawnEggItem> ILAGER_EVOKER = ITEMS.register("ilager_evoker_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.EVOKER, 0x770000, 0x770000,
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(16)));

	public static final RegistryObject<ModSpawnEggItem> VAMPIRE_PIGLIN= ITEMS.register("vampire_piglin_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.PIGLIN, 0x770000, 0x000000,
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(16)));
	public static final RegistryObject<ModSpawnEggItem> UNDERWATER_SLIME = ITEMS.register("underwater_slime_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.UNDERWATER_SLIME, 0x016300, 0x01636D,
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(16)));
	public static final RegistryObject<ModSpawnEggItem> WENDIGO = ITEMS.register("wendigo_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.WENDIGO_ENTITY, 0x440026, 0x424271,
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(16)));
	public static final RegistryObject<ModSpawnEggItem> ILAGER_PILLAGER = ITEMS.register("ilager_pillager_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.PILLAGER, 0x770000, 0x634C47,
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(16)));

	public static final RegistryObject<ModSpawnEggItem> ILAGER_VINDICATOR = ITEMS.register("ilager_vindicator_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.VINDICATOR, 0x770000, 0x878787,
					new Item.Properties().tab(MythicCraftItems.instance).stacksTo(16)));
	

	public static final DeferredRegister<Item> NO_BLOCK_ITEM = DeferredRegister.create(ForgeRegistries.ITEMS,
			MythicCraft.MOD_ID);

}
