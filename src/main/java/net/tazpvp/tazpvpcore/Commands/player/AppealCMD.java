package net.tazpvp.tazpvpcore.Commands.player;

import net.tazpvp.tazpvpcore.Utils.LinkUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AppealCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player p) {
            p.sendMessage(ChatColor.DARK_GRAY + "");
            p.sendMessage(ChatColor.GRAY + " If you wish to be unmuted or unbanned:");
            p.spigot().sendMessage(LinkUtils.discordInvite(ChatColor.DARK_AQUA + " Contact support: Click below and go to the " + ChatColor.WHITE + "#support " + ChatColor.DARK_AQUA + "channel in our " + ChatColor.AQUA + "[Discord]"));
            p.sendMessage(ChatColor.DARK_GRAY + "");
        }
        return false;
    }
}
