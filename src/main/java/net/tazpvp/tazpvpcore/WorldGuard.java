package net.tazpvp.tazpvpcore;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.metadata.FixedMetadataValue;

import static net.tazpvp.tazpvpcore.Utils.BlockUtils.isPlayerPlaced;
import static net.tazpvp.tazpvpcore.Utils.ChatUtils.startswith;

public class WorldGuard implements Listener {
    @EventHandler
    public void blockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();
        if (p.getGameMode() == GameMode.SURVIVAL) {
            if(p.getWorld().getName().equals("arena") || p.getWorld().getName().equals("ban")) {
                if (!isPlayerPlaced(b)) { e.setCancelled(true); }
            }
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
        Material m = e.getBlock().getType();
        if (m == Material.WATER || m == Material.LAVA || m == Material.DIRT || m == Material.GRASS || m == Material.TORCH) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void blockChange(BlockFromToEvent e) {
        Block b = e.getBlock();
        Material m = b.getType();
        if (m == Material.WATER || m == Material.LAVA || m == Material.DIRT || m == Material.GRASS) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void leafDecay(LeavesDecayEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void weatherChange(WeatherChangeEvent e) {
        e.setCancelled(true);
    }

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
        if (p.getGameMode() == GameMode.SURVIVAL) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (TazpvpCore.Blocks.contains(e.getClickedBlock().getType())) {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void armorMove(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (p.getGameMode() == GameMode.SURVIVAL) {
            if (e.getSlotType() == InventoryType.SlotType.ARMOR) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void itemDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.SURVIVAL) {
            e.setCancelled(true);
        }
    }
}
