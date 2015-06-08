package session6.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

import static java.nio.channels.ServerSocketChannel.*;

/**
 * Created by oleg on 02.06.15.
// */
public class Server {
    public static void main(String[] args) throws IOException {
        Thread handleThread = new Thread(new Handler());
        Thread makerThread = new Thread(new Maker());
        handleThread.start();
        makerThread.start();
    }

    private static class Maker implements Runnable{
        @Override
        public void run() {

            try {
                System.out.println("enter port");
                Scanner scanner = new Scanner(System.in);
                int port = scanner.nextInt();
                SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", port));
                while (true) {
                    makeRequest(channel);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    private static class Handler implements Runnable{
        @Override
        public void run() {

            try {
                ServerSocketChannel serverSock = ServerSocketChannel.open();
                serverSock.socket().bind(new InetSocketAddress(30004));
                SocketChannel socketChannel = serverSock.accept();
                while(true) {
                    handleReques(socketChannel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void handleReques(SocketChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        int readed;
        readed = channel.read(buffer);
        buffer.flip();
        buffer.rewind();
        String line = new String(buffer.array(), 0, readed);
        System.out.print(line);
        System.out.println();
        buffer.clear();
    }

    private static void makeRequest(SocketChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        System.out.println("Enter text");
        Scanner scan = new Scanner(System.in);
        String text = scan.next();
        buffer.put(text.getBytes());
        buffer.flip();
        buffer.rewind();
        while (buffer.hasRemaining()) {
            channel.write(buffer);
        }
        buffer.clear();
    }
}
