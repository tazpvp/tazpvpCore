package net.tazpvp.tazpvpcore.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if(p.hasPermission("tazpvp.fly")) {
                if (args.length < 1) {
                    if(p.getAllowFlight()) {
                        unfly(p);
                    } else {
                        fly(p);
                    }
                } else if (args.length == 1) {
                    Player targetP = Bukkit.getServer().getPlayer(args[0]);
                    if (p.hasPermission("tazpvp.fly.others")) {
                        if (targetP.getAllowFlight()) {
                            unfly(targetP);
                        } else {
                            fly(targetP);
                        }
                    }
                }
            }
        }
        return true;
    }
    public void fly(Player p) {
        p.setAllowFlight(true);
        p.sendMessage(ChatColor.GOLD + "Flying: " + ChatColor.RED + "enabled");
    }
    public void unfly(Player p) {
        p.setAllowFlight(false);
        p.sendMessage(ChatColor.GOLD + "Flying: " + ChatColor.RED + "disabled");
    }
}
