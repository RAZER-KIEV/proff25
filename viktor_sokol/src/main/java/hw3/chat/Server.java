package hw3.chat;

import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    private final int port=5555;


    public Server(){
        this.setDaemon(true);
        this.start();
    }

    public void run(){
        try{
            ServerSocket server = new ServerSocket(port);
            while(!isInterrupted()){
                Socket s = server.accept();
                ClientThread clthr = new ClientThread(s);
                clthr.setDaemon(true);
                clthr.start();
            }
            server.close();
        }catch (Exception ex) {
            System.out.println(ex);
        }
    }

}