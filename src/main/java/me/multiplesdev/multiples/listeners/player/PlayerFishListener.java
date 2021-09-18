package me.multiplesdev.multiples.listeners.player;

import me.multiplesdev.multiples.API;
import me.multiplesdev.multiples.Multiples;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class PlayerFishListener implements Listener {

    static Multiples plugin;
    private Object Damageable;

    public void xpCheck(Player player, Location loc, API playerLevelManager) {
        int level = playerLevelManager.getLevel();
        if (level == 0) {
            int newLevel = (level + 1);
            playerLevelManager.setLevel(1);
            int xp = playerLevelManager.getXp();
            int xpNeeded = plugin.getConfig().getInt("Levels." + newLevel + ".xp");

            int num1 = getRandom(1, 9);
            int num2 = getRandom(1, 9);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', " &6Fishing Level: " + ChatColor.YELLOW + newLevel + "/10"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', " &6Experience: " + ChatColor.YELLOW + xp + "/" + xpNeeded + " exp"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', " &6Weight: " + ChatColor.YELLOW + num1 + "." + num2 + " lbs"));
            player.sendMessage("");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&oExchange drops with the &e&oFisherman"));
            player.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 1f, 2f);
        } else {
            int xpNeeded = plugin.getConfig().getInt("Levels." + level + ".xp");
            int xp = playerLevelManager.getXp();
            int nextLevel = (level + 1);

            if (xp >= xpNeeded) {
                playerLevelManager.setXp(0);
                playerLevelManager.setLevel(nextLevel);

                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&6&lLEVELUP &7You have reached &eFishing Level " + nextLevel + "&e!")));
            }

            int num1 = getRandom(1, 9);
            int num2 = getRandom(1, 9);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', " &6Fishing Level: " + ChatColor.YELLOW + level + "/10"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', " &6Experience: " + ChatColor.YELLOW + xp + "/" + xpNeeded + " exp"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', " &6Weight: " + ChatColor.YELLOW + num1 + "." + num2 + " lbs"));
            player.sendMessage("");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&oExchange drops with the &e&oFisherman"));
            player.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 1f, 2f);
        }
    }

    @EventHandler
    public void onFishEvent(PlayerFishEvent e) {
        if (e.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            Entity caught = e.getCaught();
            Player player = e.getPlayer();
            Location loc = e.getPlayer().getLocation();
            API playerLevelManager = plugin.levelManagerHashMap.get(player.getUniqueId());
            int level = playerLevelManager.getLevel();
            int catchTotal = playerLevelManager.getCatchTotal();

            player.sendMessage("");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l&nCatch Overview &7(" + catchTotal + " &7Caught)"));
            player.sendMessage("");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7You have caught &ex1 " + ChatColor.YELLOW + caught.getName()));
            player.sendMessage("");
            if (level < 10) {
                switch (caught.getName()) {
                    case "Raw Cod":
                        playerLevelManager.setXp(playerLevelManager.getXp() + 12);
                        break;
                    case "Raw Salmon":
                        playerLevelManager.setXp(playerLevelManager.getXp() + 16);
                        break;
                    case "Pufferfish":
                        playerLevelManager.setXp(playerLevelManager.getXp() + 20);
                        break;
                    case "Tropical Fish":
                        playerLevelManager.setXp(playerLevelManager.getXp() + 26);
                        break;

                    case "Lily Pad":
                    case "Bowl":
                    case "Leather":
                    case "Leather Boots":
                    case "Rotten Flesh":
                    case "Stick":
                    case "String":
                    case "Water Bottle":
                    case "Bone":
                    case "Ink Sac":
                    case "Tripwire Hook":
                        playerLevelManager.setXp(playerLevelManager.getXp() + 32);
                        break;

                    case "Bow":
                    case "Fishing Rod":
                    case "Name Tag":
                    case "Nautilus Shell":
                    case "Enchanted book":
                        playerLevelManager.setXp(playerLevelManager.getXp() + 50);
                        break;
                }
            }
            xpCheck(player, loc, playerLevelManager);

            int rdmRepair = getRandom(1, 100);
            if (rdmRepair == 100) {
                ItemStack inHand = e.getPlayer().getInventory().getItemInMainHand();
                ItemMeta meta = inHand.getItemMeta();
                if (inHand.getType() != Material.FISHING_ROD) { return; }
                if (meta instanceof Damageable) {
                    int currentDurability = ((Damageable) meta).getDamage();
                    ((Damageable) meta).setDamage((short) inHand.getType().getMaxDurability() - (inHand.getType().getMaxDurability() + currentDurability + 1));
                    inHand.setItemMeta(meta);
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&6You were lucky and received a free repair!")));
                    player.playSound(loc, Sound.ITEM_BOTTLE_FILL_DRAGONBREATH, 1f, 0.7f);
                }
            }
        }

    }

    private int getRandom(int lower, int upper) {
        Random random = new Random();
        return random.nextInt((upper - lower) + 1) + lower;
    }

}
