package net.tazpvp.tazpvpcore.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class clearchatCommand implements CommandExecutor {
    @Override
    public boolean onCommand (CommandSender sender, Command command, String label, String[] args){
        if (sender instanceof Player p){
            if (p != null && p.hasPermission("tazpvp.staff.clearchat")){
                for (p : Bukkit.getOnlinePlayers()){
                   if (!p.hasPermission("tazpvp.staff.clearchat")){

                   }
                }

            }
        }



        return true;
    }
}
