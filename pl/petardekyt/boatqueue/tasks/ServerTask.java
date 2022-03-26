package pl.petardekyt.boatqueue.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import pl.petardekyt.boatqueue.functions.FunctionsManager;
import pl.petardekyt.boatqueue.internet.ConnectManager;
import pl.petardekyt.boatqueue.internet.PingManager;
import pl.petardekyt.boatqueue.queue.QueueManager;

public class ServerTask {

    FunctionsManager fm = new FunctionsManager();
    QueueManager qm = new QueueManager();

    public void task(Plugin p) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(p, new Runnable() {
            @Override
            public void run() {

                if (fm.isEnabledPingFallback()) {
                    new PingManager().sendPing();
                }

                for (World w : Bukkit.getWorlds()) {
                    w.setThundering(false);
                    w.setPVP(false);
                    w.setStorm(false);
                    w.setTime(1200);
                    w.setDifficulty(Difficulty.PEACEFUL);
                }

                int counter = 0;

                for (Player p : qm.getPlayersInQueue()) {

                    counter++;
                    if (fm.isEnabledPingFallback()) {
                        if (!qm.getResponding()) {
                            continue;
                        }
                    }
                    if (!(counter > fm.getPlayersPer())) {
                        new ConnectManager().connect(p, fm.getFallbackServer());
                        Bukkit.broadcastMessage(fm.mPlayerJoined(p));
                    }

                }

            }
        }, 0, 20 * 3);
    }

}
