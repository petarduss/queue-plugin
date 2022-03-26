package pl.petardekyt.boatqueue.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import pl.petardekyt.boatqueue.events.AllEvents;
import pl.petardekyt.boatqueue.functions.FunctionsManager;
import pl.petardekyt.boatqueue.queue.QueueManager;

import java.util.Random;

public class PlayerTask {

    QueueManager qm = new QueueManager();
    FunctionsManager fm = new FunctionsManager();

    public void task(Plugin p) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(p, new Runnable() {
            @Override
            public void run() {

                for (Player p : qm.getPlayersInQueue()) {

                    p.teleport(generateLocation(p.getWorld()));
                    p.setHealth(20);
                    p.setFoodLevel(20);
                    p.setLevel(qm.getPlayersInQueue().size());

                    if (fm.isEnabledPingFallback()) {
                        if (!qm.getResponding()) {
                            p.sendTitle("§eKolejka", fm.mQueueServerIsNotResponding(), 20, 20, 20);
                            continue;
                        }
                    }

                    p.sendTitle("§eKolejka", fm.mQueuePosition(p, qm.player_position(p)), 20, 20, 20);
                }

            }
        }, 20, 20);
    }

    Location generateLocation(World world) {

        Random random = new Random();

        int x = random.nextInt(10000);
        int z = random.nextInt(10000);
        int y = 150;

        return new Location(world, x, y, z);
    }

}
