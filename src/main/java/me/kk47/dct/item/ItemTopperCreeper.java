package me.kk47.dct.item;

import me.kk47.dct.DChristmasTrees;
import me.kk47.dct.client.models.ModelCreeperTopper;
import me.kk47.ueri.UERITechne;
import net.minecraft.util.ResourceLocation;

public class ItemTopperCreeper extends ItemTopperBase {

	public ItemTopperCreeper() {
		super("topper-creeper");
		this.addRenderable(new UERITechne(new ModelCreeperTopper(), new ResourceLocation(DChristmasTrees.MODID + ":textures/models/topper-creeper.png")));
	}
}
