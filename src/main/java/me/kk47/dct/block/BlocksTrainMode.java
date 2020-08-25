package me.kk47.dct.block;

import me.kk47.dct.DChristmasTrees;
import me.kk47.dct.client.render.RenderChristmasTreeTrains;
import me.kk47.dct.te.TileEntityChristmasTreeTrains;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlocksTrainMode {
	
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		ModBlocks.normalTree = new BlockChristmasTreeTrains();
		event.getRegistry().register(ModBlocks.normalTree);
	}
	
	/*public static void registerItems(RegistryEvent.Register<Item> event) {
		ModBlocks.itemTree = new ItemBlock(ModBlocks.normalTree).setRegistryName("christmastree-normal");
		event.getRegistry().register(ModBlocks.itemTree);
	}*/
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityChristmasTreeTrains.class, new ResourceLocation(DChristmasTrees.MODID, "christmastree-normal"));
	}
	
	public static void clientInit() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChristmasTreeTrains.class, new RenderChristmasTreeTrains());
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(ModBlocks.itemTree, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "christmastree-normal", "inventory"));
	}
}
