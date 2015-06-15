package session6;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.util.Scanner;

/**
 * Created by Inna on 02.06.2015.
 */
public class Chat {
    public static void main(String[] args) throws IOException {

//        ServerSocketChannel schannel = ServerSocketChannel.open();
//        schannel.socket().bind(new InetSocketAddress(30000));
//        schannel.accept();
//        ByteBuffer buf = ByteBuffer.allocate(100);
//        //buf.clear();
//
//        Scanner scan = new Scanner(System.in);
//        String str = scan.nextLine();
//        buf.put(str.getBytes());
//
//        buf.flip();
//
//        while (buf.hasRemaining()) {
//            channel.write(buf);
//        }
//
//        buf.rewind();
//
//        int bytesRead;
//        while ((bytesRead = channel.read(buf)) > 0) {
//            System.out.println(new String(buf.array(), 0, bytesRead));
//
//
//        }
 }
}
