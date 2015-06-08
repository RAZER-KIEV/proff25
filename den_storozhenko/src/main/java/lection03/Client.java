package lection03;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client{
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost",30000));
        ByteBuffer buffer = ByteBuffer.allocate(100);
        //while (true) {
            buffer.put("Hello from DENST".getBytes());
            buffer.flip();
            while (buffer.hasRemaining())
                channel.write(buffer);
            buffer.clear();

            int bytesRead;
            while ((bytesRead = channel.read(buffer)) > 0)
                System.out.println(new String(buffer.array(), 0, bytesRead));
            buffer.clear();
        //}
    }
}