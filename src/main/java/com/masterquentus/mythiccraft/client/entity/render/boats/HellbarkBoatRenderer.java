package com.masterquentus.mythiccraft.client.entity.render.boats;

import com.masterquentus.mythiccraft.MythicCraft;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.util.ResourceLocation;

public class HellbarkBoatRenderer extends BoatRenderer {
    private static final ResourceLocation BOAT_TEXTURE =
            new ResourceLocation(MythicCraft.MOD_ID, "textures/entity/boats/hellbark.png");

    public HellbarkBoatRenderer(EntityRendererManager p_i46179_1_) {
        super(p_i46179_1_);
    }

    public ResourceLocation getEntityTexture(BoatEntity entity) {
        return BOAT_TEXTURE;
    }
}
