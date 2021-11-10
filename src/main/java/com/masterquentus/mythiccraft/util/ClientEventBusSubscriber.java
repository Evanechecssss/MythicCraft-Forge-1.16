package com.masterquentus.mythiccraft.util;

import javax.annotation.Nonnull;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.client.entity.render.BasiliskEntityRender;
import com.masterquentus.mythiccraft.client.entity.render.FairyEntityRender;
import com.masterquentus.mythiccraft.client.entity.render.GoblinEntityRender;
import com.masterquentus.mythiccraft.client.entity.render.LilithEntityRender;
import com.masterquentus.mythiccraft.client.entity.render.MobSummonProjectileRenderer;
import com.masterquentus.mythiccraft.client.entity.render.SirenEntityRender;
import com.masterquentus.mythiccraft.client.entity.render.UnicornEntityRender;
import com.masterquentus.mythiccraft.client.gui.CrateScreen;
import com.masterquentus.mythiccraft.client.gui.WitchesOvenScreen;
import com.masterquentus.mythiccraft.client.tile.ItemPedestalRenderer;
import com.masterquentus.mythiccraft.events.loot.GobliniteDustAdditionModifier;
import com.masterquentus.mythiccraft.events.loot.VampiricGemStructureAdditionModifier;
import com.masterquentus.mythiccraft.init.BlockInit;
import com.masterquentus.mythiccraft.init.FluidInit;
import com.masterquentus.mythiccraft.init.ItemInit;
import com.masterquentus.mythiccraft.init.ModContainerTypes;
import com.masterquentus.mythiccraft.init.ModEntityTypes;
import com.masterquentus.mythiccraft.init.ModTileEntityTypes;
import com.masterquentus.mythiccraft.init.auto.LanternType;
import com.masterquentus.mythiccraft.init.auto.WoodTypes;
import com.masterquentus.mythiccraft.objects.blocks.WoodTypesInit;
import com.masterquentus.mythiccraft.util.registers.EntityRegistor;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MythicCraft.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.register(ModContainerTypes.bloodoak_crate.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.whiteoak_crate.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.SILVERWOOD_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.WITCHWOOD_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.ALDER_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.HAWTHORN_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.ROWAN_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.WILLOW_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.BEECH_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.ASH_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.BLACKTHORN_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.CEDAR_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.ELDER_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.JUNIPER_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.WITCHHAZEL_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.YEW_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.INFESTED_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.CHARRED_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.ICY_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.DISTORTED_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.TWISTED_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.HELLBARK_CRATE.get(), CrateScreen::new);
		ScreenManager.register(ModContainerTypes.WITCHES_OVEN_CONTAINER.get(), WitchesOvenScreen::new);

		ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.pedestal_tier1.get(), ItemPedestalRenderer::new);

		// Sapling, Door, Trapdoor, & Leaves
		for (WoodTypes wood : WoodTypes.values()) {
			RenderTypeLookup.setRenderLayer(wood.sapling.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(wood.door.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(wood.leaves.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(wood.trapdoor.get(), RenderType.cutout());

			// Pots
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_BLOODOAK_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_WHITEOAK_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_SILVERWOOD_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_WITCHWOOD_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_ALDER_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_HAWTHORN_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_ROWAN_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_WILLOW_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_BEECH_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_ASH_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_BLACKTHORN_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_CEDAR_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_ELDER_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_JUNIPER_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_WITCHHAZEL_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_YEW_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_INFESTED_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_CHARRED_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_ICY_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_TWISTED_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_DISTORTED_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.POTTED_HELLBARK_SAPLING.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(BlockInit.SEA_CANDLES.get(), RenderType.cutout());
		}

		// Crops
		RenderTypeLookup.setRenderLayer(BlockInit.vervain_crop.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.garlic_crop.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.belladonna_crop.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.foxgloves_crop.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.mandrake_crop.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.nightshade_crop.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.wormwood_crop.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.wolfsbane_crop.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.hellebore_crop.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.whitesage_crop.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.waterartichoke_crop.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.snowbell_crop.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ICY_BERRY_BUSH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.BLOOD_BERRY_BUSH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SILVER_BERRY_BUSH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CHARRED_BERRY_BUSH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SOUL_BERRY_BUSH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.INFESTED_BERRY_BUSH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.MYSTIC_BERRY_BUSH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CINDER_FRUIT_PLANT.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LIVING_KELP_PLANT.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LIVING_KELP_TOP.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.GRASSPER.get(), RenderType.cutout());

		RenderTypeLookup.setRenderLayer(BlockInit.HELL_FIRE.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CHARREDSLIME_BLOCK.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.CONGEALED_BLOOD.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.INFESTEDSLIME_BLOCK.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.MAGIC_WALL.get(), RenderType.translucent());

		// Transparent Blocks
		RenderTypeLookup.setRenderLayer(BlockInit.BLACK_ICE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.CRIMSON_ICE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PIXIE_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.FAIRY_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PIXIE_GLASS_PANE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.FAIRY_GLASS_PANE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.CRIMSON_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.CRIMSON_GLASS_PANE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.ICY_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.ICY_GLASS_PANE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EMBER_GLASS.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.EMBER_GLASS_PANE.get(), RenderType.translucent());

		// Mic
		RenderTypeLookup.setRenderLayer(BlockInit.PEDESTAL_TIER3.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PEDESTAL_TIER3.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.PEDESTAL_TIER4.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PEDESTAL_TIER4.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.PEDESTAL_TIER5.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PEDESTAL_TIER5.get(), RenderType.cutout());

		for (LanternType lantern : LanternType.values()) {
			RenderTypeLookup.setRenderLayer(lantern.block.get(), RenderType.cutout());
		}
		RenderTypeLookup.setRenderLayer(BlockInit.BLOODY_ROSE.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.POTTED_BLOODY_ROSE.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.GlOW_FLOWER.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.POTTED_GlOW_FLOWER.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.BONE_FLOWER.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.POTTED_BONE_FLOWER.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.FIRE_FLOWER.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.POTTED_FIRE_FLOWER.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.PRICKLY_FLOWER.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.POTTED_SCORCHED_FLOWER.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.POTTED_SCORCHED_FLOWER.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.EMBER_MOSS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SCORCHED_FLOWER.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SCORCHED_GRASS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SCORCHED_GRASS_GLOWING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SCORCHED_GRASS_MEDIUM.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SCORCHED_GRASS_SMALL.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.TALL_SCORCHED_GRASS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.TALL_SCORCHED_GRASS_GLOWING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.TALL_SCORCHED_GRASS_MEDIUM.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.TAll_SCORCHED_GRASS_SMALL.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.INFESTED_GRASS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.TAll_INFESTED_GRASS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CHARRED_GRASS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.BLOODLY_GRASS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.TAll_BLOODLY_GRASS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.MYSTIC_GRASS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.TAll_MYSTIC_GRASS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEEP_GRASS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.TAll_DEEP_GRASS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.TAll_CHARRED_GRASS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.FIRE_FLOWER.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.WISPY_COTTON.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.GLINT_WEED.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.HELL_FIRE.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.WEEPING_VINES.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SPANISH_MOSS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ENDER_BRAMBLE.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.WILD_BRAMBLE.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.pandors_box_open.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LIVING_KELP_TOP.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LIVING_KELP_PLANT.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LILITH_TROPHY.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LIVING_CORAL.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_LIVING_CORAL.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LIVING_CORAL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_LIVING_CORAL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LIVING_CORAL_WALL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_LIVING_CORAL_WALL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.BLOODLY_CORAL.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_BLOODLY_CORAL.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.BLOODLY_CORAL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_BLOODLY_CORAL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.BLOODLY_CORAL_WALL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_BLOODLY_CORAL_WALL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.TWILIGHT_CORAL.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_TWILIGHT_CORAL.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.TWILIGHT_CORAL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_TWILIGHT_CORAL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.TWILIGHT_CORAL_WALL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_TWILIGHT_CORAL_WALL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CRIMSON_CORAL_WALL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_CRIMSON_CORAL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_CRIMSON_CORAL_WALL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CRIMSON_CORAL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CRIMSON_CORAL.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_CRIMSON_CORAL.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ICY_CORAL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ICY_CORAL_WALL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_ICY_CORAL_WALL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ICY_CORAL.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_ICY_CORAL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_ICY_CORAL.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_DRAGON_CORAL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_DRAGON_CORAL_WALL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DRAGON_CORAL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DRAGON_CORAL_WALL_FAN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DRAGON_CORAL.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_DRAGON_CORAL.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ENDER_CACTUS.get(), RenderType.cutout());

		RenderTypeLookup.setRenderLayer(BlockInit.DEEP_GRASS_BLOCK.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.INFESTED_GRASS_BLOCK.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CHARRED_GRASS_BLOCK.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.BLOODLY_GRASS_BLOCK.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.MYSTIC_GRASS_BLOCK.get(), RenderType.cutout());

		RenderTypeLookup.setRenderLayer(FluidInit.BLOOD_FLUID.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(FluidInit.BLOOD_BLOCK.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(FluidInit.BLOOD_FLOWING.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(FluidInit.ECTOPLASM_FLUID.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(FluidInit.ECTOPLASM_BLOCK.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(FluidInit.ECTOPLASM_FLOWING.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(FluidInit.INFESTEDGOO_FLUID.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(FluidInit.INFESTEDGOO_BLOCK.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(FluidInit.INFESTEDGOO_FLOWING.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(FluidInit.DARK_WATER_FLUID.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(FluidInit.DARK_WATER_BLOCK.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(FluidInit.DARK_WATER_FLOWING.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(FluidInit.MANA_FLUID.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(FluidInit.MANA_BLOCK.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(FluidInit.MANA_FLOWING.get(), RenderType.translucent());

		Atlases.addWoodType(WoodTypesInit.BLOOD_OAK);
		Atlases.addWoodType(WoodTypesInit.WHITE_OAK);
		Atlases.addWoodType(WoodTypesInit.SILVER_WOOD);
		Atlases.addWoodType(WoodTypesInit.WITCH_WOOD);
		Atlases.addWoodType(WoodTypesInit.ALDER);
		Atlases.addWoodType(WoodTypesInit.HAWTHORN);
		Atlases.addWoodType(WoodTypesInit.ROWAN);
		Atlases.addWoodType(WoodTypesInit.WILLOW);
		Atlases.addWoodType(WoodTypesInit.BEECH);
		Atlases.addWoodType(WoodTypesInit.ASH);
		Atlases.addWoodType(WoodTypesInit.BLACKTHORN);
		Atlases.addWoodType(WoodTypesInit.CEDAR);
		Atlases.addWoodType(WoodTypesInit.ELDER);
		Atlases.addWoodType(WoodTypesInit.JUNIPER);
		Atlases.addWoodType(WoodTypesInit.WITCHHAZEL);
		Atlases.addWoodType(WoodTypesInit.YEW);
		Atlases.addWoodType(WoodTypesInit.INFESTED);
		Atlases.addWoodType(WoodTypesInit.CHARRED);
		Atlases.addWoodType(WoodTypesInit.ICY);
		Atlases.addWoodType(WoodTypesInit.TWISTED);
		Atlases.addWoodType(WoodTypesInit.DISTORTED);
		Atlases.addWoodType(WoodTypesInit.HELLBARK);

		ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.SIGN_TILE_ENTITY.get(), SignTileEntityRenderer::new);

		ItemModelsProperties.register(ItemInit.DRAGONBONE_BOW.get(), new ResourceLocation("pull"),
				(p_239429_0_, p_239429_1_, p_239429_2_) -> {
					if (p_239429_2_ == null) {
						return 0.0F;
					} else {
						return p_239429_2_.getUseItem() != p_239429_0_ ? 0.0F
								: (float) (p_239429_0_.getUseDuration() - p_239429_2_.getUseItemRemainingTicks())
										/ 20.0F;
					}
				});
		ItemModelsProperties.register(ItemInit.DRAGONBONE_BOW.get(), new ResourceLocation("pulling"),
				(p_239428_0_, p_239428_1_, p_239428_2_) -> {
					return p_239428_2_ != null && p_239428_2_.isUsingItem() && p_239428_2_.getUseItem() == p_239428_0_
							? 1.0F
							: 0.0F;
				});

		// Entities
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GOBLIN_ENTITY.get(), GoblinEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BASILISK_ENTITY.get(),
				BasiliskEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.UNICORN_ENTITY.get(), UnicornEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SIREN_ENTITY.get(), SirenEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.FAIRY_ENTITY.get(), FairyEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.LILITH_ENTITY.get(), LilithEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MOB_SUMMON.get(),
				MobSummonProjectileRenderer::new);
		EntityRegistor.registor(event);
		
	}

		 @SubscribeEvent
		    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
		                                                           event) {
		        event.getRegistry().registerAll(
		                new VampiricGemStructureAdditionModifier.Serializer().setRegistryName
		                        (new ResourceLocation(MythicCraft.MOD_ID,"vampiric_gem_in_jungle_temple"))
		        );
		        
		        event.getRegistry().registerAll(
		                new GobliniteDustAdditionModifier.Serializer().setRegistryName
		                        (new ResourceLocation(MythicCraft.MOD_ID,"goblinite_dust_from_stone"))
		        );
		    }
		}