package me.multiplesdev.multiples.commands;

import me.multiplesdev.multiples.Multiples;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Commands implements CommandExecutor {

    static Multiples plugin;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Usage: &7/multiples reload"));
            return true;
        }

        switch (label) {
            case "multiples":
                if (!(sender.hasPermission("rank.admin"))) {
                    return true;
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    plugin.getPluginLoader().disablePlugin(plugin);
                    plugin.getPluginLoader().enablePlugin(plugin);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lMultiples &7reloading configuration..."));
                    return true;
                }
                break;
            case "icebox":
                break;
            default:
                break;
        }

        return false;
    }

}
