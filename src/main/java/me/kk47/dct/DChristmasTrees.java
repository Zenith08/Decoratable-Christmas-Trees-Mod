package me.kk47.dct;

import me.kk47.dct.gui.DCTGuiHandling;
import me.kk47.dct.worldgen.CTWorldGeneration;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid=DChristmasTrees.MODID, version=DChristmasTrees.VERSION, name=DChristmasTrees.NAME)
public class DChristmasTrees {

	public static final String MODID = "christmastrees";
	public static final String NAME = "Decoratable Christmas Trees";
	public static final String VERSION = "3.0";
	
	@Instance
	public static DChristmasTrees instance;
	
	public static CreativeTabs treeTab = new CreativeTabChristmasTree();
	
	@SidedProxy(clientSide = "me.kk47.dct.client.ClientProxy", serverSide = "me.kk47.dct.server.ServerProxy")
	public static CommonProxy proxy;
	
	CTWorldGeneration treeGeneration;
	
	//TODO World Gen
	//TODO Lang File
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent e) {
		instance = this;
		proxy.preInit(e);
		treeGeneration = new CTWorldGeneration();
    }
        
    @EventHandler
    public void init(FMLInitializationEvent e) {
    	proxy.init(e);
    	
    	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new DCTGuiHandling());
    	
    	GameRegistry.registerWorldGenerator(treeGeneration, 0);
    /*	MinecraftForge.EVENT_BUS.register(new CTEventHandler());
    	
    	packetHandler = NetworkRegistry.INSTANCE.newSimpleChannel("trees");
    	packetHandler.registerMessage(TPacketChangeTrainSpeed.Handler.class, TPacketChangeTrainSpeed.class, 0, Side.SERVER);
    	packetHandler.registerMessage(TPacketChangeTrainDirection.HandlePacketChangeTrainDirection.class, TPacketChangeTrainDirection.class, 1, Side.SERVER);*/
    }
        
    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	proxy.postInit(e);
    }
}
