package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.init.auto.LanternType;
import net.minecraft.block.*;

public class ModLanternBlock extends LanternBlock {
    public final LanternType type;
    public ModLanternBlock(LanternType type) {
        super(Block.Properties.copy(Blocks.LANTERN).strength(0.3f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> 15));
        this.type = type;
    }
}
