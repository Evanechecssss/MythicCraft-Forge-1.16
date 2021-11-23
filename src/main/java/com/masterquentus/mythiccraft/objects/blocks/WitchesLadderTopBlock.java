package com.masterquentus.mythiccraft.objects.blocks;

import com.masterquentus.mythiccraft.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.WeepingVinesTopBlock;

public class WitchesLadderTopBlock extends WeepingVinesTopBlock {
    public WitchesLadderTopBlock(Properties p_i241194_1_) {
        super(p_i241194_1_);
    }

    @Override
    protected Block getBodyBlock() {
        return BlockInit.WITCHES_LADDER_PLANT.get();
    }
 }