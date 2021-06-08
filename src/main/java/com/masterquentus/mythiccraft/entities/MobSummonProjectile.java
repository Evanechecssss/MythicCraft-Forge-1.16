package com.masterquentus.mythiccraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;
import java.util.UUID;

public class MobSummonProjectile extends ThrowableEntity {
    private UUID targetID;

    public MobSummonProjectile(EntityType<? extends MobSummonProjectile> type, World world){
        super(type, world);
    }
    private static final DataParameter<String> TYPE = EntityDataManager.defineId(MobSummonProjectile.class, DataSerializers.STRING);

    protected void defineSynchedData() {
        this.getEntityData().define(TYPE, "minecraft:pig");
    }

    public void setPlayerTarget(PlayerEntity target){
        this.targetID = target.getUUID();
    }

    public PlayerEntity getPlayerTarget(){
        if (this.targetID == null) return null;
        return this.level.getPlayerByUUID(this.targetID);
    }

    @Nonnull
    public EntityType getHeldEntity() {
        String type = this.getEntityData().get(TYPE);
        return EntityType.byString(type).orElse(EntityType.PIG);
    }

    public void setHeldEntity(EntityType type){
        this.getEntityData().set(TYPE, EntityType.getKey(type).toString());
    }

    public void addAdditionalSaveData(CompoundNBT tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("summon", this.getEntityData().get(TYPE));
        tag.putUUID("target", this.targetID);
    }

    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("summon")) this.getEntityData().set(TYPE, tag.getString("summon"));
        if (tag.contains("target")) this.targetID = tag.getUUID("target");
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide() && this.getPlayerTarget() != null){
            Vector3d motion = this.getPlayerTarget().position().subtract(this.getPosition(0));
            this.setDeltaMovement(motion.normalize().scale(0.25D));
        }
    }

    @Override
    protected void onHit(RayTraceResult ray) {
        if (!this.level.isClientSide()){
            Entity summon = this.getHeldEntity().create(this.level);
            summon.setPos(ray.getLocation().x, ray.getLocation().y, ray.getLocation().z);
            this.level.addFreshEntity(summon);
        }

        this.remove();
    }

    @Override
    protected float getGravity() {
        return 0;
    }

    // cached for better performance
    // todo: null display on clientside when the heldEntity is changed
    Entity display;
    public Entity getOrCreateDisplayEntity() {
        if (this.display == null){
            this.display = this.getHeldEntity().create(this.level);
        }
        return this.display;
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
