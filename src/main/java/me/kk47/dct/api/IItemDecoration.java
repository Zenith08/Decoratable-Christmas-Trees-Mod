package me.kk47.dct.api;

import java.util.List;

import me.kk47.dct.te.TileEntityChristmasTree;
import me.kk47.ueri.UERIRenderable;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IItemDecoration {

	@SideOnly(Side.CLIENT)
	List<UERIRenderable> getRenderables(TileEntityChristmasTree treetype);
	
	boolean canBeOnTree(TileEntityChristmasTree treetype);
	
	Item asItem();
}
