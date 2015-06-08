package hw3.chat;

        import javafx.application.Application;
        import javafx.scene.Cursor;
        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.input.KeyCode;
        import javafx.scene.paint.Color;
        import javafx.stage.Stage;
        import javafx.scene.Group;
        import java.io.IOException;
        import java.net.InetSocketAddress;
        import java.nio.ByteBuffer;
        import java.nio.channels.ServerSocketChannel;
        import java.nio.channels.SocketChannel;

/**Написать чат, в котором можно отправлять и принимать сообщения в любом порядке.
 public void process()

 Класс задания hw3.chat.AsyncChat
 Класс теста hw3.chat.AsyncChatTest
 * Created by rrudych on 03.06.15.
 */
public class AsyncChat extends Application {

    private TextArea textArea;
    private SocketChannel channelToServer;
    private Label status;
    private ByteBuffer buf;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chat");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.BEIGE);

        Label ip = new Label("Connect to IP");
        ip.setLayoutX(90);
        ip.setLayoutY(10);

        Label port = new Label("Port");
        port.setLayoutX(280);
        port.setLayoutY(10);

        status = new Label("Status: FAIL");
        status.setLayoutX(400);
        status.setLayoutY(10);

        TextField textIp = new TextField();
        textIp.setLayoutX(20);
        textIp.setLayoutY(27);
        textIp.setPrefSize(200, 15);
        textIp.setCursor(Cursor.TEXT);
        textIp.setTooltip(new Tooltip("Type IP adress"));
        textIp.setPromptText("127.0.0.0");
        textIp.setEditable(true);
        textIp.setText("localhost");

        TextField textPort = new TextField();
        textPort.setLayoutX(250);
        textPort.setLayoutY(27);
        textPort.setPrefSize(80, 15);
        textPort.setCursor(Cursor.TEXT);
        textPort.setTooltip(new Tooltip("Type port"));
        textPort.setPromptText("1024 - 65535");
        textPort.setEditable(true);
        textPort.setText("30001");

        Button connectBtn = new Button("Connect");
        connectBtn.setLayoutX(380);
        connectBtn.setLayoutY(27);
        connectBtn.setMinSize(100,15);

        textArea = new TextArea();
        textArea.setLayoutX(20);
        textArea.setLayoutY(60);
        textArea.setPrefSize(460, 390);

        TextField enterText = new TextField();
        enterText.setLayoutX(20);
        enterText.setLayoutY(465);
        enterText.setPrefSize(370, 20);

        Button sendBtn = new Button("Send");
        sendBtn.setLayoutX(410);
        sendBtn.setLayoutY(465);
        sendBtn.setMinSize(70, 20);

        root.getChildren().addAll(ip, port, textIp,
                textPort, connectBtn, textArea, enterText,
                sendBtn, status);
        primaryStage.setScene(scene);
        primaryStage.show();

        class ServerThread extends Thread {
            public void run() {
                try {
                    StringBuilder sb = new StringBuilder();
                    ServerSocketChannel channel = ServerSocketChannel.open();
                    channel.socket().bind(new InetSocketAddress(30000));
                    ByteBuffer buffer = ByteBuffer.allocate(30);
                    while (true) {
                        SocketChannel sChannel = channel.accept();
                        int read = 0;
                        while (buffer.hasRemaining()) {
                            read = sChannel.read(buffer);
                            sb.append(sChannel.getRemoteAddress() + " " + new String(buffer.array(), 0, read) + "\n");
                            textArea.setText(sb.toString());
                            buffer.clear();
                        }
                    }
                } catch (Exception except) {
                    except.printStackTrace();
                }
            }
        }
        ServerThread th = new ServerThread();
        th.start();

        connectBtn.setOnAction(event -> {
            try {
                channelToServer = SocketChannel.open(new InetSocketAddress(textIp.getText(), Integer.parseInt(textPort.getText())));
                buf = ByteBuffer.allocate(250);
                if(channelToServer.isConnected()) {
                    status.setText("Status: OK");
                }
            } catch (IOException ex) {
                status.setText("Status: FAIL");
                ex.printStackTrace();
            }
        });

        sendBtn.setOnAction(event -> {
            try {
                buf.put(enterText.getText().getBytes());
                buf.flip();
                channelToServer.write(buf);
                enterText.clear();
                buf.clear();
            } catch (IOException ex) {
                status.setText("Status: FAIL");
                ex.printStackTrace();
            }
        });

        enterText.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    ByteBuffer buf = ByteBuffer.allocate(100);
                    buf.put(enterText.getText().getBytes());
                    buf.flip();
                    channelToServer.write(buf);
                    enterText.clear();
                    buf.clear();
                } catch (IOException ex) {
                    status.setText("Status: FAIL");
                    ex.printStackTrace();
                }
            }
        });

    }
}

class AsyncChatTest{


}
