package com.masterquentus.mythiccraft.tileentity;

import java.util.List;

import com.masterquentus.mythiccraft.init.ModTileEntityTypes;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class MobSlayerTileEntity extends TileEntity implements ITickableTileEntity {
    public MobSlayerTileEntity() {
        super(ModTileEntityTypes.MOB_SLAYER.get());
    }
    int timer = 0;
    boolean isActive = true;

    @Override
    public void tick() {
        if (!this.level.isClientSide() && this.isActive){
            this.timer++;
            if (this.timer > 20){
                this.timer = 0;
                
                this.hurtMobs();
            }
        }
    }
    	final int RANGE = 5;
    	private void hurtMobs() {
    	    BlockPos topCorner = this.worldPosition.offset(RANGE, RANGE, RANGE);
    	    BlockPos bottomCorner = this.worldPosition.offset(-RANGE, -RANGE, -RANGE);
    	    AxisAlignedBB box = new AxisAlignedBB(topCorner, bottomCorner);

    	    List<Entity> entities = this.level.getEntities(null, box);
    	    for (Entity target : entities){
    	        if (target instanceof LivingEntity && !(target instanceof PlayerEntity)){
    	            target.hurt(DamageSource.MAGIC, 2);
    	        }
    	    }
    	}
    	
    	public void toggle(){
    	    this.isActive = !this.isActive;
    	}
    
    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putBoolean("active", this.isActive);
        return super.save(nbt);
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        this.isActive = nbt.getBoolean("active");
    }
    
    @Override
    public SUpdateTileEntityPacket getUpdatePacket(){
        CompoundNBT nbtTag = new CompoundNBT();
        // save data to nbt 
        return new SUpdateTileEntityPacket(this.worldPosition, -1, nbtTag);
    
    }
}