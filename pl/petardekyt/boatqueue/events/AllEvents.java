package pl.petardekyt.boatqueue.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.petardekyt.boatqueue.functions.FunctionsManager;
import pl.petardekyt.boatqueue.general.StorageManager;
import pl.petardekyt.boatqueue.queue.QueueManager;

import java.util.Random;

public class AllEvents implements Listener {

    // OBJECTS //
    QueueManager queueManager = new QueueManager();
    FunctionsManager fm = new FunctionsManager();

    @EventHandler
    public void join(PlayerJoinEvent e) {

        if (!fm.queueIsEnabled()) {
            e.getPlayer().kickPlayer(fm.mQueueIsNotEnabled());
            return;
        }

        e.getPlayer().teleport(generateLocation(e.getPlayer().getWorld()));

        e.setJoinMessage("");
        queueManager.join(e.getPlayer());
    }

    @EventHandler
    public void quit(PlayerQuitEvent e) {
        e.setQuitMessage("");
        queueManager.quit(e.getPlayer());
    }

    @EventHandler
    public void chat(AsyncPlayerChatEvent e) {
        e.setCancelled(true);
        if (!fm.canChat()) {
            return;
        }
        Bukkit.broadcastMessage("§7" + e.getPlayer().getName() + " §f: " + e.getMessage());
    }

    @EventHandler
    public void command(PlayerCommandPreprocessEvent e) {
        if (!fm.canCommands()) {
            e.setCancelled(true);
            return;
        }
    }

    Location generateLocation(World world) {

        Random random = new Random();

        int x = random.nextInt(10000);
        int z = random.nextInt(10000);
        int y = 150;

        return new Location(world, x, y, z);
    }

}
