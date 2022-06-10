package net.tazpvp.tazpvpcore.Utils;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;

public class LinkUtils {
    public static TextComponent discordInvite(String name) {
        TextComponent msg = new TextComponent(ChatColor.BOLD + "" + ChatColor.YELLOW + name);
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§fDiscord Server").create()));
        msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/56rdkbSqa8"));

        return msg;
    }
    public static TextComponent storeLink(String name) {
        TextComponent msg = new TextComponent(ChatColor.BOLD + "" + ChatColor.YELLOW + name);
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§fServer Store").create()));
        msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://taznet.tebex.io/category/credits"));

        return msg;
    }
}
