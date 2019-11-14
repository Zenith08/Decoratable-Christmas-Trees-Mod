package me.kk47.dct.api;

import java.util.List;

import me.kk47.dct.te.TileEntityChristmasTree;
import me.kk47.ueri.UERIRenderable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IItemBobble extends IItemDecoration {

	@SideOnly(Side.CLIENT)
	List<UERIRenderable> getAltRenderables(TileEntityChristmasTree treetype);
	
}
