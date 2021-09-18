package me.multiplesdev.multiples.listeners;

import me.multiplesdev.multiples.Multiples;
import me.multiplesdev.multiples.listeners.block.BlockBreakListener;
import me.multiplesdev.multiples.listeners.player.PlayerFishListener;
import me.multiplesdev.multiples.listeners.player.PlayerHungerListener;
import org.bukkit.event.Listener;

public class ListenerHandler {

    private final Multiples plugin;


    public ListenerHandler(Multiples plugin) {
        this.plugin = plugin;

        // block events
        registerEvent(new BlockBreakListener());

        // player events
        registerEvent(new PlayerFishListener());
        registerEvent(new PlayerHungerListener());
    }

    private void registerEvent(Listener event) {
        plugin.getServer().getPluginManager().registerEvents(event, plugin);
    }

}
