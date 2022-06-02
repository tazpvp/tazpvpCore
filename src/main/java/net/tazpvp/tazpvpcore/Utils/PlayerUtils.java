package net.tazpvp.tazpvpcore.Utils;

import net.tazpvp.tazpvpcore.TazpvpCore;
import org.bukkit.Bukkit;
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

    public static void hidePlayer(Player p) {
        p.hidePlayer(TazpvpCore.getInstance(), p);
    }

    public static void showPlayer(Player p) {
        p.showPlayer(TazpvpCore.getInstance(), p);
    }
}
