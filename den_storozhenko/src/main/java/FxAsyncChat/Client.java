package FxAsyncChat;


import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client{
    private TextField messageText;
    private SocketChannel channel;


    public Client(String ip, int port, TextField messageText) throws IOException {
        channel = SocketChannel.open(new InetSocketAddress(ip, port));
        this.messageText = messageText;

    }

    public void send() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        //Scanner scanner = new Scanner(System.in);
        //Random random = new Random();
        String text;
        //while (!(text = String.valueOf(random.nextInt(20))).equals("0")) {
        if (!(text = messageText.getText()).equals("exit")) {
            //System.out.println(text);
            buffer.put(text.getBytes());
            buffer.flip();
            while (buffer.hasRemaining())
                channel.write(buffer);
            buffer.clear();
            //Thread.sleep(1000);
        }
        else
            channel.close();
    }

    public boolean isAvaible(){
        return channel.isConnected();
    }

    /*public static void main(String[] args) {
        try {
            new Client("localhost", 30000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

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