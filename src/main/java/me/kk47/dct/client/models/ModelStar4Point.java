package me.kk47.dct.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStar4Point extends ModelBase
{
  //fields
    ModelRenderer Shape1;
  
  public ModelStar4Point()
  {
    textureWidth = 16;
    textureHeight = 16;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 5, 5, 1);
      Shape1.setRotationPoint(0F, -18F, -0.5F);
      Shape1.setTextureSize(16, 16);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0.7853982F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    Shape1.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
}
