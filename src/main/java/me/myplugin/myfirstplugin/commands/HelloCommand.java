package me.myplugin.myfirstplugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Description;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelloCommand extends BaseCommand {
    @CommandAlias("hello|hi")
    @Description("Say hello to yourself")
    @CommandPermission("op")
    public void onHello(CommandSender sender) {
        if (sender instanceof Player player) {
            player.sendMessage("Привет, " + player.getName());
        }
    }
}
