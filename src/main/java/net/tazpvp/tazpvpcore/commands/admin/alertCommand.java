package net.tazpvp.tazpvpcore.commands.admin;

import net.tazpvp.tazpvpcore.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class alertCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            if(args.length > 0) {
                if(p.hasPermission("tazpvp.alert") || p.hasPermission("tazpvp.*")){
                    alert(args);
                }
            } else {
                return false;
            }
        } else {
            alert(args);
        }
        return true;
    }
    public static void alert(String[] ar) {
        Bukkit.broadcastMessage(ChatColor.DARK_GRAY+" ["+ChatColor.RED+"ALERT"+ChatColor.DARK_GRAY+"] " + ChatColor.GREEN + StringUtils.buildString(ar, 0));
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        }
    }
}
