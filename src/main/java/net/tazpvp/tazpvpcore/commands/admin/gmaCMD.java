package net.tazpvp.tazpvpcore.commands.admin;

import net.tazpvp.tazpvpcore.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmaCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender.hasPermission("tazpvp.gma") || commandSender.hasPermission("tazpvp.*")) {
            if (commandSender instanceof Player p) {
                if (args.length < 1) {
                    PlayerUtils.gmUser(p, GameMode.ADVENTURE);
                } else if (args.length == 1) {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if (p.hasPermission("tazpvp.gm.others")) {
                        if (target != null) {
                            PlayerUtils.gmUser(target, GameMode.ADVENTURE);
                        }
                    }
                }
            }
        }
        return true;
    }
}
