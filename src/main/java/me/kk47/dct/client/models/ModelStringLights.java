package me.kk47.dct.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStringLights extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
  
  public ModelStringLights()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 3, 1);
      Shape1.addBox(-20F, 0F, 0F, 19, 1, 1);
      Shape1.setRotationPoint(11F, 11F, 11F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0.1487144F);
      Shape2 = new ModelRenderer(this, 16, 0);
      Shape2.addBox(0F, 0F, -17F, 1, 1, 17);
      Shape2.setRotationPoint(-10F, 7F, 9F);
      Shape2.setTextureSize(64, 64);
      Shape2.mirror = true;
      setRotation(Shape2, -0.1115358F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(0F, 0F, 0F, 15, 1, 1);
      Shape3.setRotationPoint(-8F, 5F, -10F);
      Shape3.setTextureSize(64, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, -0.1115358F);
      Shape4 = new ModelRenderer(this, 5, 6);
      Shape4.addBox(0F, 0F, 0F, 1, 1, 12);
      Shape4.setRotationPoint(8F, 3F, -6F);
      Shape4.setTextureSize(64, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0.2602503F, -0.1115358F, 0F);
      Shape5 = new ModelRenderer(this, 25, 4);
      Shape5.addBox(-11F, 0F, 0F, 11, 1, 1);
      Shape5.setRotationPoint(6F, 0F, 7F);
      Shape5.setTextureSize(64, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0.1858931F);
      Shape6 = new ModelRenderer(this, 0, 0);
      Shape6.addBox(0F, 0F, -10F, 1, 1, 11);
      Shape6.setRotationPoint(-7F, -2F, 4F);
      Shape6.setTextureSize(64, 64);
      Shape6.mirror = true;
      setRotation(Shape6, -0.1115358F, -0.0743572F, 0.0743572F);
      Shape7 = new ModelRenderer(this, 0, 0);
      Shape7.addBox(0F, 0F, 0F, 10, 1, 1);
      Shape7.setRotationPoint(-6F, -3F, -6F);
      Shape7.setTextureSize(64, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, -0.2230717F);
      Shape8 = new ModelRenderer(this, 0, 0);
      Shape8.addBox(0F, 0F, 0F, 1, 1, 8);
      Shape8.setRotationPoint(4F, -5F, -4F);
      Shape8.setTextureSize(64, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0.2602503F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 4);
      Shape9.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape9.setRotationPoint(-9F, 7F, 8F);
      Shape9.setTextureSize(64, 64);
      Shape9.mirror = true;
      setRotation(Shape9, -0.0371786F, -1.226894F, 0.2974289F);
      Shape10 = new ModelRenderer(this, 0, 15);
      Shape10.addBox(0F, 0F, 0F, 3, 1, 1);
      Shape10.setRotationPoint(-10F, 5F, -8F);
      Shape10.setTextureSize(64, 64);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0.669215F, 0F);
      Shape11 = new ModelRenderer(this, 0, 7);
      Shape11.addBox(0F, 0F, 0F, 5, 1, 1);
      Shape11.setRotationPoint(7F, 3.3F, -10F);
      Shape11.setTextureSize(64, 64);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, -1.189716F, 0F);
      Shape12 = new ModelRenderer(this, 12, 14);
      Shape12.addBox(0F, 0F, 0F, 3, 1, 1);
      Shape12.setRotationPoint(5F, 0F, 7.5F);
      Shape12.setTextureSize(64, 64);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0.9666439F, 0F);
      Shape13 = new ModelRenderer(this, 0, 14);
      Shape13.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape13.setRotationPoint(-6.5F, -2F, 4F);
      Shape13.setTextureSize(64, 64);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, -0.8922867F, 0.0743572F);
      Shape14 = new ModelRenderer(this, 0, 26);
      Shape14.addBox(0F, 0F, 0F, 3, 1, 1);
      Shape14.setRotationPoint(4F, -5F, -6F);
      Shape14.setTextureSize(64, 64);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, -1.193278F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
}
