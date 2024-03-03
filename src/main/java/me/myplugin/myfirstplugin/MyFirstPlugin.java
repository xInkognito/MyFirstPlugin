package me.myplugin.myfirstplugin;

import co.aikar.commands.PaperCommandManager;
import me.myplugin.myfirstplugin.commands.BowCommand;
import me.myplugin.myfirstplugin.commands.FoodCommand;
import me.myplugin.myfirstplugin.commands.HelloCommand;
import me.myplugin.myfirstplugin.events.ArrowListener;
import me.myplugin.myfirstplugin.events.JumpListener;
import org.bukkit.plugin.java.JavaPlugin;


public final class MyFirstPlugin extends JavaPlugin {

    private static MyFirstPlugin plugin;

    public static MyFirstPlugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        getLogger().info("Плагин успешно загружен");
        getServer().getPluginManager().registerEvents(new JumpListener(), this);
        getServer().getPluginManager().registerEvents(new ArrowListener(), this);

        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new HelloCommand());
        manager.registerCommand(new FoodCommand());
        manager.registerCommand(new BowCommand());

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
}

