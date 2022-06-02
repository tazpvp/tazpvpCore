package net.tazpvp.tazpvpcore;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import java.util.List;

import static net.tazpvp.tazpvpcore.Utils.BlockUtils.isPlayerPlaced;
import static net.tazpvp.tazpvpcore.Utils.ChatUtils.startswith;

public class WorldGuard implements Listener {
    @EventHandler
    public void blockBreakEvent(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();
        if(p.getWorld().getName().equals("arena") && p.getGameMode() == GameMode.SURVIVAL) {
            if (!isPlayerPlaced(b)) { e.setCancelled(true); }
        }
    }

    @EventHandler
    public void blockPlaceEvent(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();
        if (p.getGameMode() == GameMode.SURVIVAL) {
            b.setMetadata("PlayerPlaced", new FixedMetadataValue(TazpvpCore.getInstance(), true));
        }
    }

    @EventHandler
    public void cmdPreProeces(PlayerCommandPreprocessEvent e){
        String msg = e.getMessage();
        if (startswith(msg, "/minecraft:") || startswith(msg, "/pl ") || startswith(msg, "/plugins ")){
            e.setCancelled(true);
        }
    }
}
