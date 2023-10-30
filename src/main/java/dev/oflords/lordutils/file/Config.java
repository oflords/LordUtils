package dev.oflords.lordutils.file;

import lombok.Getter;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {
    @Getter
    private File file;
    @Getter private YamlConfiguration config;

    public Config(File file) {
        this.file = file;
        this.config = YamlConfiguration.loadConfiguration(file);
    }
}
