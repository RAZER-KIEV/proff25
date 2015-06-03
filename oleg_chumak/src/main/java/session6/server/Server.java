package session6.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

import static java.nio.channels.ServerSocketChannel.*;

/**
 * Created by oleg on 02.06.15.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSock = ServerSocketChannel.open();
        serverSock.socket().bind(new InetSocketAddress(30003));
        while (true){
            SocketChannel socketChannel = serverSock.accept();
            handleReques(socketChannel);
            answerRequest(socketChannel);
        }
    }

    private static void handleReques(SocketChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        int readed;
        readed = channel.read(buffer);
            String line = new String(buffer.array(), 0, readed);
            System.out.print(line);
            System.out.println();
            buffer.clear();
    }

    private static void answerRequest(SocketChannel channel) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(100);
        System.out.println("Enter text");
        Scanner scan = new Scanner(System.in);
        String text = scan.next();
        buffer.put(text.getBytes());
        buffer.flip();
        while (buffer.hasRemaining()) {
            channel.write(buffer);
        }
        buffer.clear();
    }
}
