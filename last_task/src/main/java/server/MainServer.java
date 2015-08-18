package server;

import fileFinder.FileFinder;
import request.RequestParst;
import request.exceptions.BadRequestException;
import responseMaker.ResponseMaker;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/*
 * Examples:
 * http://localhost:8085/F:/asd.html
 * http://localhost:8085/C:/Users/storo_000/Documents/asd.html
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
            startServer(8085);
        }).start();
    }

    public static void startServer(int port) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            SocketChannel socketChannel;
            String result;
            String filePath;
            String file;
            RequestParst requestParst = new RequestParst();
            //FileFindService fileFindService = new FileFindService();
            FileFinder fileFinder = new FileFinder();
            ResponseMaker maker = new ResponseMaker();
            socketChannel = serverSocketChannel.accept();
            ByteBuffer buffer = ByteBuffer.allocate(1280000);
            ByteBuffer requestBuffer = ByteBuffer.allocate(1280000);
            int bytesRead;
            bytesRead = socketChannel.read(buffer);
            if (bytesRead != -1) {
                String str = new String(buffer.array(), 0, bytesRead);
                System.out.println(str);
                try {
                    filePath = requestParst.requestParst(str).substring(1);
                    System.out.println(filePath);
                    //file = fileFindService.findFile(filePath);
                    fileFinder.setPathToSearch(filePath);
                    file = fileFinder.findFile();
                    System.out.println(file);
                    maker.setRequest(file);
                } catch (BadRequestException e) {
                    maker.setRequest("404");
                } finally {
                    result = maker.send();
                    byte[] req1 = result.getBytes();
                    System.out.println(req1.length);
                    requestBuffer.put(req1);
                    requestBuffer.flip();
                    while (requestBuffer.hasRemaining()) {
                        socketChannel.write(requestBuffer);
                    }
                    socketChannel.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
