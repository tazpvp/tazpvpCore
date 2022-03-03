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
                        ChatColor.RED + "rebirth, or getting the \"fat\" perk.\n" +
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
                p.sendMessage(ChatColor.WHITE + "\n" +
                        ChatColor.WHITE + "1. Be respectful of others\n" +
                        ChatColor.GRAY + "Do not disrespect, impersonate, nor harass other server members. Usage of excessive toxicity and hate speech is prohibited. Do not threaten to Dox, DDoS, Swat or IP grab players.\n" +
                        ChatColor.GRAY + "\n" +
                        ChatColor.WHITE + "2. No advertising or self-promotion.\n" +
                        ChatColor.GRAY + "Do not post any external discord invites, servers, YouTube channels, or Twitch channels.\n" +
                        ChatColor.GRAY + "\n" +
                        ChatColor.WHITE + "3. No cheating\n" +
                        ChatColor.GRAY + "Do not use mods, hacks, or clients that give you an advantage over others. Do not abuse glitches and bugs in the server.\n" +
                        ChatColor.GRAY + "\n" +
                        ChatColor.WHITE + "4. Do not disrupt the server\n" +
                        ChatColor.GRAY + "Do not attempt to lag or crash the server. Do not trade in-game items for real money. No repeated or excessive messages.\n" +
                        ChatColor.GRAY + "\n" +
                        ChatColor.WHITE + "5. Do not attempt to bot/boost yourself\n" +
                        ChatColor.GRAY + "Using bots to gain a higher ranking in the game is not allowed. You have to gain stats legitimately."
                );
            }
        }
    }
}