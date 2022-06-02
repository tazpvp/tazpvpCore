package net.tazpvp.tazpvpcore;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import java.util.List;

import static net.tazpvp.tazpvpcore.Utils.BlockUtils.isPlayerPlaced;
import static net.tazpvp.tazpvpcore.Utils.ChatUtils.startswith;

public class WorldGuard implements Listener {
    @EventHandler
    public void blockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();
        if(p.getWorld().getName().equals("arena") && p.getGameMode() == GameMode.SURVIVAL) {
            if (!isPlayerPlaced(b)) { e.setCancelled(true); }
        }
    }

    @EventHandler
    public void blockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();
        if (p.getGameMode() == GameMode.SURVIVAL) {
            b.setMetadata("PlayerPlaced", new FixedMetadataValue(TazpvpCore.getInstance(), true));
        }
    }

    @EventHandler
    public void blockedCmds(PlayerCommandPreprocessEvent e){
        String msg = e.getMessage();
        if (startswith(msg, "/minecraft:") || startswith(msg, "/pl ") || startswith(msg, "/plugins ")){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void blockPhysics(BlockPhysicsEvent e) {
        if (e.getBlock().getWorld().getName().equals("arena") || e.getBlock().getWorld().getName().equals("duel")) {
            Material m = e.getBlock().getType();
            if (m == Material.WATER || m == Material.LAVA || m == Material.DIRT || m == Material.GRASS || m == Material.TORCH) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void blockChange(BlockFromToEvent e) {
        if (e.getBlock().getWorld().getName().equals("arena") || e.getBlock().getWorld().getName().equals("duel")) {
            Block b = e.getBlock();
            Material m = b.getType();
            if (m == Material.WATER || m == Material.LAVA || m == Material.DIRT || m == Material.GRASS) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void leafDecay(LeavesDecayEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void weatherChange(WeatherChangeEvent e) { e.setCancelled(true); }

    @EventHandler
    public void expDrop(PlayerDeathEvent e) {
        e.setDroppedExp(0);
    }

    @EventHandler
    public void vineGrowth(BlockGrowEvent e) {
        e.setCancelled(true);
    }

//    @EventHandler
//    public void feed(FoodLevelChangeEvent e) {
//        Player p = (Player) e.getEntity();
//    }

    @EventHandler
    public void blockUse(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        String w = p.getWorld().getName();
        Material b = e.getClickedBlock().getType();
        if (p.getGameMode() == GameMode.SURVIVAL) {
            if (w.equals("arena")) {
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    e.setCancelled(true);
                }
            }
        }
    }
}