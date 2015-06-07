package session6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Sveta on 6/2/2015.
 */
public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(30000));
        SocketChannel socketChannel = serverSocketChannel.accept();
        ByteBuffer buffer = ByteBuffer.allocate(50);




            while(!(buffer.hasRemaining())) {
                serverSocketChannel.wait();
            }

            buffer.rewind();

            int bytesRead;
            bytesRead = socketChannel.read(buffer);
                System.out.println(new String(buffer.array(),0,bytesRead));



            buffer.clear();
            buffer.put("You are".getBytes());
            buffer.flip();
            while(buffer.hasRemaining()) {

                socketChannel.write(buffer);
            }



    }
}
