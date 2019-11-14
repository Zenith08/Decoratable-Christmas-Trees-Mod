package me.kk47.dct.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDecorationA extends ModelBase
{
  //fields
    ModelRenderer ornament;
    ModelRenderer Shape54;
    ModelRenderer Shape55;
    ModelRenderer Shape59;
    ModelRenderer Shape60;
    ModelRenderer Shape62;
    ModelRenderer Shape63;
    ModelRenderer Shape65;
    ModelRenderer Shape66;
    ModelRenderer Shape68;
    ModelRenderer Shape69;
    ModelRenderer Shape70;
    ModelRenderer Shape71;
    ModelRenderer Shape72;
  
  public ModelDecorationA()
  {
    textureWidth = 16;
    textureHeight = 16;
    
      ornament = new ModelRenderer(this, 0, 0);
      ornament.addBox(0F, 0F, 0F, 2, 2, 2);
      ornament.setRotationPoint(-7F, -1F, -3F);
      ornament.setTextureSize(16, 16);
      ornament.mirror = true;
      setRotation(ornament, -0.7063936F, 0F, 0.2602503F);
      Shape54 = new ModelRenderer(this, 0, 0);
      Shape54.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape54.setRotationPoint(-10F, 9F, -7F);
      Shape54.setTextureSize(16, 16);
      Shape54.mirror = true;
      setRotation(Shape54, -0.2974289F, -0.0371786F, 0.7063936F);
      Shape55 = new ModelRenderer(this, 0, 0);
      Shape55.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape55.setRotationPoint(-4.4F, -5F, -0.3333333F);
      Shape55.setTextureSize(16, 16);
      Shape55.mirror = true;
      setRotation(Shape55, 0F, 0F, 0.6320364F);
      Shape59 = new ModelRenderer(this, 0, 0);
      Shape59.addBox(0F, 0F, 0F, 2, 2, 1);
      Shape59.setRotationPoint(-2F, -5F, 2.8F);
      Shape59.setTextureSize(16, 16);
      Shape59.mirror = true;
      setRotation(Shape59, 0.5205006F, 0F, 0F);
      Shape60 = new ModelRenderer(this, 0, 0);
      Shape60.addBox(0F, 0F, 0F, 2, 2, 1);
      Shape60.setRotationPoint(-7.4F, 11.33333F, 9.866667F);
      Shape60.setTextureSize(16, 16);
      Shape60.mirror = true;
      setRotation(Shape60, 0.5948578F, 0F, 0F);
      Shape62 = new ModelRenderer(this, 0, 0);
      Shape62.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape62.setRotationPoint(-4F, 2F, 6.466667F);
      Shape62.setTextureSize(16, 16);
      Shape62.mirror = true;
      setRotation(Shape62, 0.2974289F, 0F, 0F);
      Shape63 = new ModelRenderer(this, 0, 0);
      Shape63.addBox(0F, 0F, 0F, 1, 2, 2);
      Shape63.setRotationPoint(5F, -0.3333333F, -1.866667F);
      Shape63.setTextureSize(16, 16);
      Shape63.mirror = true;
      setRotation(Shape63, -0.7435722F, -0.0743572F, -0.5576792F);
      Shape65 = new ModelRenderer(this, 0, 0);
      Shape65.addBox(0F, 0F, 0F, 1, 2, 2);
      Shape65.setRotationPoint(9.533334F, 9.8F, 4.866667F);
      Shape65.setTextureSize(16, 16);
      Shape65.mirror = true;
      setRotation(Shape65, 0F, -0.0371786F, -0.5576792F);
      Shape66 = new ModelRenderer(this, 0, 0);
      Shape66.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape66.setRotationPoint(10.33333F, 11.26667F, -5.8F);
      Shape66.setTextureSize(16, 16);
      Shape66.mirror = true;
      setRotation(Shape66, 0F, 0F, -0.6145831F);
      Shape68 = new ModelRenderer(this, 0, 0);
      Shape68.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape68.setRotationPoint(6.6F, 4.8F, 4.333333F);
      Shape68.setTextureSize(16, 16);
      Shape68.mirror = true;
      setRotation(Shape68, 0F, 0F, -0.4089647F);
      Shape69 = new ModelRenderer(this, 0, 0);
      Shape69.addBox(0F, 0F, 0F, 2, 2, 1);
      Shape69.setRotationPoint(-3.866667F, 0.6666667F, -6.533333F);
      Shape69.setTextureSize(16, 16);
      Shape69.mirror = true;
      setRotation(Shape69, -0.6320364F, 0F, 0F);
      Shape70 = new ModelRenderer(this, 0, 0);
      Shape70.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape70.setRotationPoint(3.133333F, 0F, -6F);
      Shape70.setTextureSize(16, 16);
      Shape70.mirror = true;
      setRotation(Shape70, -0.5948578F, 0F, 0F);
      Shape71 = new ModelRenderer(this, 0, 0);
      Shape71.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape71.setRotationPoint(-6.6F, 8.333333F, -11F);
      Shape71.setTextureSize(16, 16);
      Shape71.mirror = true;
      setRotation(Shape71, 0F, 0F, 0F);
      Shape72 = new ModelRenderer(this, 0, 0);
      Shape72.addBox(0F, 0F, 0F, 2, 2, 1);
      Shape72.setRotationPoint(3.8F, 5.866667F, -8.733334F);
      Shape72.setTextureSize(16, 16);
      Shape72.mirror = true;
      setRotation(Shape72, -0.5576792F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    ornament.render(f5);
    Shape54.render(f5);
    Shape55.render(f5);
    Shape59.render(f5);
    Shape60.render(f5);
    Shape62.render(f5);
    Shape63.render(f5);
    Shape65.render(f5);
    Shape66.render(f5);
    Shape68.render(f5);
    Shape69.render(f5);
    Shape70.render(f5);
    Shape71.render(f5);
    Shape72.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
}
