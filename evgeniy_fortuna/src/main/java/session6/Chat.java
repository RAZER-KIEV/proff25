package session6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by jul on 02.06.2015.
 */
public class Chat {
    public static void main(String[] args) throws IOException{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(30000));

//        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
//            handleRequest(socketChannel);
//        }
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        socketChannel.read(byteBuffer);
        byteBuffer.clear();
        byteBuffer.put("Hi".getBytes());
        socketChannel.write(byteBuffer);
        }
    }



