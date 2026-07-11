package com.customarmor.armor;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomArmor {

    private final String id;
    private final String name;
    private final Material material;
    private final int protection;
    private final boolean glowing;
    private final String modelPath;
    private final String texturePath;

    public CustomArmor(String id, String name, Material material, int protection, boolean glowing, String modelPath, String texturePath) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.protection = protection;
        this.glowing = glowing;
        this.modelPath = modelPath;
        this.texturePath = texturePath;
    }

    public ItemStack createItemStack() {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            // Set colored name
            meta.setDisplayName(org.bukkit.ChatColor.translateAlternateColorCodes('&', name));
            
            // Set custom lore
            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(org.bukkit.ChatColor.GRAY + "Custom Armor: " + org.bukkit.ChatColor.YELLOW + id);
            lore.add(org.bukkit.ChatColor.GRAY + "Protection: " + org.bukkit.ChatColor.GREEN + "+" + protection);
            if (modelPath != null) {
                lore.add(org.bukkit.ChatColor.GRAY + "3D Model: " + org.bukkit.ChatColor.AQUA + "Enabled");
            }
            meta.setLore(lore);

            // Add protection enchantment
            meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, protection, true);

            // Add glowing effect
            if (glowing) {
                meta.addEnchant(Enchantment.DURABILITY, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }

            // Hide attributes for cleaner look
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            
            item.setItemMeta(meta);
        }

        return item;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Material getMaterial() {
        return material;
    }

    public int getProtection() {
        return protection;
    }

    public boolean isGlowing() {
        return glowing;
    }

    public String getModelPath() {
        return modelPath;
    }

    public String getTexturePath() {
        return texturePath;
    }
}
