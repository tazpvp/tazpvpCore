package net.tazpvp.tazpvpcore.Commands.player;

import net.tazpvp.tazpvpcore.Utils.LinkUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player p) {
            p.sendMessage("");
            p.spigot().sendMessage(LinkUtils.discordInvite(ChatColor.YELLOW + "[Click Here] to join the discord!"));
            p.sendMessage("");
        }
        return false;
    }
}
