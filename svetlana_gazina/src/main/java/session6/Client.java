package session6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Sveta on 6/2/2015.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30000));

        ByteBuffer buffer = ByteBuffer.allocate(50);
        buffer.put("I'm so crazy!".getBytes());

        buffer.flip();
        while (buffer.hasRemaining()) {
            socketChannel.write(buffer);
        }
        buffer.rewind();

        int bytesRead;
        bytesRead = socketChannel.read(buffer);
            System.out.println(new String(buffer.array(),0,bytesRead));


    }
}
