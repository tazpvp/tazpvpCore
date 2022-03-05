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
                if (args.length == 0) {
                    speed(p, "default");
                } else if (args.length == 1) {
                    speed(p, args[0]);
                } else if (args.length == 2) {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if(target != null) {
                        speed(target, args[1]);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public void speed(Player p, String arg){
        double speed = Integer.parseInt(arg);
        int val = Integer.parseInt(arg);
        if (arg != "default") {
            if (speed <= 10) {
                double value = speed / 10;
                float a = (float) value;
                p.setWalkSpeed(a);
                p.setFlySpeed(a);
                p.sendMessage(ChatColor.GOLD + "Speed: " + ChatColor.RED + val);
            } else {
                p.sendMessage(ChatColor.RED + "Maximum value: 10");
            }
        } else {
            p.setWalkSpeed((float) 0.2);
            p.setFlySpeed((float) 0.1);
            p.sendMessage(ChatColor.GOLD + "Speed: " + ChatColor.RED + "Default");
        }
    }
}
