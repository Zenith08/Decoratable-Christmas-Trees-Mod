package me.kk47.dct.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDecorationB extends ModelBase
{
  //fields
    ModelRenderer ornament;
    ModelRenderer Shape56;
    ModelRenderer Shape57;
    ModelRenderer Shape58;
    ModelRenderer Shape61;
    ModelRenderer Shape62;
    ModelRenderer Shape64;
    ModelRenderer Shape65;
    ModelRenderer Shape67;
    ModelRenderer Shape71;
    ModelRenderer Shape73;
    ModelRenderer Shape74;
  
  public ModelDecorationB()
  {
    textureWidth = 16;
    textureHeight = 16;
    
      ornament = new ModelRenderer(this, 0, 0);
      ornament.addBox(0F, 0F, 0F, 1, 1, 1);
      ornament.setRotationPoint(-6.5F, 4F, 1.933333F);
      ornament.setTextureSize(16, 16);
      ornament.mirror = true;
      setRotation(ornament, 0F, -0.1858931F, 0.5576792F);
      Shape56 = new ModelRenderer(this, 0, 0);
      Shape56.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape56.setRotationPoint(-12F, 10F, 6.933333F);
      Shape56.setTextureSize(16, 16);
      Shape56.mirror = true;
      setRotation(Shape56, 0F, 0F, 0F);
      Shape57 = new ModelRenderer(this, 0, 0);
      Shape57.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape57.setRotationPoint(-11F, 10F, -1F);
      Shape57.setTextureSize(16, 16);
      Shape57.mirror = true;
      setRotation(Shape57, -0.8179294F, 0F, 0.5379539F);
      Shape58 = new ModelRenderer(this, 0, 0);
      Shape58.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape58.setRotationPoint(2.4F, 4F, 5.133333F);
      Shape58.setTextureSize(16, 16);
      Shape58.mirror = true;
      setRotation(Shape58, 0.5948578F, 0F, 0F);
      Shape61 = new ModelRenderer(this, 0, 0);
      Shape61.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape61.setRotationPoint(-5F, 6F, 7.266667F);
      Shape61.setTextureSize(16, 16);
      Shape61.mirror = true;
      setRotation(Shape61, 0.6320364F, 0F, 0F);
      Shape62 = new ModelRenderer(this, 0, 0);
      Shape62.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape62.setRotationPoint(-4F, 2F, 6.466667F);
      Shape62.setTextureSize(16, 16);
      Shape62.mirror = true;
      setRotation(Shape62, 0.2974289F, 0F, 0F);
      Shape64 = new ModelRenderer(this, 0, 0);
      Shape64.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape64.setRotationPoint(4.6F, -3.4F, 2F);
      Shape64.setTextureSize(16, 16);
      Shape64.mirror = true;
      setRotation(Shape64, 0F, -0.0371786F, -0.3717861F);
      Shape65 = new ModelRenderer(this, 0, 0);
      Shape65.addBox(0F, 0F, 0F, 1, 2, 2);
      Shape65.setRotationPoint(9.533334F, 9.8F, 4.866667F);
      Shape65.setTextureSize(16, 16);
      Shape65.mirror = true;
      setRotation(Shape65, 0F, -0.0371786F, -0.5576792F);
      Shape67 = new ModelRenderer(this, 0, 0);
      Shape67.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape67.setRotationPoint(8.4F, 8.466666F, 0F);
      Shape67.setTextureSize(16, 16);
      Shape67.mirror = true;
      setRotation(Shape67, 0F, 0F, 0F);
      Shape71 = new ModelRenderer(this, 0, 0);
      Shape71.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape71.setRotationPoint(-6.6F, 8.333333F, -11F);
      Shape71.setTextureSize(16, 16);
      Shape71.mirror = true;
      setRotation(Shape71, 0F, 0F, 0F);
      Shape73 = new ModelRenderer(this, 0, 0);
      Shape73.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape73.setRotationPoint(4.4F, 10.26667F, -11.26667F);
      Shape73.setTextureSize(16, 16);
      Shape73.mirror = true;
      setRotation(Shape73, -0.7807508F, -0.4833219F, -0.6320364F);
      Shape74 = new ModelRenderer(this, 0, 0);
      Shape74.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape74.setRotationPoint(-0.9333333F, 10.46667F, -10F);
      Shape74.setTextureSize(16, 16);
      Shape74.mirror = true;
      setRotation(Shape74, -0.7807508F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    ornament.render(f5);
    Shape56.render(f5);
    Shape57.render(f5);
    Shape58.render(f5);
    Shape61.render(f5);
    Shape62.render(f5);
    Shape64.render(f5);
    Shape65.render(f5);
    Shape67.render(f5);
    Shape71.render(f5);
    Shape73.render(f5);
    Shape74.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

}
