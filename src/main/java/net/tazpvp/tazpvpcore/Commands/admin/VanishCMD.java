package net.tazpvp.tazpvpcore.Commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static net.tazpvp.tazpvpcore.Utils.PlayerUtils.hidePlayer;
import static net.tazpvp.tazpvpcore.Utils.PlayerUtils.showPlayer;

public class VanishCMD implements CommandExecutor {
    public final List<Player> Vanished = new ArrayList<>();

    @Override
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] strings) {
        if (strings.length > 1) {
            if (commandSender.hasPermission("tazpvp.vanishOthers")) {
                Player target = Bukkit.getPlayer(strings[1]);
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
        return false;
    }

    private void doChecks(final Player target) {
        if (Vanished.contains(target)) {
            Vanished.remove(target);
            vanish(target, GameMode.SURVIVAL, false, false);
        } else {
            Vanished.add(target);
            vanish(target, GameMode.SPECTATOR, true, true);
        }
    }

    private void vanish(final Player p, final GameMode gamemode, final boolean invulnerable, final boolean hidden){
        p.setGameMode(gamemode);
        p.setInvulnerable(invulnerable);
        String joinleavemsg;
        String staffmsg;
        if (hidden){
            hidePlayer(p);
            joinleavemsg = ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "] " + p.getName();
            staffmsg = ChatColor.GREEN + p.getName() + " is now vanished.";
        } else {
            showPlayer(p);
            joinleavemsg = ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + p.getName();
            staffmsg = ChatColor.GREEN + p.getName() + " is no longer vanished.";
        }
        Bukkit.broadcast(staffmsg, "tazpvp.vanish");
        Bukkit.broadcastMessage(joinleavemsg);
    }
}
