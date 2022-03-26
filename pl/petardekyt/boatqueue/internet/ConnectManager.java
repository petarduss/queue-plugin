package pl.petardekyt.boatqueue.internet;

import org.bukkit.entity.Player;
import pl.petardekyt.boatqueue.QueueManager;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConnectManager {

    public void connect(Player player, String server) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        player.sendPluginMessage(QueueManager.pl, "BungeeCord", b.toByteArray());
    }

}
