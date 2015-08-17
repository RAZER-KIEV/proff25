package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by bosyi on 17.08.15.
 */
public class MainServer {

    private static String request = "HTTP/1.1 200 OK\n\r" +
            "Server: nginx/1.2.1\n\r" +
            "Date: Sat, 08 Mar 2014 22:53:46 GMT\n\r" +
            "Content-Type: text/html\n\r" +
            "Content-Length: 7\n\r" +
            "Last-Modified: Sat, 08 Mar 2014 22:53:30 GMT\n\r" +
            "Connection: keep-alive\n\r" +
            "Accept-Ranges: bytes\n\r" +
            "\n\r" +
            "Wisdom";

    public static void main(String[] args) {
        new Thread(() -> {
            startServer(8080);
        }).start();
    }

    public static void startServer(int port) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            SocketChannel socketChannel;
            while (true) {
                System.out.println("q");
                socketChannel = serverSocketChannel.accept();
                ByteBuffer buffer = ByteBuffer.allocate(1280);
                ByteBuffer requestBuffer = ByteBuffer.allocate(1280000);
                int bytesRead;
                bytesRead = socketChannel.read(buffer);
                if (bytesRead != -1) {
                    String str = new String(buffer.array(), 0, bytesRead);
                    System.out.println(str);

                    byte[] req1 = request.getBytes();
                    System.out.println(req1.length);
                    requestBuffer.put(req1);
                    requestBuffer.flip();
                    try {
                        while (requestBuffer.hasRemaining()) {
                            socketChannel.write(requestBuffer);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    socketChannel.close();
                }



                /*while ((bytesRead = socketChannel.read(buffer)) > 0) {
                    String str = new String(buffer.array(), 0, bytesRead);
                    System.out.println(str);
                    buffer.clear();
                }*/
                System.out.println("111");
            }
            /*SocketChannel socketChannel = serverSocketChannel.accept();
            ByteBuffer buffer = ByteBuffer.allocate(128);
            ByteBuffer requestBuffer = ByteBuffer.allocate(1280000);*/


            /*int bytesRead;
            while ((bytesRead = socketChannel.read(buffer)) > 0) {
                String str = new String(buffer.array(), 0, bytesRead);
                System.out.println(str);
                buffer.clear();
                byte[] req1 = request.getBytes();
                System.out.println(req1.length);
                requestBuffer.put(req1);
                requestBuffer.flip();
                try {
                    while (requestBuffer.hasRemaining()) {
                        socketChannel.write(requestBuffer);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
