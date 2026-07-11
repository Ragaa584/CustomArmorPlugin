package com.customarmor.manager;

import com.customarmor.CustomArmorPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private final CustomArmorPlugin plugin;
    private FileConfiguration config;
    private File configFile;

    public ConfigManager(CustomArmorPlugin plugin) {
        this.plugin = plugin;
    }

    public void loadConfig() {
        configFile = new File(plugin.getDataFolder(), "config.yml");
        
        if (!configFile.exists()) {
            plugin.saveResource("config.yml", false);
        }
        
        config = YamlConfiguration.loadConfiguration(configFile);
        
        // Create armors directory if it doesn't exist
        File armorsDir = new File(plugin.getDataFolder(), "armors");
        if (!armorsDir.exists()) {
            armorsDir.mkdirs();
        }
    }

    public void reloadConfig() {
        if (configFile == null) {
            configFile = new File(plugin.getDataFolder(), "config.yml");
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
