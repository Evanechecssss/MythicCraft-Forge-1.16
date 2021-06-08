package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.init.auto.LanternType;
import com.masterquentus.mythiccraft.tileentity.LanternTileEntity;
import com.masterquentus.mythiccraft.util.helpers.KeybordHelper;
import net.minecraft.block.*;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ModLanternBlock extends LanternBlock {
    public final LanternType type;
    public ModLanternBlock(LanternType type) {
        super(Block.Properties.copy(Blocks.LANTERN).strength(0.3f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> 15));
        this.type = type;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable IBlockReader world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        if (KeybordHelper.isHoldingShift()){
            tooltip.add(new StringTextComponent(this.type.description));
        } else {
            tooltip.add(new StringTextComponent("Hold SHIFT for more information"));
        }
        super.appendHoverText(stack, world, tooltip, flag);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new LanternTileEntity();
    }
}
