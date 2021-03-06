package hw3.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


public class NewServer implements Runnable {

    private final static int DEFAULT_PORT = 30000;
    private int port;

    public NewServer(int port){
        if (port<1024 || port>50000) {
            this.port = DEFAULT_PORT;
        } else {
            this.port = port;
        }
    }


    public class SocketThread extends  Thread{
        SocketChannel socketChannel;

        SocketThread(SocketChannel socketChannel){
            this.socketChannel = socketChannel;
        }

        @Override
        public void run(){
            try {
                getText(socketChannel);
            } catch (IOException e) {
                System.out.println("Connection is interrapted.");
            }
        }
    }

    @Override
    public void run() {
        try {
            ServerSocketChannel channel= ServerSocketChannel.open();
            channel.bind(new InetSocketAddress(port));
            SocketChannel ss;

            while (true){
                ss = channel.accept();
                new SocketThread(ss).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getText(SocketChannel ss) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        int bytesRead;
        while (ss.isConnected() && buffer.hasRemaining() && (bytesRead = ss.read(buffer))>0) {
            System.out.println(new String(buffer.array(), 0, bytesRead));
            buffer.clear();
        }
    }
}
