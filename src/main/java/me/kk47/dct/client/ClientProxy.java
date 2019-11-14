package me.kk47.dct.client;

import me.kk47.dct.CommonProxy;
import me.kk47.dct.block.ModBlocks;
import me.kk47.dct.item.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent pie) {
		super.preInit(pie);
	}

	@Override
	public void init(FMLInitializationEvent ie) {
		super.init(ie);
		ModBlocks.clientInit();
		ModItems.clientInit();
	}

	@Override
	public void postInit(FMLPostInitializationEvent pie) {
		super.postInit(pie);
	}

}
