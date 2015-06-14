package hw3.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client{

    public Client(String ip, int port) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress(ip, port));
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        Scanner scanner = new Scanner(System.in);
        //Random random = new Random();
        String text;
        //while (!(text = String.valueOf(random.nextInt(20))).equals("0")) {
        while (!(text = scanner.nextLine()).equals("exit")) {
            //System.out.println(text);
            buffer.put(text.getBytes());
            buffer.flip();
            while (buffer.hasRemaining())
                channel.write(buffer);
            buffer.clear();
            //Thread.sleep(1000);
        }
        channel.close();
    }

    public static void main(String[] args) {
        try {
            new Client("localhost", 30000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 30000));
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        Scanner scanner = new Scanner(System.in);
        //Random random = new Random();

        String text;
        //while (!(text = String.valueOf(random.nextInt(20))).equals("0")) {
        while (!(text = scanner.nextLine()).equals("exit")) {
            //System.out.println(text);
            buffer.put(text.getBytes());
            buffer.flip();
            while (buffer.hasRemaining())
                channel.write(buffer);
            buffer.clear();
            //Thread.sleep(1000);
        }
        channel.close();
    }*/
}