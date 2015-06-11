package lection03;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;





public class Server{
    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(30001));
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        SocketChannel ss;
        while (true) {
            ss = channel.accept();
            int bytesRead;
            while (buffer.hasRemaining()) {
                bytesRead = ss.read(buffer);
                System.out.println(new String(buffer.array(), 0, bytesRead));
                buffer.clear();
            }
        }
    }
}