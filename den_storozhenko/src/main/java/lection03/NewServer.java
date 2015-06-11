package lection03;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by storo_000 on 11.06.2015.
 */
public class NewServer implements Runnable {


    @Override
    public void run() {
        try {
            ServerSocketChannel channel= ServerSocketChannel.open();
            channel.bind(new InetSocketAddress(30001));
            SocketChannel ss = channel.accept();
            while (true){
                getText(ss);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getText(SocketChannel ss) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        int bytesRead;
        while (buffer.hasRemaining()) {
            bytesRead = ss.read(buffer);
            System.out.println(new String(buffer.array(), 0, bytesRead));
            buffer.clear();
        }
    }
}
