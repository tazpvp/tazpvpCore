package net.tazpvp.tazpvpcore.Commands.player;

import net.tazpvp.tazpvpcore.TazpvpCore;
import net.tazpvp.tazpvpcore.Utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReplyCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player p) {
            String msg = StringUtils.buildString(strings, 0);
            if (TazpvpCore.messages.containsKey(p.getUniqueId())) {
                Player target = Bukkit.getPlayer(TazpvpCore.messages.get(p.getUniqueId()));
                if (target != null) {
                    target.sendMessage(ChatColor.DARK_AQUA + "From " + ChatColor.AQUA + p.getName() + ": "  + ChatColor.RED + msg);
                    p.sendMessage(ChatColor.DARK_AQUA + "To " + ChatColor.AQUA + target.getName() + ": " + ChatColor.RED + msg);
                    TazpvpCore.messages.put(p.getUniqueId(), target.getUniqueId());
                    TazpvpCore.messages.put(target.getUniqueId(), p.getUniqueId());
                    return true;
                }
            } else {
                p.sendMessage(ChatColor.RED + "You have no one to reply to!");
            }
        }
        return false;
    }
}
