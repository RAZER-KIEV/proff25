package hw3.chat;

public class AsyncChat {
    public void process(){
        //new Thread(new NewServer()).start();
    }

    public static void main(String[] args) {
        new Thread(new NewServer(30000)).start();
    }


}
