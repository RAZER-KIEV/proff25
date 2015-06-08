package session6.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by oleg on 02.06.15.
 */
public class toServer {
    public static void main(String[] args) throws IOException {

        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30003));
        ByteBuffer buffer = ByteBuffer.allocate(100);
        Thread handleThread = new Thread(new Maker(channel));
        Thread makerThread = new Thread(new Handler(channel));
        handleThread.start();
        makerThread.start();
    }

    private static class Maker implements Runnable{
        SocketChannel channel;

        public Maker(SocketChannel channel) {
            this.channel = channel;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    makeRequest(channel);
                }
            }catch(IOException e){
                    e.printStackTrace();
            }
        }
    }
    private static class Handler implements Runnable{
        SocketChannel channel;

        public Handler(SocketChannel channel) {
            this.channel = channel;
        }

        @Override
        public void run() {
            try {
                while(true) {
                    handleRequest(channel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

    private static void handleRequest(SocketChannel channel) throws IOException {
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
}