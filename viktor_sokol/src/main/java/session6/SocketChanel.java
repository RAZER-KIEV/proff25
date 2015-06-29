package session6;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;

/**
 * Created by Віктор on 6/2/2015.
 */
public class SocketChanel {
    public static void main(String[] args) {


    }

    public class Server1 {
        public void main(String[] ar) {
            int port = 6666; // случайный порт (может быть любое число от 1025 до 65535)
            try {
                ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
                System.out.println("Waiting for a client...");

                Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
                System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
                System.out.println();

                // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту.
                InputStream sin = socket.getInputStream();
                OutputStream sout = socket.getOutputStream();

                // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
                DataInputStream in = new DataInputStream(sin);
                DataOutputStream out = new DataOutputStream(sout);

                String line = null;
                while (true) {
                    line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
                    System.out.println("The dumb client just sent me this line : " + line);
                    System.out.println("I'm sending it back...");
                    out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
                    out.flush(); // заставляем поток закончить передачу данных.
                    System.out.println("Waiting for the next line...");
                    System.out.println();
                }
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }

    public class Client {
        public void main(String[] ar) {
            int serverPort = 6666; // здесь обязательно нужно указать порт к которому привязывается сервер.
            String address = "127.0.0.1"; // это IP-адрес компьютера, где исполняется наша серверная программа.
            // Здесь указан адрес того самого компьютера где будет исполняться и клиент.

            try {
                InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.
                System.out.println("Any of you heard of a socket with IP address " + address + " and port " + serverPort + "?");
                Socket socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
                System.out.println("Yes! I just got hold of the program.");

                // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом.
                InputStream sin = socket.getInputStream();
                OutputStream sout = socket.getOutputStream();

                // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
                DataInputStream in = new DataInputStream(sin);
                DataOutputStream out = new DataOutputStream(sout);

                // Создаем поток для чтения с клавиатуры.
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                String line = null;
                System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");
                System.out.println();

                while (true) {
                    line = keyboard.readLine(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
                    System.out.println("Sending this line to the server...");
                    out.writeUTF(line); // отсылаем введенную строку текста серверу.
                    out.flush(); // заставляем поток закончить передачу данных.
                    line = in.readUTF(); // ждем пока сервер отошлет строку текста.
                    System.out.println("The server was very polite. It sent me this : " + line);
                    System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
                    System.out.println();
                }
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }
}
