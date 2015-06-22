package hw3.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


class ServerClass implements Runnable {
    AsyncChat asyncChat = new AsyncChat();

    String strServer;

    @Override
    public void run(){
        try{
            ServerSocketChannel sch = ServerSocketChannel.open();
            sch.socket().bind(new InetSocketAddress(asyncChat.getPort()));
            SocketChannel client = sch.accept();
            ByteBuffer bf = ByteBuffer.allocate(100);
            while(true){
                bf.clear();
                if(client.read(bf)>0){
                    setStrServer(new String(bf.array(), 0, client.read(bf)));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setStrServer(String strServer) {
        this.strServer = strServer;
    }

    public String getStrServer() {
        return strServer;
    }

}

