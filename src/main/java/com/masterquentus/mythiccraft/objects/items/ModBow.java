package com.masterquentus.mythiccraft.objects.items;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class ModBow extends BowItem {
    public ModBow(Properties builder) {
        super(builder);
    }

    @Override
    public void releaseUsing(ItemStack bowStack, World world, LivingEntity entity, int timeLeft) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity shooter = (PlayerEntity)entity;
            boolean hasInfinity = shooter.isCreative() || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, bowStack) > 0;
            ItemStack ammoStack = shooter.getProjectile(bowStack);

            int timeDrawn = this.getUseDuration(bowStack) - timeLeft;
            timeDrawn = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(bowStack, world, shooter, timeDrawn, !ammoStack.isEmpty() || hasInfinity);
            if (timeDrawn < 0) return;

            if (!ammoStack.isEmpty() || hasInfinity) {
                boolean isTippedArrow = ammoStack.getItem() == Items.SPECTRAL_ARROW || ammoStack.getItem() == Items.TIPPED_ARROW;

                if (ammoStack.isEmpty()) {
                    ammoStack = new ItemStack(Items.ARROW);
                }

                float velocity = getPowerForTime(timeDrawn);
                if (!((double)velocity < 0.1D)) {
                    if (!world.isClientSide()) {
                        AbstractArrowEntity arrowEntity = createArrow(world, ammoStack, shooter);

                        arrowEntity.shootFromRotation(shooter, shooter.xRot, shooter.yRot, 0.0F, velocity * 3.0F, 1.0F);

                        if (velocity == 1.0F) arrowEntity.setCritArrow(true);

                        double damage = getArrowBaseDamage(bowStack, arrowEntity);
                        arrowEntity.setBaseDamage(damage);

                        int knockback = getArrowKnockback(bowStack, arrowEntity);
                        arrowEntity.setKnockback(knockback);

                        // apply flame enchant
                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, bowStack) > 0) {
                            arrowEntity.setSecondsOnFire(100);
                        }

                        // reduce bow durability
                        bowStack.hurtAndBreak(1, shooter, (player) -> {
                            player.broadcastBreakEvent(shooter.getUsedItemHand());
                        });

                        // set if arrow can be picked up from ground
                        if (hasInfinity && !isTippedArrow) {
                            arrowEntity.pickup = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                        }

                        // actually make the arrow entity exist in the world
                        world.addFreshEntity(arrowEntity);
                    }

                    // sound
                    float pitch = 1.0F / (random.nextFloat() * 0.4F + 1.2F) + velocity * 0.5F;
                    world.playSound((PlayerEntity)null, shooter.getX(), shooter.getY(), shooter.getZ(), SoundEvents.ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, pitch);

                    // use an arrow
                    boolean shouldConsumeArrow = !hasInfinity || isTippedArrow;
                    if (shouldConsumeArrow) {
                        ammoStack.shrink(1);
                        if (ammoStack.isEmpty()) {
                            shooter.inventory.removeItem(ammoStack);
                        }
                    }

                    shooter.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    // override to use a custom arrow entity
    protected AbstractArrowEntity createArrow(World worldIn, ItemStack ammoStack, PlayerEntity playerentity) {
        ArrowItem arrowitem = (ArrowItem)(ammoStack.getItem() instanceof ArrowItem ? ammoStack.getItem() : Items.ARROW);
        return arrowitem.createArrow(worldIn, ammoStack, playerentity);
    }

    protected double getArrowBaseDamage(ItemStack bowStack, AbstractArrowEntity arrowEntity) {
        int powerLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, bowStack);

        if (powerLevel > 0) return arrowEntity.getBaseDamage() + (double)powerLevel * 0.5D + 0.5D;
        else return arrowEntity.getBaseDamage();
    }

    protected int getArrowKnockback(ItemStack bowStack, AbstractArrowEntity arrowEntity) {
        return EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, bowStack);
    }

    // Override to change what it uses as ammo
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return (ammoStack) -> {
            return ammoStack.getItem().is(ItemTags.ARROWS);
        };
    }
}
