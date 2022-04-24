package net.tazpvp.tazpvpcore.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flyCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if(p.hasPermission("tazpvp.fly") || p.hasPermission("tazpvp.*")) {
                if (args.length < 1) {
                    if(p.getAllowFlight()) {
                        unfly(p);
                    } else {
                        fly(p);
                    }
                } else if (args.length == 1) {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if (p.hasPermission("tazpvp.fly.others") && target != null) {
                        if (target.getAllowFlight()) {
                            unfly(target);
                        } else {
                            fly(target);
                        }
                    }
                }
            }
        }
        return true;
    }
    public void fly(Player p) {
        p.setAllowFlight(true);
        p.sendMessage(ChatColor.DARK_AQUA + "Flight: " + ChatColor.AQUA + "enabled");
    }
    public void unfly(Player p) {
        p.setAllowFlight(false);
        p.sendMessage(ChatColor.DARK_AQUA + "Flight: " + ChatColor.AQUA + "disabled");
    }
}
