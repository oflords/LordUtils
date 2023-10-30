package dev.oflords.lordutils.chat;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;

public class FancyChat {
    public static ClickEvent click(String command) {
        return new ClickEvent(ClickEvent.Action.RUN_COMMAND, command);
    }

    public static HoverEvent hover(String text) {
        return new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(ChatColor.translateAlternateColorCodes('&', text)));
    }
}
