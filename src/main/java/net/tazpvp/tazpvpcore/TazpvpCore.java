package net.tazpvp.tazpvpcore;

import net.tazpvp.tazpvpcore.commands.admin.*;
import net.tazpvp.tazpvpcore.commands.player.playtimeCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class TazpvpCore extends JavaPlugin {

    public static final HashMap<Player, Boolean> inInvseeGui = new HashMap<>();

    public static TazpvpCore instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getLogger().info(" TazpvpCore is enabled!");

        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerCommands(){
        getCommand("fly").setExecutor(new flyCommand());
        getCommand("gmc").setExecutor(new gmcCommand());
        getCommand("gms").setExecutor(new gmsCommand());
        getCommand("gma").setExecutor(new gmaCommand());
        getCommand("gmsp").setExecutor(new gmspCommand());
        getCommand("heal").setExecutor(new healCommand());
        getCommand("invsee").setExecutor(new invseeCommand());
        getCommand("playtime").setExecutor(new playtimeCommand());
        getCommand("tp").setExecutor(new tpCommand());
        getCommand("clearchat").setExecutor(new clearchatCommand());
        getCommand("speed").setExecutor(new speedCommand());


    }

    public void registerEvents(){

    }

    public static TazpvpCore getInstance(){
        return instance;
    }
}
