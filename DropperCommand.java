package me.belka.xdropper;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DropperCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(sender instanceof Player) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("dropper")) {
			
			if(args.length == 0) {
				p.sendMessage("§8§m-------------------------------");
				p.sendMessage("§exDropper");
				p.sendMessage("§c/dropper set <ИМЯ> §6- Создать новый раздатчик");
				p.sendMessage("§c/dropper delete <ИМЯ> §6- Удалить раздатчик");
				p.sendMessage("§c/dropper newloc <ИМЯ> §6- Установка другой локации раздатчика");
				p.sendMessage("§c/dropper add <ИМЯ> <ID Предмета> <Damage> <Amount> §6- Добавить предмет к раздатчику");
				p.sendMessage("§c/dropper remove <ИМЯ> <ID Предмета> <Damage> <Amount> §6- Удалить предмет из раздатчика");
				p.sendMessage("§8§m-------------------------------");
			}
			
			if(args.length > 0) {
			if(args[0].equalsIgnoreCase("set")) {
				if(p.hasPermission("xdropper.set")) {
				if(args.length == 1) {
					p.sendMessage(Core.title  + "§cМало аргументов! Правильное использование: §f/dropper set <ИМЯ>");
				}
				if(args.length == 2) {
					Dropper.makeDropper(args[1], p, p.getLocation());
				}
				} else {
					p.sendMessage(Core.title + "§cНет разрешения!");
				}
			}
			
			if(args[0].equalsIgnoreCase("newloc")) {
				if(p.hasPermission("xdropper.newloc")) {
				if(args.length == 1) {
					p.sendMessage(Core.title  + "§cМало аргументов! Правильное использование: §f/dropper newloc <ИМЯ>");
				}
				if(args.length == 2) {
					Dropper.newLoc(args[1], p, p.getLocation());
				}
				} else {
					p.sendMessage(Core.title + "§cНет разрешения!");
				}
			}
			
			if(args[0].equalsIgnoreCase("add")) {
				if(p.hasPermission("xdropper.add")) {
				if(args.length == 1) {
					p.sendMessage(Core.title  + "§cМало аргументов! Правильное использование: §f/dropper add <ИМЯ> <ID Предмета> <Damage> <Amount>");
				}
				if(args.length == 2) {
					p.sendMessage(Core.title  + "§cМало аргументов! Правильное использование: §f/dropper add <ИМЯ> <ID Предмета> <Damage> <Amount>");
				}
				if(args.length == 3) {
					p.sendMessage(Core.title  + "§cМало аргументов! Правильное использование: §f/dropper add <ИМЯ> <ID Предмета> <Damage> <Amount>");
				}
				if(args.length == 4) {
					p.sendMessage(Core.title  + "§cМало аргументов! Правильное использование: §f/dropper add <ИМЯ> <ID Предмета> <Damage> <Amount>");
				}
				if(args.length == 5) {
					Dropper.addItem(args[1], p, args[2], args[3], args[4]);
				}
				} else {
					p.sendMessage(Core.title + "§cНет разрешения!");
				}
			}
			
			if(args[0].equalsIgnoreCase("delete")) {
				if(p.hasPermission("xdropper.delete")) {
				if(args.length == 1) {
					p.sendMessage(Core.title  + "§cМало аргументов! Правильное использование: §f/dropper delete <ИМЯ>");
				}
				if(args.length == 2) {
					Dropper.deleteDropper(args[1], p);
				}
				} else {
					p.sendMessage(Core.title + "§cНет разрешения!");
				}
			}
			
			if(args[0].equalsIgnoreCase("remove")) {
				if(p.hasPermission("xdropper.remove")) {
				if(args.length == 1) {
					p.sendMessage(Core.title  + "§cМало аргументов! Правильное использование: §f/dropper remove <ИМЯ> <ID Предмета> <Damage> <Amount>");
				}
				if(args.length == 2) {
					p.sendMessage(Core.title  + "§cМало аргументов! Правильное использование: §f/dropper remove <ИМЯ> <ID Предмета> <Damage> <Amount>");
				}
				if(args.length == 3) {
					p.sendMessage(Core.title  + "§cМало аргументов! Правильное использование: §f/dropper remove <ИМЯ> <ID Предмета> <Damage> <Amount>");
				}
				if(args.length == 4) {
					p.sendMessage(Core.title  + "§cМало аргументов! Правильное использование: §f/dropper remove <ИМЯ> <ID Предмета> <Damage> <Amount>");
				}
				if(args.length == 5) {
					Dropper.removeItem(args[1], p, args[2], args[3], args[4]);
				}
				} else {
					p.sendMessage(Core.title + "§cНет разрешения!");
				}
			}
			}
		}
		return true;
		} else {
			sender.sendMessage(ChatColor.RED + "Консоль запрещена!");
		}
		return false;
	}
	
}
