package week3_lesson6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
   /* SocketChannel channel = SocketChannel.open(new InetSocketAddress("192.168.1.111", 30000));
    ByteBuffer buf = ByteBuffer.allocate(30);
    buf.put("Hello".getBytes());
    buf.flip();
  //  buf.hasRemaining();
    (while buf.hasRemaining())
      channel.write(buf);*/
   public static void main(String[] args) throws IOException {

   SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8189));
    ByteBuffer buf = ByteBuffer.allocate(1000);
    buf.put("Helloy amigo".getBytes());
    buf.flip();
    while (buf.hasRemaining())
       {channel.write(buf);}
       buf.flip();
       buf.clear();
       int bytesRead;
       bytesRead=channel.read(buf);
       String str = new String(buf.array(), 0, bytesRead); // System.out.println(buf.array());
       System.out.println(str);
   }
}