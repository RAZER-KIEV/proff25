package hw4.parallel.chat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 *
 * Написать чат, в котором можно отправлять и принимать сообщения в любом порядке.
 * public void process()
 *
 * Класс задания AsyncChat
 * Класс теста hw3.chat.AsyncChatTest
 *
 * Created by george on 03.06.15.
 */

class Face extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane pane = new BorderPane();
       final TextArea textIp = new TextArea();
        pane.setTop(textIp);
        Scene scene = new Scene(pane,600,400);
        primaryStage.setTitle("CHAT");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

public class AsyncChat {
    public static void main(String[] args) {
//        Face face =new Face();
        AsyncChat asyncChat = new AsyncChat();
        asyncChat.process();


    }

    public void process(){

        int i=1;
        try {
            ServerSocket serverSocket = new ServerSocket(30000);
            while (true){
                Socket incoming = serverSocket.accept();
                System.out.println("Spawning "+i);
                Runnable r = new Server(incoming);

                Thread t=new Thread(r);
                t.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    class Server implements Runnable{

        private Socket incoming;
        SocketAddress ip ;

        public Server(Socket incoming) {
            this.incoming=incoming;
        }

        @Override
        public void run() {
            Runnable rClient=new Client(incoming);
            try {
//                ip = incoming.getRemoteSocketAddress();
//                SocketAddress ipclient = ip;
//                System.out.println(ip);
//                Inet4Address ia = new Inet4Address();
                InputStream in = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();
                Scanner scanner = new Scanner(in);
                Scanner scannerClient = new Scanner(System.in);
                PrintWriter out = new PrintWriter(outputStream,true);
                while (true){
                    if(scanner.hasNextLine()==true){
                        System.out.println(scanner.nextLine());
                    }
                    if(scannerClient.hasNextLine()==true){
                        out.println(scannerClient.nextLine());
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class Client implements Runnable{

        private Socket incoming;

        public Client(Socket incoming) {
            this.incoming=incoming;
        }

        @Override
        public void run() {
            try {
                SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost",30000));
                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine();
                ByteBuffer byteBuffer = ByteBuffer.allocate(120);
                byteBuffer.flip();
                byteBuffer.put(line.getBytes());
                socketChannel.write(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    }

}

