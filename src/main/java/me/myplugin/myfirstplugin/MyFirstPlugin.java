package me.myplugin.myfirstplugin;

import me.myplugin.myfirstplugin.events.onJumpEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyFirstPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Плагин успешно загружен");
        getServer().getPluginManager().registerEvents(new onJumpEvent(), this);
    }
}
