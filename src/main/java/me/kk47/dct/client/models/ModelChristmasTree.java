package me.kk47.dct.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChristmasTree extends ModelBase
{
  //fields
    ModelRenderer Trunk;
    ModelRenderer Branch2B;
    ModelRenderer Branch2R;
    ModelRenderer Branch2F;
    ModelRenderer Branch2L;
    ModelRenderer Branch3B;
    ModelRenderer Branch3R;
    ModelRenderer Branch3F;
    ModelRenderer Branch3L;
    ModelRenderer Branch4B;
    ModelRenderer Branch4R;
    ModelRenderer Branch4F;
    ModelRenderer Branch4L;
    ModelRenderer Branch5B;
    ModelRenderer Branch5R;
    ModelRenderer Branch5F;
    ModelRenderer Branch5L;
    ModelRenderer Branch6B;
    ModelRenderer Branch6R;
    ModelRenderer Branch6F;
    ModelRenderer Branch6L;
  
  public ModelChristmasTree()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Trunk = new ModelRenderer(this, 0, 0);
      Trunk.addBox(0F, 0F, 0F, 8, 14, 8);
      Trunk.setRotationPoint(-4F, 10F, -4F);
      Trunk.setTextureSize(64, 32);
      Trunk.mirror = true;
      setRotation(Trunk, 0F, 0F, 0F);
      Branch2B = new ModelRenderer(this, 0, 25);
      Branch2B.addBox(0F, 0F, 0F, 24, 7, 0);
      Branch2B.setRotationPoint(-12F, 8F, 7F);
      Branch2B.setTextureSize(64, 32);
      Branch2B.mirror = true;
      setRotation(Branch2B, 0.6981317F, 0F, 0F);
      Branch2R = new ModelRenderer(this, 0, 1);
      Branch2R.addBox(0F, 0F, 0F, 0, 7, 24);
      Branch2R.setRotationPoint(-7F, 8F, -12F);
      Branch2R.setTextureSize(64, 32);
      Branch2R.mirror = true;
      setRotation(Branch2R, 0F, 0F, 0.6981317F);
      Branch2F = new ModelRenderer(this, 0, 25);
      Branch2F.addBox(0F, 0F, 0F, 24, 7, 0);
      Branch2F.setRotationPoint(-12F, 8F, -7F);
      Branch2F.setTextureSize(64, 32);
      Branch2F.mirror = true;
      setRotation(Branch2F, -0.6981317F, 0F, 0F);
      Branch2L = new ModelRenderer(this, 0, 1);
      Branch2L.addBox(0F, 0F, 0F, 0, 7, 24);
      Branch2L.setRotationPoint(7F, 7F, -12F);
      Branch2L.setTextureSize(64, 32);
      Branch2L.mirror = true;
      setRotation(Branch2L, 0F, 0F, -0.6981317F);
      Branch3B = new ModelRenderer(this, 0, 25);
      Branch3B.addBox(0F, 0F, 0F, 20, 7, 0);
      Branch3B.setRotationPoint(-10F, 3F, 5F);
      Branch3B.setTextureSize(64, 32);
      Branch3B.mirror = true;
      setRotation(Branch3B, 0.6981317F, 0F, 0F);
      Branch3R = new ModelRenderer(this, 0, 5);
      Branch3R.addBox(0F, 0F, 0F, 0, 7, 20);
      Branch3R.setRotationPoint(-5F, 3F, -10F);
      Branch3R.setTextureSize(64, 32);
      Branch3R.mirror = true;
      setRotation(Branch3R, 0F, 0F, 0.6981317F);
      Branch3F = new ModelRenderer(this, 0, 25);
      Branch3F.addBox(0F, 0F, 0F, 20, 7, 0);
      Branch3F.setRotationPoint(-10F, 3F, -5F);
      Branch3F.setTextureSize(64, 32);
      Branch3F.mirror = true;
      setRotation(Branch3F, -0.6981317F, 0F, 0F);
      Branch3L = new ModelRenderer(this, 0, 5);
      Branch3L.addBox(0F, 0F, 0F, 0, 7, 20);
      Branch3L.setRotationPoint(5F, 3F, -10F);
      Branch3L.setTextureSize(64, 32);
      Branch3L.mirror = true;
      setRotation(Branch3L, 0F, 0F, -0.6981317F);
      Branch4B = new ModelRenderer(this, 0, 25);
      Branch4B.addBox(0F, 0F, 0F, 16, 7, 0);
      Branch4B.setRotationPoint(-8F, -2F, 3F);
      Branch4B.setTextureSize(64, 32);
      Branch4B.mirror = true;
      setRotation(Branch4B, 0.6981317F, 0F, 0F);
      Branch4R = new ModelRenderer(this, 0, 9);
      Branch4R.addBox(0F, 0F, 0F, 0, 7, 16);
      Branch4R.setRotationPoint(-3F, -2F, -8F);
      Branch4R.setTextureSize(64, 32);
      Branch4R.mirror = true;
      setRotation(Branch4R, 0F, 0F, 0.6981317F);
      Branch4F = new ModelRenderer(this, 0, 25);
      Branch4F.addBox(0F, 0F, 0F, 16, 7, 0);
      Branch4F.setRotationPoint(-8F, -2F, -3F);
      Branch4F.setTextureSize(64, 32);
      Branch4F.mirror = true;
      setRotation(Branch4F, -0.6981317F, 0F, 0F);
      Branch4L = new ModelRenderer(this, 0, 9);
      Branch4L.addBox(0F, 0F, 0F, 0, 7, 16);
      Branch4L.setRotationPoint(3F, -2F, -8F);
      Branch4L.setTextureSize(64, 32);
      Branch4L.mirror = true;
      setRotation(Branch4L, 0F, 0F, -0.7853982F);
      Branch5B = new ModelRenderer(this, 0, 25);
      Branch5B.addBox(0F, 0F, 0F, 12, 7, 0);
      Branch5B.setRotationPoint(-6F, -7F, 1F);
      Branch5B.setTextureSize(64, 32);
      Branch5B.mirror = true;
      setRotation(Branch5B, 0.6981317F, 0F, 0F);
      Branch5R = new ModelRenderer(this, 0, 13);
      Branch5R.addBox(0F, 0F, 0F, 0, 7, 12);
      Branch5R.setRotationPoint(-1F, -7F, -6F);
      Branch5R.setTextureSize(64, 32);
      Branch5R.mirror = true;
      setRotation(Branch5R, 0F, 0F, 0.7853982F);
      Branch5F = new ModelRenderer(this, 0, 25);
      Branch5F.addBox(0F, 0F, 0F, 12, 7, 0);
      Branch5F.setRotationPoint(-6F, -7F, -1F);
      Branch5F.setTextureSize(64, 32);
      Branch5F.mirror = true;
      setRotation(Branch5F, -0.6981317F, 0F, 0F);
      Branch5L = new ModelRenderer(this, 0, 13);
      Branch5L.addBox(0F, 0F, 0F, 0, 7, 12);
      Branch5L.setRotationPoint(1F, -7F, -6F);
      Branch5L.setTextureSize(64, 32);
      Branch5L.mirror = true;
      setRotation(Branch5L, 0F, 0F, -0.6981317F);
      Branch6B = new ModelRenderer(this, 0, 25);
      Branch6B.addBox(0F, 0F, 0F, 8, 7, 0);
      Branch6B.setRotationPoint(-4F, -12F, -1F);
      Branch6B.setTextureSize(64, 32);
      Branch6B.mirror = true;
      setRotation(Branch6B, 0.6981317F, 0F, 0F);
      Branch6R = new ModelRenderer(this, 0, 17);
      Branch6R.addBox(0F, 0F, 0F, 0, 7, 8);
      Branch6R.setRotationPoint(1F, -12F, -4F);
      Branch6R.setTextureSize(64, 32);
      Branch6R.mirror = true;
      setRotation(Branch6R, 0F, 0F, 0.6981317F);
      Branch6F = new ModelRenderer(this, 0, 25);
      Branch6F.addBox(0F, 0F, 0F, 8, 7, 0);
      Branch6F.setRotationPoint(-4F, -12F, 1F);
      Branch6F.setTextureSize(64, 32);
      Branch6F.mirror = true;
      setRotation(Branch6F, -0.6981317F, 0F, 0F);
      Branch6L = new ModelRenderer(this, 0, 17);
      Branch6L.addBox(0F, 0F, 0F, 0, 7, 8);
      Branch6L.setRotationPoint(-1F, -12F, -4F);
      Branch6L.setTextureSize(64, 32);
      Branch6L.mirror = true;
      setRotation(Branch6L, 0F, 0F, -0.6981317F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    Trunk.render(f5);
    Branch2B.render(f5);
    Branch2R.render(f5);
    Branch2F.render(f5);
    Branch2L.render(f5);
    Branch3B.render(f5);
    Branch3R.render(f5);
    Branch3F.render(f5);
    Branch3L.render(f5);
    Branch4B.render(f5);
    Branch4R.render(f5);
    Branch4F.render(f5);
    Branch4L.render(f5);
    Branch5B.render(f5);
    Branch5R.render(f5);
    Branch5F.render(f5);
    Branch5L.render(f5);
    Branch6B.render(f5);
    Branch6R.render(f5);
    Branch6F.render(f5);
    Branch6L.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
 
}
