package dev.oflords.lordutils.player.team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;

@AllArgsConstructor
@Getter
public enum TeamMaterial {

    RED(Material.RED_TERRACOTTA, Material.RED_WOOL, Material.RED_CONCRETE),
    BLUE(Material.BLUE_TERRACOTTA, Material.BLUE_WOOL, Material.BLUE_CONCRETE),
    GREEN(Material.LIME_TERRACOTTA, Material.LIME_WOOL, Material.LIME_CONCRETE),
    YELLOW(Material.YELLOW_TERRACOTTA, Material.YELLOW_WOOL, Material.YELLOW_CONCRETE),
    AQUA(Material.CYAN_TERRACOTTA, Material.CYAN_WOOL, Material.CYAN_CONCRETE),
    WHITE(Material.WHITE_TERRACOTTA, Material.WHITE_WOOL, Material.WHITE_CONCRETE),
    PINK(Material.PINK_TERRACOTTA, Material.PINK_WOOL, Material.PINK_CONCRETE),
    GRAY(Material.GRAY_TERRACOTTA, Material.GRAY_WOOL, Material.GRAY_CONCRETE);

    final Material stainedClay;
    final Material wool;
    final Material concrete;

}
