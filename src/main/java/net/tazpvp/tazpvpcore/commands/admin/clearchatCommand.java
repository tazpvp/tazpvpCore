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
                for (Player pl : Bukkit.getOnlinePlayers()){
                   if (!pl.hasPermission("tazpvp.clearchat")){
                       for (int i = 0; i<100; ++i ){
                           pl.sendMessage(" ");
                       }
                   } else {
                       pl.sendMessage(ChatColor.YELLOW + "Chat was cleared, but you are immune.");
                   }
                }

            }
        }
        return true;
    }
}
