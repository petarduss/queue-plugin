package pl.petardekyt.boatqueue.general;

import org.bukkit.entity.Player;
import pl.petardekyt.boatqueue.storage.YamlConfig;

public class StorageManager {

    // OBJECTS //

    YamlConfig config = new YamlConfig();

    // STORAGE //

    public String getValueStr(String key) {
        return config.get().getString(key);
    }

    public String replaceVariables(String str, Player p, int pos) {
        return str.replace("{pos}", String.valueOf(pos)).replace("{player}", p.getName());
    }

    public void setup() {
        config.setup();
        config.get().addDefault("petardek.boatqueue.config.functions.enable_commands", "false");
        config.get().addDefault("petardek.boatqueue.config.functions.enable_chat", "false");
        config.get().addDefault("petardek.boatqueue.config.queue.enable_queue", "true");
        config.get().addDefault("petardek.boatqueue.config.queue.players_per", "1");
        config.get().addDefault("petardek.boatqueue.config.queue.fallback_server", "hub");
        config.get().addDefault("petardek.boatqueue.config.queue.enable_ping_fallback", "true");
        config.get().addDefault("petardek.boatqueue.config.queue.fallback_address", "localhost:1337");
        config.get().addDefault("petardek.boatqueue.config.messages.queue_is_not_enabled", "&cKolejka jest wylaczona!");
        config.get().addDefault("petardek.boatqueue.config.messages.queue_position", "&eJestes #{pos} w kolejce!");
        config.get().addDefault("petardek.boatqueue.config.messages.fallback_server_is_down", "&cSerwer glowny nie odpowiada!");
        config.get().addDefault("petardek.boatqueue.config.messages.player_joined", "&a{player} juz dolaczyl na hub!");
        config.get().options().copyDefaults(true);
        config.save();
    }

    public boolean getValueBol(String key) {
        return config.get().getString(key) != null ? (config.get().getString(key).equalsIgnoreCase("true") ? true : false) : false;
    }

}
