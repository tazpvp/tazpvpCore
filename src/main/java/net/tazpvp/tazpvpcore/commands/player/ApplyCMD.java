package net.tazpvp.tazpvpcore.commands.player;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.tazpvp.tazpvpcore.utils.LinkUtils;
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
