package me.belka.xdropper;

import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {	
	
	private static Core instance;
	public static String title = "§8[§4xDropper§8] §f";
	
	public void onEnable() {
		instance = this;
		
		Config.makeConfig();
		Config.loadConfig();
		
		getServer().getPluginManager().registerEvents(new DropperListener(), this);
		getCommand("dropper").setExecutor(new DropperCommand());
		
		getLogger().info("Плагин включен! by BeLkA");
	}
	
	public static Core getPlugin() {
		return instance;
	}
	
}
