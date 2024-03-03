package me.myplugin.myfirstplugin.events;

import com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent;
import de.tr7zw.changeme.nbtapi.NBT;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.HashMap;
import java.util.UUID;

public class ArrowListener implements Listener {
    private HashMap<UUID, UUID> arrowsAndPlayers = new HashMap<>();

    @EventHandler
    public void onArrowHit(ProjectileHitEvent e) {
        if (!(e.getEntity().getType() == EntityType.ARROW)) {
            return;
        }

        if (!(e.getEntity().getShooter() instanceof Player p)) {
            return;
        }

        if (!p.isOnline() || p.isDead()){
            return;
        }

        UUID arrowHitId = e.getEntity().getUniqueId();
        if(!(arrowsAndPlayers.containsKey(arrowHitId))){
            return;
        }

        UUID playerId = arrowsAndPlayers.get(arrowHitId);
        if(!(p.getUniqueId() == playerId)){
            return;
        }

        Location playerLocation = p.getLocation();
        Location arrowLocation = e.getEntity().getLocation();
        Location teleportDestination = arrowLocation;
        teleportDestination.setPitch(playerLocation.getPitch());
        teleportDestination.setYaw(playerLocation.getYaw());

        p.teleport(teleportDestination);

        teleportDestination.getWorld().playSound(teleportDestination, Sound.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, 3.0F, 3.0F);

        e.getEntity().remove();
    }

    @EventHandler
    public void onShootBow(EntityShootBowEvent e)
    {
        if (!(e.getEntity() instanceof Player p)) {
            return;
        }

        String expectedBowId = "1";
        String actualBowId = NBT.get(p.getInventory().getItemInMainHand(), nbt -> nbt.getString("UniqueID"));

        if (!actualBowId.equals(expectedBowId)){
            return;
        }

        UUID arrowId = e.getProjectile().getUniqueId();
        UUID playerId = p.getUniqueId();

        arrowsAndPlayers.put(arrowId, playerId);
    }

    @EventHandler
    public void onArrowRemove(EntityRemoveFromWorldEvent e){
        if(!(e.getEntity().getType() == EntityType.ARROW)){
            return;
        }
        if(!(arrowsAndPlayers.containsKey(e.getEntity().getUniqueId()))){
            return;
        }

        UUID arrowId = e.getEntity().getUniqueId();
        arrowsAndPlayers.remove(arrowId);
    }
}
