package net.tazpvp.tazpvpcore;

import net.tazpvp.tazpvpcore.Commands.admin.*;
import net.tazpvp.tazpvpcore.Commands.player.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public final class TazpvpCore extends JavaPlugin implements Listener {

    public static final HashMap<Player, Boolean> inInvseeGui = new HashMap<>();

    public static TazpvpCore instance;

    public static final ArrayList<Player> newPm = new ArrayList<>();
    public static ArrayList<Material> allowedBlocks = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getLogger().info(" TazpvpCore is enabled!");

        registerCommands();
        registerEvents();

        allowedBlocks.add(Material.ENDER_CHEST);

    }

    @Override
    public void onDisable() {
    }

    public void registerCommands(){
        Objects.requireNonNull(getCommand("fly")).setExecutor(new FlyCMD());
        Objects.requireNonNull(getCommand("gmc")).setExecutor(new GmcCMD());
        Objects.requireNonNull(getCommand("gms")).setExecutor(new GmsCMD());
        Objects.requireNonNull(getCommand("gma")).setExecutor(new GmaCMD());
        Objects.requireNonNull(getCommand("gmsp")).setExecutor(new GmspCMD());
        Objects.requireNonNull(getCommand("heal")).setExecutor(new HealCMD());
        Objects.requireNonNull(getCommand("invsee")).setExecutor(new InvSeeCMD());
        Objects.requireNonNull(getCommand("playtime")).setExecutor(new PlayTimeCMD());
        Objects.requireNonNull(getCommand("tp")).setExecutor(new TeleportCMD());
        Objects.requireNonNull(getCommand("clearchat")).setExecutor(new ClearChatCMD());
        Objects.requireNonNull(getCommand("speed")).setExecutor(new SpeedCMD());
        Objects.requireNonNull(getCommand("alert")).setExecutor(new AlertCMD());
        Objects.requireNonNull(getCommand("pm")).setExecutor(new PrivateMessageCMD());
        Objects.requireNonNull(getCommand("clear")).setExecutor(new InvClearCMD());
        Objects.requireNonNull(getCommand("help")).setExecutor(new HelpCMD());
        Objects.requireNonNull(getCommand("apply")).setExecutor(new ApplyCMD());
        Objects.requireNonNull(getCommand("appeal")).setExecutor(new AppealCMD());
        Objects.requireNonNull(getCommand("rules")).setExecutor(new RulesCMD());
        Objects.requireNonNull(getCommand("ad")).setExecutor(new AdCMD());
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new VanishCMD());
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new WorldGuard(), this);
        getServer().getPluginManager().registerEvents(this, this);
    }

    public static TazpvpCore getInstance(){
        return instance;
    }
}
