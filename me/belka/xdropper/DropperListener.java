package me.belka.xdropper;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class DropperListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		if(e.getClickedBlock() != null) {
			File f = new File(Core.getPlugin().getDataFolder(), "droppers.yml");
			YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
			if(config.getConfigurationSection("droppers") != null) {
				for(String key : config.getConfigurationSection("droppers").getValues(false).keySet()) {
						Location loc = new Location(Bukkit.getWorld(config.getString("droppers." + key + ".loc.world")), 
								config.getDouble("droppers." + key + ".loc.x"), 
								config.getDouble("droppers." + key + ".loc.y"), 
								config.getDouble("droppers." + key + ".loc.z"));
						
						if((int) config.getDouble("droppers." + key + ".loc.x") == (int) e.getClickedBlock().getLocation().getX() &&
							(int) config.getDouble("droppers." + key + ".loc.y") == (int) e.getClickedBlock().getLocation().getY() && 
							(int) config.getDouble("droppers." + key + ".loc.z") == (int) e.getClickedBlock().getLocation().getZ()) {
								
							if(e.getPlayer().hasPermission("xdropper.get")) {
								String[] first = config.getStringList("droppers." + key + ".items").toArray(new String[config.getStringList("droppers." + key + ".items").size()]);
								
								for(int i = 0; i < config.getStringList("droppers." + key + ".items").size(); i++) {
								
								String[] split = first[i].split(";");
								
								ItemStack item = new ItemStack(Integer.parseInt(split[0]));
								item.setDurability((short) Integer.parseInt(split[1]));
								item.setAmount(Integer.parseInt(split[2]));
								
								e.getPlayer().getWorld().dropItemNaturally(loc, item);
								}
						} else {
							e.getPlayer().sendMessage(Core.title + "§cНет разрешения!");
						}
					}
				}
			}
		}
	}
	
}
