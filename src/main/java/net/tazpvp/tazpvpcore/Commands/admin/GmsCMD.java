package net.tazpvp.tazpvpcore.Commands.admin;

import net.tazpvp.tazpvpcore.Utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmsCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender.hasPermission("tazpvp.gms") || commandSender.hasPermission("tazpvp.*")) {
            if (commandSender instanceof Player p) {
                if (args.length < 1) {
                    PlayerUtils.gmUser(p, GameMode.SURVIVAL);
                } else if (args.length == 1) {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if (p.hasPermission("tazpvp.gm.others")) {
                        if (target != null) {
                            PlayerUtils.gmUser(target, GameMode.SURVIVAL);
                        }
                    }
                }
            }
        }
        return true;
    }
}
