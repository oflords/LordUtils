package dev.oflords.lordutils.player.team;

import dev.oflords.lordutils.chat.CC;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Color;

@AllArgsConstructor
@Getter
public enum TeamColour {
    RED(Color.RED, CC.RED, ChatColor.RED, 14, "RED", TeamMaterial.RED),
    BLUE(Color.BLUE, CC.BLUE, ChatColor.BLUE, 11, "BLUE", TeamMaterial.BLUE),
    GREEN(Color.LIME, CC.GREEN, ChatColor.GREEN, 5, "GREEN", TeamMaterial.GREEN),
    YELLOW(Color.YELLOW, CC.YELLOW, ChatColor.YELLOW, 4, "YELLOW", TeamMaterial.YELLOW),
    AQUA(Color.AQUA, CC.AQUA, ChatColor.AQUA, 3, "AQUA", TeamMaterial.AQUA),
    WHITE(Color.WHITE, CC.WHITE, ChatColor.WHITE, 0, "WHITE", TeamMaterial.WHITE),
    PINK(Color.FUCHSIA, CC.PINK, ChatColor.LIGHT_PURPLE, 6, "PINK", TeamMaterial.PINK),
    GRAY(Color.GRAY, CC.DARK_GRAY, ChatColor.DARK_GRAY, 7, "GREY", TeamMaterial.GRAY);

    public static TeamColour getById(int id) {
        for (TeamColour teamColor : TeamColour.values()) {
            if (teamColor.getColorId() == id) {
                return teamColor;
            }
        }

        return null;
    }

    Color color;
    String chatColor;
    ChatColor chatColorExplicit;
    int colorId;
    String name;
    TeamMaterial teamMaterials;
}
