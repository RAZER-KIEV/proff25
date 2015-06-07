package hw3.asyncchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by IEvgen Boldyr on 06.06.15.
 * Project: proff25
 */

public class ClientAsyncChat {

    static SocketChannel chanel;

    public static void main(String[] args) throws IOException {
        chanel = SocketChannel.open(new InetSocketAddress("localhost", 30000));
        ByteBuffer buffer = ByteBuffer.allocate(128);
        Scanner scanner = new Scanner(System.in);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ByteBuffer buffer = ByteBuffer.allocate(128);
                while (true) {
                    inputMessage(buffer);
                }
            }
        });
        thread.start();

        String message;
        while (true) {
            message = scanner.nextLine();
            sendMessage(message, buffer);
        }
    }

    private static void sendMessage(String message, ByteBuffer buffer) throws IOException {
        buffer.put(message.getBytes());
        while (buffer.hasRemaining()) {
            buffer.flip();
            chanel.write(buffer);
        }
        buffer.clear();
    }

    private static void inputMessage(ByteBuffer buffer) {
        try {
            int bytesRead;
            while ((bytesRead = chanel.read(buffer)) > 0) {
                buffer.flip();
                System.out.print("Client : ");
                System.out.println(new String(buffer.array(), 0, bytesRead));
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
