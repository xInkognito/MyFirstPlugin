package me.myplugin.myfirstplugin;

import de.tr7zw.changeme.nbtapi.NBT;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TeleportBow {

    public static ItemStack createTeleportBow(){
        ItemStack teleportBow = new ItemStack(Material.BOW, 1);

        ItemMeta teleportBowMeta = teleportBow.getItemMeta();

        List<Component> bowLore = new ArrayList<>() {{
            add(Component
                    .text("Teleport-bow")
                    .color(NamedTextColor.GREEN));
            add(Component
                    .text(" whose arrows teleport you")
                    .color(NamedTextColor.GRAY));
        }};
        teleportBowMeta.lore(bowLore);

        Component bowDisplayName = Component
                .text("Teleport-bow")
                .color(NamedTextColor.DARK_PURPLE);
        teleportBowMeta.displayName(bowDisplayName);

        teleportBowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);

        teleportBowMeta.isUnbreakable();

        teleportBow.setItemMeta(teleportBowMeta);

        NBT.modify(teleportBow, nbt -> {
            nbt.setString("UniqueID", "1");
        });

        return teleportBow;
    }
}
