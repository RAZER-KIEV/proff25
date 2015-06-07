package session6.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by RAZER on 02.06.2015.
 */
public class ServerChat {
    public static void main(String[] args) throws IOException {


    ServerSocketChannel channel = ServerSocketChannel.open();
    channel.socket().bind(new InetSocketAddress(30013));
    SocketChannel ss = channel.accept();


    ByteBuffer bb = ByteBuffer.allocate(3000);
    bb.hasRemaining(); //пока тру - посторяем врайт.
    bb.flip();
    ss.read(bb);

        System.out.println(bb);
        bb.put("Hello 321214 server ansver".getBytes());

   // channel.close();
    }
}
