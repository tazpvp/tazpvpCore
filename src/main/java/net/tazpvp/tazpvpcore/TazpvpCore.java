package net.tazpvp.tazpvpcore;

import net.tazpvp.tazpvpcore.Commands.admin.*;
import net.tazpvp.tazpvpcore.Commands.player.*;
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
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerCommands(){
        getCommand("fly").setExecutor(new FlyCMD());
        getCommand("gmc").setExecutor(new GmcCMD());
        getCommand("gms").setExecutor(new GmsCMD());
        getCommand("gma").setExecutor(new GmaCMD());
        getCommand("gmsp").setExecutor(new GmspCMD());
        getCommand("heal").setExecutor(new HealCMD());
        getCommand("invsee").setExecutor(new InvSeeCMD());
        getCommand("playtime").setExecutor(new PlayTimeCMD());
        getCommand("tp").setExecutor(new TeleportCMD());
        getCommand("clearchat").setExecutor(new ClearChatCMD());
        getCommand("speed").setExecutor(new SpeedCMD());
        getCommand("alert").setExecutor(new AlertCMD());
        getCommand("pm").setExecutor(new PrivateMessageCMD());
        getCommand("clear").setExecutor(new InvClearCMD());
        getCommand("help").setExecutor(new HelpCMD());
        getCommand("apply").setExecutor(new ApplyCMD());
        getCommand("appeal").setExecutor(new AppealCMD());
        getCommand("rules").setExecutor(new RulesCMD());
        getCommand("ad").setExecutor(new AdCMD());
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new WorldGuard(), this);
    }

    public static TazpvpCore getInstance(){
        return instance;
    }
}
