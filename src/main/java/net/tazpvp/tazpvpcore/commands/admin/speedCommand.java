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
            if (p.hasPermission("tazpvp.speed")) {
                if (args.length == 0) {
                    speed(p, 0, "0");
                } else if (args.length == 1) {
                    speed(p, Double.parseDouble(args[0]), args[0]);
                } else if (args.length == 2) {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if(target != null) {
                        speed(target, Double.parseDouble(args[1]), args[1]);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public void speed(Player p, double speed, String whatTheySaid){ //rownox needs this arg because he has brain damage.
        if (speed != 0) {
            if (speed <= 10) {
                float a = (float) (speed / 10);
                p.setWalkSpeed(a);
                p.setFlySpeed(a);
                p.sendMessage(ChatColor.GOLD + "Speed: " + ChatColor.RED + whatTheySaid);
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
