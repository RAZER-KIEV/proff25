package session6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by viktoria
 * Project:.session6
 */
public class Server {

    public static void main(String[] args) throws IOException {
    SocketChannel channel = SocketChannel.open(new InetSocketAddress("192.168.1.111", 30000));

        ByteBuffer buf = ByteBuffer.allocate(30);
        buf.put("Всем привет! :)".getBytes());
        buf.flip();
        while (buf.hasRemaining()) {
            channel.write(buf);
        }
//        System.out.println(channel.read(buf));
    }
}
