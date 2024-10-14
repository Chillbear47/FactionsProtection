package me.hi;

import org.bukkit.plugin.java.JavaPlugin;

public final class FactionsProtection extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(new SpawnProtection(), this);
        this.getServer().getPluginManager().registerEvents(new SpawnSpawnProtection(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
