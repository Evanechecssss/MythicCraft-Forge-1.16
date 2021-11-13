package com.masterquentus.mythiccraft.mixin;

import com.masterquentus.mythiccraft.entities.vampire.VampirePiglinEntity;
import com.masterquentus.mythiccraft.init.ItemInit;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.piglin.AdmireItemTask;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 10.11.2021
 * \* Description:
 * \
 */
@Mixin(AdmireItemTask.class)
public abstract class AdmirePiglinMixin {
    @Inject(at = @At(value = "HEAD"), method = "Lnet/minecraft/entity/monster/piglin/AdmireItemTask;checkExtraStartConditions(Lnet/minecraft/world/server/ServerWorld;Lnet/minecraft/entity/monster/piglin/PiglinEntity;)Z", cancellable = true)
    private void checkExtraStartConditions(ServerWorld p_212832_1_, PiglinEntity p_212832_2_, CallbackInfoReturnable<Boolean> info) {
        info.cancel();
        ItemEntity itementity = p_212832_2_.getBrain().getMemory(MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM).get();
        if (p_212832_2_ instanceof VampirePiglinEntity) {
            info.setReturnValue(itementity.getItem().getItem() == ItemInit.BLOODSTONE_INGOT.get());
        }else {
            info.setReturnValue(isLovedItem(itementity.getItem().getItem()));
        }
    }
    private static boolean isLovedItem(Item p_234480_0_) {
        return p_234480_0_.is(ItemTags.PIGLIN_LOVED);
    }
}