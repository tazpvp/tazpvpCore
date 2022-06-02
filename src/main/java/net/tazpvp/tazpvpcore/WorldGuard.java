package net.tazpvp.tazpvpcore;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import java.util.List;

public class WorldGuard implements Listener {
    @EventHandler
    public void blockBreakEvent(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();
        if(p.getWorld().getName().equals("arena") && p.getGameMode() == GameMode.SURVIVAL) {
            if (!isPlayerPlaced(b)) { e.setCancelled(true); }
        }
    }

    public void blockPlaceEvent(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();
        if (p.getGameMode() == GameMode.SURVIVAL) {
            b.setMetadata("PlayerPlaced", new FixedMetadataValue(TazpvpCore.getInstance(), true));
        }
    }
}
