package com.customarmor.model;

import com.customarmor.CustomArmorPlugin;
import org.bukkit.entity.Player;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ModelLoader {

    private final CustomArmorPlugin plugin;
    private final Map<String, JSONObject> loadedModels;

    public ModelLoader(CustomArmorPlugin plugin) {
        this.plugin = plugin;
        this.loadedModels = new HashMap<>();
    }

    public JSONObject loadModel(String modelPath) {
        if (loadedModels.containsKey(modelPath)) {
            return loadedModels.get(modelPath);
        }

        File modelFile = new File(plugin.getDataFolder(), modelPath);
        if (!modelFile.exists()) {
            plugin.getLogger().warning("Model file not found: " + modelPath);
            return null;
        }

        try {
            FileInputStream fis = new FileInputStream(modelFile);
            JSONTokener tokener = new JSONTokener(fis);
            JSONObject model = new JSONObject(tokener);
            fis.close();

            loadedModels.put(modelPath, model);
            plugin.getLogger().info("Loaded model: " + modelPath);
            return model;
        } catch (IOException e) {
            plugin.getLogger().severe("Failed to load model: " + modelPath);
            e.printStackTrace();
            return null;
        }
    }

    public void applyModelToPlayer(Player player, String modelPath) {
        JSONObject model = loadModel(modelPath);
        if (model == null) return;

        // This is a placeholder for actual model rendering
        // In a full implementation, this would use packets to send custom model data
        // For now, we'll use the CustomModelData NBT tag
        plugin.getLogger().info("Applying model " + modelPath + " to player " + player.getName());
    }

    public Map<String, JSONObject> getLoadedModels() {
        return new HashMap<>(loadedModels);
    }
}
