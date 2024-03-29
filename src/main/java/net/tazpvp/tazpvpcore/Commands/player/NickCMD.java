package net.tazpvp.tazpvpcore.Commands.player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NickCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player p) {
            if (p.hasPermission("tazpvp.nick.others") || p.hasPermission("tazpvp.*")) {
                String nick = args[1];
                Player target = Bukkit.getServer().getPlayer(args[0]);
                nick(target, nick);
            } else if (p.hasPermission("tazpvp.nick")) {
                String nick = args[0];
                nick(p, nick);
            } else {
                p.sendMessage(ChatColor.RED + "You must purchase a rank to receive this permission.");
            }
        }
        return false;
    }

    public void nick(Player p, String nick) {
        if (nick == null) {
            p.setDisplayName(p.getName());
            p.setPlayerListName(p.getName());
            p.sendMessage(ChatColor.DARK_AQUA + "Your nickname was reset.");
        } else {
            p.setDisplayName(nick);
            p.setPlayerListName(nick);
            p.sendMessage(ChatColor.DARK_AQUA + "Your nickname was set to " + ChatColor.AQUA + nick);
        }
    }
}
