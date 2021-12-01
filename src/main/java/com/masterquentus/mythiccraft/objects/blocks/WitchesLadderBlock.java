package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.init.BlockInit;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.WeepingVinesBlock;

public class WitchesLadderBlock extends WeepingVinesBlock {
    public WitchesLadderBlock(Properties p_i241195_1_) {
        super(p_i241195_1_);
    }
    protected AbstractTopPlantBlock getHeadBlock() {
        return (AbstractTopPlantBlock) BlockInit.WITCHES_LADDER_TOP.get();
    }
}