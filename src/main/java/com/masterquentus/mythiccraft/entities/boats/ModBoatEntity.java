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

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.set(WOOD_TYPE, "bloodoak");
	}

	@Override
	protected void readAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		compound.putString("Type", this.getWoodType());
	}
	@Override
	protected void addAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		compound.putString("Type", this.getWoodType());
	}

	public String getWoodType() {
		return this.entityData.get(WOOD_TYPE);
	}

	public void setWoodType(String wood) {
		this.entityData.set(WOOD_TYPE, wood);
	}

	@Override
	public Item getDropItem() {
		switch(this.getWoodType()) {
			default:
				return ItemInit.BLOODOAK_BOAT.get();
			case "bloodoak":
				return ItemInit.BLOODOAK_BOAT.get();
			case "whiteoak":
				return ItemInit.WHITEOAK_BOAT.get();
			case "silverwood":
				return ItemInit.SILVERWOOD_BOAT.get();
			case "witchwood":
				return ItemInit.WITCHWOOD_BOAT.get();
			case "alder":
				return ItemInit.ALDER_BOAT.get();
			case "hawthorn":
				return ItemInit.HAWTHORN_BOAT.get();
			case "rowan":
				return ItemInit.ROWAN_BOAT.get();
			case "willow":
				return ItemInit.WILLOW_BOAT.get();
			case "beech":
				return ItemInit.BEECH_BOAT.get();
			case "ash":
				return ItemInit.ASH_BOAT.get();
			case "blackthorn":
				return ItemInit.BLACKTHORN_BOAT.get();
			case "cedar":
				return ItemInit.CEDAR_BOAT.get();
			case "elder":
				return ItemInit.ELDER_BOAT.get();
			case "juniper":
				return ItemInit.JUNIPER_BOAT.get();
			case "witchhazel":
				return ItemInit.WITCHHAZEL_BOAT.get();
			case "yew":
				return ItemInit.YEW_BOAT.get();
			case "infested":
				return ItemInit.INFESTED_BOAT.get();
			case "charred":
				return ItemInit.CHARRED_BOAT.get();
			case "icy":
				return ItemInit.ICY_BOAT.get();
			case "twisted":
				return ItemInit.TWISTED_BOAT.get();
			case "distorted":
				return ItemInit.DISTORTED_BOAT.get();
			case "hellbark":
				return ItemInit.HELLBARK_BOAT.get();



		}
	}

	@Override
	public ItemStack getPickedResult(RayTraceResult target) {
		return new ItemStack(ForgeRegistries.ITEMS.getValue(
				new ResourceLocation(MythicCraft.MOD_ID, this.getWoodType() + "_boat")));
	}

	@Nonnull
	@Override
	public IPacket<?> getAddEntityPacket () {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}