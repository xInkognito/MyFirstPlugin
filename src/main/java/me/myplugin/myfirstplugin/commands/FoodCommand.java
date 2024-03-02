package me.myplugin.myfirstplugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import me.myplugin.myfirstplugin.MyFirstPlugin;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class FoodCommand extends BaseCommand {
    MyFirstPlugin plugin = MyFirstPlugin.getPlugin();
    @CommandAlias("food")
    @Description("Get/set your favorite food")
    public void foodCommand(CommandSender sender, @Optional String arg) {
        if (sender instanceof Player player) {
            // Get player's food
            String player_food = "food." + player.getUniqueId();
            // If command is "/food"
            if (arg == null)
            {
            String food = plugin.getConfig().getString(player_food);
                if (food == null)
                {
                    player.sendMessage("You didnt set your favorite food yet");
                }
                else {
                    player.sendMessage("Your favorite food is " + food);
                }
            }
            // If command is "/food <arg>"
            else
            {
                plugin.getConfig().set(player_food, arg);
                player.sendMessage("You set your favorite food as " + arg);
                plugin.saveConfig();
            }
        }
    }
}
