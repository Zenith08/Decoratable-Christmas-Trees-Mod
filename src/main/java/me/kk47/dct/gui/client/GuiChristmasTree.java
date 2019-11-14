package me.kk47.dct.gui.client;

import me.kk47.dct.DChristmasTrees;
import me.kk47.dct.gui.ContainerChristmasTree;
import me.kk47.dct.te.TileEntityChristmasTree;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiChristmasTree extends GuiContainer {

	public GuiChristmasTree(IInventory playerInv, TileEntityChristmasTree te) {
		super(new ContainerChristmasTree(playerInv, te));
		//TODO Switch based on trains
        this.xSize = 176;
        this.ySize = 222;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.mc.getTextureManager().bindTexture(new ResourceLocation(DChristmasTrees.MODID + ":textures/gui/gui-christmas-tree.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0,  0, this.xSize, this.ySize);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		
	}

}
