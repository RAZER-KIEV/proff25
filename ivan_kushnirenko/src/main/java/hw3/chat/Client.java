package hw3.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;

/**
 * Created by ivan on 18.07.15.
 */
public class Client {

    Socket socket;
    InputStream inStream;
    OutputStream outStream;

    public void connectToServer(String ipAddress, int port) {
        try {
            socket = new Socket(ipAddress, port);
            inStream = socket.getInputStream();
            outStream = socket.getOutputStream();
        } catch (UnknownHostException exp) {
            System.out.println("ERROR: Unknown server: " + ipAddress + ":" + port + ".");
            exp.printStackTrace();
        } catch (IOException exp) {
            System.out.println("ERROR: Cannot connect to server.");
            exp.printStackTrace();
        }
        System.out.println("Connected successfully.");
    }

    public void sendMessage(String message) {
        if (message == null) {
            System.out.println("ERROR: Message cannot be empty.");
            return;
        }
        try {
            outStream.write(message.getBytes());
        } catch (IOException exp){
            System.out.println("ERROR: Cannot send message.");
            exp.printStackTrace();
        }
    }
}
