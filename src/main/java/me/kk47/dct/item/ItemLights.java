package me.kk47.dct.item;

import java.util.ArrayList;
import java.util.List;

import me.kk47.dct.DChristmasTrees;
import me.kk47.dct.api.IItemLights;
import me.kk47.dct.client.models.ModelChristmasLights;
import me.kk47.dct.te.TileEntityChristmasTree;
import me.kk47.dct.te.TileEntityChristmasTreeNormal;
import me.kk47.ueri.UERIMod;
import me.kk47.ueri.UERIRenderable;
import me.kk47.ueri.UERITechne;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemLights extends Item implements IItemLights {

	public static ModelChristmasLights model = new ModelChristmasLights();
	public ResourceLocation texture;

	//Not Static
	private UERIRenderable rendered;

	protected List<UERIRenderable> renderables;

	private String name;

	/**@param varient the suffix after lights-string- to be included in the registry and unlocalized names*/
	public ItemLights(String variant) {
		this.name = variant;
		this.setCreativeTab(DChristmasTrees.treeTab);
		this.setRegistryName("lights-" + variant);
		this.setUnlocalizedName("lights-" + variant);

		if(UERIMod.isClientSided) {
			texture = new ResourceLocation(DChristmasTrees.MODID + ":textures/models/lights-" + variant + ".png");
			renderables = new ArrayList<UERIRenderable>();
			rendered = new UERITechne(model, texture);
			renderables.add(rendered);
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
