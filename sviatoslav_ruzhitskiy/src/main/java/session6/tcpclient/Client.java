package session6.tcpclient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by RAZER on 02.06.2015.
 */
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel channel = SocketChannel.open( new InetSocketAddress("127.0.0.1", 30013));
        ByteBuffer buf = ByteBuffer.allocate(3000);

        for(int i =0; i<1000000;i++);{
        buf.put("Hello amigo, 12345 this is client".getBytes());

        buf.hasRemaining();
        buf.flip();
        channel.write(buf);
        buf.flip();
        channel.read(buf);

        System.out.println(buf);
        Thread.sleep(3000);
        }

    }

}
