package me.kk47.dct.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCreeperTopper extends ModelBase{
	//fields
	ModelRenderer body;
	ModelRenderer upper_leg_4;
	ModelRenderer lower_leg_3;
	ModelRenderer head;
	ModelRenderer upper_leg_1;
	ModelRenderer lower_leg_1;
	ModelRenderer upper_leg_3;
	ModelRenderer lower_leg_4;
	ModelRenderer upper_leg_2;
	ModelRenderer lower_leg_2;

	public ModelCreeperTopper(){
		textureWidth = 128;
		textureHeight = 32;

		body = new ModelRenderer(this, 0, 2);
		body.addBox(0F, 0F, 0F, 2, 2, 3);
		body.setRotationPoint(-1F, -2F, -1.5F);
		body.setTextureSize(128, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		upper_leg_4 = new ModelRenderer(this, 0, 0);
		upper_leg_4.addBox(0F, 0F, 0F, 3, 1, 1);
		upper_leg_4.setRotationPoint(0F, -1F, 0F);
		upper_leg_4.setTextureSize(128, 32);
		upper_leg_4.mirror = true;
		setRotation(upper_leg_4, 0F, -0.669215F, 0.2230717F);
		lower_leg_3 = new ModelRenderer(this, 0, 0);
		lower_leg_3.addBox(0F, 0F, -1F, 2, 1, 1);
		lower_leg_3.setRotationPoint(1.5F, -0.5F, 2.5F);
		lower_leg_3.setTextureSize(128, 32);
		lower_leg_3.mirror = true;
		setRotation(lower_leg_3, 0F, -0.669215F, 1.003822F);
		head = new ModelRenderer(this, 0, 0);
		head.addBox(0F, 0F, 0F, 4, 2, 4);
		head.setRotationPoint(-2F, -4F, -2F);
		head.setTextureSize(128, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		upper_leg_1 = new ModelRenderer(this, 0, 0);
		upper_leg_1.addBox(0F, 0F, 0F, 2, 1, 1);
		upper_leg_1.setRotationPoint(0F, -1F, -1F);
		upper_leg_1.setTextureSize(128, 32);
		upper_leg_1.mirror = true;
		setRotation(upper_leg_1, 0F, 0.9294653F, 0.3346075F);
		lower_leg_1 = new ModelRenderer(this, 0, 0);
		lower_leg_1.addBox(0F, 0F, 0F, 2, 1, 1);
		lower_leg_1.setRotationPoint(1F, -0.5F, -2.5F);
		lower_leg_1.setTextureSize(128, 32);
		lower_leg_1.mirror = true;
		setRotation(lower_leg_1, 0F, 0.8179294F, 1.003822F);
		upper_leg_3 = new ModelRenderer(this, 0, 0);
		upper_leg_3.addBox(-2F, 0F, 0F, 2, 1, 1);
		upper_leg_3.setRotationPoint(-1F, -1F, 0.5F);
		upper_leg_3.setTextureSize(128, 32);
		upper_leg_3.mirror = true;
		setRotation(upper_leg_3, 0F, 0.7063936F, -0.1858931F);
		lower_leg_4 = new ModelRenderer(this, 0, 0);
		lower_leg_4.addBox(-2F, 0F, 0F, 2, 1, 1);
		lower_leg_4.setRotationPoint(-2.5F, -0.5F, 2F);
		lower_leg_4.setTextureSize(128, 32);
		lower_leg_4.mirror = true;
		setRotation(lower_leg_4, 0F, 0.7435722F, -1.115358F);
		upper_leg_2 = new ModelRenderer(this, 0, 0);
		upper_leg_2.addBox(0F, 0F, 0F, 2, 1, 1);
		upper_leg_2.setRotationPoint(-1F, -0.25F, -2.5F);
		upper_leg_2.setTextureSize(128, 32);
		upper_leg_2.mirror = true;
		setRotation(upper_leg_2, 0F, -0.8922867F, -0.2974289F);
		lower_leg_2 = new ModelRenderer(this, 0, 0);
		lower_leg_2.addBox(0F, 0F, 0F, 2, 1, 1);
		lower_leg_2.setRotationPoint(-2F, -0.25F, -2F);
		lower_leg_2.setTextureSize(128, 32);
		lower_leg_2.mirror = true;
		setRotation(lower_leg_2, 0F, 2.342252F, -0.9666439F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5){
		body.render(f5);
		upper_leg_4.render(f5);
		lower_leg_3.render(f5);
		head.render(f5);
		upper_leg_1.render(f5);
		lower_leg_1.render(f5);
		upper_leg_3.render(f5);
		lower_leg_4.render(f5);
		upper_leg_2.render(f5);
		lower_leg_2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z){
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
