package com.masterquentus.mythiccraft.entities.boats;


import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

public class ModBoatEntity extends BoatEntity {
	private static final DataParameter<String> WOOD_TYPE
			= EntityDataManager.defineId(ModBoatEntity.class, DataSerializers.STRING);

	public ModBoatEntity(EntityType<? extends BoatEntity> type, World world) {
		super(type, world);
		this.blocksBuilding = true;
	}

	public ModBoatEntity(World p_i1705_1_, double p_i1705_2_, double p_i1705_4_, double p_i1705_6_) {
		this(EntityType.BOAT, p_i1705_1_);
		this.setPos(p_i1705_2_, p_i1705_4_, p_i1705_6_);
		this.setDeltaMovement(Vector3d.ZERO);
		this.xo = p_i1705_2_;
		this.yo = p_i1705_4_;
		this.zo = p_i1705_6_;
	}

	protected void registerData() {
		super.defineSynchedData();
		this.entityData.set(WOOD_TYPE, "redwood");
	}

	protected void readAdditional(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		compound.putString("Type", this.getWoodType());
	}
	protected void writeAdditional(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		compound.putString("Type", this.getWoodType());
	}

	public String getWoodType() {
		return this.entityData.get(WOOD_TYPE);
	}

	public void setWoodType(String wood) {
		this.entityData.set(WOOD_TYPE, wood);
	}

	public Item getItemBoat() {
		switch(this.getWoodType()) {
			case "redwood":
				return ItemInit.BLOODOAK_BOAT.get();
			default:
				return ItemInit.BLOODOAK_BOAT.get();
		}
	}

	@Override
	public ItemStack getPickedResult(RayTraceResult target) {
		return new ItemStack(ForgeRegistries.ITEMS.getValue(
				new ResourceLocation(MythicCraft.MOD_ID, this.getWoodType() + "_boat")));
	}

	@Nonnull
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}