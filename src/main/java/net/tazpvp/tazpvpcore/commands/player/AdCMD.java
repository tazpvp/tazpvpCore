package net.tazpvp.tazpvpcore.commands.player;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class AdCMD implements CommandExecutor {
    final String ad = "/ad Tazpvp &f/ &c1.8 &f/ &cDuels &f/ &cGrind &f/ &cFFA";
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player p) {
            TextComponent copy = new TextComponent("\n" + ChatColor.YELLOW + "  Click " + ChatColor.GOLD + "" + ChatColor.BOLD + "Here" + ChatColor.YELLOW + " to copy the advertisement for this server.\n");
            copy.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, ad));
            p.spigot().sendMessage(copy);
        }
        return false;
    }
}
