package me.multiplesdev.multiples;

import me.multiplesdev.multiples.commands.Commands;
import me.multiplesdev.multiples.fishing.Catch;
import me.multiplesdev.multiples.listeners.Listeners;
import me.multiplesdev.multiples.menus.Icebox;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public final class Multiples extends JavaPlugin implements Listener {

    public HashMap<UUID, API> levelManagerHashMap;
    private Multiples plugin;
    static Icebox iceboxplugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(this, this);
        pm.registerEvents(new Catch(this), this);
        pm.registerEvents(new Listeners(), this);
        this.levelManagerHashMap = new HashMap<>();
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        Objects.requireNonNull(this.getCommand("multiples")).setExecutor(new Commands());
        Objects.requireNonNull(this.getCommand("icebox")).setExecutor(new Commands());

        // Database Connection

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.levelManagerHashMap.clear();
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage("");

        if (!player.hasPlayedBefore()) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l"));

            // Create Fishing Player Data
            this.levelManagerHashMap.put(player.getUniqueId(), new API(0, 0));
            this.getConfig().set("PlayerLevels." + player.getUniqueId() + ".level", 0);
            this.getConfig().set("PlayerLevels." + player.getUniqueId() + ".xp", 0);
            this.saveConfig();

        } else {

            // Get Fishing Player Data
            int level = this.getConfig().getInt("PlayerLevels." + player.getUniqueId() + ".level");
            int xp = this.getConfig().getInt("PlayerLevels." + player.getUniqueId() + ".xp");
            levelManagerHashMap.put(player.getUniqueId(), new API(level, xp));
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage("");
        API playerLevelManager = this.levelManagerHashMap.get(player.getUniqueId());

        if (this.levelManagerHashMap.containsKey(player.getUniqueId())) {
            this.getConfig().set("PlayerLevels." + player.getUniqueId() + ".level", playerLevelManager.getLevel());
            this.getConfig().set("PlayerLevels." + player.getUniqueId() + ".xp", playerLevelManager.getXp());
            this.saveConfig();
            this.levelManagerHashMap.remove(player.getUniqueId());
        }

    }

}
