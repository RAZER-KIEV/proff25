package hw3.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by jax on 06.06.15.
 */
public class AsyncChat {
    public static void main(String[] args) {
        try{
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(30000));
            ByteBuffer buffer =ByteBuffer.allocate(3000);

            while (true){
                SocketChannel socketChannel = serverSocketChannel.accept();
                int bytesRead;
                while ((bytesRead = socketChannel.read(buffer)) > 0) {
                    buffer.flip();
                    System.out.println(new String(buffer.array(), 0, bytesRead));
                    buffer.clear();
                }
                Scanner scanner = new Scanner(System.in);
                String scan = scanner.nextLine();
                buffer.put(scan.getBytes());

                while (buffer.hasRemaining()) {
                    buffer.flip();
                    socketChannel.write(buffer);
                    buffer.clear();
                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
class AsyncChatTest{

}

