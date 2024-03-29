package net.tazpvp.tazpvpcore.Utils;

import net.tazpvp.tazpvpcore.TazpvpCore;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.Locale;

public class PlayerUtils {
    public static void gmUser(Player p, GameMode mode){
        String g = mode.toString();
        String gm = g.toLowerCase(Locale.ROOT);
        p.setGameMode(mode);
        p.sendMessage(ChatColor.DARK_AQUA + "Gamemode: " + ChatColor.AQUA + gm);
    }

    public static void fly(Player p) {
        p.setAllowFlight(true);
        p.sendMessage(ChatColor.DARK_AQUA + "Flight: " + ChatColor.AQUA + "enabled");
    }
    public static void unfly(Player p) {
        p.setAllowFlight(false);
        p.sendMessage(ChatColor.DARK_AQUA + "Flight: " + ChatColor.AQUA + "disabled");
    }
}
