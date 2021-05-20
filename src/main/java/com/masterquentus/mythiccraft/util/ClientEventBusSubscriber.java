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
import com.masterquentus.mythiccraft.objects.blocks.ModContainerTypes;
import com.masterquentus.mythiccraft.objects.blocks.ModEntityTypes;

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

		// Sapling
		RenderTypeLookup.setRenderLayer(BlockInit.bloodoak_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.whiteoak_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.silverwood_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.witchwood_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.alder_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.hawthorn_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.rowan_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.willow_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.beech_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ash_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.blackthorn_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.cedar_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.elder_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.juniper_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.witchhazel_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.yew_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.charred_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.infested_sapling.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ICY_SAPLING.get(), RenderType.getCutout());

		// Crops
		RenderTypeLookup.setRenderLayer(BlockInit.vervain_crop.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.garlic_crop.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.belladonna_crop.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.foxgloves_crop.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.mandrake_crop.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.nightshade_crop.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.wormwood_crop.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.wolfsbane_crop.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.hellebore_crop.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.whitesage_crop.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.waterartichoke_crop.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.snowbell_crop.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ICY_BERRY_BUSH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.BLOOD_BERRY_BUSH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SILVER_BERRY_BUSH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CHARRED_BERRY_BUSH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SOUL_BERRY_BUSH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.INFESTED_BERRY_BUSH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.MYSTIC_BERRY_BUSH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LIVING_KELP.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LIVING_KELP_TOP.get(), RenderType.getCutout());

		// Torches
		RenderTypeLookup.setRenderLayer(BlockInit.BLOOD_TORCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SILVER_TORCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SOUL_TORCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.UNDEAD_TORCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.MYSTIC_TORCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ENDER_TORCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.FAIRY_TORCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.PIXIE_TORCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LIFE_TORCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.FERAL_TORCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LOVE_TORCH.get(), RenderType.getCutout());

		// Doors
		RenderTypeLookup.setRenderLayer(BlockInit.bloodoak_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.whiteoak_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.silverwood_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.alder_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.hawthorn_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.rowan_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.willow_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.beech_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ash_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.blackthorn_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.cedar_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.elder_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.juniper_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.witchhazel_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.yew_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.charred_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.infested_door.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ICY_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.bloodoak_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.silverwood_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.witchwood_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.alder_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.hawthorn_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.rowan_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.willow_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.beech_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ash_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.blackthorn_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.cedar_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.elder_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.juniper_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.witchhazel_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.yew_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.infested_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ICY_TRAPDOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.HELL_FIRE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CHARREDSLIME_BLOCK.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.CONGEALED_BLOOD.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.INFESTEDSLIME_BLOCK.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.MAGIC_WALL.get(), RenderType.getTranslucent());

		// Transparent Blocks
		RenderTypeLookup.setRenderLayer(BlockInit.BLACK_ICE.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.CRIMSON_ICE.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PIXIE_GLASS.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.FAIRY_GLASS.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PIXIE_GLASS_PANE.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.FAIRY_GLASS_PANE.get(), RenderType.getTranslucent());
		
		// Mic
		RenderTypeLookup.setRenderLayer(BlockInit.PEDESTAL_TIER3.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PEDESTAL_TIER3.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.PEDESTAL_TIER4.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PEDESTAL_TIER4.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.BLOOD_LANTERN.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SILVER_LANTERN.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SOUL_LANTERN.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.UNDEAD_LANTERN.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.MYSTIC_LANTERN.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ENDER_LANTERN.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.FAIRY_LANTERN.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.PIXIE_LANTERN.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LIFE_LANTERN.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.FERAL_LANTERN.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LOVE_LANTERN.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.BLOODY_ROSE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.HELL_FIRE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.WEEPING_VINES.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SPANISH_MOSS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.pandors_box_open.get(), RenderType.getCutout());


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