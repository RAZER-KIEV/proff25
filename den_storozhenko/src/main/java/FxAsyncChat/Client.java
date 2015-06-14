package FxAsyncChat;


import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;


public class Client{
    private TextField messageText;
    private SocketChannel channel;


    public Client(String ip, int port, TextField messageText) throws IOException {
        channel = SocketChannel.open(new InetSocketAddress(ip, port));
        this.messageText = messageText;
    }

    public void send() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        String text;
        if (!(text = messageText.getText()).equals("exit")) {
            buffer.put(text.getBytes());
            buffer.flip();
            while (buffer.hasRemaining())
                channel.write(buffer);
            buffer.clear();
        }
        else
            channel.close();
    }

    public boolean isAvaible(){
        return channel.isConnected();
    }
}