package session6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Sveta on 6/2/2015.
 */
public class Task {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("192.168.1.111",30000));
        ByteBuffer buffer = ByteBuffer.allocate(50);
        buffer.put("I'm so crazy!".getBytes());
        buffer.flip();
       while (buffer.hasRemaining()) {
           channel.write(buffer);
       }
        buffer.flip();
       System.out.println( channel.read(buffer));

    }
}
