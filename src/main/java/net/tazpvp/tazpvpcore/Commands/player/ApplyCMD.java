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
            p.sendMessage(ChatColor.DARK_AQUA + " Click below, then go to the " + ChatColor.WHITE + "#commands " + ChatColor.DARK_AQUA + "channel\n" + " type " + ChatColor.WHITE + "/apply (staff)");
            p.spigot().sendMessage(LinkUtils.discordInvite(" [Click Here]"));
            p.sendMessage(ChatColor.DARK_GRAY + "");

        }

        return false;
    }
}
