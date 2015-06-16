package homeTasks.week3;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

/**
 * Created by HP on 12.06.2015.
 */
public class Chat {
    public static void main(String[] args) {
        Server server= new Server();
        Client client = new Client();
        server.start();
        //client.start();
        }
  //  static ArrayList<String> messages = new ArrayList<>();

    public static class Server extends Thread {
        @Override
        public void run() {
            SocketChannel inChannel = null;
            try {
                ServerSocketChannel ssChannel = ServerSocketChannel.open();
                ssChannel.socket().bind(new InetSocketAddress(8189));
                inChannel = ssChannel.accept();}
            catch (IOException e) {
                e.printStackTrace();}

            ByteBuffer buffer = ByteBuffer.allocate(100);
            int readed = 0;
            while (true) {
//Сервер ЧИТАЕТ
                try {readed = inChannel.read(buffer);}
                catch (Exception e) {
                    e.printStackTrace();}
                String mess = new String(buffer.array(), 0, readed);
                //Chat.messages.add(mess);
                System.out.println("Get " + mess);
                buffer.flip();
                buffer.clear();
            }
        }
    }
    public static class Client extends Thread {
        @Override
        public void run() {
            SocketChannel channel = null;
            try {channel = SocketChannel.open(new InetSocketAddress("localhost", 30000));}
            catch (IOException e) {e.printStackTrace();}
            ByteBuffer bufer = ByteBuffer.allocate(100); //буфер для отправки

            while (true) {
//КЛИЕНТ ПИШЕТ
                bufer.put("Alloxa friend!".getBytes());
                bufer.flip();
                while (bufer.hasRemaining()) {
                    try {channel.write(bufer);} catch (IOException e) {e.printStackTrace();}
                    System.out.println("send Alloxa friend!");
                }
                // bufer.flip();
                bufer.clear();
            }
        }
    }
}