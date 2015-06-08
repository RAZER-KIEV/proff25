package homework3;

/**
 * Created by jax on 06.06.15.
 */
public class Chat {
    public static void main(String[] args) {
        ServerSocket serverSocket = new ServerSocket();
        Thread server = new Thread(serverSocket);
        server.start();
    }
}
