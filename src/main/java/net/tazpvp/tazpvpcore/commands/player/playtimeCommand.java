package net.tazpvp.tazpvpcore.commands.player;

import net.tazpvp.tazpvpcore.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class playtimeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p) {
            if (args.length == 0) {
                int seconds = p.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
                p.sendMessage(ChatColor.GREEN + "Your playtime is " + ChatColor.WHITE + StringUtils.secondsToDDHHMMSS(seconds));
            } else {
                OfflinePlayer target = Bukkit.getPlayer(args[0]);
                if (target.isOnline()) {
                    int seconds = target.getPlayer().getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
                    p.sendMessage(ChatColor.GREEN + target.getName() + "'s playtime is " + ChatColor.WHITE + StringUtils.secondsToDDHHMMSS(seconds));
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Please enter a valid username.");
        }
        return true;
    }
}
