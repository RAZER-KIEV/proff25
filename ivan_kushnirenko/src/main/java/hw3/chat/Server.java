package hw3.chat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by ivan on 18.07.15.
 */
public class Server {

    private ArrayList<ClientHandler> clients;
    private ServerSocket serverSocket;

    public Server(int port, String ipAddress) {

        clients = new ArrayList<ClientHandler>();

        try {
            serverSocket = new ServerSocket(port, 0, InetAddress.getByName(ipAddress));
        } catch (UnknownHostException exp) {
            System.out.println("ERROR: Unknown host.");
            exp.printStackTrace();
        } catch (IOException exp) {
            System.out.println("ERROR: Cannot create server.");
            exp.printStackTrace();
        }
        System.out.println("Server is created.");
    }

    public ArrayList<ClientHandler> getClients() {
        return clients;
    }

    public void setClients(ArrayList<ClientHandler> clients) {
        this.clients = clients;
    }

    public void getConnections() {
        Thread connector = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        synchronized (clients) {
                            clients.add(new ClientHandler(i, serverSocket.accept()));
                        }
                    } catch (IOException exp) {
                        System.out.println("ERROR: Cannot connect client.");
                        exp.printStackTrace();
                    }
                    i++;
                }
            }
        };
        connector.start();
    }

    public static void main(String[] args) {
        Server serv = new Server(30000, "localhost");
        serv.getConnections();
        Client client1 = new Client();
        client1.connectToServer("localhost", 30000);
        client1.sendMessage("Message from client1.");
        Client clent2 = new Client();
        clent2.connectToServer("localhost", 30000);
        clent2.sendMessage("Message from client2.");
        Client client3 = new Client();
        client3.connectToServer("localhost", 30000);
        client3.sendMessage("Message from client3.");
        client1.sendMessage("new Message - Client1.");

    }
}
