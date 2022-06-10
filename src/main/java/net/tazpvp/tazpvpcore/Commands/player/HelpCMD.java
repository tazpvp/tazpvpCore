package net.tazpvp.tazpvpcore.Commands.player;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCMD implements CommandExecutor {
    String s1 = " \n" +
            ChatColor.RED + " How to get Stats:\n" +
            " \n" +
            ChatColor.AQUA + " Shards: " + ChatColor.DARK_AQUA + "Levels, Heads, Generator\n" +
            ChatColor.AQUA + " Coins: " + ChatColor.DARK_AQUA + "Kills, Achievements, Streaks, Ores\n" +
            ChatColor.AQUA + " EXP: " + ChatColor.DARK_AQUA + "Kills, Achievements\n" +
            ChatColor.AQUA + " Perks/Rebirth: " + ChatColor.DARK_AQUA + "Speak with 'Rigel' in The Depths\n" +
            " \n" +
            ChatColor.GREEN + " [1/3]" + ChatColor.DARK_GREEN + " type '/help 2' for the next page.";
    String s2 = " \n" +
            ChatColor.RED + " How to get Items:\n" +
            " \n" +
            ChatColor.AQUA + " Swords: " + ChatColor.DARK_AQUA + "Spin the Wheel o Blades at spawn\n" +
            ChatColor.AQUA + " Food/Tools: " + ChatColor.DARK_AQUA + "Interact with 'Maxim' at spawn\n" +
            ChatColor.AQUA + " Armor/Bow Upgrades: " + ChatColor.DARK_AQUA + "Interact with 'Frank' at the tower\n" +
            ChatColor.AQUA + " Pickaxe Upgrades: " + ChatColor.DARK_AQUA + "Interact with 'Caesar' at the mine\n" +
            " \n" +
            ChatColor.GREEN + " [2/3]" + ChatColor.DARK_GREEN + " type '/help 3' for the next page.";
    String s3 = " \n" +
            ChatColor.RED + " Helpful Commands:\n" +
            " \n" +
            ChatColor.WHITE + " /report " + ChatColor.GRAY + "Report rule breakers.\n" +
            ChatColor.WHITE + " /apply " + ChatColor.GRAY + "Apply for a staff position.\n" +
            ChatColor.WHITE + " /spawn " + ChatColor.GRAY + "Teleport back to the spawn.\n" +
            ChatColor.WHITE + " /discord " + ChatColor.GRAY + "Join the community.\n" +
            ChatColor.WHITE + " /duel " + ChatColor.GRAY + "Battle versus another player.\n" +
            ChatColor.WHITE + " /ad " + ChatColor.GRAY + "Receive the server advertisement to copy.\n" +
            " \n" +
            ChatColor.GREEN + " [3/3]" + ChatColor.DARK_GREEN + " type '/help' for the next page.";
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player p) {
            if (args.length < 1) {
                p.sendMessage(s1);
            } else if (args.length == 1 && args[0].equals("2")) {
                p.sendMessage(s2);
            } else if (args.length == 1 && args[0].equals("3")) {
                p.sendMessage(s3);
            } else {
                p.sendMessage(ChatColor.RED + "Invalid page.");
            }
        }
        return false;
    }
}
