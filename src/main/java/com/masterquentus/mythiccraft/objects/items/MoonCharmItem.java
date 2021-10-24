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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class MoonCharmItem extends Item implements ICurioItem {

	public MoonCharmItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (KeybordHelper.isHoldingShift()) {
			tooltip.add(new StringTextComponent("This Will Help Control Your Beast"));
		} else {
			tooltip.add(new StringTextComponent("Hold SHIFT for more information"));
		}

		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}

@Override
public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack) {
	PlayerEntity player = (PlayerEntity) livingEntity;

	if (!player.level.isClientSide()) {
		boolean hasPlayerNightVision = !Objects.equals(player.getEffect(Effects.NIGHT_VISION), null);

		if (!hasPlayerNightVision) {
			player.addEffect(new EffectInstance(Effects.NIGHT_VISION, 200));

			if (random.nextFloat() > 0.6f) {
				stack.hurtAndBreak(1, player, p -> CuriosApi.getCuriosHelper()
						.onBrokenCurio(SlotTypePreset.CHARM.getIdentifier(), index, p));
			}
		}

	}

	ICurioItem.super.curioTick(identifier, index, livingEntity, stack);
}
}
