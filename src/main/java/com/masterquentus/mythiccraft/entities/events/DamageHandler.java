package com.masterquentus.mythiccraft.entities.events;

import com.masterquentus.mythiccraft.entities.WendigoEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 07.11.2021
 * \* Description:
 * \
 */
public class DamageHandler {
    @SubscribeEvent
    public void attacked(LivingAttackEvent event) {
        if (event.getEntity() instanceof WendigoEntity) {
            event.setCanceled(
                   !((WendigoEntity) event.getEntity()).attacked(event.getSource(), event.getAmount())
            );
        }
    }
}