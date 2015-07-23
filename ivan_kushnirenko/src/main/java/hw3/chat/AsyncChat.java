package hw3.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

/**
 * Created by ivan on 22.07.15.
 */
public class AsyncChat {

    public void process(){

    }


}

class Serv {

    private ArrayList<ClientHandle> clients;
    private ServerSocketChannel serverSocketChannel;
    String gettedMessage = new String();

    public Serv(int port, String ipAddress) {

        clients = new ArrayList<ClientHandle>();

        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
        } catch (UnknownHostException exp) {
            System.out.println("ERROR: Unknown host.");
            exp.printStackTrace();
        } catch (IOException exp) {
            System.out.println("ERROR: Cannot create server.");
            exp.printStackTrace();
        }
        System.out.println("Serv is created.");
    }

    public String getGettedMessage() {
        return gettedMessage;
    }

    public void setGettedMessage(String gettedMessage) {
        this.gettedMessage = gettedMessage;
    }

    public ArrayList<ClientHandle> getClients() {
        return clients;
    }

    public void setClients(ArrayList<ClientHandle> clients) {
        this.clients = clients;
    }

    public ServerSocketChannel getServerSocketChannel() {
        return serverSocketChannel;
    }

    public void setServerSocketChannel(ServerSocketChannel serverSocketChannel) {
        this.serverSocketChannel = serverSocketChannel;
    }

    public void getConnections() {
        Thread connector = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        synchronized (clients) {
                            clients.add(new ClientHandle(i, serverSocketChannel.accept(), Serv.this));
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

    public void sendMessage(String message) {
        ArrayList<ClientHandle> clients = this.clients;
        for (ClientHandle clh : clients) {
            clh.sendMessage(message);
        }
    }

    public static void main(String[] args) {
        Serv serv = new Serv(30000, "localhost");
        serv.getConnections();

        chatClient client1 = new chatClient("John");
        client1.connectToServer("localhost", 30000);

        chatClient client2 = new chatClient("Michael");
        client2.connectToServer("localhost", 30000);

        chatClient client3 = new chatClient("Pedro");
        client3.connectToServer("localhost", 30000);

        client1.sendMessage("Message from from client1.");

    }
}

class ClientHandle extends Thread {

    private SocketChannel socketChannel;
    private int numOfConnection;
    private ByteBuffer inputBuffer;
    private ByteBuffer outputBuffer;
    private Serv server;

    public Serv getServer() {
        return server;
    }

    public void setServer(Serv server) {
        this.server = server;
    }

    public SocketChannel getSocketChannel() {
        return socketChannel;
    }

    public void setSocketChannel(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    public int getNumOfConnection() {
        return numOfConnection;
    }

    public void setNumOfConnection(int numOfConnection) {
        this.numOfConnection = numOfConnection;
    }

    public ByteBuffer getInputBuffer() {
        return inputBuffer;
    }

    public void setInputBuffer(ByteBuffer buffer) {
        this.inputBuffer = buffer;
    }

    public ByteBuffer getOutputBuffer() {
        return outputBuffer;
    }

    public void setOutputBuffer(ByteBuffer outputBuffer) {
        this.outputBuffer = outputBuffer;
    }

    public ClientHandle(int numOfConnection, SocketChannel socketChannel, Serv server) {
        inputBuffer = ByteBuffer.allocate(64);
        outputBuffer = ByteBuffer.allocate(64);

        this.server = server;
        this.numOfConnection = numOfConnection;
        this.socketChannel = socketChannel;

        setDaemon(true);
        setPriority(NORM_PRIORITY);
        start();
    }

    public void sendMessage(String message) {
        try {
            outputBuffer.put(message.getBytes());
            outputBuffer.flip();
            socketChannel.write(outputBuffer);
        } catch (IOException exp) {
            System.out.println("ERROR: Cannot send message.");
            exp.printStackTrace();
        } finally {
            outputBuffer.clear();
        }
    }

    @Override
    public void run() {
        int readed;
        while (true) {
            try {
                if ((readed = socketChannel.read(inputBuffer)) > 0) {
                    synchronized (server.gettedMessage) {
                        server.gettedMessage = new String(inputBuffer.array(), 0, readed);
                        System.out.println("Getted message: " + server.gettedMessage);
                        server.sendMessage(server.gettedMessage);
                        server.gettedMessage = new String();
                    }
                }
            } catch (IOException exp) {
                exp.printStackTrace();
            } finally {
                inputBuffer.clear();
            }
        }
    }
}

class chatClient extends Thread {

    private SocketChannel socketChannel;
    private ByteBuffer inputBuffer;
    private ByteBuffer outputBuffer;
    String clientName;

    public SocketChannel getSocketChannel() {
        return socketChannel;
    }

    public void setSocketChannel(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    public ByteBuffer getInputBuffer() {
        return inputBuffer;
    }

    public void setInputBuffer(ByteBuffer inputBuffer) {
        this.inputBuffer = inputBuffer;
    }

    public ByteBuffer getOutputBuffer() {
        return outputBuffer;
    }

    public void setOutputBuffer(ByteBuffer outputBuffer) {
        this.outputBuffer = outputBuffer;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String name) {
        this.clientName = name;
    }

    chatClient(String clientName) {
        inputBuffer = ByteBuffer.allocate(64);
        outputBuffer = ByteBuffer.allocate(64);

        this.clientName = clientName;
        System.out.println("chatClient " + clientName + " was created.");
    }

    public void connectToServer(String ipAddress, int port) {
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress(ipAddress, port));
        } catch (UnknownHostException exp) {
            System.out.println("ERROR: Unknown server: " + ipAddress + ":" + port + ".");
            exp.printStackTrace();
        } catch (IOException exp) {
            System.out.println("ERROR: Cannot connect to server.");
            exp.printStackTrace();
        }
        System.out.println("Connected successfully.");
        this.start();
    }

    public void sendMessage(String message) {
        if (message == null || message.equals("")) {
            System.out.println("ERROR: Message cannot be empty.");
            return;
        }
        try {
            outputBuffer.put(message.getBytes());
            outputBuffer.flip();
            if (outputBuffer.hasRemaining()) {
                socketChannel.write(outputBuffer);
            }
        } catch (IOException exp) {
            System.out.println("ERROR: Cannot send message.");
            exp.printStackTrace();
        } finally {
            outputBuffer.clear();
        }
    }

    @Override
    public void run() {
        int readed;
        while (true) {
            try {
                if ((readed = socketChannel.read(inputBuffer)) > 0) {
                    String gettedMessage = new String(inputBuffer.array(), 0, readed);
                    System.out.println("chatClient "+clientName+" has received message: " + gettedMessage);
                    inputBuffer.clear();
                }
            } catch (IOException exp) {
                System.out.println("ERROR: Cannot read message.");
                exp.printStackTrace();
            } finally {
                inputBuffer.clear();
            }
        }
    }
}

class AsyncChatTest {

}