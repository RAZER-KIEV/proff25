package hw3.chat;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Написать чат, в котором можно отправлять и принимать сообщения в любом порядке.
 public void process()... i
 Класс задания hw3.chat.AsyncChat
 */
public class AsyncChat extends Application {

    private TextArea textArea;
    private SocketChannel channel;
    private ByteBuffer bufOut = ByteBuffer.allocate(100);
    private ByteBuffer bufInp = ByteBuffer.allocate(100);



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 400);


        Button btn = new Button();

        Button btnClose = new Button();
        btn.setText("Send");
        btnClose.setText("Close");
        btn.setPrefSize(80, 35);
        btnClose.setPrefSize(80, 35);
        btn.setLayoutX(510);
        btn.setLayoutY(310);
        btnClose.setLayoutX(510);
        btnClose.setLayoutY(355);
        root.getChildren().add(btn);
        root.getChildren().add(btnClose);

        Label lb = new Label("Its CHAT baby!!!");
        root.getChildren().add(lb);

        TextField sendTextField = new TextField();
        sendTextField.setPrefSize(450, 30);
        sendTextField.setLayoutX(10);
        sendTextField.setLayoutY(350);
        root.getChildren().add(sendTextField);

        textArea = new TextArea();
        textArea.setPrefSize(450, 310);
        textArea.setLayoutX(10);
        textArea.setLayoutY(30);
        root.getChildren().add(textArea);

        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                bufOut.put(sendTextField.getText().getBytes());
                bufOut.flip();
                while (bufOut.hasRemaining()) {
                    try {
                        channel.write(bufOut);
                        sendTextField.clear();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        btnClose.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });


        sendTextField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    ByteBuffer buf = ByteBuffer.allocate(100);
                    buf.put(sendTextField.getText().getBytes());
                    buf.flip();
                    channel.write(buf);
                    sendTextField.clear();
                    buf.clear();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });




        stage.setTitle("Client Window");
        stage.setScene(scene);
        stage.show();


        channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30000));


        class ServerThread extends Thread {
            public void run() {
                try {
                    StringBuilder sb = new StringBuilder();
                    ServerSocketChannel channel = ServerSocketChannel.open();
                    channel.socket().bind(new InetSocketAddress(30005));
                    ByteBuffer bufInp = ByteBuffer.allocate(100);
                    while (true) {
                        SocketChannel socketChannelS = channel.accept();

                            int bytesRead;
                            while ((bytesRead = socketChannelS.read(bufInp)) > 0) {
                                sb.append(socketChannelS.getRemoteAddress() + " " + new String(bufInp.array(), 0, bytesRead) + "\n");
                                sendTextField.setText(sb.toString());
                                bufInp.clear();
                            }
                    }
                } catch (Exception except) {
                    except.printStackTrace();
                }
            }
        }
        new ServerThread().start();

        class ReceiverThread extends Thread {
            private ByteBuffer bufInp;
            private SocketChannel channel;

            public ReceiverThread(ByteBuffer bufInp, SocketChannel channel) {
                this.bufInp = bufInp;
                this.channel = channel;
            }

            @Override
            public void run() {
                try {
                    int bytesRead;
                    while ((bytesRead = channel.read(bufInp)) > 0) {
                        System.out.println(new String(bufInp.array(), 0, bytesRead));
                        bufInp.flip();
                        bufInp.clear();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
            new ReceiverThread(bufInp, channel).start();


        }
    public void process() {}

}

class AsyncChatTest{
}
