package org.retrohaven.pickup;

import org.retrohaven.commands.SetSpawnerCommand;
import org.retrohaven.listeners.PickupBlocksListener;
import org.retrohaven.listeners.SpawnerBreakListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Pickup extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new SpawnerBreakListener(), this);
        getServer().getPluginManager().registerEvents(new PickupBlocksListener(), this);
        getCommand("setspawner").setExecutor(new SetSpawnerCommand());

        System.out.println("[Pickup] Plugin enabled!");
    }

    @Override
    public void onDisable() {
        System.out.println("[Pickup] Plugin disabled!");
    }
}
