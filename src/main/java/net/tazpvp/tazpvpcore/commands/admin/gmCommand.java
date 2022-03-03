package net.tazpvp.tazpvpcore.commands.admin;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;


public class gmCommand implements Listener {

    @EventHandler
    public void command(PlayerCommandSendEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("tazpvp.gmc") || p.hasPermission("tazpvp.*")) {
            if (e.getCommands().size() == 1) {
                if (e.getCommands().contains("gmc")) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(ChatColor.GOLD + "You are now in " + ChatColor.RED + "Creative");
                } else if (e.getCommands().contains("gms")) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(ChatColor.GOLD + "You are now in " + ChatColor.RED + "Survival");
                } else if (e.getCommands().contains("gma")) {
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(ChatColor.GOLD + "You are now in " + ChatColor.RED + "Adventure");
                } else if (e.getCommands().contains("gmsp")) {
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(ChatColor.GOLD + "You are now in " + ChatColor.RED + "Spectator");
                }
            }
        }
    }
}
