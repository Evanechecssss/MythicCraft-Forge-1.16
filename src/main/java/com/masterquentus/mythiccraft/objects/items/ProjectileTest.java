package com.masterquentus.mythiccraft.objects.items;

import com.masterquentus.mythiccraft.entities.MobSummonProjectile;
import com.masterquentus.mythiccraft.init.ModEntityTypes;
import com.masterquentus.mythiccraft.util.helpers.KeybordHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
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

import java.util.List;

public class ProjectileTest extends Item {

	public ProjectileTest(Properties properties)
	{
		super(properties);
	}

	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if(!worldIn.isClientSide()) {
			MobSummonProjectile projectile = new MobSummonProjectile(ModEntityTypes.MOB_SUMMON.get(), worldIn);
			projectile.setPos(playerIn.getX() + 5, playerIn.getY() + 1.5D, playerIn.getZ());
			projectile.setPlayerTarget(playerIn);
			projectile.setHeldEntity(EntityType.ZOMBIE);
			worldIn.addFreshEntity(projectile);
		}

		return ActionResult.success(playerIn.getItemInHand(handIn));
	}
}

