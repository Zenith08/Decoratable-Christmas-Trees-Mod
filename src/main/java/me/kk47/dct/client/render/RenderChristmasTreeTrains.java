package me.kk47.dct.client.render;

import java.util.ArrayList;
import java.util.List;

import me.kk47.dct.api.IItemBobble;
import me.kk47.dct.api.IItemDecoration;
import me.kk47.dct.api.IItemTopper;
import me.kk47.dct.item.ItemTrainset;
import me.kk47.dct.te.TileEntityChristmasTreeTrains;
import me.kk47.modeltrains.Data;
import me.kk47.modeltrains.api.IItemModelTrack;
import me.kk47.modeltrains.api.IItemTrain;
import me.kk47.modeltrains.api.IItemTrainLoadable;
import me.kk47.modeltrains.client.model.ModelDummyTrain;
import me.kk47.modeltrains.tileentity.TileEntityTrainController;
import me.kk47.modeltrains.train.RollingStock;
import me.kk47.ueri.UERIRenderable;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderChristmasTreeTrains extends TileEntitySpecialRenderer<TileEntityChristmasTreeTrains>{
	private ModelDummyTrain dummytrain = new ModelDummyTrain();
	private ResourceLocation dummytexture = new ResourceLocation(Data.MODID + ":textures/trains/DummyTrain.png");

	@Override
	public void render(TileEntityChristmasTreeTrains te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		renderTreeModel(te, x, y, z, partialTicks, destroyStage, alpha);
		if(te.getStackInSlot(8) != ItemStack.EMPTY && te.getStackInSlot(8).getItem() instanceof ItemTrainset){
			ItemStack[][] inv2d = te.getInventory();
			for(int lx = 0; lx < 4; lx++){
				for(int ly = 0; ly < 4; ly++){
					if(inv2d[lx][ly] != null && inv2d[lx][ly] != ItemStack.EMPTY){
						ItemStack i = inv2d[lx][ly];
						
						if(i.getItem() instanceof IItemModelTrack){
							IItemModelTrack track = (IItemModelTrack) i.getItem();
							List<UERIRenderable> trainModels = track.getRenderables(i);
							for(UERIRenderable renderable : trainModels) {
								renderScaleUERI(te, x, y, z, renderable, 0.25F, 1.0F*lx, 0.0F, 1.0F*ly, (90.0F*i.getItemDamage()));
							}
						}
					}
				}
				RollingStock[] trains = te.getTrains();
				for(int i = 0; i < trains.length; i++){
					if(trains[i].getTrainItem() != null) {
						IItemTrain it = trains[i].getTrainItem();
						List<UERIRenderable> rendering = new ArrayList<UERIRenderable>();
						rendering.addAll(it.getRenderables(te.getStackInSlot(7-i)));
						
						if(it instanceof IItemTrainLoadable) {
							IItemTrainLoadable itl = (IItemTrainLoadable) it;
							List<UERIRenderable> loadedOverrides = itl.getModelOverrides(trains[i].getLoadedResource().getName());
							if(loadedOverrides != null) {
								rendering.addAll(loadedOverrides);
							}
						}
						
						for(UERIRenderable renderable : rendering) {
							renderTrain(te, x, y, z, renderable, 0.25F, trains[i].getPos().getX(), 0.0F, trains[i].getPos().getY(), trains[i].getPos().getYaw());
						}
					}
				}
			}
		}
	}

	public void renderTreeModel(TileEntityChristmasTreeTrains te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		//Renders the tree's basic model
		List<UERIRenderable> tree = te.getTreeRenderables();
		for(UERIRenderable render : tree) {
			renderUERI(te, x, y, z, render, 1.0f, 0, 0, 0, 0);
		}

		//Renders the decorations
		if(te.getStackInSlot(0).getItem() instanceof IItemTopper) {
			IItemTopper topper = (IItemTopper) te.getStackInSlot(0).getItem();
			//					System.out.println("Rotation expected at " + topper.getRotation(te.getStackInSlot(0)));
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

	public void renderScaleUERI(TileEntity te, double x, double y, double z, UERIRenderable render, float scale, float modifierX, float modifierY, float modifierZ, float rotation){
		//The PushMatrix tells the renderer to "start" doing something.
		GlStateManager.pushMatrix();
		//This is setting the initial location.
		//		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GlStateManager.translate((float) x + 0.125F, (float) y+0.4F, (float) z + 0.125F);
		//Applies Scaling
		GlStateManager.scale(scale, scale, scale);
		//Applies new translation
		GlStateManager.translate(modifierX, modifierY-0.1F, modifierZ);

		GlStateManager.rotate(rotation, 0.0f, 1.0f, 0.0f);
		//This disables lighting on the model so that it doesn't factor being in a block when rendered
		GlStateManager.disableLighting();
		//the ':' is very important
		render.render();
		
		GlStateManager.popMatrix();
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
	
	public void renderTrain(TileEntity te, double x, double y, double z, UERIRenderable renderable, float scale, float modifierX, float modifierY, float modifierZ, float rotation) {
		//		System.out.println("RenderUERI method called");
		//The PushMatrix tells the renderer to "start" doing something.
		GlStateManager.pushMatrix();
		//This is setting the initial location.
		GlStateManager.translate((float) x + 0.1F - TileEntityTrainController.BLOCK_OFFSET, (float) y+0.4F, (float) z + 0.125F - TileEntityTrainController.BLOCK_OFFSET);
		//Applies Scaling
		GlStateManager.scale(scale, scale, scale);
		//Applies new translation
		GlStateManager.translate(modifierX+3.6F, modifierY, modifierZ-0.5F);

		GlStateManager.rotate(rotation, 0.0F, 1.0F, 0.0F);
		//This disables lighting on the model so that it doesn't factor being in a block when rendered
		GlStateManager.disableLighting();

		renderable.render();

		GlStateManager.popMatrix();
	}
}
