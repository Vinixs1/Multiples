package me.multiplesdev.multiples.listeners.block;

import me.multiplesdev.multiples.Multiples;
import me.multiplesdev.multiples.items.ItemManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.awt.*;
import java.util.Random;

public class BlockBreakListener implements Listener {

    static Multiples plugin;

    @EventHandler
    public void blockBreak(BlockBreakEvent e) {
        if (e.getPlayer().getGameMode() == GameMode.CREATIVE || e.getPlayer().getGameMode() == GameMode.SPECTATOR)
            return;
        if (e.getBlock().getState() instanceof Container)
            return;
        if (e.isCancelled()) {
            return;
        }
        if (e.getBlock().getType() != Material.SAND || e.getBlock().getType() != Material.SOUL_SAND) return;
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

                // case SOUL_SAND:

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

            if (player.getInventory().getItemInMainHand().getItemMeta().equals(ItemManager.basicShovel.getItemMeta())) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new net.md_5.bungee.api.chat.TextComponent(ChatColor.translateAlternateColorCodes('&',
                        " &6&oFound " + ChatColor.GOLD + ChatColor.ITALIC + randomInt(5, 23) + " &6&oTokens in the sand")));
            }

            if (player.getInventory().getItemInMainHand().getItemMeta().equals(ItemManager.goodShovel.getItemMeta())) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new net.md_5.bungee.api.chat.TextComponent(ChatColor.translateAlternateColorCodes('&',
                        " &6&oFound " + ChatColor.GOLD + ChatColor.ITALIC + randomInt(16, 32) + " &6&oTokens in the sand")));
            }

            if (player.getInventory().getItemInMainHand().getItemMeta().equals(ItemManager.legendaryShovel.getItemMeta())) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new net.md_5.bungee.api.chat.TextComponent(ChatColor.translateAlternateColorCodes('&',
                        " &6&oFound " + ChatColor.GOLD + ChatColor.ITALIC + randomInt(21, 42) + " &6&oTokens in the sand")));
            }

            if (player.getInventory().getItemInMainHand().getItemMeta().equals(ItemManager.mythicShovel.getItemMeta())) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&',
                        " &6&oFound " + ChatColor.GOLD + ChatColor.ITALIC + randomInt(34, 64) + " &6&oTokens in the sand")));
            }

            player.playSound(loc, Sound.ENTITY_VILLAGER_YES, 1.0f, 2.0f);
        }

        // TODO: Sand Cooldown
        block.setType(Material.SANDSTONE);

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            for (int i = 0; i < 10; i++) {

            }


        });

    }

    private static int randomInt(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
