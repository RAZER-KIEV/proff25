package session6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by just1ce on 02.06.2015.
 */
public class Net {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 55555));
        ByteBuffer buffer=ByteBuffer.allocate(3000);
        ByteBuffer buf = ByteBuffer.allocate(48);

        //int bytesRead = channel.read(buf);
        String tmp;
        Scanner scanner =new Scanner(System.in);
        buffer.clear();
        buffer.put("hi".getBytes());
        buffer.flip();
        channel.write(buffer);
        while(true) {

                buf.clear();
                channel.read(buf);
                buf.flip();
                System.out.println(new String(buf.array()));

            tmp = scanner.nextLine();
            buffer.clear();
            buffer.put(tmp.getBytes());
            buffer.flip();
            channel.write(buffer);

        }
    }
}
