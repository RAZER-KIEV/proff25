package hw3.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Connection{
    private final int port=5555;
    private OutputStream os;
    public Socket socket;
    private Message msg = null;

    public Connection(String IP) {
        try{
            socket = new Socket(IP,port);
            os = socket.getOutputStream();
            System.out.println(IP+" is connected. Type message.");
        } catch(IOException ex){
            System.out.println(ex);
        }
    }

    public void sendMessage(String to, String text){
        msg = new Message();
        msg.from=socket.getInetAddress().getHostName();
        msg.to=to;
        msg.text=text;
        try{
            msg.writeToStream(os);
        } catch(IOException ex){
            System.out.println(ex);
        }
    }

    public void run(){

    }

}

