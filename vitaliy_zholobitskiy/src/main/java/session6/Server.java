package session6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by just1ce on 02.06.2015.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.socket().bind(new InetSocketAddress(55555));
        ByteBuffer buf = ByteBuffer.allocate(50);
        ByteBuffer buffer=ByteBuffer.allocate(3000);
        Scanner scanner =new Scanner(System.in);
        String tmp;
        while (true){
            SocketChannel socketChannel =
                    channel.accept();
            if(socketChannel != null) {
                while(socketChannel.isConnected()) {
                    buf.clear();
                    socketChannel.read(buf);
                    buf.flip();

                    System.out.println(new String(buf.array()));

                    buffer.clear();
                    tmp = scanner.nextLine();
                    buffer.put(tmp.getBytes());
                    buffer.flip();
                    socketChannel.write(buffer);
                }
            }
        }
    }
}
