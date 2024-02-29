package me.myplugin.myfirstplugin.events;


import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class onJumpEvent implements Listener {

    @EventHandler
    public void onJump(PlayerJumpEvent e){

        Player player = e.getPlayer();
        player.sendMessage("Молодец!");

    }
}
