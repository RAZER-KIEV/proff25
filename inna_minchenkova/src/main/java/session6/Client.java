package session6;

import java.io.IOException;
import java.net.InetSocketAddress;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Inna on 02.06.2015.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("192.168.1.111", 30000));
        ByteBuffer buffer = ByteBuffer.allocate(30);
        buffer.put("Hello".getBytes());

        buffer.flip();

        while (buffer.hasRemaining()){
            channel.write(buffer);
        }

        buffer.rewind();

        //buffer.clear();
//        buffer.put("Hi!".getBytes());
//        channel.write(buffer);

    }
}
