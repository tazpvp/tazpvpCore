package net.tazpvp.tazpvpcore;

import net.tazpvp.tazpvpcore.commands.admin.*;
import net.tazpvp.tazpvpcore.commands.player.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public final class TazpvpCore extends JavaPlugin {

    public static final HashMap<Player, Boolean> inInvseeGui = new HashMap<>();

    public static TazpvpCore instance;

    public static final ArrayList<Player> newPm = new ArrayList<>();

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
        getCommand("fly").setExecutor(new flyCMD());
        getCommand("gmc").setExecutor(new gmcCMD());
        getCommand("gms").setExecutor(new gmsCMD());
        getCommand("gma").setExecutor(new gmaCMD());
        getCommand("gmsp").setExecutor(new gmspCMD());
        getCommand("heal").setExecutor(new healCMD());
        getCommand("invsee").setExecutor(new invseeCMD());
        getCommand("playtime").setExecutor(new playtimeCMD());
        getCommand("tp").setExecutor(new tpCMD());
        getCommand("clearchat").setExecutor(new clearchatCMD());
        getCommand("speed").setExecutor(new speedCMD());
        getCommand("alert").setExecutor(new alertCMD());
        getCommand("pm").setExecutor(new pmCMD());
        getCommand("clear").setExecutor(new invclearCMD());
        getCommand("help").setExecutor(new helpCMD());
        getCommand("apply").setExecutor(new applyCMD());
        getCommand("appeal").setExecutor(new AppealCMD());
        getCommand("rules").setExecutor(new RulesCMD());


    }

    public void registerEvents(){

    }

    public static TazpvpCore getInstance(){
        return instance;
    }
}
