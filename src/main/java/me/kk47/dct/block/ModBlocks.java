package me.kk47.dct.block;

import me.kk47.dct.DChristmasTrees;
import me.kk47.dct.client.render.RenderChristmasTree;
import me.kk47.dct.te.TileEntityChristmasTreeNormal;
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

public class ModBlocks {

	public static BlockChristmasTreeNormal normalTree;
	public static Item itemTree;
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		normalTree = new BlockChristmasTreeNormal();
		event.getRegistry().register(normalTree);
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		itemTree = new ItemBlock(normalTree).setRegistryName("christmastree-normal");
		event.getRegistry().register(itemTree);
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityChristmasTreeNormal.class, new ResourceLocation(DChristmasTrees.MODID, "christmastree-normal"));
	}
	
	@SideOnly(Side.CLIENT)
	public static void clientInit() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChristmasTreeNormal.class, new RenderChristmasTree());
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(itemTree, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "christmastree-normal", "inventory"));
	}
}
