package dev.oflords.lordutils;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class LordUtils extends JavaPlugin {

    private static LordUtils lordUtils;

    @Override
    public void onEnable() {
        lordUtils = this;
    }

    public static LordUtils get() {
        return lordUtils;
    }
}
