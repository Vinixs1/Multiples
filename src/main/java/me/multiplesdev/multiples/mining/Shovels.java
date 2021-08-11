package me.multiplesdev.multiples.mining;

import me.multiplesdev.multiples.Multiples;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.awt.*;
import java.util.Collection;
import java.util.Random;

public class Shovels implements Listener {

    static Multiples plugin;
    public Shovels(Multiples instance) {
        plugin = instance;
    }

    @EventHandler
    public void onDig(BlockBreakEvent e) {
        if (!e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) { return; }
        if (e.getPlayer().getGameMode() == GameMode.CREATIVE || e.getPlayer().getGameMode() == GameMode.SPECTATOR) { return; }
        if (e.getBlock().getState() instanceof Container) { return; }
        if (e.getBlock().getType().toString() == "Sand") {
            Player player = e.getPlayer();
            Block block = e.getBlock();
            Location loc = e.getBlock().getLocation();
            ItemStack inHand = e.getPlayer().getInventory().getItemInMainHand();
            Collection<ItemStack> drops = block.getDrops(player.getInventory().getItemInMainHand());
            if (drops.isEmpty()) {
                return;
            }
            if (inHand.getType().toString() == "Golden Shovel") {
                e.setCancelled(true);
                breakSand(player, block, loc);
            } else {
                e.setCancelled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lERROR &7Purchase the &eShovel &7in the &eIsland Shop &7to mine this!"));
            }

        }


    }

    private void breakSand(Player player, Block block, Location loc) {
        int num = getRandom(1, 100);
        if (num >= 75) {
            int addTokens = getRandom(13, 24);
            block.setType(Material.SAND);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lMultiples &7Found " + addTokens + "tokens in the sand!"));
        } else {
            block.setType(Material.SAND);
            long totalMilliseconds = System.currentTimeMillis();

            long totalSeconds = totalMilliseconds / 1000;
            long currentSeconds = totalSeconds % 60;

            long totalMinutes = totalSeconds / 60;
            long currentMinutes = totalMinutes % 60;

            long totalHours = totalMinutes / 60;
            long currentHours = totalHours % 24;
            player.sendMessage(String.valueOf(currentSeconds));
            player.sendMessage(String.valueOf(currentMinutes));
            player.sendMessage(String.valueOf(currentHours));

        }

    }

    private int getRandom(int lower, int upper) {
        Random random = new Random();
        return random.nextInt((upper - lower) + 1) + lower;
    }

}
