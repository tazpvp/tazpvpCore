package net.tazpvp.tazpvpcore.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.tazpvp.tazpvpcore.commands.admin.gmaCommand.gmUser;

public class gmsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender.hasPermission("tazpvp.gms") || commandSender.hasPermission("tazpvp.*")) {
            if (commandSender instanceof Player p) {
                if (args.length < 1) {
                    gmUser(p, GameMode.SURVIVAL);
                } else if (args.length == 1) {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if (p.hasPermission("tazpvp.gm.others")) {
                        if (target != null) {
                            gmUser(target, GameMode.SURVIVAL);
                        }
                    }
                }
            }
        }
        return true;
    }
}
