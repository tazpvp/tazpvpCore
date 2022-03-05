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
                    float b = (float) 0.2;
                    p.setWalkSpeed(b);
                    p.setFlySpeed(b);
                    p.sendMessage(ChatColor.GOLD + "Speed: " + ChatColor.RED + "Default");
                } else if (args.length == 1) {
                    double speed = Integer.parseInt(args[0]);
                    int val = Integer.parseInt(args[0]);
                    speed(p, speed, val, args.length);
                } else if (args.length == 2) {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if(target != null) {
                        double speed = Integer.parseInt(args[1]);
                        int val = Integer.parseInt(args[0]);
                        speed(target, speed, val, args.length);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public void speed(Player p, double speed, int val, int length){
        if (speed <= 10) {
            double value = speed / 10;
            float a = (float) value;
            p.setWalkSpeed(a);
            p.setFlySpeed(a);
            p.sendMessage(ChatColor.GOLD + "Speed: " + ChatColor.RED + length);
        } else {
            p.sendMessage(ChatColor.RED + "Maximum value: 10");
        }
    }
}
