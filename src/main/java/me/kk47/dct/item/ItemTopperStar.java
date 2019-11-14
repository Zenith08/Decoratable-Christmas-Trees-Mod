package me.kk47.dct.item;

import me.kk47.dct.DChristmasTrees;
import me.kk47.dct.client.models.ModelStar4Point;
import me.kk47.ueri.UERITechne;
import net.minecraft.util.ResourceLocation;

public class ItemTopperStar extends ItemTopperBase {

	public ItemTopperStar() {
		super("topper-star");
		this.addRenderable(new UERITechne(new ModelStar4Point(), new ResourceLocation(DChristmasTrees.MODID + ":textures/models/star-4-point.png")));
	}

}
