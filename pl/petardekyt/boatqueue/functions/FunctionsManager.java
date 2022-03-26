package pl.petardekyt.boatqueue.functions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import pl.petardekyt.boatqueue.general.StorageManager;

public class FunctionsManager {

    // OBJECTS //
    StorageManager sm = new StorageManager();

    public boolean canChat() {
        return sm.getValueBol("petardek.boatqueue.config.functions.enable_chat");
    }

    public boolean canCommands() {
        return sm.getValueBol("petardek.boatqueue.config.functions.enable_commands");
    }

    public boolean queueIsEnabled() {
        return sm.getValueBol("petardek.boatqueue.config.queue.enable_queue");
    }

    public int getPlayersPer() {
        return Integer.parseInt(sm.getValueStr("petardek.boatqueue.config.queue.players_per"));
    }

    public String getFallbackServer() {
        return sm.getValueStr("petardek.boatqueue.config.queue.fallback_server");
    }

    public boolean isEnabledPingFallback() {
        return sm.getValueBol("petardek.boatqueue.config.queue.enable_ping_fallback");
    }

    public String getFallbackServerAddress() {
        return sm.getValueStr("petardek.boatqueue.config.queue.fallback_address");
    }

    public String mQueueIsNotEnabled() {
        return ChatColor.translateAlternateColorCodes('&', sm.getValueStr("petardek.boatqueue.config.messages.queue_is_not_enabled"));
    }

    public String mQueuePosition(Player p, int position) {
        return ChatColor.translateAlternateColorCodes('&', sm.replaceVariables(
                sm.getValueStr("petardek.boatqueue.config.messages.queue_position"),
                p,
                position
        ));
    }

    public String mQueueServerIsNotResponding() {
        return ChatColor.translateAlternateColorCodes('&', sm.getValueStr("petardek.boatqueue.config.messages.fallback_server_is_down"));
    }

    public String mPlayerJoined(Player player) {
        return ChatColor.translateAlternateColorCodes('&', sm.replaceVariables(
                sm.getValueStr("petardek.boatqueue.config.messages.player_joined"),
                player,
                0
        ));
    }

}
