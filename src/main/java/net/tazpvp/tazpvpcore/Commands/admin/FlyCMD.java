package net.tazpvp.tazpvpcore.Commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.tazpvp.tazpvpcore.Utils.PlayerUtils.fly;
import static net.tazpvp.tazpvpcore.Utils.PlayerUtils.unfly;

public class FlyCMD implements CommandExecutor {
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
}
