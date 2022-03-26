package pl.petardekyt.boatqueue.internet;

import pl.petardekyt.boatqueue.functions.FunctionsManager;
import pl.petardekyt.boatqueue.queue.QueueManager;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class PingManager {

    public void sendPing() {
        new QueueManager().setResponding(getResult());
    }

    public boolean getResult() {
        String address = new FunctionsManager().getFallbackServerAddress();
        int port = Integer.parseInt(address.split(":")[1]);
        String ip = address.split(":")[0];
        SocketAddress server = new InetSocketAddress(ip, port);
        Socket socket = new Socket();
        try {socket.connect(server, 100); return true;}catch (java.io.IOException IOException){return false;}
    }

}
