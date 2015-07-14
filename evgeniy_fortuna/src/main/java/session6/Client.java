package session6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by jul on 02.06.2015.
 */
public class Client {
    public static void main(String[] args) throws IOException{
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",30000));

        ByteBuffer buf = ByteBuffer.allocate(100);
//        buf.clear();

        buf.put("Run, Forrest, run!".getBytes());
        buf.flip();

        while (buf.hasRemaining()){
            socketChannel.write(buf);
        }
        buf.rewind();

        int bytesRead;
        while ((bytesRead = socketChannel.read(buf)) > 0){
            System.out.println(new String(buf.array(), 0, bytesRead));
        }
    }
}
