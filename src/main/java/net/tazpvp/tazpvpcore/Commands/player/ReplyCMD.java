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
            String msg = StringUtils.buildString(strings, 1);
            if (TazpvpCore.messages.containsKey(p)) {
                Player target = Bukkit.getPlayer(TazpvpCore.messages.get(p));
                if (target != null) {
                    target.sendMessage(ChatColor.DARK_AQUA + p.getName() + ": " + ChatColor.AQUA + msg);
                    p.sendMessage(ChatColor.DARK_AQUA + "Replied to " + ChatColor.AQUA + target.getName() + ": " + ChatColor.AQUA + msg);
                    return true;
                }
            }
        }
        return false;
    }
}
