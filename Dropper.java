package me.belka.xdropper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Dropper {

	public static void makeDropper(String name, Player p, Location loc) {
		File f = new File(Core.getPlugin().getDataFolder(), "droppers.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
		
		if(config.getConfigurationSection("droppers." + name) != null) {
			p.sendMessage(Core.title + "Этот раздатчик уже существует");
			return;
		}
		
		ArrayList<String> list = new ArrayList<>();
		
		config.set("droppers." + name + ".name", name);
		
		config.set("droppers." + name + ".loc.world", loc.getWorld().getName());
		config.set("droppers." + name + ".loc.x", (int) loc.getX());
		config.set("droppers." + name + ".loc.y", (int) loc.add(0, -1, 0).getY());
		config.set("droppers." + name + ".loc.z", (int) loc.getZ());
		
		config.set("droppers." + name + ".items", list);
		
		p.sendMessage(Core.title + "Новый раздатчик " + name + " создан!");
		
		try {
			config.save(f);
			config.load(f);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void addItem(String name, Player p, String id, String dmg, String amount) {;
		
		File f = new File(Core.getPlugin().getDataFolder(), "droppers.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
		
		if(config.getConfigurationSection("droppers." + name) == null) {
			p.sendMessage(Core.title + "Этого раздатчика не существует");
			return;
		}
		
		List<String> first = config.getStringList("droppers." + name + ".items");
		ArrayList<String> list = new ArrayList<>();
		list.addAll(first);
		list.add(id + ";" + dmg + ";" + amount);
		
		config.set("droppers." + name + ".items", list);
		
		p.sendMessage(Core.title  + "К раздатчику " + name + " добавлен предмет с ID " + id + ". Damage предмета - " + dmg + ". Кол-во - " + amount);
		
		try {
			config.save(f);
			config.load(f);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void newLoc(String name, Player p, Location loc) {
		File f = new File(Core.getPlugin().getDataFolder(), "droppers.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
		
		if(config.getConfigurationSection("droppers." + name) == null) {
			p.sendMessage(Core.title + "Этого раздатчика не существует");
			return;
		}
		
		config.set("droppers." + name + ".loc.world", loc.getWorld().getName());
		config.set("droppers." + name + ".loc.x", (int) loc.getX());
		config.set("droppers." + name + ".loc.y", (int) loc.add(0, -1, 0).getY());
		config.set("droppers." + name + ".loc.z", (int) loc.getZ());
		
		p.sendMessage(Core.title + "Локация раздатчика " + name + " изменена! " + loc.getX() + ", " + loc.getY() + ", " + loc.getZ());
		
		try {
			config.save(f);
			config.load(f);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void deleteDropper(String name, Player p) {
		File f = new File(Core.getPlugin().getDataFolder(), "droppers.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
		
		if(config.getConfigurationSection("droppers." + name) == null) {
			p.sendMessage(Core.title + "Этого раздатчика не существует");
			return;
		}
		
		config.set("droppers." + name, null);
		
		p.sendMessage(Core.title + "Раздатчик " + name + " удален!");
		
		try {
			config.save(f);
			config.load(f);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void removeItem(String name, Player p, String id, String dmg, String amount) {
		
		File f = new File(Core.getPlugin().getDataFolder(), "droppers.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
		
		if(config.getConfigurationSection("droppers." + name) == null) {
			p.sendMessage(Core.title + "Этого раздатчика не существует");
			return;
		}
		
		List<String> first = config.getStringList("droppers." + name + ".items");
		ArrayList<String> list = new ArrayList<>();
		list.addAll(first);
		list.remove(id + ";" + dmg + ";" + amount);
		
		config.set("droppers." + name + ".items", list);
		
		p.sendMessage(Core.title  + "В раздатчике " + name + " удален предмет с ID " + id + ", с Damage " + dmg + ", в кол-ве " + amount);
		
		try {
			config.save(f);
			config.load(f);
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
}
