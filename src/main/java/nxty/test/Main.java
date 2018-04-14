package nxty.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import nxty.util.AutoDenyThreadFactory;

@Mod(modid = "autoDeny", version = "1.0", clientSideOnly = true, acceptedMinecraftVersions = "1.8.9")
public class Main {
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static final ExecutorService Threadpool;
	
	static {
		Threadpool = Executors.newCachedThreadPool(new AutoDenyThreadFactory());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new sendMessage());
	}
	
}
