package com.masterquentus.mythiccraft.tileentity;

import com.masterquentus.mythiccraft.init.ModTileEntityTypes;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.util.Constants;

public class GrassperTileEntity extends TileEntity {
	ItemStack displayedItem = ItemStack.EMPTY;
	public GrassperTileEntity(final TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
	
	public GrassperTileEntity() {
		this(ModTileEntityTypes.GRASSPER.get());
	}

	@Override
	public void setChanged() {
		super.setChanged();
		this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(),
				Constants.BlockFlags.BLOCK_UPDATE);
	}

	// use from block
	public void setItem(ItemStack stack){
		this.displayedItem = stack;
		this.setChanged();
	}

	// for render
	public ItemStack getItem(){
		return this.displayedItem;
	}

	// saving data
	@Override
	public void load(BlockState state, CompoundNBT tag) {
		super.load(state, tag);
		this.displayedItem = tag.contains("held") ? ItemStack.of(tag.getCompound("held")) : ItemStack.EMPTY;
	}

	@Override
	public CompoundNBT save(CompoundNBT tag) {
		CompoundNBT held = new CompoundNBT();
		displayedItem.save(held);
		tag.put("held", held);
		return super.save(tag);
	}


	// block update
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		CompoundNBT nbt = new CompoundNBT();
		this.save(nbt);

		return new SUpdateTileEntityPacket(this.worldPosition, 1, nbt);
	}
	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		this.load(this.getBlockState(), pkt.getTag());
	}

	// chunk load
	@Override
	public CompoundNBT getUpdateTag() {
		return this.save(new CompoundNBT());
	}
	@Override
	public void handleUpdateTag(BlockState state, CompoundNBT tag) {
		this.load(state, tag);
	}
}