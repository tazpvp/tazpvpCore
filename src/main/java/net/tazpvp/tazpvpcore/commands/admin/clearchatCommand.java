package net.tazpvp.tazpvpcore.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class clearchatCommand implements CommandExecutor {
    @Override
    public boolean onCommand (CommandSender sender, Command command, String label, String[] args){
        if (sender instanceof Player p){
            if (p.hasPermission("tazpvp.clearchat") || p.hasPermission("tazpvp.*")){
                for (Player player : Bukkit.getOnlinePlayers()){
                   if (!player.hasPermission("tazpvp.clearchat")){
                       for (int i = 0; i<100; ++i ){
                           player.sendMessage(" ");
                       }
                   } else {
                       return false;
                   }
                }

            }
        }
        return true;
    }
}
