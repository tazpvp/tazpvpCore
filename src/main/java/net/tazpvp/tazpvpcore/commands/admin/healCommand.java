package net.tazpvp.tazpvpcore.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class healCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player p) {
            if (p.hasPermission("tazpvp.heal")) {
                if (args.length < 1) {
                    p.setHealth(20);
                    p.setFoodLevel(20);
                    for (PotionEffect effect : p.getActivePotionEffects()) {
                        p.removePotionEffect(effect.getType());
                    }
                } else if (args.length == 1) {
                    Player targetP = Bukkit.getServer().getPlayer(args[0]);
                    p.setHealth(20);
                    targetP.setFoodLevel(20);
                    for (PotionEffect effect : targetP.getActivePotionEffects()) {
                        targetP.removePotionEffect(effect.getType());
                    }
                }
            }
        }
        return true;
    }
}
