package net.tazpvp.tazpvpcore.Commands.player;

import net.tazpvp.tazpvpcore.Utils.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player p) {
            if (args.length < 1) {
                p.sendMessage(StringUtils.s1);
            } else if (args.length == 1 && args[0].equals("2")) {
                p.sendMessage(StringUtils.s2);
            } else if (args.length == 1 && args[0].equals("3")) {
                p.sendMessage(StringUtils.s3);
            } else {
                p.sendMessage(ChatColor.RED + "Invalid page.");
            }
        }
        return false;
    }
}
