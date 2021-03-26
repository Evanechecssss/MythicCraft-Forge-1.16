package com.masterquentus.mythiccraft.client.entity.model;

import com.masterquentus.mythiccraft.entities.UnicornEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class UnicornEntityModel extends EntityModel<UnicornEntity> {
	private final ModelRenderer Body;
	private final ModelRenderer TailA;
	private final ModelRenderer RightBackLeg;
	private final ModelRenderer LeftBackLeg;
	private final ModelRenderer RightFrontLeg;
	private final ModelRenderer LeftFrontLeg;
	private final ModelRenderer NeckHead;
	private final ModelRenderer Neck;
	private final ModelRenderer Mane;
	private final ModelRenderer Head;
	private final ModelRenderer UMouth;
	private final ModelRenderer Ear1;
	private final ModelRenderer Ear2;
	private final ModelRenderer ears;

	public UnicornEntityModel() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 11.0F, 9.0F);
		Body.setTextureOffset(0, 0).addBox(-5.0F, -8.0F, -20.0F, 10.0F, 10.0F, 22.0F, 0.0F, false);

		TailA = new ModelRenderer(this);
		TailA.setRotationPoint(0.0F, 4.0F, 11.0F);
		setRotationAngle(TailA, 0.5236F, 0.0F, 0.0F);
		TailA.setTextureOffset(26, 32).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 14.0F, 4.0F, 0.0F, false);

		RightBackLeg = new ModelRenderer(this);
		RightBackLeg.setRotationPoint(-3.0F, 13.0F, 9.0F);
		RightBackLeg.setTextureOffset(40, 40).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, true);
		RightBackLeg.setTextureOffset(0, 30).addBox(0.0F, 4.0F, 1.0F, 0.0F, 5.0F, 2.0F, 0.0F, true);

		LeftBackLeg = new ModelRenderer(this);
		LeftBackLeg.setRotationPoint(3.0F, 13.0F, 9.0F);
		LeftBackLeg.setTextureOffset(40, 40).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);
		LeftBackLeg.setTextureOffset(0, 30).addBox(0.0F, 4.0F, 1.0F, 0.0F, 5.0F, 2.0F, 0.0F, false);

		RightFrontLeg = new ModelRenderer(this);
		RightFrontLeg.setRotationPoint(-3.0F, 13.0F, -9.0F);
		RightFrontLeg.setTextureOffset(40, 40).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 11.0F, 4.0F, 0.0F, true);
		RightFrontLeg.setTextureOffset(0, 30).addBox(0.0F, 5.0F, 3.0F, 0.0F, 5.0F, 2.0F, 0.0F, true);

		LeftFrontLeg = new ModelRenderer(this);
		LeftFrontLeg.setRotationPoint(3.0F, 13.0F, -9.0F);
		LeftFrontLeg.setTextureOffset(40, 40).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);
		LeftFrontLeg.setTextureOffset(0, 30).addBox(0.0F, 5.0F, 3.0F, 0.0F, 5.0F, 2.0F, 0.0F, false);

		NeckHead = new ModelRenderer(this);
		NeckHead.setRotationPoint(0.0F, 7.0F, -9.0F);
		setRotationAngle(NeckHead, -0.3927F, 0.0F, 0.0F);
		

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		NeckHead.addChild(Neck);
		setRotationAngle(Neck, 0.5236F, 0.0F, 0.0F);
		Neck.setTextureOffset(0, 0).addBox(-2.0F, -11.0F, -3.0F, 4.0F, 12.0F, 7.0F, 0.0F, false);

		Mane = new ModelRenderer(this);
		Mane.setRotationPoint(0.0F, 0.0F, 0.0F);
		NeckHead.addChild(Mane);
		setRotationAngle(Mane, 0.5236F, 0.0F, 0.0F);
		Mane.setTextureOffset(0, 44).addBox(-0.5F, -16.0F, 3.0F, 2.0F, 16.0F, 2.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -11.0F, -3.0F);
		NeckHead.addChild(Head);
		setRotationAngle(Head, 0.5236F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 32).addBox(-3.0F, -5.0F, -6.0F, 6.0F, 5.0F, 7.0F, 0.0F, false);
		Head.setTextureOffset(42, 10).addBox(-1.0F, -10.0F, -4.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		UMouth = new ModelRenderer(this);
		UMouth.setRotationPoint(0.0F, -11.0F, -3.0F);
		NeckHead.addChild(UMouth);
		setRotationAngle(UMouth, 0.5236F, 0.0F, 0.0F);
		UMouth.setTextureOffset(42, 0).addBox(-2.0F, -5.0F, -11.0F, 4.0F, 5.0F, 5.0F, 0.0F, false);

		Ear1 = new ModelRenderer(this);
		Ear1.setRotationPoint(0.0F, 0.0F, 0.0F);
		NeckHead.addChild(Ear1);
		setRotationAngle(Ear1, 0.5236F, 0.0F, 0.0873F);
		Ear1.setTextureOffset(0, 0).addBox(-0.5F, -18.0F, 2.99F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		Ear2 = new ModelRenderer(this);
		Ear2.setRotationPoint(0.0F, 0.0F, 0.0F);
		NeckHead.addChild(Ear2);
		setRotationAngle(Ear2, 0.5236F, 0.0F, -0.0873F);
		Ear2.setTextureOffset(0, 0).addBox(-1.5F, -18.0F, 2.99F, 2.0F, 3.0F, 1.0F, 0.0F, true);

		ears = new ModelRenderer(this);
		ears.setRotationPoint(0.0F, 24.0F, 0.0F);
		
	}

	@Override
	public void setRotationAngles(UnicornEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		TailA.render(matrixStack, buffer, packedLight, packedOverlay);
		RightBackLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftBackLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		RightFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		NeckHead.render(matrixStack, buffer, packedLight, packedOverlay);
		ears.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}