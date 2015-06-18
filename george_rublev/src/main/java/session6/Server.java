package session6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by george on 02.06.15.
 */
public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1",30000));
        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();

            handleQuestion hq = new handleQuestion(socketChannel);
            hanndleRequest(socketChannel);
        }

    }

    static class handleQuestion extends Thread {
        SocketChannel socket = null;
        handleQuestion(SocketChannel socket){
            this.socket = socket;
        }

        @Override
        public void run(){
            try {
                ByteBuffer byteOut = ByteBuffer.allocate(30);
                socket = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30000));
                byteOut.flip();
                byteOut.put("Hello".getBytes());
                socket.write(byteOut);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static void hanndleRequest(SocketChannel socketChannel) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(30);
        try {
            int bytesRead = socketChannel.read(byteBuffer);
            System.out.println(byteBuffer.toString());
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;


    }
}
