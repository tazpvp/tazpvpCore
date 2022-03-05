package net.tazpvp.tazpvpcore.commands.admin;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmspCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.hasPermission("tazpvp.gmc")) {
            if (commandSender instanceof Player p) {
                p.setGameMode(GameMode.SPECTATOR);
            }
        }
        return true;
    }
}
