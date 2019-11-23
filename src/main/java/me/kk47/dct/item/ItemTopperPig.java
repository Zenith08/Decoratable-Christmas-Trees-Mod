package me.kk47.dct.item;

import me.kk47.dct.DChristmasTrees;
import me.kk47.dct.client.models.ModelTopperPig;
import me.kk47.ueri.UERIMod;
import me.kk47.ueri.UERITechne;
import net.minecraft.util.ResourceLocation;

public class ItemTopperPig extends ItemTopperBase{

	public ItemTopperPig() {
		super("topper-pig");
		if(UERIMod.isClientSided) {
			this.addRenderable(new UERITechne(new ModelTopperPig(), new ResourceLocation(DChristmasTrees.MODID + ":textures/models/topper-pig.png")));
		}
	}
}
