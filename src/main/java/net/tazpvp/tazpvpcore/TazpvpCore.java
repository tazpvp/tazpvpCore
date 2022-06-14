package net.tazpvp.tazpvpcore;

import net.tazpvp.tazpvpcore.Commands.admin.*;
import net.tazpvp.tazpvpcore.Commands.player.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class TazpvpCore extends JavaPlugin implements Listener {
    public static final HashMap<Player, Boolean> inInvseeGui = new HashMap<>();
    public static TazpvpCore instance;
    public static final ArrayList<Player> newPm = new ArrayList<>();
    public static ArrayList<Material> Blocks = new ArrayList<>();
    public static List<Player> Vanished = new ArrayList<>();
    public static List<Material> keepItems = new ArrayList<>();
    public static HashMap<UUID, UUID> messages = new HashMap<>();


    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getLogger().info(" TazpvpCore is enabled!");

        registerCommands();
        registerEvents();

        Blocks.add(Material.CHEST);
        Blocks.add(Material.TRAPPED_CHEST);
        Blocks.add(Material.FURNACE);
        Blocks.add(Material.OAK_TRAPDOOR);
        Blocks.add(Material.SPRUCE_TRAPDOOR);
        Blocks.add(Material.LECTERN);
        Blocks.add(Material.CRAFTING_TABLE);
        Blocks.add(Material.BARREL);
        Blocks.add(Material.SPRUCE_FENCE_GATE);
        Blocks.add(Material.DARK_OAK_FENCE_GATE);
        Blocks.add(Material.ANVIL);
        Blocks.add(Material.NOTE_BLOCK);
        Blocks.add(Material.FLOWER_POT);
        Blocks.add(Material.SPRUCE_DOOR);
        Blocks.add(Material.DARK_OAK_DOOR);
        
        keepItems.add(Material.WOODEN_SWORD);
        keepItems.add(Material.STONE_SWORD);
        keepItems.add(Material.IRON_SWORD);
        keepItems.add(Material.DIAMOND_SWORD);
        keepItems.add(Material.GOLDEN_SWORD);
        keepItems.add(Material.NETHERITE_SWORD);
        keepItems.add(Material.BOW);
        keepItems.add(Material.WOODEN_PICKAXE);
        keepItems.add(Material.STONE_PICKAXE);
        keepItems.add(Material.IRON_PICKAXE);
        keepItems.add(Material.GOLDEN_PICKAXE);
        keepItems.add(Material.DIAMOND_PICKAXE);
        keepItems.add(Material.DIAMOND_HELMET);
        keepItems.add(Material.DIAMOND_CHESTPLATE);
        keepItems.add(Material.DIAMOND_LEGGINGS);
        keepItems.add(Material.DIAMOND_BOOTS);
    }

    @Override
    public void onDisable() {
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
        getCommand("pm").setExecutor(new MessageCMD());
        getCommand("clear").setExecutor(new InvClearCMD());
        getCommand("help").setExecutor(new HelpCMD());
        getCommand("apply").setExecutor(new ApplyCMD());
        getCommand("appeal").setExecutor(new AppealCMD());
        getCommand("rules").setExecutor(new RulesCMD());
        getCommand("ad").setExecutor(new AdCMD());
        getCommand("vanish").setExecutor(new VanishCMD());
        getCommand("discord").setExecutor(new DiscordCMD());
        getCommand("store").setExecutor(new StoreCMD());
        getCommand("re").setExecutor(new ReplyCMD());
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new WorldGuard(), this);
        getServer().getPluginManager().registerEvents(this, this);
    }

    public static TazpvpCore getInstance(){
        return instance;
    }
}
