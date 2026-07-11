package com.customarmor.manager;

import com.customarmor.CustomArmorPlugin;
import com.customarmor.armor.CustomArmor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ArmorManager {

    private final CustomArmorPlugin plugin;
    private final Map<String, CustomArmor> armors;

    public ArmorManager(CustomArmorPlugin plugin) {
        this.plugin = plugin;
        this.armors = new HashMap<>();
    }

    public void loadArmors() {
        File armorsDir = new File(plugin.getDataFolder(), "armors");
        if (!armorsDir.exists()) {
            armorsDir.mkdirs();
            // Create example armor config
            createExampleArmor(armorsDir);
            return;
        }

        File[] armorFiles = armorsDir.listFiles((dir, name) -> name.endsWith(".yml"));
        if (armorFiles == null) return;

        for (File armorFile : armorFiles) {
            try {
                FileConfiguration config = YamlConfiguration.loadConfiguration(armorFile);
                String armorId = armorFile.getName().replace(".yml", "");
                
                CustomArmor armor = loadArmorFromConfig(armorId, config);
                if (armor != null) {
                    armors.put(armorId, armor);
                    plugin.getLogger().info("Loaded armor: " + armorId);
                }
            } catch (Exception e) {
                plugin.getLogger().warning("Failed to load armor: " + armorFile.getName());
                e.printStackTrace();
            }
        }
    }

    private CustomArmor loadArmorFromConfig(String id, FileConfiguration config) {
        String name = config.getString("name", "Custom Armor");
        String materialName = config.getString("material", "DIAMOND_CHESTPLATE");
        Material material;
        
        try {
            material = Material.valueOf(materialName.toUpperCase());
        } catch (IllegalArgumentException e) {
            material = Material.DIAMOND_CHESTPLATE;
        }

        int protection = config.getInt("protection", 10);
        boolean glowing = config.getBoolean("glowing", false);
        String modelPath = config.getString("model", null);
        String texturePath = config.getString("texture", null);

        return new CustomArmor(id, name, material, protection, glowing, modelPath, texturePath);
    }

    private void createExampleArmor(File armorsDir) {
        File exampleFile = new File(armorsDir, "example_armor.yml");
        try {
            if (!exampleFile.exists()) {
                exampleFile.createNewFile();
                FileConfiguration config = YamlConfiguration.loadConfiguration(exampleFile);
                
                config.set("name", "&6&lLegendary Chestplate");
                config.set("material", "DIAMOND_CHESTPLATE");
                config.set("protection", 15);
                config.set("glowing", true);
                config.set("model", "models/example_armor.json");
                config.set("texture", "textures/example_armor.png");
                
                config.save(exampleFile);
                plugin.getLogger().info("Created example armor config");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CustomArmor getArmor(String id) {
        return armors.get(id);
    }

    public Map<String, CustomArmor> getAllArmors() {
        return new HashMap<>(armors);
    }

    public ItemStack createArmorItem(String armorId) {
        CustomArmor armor = armors.get(armorId);
        if (armor == null) return null;
        
        return armor.createItemStack();
    }
}
