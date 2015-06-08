package session6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by bosyi on 02.06.15.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server");
        Scanner scanner = new Scanner(System.in);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(30000));
        SocketChannel socketChannel = serverSocketChannel.accept();

        ByteBuffer buffer = ByteBuffer.allocate(128);
        while (true) {
            buffer.clear();
            int readed;
            readed = socketChannel.read(buffer); // для сокет ченела не коректно орієнтуватися на 0. треба читати від нього осбливе повідомлення.
            String line = new String(buffer.array()/*, 0, readed*/);
            System.out.print(line);
            buffer.clear();
            System.out.println();
            System.out.print("Enter text: ");
            buffer.put(scanner.nextLine().getBytes());
            buffer.flip();
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
//            buffer.clear();



        }


    }

}
