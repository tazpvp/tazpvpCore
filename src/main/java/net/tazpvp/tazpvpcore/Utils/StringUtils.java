package net.tazpvp.tazpvpcore.Utils;

import org.bukkit.ChatColor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class StringUtils {
    public static String buildString(String[] args, int start) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = start; i < args.length; i++) {
            stringBuilder.append(args[i]).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.toString().length()-1);
    }
    public static String dateToString(long unix) {
        Date date = new Date(unix);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        format.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        return format.format(date);
    }
    public static String secondsToDDHHMMSS(long seconds) {
        return String.format("%02dd %02dh %02dm %02ds", seconds / 86400, (seconds / 3600 % 24), (seconds / 60) % 60, seconds % 60);
    }

    public static String secondsToHHMMSS(long seconds) {
        return String.format("%02dh %02dm %02ds", seconds / 3600, (seconds / 60) % 60, seconds % 60);
    }

    public static String s1 = " \n" +
            ChatColor.AQUA + "" + ChatColor.BOLD + " STATS\n" +
            " \n" +
            ChatColor.AQUA + " Shards: " + ChatColor.DARK_AQUA + "Levels, Heads, Generator\n" +
            ChatColor.AQUA + " Coins: " + ChatColor.DARK_AQUA + "Kills, Achievements, Streaks, Ores\n" +
            ChatColor.AQUA + " EXP: " + ChatColor.DARK_AQUA + "Kills, Achievements\n" +
            ChatColor.AQUA + " Perks/Rebirth: " + ChatColor.DARK_AQUA + "Speak with 'Rigel' in The Depths\n" +
            " \n" +
            ChatColor.GREEN + " [1/3]" + ChatColor.DARK_GREEN + " type '/help 2' for the next page.";
    public static String s2 = " \n" +
            ChatColor.AQUA + "" + ChatColor.BOLD + " ITEMS\n" +
            " \n" +
            ChatColor.YELLOW + " Shards: " + ChatColor.GOLD + "Trade player heads to 'Bub' in the sewers\n" +
            ChatColor.YELLOW + " Swords: " + ChatColor.GOLD + "Spin the Wheel at spawn, or get one per 10 levels\n" +
            ChatColor.YELLOW + " Food/Tools: " + ChatColor.GOLD + "Interact with 'Maxim' at spawn\n" +
            ChatColor.YELLOW + " Armor/Bow Upgrades: " + ChatColor.GOLD + "Interact with 'Frank' at the tower\n" +
            ChatColor.YELLOW + " Pickaxe Upgrades: " + ChatColor.GOLD + "Interact with 'Caesar' at the mine\n" +
            " \n" +
            ChatColor.GREEN + " [2/3]" + ChatColor.DARK_GREEN + " type '/help 3' for the next page.";
    public static String s3 = " \n" +
            ChatColor.AQUA + "" + ChatColor.BOLD + " COMMANDS\n" +
            " \n" +
            ChatColor.WHITE + " /report " + ChatColor.GRAY + "Report rule breakers.\n" +
            ChatColor.WHITE + " /apply " + ChatColor.GRAY + "Apply for a staff position.\n" +
            ChatColor.WHITE + " /spawn " + ChatColor.GRAY + "Teleport back to the spawn.\n" +
            ChatColor.WHITE + " /discord " + ChatColor.GRAY + "Join the community.\n" +
            ChatColor.WHITE + " /duel " + ChatColor.GRAY + "Battle versus another player.\n" +
            ChatColor.WHITE + " /ad " + ChatColor.GRAY + "Receive the server advertisement to copy.\n" +
            ChatColor.WHITE + " /afk " + ChatColor.GRAY + "Gain rewards every 5 minutes while afk.\n" +
            " \n" +
            ChatColor.GREEN + " [3/3]" + ChatColor.DARK_GREEN + " type '/help' for the next page.";
}
