package hw3.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by just1ce on 07.06.2015.
 */
public class AsyncChat {
    public  AsyncChat(){}

    public void process() throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 55555));
        ByteBuffer buffer=ByteBuffer.allocate(3000);
        ByteBuffer buf = ByteBuffer.allocate(48);

        //int bytesRead = channel.read(buf);
        String tmp;
        Scanner scanner =new Scanner(System.in);


        while(true) {
            tmp = scanner.nextLine();
            buffer.clear();
            buffer.put(tmp.getBytes());
            buffer.flip();
            channel.write(buffer);

        }
    }

}
class AsyncChatTest{
    public AsyncChatTest(){}

}
