package session06;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Написать синхронизированный чат на сокетах между сервером и клиентом. На одном компьютере. Между двумя классами.
 * На стороне сервера используется специальный канал ServerSocketChannel, которому передается только номер порта.
 * Этот порт прослушивается и ожидает соединения.
 * Например: ServerSocketChannel channel = ServerSocketChannel.open();
 * channel.socket().bind(new InetSocketAddress(30_000));
 * SocketChannel ss = channel.accept();
 *
 * Created by Jeckgehor on 02.06.2015.
 */
public class SynchChat {

    public static void main (String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(30_000));
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();

        }
    }


}
