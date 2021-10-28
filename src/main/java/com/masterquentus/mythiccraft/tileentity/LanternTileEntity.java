package com.masterquentus.mythiccraft.tileentity;

import com.masterquentus.mythiccraft.init.ModTileEntityTypes;
import com.masterquentus.mythiccraft.init.auto.LanternType;
import com.masterquentus.mythiccraft.objects.blocks.ModLanternBlock;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class LanternTileEntity extends TileEntity implements ITickableTileEntity {
    public LanternTileEntity() {
        super(ModTileEntityTypes.LANTERN_TILE.get());
    }

    @Override
    public void tick() {
    	 World world = this.level;
         if (world != null) {
             if (!world.isClientSide()) {
                 LanternType type = ((ModLanternBlock) this.getBlockState().getBlock()).type;
                 type.action.tick(this.worldPosition, this.level);
             }
        }
    }
}
