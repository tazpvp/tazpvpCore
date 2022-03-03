package net.tazpvp.tazpvpcore.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class flyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = null;
        if (sender instanceof Player) {
            p = (Player) sender;
        }
        if(p != null && p.hasPermission("tazpvp.fly")) {
            if (args.length < 1) {
                if(p.getAllowFlight()) {
                    p.setAllowFlight(false);
                    p.sendMessage(ChatColor.GOLD + "Flying: " + ChatColor.RED + "disabled");
                } else {
                    p.setAllowFlight(true);
                    p.sendMessage(ChatColor.GOLD + "Flying: " + ChatColor.RED + "enabled");
                }
            } else if (args.length == 1) {
                Player targetP = Bukkit.getServer().getPlayer(args[0]);
                if (p.hasPermission("tazpvp.fly.others")) {
                    if (targetP.getAllowFlight()) {
                        targetP.setAllowFlight(false);
                        targetP.sendMessage(ChatColor.GOLD + "Flying: " + ChatColor.RED + "disabled");
                    } else {
                        targetP.setAllowFlight(true);
                        targetP.sendMessage(ChatColor.GOLD + "Flying: " + ChatColor.RED + "enabled");
                    }
                }
            }
        }
        return true;
    }
}
