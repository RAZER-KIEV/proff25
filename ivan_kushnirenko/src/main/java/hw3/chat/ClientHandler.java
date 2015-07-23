package hw3.chat;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by ivan on 18.07.15.
 */
public class ClientHandler extends Thread {

    private SocketChannel socketChannel;
    private int numOfConnection;
    private ByteBuffer inputBuffer;
    private ByteBuffer outputBuffer;
    private Server server;

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
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

    public ClientHandler(int numOfConnection, SocketChannel socketChannel, Server server) {
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

