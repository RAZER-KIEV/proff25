package session6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by bosyi on 02.06.15.
 */
public class SocketEx {
    public static void main(String[] args) {
        System.out.println("Client");
        Scanner scanner = new Scanner(System.in);
        SocketChannel channel = null;
        try {
            channel = SocketChannel.open(
                    new InetSocketAddress("127.0.0.1", 30000)
            );
            ByteBuffer buffer = ByteBuffer.allocate(128);
            while (true) {
                System.out.print("Enter text: ");
                buffer.put(scanner.nextLine().getBytes());
                buffer.flip();
                while (buffer.hasRemaining()) {
                    channel.write(buffer);
                }
                buffer.clear();
                int readed;
                readed = channel.read(buffer); // для сокет ченела не коректно орієнтуватися на 0. треба читати від нього осбливе повідомлення.
                String line = new String(buffer.array(), 0, readed);
                System.out.print(line);
                if (line.equals("end")) {
                    channel.close();
                }
                buffer.clear();
                System.out.println();

            }



        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
