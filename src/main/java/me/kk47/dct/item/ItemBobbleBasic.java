package me.kk47.dct.item;

import java.util.ArrayList;
import java.util.List;

import me.kk47.dct.DChristmasTrees;
import me.kk47.dct.api.IItemBobble;
import me.kk47.dct.client.models.ModelDecorationA;
import me.kk47.dct.client.models.ModelDecorationB;
import me.kk47.dct.te.TileEntityChristmasTree;
import me.kk47.dct.te.TileEntityChristmasTreeNormal;
import me.kk47.ueri.UERIMod;
import me.kk47.ueri.UERIRenderable;
import me.kk47.ueri.UERITechne;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemBobbleBasic extends Item implements IItemBobble {

	public static ModelDecorationA modelA = new ModelDecorationA();
	public static ModelDecorationB modelB = new ModelDecorationB();
	
	public ResourceLocation texture;

	//Not Static
	private UERIRenderable renderedA;
	private UERIRenderable renderedB;

	private List<UERIRenderable> renderablesA;
	private List<UERIRenderable> renderablesB;

	private String name;

	/**@param varient the suffix after decorations- to be included in the registry and unlocalized names*/
	public ItemBobbleBasic(String variant) {
		this.name = variant;
		this.setCreativeTab(DChristmasTrees.treeTab);
		this.setRegistryName("decorations-" + variant);
		this.setUnlocalizedName("decorations-" + variant);

		if(UERIMod.isClientSided) {
			texture = new ResourceLocation(DChristmasTrees.MODID + ":textures/models/decorations-" + variant + ".png");
			renderablesA = new ArrayList<UERIRenderable>();
			renderablesB = new ArrayList<UERIRenderable>();
			renderedA = new UERITechne(modelA, texture);
			renderedB = new UERITechne(modelB, texture);
			renderablesA.add(renderedA);
			renderablesB.add(renderedB);
		}
	}

	@Override
	public List<UERIRenderable> getRenderables(TileEntityChristmasTree treetype) {
		return renderablesA;
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
	public List<UERIRenderable> getAltRenderables(TileEntityChristmasTree treetype) {
		return renderablesB;
	}

	@Override
	public Item asItem() {
		return this;
	}
}
