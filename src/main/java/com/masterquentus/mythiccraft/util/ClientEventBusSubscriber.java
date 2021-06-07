package com.masterquentus.mythiccraft.util;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.client.entity.render.BasiliskEntityRender;
import com.masterquentus.mythiccraft.client.entity.render.FairyEntityRender;
import com.masterquentus.mythiccraft.client.entity.render.GoblinEntityRender;
import com.masterquentus.mythiccraft.client.entity.render.LilithEntityRender;
import com.masterquentus.mythiccraft.client.entity.render.SirenEntityRender;
import com.masterquentus.mythiccraft.client.entity.render.UnicornEntityRender;
import com.masterquentus.mythiccraft.client.gui.*;
import com.masterquentus.mythiccraft.init.BlockInit;
import com.masterquentus.mythiccraft.init.ModContainerTypes;
import com.masterquentus.mythiccraft.init.ModEntityTypes;

import com.masterquentus.mythiccraft.init.auto.LanternType;
import com.masterquentus.mythiccraft.init.auto.WoodTypes;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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

		// Sapling & Door
		for (WoodTypes wood : WoodTypes.values()){
			RenderTypeLookup.setRenderLayer(wood.sapling.get(), RenderType.cutout());
			RenderTypeLookup.setRenderLayer(wood.door.get(), RenderType.cutout());
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
		RenderTypeLookup.setRenderLayer(BlockInit.LIVING_KELP.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LIVING_KELP_TOP.get(), RenderType.cutout());

		// Torches
		RenderTypeLookup.setRenderLayer(BlockInit.BLOOD_TORCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SILVER_TORCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SOUL_TORCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.UNDEAD_TORCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.MYSTIC_TORCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ENDER_TORCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.FAIRY_TORCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.PIXIE_TORCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LIFE_TORCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.FERAL_TORCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LOVE_TORCH.get(), RenderType.cutout());

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
		
		// Mic
		RenderTypeLookup.setRenderLayer(BlockInit.PEDESTAL_TIER3.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PEDESTAL_TIER3.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.PEDESTAL_TIER4.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PEDESTAL_TIER4.get(), RenderType.cutout());

		for (LanternType lantern : LanternType.values()){
			RenderTypeLookup.setRenderLayer(lantern.block.get(), RenderType.cutout());
		}
		RenderTypeLookup.setRenderLayer(BlockInit.BLOODY_ROSE.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.HELL_FIRE.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.WEEPING_VINES.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SPANISH_MOSS.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(BlockInit.pandors_box_open.get(), RenderType.cutout());


		// Entities
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GOBLIN_ENTITY.get(), GoblinEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BASILISK_ENTITY.get(),
				BasiliskEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.UNICORN_ENTITY.get(), UnicornEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SIREN_ENTITY.get(), SirenEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.FAIRY_ENTITY.get(), FairyEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.LILITH_ENTITY.get(), LilithEntityRender::new);

	}
}