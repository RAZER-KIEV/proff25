package hw3.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by ivan on 18.07.15.
 */
public class ClientHandler extends Thread {

    private Socket socket;
    private int numOfConnection;
    private byte[] buffer;
    private InputStream inStream;
    private OutputStream outStream;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getNumOfConnection() {
        return numOfConnection;
    }

    public void setNumOfConnection(int numOfConnection) {
        this.numOfConnection = numOfConnection;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public InputStream getInStream() {
        return inStream;
    }

    public void setInStream(InputStream inStream) {
        this.inStream = inStream;
    }

    public OutputStream getOutStream() {
        return outStream;
    }

    public void setOutStream(OutputStream outStream) {
        this.outStream = outStream;
    }

    public ClientHandler(int numOfConnection, Socket socket) {
        buffer = new byte[64 * 1024];

        this.numOfConnection = numOfConnection;
        this.socket = socket;
        try {
            inStream = socket.getInputStream();
            outStream = socket.getOutputStream();
        } catch (IOException exp) {
            exp.printStackTrace();
        }

        setDaemon(true);
        setPriority(NORM_PRIORITY);
        start();
    }

    @Override
    public void run() {
        while(true) {
            try {
                int readed = inStream.read(buffer);
                if (readed > 0) {
                    System.out.println(new String(buffer, 0, readed));
                    buffer = new byte[64 * 1024];
                }
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }
    }

}

