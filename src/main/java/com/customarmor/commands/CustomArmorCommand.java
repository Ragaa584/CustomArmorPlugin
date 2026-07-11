package com.customarmor.commands;

import com.customarmor.CustomArmorPlugin;
import com.customarmor.armor.CustomArmor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CustomArmorCommand implements CommandExecutor {

    private final CustomArmorPlugin plugin;

    public CustomArmorCommand(CustomArmorPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sendHelp(sender);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "give":
                handleGiveCommand(sender, args);
                break;
            case "list":
                handleListCommand(sender);
                break;
            case "reload":
                handleReloadCommand(sender);
                break;
            default:
                sendHelp(sender);
        }

        return true;
    }

    private void handleGiveCommand(CommandSender sender, String[] args) {
        if (!sender.hasPermission("customarmor.admin")) {
            sender.sendMessage(org.bukkit.ChatColor.RED + "You don't have permission to use this command!");
            return;
        }

        if (args.length < 2) {
            sender.sendMessage(org.bukkit.ChatColor.RED + "Usage: /customarmor give <armor_id> [player]");
            return;
        }

        String armorId = args[1];
        CustomArmor armor = plugin.getArmorManager().getArmor(armorId);

        if (armor == null) {
            sender.sendMessage(org.bukkit.ChatColor.RED + "Armor not found: " + armorId);
            return;
        }

        Player target;
        if (args.length >= 3) {
            target = plugin.getServer().getPlayer(args[2]);
            if (target == null) {
                sender.sendMessage(org.bukkit.ChatColor.RED + "Player not found: " + args[2]);
                return;
            }
        } else {
            if (!(sender instanceof Player)) {
                sender.sendMessage(org.bukkit.ChatColor.RED + "You must specify a player when using this command from console!");
                return;
            }
            target = (Player) sender;
        }

        ItemStack item = plugin.getArmorManager().createArmorItem(armorId);
        if (item != null) {
            target.getInventory().addItem(item);
            target.sendMessage(org.bukkit.ChatColor.GREEN + "You received: " + org.bukkit.ChatColor.translateAlternateColorCodes('&', armor.getName()));
            sender.sendMessage(org.bukkit.ChatColor.GREEN + "Gave " + armor.getName() + " to " + target.getName());
        }
    }

    private void handleListCommand(CommandSender sender) {
        if (!sender.hasPermission("customarmor.use")) {
            sender.sendMessage(org.bukkit.ChatColor.RED + "You don't have permission to use this command!");
            return;
        }

        sender.sendMessage(org.bukkit.ChatColor.GOLD + "=== Custom Armors ===");
        for (String armorId : plugin.getArmorManager().getAllArmors().keySet()) {
            CustomArmor armor = plugin.getArmorManager().getArmor(armorId);
            sender.sendMessage(org.bukkit.ChatColor.YELLOW + "- " + armorId + ": " + 
                org.bukkit.ChatColor.translateAlternateColorCodes('&', armor.getName()));
        }
    }

    private void handleReloadCommand(CommandSender sender) {
        if (!sender.hasPermission("customarmor.admin")) {
            sender.sendMessage(org.bukkit.ChatColor.RED + "You don't have permission to use this command!");
            return;
        }

        plugin.getConfigManager().reloadConfig();
        plugin.getArmorManager().loadArmors();
        sender.sendMessage(org.bukkit.ChatColor.GREEN + "CustomArmor configuration reloaded!");
    }

    private void sendHelp(CommandSender sender) {
        sender.sendMessage(org.bukkit.ChatColor.GOLD + "=== CustomArmor Commands ===");
        sender.sendMessage(org.bukkit.ChatColor.YELLOW + "/customarmor give <armor_id> [player]" + org.bukkit.ChatColor.GRAY + " - Give custom armor");
        sender.sendMessage(org.bukkit.ChatColor.YELLOW + "/customarmor list" + org.bukkit.ChatColor.GRAY + " - List all custom armors");
        sender.sendMessage(org.bukkit.ChatColor.YELLOW + "/customarmor reload" + org.bukkit.ChatColor.GRAY + " - Reload configuration");
    }
}
