package session6.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by viktoria
 * Project:.session6.chat
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.socket().bind(new InetSocketAddress(30000));

        ByteBuffer buf = ByteBuffer.allocate(100);
        buf.rewind();

//        while (buf.array().toString()){
//            SocketChannel ss = channel.accept();
//
//

//        }


    }
}
