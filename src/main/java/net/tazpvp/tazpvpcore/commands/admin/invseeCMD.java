package net.tazpvp.tazpvpcore.commands.admin;

import net.tazpvp.tazpvpcore.TazpvpCore;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class InvSeeCMD implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p) {
            if(p.hasPermission("tazpvp.invsee") || p.hasPermission("tazpvp.*")){
                if(args.length == 1) {
                    Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
                    Inventory targetInv = targetPlayer.getInventory();
                    TazpvpCore.inInvseeGui.put(p, true);
                    p.openInventory(targetInv);
                }
            }
        }
        return false;
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player p = (Player) event.getPlayer();
        if(TazpvpCore.inInvseeGui.containsKey(p)) {
            TazpvpCore.inInvseeGui.remove(p);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player p = (Player) event.getWhoClicked();
            if(TazpvpCore.inInvseeGui.containsKey(p)) {
                event.setCancelled(true);
            }
        }
    }
}
