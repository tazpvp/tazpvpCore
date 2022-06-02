package net.tazpvp.tazpvpcore.Commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class VanishCMD implements CommandExecutor {
    public final List<Player> Vanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player p) {
            String w = p.getWorld().getName();
            if (!p.hasPermission("tazpvp.vanish")) {
                p.sendMessage(ChatColor.RED + "You do not have permission to vanish.");
            } else if (!w.equalsIgnoreCase("arena")) {
                p.sendMessage(ChatColor.RED + "You must be at spawn to vanish.");
            } else if (!Vanished.contains(p)){
                Vanished.add(p);
                p.setGameMode(GameMode.SPECTATOR);
                p.setInvulnerable(true);
                Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "] " + p.getName());
                for (Player staff : Bukkit.getOnlinePlayers()){
                    if (staff.hasPermission("tazpvp.vanish")){
                        staff.sendMessage(ChatColor.GREEN + p.getName() + " is now vanished.");
                    }
                }
            } else {
                Vanished.remove(p);
                p.setGameMode(GameMode.SURVIVAL);
                p.setInvulnerable(false);
                Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + p.getName());
                for (Player staff : Bukkit.getOnlinePlayers()){
                    if (staff.hasPermission("tazpvp.vanish")){
                        staff.sendMessage(ChatColor.GREEN + p.getName() + " is no longer vanished.");
                    }
                }
            }
        }
        return false;
    }
}
