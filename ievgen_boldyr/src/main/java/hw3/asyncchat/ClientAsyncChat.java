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

    public static void main(String[] args) throws IOException {
        SocketChannel chanel = SocketChannel.open(new InetSocketAddress("localhost", 30000));
        ByteBuffer buffer = ByteBuffer.allocate(128);
        Scanner scanner = new Scanner(System.in);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ByteBuffer buffer = ByteBuffer.allocate(128);
                while (true) {
                    try {
                        int bytesRead;
                        while ((bytesRead = chanel.read(buffer)) > 0) {
                            System.out.print("Server : ");
                            System.out.println(new String(buffer.array(), 0, bytesRead));
                        }
                        buffer.clear();
                        buffer.rewind();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

        String message;
        while (true) {
            message = scanner.nextLine();
            buffer.put(message.getBytes());
            buffer.flip();
            while (buffer.hasRemaining()) {
                chanel.write(buffer);
            }
            buffer.clear();
        }
    }
}
