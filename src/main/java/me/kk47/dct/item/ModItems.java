package me.kk47.dct.item;

import me.kk47.dct.ChristmasDecorationRegistry;
import me.kk47.dct.DChristmasTrees;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	
	public static ItemLights lights4col;
	public static ItemLights lightsBlue;
	public static ItemLights lightsGreen;
	public static ItemLights lightsOff;
	public static ItemLights lightsPurpleBlue;
	public static ItemLights lightsPurple;
	public static ItemLights lightsRedGreen;
	public static ItemLights lightsWhiteTint;
	public static ItemLights lightsWhite;
	public static ItemLights lightsYellowBlue;
	
	public static ItemStringLights lightsStringBlue;
	public static ItemStringLights lightsStringGreen;
	public static ItemStringLights lightsStringRed;
	public static ItemStringLights lightsStringYellow;
	
//	public static ItemIcicleLights icicleLights;
	
	public static ItemBobbleBasic bobbleBlue;
	public static ItemBobbleBasic bobbleGreen;
	public static ItemBobbleBasic bobblePurple;
	public static ItemBobbleBasic bobbleRed;
	public static ItemBobbleBasic bobbleWhite;
	public static ItemBobbleBasic bobbleYellow;
	
	public static ItemTopperBase starTopper;
	public static ItemTopperBase creeperTopper;
	public static ItemTopperBase pigTopper;
	
	public static ItemTrainset trainset;
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		lights4col = new ItemLights("4-col");
		event.getRegistry().register(lights4col);
		ChristmasDecorationRegistry.addLights(lights4col);
		lightsBlue = new ItemLights("blue");
		event.getRegistry().register(lightsBlue);
		ChristmasDecorationRegistry.addLights(lightsBlue);
		lightsGreen = new ItemLights("green");
		event.getRegistry().register(lightsGreen);
		ChristmasDecorationRegistry.addLights(lightsGreen);
		lightsOff = new ItemLights("off");
		event.getRegistry().register(lightsOff);
		ChristmasDecorationRegistry.addLights(lightsOff);
		lightsPurpleBlue = new ItemLights("purple-blue");
		event.getRegistry().register(lightsPurpleBlue);
		ChristmasDecorationRegistry.addLights(lightsPurpleBlue);
		lightsPurple = new ItemLights("purple");
		event.getRegistry().register(lightsPurple);
		ChristmasDecorationRegistry.addLights(lightsPurple);
		lightsRedGreen = new ItemLights("red-green");
		event.getRegistry().register(lightsRedGreen);
		ChristmasDecorationRegistry.addLights(lightsRedGreen);
		lightsWhiteTint = new ItemLights("white-tint");
		event.getRegistry().register(lightsWhiteTint);
		ChristmasDecorationRegistry.addLights(lightsWhiteTint);
		lightsWhite = new ItemLights("white");
		event.getRegistry().register(lightsWhite);
		ChristmasDecorationRegistry.addLights(lightsWhite);
		lightsYellowBlue = new ItemLights("yellow-blue");
		event.getRegistry().register(lightsYellowBlue);
		ChristmasDecorationRegistry.addLights(lightsYellowBlue);
		
		lightsStringBlue = new ItemStringLights("blue");
		event.getRegistry().register(lightsStringBlue);
		ChristmasDecorationRegistry.addLights(lightsStringBlue);
		lightsStringGreen = new ItemStringLights("green");
		event.getRegistry().register(lightsStringGreen);
		ChristmasDecorationRegistry.addLights(lightsStringGreen);
		lightsStringRed = new ItemStringLights("red");
		event.getRegistry().register(lightsStringRed);
		ChristmasDecorationRegistry.addLights(lightsStringRed);
		lightsStringYellow = new ItemStringLights("yellow");
		event.getRegistry().register(lightsStringYellow);
		ChristmasDecorationRegistry.addLights(lightsStringYellow);
		
	/*	icicleLights = new ItemIcicleLights();
		event.getRegistry().register(icicleLights);*/
		
		bobbleBlue = new ItemBobbleBasic("blue");
		event.getRegistry().register(bobbleBlue);
		ChristmasDecorationRegistry.addBobble(bobbleBlue);
		bobbleGreen = new ItemBobbleBasic("green");
		event.getRegistry().register(bobbleGreen);
		ChristmasDecorationRegistry.addBobble(bobbleGreen);
		bobblePurple = new ItemBobbleBasic("purple");
		event.getRegistry().register(bobblePurple);
		ChristmasDecorationRegistry.addBobble(bobblePurple);
		bobbleRed = new ItemBobbleBasic("red");
		event.getRegistry().register(bobbleRed);
		ChristmasDecorationRegistry.addBobble(bobbleRed);
		bobbleWhite = new ItemBobbleBasic("white");
		event.getRegistry().register(bobbleWhite);
		ChristmasDecorationRegistry.addBobble(bobbleWhite);
		bobbleYellow = new ItemBobbleBasic("yellow");
		event.getRegistry().register(bobbleYellow);
		ChristmasDecorationRegistry.addBobble(bobbleYellow);
		
		starTopper = new ItemTopperStar();
		event.getRegistry().register(starTopper);
		ChristmasDecorationRegistry.addTopper(starTopper);
		pigTopper = new ItemTopperPig();
		event.getRegistry().register(pigTopper);
		ChristmasDecorationRegistry.addTopper(pigTopper);
		creeperTopper = new ItemTopperCreeper();
		event.getRegistry().register(creeperTopper);
		ChristmasDecorationRegistry.addTopper(creeperTopper);
		
		trainset = new ItemTrainset();
		event.getRegistry().register(trainset);
	}
	
	@SideOnly(Side.CLIENT)
	public static void clientInit() {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(lights4col, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "lights-4-col", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(lightsBlue, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "lights-blue", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(lightsGreen, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "lights-green", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(lightsOff, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "lights-off", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(lightsPurpleBlue, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "lights-purple-blue", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(lightsPurple, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "lights-purple", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(lightsRedGreen, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "lights-red-green", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(lightsWhiteTint, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "lights-white-tint", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(lightsWhite, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "lights-white", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(lightsYellowBlue, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "lights-yellow-blue", "inventory"));
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(lightsStringBlue, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "lights-string-blue", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(lightsStringGreen, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "lights-string-green", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(lightsStringRed, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "lights-string-red", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(lightsStringYellow, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "lights-string-yellow", "inventory"));
		
		/*Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(icicleLights, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "lights-icicle", "inventory"));*/
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(bobbleBlue, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "decorations-blue", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(bobbleGreen, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "decorations-green", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(bobblePurple, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "decorations-purple", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(bobbleRed, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "decorations-red", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(bobbleWhite, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "decorations-white", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(bobbleYellow, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "decorations-yellow", "inventory"));
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(starTopper, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "topper-star", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(pigTopper, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "topper-pig", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(creeperTopper, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "topper-creeper", "inventory"));
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(trainset, 0, new ModelResourceLocation(DChristmasTrees.MODID + ":" + "trainset", "inventory"));
	}
}
