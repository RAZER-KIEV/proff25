package session6.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by oleg on 02.06.15.
 */
public class toServer {
    public static void main(String[] args) throws IOException {

        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30003));
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
        int readed;
        while ((readed = channel.read(buffer)) > 0) {
            String line = new String(buffer.array(), 0, readed);
            System.out.print(line);
            buffer.clear();
        }
    }
}
