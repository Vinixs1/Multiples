package me.multiplesdev.multiples.items;

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
        basicShovelMeta.setDisplayName("&f&lBasic Shovel");
        List<String> basicShovelLore = new ArrayList<>();
        basicShovelLore.add("&bEfficiency I");
        basicShovelLore.add("");
        basicShovelLore.add(" &8| &7Empty");
        basicShovelLore.add("");
        basicShovelMeta.setLore(basicShovelLore);
        basicShovelMeta.addEnchant(Enchantment.DIG_SPEED, 1, false);
        basicShovelMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        basicShovelItem.setItemMeta(basicShovelMeta);
        basicShovel = basicShovelItem;

        // Good Shovel
        ItemStack goodShovelItem = new ItemStack(Material.GOLDEN_SHOVEL, 1);
        ItemMeta goodShovelMeta = goodShovelItem.getItemMeta();
        goodShovelMeta.setDisplayName("&a&lGood Shovel");
        List<String> goodShovelLore = new ArrayList<>();
        goodShovelLore.add("&bEfficiency I");
        goodShovelLore.add("&bFortune I");
        goodShovelLore.add("");
        goodShovelLore.add(" &8| &7Empty");
        goodShovelLore.add(" &8| &7Empty");
        goodShovelLore.add("");
        goodShovelMeta.setLore(goodShovelLore);
        goodShovelMeta.addEnchant(Enchantment.DIG_SPEED, 1, false);
        goodShovelMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        goodShovelItem.setItemMeta(goodShovelMeta);
        goodShovel = goodShovelItem;

        // Legendary Shovel
        ItemStack legendaryShovelItem = new ItemStack(Material.GOLDEN_SHOVEL, 1);
        ItemMeta legendaryShovelMeta = legendaryShovelItem.getItemMeta();
        legendaryShovelMeta.setDisplayName("&6&lLegendary Shovel");
        List<String> legendaryShovelLore = new ArrayList<>();
        legendaryShovelLore.add("&bEfficiency II");
        legendaryShovelLore.add("&bFortune II");
        legendaryShovelLore.add("");
        legendaryShovelLore.add(" &8| &7Empty");
        legendaryShovelLore.add(" &8| &7Empty");
        legendaryShovelLore.add(" &8| &7Empty");
        legendaryShovelLore.add("");
        legendaryShovelMeta.setLore(legendaryShovelLore);
        legendaryShovelMeta.addEnchant(Enchantment.DIG_SPEED, 1, false);
        legendaryShovelMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        legendaryShovelItem.setItemMeta(legendaryShovelMeta);
        legendaryShovel = legendaryShovelItem;

        // Mythic Shovel
        ItemStack mythicShovelItem = new ItemStack(Material.GOLDEN_SHOVEL, 1);
        ItemMeta mythicShovelMeta = mythicShovelItem.getItemMeta();
        mythicShovelMeta.setDisplayName("&d&lMythic Shovel");
        List<String> mythicShovelLore = new ArrayList<>();
        mythicShovelLore.add("&bEfficiency III");
        mythicShovelLore.add("&bFortune II");
        mythicShovelLore.add("");
        mythicShovelLore.add(" &8| &7Empty");
        mythicShovelLore.add(" &8| &7Empty");
        mythicShovelLore.add(" &8| &7Empty");
        mythicShovelLore.add(" &8| &7Empty");
        mythicShovelLore.add("");
        mythicShovelMeta.setLore(mythicShovelLore);
        mythicShovelMeta.addEnchant(Enchantment.DIG_SPEED, 1, false);
        mythicShovelMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        mythicShovelItem.setItemMeta(mythicShovelMeta);
        mythicShovel = mythicShovelItem;

    }


    
    
}
