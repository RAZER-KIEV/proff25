package homework3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by jax on 06.06.15.
 */
public class ServerSocket  implements Runnable{

    @Override
    public void run() {
        try{
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(30000));
            ByteBuffer buffer =ByteBuffer.allocate(3000);
            while (true){
                SocketChannel socketChannel = serverSocketChannel.accept();
                Scanner scanner = new Scanner(socketChannel);
                StringBuilder sb =new StringBuilder();
                while (scanner.hasNextLine()){
                    sb.append(scanner.nextLine());
                }
                System.out.println(sb.toString());
                buffer.put("Wellcom to hell!!!".getBytes());
                buffer.flip();
                while (buffer.hasRemaining()) {
                    socketChannel.write(buffer);
                }
                buffer.clear();

            }
    }catch (IOException e){
            e.printStackTrace();
        }
    }
}


