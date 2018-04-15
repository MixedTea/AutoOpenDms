package nxty.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientDisconnectionFromServerEvent;
import nxty.util.AutoDenyThreadFactory;

@Mod(modid = "autoDeny", version = "1.0", clientSideOnly = true, acceptedMinecraftVersions = "1.8.9")
public class Main {
	public static final Logger logger = LogManager.getLogger("autoDeny");
	public static Minecraft mc = Minecraft.getMinecraft();
	public static boolean hypixel = false;
	public static final ExecutorService Threadpool;
	public static final String modid = "autoDeny";
	static {
		Threadpool = Executors.newCachedThreadPool(new AutoDenyThreadFactory());
	}
	
	@Mod.Instance
	private static Main instance;
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		ClientCommandHandler.instance.registerCommand(new adCommand());
		MinecraftForge.EVENT_BUS.register(new sendMessage());
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void playerLoggedIn(ClientConnectedToServerEvent event) {
		if(!mc.isSingleplayer()) {
			hypixel = event.manager.getRemoteAddress().toString().toLowerCase().contains("hypixel.net");
		}
	}
	@SubscribeEvent
	public void playerLoggedOut(ClientDisconnectionFromServerEvent event) {
		hypixel = false;
	}
	public static Main getInstance() {
		return instance;
	}
	public static String getModid() {
		return modid;
	}
}
