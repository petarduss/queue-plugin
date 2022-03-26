package pl.petardekyt.boatqueue;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import pl.petardekyt.boatqueue.events.AllEvents;
import pl.petardekyt.boatqueue.general.StorageManager;
import pl.petardekyt.boatqueue.storage.YamlConfig;
import pl.petardekyt.boatqueue.tasks.PlayerTask;
import pl.petardekyt.boatqueue.tasks.ServerTask;

public class QueueManager extends JavaPlugin implements Listener {

    /**
     * BoatQueue by PetardekYT (twojastrata_#5358)
     * for BoatMC
     */

    // OBJECTS //

    private static final YamlConfig config = new YamlConfig();
    private static final StorageManager sm = new StorageManager();
    public static Plugin pl = null;

    // QUEUE MANAGER //

    @Override
    public void onEnable() {
        // LOGIC ENABLE //
        pl = this;
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new AllEvents(), this);
        sm.setup();
        new PlayerTask().task(this);
        new ServerTask().task(this);
    }

    @Override
    public void onLoad() {
        // LOGIC LOAD //
    }

    @Override
    public void onDisable() {
        // LOGIC DISABLE //
    }

}
