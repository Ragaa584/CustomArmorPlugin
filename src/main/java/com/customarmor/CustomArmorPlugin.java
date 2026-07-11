package com.customarmor;

import com.customarmor.commands.CustomArmorCommand;
import com.customarmor.manager.ArmorManager;
import com.customarmor.manager.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomArmorPlugin extends JavaPlugin {

    private static CustomArmorPlugin instance;
    private ArmorManager armorManager;
    private ConfigManager configManager;

    @Override
    public void onEnable() {
        instance = this;
        
        // Initialize managers
        configManager = new ConfigManager(this);
        configManager.loadConfig();
        
        armorManager = new ArmorManager(this);
        armorManager.loadArmors();
        
        // Register commands
        getCommand("customarmor").setExecutor(new CustomArmorCommand(this));
        
        getLogger().info("CustomArmorPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomArmorPlugin has been disabled!");
    }

    public static CustomArmorPlugin getInstance() {
        return instance;
    }

    public ArmorManager getArmorManager() {
        return armorManager;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}
