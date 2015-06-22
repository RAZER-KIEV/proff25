package hw3.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;


class ClientClass implements Runnable {
    AsyncChat asyncChat = new AsyncChat();
    @Override
    public void run(){

        try{
            AsynchronousSocketChannel chan = AsynchronousSocketChannel.open();
            chan.connect(new InetSocketAddress(asyncChat.getIp(), asyncChat.getPort()));
            ByteBuffer bf = ByteBuffer.allocate(100);
            while(true){
                bf.clear();
                bf.put(asyncChat.getMessage().getBytes());
                bf.flip();
                chan.write(bf);
                bf.clear();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

