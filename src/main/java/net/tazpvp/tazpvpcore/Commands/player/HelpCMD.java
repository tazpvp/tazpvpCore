package net.tazpvp.tazpvpcore.Commands.player;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCMD implements CommandExecutor {
    String s1 = " \n" +
            ChatColor.GRAY + "" + ChatColor.BOLD + " HOW TO GET:\n" +
            ChatColor.AQUA + " Shards: " + ChatColor.DARK_AQUA + "Levels, Heads, Generator\n" +
            ChatColor.YELLOW + " Coins: " + ChatColor.GOLD + "Kills, Achievements, Streaks, Ores\n" +
            ChatColor.LIGHT_PURPLE + " EXP: " + ChatColor.DARK_PURPLE + "Kills, Achievements,\n" +
            ChatColor.RED + " Extra HP: " + ChatColor.DARK_RED + "Rebirth, Fat Perk,\n" +
            " \n" +
            ChatColor.GREEN + " [1/2]" + ChatColor.GRAY + " type '/help 2' for the next page.";
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player p) {
            if (args.length < 1) {
                help(p, 1);
            } else if (args.length == 1 && args[0].equals("2")) {
                help(p, 2);}
        }
        return false;
    }

    public void help(Player p, int page) {
        if (page == 1) {
            p.sendMessage(s1);
        } else if (page == 2) {
            p.sendMessage("" +
                    ChatColor.WHITE + "/report " + ChatColor.GRAY + "Report rule breakers.\n" +
                    ChatColor.WHITE + "/apply " + ChatColor.GRAY + "Apply for a staff position.\n" +
                    ChatColor.WHITE + "/spawn " + ChatColor.GRAY + "Teleport back to the spawn.\n" +
                    ChatColor.WHITE + "/discord " + ChatColor.GRAY + "Join the community.\n" +
                    ChatColor.WHITE + "/duel " + ChatColor.GRAY + "Battle versus another player.\n" +
                    ChatColor.WHITE + "/ad " + ChatColor.GRAY + "Receive the server advertisement to copy.\n" +
                    ChatColor.GRAY + "\n" +
                    ChatColor.GREEN + "[2/2] " + ChatColor.GRAY + "type '/help' to go back"
            );
        } else {
            p.sendMessage(ChatColor.RED + "Invalid page.");
        }
    }
}
