package me.kk47.dct;

import me.kk47.dct.block.ModBlocks;
import me.kk47.dct.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent pie) {
		MinecraftForge.EVENT_BUS.register(ModBlocks.class);
		MinecraftForge.EVENT_BUS.register(ModItems.class);
	}
	
	public void init(FMLInitializationEvent ie) {
		ModBlocks.registerTileEntities();
	}
	
	public void postInit(FMLPostInitializationEvent pie) {
		
	}
}
