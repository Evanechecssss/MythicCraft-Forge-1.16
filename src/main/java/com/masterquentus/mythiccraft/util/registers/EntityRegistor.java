package com.masterquentus.mythiccraft.util.registers;

import com.masterquentus.mythiccraft.client.entity.render.*;
import com.masterquentus.mythiccraft.client.entity.render.vampires.IlagerVampireRenders;
import com.masterquentus.mythiccraft.entities.vampire.IlagerTypes;
import com.masterquentus.mythiccraft.entities.vampire.VampireEvokerEntity;
import com.masterquentus.mythiccraft.init.ModEntityTypes;
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

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.EVOKER.get(), (manager) -> new IlagerVampireRenders<VampireEvokerEntity>(manager, IlagerTypes.EVOKER));

    }

}