package com.masterquentus.mythiccraft.mixin;

import com.google.common.collect.Lists;
import com.masterquentus.mythiccraft.entities.vampire.VampirePiglinEntity;
import com.masterquentus.mythiccraft.init.ItemInit;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.BrainUtil;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityPredicates;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 09.11.2021
 * \* Description:
 * \
 */
@Mixin(PiglinTasks.class)
public abstract class VampirePiglinTask {
    @Inject(at = @At(value = "HEAD"), method = "findNearestValidAttackTarget(Lnet/minecraft/entity/monster/piglin/PiglinEntity;)Ljava/util/Optional;", cancellable = true,remap=false)
    private static void findNearestValidAttackTarget(PiglinEntity p_234526_0_, CallbackInfoReturnable<Optional<? extends LivingEntity>> cir) {
        cir.cancel();
        Brain<PiglinEntity> brain = p_234526_0_.getBrain();
        if (isNearZombified(p_234526_0_)) {
            cir.setReturnValue(Optional.empty());
        } else {
            Optional<LivingEntity> optional = BrainUtil.getLivingEntityFromUUIDMemory(p_234526_0_, MemoryModuleType.ANGRY_AT);
            if (optional.isPresent() && isAttackAllowed(optional.get())) {
                cir.setReturnValue(optional);
            } else {
                if (brain.hasMemoryValue(MemoryModuleType.UNIVERSAL_ANGER)) {
                    Optional<PlayerEntity> optional1 = brain.getMemory(MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER);
                    if (optional1.isPresent()) {
                        cir.setReturnValue(optional1);
                    }
                }

                Optional<MobEntity> optional3 = brain.getMemory(MemoryModuleType.NEAREST_VISIBLE_NEMESIS);
                if (optional3.isPresent()) {
                    cir.setReturnValue(optional3);
                } else {
                    if(p_234526_0_ instanceof VampirePiglinEntity){
                        Optional<PlayerEntity> optional2 = brain.getMemory(MemoryModuleType.NEAREST_TARGETABLE_PLAYER_NOT_WEARING_GOLD);
                        Optional<PlayerEntity> goldoptional =  optional2.filter(getPlayersWithoutVamipreArmor());
                        cir.setReturnValue(goldoptional.isPresent() && isAttackAllowed(goldoptional.get()) ? goldoptional : Optional.empty());
                    }else{
                        Optional<PlayerEntity> optional2 = brain.getMemory(MemoryModuleType.NEAREST_TARGETABLE_PLAYER_NOT_WEARING_GOLD);
                        cir.setReturnValue(optional2.isPresent() && isAttackAllowed(optional2.get()) ? optional2 : Optional.empty());
                    }
                }
            }
        }
    }
    private static Predicate<PlayerEntity> getPlayersWithoutVamipreArmor(){
        return entity -> !playerInVamparickArmore(entity);
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
    private static boolean playerInVamparickArmore(PlayerEntity entity){
        Iterable<ItemStack> stackIterable = entity.getArmorSlots();
        List<ItemStack> armor_list = Lists.newArrayList(stackIterable);
        return armor_list.get(3).getItem().equals(ItemInit.vampiric_helmet.get()) && armor_list.get(2).getItem().equals(ItemInit.vampiric_chestplate.get()) &&
                armor_list.get(1).getItem().equals(ItemInit.vampiric_leggings.get()) && armor_list.get(0).getItem().equals(ItemInit.vampiric_boots.get());
    }
}