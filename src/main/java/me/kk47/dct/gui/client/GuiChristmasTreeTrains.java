package me.kk47.dct.gui.client;

import java.io.IOException;

import me.kk47.dct.DChristmasTrees;
import me.kk47.dct.gui.ContainerChristmasTreeTrains;
import me.kk47.dct.gui.button.TReverserButton;
import me.kk47.dct.network.TPacketTrainChangeDirection;
import me.kk47.dct.network.TPacketTrainChangeSpeed;
import me.kk47.dct.te.TileEntityChristmasTreeTrains;
import me.kk47.modeltrains.gui.client.button.ReverserButton;
import me.kk47.modeltrains.gui.client.button.SpeedButton;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiChristmasTreeTrains extends GuiContainer{
	TileEntityChristmasTreeTrains te;

	public SpeedButton tsb1;
	public SpeedButton tsb2;
	public SpeedButton tsb3;
	public SpeedButton tsb4;
	public SpeedButton tsb5;
	public SpeedButton tsb6;

	public TReverserButton tforwards;
	public TReverserButton tbackwards;

	public GuiChristmasTreeTrains(IInventory playerInv, TileEntityChristmasTreeTrains te) {
		super(new ContainerChristmasTreeTrains(playerInv, te));

		this.te = te;
		this.xSize = 176;
		this.ySize = 186;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		//Updates speed buttons
		byte speed = te.getSpeedValue();
		tsb1.isSelected = false;
		tsb2.isSelected = false;
		tsb3.isSelected = false;
		tsb4.isSelected = false;
		tsb5.isSelected = false;
		tsb6.isSelected = false;
		if(speed == 0){
			tsb1.isSelected = true;
		}else if(speed == 1){
			tsb2.isSelected = true;
		}else if(speed == 2){
			tsb3.isSelected = true;
		}else if(speed == 3){
			tsb4.isSelected = true;
		}else if(speed == 4){
			tsb5.isSelected = true;
		}else if(speed == 5){
			tsb6.isSelected = true;
		}

		tforwards.isSelected = false;
		tbackwards.isSelected = false;
		if(te.getDirectionValue()){
			tforwards.isSelected = true;
		}else{
			tbackwards.isSelected = true;
		}


		this.mc.getTextureManager().bindTexture(new ResourceLocation(DChristmasTrees.MODID + ":textures/gui/gui-christmas-tree-trains.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}

	@Override
	public void initGui(){
		super.initGui();
		//		System.out.println("init gui");
		//  gui button             id, x cord, y cord, caption
		this.buttonList.add(tforwards = new TReverserButton(0, guiLeft + 135, guiTop + 71, 36, 18, "Backwards"));
		this.buttonList.add(tbackwards = new TReverserButton(1, guiLeft + 97, guiTop + 71, 36, 18, "Forwards"));

		this.buttonList.add(tsb1 = new SpeedButton(2, guiLeft + 11, guiTop + 5, 9, 9, ""));
		this.buttonList.add(tsb2 = new SpeedButton(3, guiLeft + 11, guiTop + 16, 9, 9, ""));
		this.buttonList.add(tsb3 = new SpeedButton(4, guiLeft + 11, guiTop + 27, 9, 9, ""));
		this.buttonList.add(tsb4 = new SpeedButton(5, guiLeft + 11, guiTop + 38, 9, 9, ""));
		this.buttonList.add(tsb5 = new SpeedButton(6, guiLeft + 11, guiTop + 49, 9, 9, ""));
		this.buttonList.add(tsb6 = new SpeedButton(7, guiLeft + 11, guiTop + 60, 9, 9, ""));
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
//		System.out.println("Action Performed, button id is " + button.id);
		if(button.id > 1){
			DChristmasTrees.packetHandler.sendToServer(new TPacketTrainChangeSpeed((byte) (button.id-2), te.getPos()));
		}else if(button.id == 0){
			DChristmasTrees.packetHandler.sendToServer(new TPacketTrainChangeDirection(true, te.getPos()));
		}else if(button.id == 1){
			DChristmasTrees.packetHandler.sendToServer(new TPacketTrainChangeDirection(false, te.getPos()));
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {

	}
}
