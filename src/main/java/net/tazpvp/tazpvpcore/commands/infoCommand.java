package net.tazpvp.tazpvpcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class infoCommand {
    @EventHandler
    public void command(PlayerCommandSendEvent e) {
        Player p = e.getPlayer();
        if (e.getCommands().size() == 1) {
            if (e.getCommands().contains("help")) {
                p.sendMessage(ChatColor.AQUA + "-----" + ChatColor.DARK_AQUA + "-----" + ChatColor.AQUA + "-----" + ChatColor.RED + ChatColor.BOLD + "" + "TAZSPREE " + ChatColor.AQUA + "-----" + ChatColor.DARK_AQUA + "-----" + ChatColor.AQUA + "-----\n" +
                        ChatColor.YELLOW + "Gain EXP from daily rewards, dealing damage,\n" +
                        ChatColor.YELLOW + "achievements, and killing mobs or players.\n" +
                        ChatColor.YELLOW + "\n" +
                        ChatColor.GOLD + "Gain money from killing, achievements, streaks,\n" +
                        ChatColor.GOLD + "mining, and daily rewards to use at the shop\n" +
                        ChatColor.YELLOW + "\n" +
                        ChatColor.RED + "Get up to five extra hearts from streaks,\n" +
                        ChatColor.RED + "rebirthing, or getting the \"fat\" perk.\n" +
                        ChatColor.YELLOW + "\n" +
                        ChatColor.DARK_AQUA + "All inventory items are lost on death.\n" +
                        ChatColor.GREEN + "PAGE [1/2]" + ChatColor.GRAY + "/help2 for next page."
                );
            } else if (e.getCommands().contains("help2")) {
                p.sendMessage(ChatColor.AQUA + "-----" + ChatColor.DARK_AQUA + "-----" + ChatColor.AQUA + "-----" + ChatColor.RED + ChatColor.BOLD + "" + "TAZSPREE " + ChatColor.AQUA + "-----" + ChatColor.DARK_AQUA + "-----" + ChatColor.AQUA + "-----\n" +
                        ChatColor.WHITE + "/report " + ChatColor.GRAY + "Report rule breakers.\n" +
                        ChatColor.WHITE + "/apply " + ChatColor.GRAY + "Apply for a staff position.\n" +
                        ChatColor.WHITE + "/spawn " + ChatColor.GRAY + "Teleport back to the spawn.\n" +
                        ChatColor.WHITE + "/discord " + ChatColor.GRAY + "Join the community.\n" +
                        ChatColor.WHITE + "/duel " + ChatColor.GRAY + "Battle versus another player.\n" +
                        ChatColor.WHITE + "/ad " + ChatColor.GRAY + "Receive the server advertisement to copy.\n" +
                        ChatColor.GRAY + "\n" +
                        ChatColor.GREEN + "PAGE [2/2] " + ChatColor.GRAY + "/help to go back"
                );
            } else if (e.getCommands().contains("rules")) {
                p.sendMessage(ChatColor.GOLD + "You are now in " + ChatColor.RED + "Survival");
            }
        }
    }
}