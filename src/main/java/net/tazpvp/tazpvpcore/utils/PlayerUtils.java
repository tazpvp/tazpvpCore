package net.tazpvp.tazpvpcore.utils;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.Locale;

public class PlayerUtils {
    public static void gmUser(Player p, GameMode mode){
        String g = mode.toString();
        String gm = g.toLowerCase(Locale.ROOT);
        p.setGameMode(mode);
        p.sendMessage(ChatColor.GOLD + "Gamemode: " + ChatColor.RED + gm);
    }
}