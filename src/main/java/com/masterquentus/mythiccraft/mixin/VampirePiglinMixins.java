package com.masterquentus.mythiccraft.mixin;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.entities.vampire.VampirePiglinEntity;
import com.masterquentus.mythiccraft.init.ItemInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.PiglinMobsSensor;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 08.11.2021
 * \* Description:
 * \
 */
@Mixin(PiglinMobsSensor.class)
public abstract class VampirePiglinMixins {
    @Inject(at = @At(value = "TAIL"), method = "doTick(Lnet/minecraft/world/server/ServerWorld;Lnet/minecraft/entity/LivingEntity;)V", cancellable = true)
    protected void doTick(ServerWorld p_212872_1_, LivingEntity piglin, CallbackInfo info){
        Optional<PlayerEntity> optional = Optional.empty();
        Brain<?> brain = piglin.getBrain();
        for(LivingEntity livingentity : brain.getMemory(MemoryModuleType.VISIBLE_LIVING_ENTITIES).orElse(ImmutableList.of())) {
            if (livingentity instanceof PlayerEntity) {
                PlayerEntity playerentity = (PlayerEntity) livingentity;
                if (piglin instanceof VampirePiglinEntity){
                    playerInVamparickArmore(playerentity);
                    if (!optional.isPresent() && EntityPredicates.ATTACK_ALLOWED.test(livingentity) && (!PiglinTasks.isWearingGold(playerentity) || !playerInVamparickArmore(playerentity))) {
                        optional = Optional.of(playerentity);
                    }
                }else {
                    if (!optional.isPresent() && EntityPredicates.ATTACK_ALLOWED.test(livingentity) && !PiglinTasks.isWearingGold(playerentity)) {
                        optional = Optional.of(playerentity);
                    }
                }
            }
        }
        brain.setMemory(MemoryModuleType.NEAREST_TARGETABLE_PLAYER_NOT_WEARING_GOLD, optional);
        info.cancel();
    }

    private static boolean playerInVamparickArmore(PlayerEntity entity){
        Iterable<ItemStack> stackIterable = entity.getArmorSlots();
        List<ItemStack> armor_list = Lists.newArrayList(stackIterable);
        return armor_list.get(3).getItem().equals(ItemInit.vampiric_helmet.get()) && armor_list.get(2).getItem().equals(ItemInit.vampiric_chestplate.get()) &&
                armor_list.get(1).getItem().equals(ItemInit.vampiric_leggings.get()) && armor_list.get(0).getItem().equals(ItemInit.vampiric_boots.get());
    }
}
