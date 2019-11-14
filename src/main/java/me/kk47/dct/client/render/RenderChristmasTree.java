package me.kk47.dct.client.render;

import java.util.List;

import me.kk47.dct.api.IItemBobble;
import me.kk47.dct.api.IItemDecoration;
import me.kk47.dct.api.IItemTopper;
import me.kk47.dct.te.TileEntityChristmasTreeNormal;
import me.kk47.ueri.UERIRenderable;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderChristmasTree extends TileEntitySpecialRenderer<TileEntityChristmasTreeNormal> {

	public RenderChristmasTree() {
		
	}
	
	@Override
	public void render(TileEntityChristmasTreeNormal te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		//Renders the tree's basic model
		List<UERIRenderable> tree = te.getTreeRenderables();
		for(UERIRenderable render : tree) {
			renderUERI(te, x, y, z, render, 1.0f, 0, 0, 0, 0);
		}
		
		//Renders the decorations
		if(te.getStackInSlot(0).getItem() instanceof IItemTopper) {
			IItemTopper topper = (IItemTopper) te.getStackInSlot(0).getItem();
//			System.out.println("Rotation expected at " + topper.getRotation(te.getStackInSlot(0)));
			for(UERIRenderable render : topper.getRenderables(te)) {
				renderUERI(te, x, y, z, render, 1.0f, 0, 0, 0, topper.getRotation(te.getStackInSlot(0)));
			}
		}
		if(te.getStackInSlot(1).getItem() instanceof IItemDecoration) {
			IItemDecoration decoration = (IItemDecoration) te.getStackInSlot(1).getItem();
			for(UERIRenderable render : decoration.getRenderables(te)) {
				renderUERI(te, x, y, z, render, 1.0f, 0, 0, 0, 0);
			}
		}
		if(te.getStackInSlot(2).getItem() instanceof IItemBobble) {
			IItemBobble decoration = (IItemBobble) te.getStackInSlot(2).getItem();
			for(UERIRenderable render : decoration.getAltRenderables(te)) {
				renderUERI(te, x, y, z, render, 1.0f, 0, 0, 0, 0);
			}
		}
		if(te.getStackInSlot(3).getItem() instanceof IItemDecoration) {
			IItemDecoration decoration = (IItemDecoration) te.getStackInSlot(3).getItem();
			for(UERIRenderable render : decoration.getRenderables(te)) {
				renderUERI(te, x, y, z, render, 1.0f, 0, 0, 0, 0);
			}
		}
	}

	public void renderUERI(TileEntity te, double x, double y, double z, UERIRenderable renderable, float scale, float modifierX, float modifierY, float modifierZ, float rotation) {
		//		System.out.println("RenderUERI method called");
		//The PushMatrix tells the renderer to "start" doing something.
		GlStateManager.pushMatrix();
		//This is setting the initial location.
		GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		//Applies Scaling
		GlStateManager.scale(scale, scale, scale);

		//IDK why but this needs to be there
		GlStateManager.rotate(rotation, 0.0F, 1.0F, 0.0F);
		//This disables lighting on the model so that it doesn't factor being in a block when rendered
		GlStateManager.disableLighting();

		renderable.render();

		GlStateManager.popMatrix();
	}
}
