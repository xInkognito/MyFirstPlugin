package me.myplugin.myfirstplugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import me.myplugin.myfirstplugin.MyFirstPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class FoodCommand extends BaseCommand {
    MyFirstPlugin plugin = MyFirstPlugin.getPlugin();

    @CommandAlias("food")
    @Description("Get/set your favorite food")
    public void foodCommand(CommandSender sender, @Optional String arg) {
        // If not a player
        if (!(sender instanceof Player player)) {
            return;
        }

        // Get player's food
        String player_food = "food." + player.getUniqueId();

        // If command is "/food"
        if (!(arg == null)) {
            plugin.getConfig().set(player_food, arg);
            final TextComponent textComponent2 = Component
                    .text("You set your favorite food as ")
                    .color(NamedTextColor.DARK_PURPLE)
                    .append(Component
                            .text(arg)
                            .color(NamedTextColor.YELLOW)
                            .decorate(TextDecoration.BOLD));
            player.sendMessage(textComponent2);
            plugin.saveConfig();
            return;
        }

        //If command is "/food <arg>"
        String food = plugin.getConfig().getString(player_food);

        if (food == null) {
            player.sendMessage(Component
                    .text("You didnt set your favorite food yet")
                    .color(NamedTextColor.DARK_PURPLE));
            return;
        }

        final TextComponent textComponent = Component
                .text("Your favorite food is ")
                .color(NamedTextColor.DARK_PURPLE)
                .append(Component
                        .text(food)
                        .color(NamedTextColor.YELLOW)
                        .decorate(TextDecoration.BOLD));
        player.sendMessage(textComponent);
    }
}
