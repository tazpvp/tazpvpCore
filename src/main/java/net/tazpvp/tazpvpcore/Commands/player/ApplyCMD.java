package net.tazpvp.tazpvpcore.Commands.player;

import net.tazpvp.tazpvpcore.Utils.LinkUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ApplyCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player p) {
            p.sendMessage(ChatColor.DARK_GRAY + "");
            p.spigot().sendMessage(LinkUtils.discordInvite(ChatColor.AQUA + "[Click Here] " + ChatColor.DARK_AQUA + "to join the discord"));
            p.sendMessage(ChatColor.DARK_AQUA + " Then go to the " + ChatColor.AQUA + "#commands " + ChatColor.DARK_AQUA + "channel\n" + " type " + ChatColor.AQUA + "/apply (staff)");
            p.sendMessage(ChatColor.DARK_GRAY + "");
        }
        return false;
    }
}
