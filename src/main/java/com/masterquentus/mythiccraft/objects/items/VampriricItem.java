package com.masterquentus.mythiccraft.objects.items;

import java.util.List;
import java.util.Objects;

import com.masterquentus.mythiccraft.util.helpers.KeybordHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class VampriricItem extends Item implements ICurioItem {

	public VampriricItem(Properties properties) {
		super(properties);
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return true;
	}

	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (KeybordHelper.isHoldingShift()) {
			tooltip.add(new StringTextComponent("Right Click To get Night vision, Invisibility, and Bad Omen "));
		} else {
			tooltip.add(new StringTextComponent("Hold SHIFT for more information"));
		}

		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (!playerIn.getCooldowns().isOnCooldown(this)) {
			playerIn.addEffect(new EffectInstance(Effects.NIGHT_VISION, 6000, 2555));
			playerIn.addEffect(new EffectInstance(Effects.INVISIBILITY, 5000, 1555));
			playerIn.addEffect(new EffectInstance(Effects.BAD_OMEN, 10000, 10000));
			playerIn.getCooldowns().addCooldown(this, 800);
			return ActionResult.success(playerIn.getItemInHand(handIn));
		}

		return ActionResult.fail(playerIn.getItemInHand(handIn));
	}

	@Override
	public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack) {
		PlayerEntity player = (PlayerEntity) livingEntity;

		if (!player.level.isClientSide()) {
			boolean hasPlayerFireResistance = !Objects.equals(player.getEffect(Effects.FIRE_RESISTANCE), null);

			if (!hasPlayerFireResistance) {
				player.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 200));

				if (random.nextFloat() > 0.6f) {
					stack.hurtAndBreak(1, player, p -> CuriosApi.getCuriosHelper()
							.onBrokenCurio(SlotTypePreset.RING.getIdentifier(), index, p));
				}
			}

		}

		ICurioItem.super.curioTick(identifier, index, livingEntity, stack);
	}
}
