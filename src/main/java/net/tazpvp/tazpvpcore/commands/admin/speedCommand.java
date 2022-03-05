package net.tazpvp.tazpvpcore.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class speedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player p) {
            if (p.hasPermission("tazpvp.heal")) {
                if (args.length == 1) {
                    int speed = Integer.parseInt(args[0]);
                    p.setWalkSpeed(speed);
                    p.setFlySpeed(speed);
                    p.sendMessage(ChatColor.GOLD + "Speed: " + ChatColor.RED + speed);
                } else if (args.length == 2) {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    int speed = Integer.parseInt(args[1]);
                    target.setWalkSpeed(speed);
                    target.setFlySpeed(speed);
                    target.sendMessage(ChatColor.GOLD + "Speed: " + ChatColor.RED + speed);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
