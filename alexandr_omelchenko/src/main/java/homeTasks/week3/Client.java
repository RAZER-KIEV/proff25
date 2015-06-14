package homeTasks.week3;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8189));
        ByteBuffer bufer = ByteBuffer.allocate(200); //буфер для отправки

        int readed=0;
        while(true) {
//КЛИЕНТ ПИШЕТ
            bufer.put("Alloxa friend!".getBytes());
            bufer.flip();
            while (bufer.hasRemaining()) {
                channel.write(bufer);
                System.out.println("send Alloxa friend!");
            }
           // bufer.flip();
            bufer.clear();
//КЛИЕНТ ЧИТАЕТ
            readed = channel.read(bufer);
            String mess = new String(bufer.array(), 0, readed);
            System.out.println("Get "+ mess);
          //  bufer.flip();
            bufer.clear();
        }
    }
}