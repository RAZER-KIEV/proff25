package hw3.SocketChat;

/**
 * Created by ivan on 18.07.15.
 */

import java.net.Socket;

class SampleClient extends Thread {
    public static void main(String args[]) {
        try {
            // открываем сокет и коннектимся к localhost:3128
            // получаем сокет сервера
            Socket s = new Socket("localhost", 3128);

            // берём поток вывода и выводим туда первый аргумент
            // заданный при вызове, адрес открытого сокета и его порт
            args[0] = args[0] + "\n" + s.getInetAddress().getHostAddress()
                    + ":" + s.getLocalPort();
            s.getOutputStream().write(args[0].getBytes());

            // читаем ответ
            byte buf[] = new byte[64 * 1024];
            int r = s.getInputStream().read(buf);
            String data = new String(buf, 0, r);

            // выводим ответ в консоль
            System.out.println(data);
        } catch (Exception e) {
            System.out.println("init error: " + e);
        } // вывод исключений
    }
}

