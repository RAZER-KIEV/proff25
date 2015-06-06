package session6;

/**
 * Created by Sveta on 6/2/2015.
 */
public class PrinterTask {
    public static void main(String[] args) {
        Printer printer = new Printer();
        new ThreadPrint().start();
        new ThreadPrint().start();
    }



}

class Printer {
    public synchronized void print(String line) throws InterruptedException {
        System.out.print("[");
        Thread.sleep(1);
        System.out.print(line);
        Thread.sleep(1);
        System.out.println("]");

    }
}

class ThreadPrint extends Thread {
    private Printer printer;
    @Override
    public void run(){
        String line = Thread.currentThread().getName();
        try {
            for (int i = 0; i < 200 ; i++) {
                printer.print(line);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
