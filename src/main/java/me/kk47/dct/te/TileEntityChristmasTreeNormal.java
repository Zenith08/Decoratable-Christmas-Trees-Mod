package me.kk47.dct.te;

import java.util.ArrayList;
import java.util.List;

import me.kk47.dct.DChristmasTrees;
import me.kk47.dct.client.models.ModelChristmasTree;
import me.kk47.ueri.UERIMod;
import me.kk47.ueri.UERIRenderable;
import me.kk47.ueri.UERITechne;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityChristmasTreeNormal extends TileEntityChristmasTree {

	@SideOnly(Side.CLIENT)
	List<UERIRenderable> treeModel;

	public TileEntityChristmasTreeNormal() {
		if(UERIMod.isClientSided) {
			treeModel = new ArrayList<UERIRenderable>();
			treeModel.add(new UERITechne(new ModelChristmasTree(), new ResourceLocation(DChristmasTrees.MODID + ":textures/blocks/christmas-tree-normal.png")));
		}
	}

	@Override
	public List<UERIRenderable> getTreeRenderables() {
		return treeModel;
	}

	@Override
	public boolean supportsTrains() {
		return false;
	}

	@Override
	public int getSizeInventory() {
		return 4;
	}

}
