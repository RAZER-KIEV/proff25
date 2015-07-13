package hw3.chat;




import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.rmi.UnknownHostException;

/**
 * Created by ivan on 04.07.15.
 */
public class Test {

    public static void main(String[] args) {
//        InetSocketAddress inteadress = new InetSocketAddress("127.0.0.1",30000);
//        try{
//            SocketChannel channel = SocketChannel.open(inteadress);
//            ByteBuffer buffer = ByteBuffer.allocate(32);
//            buffer.put("Hello".getBytes());
//            if(buffer.hasRemaining()){
//                channel.write(buffer);
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        try{
            Socket socket = new Socket("localhost",1234);
        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
