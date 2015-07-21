package hw3.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by ivan on 18.07.15.
 */
public class Client extends Thread {

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

    Client(String clientName) {
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
