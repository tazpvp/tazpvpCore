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
            p.sendMessage(ChatColor.AQUA + "If you want to be unmuted or unbanned, follow the steps below.");
            p.sendMessage(ChatColor.DARK_AQUA + "Contact support: Click below and go to the " + ChatColor.WHITE + "#support " + ChatColor.DARK_AQUA + "channel in our discord.");
            p.spigot().sendMessage(LinkUtils.discordInvite("[Click Here] to appeal."));
            p.sendMessage(ChatColor.DARK_GRAY + "");
        }
        return false;
    }
}
