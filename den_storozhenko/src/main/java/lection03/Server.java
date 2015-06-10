package lection03;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


public class Server{
    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(30000));
        ByteBuffer buffer = ByteBuffer.allocate(100);
        //while (true) {
            SocketChannel ss = channel.accept();
            int bytesRead;
            while ((bytesRead = ss.read(buffer)) > 0) {
                System.out.println(new String(buffer.array(), 0, bytesRead));
            }
            buffer.clear();

            buffer.put("Hello from server".getBytes());
            buffer.flip();
            ss.write(buffer);

            buffer.clear();
        //}
    }
}