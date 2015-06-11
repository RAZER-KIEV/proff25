package hw3.chat;

import lection03.NewServer;

/**
 * Created by storo_000 on 11.06.2015.
 */
public class AsyncChat {
    public void process(){
        new Thread(new NewServer()).start();
    }

    public static void main(String[] args) {
        new Thread(new NewServer()).start();
    }
}
