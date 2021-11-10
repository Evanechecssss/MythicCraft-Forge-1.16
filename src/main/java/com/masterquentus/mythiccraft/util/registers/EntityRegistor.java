package com.masterquentus.mythiccraft.util.registers;

import com.masterquentus.mythiccraft.client.entity.render.*;
import com.masterquentus.mythiccraft.client.entity.render.vampires.IlagerVampireRenders;
import com.masterquentus.mythiccraft.entities.vampire.*;
import com.masterquentus.mythiccraft.init.ModEntityTypes;
import net.minecraft.world.raid.Raid;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class EntityRegistor {

	public static void registor(FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GOBLIN_ENTITY.get(), GoblinEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BASILISK_ENTITY.get(),
				BasiliskEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.UNICORN_ENTITY.get(), UnicornEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SIREN_ENTITY.get(), SirenEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.FAIRY_ENTITY.get(), FairyEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.LILITH_ENTITY.get(), LilithEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MOB_SUMMON.get(),
				MobSummonProjectileRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.WENDIGO_ENTITY.get(),WendigoEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.EVOKER.get(), (manager) -> new IlagerVampireRenders<VampireEvokerEntity>(manager, VampireTypes.EVOKER));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PIGLIN.get(), (manager) -> new IlagerVampireRenders<VampirePiglinEntity>(manager, VampireTypes.PIGLIN));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PILLAGER.get(), (manager) -> new IlagerVampireRenders<VampirePillagerEntity>(manager, VampireTypes.PILLAGER));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.VINDICATOR.get(), (manager) -> new IlagerVampireRenders<VampireVindicatorEntity>(manager, VampireTypes.VINDICATOR));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.UNDERWATER_SLIME.get(), UnderwaterSlimeRender::new);
		    RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.EVOKER.get(),
				(manager) -> new IlagerVampireRenders<VampireEvokerEntity>(manager, IlagerTypes.EVOKER));
		    RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PILLAGER.get(),
				(manager) -> new IlagerVampireRenders<VampirePillagerEntity>(manager, IlagerTypes.PILLAGER));
		    RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.VINDICATOR.get(),
				(manager) -> new IlagerVampireRenders<VampireVindicatorEntity>(manager, IlagerTypes.VINDICATOR));

		Raid.WaveMember.create("VAMPIRE_EVOKER", ModEntityTypes.EVOKER.get(), new int[] { 0, 0, 2, 0, 1, 4, 2, 5 });
		Raid.WaveMember.create("VAMPIRE_PILLAGER", ModEntityTypes.PILLAGER.get(), new int[] { 0, 0, 2, 0, 1, 4, 2, 5 });
		Raid.WaveMember.create("VAMPIRE_VINDICATOR", ModEntityTypes.VINDICATOR.get(),
				new int[] { 0, 0, 2, 0, 1, 4, 2, 5 });
	}

}