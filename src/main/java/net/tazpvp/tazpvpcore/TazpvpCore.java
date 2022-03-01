package net.tazpvp.tazpvpcore;

import net.tazpvp.tazpvpcore.commands.gmCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TazpvpCore extends JavaPlugin {

    public static TazpvpCore instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getLogger().info(" TazpvpCore has been enabled!");

        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerCommands(){

    }

    public void registerEvents(){
        getServer().getPluginManager().registerEvents(new gmCommand(), this);
    }

    public static TazpvpCore getInstance(){
        return instance;
    }
}
