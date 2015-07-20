package hw3.chat;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientThread extends Thread{
    private InputStream is;

    public ClientThread(Socket s){
        try{
            is = s.getInputStream();
        }catch(IOException ex){
            System.out.println(ex);
        }
    }

    public void run(){
        try{
            while(!isInterrupted()){
                Message msg = Message.readFromStream(is);
                if (msg == null)
                    Thread.yield();
                else
                    System.out.println(msg.toString());
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

}
