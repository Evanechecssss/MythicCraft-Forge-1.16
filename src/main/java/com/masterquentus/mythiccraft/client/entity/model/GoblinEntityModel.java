package com.masterquentus.mythiccraft.client.entity.model;

import com.masterquentus.mythiccraft.entities.GoblinEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GoblinEntityModel extends EntityModel<GoblinEntity> {
	private final ModelRenderer clothes;
	private final ModelRenderer bone;
	private final ModelRenderer left_ear2;
	private final ModelRenderer left_ear3;
	private final ModelRenderer left_arm_clothes;
	private final ModelRenderer right_arm_clothes;
	private final ModelRenderer left_leg;
	private final ModelRenderer right_leg;

	public GoblinEntityModel() {
		// textureWidth = 128;
		// textureHeight = 128;

		clothes = new ModelRenderer(this);
		clothes.setPos(0.0F, 24.0F, 0.0F);
		clothes.texOffs(73, 38).addBox(-2.0F, -20.0F, -5.0F, 8.0F, 5.0F, 1.0F, 0.0F, false);
		clothes.texOffs(48, 0).addBox(-6.0F, -15.0F, -5.0F, 12.0F, 4.0F, 1.0F, 0.0F, false);
		clothes.texOffs(74, 26).addBox(-7.0F, -11.0F, -4.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		clothes.texOffs(0, 10).addBox(-7.0F, -10.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		clothes.texOffs(52, 75).addBox(6.0F, -12.0F, -5.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		clothes.texOffs(42, 57).addBox(6.0F, -11.0F, -5.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		clothes.texOffs(9, 0).addBox(6.0F, -10.0F, -5.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		clothes.texOffs(0, 10).addBox(6.0F, -8.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		clothes.texOffs(7, 10).addBox(-7.0F, -9.0F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		clothes.texOffs(51, 33).addBox(-7.0F, -8.0F, 2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		clothes.texOffs(48, 8).addBox(-6.0F, -15.0F, 2.0F, 12.0F, 2.0F, 1.0F, 0.0F, false);
		clothes.texOffs(30, 34).addBox(-6.0F, -13.0F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(48, 14).addBox(-6.0F, -12.0F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(48, 57).addBox(-6.0F, -11.0F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(0, 36).addBox(-6.0F, -10.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(12, 12).addBox(-6.0F, -9.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(60, 39).addBox(-7.0F, -15.0F, -5.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		clothes.texOffs(70, 70).addBox(-7.0F, -13.0F, -5.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		clothes.texOffs(66, 17).addBox(-3.0F, -23.0F, 2.0F, 9.0F, 8.0F, 1.0F, 0.0F, false);
		clothes.texOffs(60, 39).addBox(-6.0F, -21.0F, 2.0F, 3.0F, 6.0F, 1.0F, 0.0F, false);
		clothes.texOffs(0, 0).addBox(-5.0F, -18.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		clothes.texOffs(36, 38).addBox(-6.0F, -16.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(24, 55).addBox(-4.0F, -19.0F, -5.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		clothes.texOffs(9, 4).addBox(6.0F, -23.0F, -5.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		clothes.texOffs(9, 4).addBox(2.0F, -25.0F, 2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		clothes.texOffs(0, 32).addBox(6.0F, -21.0F, 2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		clothes.texOffs(7, 13).addBox(8.0F, -23.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(0, 53).addBox(5.0F, -26.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(30, 36).addBox(-2.0F, -24.0F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(7, 13).addBox(-5.0F, -22.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(7, 13).addBox(1.0F, -21.0F, -5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(9, 4).addBox(4.0F, -24.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		clothes.texOffs(0, 32).addBox(5.0F, -26.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		clothes.texOffs(11, 10).addBox(6.0F, -19.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(7, 13).addBox(8.0F, -21.0F, -5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(0, 53).addBox(10.0F, -23.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		clothes.texOffs(81, 47).addBox(3.0F, -22.0F, -5.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		clothes.texOffs(30, 32).addBox(-3.0F, -11.0F, -5.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(18, 53).addBox(0.0F, -10.0F, -5.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(30, 36).addBox(2.0F, -9.0F, -5.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(7, 13).addBox(4.0F, -8.0F, -5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		clothes.texOffs(84, 8).addBox(4.0F, -25.0F, 2.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		clothes.texOffs(66, 6).addBox(6.0F, -15.0F, -5.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		clothes.texOffs(40, 70).addBox(6.0F, -14.0F, -5.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setPos(0.0F, 24.0F, 0.0F);
		bone.texOffs(0, 0).addBox(-8.0F, -42.0F, -9.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
		bone.texOffs(0, 32).addBox(-6.0F, -26.0F, -4.0F, 12.0F, 11.0F, 6.0F, 0.0F, false);

		left_ear2 = new ModelRenderer(this);
		left_ear2.setPos(8.5F, -8.8571F, -1.2857F);
		left_ear2.texOffs(85, 54).addBox(-0.5F, 1.8571F, -7.7143F, 1.0F, 4.0F, 3.0F, 0.0F, false);
		left_ear2.texOffs(83, 21).addBox(-0.5F, -3.1429F, -6.7143F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		left_ear2.texOffs(46, 82).addBox(-0.5F, -5.1429F, -3.7143F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		left_ear2.texOffs(10, 74).addBox(-0.5F, -7.1429F, 4.2857F, 1.0F, 11.0F, 4.0F, 0.0F, false);
		left_ear2.texOffs(80, 65).addBox(-0.5F, 2.8571F, 1.2857F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		left_ear2.texOffs(80, 80).addBox(-0.5F, 3.8571F, -3.7143F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		left_ear2.texOffs(72, 47).addBox(-0.5F, -8.1429F, -0.7143F, 1.0F, 3.0F, 7.0F, 0.0F, false);

		left_ear3 = new ModelRenderer(this);
		left_ear3.setPos(-8.5F, -8.8571F, -1.2857F);
		left_ear3.texOffs(58, 85).addBox(-0.5F, 1.8571F, -7.7143F, 1.0F, 4.0F, 3.0F, 0.0F, false);
		left_ear3.texOffs(68, 80).addBox(-0.5F, -3.1429F, -6.7143F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		left_ear3.texOffs(34, 80).addBox(-0.5F, -5.1429F, -3.7143F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		left_ear3.texOffs(0, 74).addBox(-0.5F, -7.1429F, 4.2857F, 1.0F, 11.0F, 4.0F, 0.0F, false);
		left_ear3.texOffs(78, 57).addBox(-0.5F, 2.8571F, 1.2857F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		left_ear3.texOffs(61, 77).addBox(-0.5F, 3.8571F, -3.7143F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		left_ear3.texOffs(0, 0).addBox(-0.5F, -8.1429F, -0.7143F, 1.0F, 3.0F, 7.0F, 0.0F, false);

		left_arm_clothes = new ModelRenderer(this);
		left_arm_clothes.setPos(6.0F, -5.5F, -1.0F);
		left_arm_clothes.texOffs(0, 53).addBox(0.0F, 3.5F, -3.0F, 6.0F, 11.0F, 6.0F, 0.0F, false);
		left_arm_clothes.texOffs(56, 24).addBox(6.0F, 3.5F, -4.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		left_arm_clothes.texOffs(76, 0).addBox(0.0F, 3.5F, 3.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		left_arm_clothes.texOffs(20, 78).addBox(0.0F, 3.5F, -4.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		right_arm_clothes = new ModelRenderer(this);
		right_arm_clothes.setPos(-6.0F, -5.5F, -1.0F);
		right_arm_clothes.texOffs(36, 36).addBox(-6.0F, 3.5F, -3.0F, 6.0F, 11.0F, 6.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setPos(3.0F, 9.5F, -1.0F);
		left_leg.texOffs(54, 54).addBox(-3.0F, -0.5F, -3.0F, 6.0F, 12.0F, 6.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setPos(-3.0F, 9.5F, -1.0F);
		right_leg.texOffs(24, 57).addBox(-3.0F, -0.5F, -3.0F, 6.0F, 12.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(GoblinEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		clothes.render(matrixStack, buffer, packedLight, packedOverlay);
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		left_ear2.render(matrixStack, buffer, packedLight, packedOverlay);
		left_ear3.render(matrixStack, buffer, packedLight, packedOverlay);
		left_arm_clothes.render(matrixStack, buffer, packedLight, packedOverlay);
		right_arm_clothes.render(matrixStack, buffer, packedLight, packedOverlay);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}