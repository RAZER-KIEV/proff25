package hw3.chat;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
/*
*
 * Created by viktoria
 * Project:.hw3.chat
 */

public class Server {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.run();
    }

    private void run()  {
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.socket().bind(new InetSocketAddress(30000));

            SocketChannel ss = channel.accept();
            System.out.println("Client connected from "+ ss.getLocalAddress());

            while (true) {
                InputStreamReader inputStream = new InputStreamReader(ss.socket().getInputStream());
                BufferedReader reader = new BufferedReader(inputStream);

                String message = reader.readLine();
                System.out.println(message);

                if (message != null) {
                    PrintStream print = new PrintStream(ss.socket().getOutputStream());
                    print.println("Message received");
                }
            }
        }
        catch(Exception except){
            except.printStackTrace();
        }




        }
    }
