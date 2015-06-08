package hw3.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by oleg on 04.06.15.
 */


public class AsyncChat {
    public static void main(String[] args) {
//        212.90.61.116
        Thread innerThread = new Thread(new Handler());
        Thread outerThread = new Thread(new Maker());
        innerThread.start();
        outerThread.start();
    }

    private static class Maker implements Runnable{

        @Override
        public void run() {
            System.out.println("Enter IP");
            Scanner scan = new Scanner(System.in);
            String ipAddress = scan.next();
            System.out.println("Enter port");
            int port = scan.nextInt();
            try {
                SocketChannel outerChannel = SocketChannel.open(new InetSocketAddress(ipAddress, port));
                while(true){
                    make(outerChannel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void make(SocketChannel channel) throws IOException {
            System.out.println("Enter text");
            Scanner scan = new Scanner(System.in);
            String text = scan.next();
            ByteBuffer buffer = ByteBuffer.allocate(100);
            buffer.put(text.getBytes());
            buffer.flip();
            buffer.rewind();
            while(buffer.hasRemaining()) {
                channel.write(buffer);
            }
            buffer.clear();
        }
    }

    private static class Handler implements Runnable{

        @Override
        public void run() {
            try {
                ServerSocketChannel ssChannel = ServerSocketChannel.open();
                ssChannel.socket().bind(new InetSocketAddress(30001));
                SocketChannel inputChannel = ssChannel.accept();
                while(true){
                    handle(inputChannel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private void handle(SocketChannel channel) throws IOException {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            int readed;
            readed = channel.read(buffer);
            buffer.flip();
            buffer.rewind();
            String line = new String(buffer.array(), 0, readed);
            System.out.println(line);
            buffer.clear();
        }
    }
}