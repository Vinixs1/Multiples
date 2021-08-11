package me.multiplesdev.multiples.listeners;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.awt.*;
import java.util.*;

public class Listeners implements Listener {

    @EventHandler
    public void blockBreak(BlockBreakEvent e) {
        if (e.getPlayer().getGameMode() == GameMode.CREATIVE || e.getPlayer().getGameMode() == GameMode.SPECTATOR)
            return;
        if (e.getBlock().getState() instanceof Container)
            return;
        Player player = e.getPlayer();
        Block block = e.getBlock();
        World world = e.getPlayer().getWorld();
        Location playerLoc = player.getLocation();
        Location blockLoc = block.getLocation();
        ItemStack inHand = player.getInventory().getItemInMainHand();
        if (inHand.getType() == Material.GOLDEN_SHOVEL) {
            switch (block.getType()) {
                case GOLDEN_SHOVEL:

                case SAND:
                    e.setCancelled(true);
                    sandBreak(player, block, playerLoc);
                    player.playSound(playerLoc, Sound.BLOCK_NOTE_BLOCK_BELL, 1.0f, 2.0f);
                    break;

            default:
                break;

            }
        } else {
            e.setCancelled(true);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lERROR &7You need a shovel to dig for tokens!"));
            player.playSound(playerLoc, Sound.ENTITY_VILLAGER_NO, 1.0f, 2.0f);
        }


    }

    private void sandBreak(Player player, Block block, Location loc) {
        if (randomInt(1, 100) <= 10) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Found" + ChatColor.GOLD + randomInt(3, 23) + "&6tokens in the sand"));
        }
        block.setType(Material.SANDSTONE);
    }

    private static int randomInt(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
