package com.retrohaven.spawnerpickup;

import com.retrohaven.spawnerpickup.commands.SetSpawnerCommand;
import com.retrohaven.spawnerpickup.listeners.SpawnerBreakListener;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnerPickup extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new SpawnerBreakListener(), this);
        getCommand("setspawner").setExecutor(new SetSpawnerCommand());

        System.out.println("[SpawnerPickup] Plugin enabled!");
    }

    @Override
    public void onDisable() {
        System.out.println("[SpawnerPickup] Plugin disabled!");
    }
}
