package net.tazpvp.tazpvpcore;

import net.tazpvp.tazpvpcore.commands.admin.*;
import net.tazpvp.tazpvpcore.commands.player.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public final class TazpvpCore extends JavaPlugin implements Listener {

    public static final HashMap<Player, Boolean> inInvseeGui = new HashMap<>();

    public static TazpvpCore instance;

    public static final ArrayList<Player> newPm = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getLogger().info(" TazpvpCore is enabled!");

        registerCommands();

        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void cmdPreProeces(PlayerCommandPreprocessEvent e){
        String msg = e.getMessage();
        if (startswith(msg, "/minecraft:") || startswith(msg, "/pl ") || startswith(msg, "/plugins ")){
            e.setCancelled(true);
        }
    }

    public boolean startswith(String s, String s1) {
        return s.startsWith(s1);
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

    public static TazpvpCore getInstance(){
        return instance;
    }
}
