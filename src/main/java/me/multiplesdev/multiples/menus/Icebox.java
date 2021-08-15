package me.multiplesdev.multiples.menus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Icebox implements Listener {

    private static Inventory INV;

    public void register() {

        Inventory inv = Bukkit.createInventory(null, 9, "Personal Icebox");
        List<String> lore = new ArrayList<>();

        ItemStack item = new ItemStack(Material.COD);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.YELLOW  + "x0 Cod");
        lore.add(ChatColor.GRAY + "&7Worth: &e$0");
        lore.add(ChatColor.GRAY + " ");
        lore.add(ChatColor.GRAY + "&7&oaRight-click to sell");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(10, item);

        item = new ItemStack(Material.SALMON);
        meta.setDisplayName(ChatColor.YELLOW  + "x0 Salmon");
        lore.add(ChatColor.GRAY + "&7Worth: &e$0");
        lore.add(ChatColor.GRAY + " ");
        lore.add(ChatColor.GRAY + "&7&oaRight-click to sell");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(11, item);

        setInventory(inv);

    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!event.getInventory().equals(getInventory()))
            return;

        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);

        if (event.getView().getType() == InventoryType.PLAYER)
            return;

        // GUI SLOTS
        switch(event.getSlot()) {

            case 10:
                player.closeInventory();
                player.updateInventory();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "Sold some cod"));
                break;
            case 11:
                player.closeInventory();
                player.updateInventory();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "Sold some salmon"));
                break;
            default:
                break;

        }

    }

    public Inventory getInventory() {
        return INV;
    }

    public void setInventory(Inventory inv) {
        INV = inv;
    }

    public void openInventory(Player player) {
        player.openInventory(INV);
    }

}