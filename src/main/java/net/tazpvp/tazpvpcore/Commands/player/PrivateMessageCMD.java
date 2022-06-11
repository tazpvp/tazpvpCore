package net.tazpvp.tazpvpcore.Commands.player;

import net.tazpvp.tazpvpcore.TazpvpCore;
import net.tazpvp.tazpvpcore.Utils.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PrivateMessageCMD implements CommandExecutor, Listener{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        if (TazpvpCore.newPm.contains(p)) {
            TazpvpCore.newPm.remove(p);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length >= 2) {
                Player target = p.getServer().getPlayer(args[0]);
                if (target == null) {
                    p.sendMessage(ChatColor.RED + "This player does not exist.");
                } else if (target.getName().equals(p.getName())) {
                    p.sendMessage(ChatColor.RED + "You cannot private message yourself!");
                } else {
                    String msg = StringUtils.buildString(args, 1);
                    target.sendMessage( ChatColor.DARK_AQUA + "From " + ChatColor.AQUA + p.getName() + ": "  + ChatColor.YELLOW + msg);
                    p.sendMessage(ChatColor.DARK_AQUA + "To " + ChatColor.AQUA + (args[0]) + ": " + ChatColor.YELLOW + msg);
                    target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1, 1);
                    if (!TazpvpCore.newPm.contains(p)) {
                        TazpvpCore.newPm.add(p);
                    }
                    if (!TazpvpCore.newPm.contains(target)) {
                        target.sendMessage(ChatColor.AQUA + "To respond to this private message, type " + ChatColor.GRAY + "/PM <player> <message>");
                        TazpvpCore.newPm.add(target);
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
