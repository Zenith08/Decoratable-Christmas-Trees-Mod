package me.kk47.dct.item;

import java.util.ArrayList;
import java.util.List;

import me.kk47.dct.DChristmasTrees;
import me.kk47.dct.api.IItemLights;
import me.kk47.dct.client.models.ModelIcicleLights;
import me.kk47.dct.te.TileEntityChristmasTree;
import me.kk47.dct.te.TileEntityChristmasTreeNormal;
import me.kk47.ueri.UERIMod;
import me.kk47.ueri.UERIRenderable;
import me.kk47.ueri.UERITechne;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemIcicleLights extends Item implements IItemLights {

	private List<UERIRenderable> renderables;
	
	public ItemIcicleLights() {
		this.setCreativeTab(DChristmasTrees.treeTab);
		this.setRegistryName("lights-" + "icicle");
		this.setUnlocalizedName("lights-" + "icicle");

		if(UERIMod.isClientSided) {
			ResourceLocation texture = new ResourceLocation(DChristmasTrees.MODID + ":textures/models/lights-" + "icicle" + ".png");
			renderables = new ArrayList<UERIRenderable>();
			
			renderables.add(new UERITechne(new ModelIcicleLights(), texture));
		}
	}

	@Override
	public List<UERIRenderable> getRenderables(TileEntityChristmasTree treetype) {
		return renderables;
	}

	@Override
	public boolean canBeOnTree(TileEntityChristmasTree treetype) {
		if(treetype instanceof TileEntityChristmasTreeNormal) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Item asItem() {
		return this;
	}

}
