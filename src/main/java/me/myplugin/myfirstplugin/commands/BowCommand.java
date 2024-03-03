package me.myplugin.myfirstplugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Description;
import me.myplugin.myfirstplugin.TeleportBow;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class BowCommand extends BaseCommand {
    @CommandAlias("bow")
    @Description("Get teleport bow")
    @CommandPermission("op")
    public void bowCommand(CommandSender sender) {
        if (!(sender instanceof Player player)) {
            return;
        }

        ItemStack teleportBow = TeleportBow.createTeleportBow();
        player.getInventory().addItem(teleportBow);

        ItemStack arrow = new ItemStack(Material.ARROW, 1);
        player.getInventory().addItem(arrow);

        player.sendMessage(Component
                .text("Obtained a ")
                .append(Component
                        .text("teleport-bow")
                        .color(NamedTextColor.RED)
                        .decorate(TextDecoration.BOLD)));

    }
}