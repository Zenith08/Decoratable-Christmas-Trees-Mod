package me.kk47.dct.item;

import java.util.ArrayList;

import me.kk47.dct.DChristmasTrees;
import me.kk47.dct.client.models.ModelStringLights;
import me.kk47.ueri.UERIMod;
import me.kk47.ueri.UERIRenderable;
import me.kk47.ueri.UERITechne;
import net.minecraft.util.ResourceLocation;

public class ItemStringLights extends ItemLights {

	public static ModelStringLights stringModel = new ModelStringLights();
	
	public ItemStringLights(String variant) {
		super("string-" + variant);
		
		//Overwrites the originals
		if(UERIMod.isClientSided) {
			ResourceLocation stringTexture = new ResourceLocation(DChristmasTrees.MODID + ":textures/models/lights-string-" + variant + ".png");
			this.renderables = new ArrayList<UERIRenderable>();
			this.renderables.add(new UERITechne(stringModel, stringTexture));
		}
		
	}

}
