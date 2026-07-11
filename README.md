# CustomArmorPlugin

A powerful Minecraft plugin for adding custom 3D armor to your server. This plugin allows you to easily create and manage custom armor pieces with unique models, textures, and properties.

## Features

- **Custom Armor Creation**: Create unlimited custom armor pieces with unique properties
- **3D Model Support**: Load and apply custom 3D models to armor pieces
- **Texture Support**: Custom textures for each armor piece
- **Easy Configuration**: Simple YAML-based configuration
- **Command System**: Intuitive commands for managing armor
- **Glowing Effects**: Add enchantment glow effects to armor
- **Custom Protection Values**: Set specific protection levels for each armor
- **Hot Reload**: Reload configuration without restarting the server

## Requirements

- Minecraft Server (Spigot/Paper) 1.20.1 or higher
- Java 17 or higher
- Maven (for building from source)

## Installation

1. Download the latest `CustomArmorPlugin.jar`
2. Place it in your server's `plugins` folder
3. Restart your server
4. The plugin will create necessary configuration files automatically

## Usage

### Commands

- `/customarmor give <armor_id> [player]` - Give custom armor to a player
- `/customarmor list` - List all available custom armors
- `/customarmor reload` - Reload the plugin configuration

### Permissions

- `customarmor.use` - Use basic commands
- `customarmor.admin` - Admin commands (give, reload)

## Creating Custom Armor

### Step 1: Create Armor Config

Create a new YAML file in `plugins/CustomArmorPlugin/armors/` with your armor ID:

```yaml
# example_armor.yml
name: "&6&lLegendary Chestplate"
material: DIAMOND_CHESTPLATE
protection: 15
glowing: true
model: "models/example_armor.json"
texture: "textures/example_armor.png"
```

### Step 2: Add 3D Model (Optional)

Place your JSON model file in `plugins/CustomArmorPlugin/models/`:

```json
{
  "parent": "minecraft:item/generated",
  "textures": {
    "layer0": "customarmor:textures/example_armor"
  }
}
```

### Step 3: Add Texture (Optional)

Place your PNG texture file in `plugins/CustomArmorPlugin/textures/`

### Step 4: Reload

Use `/customarmor reload` to load your new armor

### Step 5: Give Armor

Use `/customarmor give example_armor` to get your custom armor

## Configuration Options

### Armor Config Fields

- `name`: Display name (supports color codes with &)
- `material`: Base material (e.g., DIAMOND_CHESTPLATE, IRON_HELMET)
- `protection: Protection enchantment level (1-255)
- `glowing`: Whether the item has an enchantment glow effect
- `model`: Path to the 3D model JSON file (optional)
- `texture`: Path to the texture PNG file (optional)

### Supported Materials

- All vanilla armor materials:
  - LEATHER_*, CHAINMAIL_*, IRON_*, GOLD_*, DIAMOND_*, NETHERITE_*

## Example Armors

### Basic Armor
```yaml
name: "&cSimple Chestplate"
material: IRON_CHESTPLATE
protection: 5
glowing: false
```

### Advanced Armor with 3D Model
```yaml
name: "&5&lMystic Chestplate"
material: DIAMOND_CHESTPLATE
protection: 20
glowing: true
model: "models/mystic_chestplate.json"
texture: "textures/mystic_chestplate.png"
```

## Building from Source

1. Clone the repository
2. Run `mvn clean package`
3. Find the JAR file in `target/CustomArmorPlugin-1.0.0.jar`

## Troubleshooting

### Armor not loading
- Check the console for error messages
- Verify YAML syntax is correct
- Ensure material name is valid

### Model not displaying
- Verify model JSON syntax
- Check texture file path
- Ensure files are in correct directories

### Commands not working
- Check you have the required permissions
- Verify the plugin is enabled
- Check console for errors

## Support

For issues and feature requests, please contact the plugin developer.

## License

This plugin is provided as-is for personal and commercial use.
