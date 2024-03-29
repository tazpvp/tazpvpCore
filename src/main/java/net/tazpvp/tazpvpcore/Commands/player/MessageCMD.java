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

public class MessageCMD implements CommandExecutor, Listener{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        if (TazpvpCore.newPm.contains(p)) {
            TazpvpCore.newPm.remove(p);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if (args.length >= 2) {
                Player target = p.getServer().getPlayer(args[0]);
                if (target == null) { p.sendMessage(ChatColor.RED + "This player does not exist."); return true; }
                if (target.getName().equals(p.getName())) { p.sendMessage(ChatColor.RED + "You cannot private message yourself!"); return true;}

                String msg = StringUtils.buildString(args, 1);
                target.sendMessage( ChatColor.DARK_AQUA + "From " + ChatColor.RED + p.getName() + ": "  + ChatColor.AQUA + msg);
                p.sendMessage(ChatColor.DARK_AQUA + "To " + ChatColor.RED + (args[0]) + ": " + ChatColor.AQUA + msg);
                target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1, 1);
                if (!TazpvpCore.messages.containsKey(target.getUniqueId())) {
                    target.sendMessage(ChatColor.AQUA + "To respond to this pm, type " + ChatColor.GRAY + "/re <message>");
                }
                TazpvpCore.messages.put(p.getUniqueId(), target.getUniqueId());
                TazpvpCore.messages.put(target.getUniqueId(), p.getUniqueId());
            } else {
                return true;
            }
        }
        return true;
    }
}
