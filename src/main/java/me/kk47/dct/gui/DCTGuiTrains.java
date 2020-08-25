package me.kk47.dct.gui;

import me.kk47.dct.gui.client.GuiChristmasTree;
import me.kk47.dct.gui.client.GuiChristmasTreeTrains;
import me.kk47.dct.te.TileEntityChristmasTree;
import me.kk47.dct.te.TileEntityChristmasTreeTrains;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DCTGuiTrains {
	/*
	public static Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == DCTGuiHandling.CHRISTMAS_TREE_GUI) {
			return new ContainerChristmasTree(player.inventory, (TileEntityChristmasTree) world.getTileEntity(new BlockPos(x, y, z)));
		} else if(ID == DCTGuiHandling.CHRISTMAS_TRAINS_GUI) {
			return new ContainerChristmasTreeTrains(player.inventory, (TileEntityChristmasTreeTrains) world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		return null;
	}

	public static Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == DCTGuiHandling.CHRISTMAS_TREE_GUI) {
			return new GuiChristmasTree(player.inventory, (TileEntityChristmasTree) world.getTileEntity(new BlockPos(x, y, z)));
		}else if(ID == DCTGuiHandling.CHRISTMAS_TRAINS_GUI) {
			return new GuiChristmasTreeTrains(player.inventory, (TileEntityChristmasTreeTrains) world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		return null;
	}*/

}
