package net.tazpvp.tazpvpcore.commands.player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class nickCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player target = Bukkit.getServer().getPlayer(args[0]);
        String nick = args[1];
        if (target != null) {
            if (nick == null) {
                target.setDisplayName(target.getName());
                target.setPlayerListName(target.getName());
                target.sendMessage(ChatColor.DARK_AQUA + "Your nickname was reset.");
            } else if (nick.length() > 14) {
                commandSender.sendMessage(ChatColor.RED + "The nickname is too long");
            } else {
                target.setDisplayName(nick);
                target.setPlayerListName(nick);
                target.sendMessage(ChatColor.DARK_AQUA + "Your nickname was set to " + ChatColor.AQUA + nick);
            }
        }
        return true;
    }
}
