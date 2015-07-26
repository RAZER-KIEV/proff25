package session6.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by viktoria
 * Project:.session6.chat
 */
public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30000));

        ByteBuffer buf = ByteBuffer.allocate(100);
        buf.put("привет! :)".getBytes());
        buf.flip();
        while (buf.hasRemaining()) {
            channel.write(buf);
        }
        buf.rewind();

        int bytesRead;

        while ((bytesRead = channel.read(buf)) > 0) {
          System.out.println(new String(buf.array(),0, bytesRead));

        }

        System.out.println(buf.array().toString());

    }
}
