package net.tazpvp.tazpvpcore.commands.player;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class helpCMD implements CommandExecutor {
    String s1 = "" +
            ChatColor.YELLOW + "Gain EXP from daily rewards, dealing damage,\n" +
            ChatColor.YELLOW + "achievements, and killing mobs or players.\n" +
            ChatColor.YELLOW + "\n" +
            ChatColor.GOLD + "Gain money from killing, achievements, streaks,\n" +
            ChatColor.GOLD + "mining, and daily rewards to use at the shop\n" +
            ChatColor.YELLOW + "\n" +
            ChatColor.RED + "Get up to five extra hearts from streaks,\n" +
            ChatColor.RED + "rebirth, or getting the \"fat\" perk.\n" +
            ChatColor.YELLOW + "\n" +
            ChatColor.DARK_AQUA + "All inventory items are lost on death.\n" +
            "" +
            ChatColor.GREEN + "[1/2]" + ChatColor.GRAY + " type '/help 2' for the next page.";
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player p) {
            if (args.length < 1) {
                help(p, 1);
            } else if (args.length == 2 && args[1].equals("2")) {
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
