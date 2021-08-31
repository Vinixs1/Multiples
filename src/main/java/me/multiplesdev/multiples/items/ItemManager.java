package me.multiplesdev.multiples.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack basicShovel;
    public static ItemStack goodShovel;
    public static ItemStack epicShovel;
    public static ItemStack legendaryShovel;
    public static ItemStack mythicShovel;

    public static void init() {
        createShovels();
    }

    private static void createShovels() {
        // Basic Shovel
        ItemStack basicShovelItem = new ItemStack(Material.GOLDEN_SHOVEL, 1);
        ItemMeta basicShovelMeta = basicShovelItem.getItemMeta();
        basicShovelMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lBasic Shovel"));
        List<String> basicShovelLore = new ArrayList<>();
        basicShovelLore.add(ChatColor.translateAlternateColorCodes('&', "&bEfficiency I"));
        basicShovelLore.add("");
        basicShovelLore.add(ChatColor.translateAlternateColorCodes('&', " &8| &7Empty"));
        basicShovelMeta.setLore(basicShovelLore);
        basicShovelMeta.addEnchant(Enchantment.DIG_SPEED, 1, false);
        basicShovelMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        basicShovelMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        basicShovelMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        basicShovelItem.setItemMeta(basicShovelMeta);
        basicShovel = basicShovelItem;

        // Good Shovel
        ItemStack goodShovelItem = new ItemStack(Material.GOLDEN_SHOVEL, 1);
        ItemMeta goodShovelMeta = goodShovelItem.getItemMeta();
        goodShovelMeta.setDisplayName("&a&lGood Shovel");
        List<String> goodShovelLore = new ArrayList<>();
        goodShovelLore.add(ChatColor.translateAlternateColorCodes('&', "&bEfficiency I"));
        goodShovelLore.add(ChatColor.translateAlternateColorCodes('&', "&bFortune I"));
        goodShovelLore.add("");
        goodShovelLore.add(ChatColor.translateAlternateColorCodes('&', " &8| &7Empty"));
        goodShovelLore.add(ChatColor.translateAlternateColorCodes('&', " &8| &7Empty"));
        goodShovelMeta.setLore(goodShovelLore);
        goodShovelMeta.addEnchant(Enchantment.DIG_SPEED, 1, false);
        goodShovelMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        goodShovelMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        goodShovelMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        goodShovelItem.setItemMeta(goodShovelMeta);
        goodShovel = goodShovelItem;

        // Legendary Shovel
        ItemStack legendaryShovelItem = new ItemStack(Material.GOLDEN_SHOVEL, 1);
        ItemMeta legendaryShovelMeta = legendaryShovelItem.getItemMeta();
        legendaryShovelMeta.setDisplayName("&6&lLegendary Shovel");
        List<String> legendaryShovelLore = new ArrayList<>();
        legendaryShovelLore.add(ChatColor.translateAlternateColorCodes('&', "&bEfficiency II"));
        legendaryShovelLore.add(ChatColor.translateAlternateColorCodes('&', "&bFortune II"));
        legendaryShovelLore.add("");
        legendaryShovelLore.add(ChatColor.translateAlternateColorCodes('&', " &8| &7Empty"));
        legendaryShovelLore.add(ChatColor.translateAlternateColorCodes('&', " &8| &7Empty"));
        legendaryShovelLore.add(ChatColor.translateAlternateColorCodes('&', " &8| &7Empty"));
        legendaryShovelMeta.setLore(legendaryShovelLore);
        legendaryShovelMeta.addEnchant(Enchantment.DIG_SPEED, 1, false);
        legendaryShovelMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        legendaryShovelMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        legendaryShovelMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        legendaryShovelItem.setItemMeta(legendaryShovelMeta);
        legendaryShovel = legendaryShovelItem;

        // Mythic Shovel
        ItemStack mythicShovelItem = new ItemStack(Material.GOLDEN_SHOVEL, 1);
        ItemMeta mythicShovelMeta = mythicShovelItem.getItemMeta();
        mythicShovelMeta.setDisplayName("&d&lMythic Shovel");
        List<String> mythicShovelLore = new ArrayList<>();
        mythicShovelLore.add(ChatColor.translateAlternateColorCodes('&', "&bEfficiency III"));
        mythicShovelLore.add(ChatColor.translateAlternateColorCodes('&', "&bFortune II"));
        mythicShovelLore.add("");
        mythicShovelLore.add(ChatColor.translateAlternateColorCodes('&', " &8| &7Empty"));
        mythicShovelLore.add(ChatColor.translateAlternateColorCodes('&', " &8| &7Empty"));
        mythicShovelLore.add(ChatColor.translateAlternateColorCodes('&', " &8| &7Empty"));
        mythicShovelLore.add(ChatColor.translateAlternateColorCodes('&', " &8| &7Empty"));
        mythicShovelMeta.setLore(mythicShovelLore);
        mythicShovelMeta.addEnchant(Enchantment.DIG_SPEED, 1, false);
        mythicShovelMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        mythicShovelMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        mythicShovelMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        mythicShovelItem.setItemMeta(mythicShovelMeta);
        mythicShovel = mythicShovelItem;

    }


    
    
}
