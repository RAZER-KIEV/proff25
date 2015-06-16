package session06;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * * Created by Jeckgehor on 02.06.2015.
 */
public class InetRead {

    public static void main (String[] args) throws IOException {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("192.168.1.111", 30_000);
        SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);
        ByteBuffer buffer = ByteBuffer.allocate(200);
        buffer.put("Hello, server".getBytes());
        buffer.flip();
        while (buffer.hasRemaining()) {
            socketChannel.write(buffer);
        }
        buffer.rewind();
        int byteRead;
        while ((byteRead = socketChannel.read(buffer)) > 0) {
            System.out.println(new String(buffer.array(), 0, byteRead));
        }
    }
}
