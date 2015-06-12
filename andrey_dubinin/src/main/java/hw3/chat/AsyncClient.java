package hw3.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by jax on 06.06.15.
 */
public class AsyncClient {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30000));
            ByteBuffer buffer = ByteBuffer.allocate(300);
            Scanner scanner = new Scanner(System.in);
                 while (true) {

                     String scan = scanner.nextLine();
                     buffer.put(scan.getBytes());

                     while (buffer.hasRemaining()) {
                         buffer.flip();
                         socketChannel.write(buffer);

                         buffer.clear();
                     }
                     int bytesRead;
                     while ((bytesRead = socketChannel.read(buffer)) > 0) {
                     System.out.println(new String(buffer.array(), 0, bytesRead));
                   }
                }

            }catch(IOException e){
                e.printStackTrace();
            }
    }
}
