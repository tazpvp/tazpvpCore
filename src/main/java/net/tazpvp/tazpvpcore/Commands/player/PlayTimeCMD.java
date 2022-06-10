package net.tazpvp.tazpvpcore.Commands.player;

import net.tazpvp.tazpvpcore.Utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayTimeCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p) {
            if (args.length == 0) {
                int seconds = p.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
                p.sendMessage(ChatColor.DARK_AQUA + "Playtime: " + ChatColor.AQUA + StringUtils.secondsToDDHHMMSS(seconds));
            } else {
                OfflinePlayer target = Bukkit.getPlayer(args[0]);
                if (target.isOnline()) {
                    int seconds = target.getPlayer().getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
                    p.sendMessage(ChatColor.DARK_AQUA + target.getName() + "'s playtime: " + ChatColor.AQUA + StringUtils.secondsToDDHHMMSS(seconds));
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Please enter a valid username.");
        }
        return true;
    }
}
