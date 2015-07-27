package hw3.chat;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by viktoria
 * Project:.hw3.chat
 */
public class Client implements Runnable {
    private SocketChannel socket;

    public static void main(String[] args) throws IOException {

        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30000));
        Client client = new Client(channel);
        Thread thread = new Thread((Runnable) client);
        thread.run();
    }

    public Client(SocketChannel s) {
        this.socket = s;
    }

    public void run() {
        try {
/*            PrintStream printStream = new PrintStream(channel.socket().getOutputStream());
            printStream.println("Hello to Server from client");*/

            Scanner in = new Scanner(socket.socket().getInputStream());
            PrintWriter out = new PrintWriter(socket.socket().getOutputStream());

            while (true){
                if (in.hasNext()){
                    String input = in.nextLine();
                    System.out.println("Client: " + input);
                    out.println("You: "+ input);
                    out.flush();
                }
            }
/*            InputStreamReader inputStream = new InputStreamReader(channel.socket().getInputStream());
            BufferedReader reader = new BufferedReader(inputStream);

            String msg = reader.readLine();
            System.out.println(msg);*/
        } catch (Exception exept) {
            exept.printStackTrace();
        }
    }
}

