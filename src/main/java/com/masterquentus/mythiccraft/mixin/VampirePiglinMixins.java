package com.masterquentus.mythiccraft.mixin;

import com.masterquentus.mythiccraft.entities.vampire.VampirePiglinEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.BrainUtil;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.EntityPredicates;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 08.11.2021
 * \* Description:
 * \
 */
@Mixin(PiglinTasks.class)
public class VampirePiglinMixins {
    @Inject(at = @At(value = "TAIL"), method = "findNearestValidAttackTarget(Lnet/minecraft/entity/monster/piglin/PiglinEntity;)Ljava/util/Optional;", cancellable = true,remap=false)
    protected static void findNearestValidAttackTarget(PiglinEntity p_234526_0_, CallbackInfoReturnable<Optional<? extends LivingEntity>> cir) {
        if(p_234526_0_ instanceof VampirePiglinEntity){
            Brain<PiglinEntity> brain = p_234526_0_.getBrain();
            Optional<PlayerEntity> optional2 = brain.getMemory(MemoryModuleType.NEAREST_TARGETABLE_PLAYER_NOT_WEARING_GOLD);
            cir.setReturnValue(optional2);
        }
    }


    private static boolean isNearZombified(PiglinEntity p_234525_0_) {
        Brain<PiglinEntity> brain = p_234525_0_.getBrain();
        if (brain.hasMemoryValue(MemoryModuleType.NEAREST_VISIBLE_ZOMBIFIED)) {
            LivingEntity livingentity = brain.getMemory(MemoryModuleType.NEAREST_VISIBLE_ZOMBIFIED).get();
            return p_234525_0_.closerThan(livingentity, 6.0D);
        } else {
            return false;
        }
    }

    private static boolean isAttackAllowed(LivingEntity p_234506_0_) {
        return EntityPredicates.ATTACK_ALLOWED.test(p_234506_0_);
    }
}