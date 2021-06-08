package com.masterquentus.mythiccraft.client.entity.render;

import com.masterquentus.mythiccraft.entities.MobSummonProjectile;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class MobSummonProjectileRenderer extends EntityRenderer<MobSummonProjectile> {
    public MobSummonProjectileRenderer(EntityRendererManager p_i46193_1_) {
        super(p_i46193_1_);
    }

    @Override
    public void render(MobSummonProjectile projectile, float yaw, float ticks, MatrixStack matrixStack, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
        matrixStack.pushPose();

        Entity entity = projectile.getOrCreateDisplayEntity();
        if (entity != null) {
            // spin around like in a mob spawner
            float spin = (projectile.level.getDayTime() + ticks) / 2;
            matrixStack.mulPose(Vector3f.YP.rotation(spin));

            // scale the entity so it fits in a small cube
            float f = 0.53125F;
            float f1 = Math.max(entity.getBbWidth(), entity.getBbHeight());
            if (f1 > 1.0D)  f /= f1;
            matrixStack.scale(f, f, f);

            // actually render it
            int lightColor = WorldRenderer.getLightColor(projectile.level, projectile.blockPosition());
            Minecraft.getInstance().getEntityRenderDispatcher().render(entity, 0.0D, 0.0D, 0.0D, 0.0F, ticks, matrixStack, p_225623_5_, lightColor);
        }

        matrixStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(MobSummonProjectile projectile) {
        return null;
    }
}

