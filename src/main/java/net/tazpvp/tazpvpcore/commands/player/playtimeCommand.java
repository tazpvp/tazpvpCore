package net.tazpvp.tazpvpcore.commands.player;

import net.tazpvp.tazpvpcore.TazpvpCore;
import net.tazpvp.tazpvpcore.utils.stringUtils;
import org.apache.commons.lang.StringUtils;
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
        Player player = null;
        if(sender instanceof Player) {
            player = (Player) sender;
        }
        if(player != null) {
            if(args.length == 0) {
                int seconds = player.getStatistic(Statistic.PLAY_ONE_MINUTE)/20;
                player.sendMessage(ChatColor.GREEN + "Your playtime is " + ChatColor.WHITE + stringUtils.secondsToDDHHMMSS(seconds));
            } else {
                OfflinePlayer target = Bukkit.getPlayer(args[0]);
                if(target.isOnline()) {
                    int seconds = target.getPlayer().getStatistic(Statistic.PLAY_ONE_MINUTE)/20;
                    player.sendMessage(ChatColor.GREEN + target.getName() + "'s playtime is " + ChatColor.WHITE + stringUtils.secondsToDDHHMMSS(seconds));
                }
            }
        }
        return true;
    }
}
