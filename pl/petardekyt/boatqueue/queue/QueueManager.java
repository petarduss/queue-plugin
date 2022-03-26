package pl.petardekyt.boatqueue.queue;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QueueManager {

    private static ArrayList<Player> players_in_queue = new ArrayList<>();
    private static HashMap<String, Boolean> status = new HashMap<>();

    public void join(Player p) {
        players_in_queue.add(p);
    }

    public void quit(Player p) {
        players_in_queue.remove(p);
    }

    public List<Player> getPlayersInQueue() {
        return players_in_queue;
    }

    public int player_position(Player p) {
        return players_in_queue.indexOf(p);
    }

    public void setResponding(boolean responding) {
        status.put("status", responding);
    }

    public boolean getResponding() {
        return status.get("status");
    }

}
