package me.kk47.dct.gui;

import me.kk47.dct.gui.client.GuiChristmasTree;
import me.kk47.dct.te.TileEntityChristmasTree;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class DCTGuiHandling implements IGuiHandler {

	public static final int CHRISTMAS_TREE_GUI = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == CHRISTMAS_TREE_GUI) {
			return new ContainerChristmasTree(player.inventory, (TileEntityChristmasTree) world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == CHRISTMAS_TREE_GUI) {
			return new GuiChristmasTree(player.inventory, (TileEntityChristmasTree) world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		return null;
	}

}
