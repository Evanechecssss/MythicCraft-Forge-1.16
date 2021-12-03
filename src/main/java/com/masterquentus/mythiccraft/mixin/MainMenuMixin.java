package com.masterquentus.mythiccraft.mixin;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.MainMenuScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * \* User: Evanechecssss
 * \* https://bio.link/evanechecssss
 * \* Data: 14.11.2021
 * \* Description:
 * \
 */
@Mixin(MainMenuScreen.class)
public abstract class MainMenuMixin {
    @Inject(at = @At(value = "HEAD"), method = "render(Lcom/mojang/blaze3d/matrix/MatrixStack;IIF)V")
    public void render(MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_, CallbackInfo info) {

    }

}