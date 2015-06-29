package hw3.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client{

    public Client(String ip, int port) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress(ip, port));
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        Scanner scanner = new Scanner(System.in);

        String text;

        while (!(text = scanner.nextLine()).equals("exit")) {

            buffer.put(text.getBytes());
            buffer.flip();
            while (buffer.hasRemaining())
                channel.write(buffer);
            buffer.clear();

        }
        channel.close();
    }

    public static void main(String[] args) {
        try {
            new Client("localhost", 30000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}