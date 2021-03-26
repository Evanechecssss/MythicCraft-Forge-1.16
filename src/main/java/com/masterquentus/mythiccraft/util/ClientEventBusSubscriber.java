package com.masterquentus.mythiccraft.util;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.client.entity.render.BasiliskEntityRender;
import com.masterquentus.mythiccraft.client.entity.render.FairyEntityRender;
import com.masterquentus.mythiccraft.client.entity.render.GoblinEntityRender;
import com.masterquentus.mythiccraft.client.entity.render.LilithEntityRender;
import com.masterquentus.mythiccraft.client.entity.render.SirenEntityRender;
import com.masterquentus.mythiccraft.client.entity.render.UnicornEntityRender;
import com.masterquentus.mythiccraft.client.gui.BloodOakCrateScreen;
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

		ScreenManager.registerFactory(ModContainerTypes.bloodoak_crate.get(), BloodOakCrateScreen::new);

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
		RenderTypeLookup.setRenderLayer(BlockInit.bloodoak_trapdoor.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.whiteoak_trapdoor.get(), RenderType.getCutout());
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