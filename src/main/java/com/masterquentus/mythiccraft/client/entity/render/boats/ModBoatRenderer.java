package com.masterquentus.mythiccraft.client.entity.render.boats;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.entities.boats.ModBoatEntity;
import com.masterquentus.mythiccraft.init.ItemInit;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.util.ResourceLocation;

/**
 * \* User: Evanechecssss
 * \* https://evanechecssss.github.io
 * \
 */
public class ModBoatRenderer extends BoatRenderer {
    public ModBoatRenderer(EntityRendererManager p_i46179_1_) {
        super(p_i46179_1_);
    }

    @Override
    public ResourceLocation getTextureLocation(BoatEntity entity) {
        
        switch(((ModBoatEntity) entity).getWoodType()) {
            default:
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/bloodoak.png");
            case "bloodoak":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/bloodoak.png");

            case "whiteoak":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/whiteoak.png");

            case "silverwood":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/silverwood.png");

            case "witchwood":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/witchwood.png");

            case "alder":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/alder.png");

            case "hawthorn":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/hawthorn.png");

            case "rowan":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/rowan.png");

            case "willow":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/willow.png");

            case "beech":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/beech.png");

            case "ash":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/ash.png");

            case "blackthorn":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/blackthorn.png");

            case "cedar":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/cedar.png");

            case "elder":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/elder.png");

            case "juniper":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/juniper.png");

            case "witchhazel":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/witchhazel.png");

            case "yew":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/yew.png");

            case "infested":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/infested.png");

            case "charred":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/charred.png");

            case "icy":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/icy.png");

            case "twisted":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/twisted.png");

            case "distorted":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/distorted.png");

            case "hellbark":
                return new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/hellbark.png");

        }
        
    }
}
