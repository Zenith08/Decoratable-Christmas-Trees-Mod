package me.kk47.dct.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTopperPig extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
  
  public ModelTopperPig()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 22, 1);
      Shape1.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape1.setRotationPoint(-2F, -13F, -3F);
      Shape1.setTextureSize(32, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 22, 1);
      Shape2.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape2.setRotationPoint(1F, -13F, -3F);
      Shape2.setTextureSize(32, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 22, 1);
      Shape3.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape3.setRotationPoint(-2F, -13F, 2F);
      Shape3.setTextureSize(32, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 22, 1);
      Shape4.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape4.setRotationPoint(1F, -13F, 2F);
      Shape4.setTextureSize(32, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 8, 20);
      Shape5.addBox(0F, 0F, 0F, 4, 4, 8);
      Shape5.setRotationPoint(-2F, -17F, -4F);
      Shape5.setTextureSize(32, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 0);
      Shape6.addBox(0F, 0F, 0F, 3, 3, 3);
      Shape6.setRotationPoint(-1.466667F, -18F, 4F);
      Shape6.setTextureSize(32, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
}
