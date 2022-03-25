package net.tazpvp.tazpvpcore.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CICOMMAND implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 1) {
            if (Bukkit.getPlayer(args[0]) != null) {
                Player target = Bukkit.getPlayer(args[0]);
                target.getInventory().clear();
                sender.sendMessage(ChatColor.GOLD + "Cleared " + ChatColor.RED +  target.getName() + ChatColor.GOLD + "'s inventory");
            }
        } else {
            if (sender instanceof Player p) {
                p.getInventory().clear();
            }
        }
        return true;
    }
}
