package lection03;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost",30001));
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            buffer.put(scanner.nextLine().getBytes());
            buffer.flip();
            while (buffer.hasRemaining())
                channel.write(buffer);
            buffer.clear();
        }
    }
}