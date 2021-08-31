package me.multiplesdev.multiples.commands;

import me.multiplesdev.multiples.Multiples;
import me.multiplesdev.multiples.items.ItemManager;
import me.multiplesdev.multiples.menus.Icebox;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    static Multiples plugin;
    static Icebox iceboxplugin;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player) && !sender.hasPermission("rank.admin")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lERROR &7No Permissions!"));
            return true;
        }

        if (!(sender instanceof Player)) {
            return false;
        }

        if (label.equalsIgnoreCase("multiples")) {
            if (args.length >= 1) {
                Player player = (Player) sender;
                switch (args[0].toLowerCase()) {
                    default:
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lERROR &7Unknown args"));
                        break;
                    case "reload":
                        if (args.length > 1) {
                            // TODO - add reset command
                            break;
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lMultiples &7reloading plugin..."));
                            plugin.getPluginLoader().disablePlugin(plugin);
                            plugin.getPluginLoader().enablePlugin(plugin);
                            return true;
                        }
                    case "fishing":
                        if (args.length < 3) {
                            // TODO - add reset command
                            break;
                        }
                    case "basicshovel":
                        player.getInventory().addItem(ItemManager.basicShovel);
                        break;
                    case "goodshovel":
                        player.getInventory().addItem(ItemManager.goodShovel);
                        break;
                    case "epicshovel":
                        player.getInventory().addItem(ItemManager.epicShovel);
                        break;
                    case "legendaryshovel":
                        player.getInventory().addItem(ItemManager.legendaryShovel);
                        break;
                    case "mythicshovel":
                        player.getInventory().addItem(ItemManager.mythicShovel);
                        break;
                }
            }
        } else {
            if (label.equalsIgnoreCase("icebox")) {
                Player player = (Player) sender;
                iceboxplugin.openInventory(player);
                return true;
            }
        }


        return false;
    }

}
