package net.tazpvp.tazpvpcore;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
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
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import static net.tazpvp.tazpvpcore.Utils.BlockUtils.isPlayerPlaced;
import static net.tazpvp.tazpvpcore.Utils.ChatUtils.startswith;

public class WorldGuard implements Listener {
    @EventHandler
    public void blockedCmds(PlayerCommandPreprocessEvent e){
        String msg = e.getMessage();
        if (startswith(msg, "/minecraft:")){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void blockChange(BlockFromToEvent e) {
        e.setCancelled(true);
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
        Material m = e.getItemDrop().getItemStack().getType();
        if (p.getGameMode() == GameMode.SURVIVAL) {
            if (TazpvpCore.keepItems.contains(m)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void itemCraft(org.bukkit.event.inventory.CraftItemEvent e) {
        if (!e.getWhoClicked().isOp()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    final void onTeleport(PlayerTeleportEvent e) {
        if (!e.getPlayer().hasPermission("tazpvp.*")) {
            if (e.getCause().equals(PlayerTeleportEvent.TeleportCause.SPECTATE)) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.RED + "You cannot teleport while spectating.");
            }
        }
    }
}
