package net.tazpvp.tazpvpcore.commands.player;

import net.tazpvp.tazpvpcore.utils.LinkUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AppealCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player p) {
            p.sendMessage(ChatColor.DARK_GRAY + "▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
            p.sendMessage(ChatColor.AQUA + "If you would like to be un-muted or un-banned, please follow the steps below:");
            p.sendMessage(ChatColor.DARK_AQUA + "Contact support by going to the " + ChatColor.WHITE + "#support " + ChatColor.DARK_AQUA + "channel of our discord server.");
            p.sendMessage(ChatColor.DARK_AQUA + "False punishments will be quickly revoked; cheaters, however, will stay punished but can appeal 24 hours later.");
            p.spigot().sendMessage(LinkUtils.discordInvite("Click Here to appeal."));
            p.sendMessage(ChatColor.DARK_GRAY + "▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        }
        return false;
    }
}
