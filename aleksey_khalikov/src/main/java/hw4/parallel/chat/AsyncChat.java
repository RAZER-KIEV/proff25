package hw4.parallel.chat;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by GFalcon on 06.06.15.
 */
public class AsyncChat extends Application {

    // ��������� ����
    TextField txtAddress = new TextField("127.0.0.1");
    TextField txtPort = new TextField("8189");
    TextArea txtHistory = new TextArea();
    TextField txtSendText = new TextField("����� ���������");

    // ��������� ����������� � ��������
    boolean connect = false;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("����������� ���");

        // ������� ������ � ������ ������, ������ ����� � ������ ����������
        Button btnConn = new Button("Connect");

        HBox hbox = new HBox(txtAddress, txtPort);
        BorderPane topPane = new BorderPane(hbox);
        topPane.setRight(btnConn);

        // ������ ������
        Button btnSend = new Button("Send");
        btnSend.setVisible(false);

        BorderPane bottomPane = new BorderPane(txtSendText,null,btnSend,null,null);


        txtHistory.setWrapText(true);
        txtHistory.setEditable(false);

        BorderPane mainPane = new BorderPane(txtHistory,topPane,null,bottomPane,null);

        Scene scene = new Scene(mainPane, 600, 400);
        stage.setScene(scene);
        stage.show();

        btnSend.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    sendMassege();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnConn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(!connect){
                    btnConn.setText("Disconnect");
                    btnSend.setVisible(true);
                } else {
                    btnConn.setText("Connect");
                    btnSend.setVisible(false);
                }
                connectToServer();

            }
        });
    }

    public void sendMassege() throws IOException {
        // ����� �������� ��������� �� ������

        //txtHistory.appendText(txtSendText.getText());
        //txtHistory.appendText("\n");

        SocketChannel channel = SocketChannel.open(new InetSocketAddress(txtAddress.getText().trim(), Integer.parseInt(txtPort.getText())));
        ByteBuffer buf = ByteBuffer.allocate(30);
        buf.put(txtSendText.getText().getBytes());
        buf.flip();
        while (buf.hasRemaining()){
            channel.write(buf);
        }
        txtSendText.clear();

    }
    public void connectToServer(){
        // ����� ��� ��������� ���������� � ��������
        if(!connect){
            txtHistory.clear();
            //txtHistory.appendText("����������� ����������� " + txtAddress.getText() + " : " + txtPort.getText() + "\n");
            int numThread = 1;
            try {
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.socket().bind(new InetSocketAddress(Integer.parseInt(txtPort.getText())));
                connect = true;
                while (true){
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    Runnable runnable = new ServerThread(socketChannel);
                    Thread serverThread = new Thread(runnable);
                    serverThread.start();
                    numThread++;
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        } else {
            txtHistory.appendText("���������� ���������");
            connect = false;
        }



    }

    public class ServerThread implements Runnable{
        // ����� ��������� ������ ���������� ������� � ��������
        private SocketChannel incoming;
        public ServerThread(SocketChannel name){
            this.incoming = name;
        }
        @Override
        public void run(){
            try {
                try {
                    ByteBuffer sbuf = ByteBuffer.allocate(30);
                    int bytesRead;
                    while ((bytesRead = incoming.read(sbuf)) > 0){
                        txtHistory.appendText(new String(sbuf.array()));
                    }
                } finally {
                    incoming.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }


    }
}
