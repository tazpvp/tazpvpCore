package net.tazpvp.tazpvpcore.Commands.admin;

import net.tazpvp.tazpvpcore.TazpvpCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCMD implements CommandExecutor {
    @Override
    public boolean onCommand( CommandSender commandSender,  Command command, String s, String[] strings) {
        if (strings.length > 0) {
            if (commandSender.hasPermission("tazpvp.vanishOthers")) {
                Player target = Bukkit.getPlayer(strings[0]);
                if (target == null) {
                    commandSender.sendMessage(ChatColor.RED + "Player not found.");
                    return true;
                }
                doChecks(target);
            }
        } else {
            if (commandSender instanceof Player p) {
                if (p.hasPermission("tazpvp.vanish")) {
                    doChecks(p);
                }
            }
        }
        return true;
    }

    private void doChecks(final Player target) {
        vanish(target, false);
    }

    private void vanish(final Player p, final boolean invulnerable){
        p.setInvulnerable(invulnerable);
        String joinleavemsg;
        String staffmsg;
        if (!TazpvpCore.Vanished.contains(p)) {
            TazpvpCore.Vanished.add(p);
            p.hidePlayer(TazpvpCore.getInstance(), p);
            joinleavemsg = ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "] " + p.getName();
            staffmsg = ChatColor.GREEN + p.getName() + " is now vanished.";
        } else {
            TazpvpCore.Vanished.remove(p);
            p.showPlayer(TazpvpCore.getInstance(), p);
            joinleavemsg = ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + p.getName();
            staffmsg = ChatColor.GREEN + p.getName() + " is no longer vanished.";
        }
        Bukkit.broadcast(staffmsg, "tazpvp.vanish");
        Bukkit.broadcastMessage(joinleavemsg);
    }
}
