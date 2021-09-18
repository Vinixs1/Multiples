package me.multiplesdev.multiples.data;


import me.multiplesdev.multiples.Multiples;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class PlayerManager {

    File file = null;
    FileConfiguration configuration = null;
    OfflinePlayer player = null;

    public void FileUtility(OfflinePlayer player) {
        this.player = player;
    }

    public FileConfiguration getConfig() {
        if(configuration == null) {
            configuration = YamlConfiguration.loadConfiguration(getFile());
            return configuration;
        }
        return configuration;
    }

    public void saveConfig() {
        try {
            configuration.save(file);
            Multiples.get().getLogger().log(Level.INFO, "Saved change for " + file.getName());
        } catch (IOException e) {
            Multiples.get().getLogger().log(Level.SEVERE, "Cannot save to " + file.getName());
        }
    }

    public void set(String path, Object object) {
        getConfig().set(player.getName() + "." + path, object);
        saveConfig();
    }

    public File getFile() {
        if (file == null) {
            this.file = new File(Multiples.get().getDataFolder() + "/players", player.getUniqueId().toString() + ".yml");
            if (!this.file.exists()) {
                try {
                    if (this.file.createNewFile()) {
                        Multiples.get().getLogger().log(Level.INFO, "File for player " + player.getName() + " has been created");
                        Multiples.get().getLogger().log(Level.INFO, "Saved as " + player.getUniqueId().toString() + ".yml");
                    }
                } catch (IOException e) {
                    Multiples.get().getLogger().log(Level.SEVERE, "Cannot create data file for " + player.getName());
                }
            }
            return file;
        }
        return file;
    }

    public void reloadConfig() {
        YamlConfiguration.loadConfiguration(file);

    }

}
