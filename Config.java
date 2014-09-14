package me.belka.xdropper;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class Config {

	public static void makeConfig() {
		File f = new File(Core.getPlugin().getDataFolder(), "droppers.yml");
		
		if(!f.exists()) {
			YamlConfiguration config = new YamlConfiguration();
			
			try {
				config.save(f);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void loadConfig() {
		File f = new File(Core.getPlugin().getDataFolder(), "droppers.yml");
		YamlConfiguration config = new YamlConfiguration();
			
		try {
			config.load(f);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
