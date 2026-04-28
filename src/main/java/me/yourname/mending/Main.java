package me.yourname.mending;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MendingListener(), this);
        getCommand("mending").setExecutor(new MendingCommand());
    }
}