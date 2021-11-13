package com.masterquentus.mythiccraft.mixin;

import com.google.common.collect.Lists;
import com.masterquentus.mythiccraft.entities.vampire.VampirePiglinEntity;
import com.masterquentus.mythiccraft.init.ItemInit;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.BrainUtil;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
    @Final
    @Shadow()
    private static Set<Item> FOOD_ITEMS;

    @Inject(at = @At(value = "HEAD"), method = "findNearestValidAttackTarget(Lnet/minecraft/entity/monster/piglin/PiglinEntity;)Ljava/util/Optional;", cancellable = true)
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
                    if (p_234526_0_ instanceof VampirePiglinEntity) {
                        Optional<PlayerEntity> optional2 = brain.getMemory(MemoryModuleType.NEAREST_TARGETABLE_PLAYER_NOT_WEARING_GOLD);
                        Optional<PlayerEntity> goldoptional = optional2.filter(getPlayersWithoutVamipreArmor());
                        cir.setReturnValue(goldoptional.isPresent() && isAttackAllowed(goldoptional.get()) ? goldoptional : Optional.empty());
                    } else {
                        Optional<PlayerEntity> optional2 = brain.getMemory(MemoryModuleType.NEAREST_TARGETABLE_PLAYER_NOT_WEARING_GOLD);
                        cir.setReturnValue(optional2.isPresent() && isAttackAllowed(optional2.get()) ? optional2 : Optional.empty());
                    }
                }
            }
        }
    }


    @Inject(at = @At(value = "HEAD"), method = "pickUpItem(Lnet/minecraft/entity/monster/piglin/PiglinEntity;Lnet/minecraft/entity/item/ItemEntity;)V", cancellable = true)
    private static void pickUpItem(PiglinEntity p_234470_0_, ItemEntity p_234470_1_, CallbackInfo cir) {
        cir.cancel();
        stopWalking(p_234470_0_);
        ItemStack itemstack;
        if (p_234470_0_ instanceof VampirePiglinEntity){
            if (p_234470_1_.getItem().getItem() == ItemInit.BLOODSTONE_INGOT.get()) {
                p_234470_0_.take(p_234470_1_, p_234470_1_.getItem().getCount());
                itemstack = p_234470_1_.getItem();
                p_234470_1_.remove();
            } else {
                p_234470_0_.take(p_234470_1_, 1);
                itemstack = removeOneItemFromItemEntity(p_234470_1_);
            }

            Item item = itemstack.getItem();
            if (p_234470_1_.getItem().getItem() == ItemInit.BLOODSTONE_INGOT.get()) {
                p_234470_0_.getBrain().eraseMemory(MemoryModuleType.TIME_TRYING_TO_REACH_ADMIRE_ITEM);
                holdInOffhand(p_234470_0_, itemstack);
                admireGoldItem(p_234470_0_);
            } else if (isFood(item) && !hasEatenRecently(p_234470_0_)) {
                eat(p_234470_0_);
            } else {
                boolean flag = p_234470_0_.equipItemIfPossible(itemstack);
                if (!flag) {
                    putInInventory(p_234470_0_, itemstack);
                }
            }
        }else
        {
            if (p_234470_1_.getItem().getItem() == Items.GOLD_NUGGET) {
                p_234470_0_.take(p_234470_1_, p_234470_1_.getItem().getCount());
                itemstack = p_234470_1_.getItem();
                p_234470_1_.remove();
            } else {
                p_234470_0_.take(p_234470_1_, 1);
                itemstack = removeOneItemFromItemEntity(p_234470_1_);
            }

            Item item = itemstack.getItem();
            if (isLovedItem(item)) {
                p_234470_0_.getBrain().eraseMemory(MemoryModuleType.TIME_TRYING_TO_REACH_ADMIRE_ITEM);
                holdInOffhand(p_234470_0_, itemstack);
                admireGoldItem(p_234470_0_);
            } else if (isFood(item) && !hasEatenRecently(p_234470_0_)) {
                eat(p_234470_0_);
            } else {
                boolean flag = p_234470_0_.equipItemIfPossible(itemstack);
                if (!flag) {
                    putInInventory(p_234470_0_, itemstack);
                }
            }
        }

    }
    @Inject(at = @At(value = "HEAD"), method = "stopHoldingOffHandItem(Lnet/minecraft/entity/monster/piglin/PiglinEntity;Z)V", cancellable = true)
    private static void stopHoldingOffHandItem(PiglinEntity p_234477_0_, boolean p_234477_1_, CallbackInfo info) {
        if(p_234477_0_ instanceof VampirePiglinEntity){
            ItemStack itemstack = p_234477_0_.getItemInHand(Hand.OFF_HAND);
            p_234477_0_.setItemInHand(Hand.OFF_HAND, ItemStack.EMPTY);
            if (p_234477_0_.isAdult()) {
                boolean flag = itemstack.getItem() == ItemInit.BLOODSTONE_INGOT.get();
                if (p_234477_1_ && flag) {
                    throwItems(p_234477_0_, getBarterResponseItems(p_234477_0_));
                } else if (!flag) {
                    boolean flag1 = p_234477_0_.equipItemIfPossible(itemstack);
                    if (!flag1) {
                        putInInventory(p_234477_0_, itemstack);
                    }
                }
            } else {
                boolean flag2 = p_234477_0_.equipItemIfPossible(itemstack);
                if (!flag2) {
                    ItemStack itemstack1 = p_234477_0_.getMainHandItem();
                    if (itemstack1.getItem()== ItemInit.BLOODSTONE_INGOT.get()) {
                        putInInventory(p_234477_0_, itemstack1);
                    } else {
                        throwItems(p_234477_0_, Collections.singletonList(itemstack1));
                    }

                    p_234477_0_.holdInMainHand(itemstack);
                }
            }
        }else {
            ItemStack itemstack = p_234477_0_.getItemInHand(Hand.OFF_HAND);
            p_234477_0_.setItemInHand(Hand.OFF_HAND, ItemStack.EMPTY);
            if (p_234477_0_.isAdult()) {
                boolean flag = itemstack.isPiglinCurrency();
                if (p_234477_1_ && flag) {
                    throwItems(p_234477_0_, getBarterResponseItems(p_234477_0_));
                } else if (!flag) {
                    boolean flag1 = p_234477_0_.equipItemIfPossible(itemstack);
                    if (!flag1) {
                        putInInventory(p_234477_0_, itemstack);
                    }
                }
            } else {
                boolean flag2 = p_234477_0_.equipItemIfPossible(itemstack);
                if (!flag2) {
                    ItemStack itemstack1 = p_234477_0_.getMainHandItem();
                    if (isLovedItem(itemstack1.getItem())) {
                        putInInventory(p_234477_0_, itemstack1);
                    } else {
                        throwItems(p_234477_0_, Collections.singletonList(itemstack1));
                    }

                    p_234477_0_.holdInMainHand(itemstack);
                }
            }
        }
    }
    @Inject(at = @At(value = "HEAD"), method = "wantsToPickup(Lnet/minecraft/entity/monster/piglin/PiglinEntity;Lnet/minecraft/item/ItemStack;)Z", cancellable = true)
    private static void wantsToPickup(PiglinEntity p_234474_0_, ItemStack p_234474_1_, CallbackInfoReturnable<Boolean> cir) {
        cir.cancel();
        Item item = p_234474_1_.getItem();
        if (p_234474_0_ instanceof VampirePiglinEntity){
            if (item.is(ItemTags.PIGLIN_REPELLENTS)) {
                cir.setReturnValue(false);
            } else if (isAdmiringDisabled(p_234474_0_) && p_234474_0_.getBrain().hasMemoryValue(MemoryModuleType.ATTACK_TARGET)) {
                cir.setReturnValue(false);
            } else if (item == ItemInit.BLOODSTONE_INGOT.get()) {
                cir.setReturnValue(isNotHoldingLovedItemInOffHand(p_234474_0_));
            } else {
                boolean flag = p_234474_0_.canAddToInventory(p_234474_1_);
                if (item == ItemInit.BLOODSTONE_INGOT.get()) {
                    cir.setReturnValue(flag);
                } else if (isFood(item)) {
                    cir.setReturnValue(!hasEatenRecently(p_234474_0_) && flag);
                } else if (item != ItemInit.BLOODSTONE_INGOT.get()) {
                    cir.setReturnValue(p_234474_0_.canReplaceCurrentItem(p_234474_1_));
                } else {
                    cir.setReturnValue(isNotHoldingLovedItemInOffHand(p_234474_0_) && flag);
                }
            }
        }else
        {
            if (item.is(ItemTags.PIGLIN_REPELLENTS)) {
                cir.setReturnValue(false);
            } else if (isAdmiringDisabled(p_234474_0_) && p_234474_0_.getBrain().hasMemoryValue(MemoryModuleType.ATTACK_TARGET)) {
                cir.setReturnValue(false);
            } else if (p_234474_1_.isPiglinCurrency()) {
                cir.setReturnValue(isNotHoldingLovedItemInOffHand(p_234474_0_));
            } else {
                boolean flag = p_234474_0_.canAddToInventory(p_234474_1_);
                if (item == Items.GOLD_NUGGET) {
                    cir.setReturnValue(flag);
                } else if (isFood(item)) {
                    cir.setReturnValue(!hasEatenRecently(p_234474_0_) && flag);
                } else if (!isLovedItem(item)) {
                    cir.setReturnValue(p_234474_0_.canReplaceCurrentItem(p_234474_1_));
                } else {
                    cir.setReturnValue(isNotHoldingLovedItemInOffHand(p_234474_0_) && flag);
                }
            }
        }

    }
    @Inject(at = @At(value = "HEAD"), method = "canAdmire(Lnet/minecraft/entity/monster/piglin/PiglinEntity;Lnet/minecraft/item/ItemStack;)Z", cancellable = true)
    private static void canAdmire(PiglinEntity p_234489_0_, ItemStack p_234489_1_, CallbackInfoReturnable<Boolean> info) {
        info.cancel();
        if(p_234489_0_ instanceof VampirePiglinEntity){
            info.setReturnValue(!isAdmiringDisabled(p_234489_0_) && !isAdmiringItem(p_234489_0_) && p_234489_0_.isAdult() && p_234489_1_.getItem()== ItemInit.BLOODSTONE_INGOT.get());
        }else {
            info.setReturnValue(!isAdmiringDisabled(p_234489_0_) && !isAdmiringItem(p_234489_0_) && p_234489_0_.isAdult() && p_234489_1_.isPiglinCurrency());
        }

    }
    /* Help methods from class */
    private static Predicate<PlayerEntity> getPlayersWithoutVamipreArmor() {
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
    private static List<ItemStack> getBarterResponseItems(PiglinEntity p_234524_0_) {
        LootTable loottable = p_234524_0_.level.getServer().getLootTables().get(LootTables.PIGLIN_BARTERING);
        return loottable.getRandomItems((new LootContext.Builder((ServerWorld)p_234524_0_.level)).withParameter(LootParameters.THIS_ENTITY, p_234524_0_).withRandom(p_234524_0_.level.random).create(LootParameterSets.PIGLIN_BARTER));
    }
    private static void throwItems(PiglinEntity p_234475_0_, List<ItemStack> p_234475_1_) {
        Optional<PlayerEntity> optional = p_234475_0_.getBrain().getMemory(MemoryModuleType.NEAREST_VISIBLE_PLAYER);
        if (optional.isPresent()) {
            throwItemsTowardPlayer(p_234475_0_, optional.get(), p_234475_1_);
        } else {
            throwItemsTowardRandomPos(p_234475_0_, p_234475_1_);
        }

    }
    private static void throwItemsTowardPlayer(PiglinEntity p_234472_0_, PlayerEntity p_234472_1_, List<ItemStack> p_234472_2_) {
        throwItemsTowardPos(p_234472_0_, p_234472_2_, p_234472_1_.position());
    }
    private static boolean isAttackAllowed(LivingEntity p_234506_0_) {
        return EntityPredicates.ATTACK_ALLOWED.test(p_234506_0_);
    }
    private static boolean playerInVamparickArmore(PlayerEntity entity) {
        Iterable<ItemStack> stackIterable = entity.getArmorSlots();
        List<ItemStack> armor_list = Lists.newArrayList(stackIterable);
        return armor_list.get(3).getItem().equals(ItemInit.vampiric_helmet.get()) && armor_list.get(2).getItem().equals(ItemInit.vampiric_chestplate.get()) &&
                armor_list.get(1).getItem().equals(ItemInit.vampiric_leggings.get()) && armor_list.get(0).getItem().equals(ItemInit.vampiric_boots.get());
    }
    private static boolean isAdmiringDisabled(PiglinEntity p_234453_0_) {
        return p_234453_0_.getBrain().hasMemoryValue(MemoryModuleType.ADMIRING_DISABLED);
    }
    private static boolean isAdmiringItem(PiglinEntity p_234451_0_) {
        return p_234451_0_.getBrain().hasMemoryValue(MemoryModuleType.ADMIRING_ITEM);
    }
    private static boolean isNotHoldingLovedItemInOffHand(PiglinEntity p_234455_0_) {
        return p_234455_0_.getOffhandItem().isEmpty() || p_234455_0_.getOffhandItem().getItem() != ItemInit.BLOODSTONE_INGOT.get();
    }
    private static boolean hasEatenRecently(PiglinEntity p_234538_0_) {
        return p_234538_0_.getBrain().hasMemoryValue(MemoryModuleType.ATE_RECENTLY);
    }
    private static boolean isFood(Item p_234499_0_) {
        return FOOD_ITEMS.contains(p_234499_0_);
    }
    @Shadow()
    protected static boolean isLovedItem(Item p_234480_0_) {
        return p_234480_0_.is(ItemTags.PIGLIN_LOVED);
    }

    private static void stopWalking(PiglinEntity p_234531_0_) {
        p_234531_0_.getBrain().eraseMemory(MemoryModuleType.WALK_TARGET);
        p_234531_0_.getNavigation().stop();
    }
    private static ItemStack removeOneItemFromItemEntity(ItemEntity p_234465_0_) {
        ItemStack itemstack = p_234465_0_.getItem();
        ItemStack itemstack1 = itemstack.split(1);
        if (itemstack.isEmpty()) {
            p_234465_0_.remove();
        } else {
            p_234465_0_.setItem(itemstack);
        }

        return itemstack1;
    }
    private static void eat(PiglinEntity p_234536_0_) {
        p_234536_0_.getBrain().setMemoryWithExpiry(MemoryModuleType.ATE_RECENTLY, true, 200L);
    }
    private static void putInInventory(PiglinEntity p_234498_0_, ItemStack p_234498_1_) {
        ItemStack itemstack = p_234498_0_.addToInventory(p_234498_1_);
        throwItemsTowardRandomPos(p_234498_0_, Collections.singletonList(itemstack));
    }
    private static void admireGoldItem(LivingEntity p_234501_0_) {
        p_234501_0_.getBrain().setMemoryWithExpiry(MemoryModuleType.ADMIRING_ITEM, true, 120L);
    }
    private static void throwItemsTowardRandomPos(PiglinEntity p_234490_0_, List<ItemStack> p_234490_1_) {
        throwItemsTowardPos(p_234490_0_, p_234490_1_, getRandomNearbyPos(p_234490_0_));
    }
    private static Vector3d getRandomNearbyPos(PiglinEntity p_234537_0_) {
        Vector3d vector3d = RandomPositionGenerator.getLandPos(p_234537_0_, 4, 2);
        return vector3d == null ? p_234537_0_.position() : vector3d;
    }
    private static void throwItemsTowardPos(PiglinEntity p_234476_0_, List<ItemStack> p_234476_1_, Vector3d p_234476_2_) {
        if (!p_234476_1_.isEmpty()) {
            p_234476_0_.swing(Hand.OFF_HAND);

            for(ItemStack itemstack : p_234476_1_) {
                BrainUtil.throwItem(p_234476_0_, itemstack, p_234476_2_.add(0.0D, 1.0D, 0.0D));
            }
        }

    }
    private static boolean isHoldingItemInOffHand(PiglinEntity p_234454_0_) {
        return !p_234454_0_.getOffhandItem().isEmpty();
    }
    private static void holdInOffhand(PiglinEntity p_241427_0_, ItemStack p_241427_1_) {
        if (isHoldingItemInOffHand(p_241427_0_)) {
            p_241427_0_.spawnAtLocation(p_241427_0_.getItemInHand(Hand.OFF_HAND));
        }

        p_241427_0_.holdInOffHand(p_241427_1_);
    }

}