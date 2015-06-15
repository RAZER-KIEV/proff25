package week3_lesson6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8189));
        SocketChannel clientChannel = serverSocketChannel.accept();

        ByteBuffer buffer = ByteBuffer.allocate(1000);

            int bytesRead = clientChannel.read(buffer);
            String str = new String(buffer.array(), 0, bytesRead);
            System.out.println(str);
            buffer.flip();
            clientChannel.write(buffer);
            buffer.flip();
            buffer.clear();
               // while (true) {
      //     SocketChannel socketChannel = socketChannel.accept();
          // handleRequest(SocketChannel);
        }
    }