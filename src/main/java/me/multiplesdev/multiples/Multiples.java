package me.multiplesdev.multiples;

import me.multiplesdev.multiples.commands.Commands;
import me.multiplesdev.multiples.data.PlayerManager;
import me.multiplesdev.multiples.items.ItemManager;
import me.multiplesdev.multiples.listeners.ListenerHandler;
import me.multiplesdev.multiples.utils.MiningAPI;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public final class Multiples extends JavaPlugin implements Listener {

    public HashMap<UUID, API> levelManagerHashMap;
    public HashMap<UUID, MiningAPI> miningManagerHashMap;
    private Multiples plugin;
    public PlayerManager playerManager;

    public static Multiples instance;
    public static Multiples get() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getLogger().info("Multiples plugin has been enabled!");
        new ListenerHandler(this);

        // TODO: Create a command handler
        Objects.requireNonNull(this.getCommand("multiples")).setExecutor(new Commands());
        Objects.requireNonNull(this.getCommand("icebox")).setExecutor(new Commands());

        // Create hashmaps
        levelManagerHashMap = new HashMap<>();
        miningManagerHashMap = new HashMap<>();

        // Check for data folder
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }

        // Create/Save config
        getConfig().options().copyDefaults(true);
        saveConfig();

        // Create Shovels, Rods, Other items
        ItemManager.init();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.levelManagerHashMap.clear();
        this.miningManagerHashMap.clear();
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l"));

        if (!player.hasPlayedBefore()) {
            // First Join
            e.setJoinMessage("&6&lNEW &e" + player.getName());
            player.getInventory().addItem(ItemManager.basicShovel);
            player.getInventory().addItem(ItemManager.basicRod);

        }
        e.setJoinMessage("");

        // Check for player data
        if (this.levelManagerHashMap.isEmpty() && this.miningManagerHashMap.isEmpty()) {

            // Create & Store player data
            levelManagerHashMap.put(player.getUniqueId(), new API(1, 0, 0));
            miningManagerHashMap.put(player.getUniqueId(), new MiningAPI(1, 0, 0, 0));

            API fishingLevelManager = levelManagerHashMap.get(player.getUniqueId());
            MiningAPI miningLevelManager = miningManagerHashMap.get(player.getUniqueId());
            YamlConfiguration config = YamlConfiguration.loadConfiguration(playerManager.getFile());
            config.set("Mining.Level", miningLevelManager.getLevel());
            config.set("Mining.Xp", miningLevelManager.getXp());
            config.set("Mining.Progress", miningLevelManager.getProgress());
            config.set("Mining.Mined", miningLevelManager.getBlocksMined());
            config.set("Fishing.Level", fishingLevelManager.getLevel());
            config.set("Fishing.Xp", fishingLevelManager.getXp());
            config.set("Fishing.Caught",fishingLevelManager.getCatchTotal());
            playerManager.saveConfig();

            if (player.hasPermission("rank.admin")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&6&lADMIN &7&oData successfully loaded"));
            }
        } else {
            // Load player data
            int miningLevel = playerManager.getConfig().getInt("Mining.Level");
            int miningXp = playerManager.getConfig().getInt("Mining.Xp");
            int blocksMined = playerManager.getConfig().getInt("Mining.Mined");
            int progress = playerManager.getConfig().getInt("Mining.Progress");
            miningManagerHashMap.put(player.getUniqueId(), new MiningAPI(miningLevel, miningXp, progress, blocksMined));

            // Fishing Data
            int fishingLevel = playerManager.getConfig().getInt("Fishing.Level");
            int fishingXp = playerManager.getConfig().getInt("Fishing.Xp");
            int catchTotal = playerManager.getConfig().getInt("Fishing.Caught");
            levelManagerHashMap.put(player.getUniqueId(), new API(fishingLevel, fishingXp, catchTotal));

        }

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(playerManager.getFile());
        API playerLevelManager = levelManagerHashMap.get(player.getUniqueId());
        MiningAPI playerMiningManager = miningManagerHashMap.get(player.getUniqueId());
        int miningLevel = playerMiningManager.getLevel();
        int miningXp = playerMiningManager.getXp();
        int progress = playerMiningManager.getProgress();
        int blocksMined = playerMiningManager.getBlocksMined();

        int fishingLevel = playerLevelManager.getLevel();
        int fishingXp = playerLevelManager.getXp();
        int fishCaught = playerLevelManager.getCatchTotal();

        // Load data
        config.set("Mining.Level", miningLevel);
        config.set("Mining.Xp", miningXp);
        config.set("Mining.Progress", progress);
        config.set("Mining.Mined", blocksMined);
        config.set("Fishing.Level", fishingLevel);
        config.set("Fishing.Xp", fishingXp);
        config.set("Fishing.Caught", fishCaught);
        playerManager.saveConfig();

        e.setQuitMessage("");
        this.levelManagerHashMap.remove(player.getUniqueId());

    }

}
