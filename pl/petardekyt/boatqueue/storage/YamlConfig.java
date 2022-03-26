package pl.petardekyt.boatqueue.storage;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class YamlConfig {

    private static File file;
    private static FileConfiguration configs;

    public void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("BoatQueue").getDataFolder().getAbsolutePath() + "/Configs", "config.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }
        configs = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration get() {
        return configs;
    }

    public void save() {
        try {
            configs.save(file);
        } catch (IOException e) {
            System.out.println("Couldn't save file");
        }
    }

    public static void reload() {
        configs = YamlConfiguration.loadConfiguration(file);
    }

}
